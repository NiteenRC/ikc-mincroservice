FROM java:8
VOLUME /tmp
ADD /target/category-service-0.0.1-SNAPSHOT.jar category-service-0.0.1-SNAPSHOT.jar
EXPOSE 8081
RUN bash -c 'touch /category-service-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java", "-jar", "/category-service-0.0.1-SNAPSHOT.jar"]