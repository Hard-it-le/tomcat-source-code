package com.mini.tomcat.util;

/**
 * @Author yujiale
 * @Date 2022/8/8 20:15
 * @Description http 协议工具类，主要提供响应头信息，这里只提供200和404情况
 **/
public class HttpProtocolUtil {


    /**
     * 响应吗 200 提供请求头信息
     *
     * @param contentLength 内容长度
     * @return 请求头信息
     */
    public static String getHttpHeader200(long contentLength) {
        return " HTTP/1.1 200 OK \n" + " Content-Type: text/html \n" + " Content-Length: " + contentLength + " \n" + "\r\n";
    }


    /**
     * 响应编码 404 提供请求头信息（包含数据内容）
     *
     * @return 返回数据类型
     */
    public static String getHttpHeader404() {
        String str404 = " <h1>404 not found</h1>";
        return " HTTP/1.1 404 NOT Found \n" +
            " Content-Type: text/html \n" +
            " Content-Length: " +
            str404.getBytes().length + "\n" + "\r\n" + str404;
    }

}
