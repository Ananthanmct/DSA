package com.central.zepto.central_api.Util;

import com.central.zepto.central_api.models.AppUser;
import com.central.zepto.central_api.models.Product;
import com.central.zepto.central_api.models.WareHouse;
import com.central.zepto.central_api.models.WareHouseProducts;
import com.central.zepto.central_api.requestdto.RegisterProductDTO;
import com.central.zepto.central_api.requestdto.RegisterUserDTO;
import com.central.zepto.central_api.requestdto.RegisterWareHouseProductDTO;
import com.central.zepto.central_api.requestdto.RequestWarehouseDTO;
import org.springframework.stereotype.Component;

@Component
public class Adapter {

    public AppUser mapUserRequestBodyToAppUser(RegisterUserDTO user){
        AppUser appUser = AppUser.builder()
                .name(user.getName())
                .userType(user.getUserType().toString())
                .email(user.getEmail())
                .address(user.getAddress())
                .pincode(user.getPincode())
                .status("ACTIVE")
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .build();
        return appUser;
    }

    public Product mapRegisterProductDTOToProduct(RegisterProductDTO productDTO){
        Product product = Product.builder()
                .productName(productDTO.getProductName())
                .productPrice(productDTO.getProductPrice())
                .details(productDTO.getDetails())
                .weight(productDTO.getWeight())
                .rating(0.0)
                .manufacturerEmail(productDTO.getManufacturerEmail())
                .totalPurchase(0)
                .build();
        return product;
    }

    public WareHouse mapRegisterWarehouseDTOToWareHouse(RequestWarehouseDTO warehouseDTO, AppUser manager){
        WareHouse wareHouse = WareHouse.builder()
                .name(warehouseDTO.getName())
                .pincode(warehouseDTO.getPincode())
                .address(warehouseDTO.getAddress())
                .email(warehouseDTO.getEmail())
                .manager(manager)
                .build();
        return wareHouse;
    }

    public WareHouseProducts mapWareHouseProductDTOToWareHouseProducts(RegisterWareHouseProductDTO wareHouseProductDTO){
        WareHouseProducts wareHouseProducts = WareHouseProducts.builder()
                .wid(wareHouseProductDTO.getWid())
                .pid(wareHouseProductDTO.getPid())
                .discount(wareHouseProductDTO.getDiscount())
                .totalQuantity(wareHouseProductDTO.getTotalQuantity())
                .build();
        return wareHouseProducts;
    }

}
