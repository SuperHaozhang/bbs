package com.cheer.bbs.util;

import org.apache.commons.codec.digest.DigestUtils;

public class StringUtils {
    // 使用md5加密
    public static String encrypt(String password) {
        return DigestUtils.md5Hex(password);
    }


    //计算时间
    public static String long2String(long date){
        String year = ((int)date/3600/24/30/12)+"年";
        String mon = ((int)date/3600/24/30%12)+"月";
        String day = ((int)date/3600/24%30)+"日";
        String hr = ((int) date/3600%24)+"时";
        String min = ((int)date/60%60)+"分";
        String sec = ((int)date%60)+"秒";
        return year+mon+day+hr+min+sec;
    }
}
