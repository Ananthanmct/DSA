package com.db.zepto.db_api.controller;

import com.db.zepto.db_api.model.AppOrder;
import com.db.zepto.db_api.model.AppUser;
import com.db.zepto.db_api.repository.AppUserRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/user")
public class AppUserController {



    private AppUserRepository appUserRepository;

    @Autowired
    public AppUserController(AppUserRepository appUserRepository){
        this.appUserRepository = appUserRepository;
    }

    @GetMapping("/{userId}")
    public AppUser getUserById(@PathVariable UUID userId){
        return appUserRepository.findById(userId)
                .orElse(null);
    }


    @PostMapping("/save")
    public AppUser saveUser(@RequestBody AppUser user){
        AppOrder order = AppOrder.builder().build();
        appUserRepository.save(user);
        return user;
    }

    @PutMapping("/update")
    public AppUser updateUser(@RequestBody AppUser user){
        appUserRepository.save(user);
        return user;
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable UUID userId){
        appUserRepository.deleteById(userId);
    }

}
