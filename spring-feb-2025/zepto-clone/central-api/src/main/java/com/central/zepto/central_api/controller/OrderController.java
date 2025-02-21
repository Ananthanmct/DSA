package com.central.zepto.central_api.controller;

import com.central.zepto.central_api.requestdto.RequestOrderProductDTO;
import com.central.zepto.central_api.responsedto.ResponseBillDTO;
import com.central.zepto.central_api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/central/order/")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/place")
    public ResponseBillDTO placeOrder(@RequestBody List<RequestOrderProductDTO> products,
                                      @RequestParam UUID userId){
        // order service
        return orderService.placeOrder(products, userId);
    }
}
