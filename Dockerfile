#FROM quay.io/wildfly/wildfly-centos7
 
#COPY target/* /opt/jboss/wildfly/standalone/deployments/



FROM jboss/wildfly

## copy your local .war file assumming that this dockerfile is in the same folder as the .war file.
COPY target/* /opt/jboss/wildfly/standalone/deployments/

## adding a user to your JBoss server. Modify the user name and password as needed
RUN /opt/jboss/wildfly/bin/add-user.sh admin passwod --silent