package org.loversAPP.dao;

import org.apache.ibatis.annotations.Param;
import org.loversAPP.model.CommentLike;
import org.loversAPP.model.CommentLikeExample;

import java.util.List;

public interface CommentLikeMapper {
    long countByExample(CommentLikeExample example);

    int deleteByExample(CommentLikeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CommentLike record);

    int insertSelective(CommentLike record);

    List<CommentLike> selectByExample(CommentLikeExample example);

    CommentLike selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CommentLike record, @Param("example") CommentLikeExample example);

    int updateByExample(@Param("record") CommentLike record, @Param("example") CommentLikeExample example);

    int updateByPrimaryKeySelective(CommentLike record);

    int updateByPrimaryKey(CommentLike record);
}