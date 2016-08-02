FROM smartcosmos/service
MAINTAINER SMART COSMOS Platform Core Team

ADD target/smartcosmos-*.jar  /opt/smartcosmos/smartcosmos-event-listener.jar

CMD ["/opt/smartcosmos/smartcosmos-event-listener.jar"]
