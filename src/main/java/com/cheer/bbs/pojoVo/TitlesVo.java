package com.cheer.bbs.pojoVo;

import com.cheer.bbs.pojo.Titles;

public class TitlesVo extends Titles {
    private String avatar;
    private String lastdate;

    public String getLastdate() {
        return lastdate;
    }

    public void setLastdate(String lastdate) {
        this.lastdate = lastdate;
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
