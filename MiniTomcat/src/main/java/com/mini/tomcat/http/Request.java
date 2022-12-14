package com.mini.tomcat.http;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author yujiale
 * @Date 2022/8/8 20:27
 * @Description 把请求信息封装为 Request 对象（根据InputSteam输⼊流封装）
 **/
public class Request {
    /**
     * 请求方式，get/post
     */
    private String method;

    /**
     * 路径
     */
    private String url;

    /**
     * 输入流，其他属性从输入流中解析出来
     */
    private InputStream inputStream;

    public Request() {
    }

    public Request(InputStream inputStream) throws IOException {

        this.inputStream = inputStream;

        int count = 0;
        while (count == 0) {
            count = inputStream.available();
        }

        byte[] bytes = new byte[count];
        inputStream.read(bytes);
        String inputStr = new String(bytes);

        String firstLineStr = inputStr.split("\\n")[0];

        String[] strings = firstLineStr.split("  ");

        this.method = strings[0];
        this.url = strings[1];

        System.out.println("=====>>method:" + method);
        System.out.println("=====>>url:" + url);
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}
