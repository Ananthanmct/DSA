package com.central.zepto.central_api.Util;

import com.central.zepto.central_api.models.AppUser;
import com.central.zepto.central_api.models.Product;
import com.central.zepto.central_api.models.WareHouse;
import com.central.zepto.central_api.models.WareHouseProducts;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.UUID;

@Component
public class DatabaseAPIUtil extends ApiUtilImpl {

    @Value("${db.api.url}")
    String dbApiUrl;

    @Autowired
    ModelMapper mapper;

    public AppUser callCreateUserEndpoint(AppUser user){
        //creation of url
//        String url = "http://localhost:8081" + dbApiUrl + "/user/save";
//        URI finalUrl = URI.create(url);
//        //create request entity
//        RequestEntity request = RequestEntity.post(finalUrl).body(user);
//        // Create rest Template
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<AppUser> response =restTemplate.exchange(url, HttpMethod.POST, request, AppUser.class);
//        return response.getBody();

        Object resp = makePostCall(dbApiUrl, "/user/save", new HashMap<>(), user);
        AppUser userResp = mapper.map(resp, AppUser.class);
        return userResp;
    }

    public Product callCreateProductEndPoint(Product product){
        Object resp = makePostCall(dbApiUrl, "/product/save", new HashMap<>(), product);
        return mapper.map(resp, Product.class);

    }

    public AppUser getUserByEmail(String email){
        String endPoint =  "/user/email/" + email;
        Object resp  = makeGetCall(dbApiUrl, endPoint, new HashMap<>());
        return mapper.map(resp, AppUser.class);
    }

    public AppUser getUserByUserId(UUID userId){
        // need to make get call to dbApi
        String endPoint = "/user/" + userId.toString();
        Object resp = makeGetCall(dbApiUrl,endPoint, new HashMap<>());
        return mapper.map(resp, AppUser.class);
    }

    public WareHouse createWareHouse(WareHouse wareHouse){
        String endPoint = "/warehouse/save";
        Object resp = makePostCall(dbApiUrl, endPoint, new HashMap<>(), wareHouse);
        return mapper.map(resp, WareHouse.class);
    }

    public WareHouseProducts createWareHouseProducts(WareHouseProducts wareHouseProducts){
        String endPoint = "/warehouse/products/save";
        Object resp = makePostCall(dbApiUrl, endPoint, new HashMap<>(), wareHouseProducts);
        return mapper.map(resp, WareHouseProducts.class);
    }
}
