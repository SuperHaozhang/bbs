package com.cheer.bbs.pojoVo;

import com.cheer.bbs.pojo.Messages;

public class MessageVo extends Messages {
    private String avatar;
    private String title;
    private String date;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "MessageVo{" +
                "avatar='" + avatar + '\'' +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
