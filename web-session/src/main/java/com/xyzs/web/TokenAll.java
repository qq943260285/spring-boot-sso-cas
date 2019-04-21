package com.xyzs.web;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Token管理
 */
@Component
@EnableScheduling
public class TokenAll {
    private static final Map<String, Date> ALL_TOKEN = new ConcurrentHashMap(16);

    /**
     * 添加
     *
     * @param token
     * @return
     */
    public static boolean add(String token) {
        try {
            ALL_TOKEN.put(token, new Date());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * 是否存在
     *
     * @param token
     * @return
     */
    public static boolean isToken(String token) {
        return ALL_TOKEN.containsKey(token) && add(token);
    }

    /**
     * 删除
     *
     * @param token
     * @return
     */
    public static boolean del(String token) {
        return ALL_TOKEN.remove(token) != null;
    }


    @Scheduled(cron = "0 0/1 * * * *")
    public void scheduled() {
        Iterator<Map.Entry<String, Date>> iterator = ALL_TOKEN.entrySet().iterator();
        Date date = new Date();
        System.out.println("Token Size:" + ALL_TOKEN.size());
        while (iterator.hasNext()) {
            Map.Entry<String, Date> entry = iterator.next();
            if (Duration.between(entry.getValue().toInstant(), date.toInstant()).getSeconds() > (3 * 60)) {
                del(entry.getKey());
            }
        }
    }
}
