package com.central.zepto.central_api.service;

import com.central.zepto.central_api.Util.DatabaseAPIUtil;
import com.central.zepto.central_api.exception.ProductNotPresentException;
import com.central.zepto.central_api.exception.UserNotFoundException;
import com.central.zepto.central_api.exception.WareHouseNotAvailableException;
import com.central.zepto.central_api.models.*;
import com.central.zepto.central_api.requestdto.RequestOrderProductDTO;
import com.central.zepto.central_api.responsedto.ResponseBillDTO;
import com.central.zepto.central_api.responsedto.ResponseBillProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    DatabaseAPIUtil databaseAPIUtil;

    @Autowired
    WareHouseService wareHouseService;


    public double getPriceAfterDiscount(int amount, int discount){
        double offAmount = amount*(discount/100);
        return amount - offAmount;
    }

    public ResponseBillDTO placeOrder(List<RequestOrderProductDTO> products,
                                      UUID userId){


        AppUser user = databaseAPIUtil.getUserByUserId(userId);
        if(user == null){
            throw new UserNotFoundException(String.format("User with id %s does not exists", userId.toString()));
        }

        int pincode = user.getPincode();

        WareHouse wareHouse = databaseAPIUtil.getWareHouseByPincode(pincode);

        if(wareHouse == null){
            throw new WareHouseNotAvailableException(String.format("We regret to inform you warehouse is not present at your pincode %d", pincode));
        }

        ResponseBillDTO bill = new ResponseBillDTO();
        List<ResponseBillProductDTO> billProducts = new ArrayList<>();
        AppOrder order = new AppOrder();
        List<Product> orderProducts = new ArrayList<>();
        double totalAmount = 0.0;
        // if warehouse present then we will see what ever the product user is ordering it is present in that warehouse or not
        for(RequestOrderProductDTO product: products){
            UUID pid = product.getPid();
            // we will check that this pid is presnt int warehouse or not
            WareHouseProducts wareHouseProduct = wareHouseService.getProductByWidPid(wareHouse.getId(), pid);
            if(wareHouseProduct.getTotalQuantity() < product.getQuantity()){
                throw new ProductNotPresentException(String.format(
                        "Product with pid %s does not have enough quantity", pid.toString()
                ));
            }
           Product oP = wareHouseService.getProductById(pid);
           orderProducts.add(oP);
           ResponseBillProductDTO billProductDTO = new ResponseBillProductDTO();
           billProductDTO.setProductId(pid);
           billProductDTO.setQuantity(product.getQuantity());
           double priceAfterDiscount = this.getPriceAfterDiscount(oP.getProductPrice(), wareHouseProduct.getDiscount());
           billProductDTO.setAmount(product.getQuantity()*priceAfterDiscount);
           billProductDTO.setProductName(oP.getProductName());
           billProducts.add(billProductDTO);
           totalAmount += priceAfterDiscount;
        }

        order.setCustomer(user);
        order.setPlacedTime(LocalDateTime.now());
        order.setProducts(orderProducts);
        order.setTotalAmount(totalAmount);

        // Save this order in database

        order = databaseAPIUtil.saveOrder(order);

        bill.setOrderId(order.getId());
        bill.setOrderPlacedTime(LocalDateTime.now());
        bill.setTotalBillPayed(totalAmount);
        bill.setProducts(billProducts);
        return bill;
    }
}
