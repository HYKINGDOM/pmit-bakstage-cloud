# pmit-service-mail

### 模块介绍
该模块属于邮件模块,使用spring集成的mail的包,可以方便的使用其发送邮件,同时也保留之前项目的邮件发送方法

### 使用方法
* 本地测试需要修改激活的yml(dev,test,prod)
* 需要在pom.xml中引入该模块
```xml
    <groupId>com.galaxysoft.center.project</groupId>
    <artifactId>pmit-service-mail</artifactId>
    <version>0.0.1-SNAPSHOT</version>
```
* 由于已经交给spring进行管理所以只需要在使用该方法的类中自动注入
```java
    @Autowired
    private IMailService iMailService;
```
* IMailService中的api方法介绍,如不够用可以进行自定义发送方法
```java

    /**
	 * 发送纯文本
	 * @param mail
	 */
	 void send(EmailObject mail);

	/**
	 * 发送富文本可以加上图片和附件
	 * @param mail
	 */
	  void sendHtml(EmailObject mail);

	/**
	 * 模版发送 freemarker
	 * @param mail
	 */
	  void sendFreemarker(EmailObject mail);

```

* 选用方法后先实例化EmailObject实体类,按照类中的注释使用,不使用的可以不加数据

* 如需要加图片,文件和模板就要在resource/static/中按照分类文件夹中加入自定义文件

* 邮件发送使用的模板freemarker 如需自定义请自行百度