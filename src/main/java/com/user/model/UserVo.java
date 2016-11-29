package com.user.model;

public class UserVo {
    private String id;
    private String pw;
    private String login;

    public UserVo() {
    }

    public UserVo(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserVo)) return false;

        UserVo userVo = (UserVo) o;

        if (getId() != null ? !getId().equals(userVo.getId()) : userVo.getId() != null) return false;
        return getPw() != null ? getPw().equals(userVo.getPw()) : userVo.getPw() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getPw() != null ? getPw().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "{\"login:\"" + login + "\",\"id:\"" + id+ "\"}";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
