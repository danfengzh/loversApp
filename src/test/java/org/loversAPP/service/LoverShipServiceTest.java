package org.loversAPP.service;

import org.junit.Test;
import org.loversAPP.service.baseService.baseServiceTest;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/2/17.
 */
public class LoverShipServiceTest extends baseServiceTest {
    @Autowired
    private LoverShipService loverShipService;
    @Test
    public void queryLoverShip_HasLoveShip() throws Exception {

        loverShipService.QueryLoverShip_HasLoveShip(1,null);
        System.out.println("*****");
    }

}