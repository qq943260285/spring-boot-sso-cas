package com.xyzs.web.controller;

import com.xyzs.web.Utils;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;

@RestController
public class DemoController {
    @GetMapping("/index")
    public String index(HttpServletRequest httpServletRequest) {
        StringBuilder sb = new StringBuilder();
        sb.append(Utils.requestToString(httpServletRequest));
        sb.append("\n");
        sb.append("com.xyzs.web-a OK");

        return sb.toString();
    }

    @GetMapping("/add")
    public String add(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Cookie cookie = new Cookie("webName", "com.xyzs.web-a");
        httpServletResponse.addCookie(cookie);
        return "com.xyzs.web-a add OK";
    }

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

    @GetMapping("/xxx")
    public String xxx(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        if (verify(httpServletRequest).isEmpty()) {
//            RestTemplate restTemplate = new RestTemplate();
            try {
                httpServletResponse.sendRedirect("http://xyzs.com:8788/login.html" +
                        "?login=" +
                        httpServletRequest.getScheme() + "://" +
                        httpServletRequest.getServerName() + ":" +
                        httpServletRequest.getServerPort() + "/login" +
                        "&redirect=" + httpServletRequest.getRequestURL()
                );
            } catch (IOException e) {
                e.printStackTrace();
            }
//            String forObject = restTemplate.getForObject("http://xyzs.com:8788/login?url=" + httpServletRequest.getRequestURI(), String.class);

            return "no";
        }

        return "ok";
    }

    @GetMapping("/login")
    public void login(@RequestParam("token") String token,
                      @RequestParam("redirect") String redirect,
                      HttpServletRequest httpServletRequest,
                      HttpServletResponse httpServletResponse
    ) {

        if (verify(httpServletRequest).isEmpty()) {
            RestTemplate restTemplate = new RestTemplate();
            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("token", token);
            Boolean b = restTemplate.postForObject("http://xyzs.com:8788/verify", map, Boolean.class);
            if (b != null && b) {
                Cookie cookie = new Cookie("token", token);
                httpServletResponse.addCookie(cookie);
                try {
                    httpServletResponse.sendRedirect(redirect);
                } catch (IOException e) {
                    e.printStackTrace();
                }
//                return "Ok New Token：" + token;
            } else {
//                return "No";
            }
        } else {
//            return "Ok Token：" + token;
        }
    }

    private String verify(HttpServletRequest httpServletRequest) {
        Cookie[] cookies = httpServletRequest.getCookies();
        String v = "";
        for (int i = 0; i < (cookies == null ? 0 : cookies.length); i++) {
            if ("token".equalsIgnoreCase(cookies[i].getName())) {
                try {
                    v = URLDecoder.decode(cookies[i].getValue(), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return v;
    }
}
