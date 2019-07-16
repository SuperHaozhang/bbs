package com.cheer.bbs.pojoVo;

import com.cheer.bbs.pojo.Titles;

public class TitlesVo extends Titles {
    private String avatar;
    private String lastTime;



    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "TitlesVo{" +
                "avatar='" + avatar + '\'' +
                '}';
    }
}
