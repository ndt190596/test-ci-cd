# Sử dụng image Java OpenJDK 17 slim làm base image
FROM openjdk:17-jdk-slim

# Đặt thư mục làm việc trong container
WORKDIR /app

# Tạo volume để lưu trữ dữ liệu tạm thời (thường dùng cho logs hoặc cache)
VOLUME /tmp

# Sao chép file JAR đã build vào container
COPY target/payment-service-0.0.1-SNAPSHOT.jar /app/payment-service.jar

# Cấu hình container để chạy ứng dụng Java
ENTRYPOINT ["java", "-jar", "/app/payment-service.jar"]

# Mở cổng 8080 để ứng dụng có thể được truy cập
EXPOSE 8080
