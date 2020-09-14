FROM jboss/wildfly
ADD your-awesome-app.war /opt/jboss/wildfly/standalone/deployments/ 
USER root
RUN chown jboss:jboss /opt/jboss/wildfly/standalone/deployments/*
USER jboss