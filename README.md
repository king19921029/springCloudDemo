java基础

关键字
Pricate 私有的
Protected 受保护的
Public 公共的
Class 类
Extends 扩充，继承
implements 实现（接口）
Interface 接口

基本数据类型
整数类型：byte，short，int，long
浮点数类型：float，double
字符类型：char
布尔类型：boolean 
byte（数据类型是8位，变量占用的空间只有 int 类型的四分之一）
short（16位，int的二分之一）
Int （32位）
Long （64位）
Float（单精度浮点，32位）
Double（双精度，64位）

Boolean（布尔）

Char（unicode字符 16位）

String（字符串）

引用类型
对象、数组
Integer是一个类继承于 Object 类

常量（final）大写规范
类变量：独立于方法之外的变量，用 static 修饰。








应用技术
springcloud -java架构
Mybatis -数据库服务组件
maven -组件管理
Mysql- 关系型数据库
rediss- 内存型数据库（缓存数据、例如token等）
Nginx
Spring Security -安全架构
log4j 日志服务


项目运行前需要cd到nacos/bin目录执行sh startup.sh -m standalone
项目关联
Consumer (接口发起层，表示前台，服务消费者)
	pom.xml—主入口、maven组件初始化文件
	.iml 系统配置文件自动生成
	src/mian/java 主要代码目录
		com.yuanqi主要代码目录
		comm 公用类
		controller 请求转发，接受页面参数传递给service，接到返回值，再传给页面。
		remote 接口定义层
		secuity 设置请求头header跨域等配置
		
	src/mian/resources/application.properties 服务名称、端口、地址与p层关联的主要文件

Provider(接受发起数据返回层，表示后台，服务提供者)
	pom.xml—同上
	.iml —同上
	src/mian/java/com.yuanqi 主要代码目录
		comm 公用类
		controller 请求转发，接受页面参数传递给service，接到返回值，再传给页面。
		dao sql语句定义类
		service   服务层对dao进行封装
		service/impl  接口实现层
		secuity 设置请求头header跨域等配置
		
	src/mian/resources/application.properties 服务名称、端口、地址与c层关联的主要文件
	src/mian/resources/mybatis.mapper sql语句数据库操作

	
DAO层：
DAO层叫数据访问层，全称为data access object，属于一种比较底层，比较基础的操作，具体到对于某个表的增删改查，也就是说某个DAO一定是和数据库的某一张表一一对应的，其中封装了增删改查基本操作，建议DAO只做原子操作，增删改查。

Service层：
Service层叫服务层，被称为服务，粗略的理解就是对一个或多个DAO进行的再次封装，封装成一个服务，所以这里也就不会是一个原子操作了，需要事物控制。

Controler层：
Controler负责请求转发，接受页面过来的参数，传给Service处理，接到返回值，再传给页面。

总结：
个人理解DAO面向表，Service面向业务。后端开发时先数据库设计出所有表，然后对每一张表设计出DAO层，然后根据具体的业务逻辑进一步封装DAO层成一个Service层，对外提供成一个服务。

	

特别注意！！！
@依赖
public class “xxx”{

}

定义类或者接口或者服务的时候一定记得签名+@依赖


从页面发起一个ajax请求到成功回掉接受数据过程：
1.c层contorller其中某个方法(/adminUse/v1/login.login())
2.c层remote匹配（/adminUse/v1/login 然后发送p层）
3.到达p层contorller(p)关联至impl来实现
4.数据来源于dao层(但第四步是主要返回给前端数据)
5.impl调用dao层方法。dao暴露
6.ProviderApplication开启服务时就扫码dao然后匹配mybatis.mapper的某个文件来执行sql语句


名词解释 注解

@RestController  在提供json接口时需要的配置操作再也不需要自己配置了。
是@Controller、@ResponseBody的结合


@Controller
@ResponseBody
public class MyController { }

@RestController
public class MyRestController { }

 CoreServiceRemote 
其功能就是接收前端请求，根据前端请求中的服务接口名、方法名、参数数组去调用bean容器中的对应接口的方法，并返回json格式的数据到前端。
