<html>
<head>
  <title>webservices2 方式一：生成类方式</title>
</head>
<body>
1、服务器端
服务器接口Test_service.java
package com.xiaostudy;

/**
* @desc 服务器接口
* @author xiaostudy
*
*/
public interface Test_service {

public String getNumber(String number);

}
服务器接口实现类Test_serviceImpl.java
package com.xiaostudy;

import javax.jws.WebService;

/**
* @desc 服务器接口实现类
* @author xiaostudy
*
*/
@WebService
public class Test_serviceImpl implements Test_service {

/**
* @desc 处理客户端的数据，并返回数据
* @param number 参数
* @return String 返回数据类型
*/
@Override
public String getNumber(String number) {

System.out.println("我服务器端执行了。。。。");

return number+"_后面添加的";
}

}
开始服务器类MyService.java
package com.xiaostudy;

import javax.xml.ws.Endpoint;

/**
* @desc 开始服务器类
* @author xiaostudy
*
*/
public class MyService {

public static void main(String[] args) {

Endpoint.publish("http://127.0.0.1:9999/number", new Test_serviceImpl());

}

}
接下来运行开始服务器

输入地址看看是否连通

2、编写客服端
通过wsim命令生成服务器的描述文件，进入到另新建一个项目的src目录下，然后执行下面这个命令
wsimport -s . http://127.0.0.1:9999/number?wsdl

注：如果发生以下提示（wsimport 不是内部或外部命令，也不是可运行的程序或批处理文件）
解决方法，参考文章：https://blog.csdn.net/jiudihanbing/article/details/52382508
然后就会看到自动生成的文件

然后编写客户端类，传数据，并返回数据

最后执行客户端，看看结果

PS：参考地址 https://www.cnblogs.com/xiaostudy/p/9568884.html

</body>
</html>
