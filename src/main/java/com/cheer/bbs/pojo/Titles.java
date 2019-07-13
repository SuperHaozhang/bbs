package com.cheer.bbs.pojo;

public class Titles {
    private int id;
    private String cname;
    private String title;
    private String message;
    private String date;

    public Titles() {
    }

    public Titles(String cname, String title, String message,String date) {
        this.cname = cname;
        this.title = title;
        this.message = message;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Titles{" +
                "id=" + id +
                ", cname='" + cname + '\'' +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
