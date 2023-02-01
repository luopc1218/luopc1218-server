FROM openjdk:11.0.16

# 添加 Spring Boot 包
ADD target/luopc1218-server-0.0.1-SNAPSHOT.jar /luopc1218-server.jar

# 执行启动命令
ENTRYPOINT ["sh","-c","java -jar  /luopc1218-server.jar"]