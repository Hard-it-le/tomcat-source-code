package com.mini.tomcat.servlet;

import com.mini.tomcat.http.Request;
import com.mini.tomcat.http.Response;

/**
 * @Author yujiale
 * @Date 2022/8/8 21:36
 * @Description TODO
 **/
public abstract class AbstractHttpServlet implements Servlet {
    /**
     * get 方法
     * @param request req 请求
     * @param response res 返回
     */
    public abstract void doGet(Request request, Response response);

    /**
     * post 方法
     * @param request req 请求
     * @param response res 返回
     */
    public abstract void doPost(Request request, Response response);

    @Override
    public void service(Request request, Response response) throws Exception {
        if (" GET " .equalsIgnoreCase(request.getMethod())
        ) {
            doGet(request, response);
        } else {
            doPost(request, response);
        }
    }
}
