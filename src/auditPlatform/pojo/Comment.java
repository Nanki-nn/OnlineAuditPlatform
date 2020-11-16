package auditPlatform.pojo;

public class Comment {
    private int id;
    private int userId;
    private int problemsId;
    private String txt;
    private int thumbsUpNum;

    public Comment() {
    }

    public Comment(int id, int userId, int problemsId, String txt, int thumbsUpNum) {
        this.id = id;
        this.userId = userId;
        this.problemsId = problemsId;
        this.txt = txt;
        this.thumbsUpNum = thumbsUpNum;
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

    public int getProblemsId() {
        return problemsId;
    }

    public void setProblemsId(int problemsId) {
        this.problemsId = problemsId;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public int getThumbsUpNum() {
        return thumbsUpNum;
    }

    public void setThumbsUpNum(int thumbsUpNum) {
        this.thumbsUpNum = thumbsUpNum;
    }

    @Override
    public String toString() {
        return "comment{" +
                "id=" + id +
                ", userId=" + userId +
                ", problemsId=" + problemsId +
                ", txt='" + txt + '\'' +
                ", thumbsUpNum=" + thumbsUpNum +
                '}';
    }
}
