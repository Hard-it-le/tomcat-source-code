package com.mini.tomcat.http;

import com.mini.tomcat.util.HttpProtocolUtil;
import com.mini.tomcat.util.StaticResourceUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Author yujiale
 * @Date 2022/8/8 20:38
 * @Description 封装 Response 对象，依赖与 outputStream，提供核心方法，输出 html
 **/
public class Response {
    private OutputStream outputStream;


    public Response() {
    }

    public Response(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    /**
     * 使用输出流输出制定字符串
     *
     * @param content 内容
     * @throws IOException 异常
     */
    public void output(String content) throws IOException {
        outputStream.write(content.getBytes());
    }

    /**
     * @param path url，随后要根据url来获取到静态资源的绝对路径，进⼀步根据绝对路径读取该静态资源⽂件，最终通过输出流输出-----> classes
     */
    public void outputHtml(String path) throws IOException {
//获取静态资源⽂件的绝对路径
        String absoluteResourcePath = StaticResourceUtil.getAbsolutePath(path);
        //输⼊静态资源⽂件
        File file = new File(absoluteResourcePath);
        if (file.exists() && file.isFile()) {
            //读取静态资源⽂件，输出静态资源
            StaticResourceUtil.outputStaticResource(new FileInputStream(file), outputStream);
        } else {
            //输出404
            output(HttpProtocolUtil.getHttpHeader404(
                )
            )
            ;
        }
    }
}
