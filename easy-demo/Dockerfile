# 基础镜像
FROM openjdk:8-jre-alpine

# 设置JVM变量，可以通过外部修改JVM参数，如果将环境变量写在这里而非deployment.yaml上一定要限制Pod的资源，如果没限制就死翘翘
ENV JVM_OPTS "-server.port=8080"

# Java参数
ENV JAVA_OPTS "-Dfile.encoding=utf8 -Djava.security.egd=file:/dev/./urandom"

#同步时区
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' > /etc/timeZone;

COPY target/easy-demo.jar /app.jar

EXPOSE 8080

# 启动文件服务
ENTRYPOINT ["/bin/sh","-c","java ${JVM_OPTS} ${JAVA_OPTS} -jar app.jar"]

# https://cloud.tencent.com/developer/article/1932751
# https://blog.csdn.net/a772304419/article/details/118105136
# https://help.aliyun.com/document_detail/383255.html#section-vb6-hhy-858

#-XX:+UseContainerSupport
#-XX:InitialRAMPercentage=70.0
#-XX:MaxRAMPercentage=70.0
#-XX:+PrintGCDetails
#-XX:+PrintGCDateStamps
#-Xloggc:/home/admin/nas/gc-${POD_IP}-$(date '+%s').log
#-XX:+HeapDumpOnOutOfMemoryError
#-XX:HeapDumpPath=/home/admin/nas/dump-${POD_IP}-$(date '+%s').hprof