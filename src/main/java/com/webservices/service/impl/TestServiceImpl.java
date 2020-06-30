package com.webservices.service.impl;

import com.webservices.service.TestService;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * @desc 服务器接口实现类
 *
 */
@WebService
public class TestServiceImpl implements TestService {
    /**
     * @desc 处理客户端的数据，并返回数据
     * @param number 参数
     * @return String 返回数据类型
     */
    public String getNumber(String number) {

        System.out.println("我服务器端执行了。。。。");

        return number+"_后面添加的";
    }

    public List<Article> getArticles() {
        List<Article> articles = new ArrayList<Article>();

        Article article = new Article();
        article.setUrl("文章的url-001");
        article.setAuthor("文章的作者-001");
        article.setTitle("文章的标题-001");
        article.setSummary("文章的摘要-001");
        articles.add(article);

        Article article2 = new Article();
        article2.setUrl("文章的url-002");
        article2.setAuthor("文章的作者-002");
        article2.setTitle("文章的标题-002");
        article2.setSummary("文章的摘要-002");
        articles.add(article2);
        return articles;
    }

    public  static class Article{
        private String url;
        private String title;
        private String summary;
        private String author;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }
    }
}
