package com.db.zepto.db_api.controller;

import com.db.zepto.db_api.model.WareHouseProducts;
import com.db.zepto.db_api.repository.WareHouseProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/db/warehouse/product")
public class WareHouseProductController {

    @Autowired
    WareHouseProductsRepository wareHouseProductsRepository;

    @PostMapping("/save")
    public WareHouseProducts addProduct(@RequestBody WareHouseProducts wareHouseProducts){
        wareHouseProductsRepository.save(wareHouseProducts);
        return wareHouseProducts;
    }
}
