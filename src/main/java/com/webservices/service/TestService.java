package com.webservices.service;

import com.webservices.service.impl.TestServiceImpl;

import java.util.List;

/**
 * @desc 服务器接口
 * @author xiaostudy
 *
 */
public interface TestService {

    String getNumber(String number);

    List<TestServiceImpl.Article> getArticles();

}
