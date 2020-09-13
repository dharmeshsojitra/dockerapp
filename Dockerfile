FROM quay.io/wildfly/wildfly-centos7
 
COPY target/* /opt/jboss/wildfly/standalone/deployments/