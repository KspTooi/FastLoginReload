FastLoginReload
======
"一个强大的~~轻量级~~登录插件!"<br>
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

##MAVEN聚合工程:  

* DAL------------->数据交互/持久化
* ENTITY-------->实体模块
* PROCESS---->主业务模块
* SECURE------>安全模块
* UTIL------------>保障模块

##外部框架与库:

SpringBoot + Hibernate + Sqlite/Mysql/Redis




以下介绍已过期,请勿作参考.
======

特性
======
FastLogin是一个~~非常轻量化~~的登录插件,和同类插件比起来,它~~非常轻量化,~~配置简单易上手.命令少,节约内存与CPU开销,也没有许多无用的设置与功能选项,这些特点使它非常适用于中小型服务器。<br>

* 轻量化 配置简单<br>
* 运行速度快<br>
* 不支持权限组<br>
* 支持MD5加密算法<br>
* 支持密码明文存储<br>
* 支持使用.gd文件和Mysql数据库<br>
* 可以自定义玩家加入退出消息<br>
* 能够有效防止影分身BUG<br>
* 支持限制单IP注册上限制<br>
* 可以防止机器人压测<br>
* 支持未登录状态下的OP与创造保护<br>
* 支持未登录失明 和登录后产生粒子特效<br>
* 支持中文名. 并兼容自定义正则表达式匹配玩家名<br>
* 可以编写你自己的语言文件<br>

命令
====
* [例子:FastLogin 命令](https://github.com/ishiyamasayuri/FastLogin/blob/master/docs/Commands.md)

权限
====
不支持权限组

配置文件
====
* [例子:FastLogin 配置文件](https://github.com/ishiyamasayuri/FastLogin/blob/master/docs/config.md)

前置
====
* [前置依赖GeneralDataCoreV6](https://github.com/ishiyamasayuri/FastLogin/tree/master/Depend)

