package auditPlatform.pojo;

public class answer {
    private int id;
    private int problemsId;
    private String txt;
    private int userId;
    private int viewNum;
    private int collectNum;
    private int thumbsUpNum;
    private int commentNum;

    public answer() {
    }

    public answer(int id, int problemsId, String txt, int userId, int viewNum, int collectNum, int thumbsUpNum, int commentNum) {
        this.id = id;
        this.problemsId = problemsId;
        this.txt = txt;
        this.userId = userId;
        this.viewNum = viewNum;
        this.collectNum = collectNum;
        this.thumbsUpNum = thumbsUpNum;
        this.commentNum = commentNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getViewNum() {
        return viewNum;
    }

    public void setViewNum(int viewNum) {
        this.viewNum = viewNum;
    }

    public int getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(int collectNum) {
        this.collectNum = collectNum;
    }

    public int getThumbsUpNum() {
        return thumbsUpNum;
    }

    public void setThumbsUpNum(int thumbsUpNum) {
        this.thumbsUpNum = thumbsUpNum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    @Override
    public String toString() {
        return "answer{" +
                "id=" + id +
                ", problemsId=" + problemsId +
                ", txt='" + txt + '\'' +
                ", userId=" + userId +
                ", viewNum=" + viewNum +
                ", collectNum=" + collectNum +
                ", thumbsUpNum=" + thumbsUpNum +
                ", commentNum=" + commentNum +
                '}';
    }
}
