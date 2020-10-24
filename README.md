FastLoginReload
======
"一个强大的登录插件!"<br>
![image](https://github.com/ishiyamasayuri/FastLogin/blob/master/FastLogin_LogoRE.png)
<br>

FastLoginR(FLR)是在原FastLogin的基础上进行重构的一个全新项目,相对于原FastLogin来说,FLR将会拥有更强大的功能与稳定性,与此同时它也继承了FastLogin轻量化的特性.它多样化的能力使其可以支持各种规模的服务器.

特性
======
* 支持高版本服务端
* 支持Sponge端!
* 运行高效,资源占用少.
* 可以通过电子邮箱找回密码
* 支持多种密码加密储存算法
* 支持Sqlite Mysql
* 能够限制单IP注册数上限
* 保存玩家退出位置.
* 可以自定义玩家加入与退出消息
* 支持未登录状态下的OP与创造保护

基本架构
======

MAVEN聚合工程:  

* DAL------------->数据交互/持久化
* ENTITY-------->实体模块
* PROCESS---->主业务模块
* SECURE------>安全模块
* UTIL------------>保障模块

外部框架与库:  
SpringBoot + Hibernate + Sqlite/Mysql/Redis

前一个版本
=====
[FastLogin](https://github.com/90neko/FastLogin)
