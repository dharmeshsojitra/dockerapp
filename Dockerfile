# Use latest Fedora image as the base
FROM centos:latest
MAINTAINER http://www.centos.org

LABEL Vendor="CentOS"
LABEL License=GPLv2
LABEL Version=8.2.0.Final


# Update base image
RUN yum -y update && yum clean all

# xmlstarlet is useful when modifying attributes/elements
# saxon can be used to execute configuration transformation using XSLT
# augeas is a great tool to edit any configuration files (XML too)
# bsdtar can be used to unpack zip files using pipes
RUN yum -y install java-1.8.0-openjdk.x86_64 java-1.8.0-openjdk-devel.x86_64 \ 
    augeas bsdtar shadow-utils && yum clean all

RUN yum -y install wget

# Set the WILDFLY_VERSION env variable
ENV WILDFLY_VERSION 16.0.0.Final
ENV JBOSS_HOME /opt/jboss/wildfly

USER root

# Add the WildFly distribution to /opt, and make wildfly the owner of the extracted tar content
# Make sure the distribution is available from a well-known place
RUN cd /tmp \
	&& groupadd -r jboss \
	&& useradd -r -g jboss -d /opt/wildfly -s /sbin/nologin wildfly \
	&& wget https://download.jboss.org/wildfly/16.0.0.Final/wildfly-16.0.0.Final.tar.gz \
    && tar xf wildfly-$WILDFLY_VERSION.tar.gz -C /opt \
    && ln -s /opt/$WILDFLY_VERSION /opt/wildfly \
    && rm wildfly-$WILDFLY_VERSION.tar.gz \
    && chown -RH jboss: ${JBOSS_HOME} \
    && chmod -R g+rw ${JBOSS_HOME}

# Ensure signals are forwarded to the JVM process correctly for graceful shutdown
ENV LAUNCH_JBOSS_IN_BACKGROUND true

USER jboss

# Expose the ports we're interested in
EXPOSE 8080

ADD target/docker-demo-0.0.1-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/

# Set the default command to run on boot
# This will boot WildFly in the standalone mode and bind to all interface
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]