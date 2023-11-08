# base imaj olarak nginx resmi imajını kullanıyoruz --
FROM nginx:latest


# label ile de key value pair olarak bu imajla ilgili bilgileri giriyoruz. her iki talimat da imajın içindeki sistemle alakalı değil.
# her ikisi de imajın metadatasında saklanıyor. imajla alakali bilgiler.
LABEL maintainer="Muhammed Topgul @mtopgul" version="1.0" name="hello-docker"

# bir adet env variable tanımlıyoruz. Daha sonra bunu runtime'da değiştireceğiz
ENV KULLANICI="Dunyali"

# Uygulama depolarından mevcut paketlerin en son listesini çekip güncelliyoruz.
# debian-slim'de bir çok tool mevcut değil. Bizim curl kullanmamız gerektiği için curl kuruyoruz
RUN apt-get update && apt-get install curl -y

# nginx web sayfalarını /usr/share/nginx/html folder'ında barındırıyor. O nedenle bu folder'a geçiyoruz
WORKDIR /usr/share/nginx/html

# web sitemizin açılış sayfası olan Hello_docker.html dosyasını buraya kopyalıyoruz.
COPY hello_docker.html /usr/share/nginx/html

# sistemin düzgün çalıştığını ve nginx daemon'ının web sitesini publish etmekte bir sorun yaşamadığını test ediyoruz
HEALTHCHECK --interval=30s --timeout=10s --start-period=5s --retries=3 CMD curl -f http://localhost/ || exit 1

# bu imajdan container yaratıldığı zaman çalışmasını istediğimiz komutu buraya giriyoruz
# /usr/share/nginx/html klasörüne geçiyor ve sed aracılığıyla hello_docker.html dosyasının içerisindeki
# Kullanici kelimesini $KULLANICI env variable'ının değeriyle Hostname kelimesini de $HOSTNAME ile değiştiriyor ve
# dosyanın içeriğini index.html'e adlı yeni bir dosyaya yazıyoruz.
# ardından nginx daemon'ı çalıştırıyoruz
CMD sed -e s/Kullanici/"$KULLANICI"/ hello_docker.html > index1.html &&\
    sed -e s/Hostname/"$HOSTNAME"/ index1.html > index.html ;\
    rm index1.html hello_docker.html; nginx -g 'daemon off;'