package com.central.zepto.central_api.controller;

import com.central.zepto.central_api.models.AppUser;
import com.central.zepto.central_api.models.Product;
import com.central.zepto.central_api.requestdto.RegisterUserDTO;
import com.central.zepto.central_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/central/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public AppUser createUser(@RequestBody RegisterUserDTO user){
        AppUser response  = userService.createUser(user);
        return  response;
    }

    @GetMapping("/products")
    public void getProductsByPincode(@RequestParam UUID userId){
        // warehouse service
    }

}
