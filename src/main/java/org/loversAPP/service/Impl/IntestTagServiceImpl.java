package org.loversAPP.service.Impl;

import org.loversAPP.DTO.MathableUser;
import org.loversAPP.model.InterestTag;
import org.loversAPP.service.IntestTagService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/5/11.
 */
@Service
public class IntestTagServiceImpl implements IntestTagService {
    public List<InterestTag> getInterestTagBySex(Integer sex) {
        return null;
    }

    public List<MathableUser> getUserOrderByMatchIndex(String halfHobby) {
        return null;
    }

    public int insertInterestTags(String tag) {
        return 0;
    }
}
