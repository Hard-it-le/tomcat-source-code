package com.mini.tomcat;

import com.mini.tomcat.http.Request;
import com.mini.tomcat.http.Response;
import com.mini.tomcat.servlet.AbstractHttpServlet;

import java.io.InputStream;
import java.net.Socket;
import java.util.Map;

/**
 * @Author yujiale
 * @Date 2022/8/8 23:03
 * @Description TODO
 **/
public class RequestProcessor extends Thread {

    private Socket socket;
    private Map<String, AbstractHttpServlet> servletMap;

    public RequestProcessor(Socket socket, Map<String, AbstractHttpServlet> servletMap) {
        this.socket = socket;
        this.servletMap = servletMap;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();

            // 封装Request对象和Response对象
            Request request = new Request(inputStream);
            Response response = new Response(socket.getOutputStream());

            // 静态资源处理
            if (servletMap.get(request.getUrl()) == null) {
                response.outputHtml(request.getUrl());
            } else {
                // 动态资源servlet请求
                AbstractHttpServlet httpServlet = servletMap.get(request.getUrl());
                httpServlet.service(request, response);
            }

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}