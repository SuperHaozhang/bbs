package com.cheer.bbs.pojo;

public class Progra {
    private int id;
    private String name;
    private String password;
    private String hiredate;
    private String avatar;

    public Progra() {
    }

    public Progra( String name, String password, String hiredate, String avatar) {
        this.name = name;
        this.password = password;
        this.hiredate = hiredate;
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Progra{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", hiredate='" + hiredate + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
