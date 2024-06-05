package info.csoe.bean;

public class User {
    private Integer userId;
    private String username;
    private String qqOpenId;
    private String password;
    private String userEmail;
    private String getUserEmailCode;
    private String isActive;
    private String userSex;
    private String userQq;
    private String userTel;
    private String userXueli;
    private String userHobby;
    private String userIntroduce;
    private Long createTime;
    private Long updateTime;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", qqOpenId='" + qqOpenId + '\'' +
                ", password='" + password + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", getUserEmailCode='" + getUserEmailCode + '\'' +
                ", isActive='" + isActive + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userQq='" + userQq + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userXueli='" + userXueli + '\'' +
                ", userHobby='" + userHobby + '\'' +
                ", userIntroduce='" + userIntroduce + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getQqOpenId() {
        return qqOpenId;
    }

    public void setQqOpenId(String qqOpenId) {
        this.qqOpenId = qqOpenId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getGetUserEmailCode() {
        return getUserEmailCode;
    }

    public void setGetUserEmailCode(String getUserEmailCode) {
        this.getUserEmailCode = getUserEmailCode;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserQq() {
        return userQq;
    }

    public void setUserQq(String userQq) {
        this.userQq = userQq;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserXueli() {
        return userXueli;
    }

    public void setUserXueli(String userXueli) {
        this.userXueli = userXueli;
    }

    public String getUserHobby() {
        return userHobby;
    }

    public void setUserHobby(String userHobby) {
        this.userHobby = userHobby;
    }

    public String getUserIntroduce() {
        return userIntroduce;
    }

    public void setUserIntroduce(String userIntroduce) {
        this.userIntroduce = userIntroduce;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public User(Integer userId, String username, String qqOpenId, String password, String userEmail, String getUserEmailCode, String isActive, String userSex, String userQq, String userTel, String userXueli, String userHobby, String userIntroduce, Long createTime, Long updateTime) {
        this.userId = userId;
        this.username = username;
        this.qqOpenId = qqOpenId;
        this.password = password;
        this.userEmail = userEmail;
        this.getUserEmailCode = getUserEmailCode;
        this.isActive = isActive;
        this.userSex = userSex;
        this.userQq = userQq;
        this.userTel = userTel;
        this.userXueli = userXueli;
        this.userHobby = userHobby;
        this.userIntroduce = userIntroduce;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
