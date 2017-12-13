FROM java:8 
MAINTAINER docker_user newbreach@live.com
VOLUME ["/abciconfig"]
ADD sabci-1.0.jar app.jar
EXPOSE 46658
RUN bash -c "echo /app.jar"
ENTRYPOINT ["java","-cp","/app.jar","com.yunfeng.sabci.Dummy"]
