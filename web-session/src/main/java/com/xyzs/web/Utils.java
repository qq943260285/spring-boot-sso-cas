package com.xyzs.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * 未说明
 *
 * @Author: 小宇专属
 * @Date: 2019/4/8 16:44
 * @Modify: 无
 */
public class Utils {
    static public String requestToString(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();


        //====================== 接口HttpServletRequest ==========================
        //java.lang.String返回用于保护servlet的身份验证方案的名称。
        sb.append("用于保护servlet的身份验证方案的名称:" + request.getAuthType() + "\r\n");

        //java.lang.String返回请求URI的一部分，指示请求的上下文。
        sb.append("请求URI的一部分，指示请求的上下文:" + request.getContextPath() + "\r\n");

        //long返回指定请求标头的long值，作为表示Date对象的值 。
        //sb.append(request.getDateHeader(java.lang.String name)

        //java.lang.String返回用于发出此请求的HTTP方法的名称，例如，GET，POST或PUT。
        sb.append("请求的HTTP方法的名称:" + request.getMethod() + "\r\n");

        //java.lang.String返回与客户端发出此请求时发送的URL关联的任何额外路径信息。
        sb.append("与客户端发出此请求时发送的URL关联的任何额外路径信息:" + request.getPathInfo() + "\r\n");

        //java.lang.String返回servlet名称之后但查询字符串之前的任何额外路径信息，并将其转换为实际路径。
        sb.append("servlet名称之后但查询字符串之前的任何额外路径信息，并将其转换为实际路径:" + request.getPathTranslated() + "\r\n");

        //java.lang.String返回路径后请求URL中包含的查询字符串。
        sb.append("返回路径后请求URL中包含的查询字符串:" + request.getQueryString() + "\r\n");

        //java.lang.String如果用户已经过身份验证，或者null用户未经过身份验证，则返回发出此请求的用户的登录名。
        sb.append("返回发出此请求的用户的登录名:" + request.getRemoteUser() + "\r\n");

        //java.lang.String返回客户端指定的会话ID。
        sb.append("客户端指定的会话ID:" + request.getRequestedSessionId() + "\r\n");

        //java.lang.String将此请求的URL部分从协议名称返回到HTTP请求第一行中的查询字符串。
        sb.append("请求的URL部分从协议名称返回到HTTP请求第一行中的查询字符串:" + request.getRequestURI() + "\r\n");

        //java.lang.StringBuffer重构客户端用于发出请求的URL。
        sb.append("重构客户端用于发出请求的URL:" + request.getRequestURL() + "\r\n");

        //java.lang.String返回此请求调用servlet的URL的一部分。
        sb.append("请求调用servlet的URL的一部分:" + request.getServletPath() + "\r\n");

        //HttpSession返回与此请求关联的当前会话，或者如果请求没有会话，则创建一个会话。
        sb.append("与此请求关联的当前会话:" + request.getSession() + "\r\n");

        //HttpSession返回HttpSession 与此请求关联的当前值，如果没有当前会话且create为true，则返回新会话。
        //request.getSession(boolean create);

        //java.security.Principal返回java.security.Principal包含当前经过身份验证的用户的名称的对象。
        sb.append("包含当前经过身份验证的用户的名称的对象:" + request.getUserPrincipal() + "\r\n");

        //boolean检查所请求的会话ID是否作为cookie进入。
        sb.append("检查所请求的会话ID是否作为cookie进入:" + request.isRequestedSessionIdFromCookie() + "\r\n");

        //boolean检查请求的会话ID是否作为请求URL的一部分进入。
        sb.append("检查请求的会话ID是否作为请求URL的一部分进入:" + request.isRequestedSessionIdFromURL() + "\r\n");

        //boolean检查请求的会话ID是否仍然有效。
        sb.append("检查请求的会话ID是否仍然有效:" + request.isRequestedSessionIdValid() + "\r\n");

        //boolean返回一个布尔值，指示经过身份验证的用户是否包含在指定的逻辑“角色”中。
        //request.isUserInRole(java.lang.String role);


        //====================== 接口ServletRequest ==========================
        //java.lang.Object 返回指定属性的值作为Object，或者null如果不存在给定名称的属性。
        //getAttribute (java.lang.String name);

        //java.util.Enumeration 返回Enumeration包含此请求可用属性的名称。
        sb.append("Enumeration包含此请求可用属性的名称:" + request.getAttributeNames() + "\r\n");

        //java.lang.String 返回此请求正文中使用的字符编码的名称。
        sb.append("请求正文中使用的字符编码的名称:" + request.getCharacterEncoding() + "\r\n");

        //int 返回请求正文的长度（以字节为单位），并由输入流提供，如果长度未知，则返回 - 1。
        sb.append("请求正文的长度（以字节为单位）:" + request.getContentLength() + "\r\n");

        //java.lang.String 返回请求正文的MIME类型，或者 null类型是否已知。
        sb.append("请求正文的MIME类型:" + request.getContentType() + "\r\n");

        //ServletInputStream 使用a以二进制数据的形式检索请求的主体ServletInputStream。
//        sb.append("以二进制数据的形式检索请求的主体:" + request.getInputStream() + "\r\n");

        //java.lang.String 返回接收请求的接口的Internet协议（IP）地址。
        sb.append("接收请求的接口的Internet协议（IP）地址:" + request.getLocalAddr() + "\r\n");

        //java.util.Locale Locale根据Accept - Language标头 返回客户端将接受内容的首选项。
        sb.append("客户端将接受内容的首选项:" + request.getLocale() + "\r\n");

        //java.util.Enumeration 返回Enumeration的Locale对象指示，在开始，按照降序的优选语言环境，可以接受的基础上，Accept - Language头客户端的语言环境。
        sb.append("Language头客户端的语言环境:" + request.getLocales() + "\r\n");

        //java.lang.String 返回接收请求的Internet协议（IP）接口的主机名。
        sb.append("接收请求的Internet协议（IP）接口的主机名:" + request.getLocalName() + "\r\n");

        //int 返回接收请求的接口的Internet协议（IP）端口号。
        sb.append("接收请求的接口的Internet协议（IP）端口号:" + request.getLocalPort() + "\r\n");

        //java.lang.String 以a为参数String，或者null如果参数不存在，则返回请求参数的值。
        //getParameter (java.lang.String name);

        //java.util.Map 返回此请求的参数的java.util.Map。
        sb.append("返回此请求的参数的:" + request.getParameterMap() + "\r\n");

        //java.util.Enumeration 返回 包含此请求中包含的参数名称Enumeration的String对象。
        sb.append("包含此请求中包含的参数名称Enumeration的String对象:" + request.getParameterNames() + "\r\n");

        //java.lang.String[] 返回String包含给定请求参数具有的所有值的对象数组，或者 null参数是否不存在。
        //getParameterValues (java.lang.String name);

        //java.lang.String 以protocol / majorVersion.minorVersion格式返回请求使用的协议的名称和版本，例如HTTP / 1.1。
        sb.append("请求使用的协议的名称和版本:" + request.getProtocol() + "\r\n");

        //java.io.BufferedReader 使用a作为字符数据检索请求的主体BufferedReader。
        //sb.append("字符数据检索请求的主体BufferedReader:" + request.getReader() + "\r\n");

        //java.lang.String 返回发送请求的客户端或最后一个代理的Internet协议（IP）地址。
        sb.append("发送请求的客户端或最后一个代理的Internet协议（IP）地址:" + request.getRemoteAddr() + "\r\n");

        //java.lang.String 返回客户端的完全限定名称或发送请求的最后一个代理。
        sb.append("客户端的完全限定名称或发送请求的最后一个代理:" + request.getRemoteHost() + "\r\n");

        //int 返回客户端的Internet协议（IP）源端口或发送请求的最后一个代理。
        sb.append("客户端的Internet协议（IP）源端口或发送请求的最后一个代理:" + request.getRemotePort() + "\r\n");

        //RequestDispatcher 返回一个RequestDispatcher对象，该对象充当位于给定路径的资源的包装器。
        //getRequestDispatcher(java.lang.String path)

        //java.lang.String 返回用于提出这个要求的方案的名称，例如 http，https或ftp。
        sb.append("用于提出这个要求的方案的名称:" + request.getScheme() + "\r\n");

        //java.lang.String 返回发送请求的服务器的主机名。
        sb.append("发送请求的服务器的主机名:" + request.getServerName() + "\r\n");

        //int 返回发送请求的端口号。
        sb.append("发送请求的端口号:" + request.getServerPort() + "\r\n");

        //boolean 返回一个布尔值，指示此请求是否是使用安全通道（如HTTPS）进行的。
        sb.append("是否是使用安全通HTTPS:" + request.isSecure() + "\r\n");

        //void 从此请求中删除属性。
        //removeAttribute (java.lang.String name);

        //void 在此请求中存储属性。
        //setAttribute (java.lang.String name, java.lang.Object o);

        //void 覆盖此请求正文中使用的字符编码的名称。
        //setCharacterEncoding (java.lang.String env);


        sb.append("\r\n\r\n\r\n");

        //java.util.Enumeration返回此请求包含的所有标头名称的枚举。
        Enumeration e = request.getHeaderNames();
        sb.append("返回此请求包含的所有标头名称的枚举:\r\n");
        while (e.hasMoreElements()) {
            sb.append("=====================================\r\n");
            String key = (String) e.nextElement();

            //java.lang.String以a的形式返回指定请求标头的值String。
            //request.getHeader(java.lang.String name)

            //java.util.Enumeration返回指定请求头作为的所有值Enumeration的String对象。
            //request.getHeaders(java.lang.String name);

            //int返回指定的请求标头的值作为int。
            //request.getIntHeader(java.lang.String name);
            String value = request.getHeader(key);
            sb.append(key + ":" + value + "\r\n");
        }


        sb.append("\r\n\r\n\r\n");
        sb.append(Utils.requestCookiesToString(request));

        return sb.toString();
    }



