package auditPlatform.pojo;

public class Problems {
    private int id;
    private int userId;
    private String txt;
    private int answerNum;
    private int highestScore;
    private int status;
    private int answerId;

    public Problems() {
    }

    public Problems(int id, int userId, String txt, int answerNum, int highestScore, int status, int answerId) {
        this.id = id;
        this.userId = userId;
        this.txt = txt;
        this.answerNum = answerNum;
        this.highestScore = highestScore;
        this.status = status;
        this.answerId = answerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public int getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(int answerNum) {
        this.answerNum = answerNum;
    }

    public int getHighestScore() {
        return highestScore;
    }

    public void setHighestScore(int highestScore) {
        this.highestScore = highestScore;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    @Override
    public String toString() {
        return "Problems{" +
                "id=" + id +
                ", userId=" + userId +
                ", txt='" + txt + '\'' +
                ", answerNum=" + answerNum +
                ", highestScore=" + highestScore +
                ", status=" + status +
                ", answerId=" + answerId +
                '}';
    }
}
