package com.webservices.testmain;

import com.webservices.service.impl.TestServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * @desc 开始服务器类
 * @author xiaostudy
 *
 */
public class MyService {

    public static void main(String[] args) {

        Endpoint.publish("http://127.0.0.1:9999/number", new TestServiceImpl());

    }

}