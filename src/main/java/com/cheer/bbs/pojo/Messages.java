package com.cheer.bbs.pojo;

public class Messages {
    private int id;
    private int tid;
    private String message;
    private int floor;
    private String cname;
    private String date;
    private int bool;
    public Messages() {
    }

    public Messages(int tid, String message, int floor,String cname,String date,int bool) {
        this.tid = tid;
        this.message = message;
        this.floor = floor;
        this.cname=cname;
        this.date = date;
        this.bool = bool;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getBool() {
        return bool;
    }

    public void setBool(int bool) {
        this.bool = bool;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "id=" + id +
                ", tid=" + tid +
                ", message='" + message + '\'' +
                ", floor=" + floor +
                ", cname=" + cname +
                ", date=" + date +
                '}';
    }
}
