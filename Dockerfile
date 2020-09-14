FROM jboss/wildfly
ADD target/* /opt/jboss/wildfly/standalone/deployments/ 
USER root
RUN chown jboss:jboss /opt/jboss/wildfly/standalone/deployments/*
USER jboss