FROM openjdk:11-jre
RUN mkdir app
ARG JAR_FILE
ADD /target/${JAR_FILE} /app/ecommerce-pedidos.jar
EXPOSE 8084
WORKDIR /app
ENTRYPOINT java -jar ecommerce-pedidos.jar