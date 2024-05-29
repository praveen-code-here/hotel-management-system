package edu.ijse.lovers_leap.dto;

public class LoginDto {
    private int loginDetaiId;
    private String loginTime;
    private String loginDate;
    private int userId;

    public LoginDto(int loginDetaiId, String loginTime, String loginDate, int userId) {
        this.loginDetaiId = loginDetaiId;
        this.loginTime = loginTime;
        this.loginDate = loginDate;
        this.userId = userId;
    }

    public LoginDto(String loginTime, String loginDate, int userId) {
        this.loginTime = loginTime;
        this.loginDate = loginDate;
        this.userId = userId;
    }

    public int getLoginDetaiId() {
        return loginDetaiId;
    }

    public void setLoginDetaiId(int loginDetaiId) {
        this.loginDetaiId = loginDetaiId;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(String loginDate) {
        this.loginDate = loginDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