    static public String requestCookiesToString(HttpServletRequest request) {
        StringBuilder sb =new StringBuilder();

        //Cookie[]返回一个数组，其中包含Cookie 客户端使用此请求发送的所有对象。
        sb.append("其中包含Cookie 客户端使用此请求发送的所有对象:" + request.getCookies() + "\r\n");
        Cookie[] cookies = request.getCookies();
        if ( cookies!=null) {
            for (Cookie c : cookies) {
                sb.append("=====================================\r\n");
                //java.lang.String返回描述此cookie用途的注释，或者 nullcookie是否没有注释。
                sb.append("\t描述此cookie用途的注释:" + c.getComment() + "\r\n");
                //java.lang.String返回为此cookie设置的域名。
                sb.append("\tcookie设置的域名:" + c.getDomain() + "\r\n");
                //int返回cookie的最大年龄，以秒为单位指定。默认情况下，-1指示cookie将持续存在直到浏览器关闭。
                sb.append("\tcookie的最大年龄:" + c.getMaxAge() + "\r\n");
                //java.lang.String返回cookie的名称。
                sb.append("\tcookie的名称:" + c.getName() + "\r\n");
                //java.lang.String返回浏览器返回此cookie的服务器上的路径。
                sb.append("\t浏览器返回此cookie的服务器上的路径:" + c.getPath() + "\r\n");
                //booleantrue如果浏览器仅通过安全协议发送cookie，如果浏览器可以使用任何协议发送cookie，则为false。。
                sb.append("\t浏览器仅通过安全协议发送cookie:" + c.getSecure() + "\r\n");
                //java.lang.String返回cookie的值。
                sb.append("\tcookie的值:" + c.getValue() + "\r\n");
                //int返回此cookie符合的协议版本。
                sb.append("\t此cookie符合的协议版本:" + c.getVersion() + "\r\n");
            }
        }
        return  sb.toString();
    }
}
