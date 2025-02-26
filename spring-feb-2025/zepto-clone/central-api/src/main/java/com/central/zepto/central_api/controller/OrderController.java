package com.central.zepto.central_api.controller;

import com.central.zepto.central_api.exception.ProductNotPresentException;
import com.central.zepto.central_api.exception.UserNotFoundException;
import com.central.zepto.central_api.exception.WareHouseNotAvailableException;
import com.central.zepto.central_api.requestdto.RequestOrderProductDTO;
import com.central.zepto.central_api.responsedto.ResponseBillDTO;
import com.central.zepto.central_api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/central/order/")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/place")
    public ResponseEntity placeOrder(@RequestBody List<RequestOrderProductDTO> products,
                                     @RequestParam UUID userId){
        // order service
        try{
          ResponseBillDTO bill = orderService.placeOrder(products, userId);
          return new ResponseEntity(bill, HttpStatus.CREATED);
        }catch (ProductNotPresentException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }catch (WareHouseNotAvailableException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }catch (UserNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }
}
