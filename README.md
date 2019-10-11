# pmit-bakstage-cloud

#### 项目简介
以spring-cloud全家桶的微服务基础框架搭建,同时集成各种框架,技术类的服务模块

#### 技术选型
spring-cloud Greenwich.SR1
spring-boot 2.1.7.RELEASE
spring-cloud-gateway
spring-cloud-eureka
spring-cloud-admin
spring-cloud-config
spring-cloud-fegin
spring-cloud-hystrix


#### 本地构建
* 1. Git clone 代码到本地
* 2. ideal 右下角 checkout as 到自己的分支
* 3. ideal 右边栏点开maven  点击刷新 会自动导入项目依赖(建议设置本地maven,同时加入阿里镜像,导入速度 会快很多)
* 4. idea打开后右下角会有RunDashboard的提示,选择打开.如果没有效果则需要修改.idea/workspace.xml文件中<component name="RunDashboard">标签的属性然后在idea下面的标签页下面有RunDashboard
```xml
	<option name="configurationTypes">
      <set>
        <option value="SpringBootApplicationConfigurationType" />
      </set>
    </option>
```
* 4. 核心模块pmit-service-eureka,运行默认监听8761端口

#### 技术架构
* 基于spring cloud全家桶技术构建,同时加入redis,rabbitmq
× 给予docker容器化运行 



#### FAQ
* 1，项目启动先启动pmit-service-eureka，再启动其他的模块，启动好之后打开localhost:8761 可以查看所有的服务是不是已经注册到注册中心
* 2，提交代码的时候不要提交ideal的配置文件
* 3，依赖导入完成后，右上角如果没有启动实例名，先给项目设置JDK 1.8
* 4. 各个模块的情况
```markdown
* admin     ---已完成，集成到两个模块，因为使用这个监控需要用到security 依赖，可能会导致接口访问被拦截等错误，所以需要观察一段时间
* eureka    ---已完成 可以使用 可以优化
* ribbon    ---已完成 可以测试
* gateway   ---spring cloud gateway 网关组件 
* oauth     ---服务的检权模块，暂时只有登录接口

* communal
    * redis     ---已完成 可以作为 公共模块注入使用
    * rabbitMq  ---中间件 已完成 现使用的有邮件队列
    * email     ---邮件服务 已完成 后期可以加上缓存队列功能
    * common    ---公共模块 已完成
    * log       ---日志模块 未完成

* 8001   ---测试模块
* 8002    ---测试模块

``

#### 原则
* 1, 模块都应注册到eureka,maven中parent加入父类parent的标签内容,并在父pom中<modules>中加入该模块的标签

