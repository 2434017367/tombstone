package com.example.tombstone.utils;

import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * @email 2434017367@qq.com
 * @author: zhy
 * @date: 2019/12/15
 * @time: 13:02
 */
public class CommUtils {

    public static String getUuid(){
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
        uuid = uuid.replaceAll("-", "");
        System.out.println(uuid);
        return uuid;
    }

    public static boolean isEmpty(String s){
        return StringUtils.isEmpty(s) || "null".equals(s);
    }

    public static boolean isNotEmpty(String s){
        return !isEmpty(s);
    }

    public static void main(String[] args) {
        getUuid();
    }

}
