package edu.ijse.lovers_leap.entity;

public class LoginEntity {
    private int login_Detail_Id;
    private String login_time;
    private String login_Date;
    private int user_id;

    public LoginEntity(int login_Detail_Id, String login_time, String login_Date, int user_id) {
        this.login_Detail_Id = login_Detail_Id;
        this.login_time = login_time;
        this.login_Date = login_Date;
        this.user_id = user_id;
    }

    public LoginEntity(String login_time, String login_Date, int user_id) {
        this.login_time = login_time;
        this.login_Date = login_Date;
        this.user_id = user_id;
    }

    public int getLogin_Detail_Id() {
        return login_Detail_Id;
    }

    public void setLogin_Detail_Id(int login_Detail_Id) {
        this.login_Detail_Id = login_Detail_Id;
    }

    public String getLogin_time() {
        return login_time;
    }

    public void setLogin_time(String login_time) {
        this.login_time = login_time;
    }

    public String getLogin_Date() {
        return login_Date;
    }

    public void setLogin_Date(String login_Date) {
        this.login_Date = login_Date;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
