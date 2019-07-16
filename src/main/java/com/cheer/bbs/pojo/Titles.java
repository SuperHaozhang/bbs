package com.cheer.bbs.pojo;

public class Titles {
    private int id;
    private String cname;
    private String title;
    private String message;
    private String date;
    private int click;
    private int mesnum;

    public Titles() {
    }

    public Titles(String cname, String title, String message,String date,int click,int mesnum) {
        this.cname = cname;
        this.title = title;
        this.message = message;
        this.date = date;
        this.click=click;
        this.mesnum=mesnum;
    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }

    public int getMesnum() {
        return mesnum;
    }

    public void setMesnum(int mesnum) {
        this.mesnum = mesnum;
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
