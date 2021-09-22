From openjdk:11
copy ./target/spring-boot-cart-app-1.0.jar spring-boot-cart-app-1.0.jar
CMD ["java","-jar","spring-boot-cart-app-1.0.jar"]