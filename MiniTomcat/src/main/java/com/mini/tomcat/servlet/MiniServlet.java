package com.mini.tomcat.servlet;

import com.mini.tomcat.http.Request;
import com.mini.tomcat.http.Response;
import com.mini.tomcat.util.HttpProtocolUtil;

import java.io.IOException;

/**
 * @Author yujiale
 * @Date 2022/8/8 21:41
 * @Description TODO
 **/
public class MiniServlet extends AbstractHttpServlet {
    @Override
    public void doGet(Request request, Response response) {
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String content = " <h1>MiniServlet doGet</h1>";
        try {
            response.output((HttpProtocolUtil.getHttpHeader200(content.getBytes().length) + content));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(Request request, Response response) {
        String content = " <h1>MiniServlet doPost</h1>";
        try {
            response.output((HttpProtocolUtil.getHttpHeader200(content.getBytes().length) + content));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() throws Exception {

    }

    @Override
    public void destory() throws Exception {

    }
}
