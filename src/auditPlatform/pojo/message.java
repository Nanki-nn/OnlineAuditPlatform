package auditPlatform.pojo;

public class message {
    private int id;
    private int userIdOne;
    private int userIdTwo;
    private String comment;

    public message() {
    }

    public message(int id, int userIdOne, int userIdTwo, String comment) {
        this.id = id;
        this.userIdOne = userIdOne;
        this.userIdTwo = userIdTwo;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserIdOne() {
        return userIdOne;
    }

    public void setUserIdOne(int userIdOne) {
        this.userIdOne = userIdOne;
    }

    public int getUserIdTwo() {
        return userIdTwo;
    }

    public void setUserIdTwo(int userIdTwo) {
        this.userIdTwo = userIdTwo;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "message{" +
                "id=" + id +
                ", userIdOne=" + userIdOne +
                ", userIdTwo=" + userIdTwo +
                ", comment='" + comment + '\'' +
                '}';
    }
}
