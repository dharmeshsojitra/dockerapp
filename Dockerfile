FROM quay.io/wildfly/wildfly-centos7
 
ADD target/* /opt/jboss/wildfly/standalone/deployments/

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-c", "standalone-full-poc.xml", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]