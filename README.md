# pmit_bakstage_cloud

#### 介绍
微服务基础框架搭建

#### 软件架构
spring-cloud Greenwich.SR1
spring-boot 2.1.4.RELEASE

fegin 
eureka
hystrix
rribbon
zuul
config

#### 安装教程

1. 线上新建自己的分支
2. Git clone 代码到本地
3. ideal 右下角 checkout as 到自己的分支
4. ideal 右边栏点开maven  点击刷新 会自动导入项目依赖

#### 使用说明

* 项目现在只是很基础的一点，可以先试试ribbon和fegin，这两个包里面已经有demo，
* 项目启动先启动pmit-service-eureka，再启动其他的，启动好之后打开localhost:8761 可以查看所有的服务是不是已经注册到注册中心
* 提交代码的时候不要提交ideal的配置文件
* 依赖导入完成后，右上角如果没有启动实例名，先给项目设置JDK 1.8
