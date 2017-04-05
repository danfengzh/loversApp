package org.loversAPP.service;

import org.junit.Test;
import org.loversAPP.service.baseService.baseServiceTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/4/3.
 */
public class DoolePhotoServiceTest extends baseServiceTest {
    @Autowired
    private DoolePhotoService doolePhotoService;
    @Test
    public void doodlePhoto() throws Exception {
        int res=   doolePhotoService.getDogHeadByID("oca84dy2");
        System.out.println("vvvv");
    }

    @Test
    public void insertDog() throws Exception {

    }

    @Test
    public void getDogHeadByID() throws Exception {

    }

    @Test
    public void getAllDooolePhotos() throws Exception {

    }

}