package auditPlatform.dao;

import auditPlatform.dao.impl.AnswerService;
import auditPlatform.pojo.Answer;

import java.sql.Connection;
import java.util.List;

public class AnswerServiceImpl implements AnswerService {
    @Override
    public int addAnswer(Connection con, Answer answer) {
        return 0;
    }

    @Override
    public int deleteAnswer(Connection con, int id) {
        return 0;
    }

    @Override
    public Answer findAnswerById(Connection con, int id) {
        return null;
    }

    @Override
    public List<Answer> findAnswerByProblemsId(Connection con, int problemsId) {
        return null;
    }

    @Override
    public List<Answer> findAnswerByUserId(Connection con, int userId) {
        return null;
    }

    @Override
    public int publishAnswer(Connection con, int id) {
        return 0;
    }

    @Override
    public int thumbsUpAnswer(Connection con, int id) {
        return 0;
    }

    @Override
    public int collectAnswer(Connection con, int id) {
        return 0;
    }

    @Override
    public int viewAnswer(Connection con, int id) {
        return 0;
    }

    @Override
    public int commentAnswer(Connection con, int id) {
        return 0;
    }
}
