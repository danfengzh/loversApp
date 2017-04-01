package org.loversAPP.service.Impl;

import org.loversAPP.dao.LoverDogMapper;
import org.loversAPP.dao.DoodlePhotoMapper;
import org.loversAPP.model.DoodlePhoto;
import org.loversAPP.model.LoverDog;
import org.loversAPP.service.DoolePhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/31.
 */
@Service
public class DoolePhotoServiceImpl implements DoolePhotoService {
    @Autowired
    private DoodlePhotoMapper doodlePhotoMapper;
    @Autowired
    private LoverDogMapper loverDogMapper;
    public int doodlePhoto(int photoID, String doodlePhoto, int userID, int userItemID) {
        DoodlePhoto doodlePhot=new DoodlePhoto();
        doodlePhot.setDoodlephoto(doodlePhoto);
        doodlePhot.setUserid(userID);
        doodlePhot.setPhotoid(photoID);
        doodlePhot.setUseritemid(userItemID);
        doodlePhot.setDoodletime(new Date());
        return doodlePhotoMapper.insertSelective(doodlePhot);
    }

    public int insertDog(LoverDog loverDog) {
        return loverDogMapper.insertSelective(loverDog);
    }

    public int getDogHeadByID(String loverID) {
        return loverDogMapper.getDogHeadByID(loverID);
    }

    public List<DoodlePhoto> getAllDooolePhotos() {
        return doodlePhotoMapper.getAllDooolePhotos();
    }
}
