package com.central.zepto.central_api;

import com.central.zepto.central_api.Util.UserUtil;
import com.central.zepto.central_api.enums.UserType;
import com.central.zepto.central_api.models.AppUser;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

public class UserUtilTest {

    UserUtil userUtil = new UserUtil();
    // -ve scenario test -> User object that is not of type zepto manager

    // +ve scenario test  -> User object is of type zepto manager

    @AfterAll
    public static void sayHello(){
        System.out.println("Hello");
    }


    @Test
    public void isZeptoWareHouseManagerTest(){
        System.out.println("h1");
        AppUser user = new AppUser();
        user.setUserType(UserType.WAREHOUSE_MANAGER.toString());
        boolean actualResp = userUtil.isZeptoWareHouseManager(user);
        boolean expectedResp = true;
        assertEquals(expectedResp, actualResp);
    }

    @Test
    public void isNotZeptoWareHouseManagerTest(){
        System.out.println("h2");
        AppUser user = new AppUser();
        user.setUserType(UserType.APPLICATION_ADMIN.toString());
        boolean actualResp = userUtil.isZeptoWareHouseManager(user);
        boolean extectedResp = false;
        assertEquals(actualResp, extectedResp);
    }


}
