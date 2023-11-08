# 1. Adım: JDK ile image oluştur ve derle.
FROM openjdk:8-jdk-alpine AS derleyici
COPY /src /target
WORKDIR /target
RUN javac Hello.java

# 2. Adım: 1. Adımda image içinde derlenen dosyaları yeni image kopyala ve JRE ile çalıştır.
FROM openjdk:8-jre-alpine
WORKDIR /uygulama
COPY --from=derleyici /target .
ENTRYPOINT ["java", "Hello"]
