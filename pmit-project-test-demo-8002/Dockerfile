# 指定镜像
FROM openjdk:8u191-jdk-alpine3.9

# 维护者信息
MAINTAINER yihur@isoftstone

# 在新镜像内部执行的命令，比如安装一些软件、配置一些基础环境，可使用\来换行，当前设置是指定时区,&&支持多命令
RUN mkdir -p /pmit-project-test-demo-8002 && ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

# 设置工作目录
WORKDIR /pmit-project-test-demo-8002

# 设置端口
EXPOSE 8002

# 将文件复制到镜像中
ADD ./pmit-project-test-demo-8002/target/pmit-project-test-demo-8002-1.0-SNAPSHOT.jar  ./

CMD java -Djava.security.egd=file:/dev/./urandom -jar pmit-project-test-demo-8002-1.0-SNAPSHOT.jar


