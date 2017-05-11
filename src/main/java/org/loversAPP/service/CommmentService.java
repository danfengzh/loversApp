package org.loversAPP.service;

import org.loversAPP.DTO.LikeWithUser;
import org.loversAPP.DTO.ReplyWithUser;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/11.
 */
public interface CommmentService {
    public int updateZanLikeNumByMID(int momentID ,int likeNum);

    public int updatePingLikeNumByMID(int momentID ,int likeNum);

    public int deleteCommentByMID(int momentID);

    public int insertCommentLike(int momentID ,int userID);

    public int deleteCommentLike(int momentID ,int userID);

   public List<LikeWithUser>  getLikesByCID(int commentID);

    public int insertCommentReply(int momentID,int  userID, String replyContent);

    public  int deleteCommentReply(int momentID, int userID);
    public List<ReplyWithUser> getRepliesByCID(int commentID);
}
