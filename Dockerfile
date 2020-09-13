FROM quay.io/wildfly/wildfly-centos7
 
#COPY target/* /opt/jboss/wildfly/standalone/deployments/

COPY /var/lib/jenkins/workspace/DOCKER_APP/target/dockerapp.war /opt/jboss/wildfly/standalone/deployments/ 