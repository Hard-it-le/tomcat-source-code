package com.mini.tomcat.servlet;

import com.mini.tomcat.http.Request;
import com.mini.tomcat.http.Response;

/**
 * @Author yujiale
 * @Date 2022/8/8 21:35
 * @Description TODO
 **/
public interface Servlet {

    /**
     * 初始化 servlet
     *
     * @throws Exception
     */
    void init() throws Exception;

    /**
     * 销毁客户端
     *
     * @throws Exception
     */
    void destory() throws Exception;

    /**
     * service 实现
     *
     * @param request req
     * @param response res
     * @throws Exception
     */
    void service(Request request, Response response) throws Exception;
}
