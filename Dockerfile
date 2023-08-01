FROM menesk2m/rockylinux9.1:tomcat
# Maintainer
LABEL ORGANIZATION="UNIXCLOUDTRAININGS"
# copy war file on to container 
COPY ./build/libs/my-app-1.0-SNAPSHOT.jar /opt/tomcat/tomcat10/webapps
