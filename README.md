FastLoginReload
======
"一个强大的登录插件!"<br>
![image](https://github.com/90neko/FastLoginReload/blob/master/FastLoginR-LOGO-RE.png)
<br>

FastLoginR(FLR)是在原FastLogin的基础上进行重构的一个全新项目,相对于原FastLogin来说,FLR将会拥有更强大的功能与稳定性,与此同时它也继承了FastLogin轻量化的特性.它多样化的能力使其可以支持各种规模的服务器.

![image](https://img.shields.io/github/v/tag/KspTooi/FastLoginReload)
![image](https://img.shields.io/github/v/release/KspTooi/FastLoginReload)
![image](https://img.shields.io/github/downloads/KspTooi/FastLoginReload/total)  
![image](https://img.shields.io/github/commit-activity/m/KspTooi/FastLoginReload)
![image](https://img.shields.io/github/license/KspTooi/FastLoginReload?color=blue)




特性
======
* 不支持CatServer端!
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

* Starter---------->引导模块(Bukkit/Sponge)
* PROCESS---->主业务模块(命令处理)
* SECURITY---->安全模块
* DAL------------->数据交互/持久化
* UTIL------------->通用工具
* ENTITY-------->实体模块

外部框架与库:  
V1.2F ~~SpringBoot + Hibernate + Sqlite/Mysql/Redis~~  
V1.3F ~~Guice+Mybatis + SQLITE/MYSQL~~  
V1.3F.43 Guice+Mybatis + H2/MYSQL

开发版本号说明
======

(A)Alpha测试  
(F)快速迭代  
(S)集成测试  
(P)预发/测试  
(RE)发行版  
(L)提供旧版本服务端支持  




前一个版本
=====
[FastLogin](https://github.com/90neko/FastLogin)


