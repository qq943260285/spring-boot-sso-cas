# spring-boot-sso-cas
SSO（Single Sign On）单点登录，基于CAS的跨域名WEB单点登录例子

## 准备
1. HOSTS
``` text
127.0.0.1		xyzs.com
127.0.0.1		xyzs-a.com
127.0.0.1		xyzs-b.com
```

## 项目
### web-api
1. GET /xxx
    > 需要登录获取信息
2. GET /login
    > 使用Token登录，验证
### web-session
1. POST /login
    > 登录获取Token信息（可扩展添加用户名、密码）
2. POST /verify
    > 提供web-api验证Token信息
3. /login.html
    > 统一登录页面

## 测试
1. 启动web-api、web-session
2. 使用xyzs-a.com访问web-api
3. 跳转统一登录页xyzs.com访问web-session
4. 使用xyzs-b.com访问web-api