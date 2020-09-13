FROM quay.io/wildfly/wildfly-centos7
 
ADD target/dockerapp.war /opt/jboss/wildfly/standalone/deployments/