FROM ubuntu:18.04

# Ubuntu'yu güncelle
RUN apt-get update -y

# Java'yı indir
RUN apt-get install openjdk-17-jre -y

# merhaba isimli klasöre geç yoksa da oluştur. Bundan sonra bu klasörde çalış.
WORKDIR /merhaba

# Jar dosyasını merhaba klasörüne kopyala
COPY /target/web-app1.jar .

# Container başlatıldığında Java uygulamasının da başlamasını sağla
CMD ["java", "-jar", "web-app1.jar", "com.mtopgul.WebApp1Application"]