package com.xyzs.web.controller;

import com.xyzs.web.TokenAll;
import com.xyzs.web.Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.UUID;

@RestController
public class DemoController {


    @GetMapping("/get")
    public String get(HttpServletRequest httpServletRequest) {

        StringBuilder sb = new StringBuilder();
        sb.append(Utils.requestCookiesToString(httpServletRequest));
        sb.append("com.xyzs.web-a get OK");
        return sb.toString();
    }

    @GetMapping("/redirect")
    public void redirect(HttpServletResponse httpServletResponse) {
        try {
            httpServletResponse.sendRedirect("http://www.baidu.com");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/login")
    public String login(
//            @RequestParam("loginUrl") String loginUrl,
//                      @RequestParam("redirect") String redirect,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {

        //System.out.println(Utils.requestToString(httpServletRequest));
        System.out.println(httpServletRequest.getHeader("referer"));
        String token = verify(httpServletRequest);
        if (token.isEmpty()) {
            token = UUID.randomUUID().toString();
            if (TokenAll.add(token)) {
                Cookie cookie = new Cookie("token", token);
                httpServletResponse.addCookie(cookie);
            }
        }
//        try {
//            httpServletResponse.sendRedirect(loginUrl +
//                    "?token=" + token
////                    "&redirect=" + redirect
//            );
//            httpServletResponse.sendRedirect(httpServletRequest.getHeader("referer"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return token;

    }

    @PostMapping("/verify")
    public boolean tokenVerify(@RequestParam("token") String token) {
        return TokenAll.isToken(token);
    }

    private String verify(HttpServletRequest httpServletRequest) {
        Cookie[] cookies = httpServletRequest.getCookies();
        String v = "";
        for (int i = 0; i < (cookies == null ? 0 : cookies.length); i++) {
            if ("token".equalsIgnoreCase(cookies[i].getName())) {
                try {
                    v = URLDecoder.decode(cookies[i].getValue(), "UTF-8");
                    if (!TokenAll.isToken((v))) {
                        v = "";
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return v;
    }
}
