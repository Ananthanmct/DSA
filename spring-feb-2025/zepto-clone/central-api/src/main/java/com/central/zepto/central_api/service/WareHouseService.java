package com.central.zepto.central_api.service;

import com.central.zepto.central_api.Util.Adapter;
import com.central.zepto.central_api.Util.DatabaseAPIUtil;
import com.central.zepto.central_api.Util.UserUtil;
import com.central.zepto.central_api.enums.UserType;
import com.central.zepto.central_api.exception.UnAuthorized;
import com.central.zepto.central_api.exception.UserNotFoundException;
import com.central.zepto.central_api.models.AppUser;
import com.central.zepto.central_api.models.WareHouse;
import com.central.zepto.central_api.models.WareHouseProducts;
import com.central.zepto.central_api.requestdto.RegisterWareHouseProductDTO;
import com.central.zepto.central_api.requestdto.RequestWarehouseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WareHouseService {

    @Autowired
    DatabaseAPIUtil databaseAPIUtil;

    @Autowired
    Adapter adapter;

    @Autowired
    UserUtil userUtil;

    public WareHouse createWareHouse(UUID userId, RequestWarehouseDTO warehouseDTO){

        // We have userId ->
        // With the help of userId we will try to get user from dbApi

        AppUser user = databaseAPIUtil.getUserByUserId(userId);

        if(user == null){
            throw new UserNotFoundException(String.format("User with id %s does not exists in system", userId.toString()));
        }

        if(!user.getUserType().equals(UserType.APPLICATION_ADMIN.toString())){
            throw new UnAuthorized(String.format("USer wih id %s does not have access to create warehouse", userId.toString()));
        }

        // We will start creating warehouse into the system.

        // we need to call database api util that will hit dbApi url to create warehouse

        UUID managerId = warehouseDTO.getManagerId();

        AppUser manager = databaseAPIUtil.getUserByUserId(managerId);

        WareHouse wareHouse = adapter.mapRegisterWarehouseDTOToWareHouse(warehouseDTO,
                manager);

        // Will call database api to create warehouse record in the database

        WareHouse wareHouseResp = databaseAPIUtil.createWareHouse(wareHouse);

        return wareHouseResp;
    }


    public WareHouseProducts addProductsToWareHouse(RegisterWareHouseProductDTO wareHouseProductDTO,
                                       UUID userId){
        AppUser user = databaseAPIUtil.getUserByUserId(userId);

        if(userUtil.isZeptoWareHouseManager(user) == false
        && userUtil.isZeptoApplicationAdmin(user) == false){
            throw new UnAuthorized(String.format("User with id %s does not have access to add products into system", userId.toString()));
        }

        // we need to call database api to create new record into the warehouse product table

        WareHouseProducts wareHouseProducts = adapter.mapWareHouseProductDTOToWareHouseProducts(wareHouseProductDTO);

        // database api

        WareHouseProducts wareHouseProductsResp = databaseAPIUtil.createWareHouseProducts(wareHouseProducts);

        return wareHouseProductsResp;
    }
}
