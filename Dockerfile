FROM tomcat:9.0.34-jdk8-openjdk
MAINTAINER luiggi_mendoza

COPY target/*.war $CATALINA_HOME/webapps/
COPY mssql-jdbc-8.2.2.jre8.jar $CATALINA_HOME/lib

#Para propósito de debug habilitar solo en desarrollo
ENTRYPOINT ["catalina.sh", "jpda", "run"]
