package org.loversAPP.service;

import org.loversAPP.DTO.MathableUser;
import org.loversAPP.model.InterestTag;

import java.util.List;

/**
 * Created by Administrator on 2017/5/11.
 */
public interface IntestTagService {
    public List<InterestTag>  getInterestTagBySex(Integer  sex);

    public List<MathableUser>  getUserOrderByMatchIndex(String halfHobby);

    /**
     * 插入自定义标签
     * @param tag
     * @return
     */
    public int insertInterestTags(String tag);
}
