package com.shopping.mailservice.Shopping_Mail_Service.Controller;

import com.shopping.mailservice.Shopping_Mail_Service.service.ShopperMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/mail/shopper")
public class ShopperMailController {

    @Autowired
    ShopperMailService shopperMailService;

    @GetMapping("/cancelorder")


    public void cancelOrder(@RequestParam String shopperEmail, @RequestParam String orderId){

        System.out.println("Inside Mail Controller: Request Recieved");
        Logger logger = new Logger("log1", "Shopper");
        logger.info("Inside Mail Controller: Request Recieved"));
        shopperMailService.sendCancelationMail(shopperEmail, orderId);
    }
}
