# 基础镜像
FROM openjdk:8-jre-alpine

# 设置JVM变量，可以通过外部修改JVM参数，如果将环境变量写在这里而非deployment.yaml上一定要限制Pod的资源，如果没限制就死翘翘
ENV JVM_OPTS "-Dserver.port=8080 \
-Dspring.profiles.active=prod \
-Dspring.cloud.nacos.config.namespace=deadb8c6-a7ac-4094-a6d6-6f57c092b4c7 \
-Dspring.cloud.nacos.discovery.namespace=deadb8c6-a7ac-4094-a6d6-6f57c092b4c7 \
-Dspring.cloud.nacos.server-addr=nacos-server.cloud-demo:8848"
# Java参数
ENV JAVA_OPTS "-Dfile.encoding=utf8 -Djava.security.egd=file:/dev/./urandom"

#同步时区
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' > /etc/timeZone;

COPY target/spring-cloud-consumer.jar /app.jar

EXPOSE 8080

# 启动文件服务
ENTRYPOINT ["/bin/sh","-c","java ${JVM_OPTS} ${JAVA_OPTS} -jar app.jar"]