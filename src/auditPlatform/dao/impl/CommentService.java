package auditPlatform.dao.impl;

import auditPlatform.pojo.Comment;

import java.sql.Connection;
import java.util.List;

public interface CommentService {
    /**
     * 添加评论
     * @param con
     * @param comment
     * @return
     */
    int addComment(Connection con, Comment comment);
    /**
     * 点赞评论(根据id)
     * @param con
     * @param id
     * @return
     */
    int thumbsUpComment(Connection con,int id);

    /**
     * 根据id删除评论
     * @param con
     * @param id
     * @return
     */
    int deleteComment(Connection con,int id);

    /**
     * 根据id查找评论
     * @param con
     * @param Id
     * @return
     */
    Comment findCommentById(Connection con,int Id);

    /**
     * 根据问题id查找评论
     * @param con
     * @param problemsId
     * @return
     */
    List<Comment> findCommentByProblemsId(Connection con,int problemsId);

}
