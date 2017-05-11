package org.loversAPP.service.Impl;

import org.loversAPP.DTO.LikeWithUser;
import org.loversAPP.DTO.ReplyWithUser;
import org.loversAPP.dao.CommentReplyMapper;
import org.loversAPP.model.*;
import org.loversAPP.dao.CommentLikeMapper;
import org.loversAPP.dao.CommentMapper;
import org.loversAPP.service.CommmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/11.
 */
@Service
public class CommmentServiceImpl implements CommmentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private CommentLikeMapper commentLikeMapper;
    @Autowired
    private CommentReplyMapper commentReplyMapper;
    public int updateZanLikeNumByMID(int momentID, int likeNum) {
        Comment comment=new Comment();
        comment.setLikenum(likeNum);
        CommentExample commentExample=new CommentExample();
        commentExample.createCriteria().andMomentidEqualTo(momentID);
        return commentMapper.updateByExampleSelective(comment,commentExample);
    }

    public int updatePingLikeNumByMID(int momentID, int likeNum) {
        Comment comment=new Comment();
        comment.setReplynum(likeNum);
        CommentExample commentExample=new CommentExample();
        commentExample.createCriteria().andMomentidEqualTo(momentID);
        return commentMapper.updateByExampleSelective(comment,commentExample);
    }

    public int deleteCommentByMID(int momentID) {
        CommentExample commentExample=new CommentExample();
        commentExample.createCriteria().andMomentidEqualTo(momentID);
        return commentMapper.deleteByExample(commentExample);
    }

    public int insertCommentLike(int momentID, int userID) {
        CommentLike commentLike=new CommentLike();
        commentLike.setCommentid(momentID);
        commentLike.setUserid(userID);
        commentLike.setLikedate(new Date());
        return commentLikeMapper.insertSelective(commentLike);
    }

    public int deleteCommentLike(int momentID, int userID) {
        CommentLikeExample commentLikeExample=new CommentLikeExample();
        commentLikeExample.createCriteria().andCommentidEqualTo(momentID).andUseridEqualTo(userID);
        return commentLikeMapper.deleteByExample(commentLikeExample);
    }

    public List<LikeWithUser> getLikesByCID(int commentID) {
        return commentLikeMapper.getLikesByCID(commentID);
    }

    public int insertCommentReply(int momentID, int userID, String replyContent) {
        CommentReply commentReply=new CommentReply();
        commentReply.setCommentid(momentID);
        commentReply.setUserid(userID);
        commentReply.setReplycontent(replyContent);
        return commentReplyMapper.insertSelective(commentReply);
    }

    public int deleteCommentReply(int momentID, int userID) {
        CommentReplyExample commentReplyExample=new CommentReplyExample();
        commentReplyExample.createCriteria().andCommentidEqualTo(momentID).andUseridEqualTo(userID);
        return commentReplyMapper.deleteByExample(commentReplyExample);
    }

    public List<ReplyWithUser> getRepliesByCID(int commentID) {
        return commentReplyMapper.getReplistrbYcID(commentID);
    }
}
