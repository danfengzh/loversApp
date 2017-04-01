package org.loversAPP.service;

import org.loversAPP.model.DoodlePhoto;
import org.loversAPP.model.LoverDog;

import java.util.List;

/**
 * Created by Administrator on 2017/3/31.
 */
public interface DoolePhotoService {

    public int doodlePhoto(int photoID, String doodlePhoto, int userID, int userItemID);

    public int insertDog(LoverDog loverDog);

    public int getDogHeadByID(String loverID);



    public List<DoodlePhoto> getAllDooolePhotos();
}
