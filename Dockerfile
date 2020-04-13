FROM tomcat:9.0.34-jdk8-openjdk
MAINTAINER luiggi_mendoza

COPY target/*.war $CATALINA_HOME/webapps/
