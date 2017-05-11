package org.loversAPP.service.Impl;

import org.loversAPP.dao.MomentMapper;
import org.loversAPP.model.Moment;
import org.loversAPP.service.MomentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
@Service
public class MomentServiceImpl implements MomentService {
    @Autowired
    private MomentMapper momentMapper;

    public int insertMoment(Moment moment) {

        return momentMapper.insertSelective(moment);
    }


    public int deleteMomentByID(int id) {
        return momentMapper.deleteByPrimaryKey(id);
    }


    public List<Moment> getMommentByUID(int userID) {
        return momentMapper.selectByUserid(userID);
    }


    public Moment getMommentByID(int id) {
        return momentMapper.selectByPrimaryKey(id);
    }

    public int updateCommentIDByID(int id, int commentID) {
        Moment moment=new Moment();
        moment.setId(id);
        moment.setCommentid(commentID);
        return momentMapper.updateByPrimaryKeySelective(moment);
    }
}
