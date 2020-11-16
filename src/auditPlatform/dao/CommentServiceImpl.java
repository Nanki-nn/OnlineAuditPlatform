package auditPlatform.dao;

import auditPlatform.dao.impl.CommentService;
import auditPlatform.pojo.Comment;

import java.sql.Connection;
import java.util.List;

public class CommentServiceImpl implements CommentService {
    @Override
    public int addComment(Connection con, Comment comment) {
        return 0;
    }

    @Override
    public int thumbsUpComment(Connection con, int id) {
        return 0;
    }

    @Override
    public int deleteComment(Connection con, int id) {
        return 0;
    }

    @Override
    public Comment findCommentById(Connection con, int Id) {
        return null;
    }

    @Override
    public List<Comment> findCommentByProblemsId(Connection con, int problemsId) {
        return null;
    }

    @Override
    public List<Comment> findCommentByUserId(Connection con, int userId) {
        return null;
    }
}
