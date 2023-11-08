###### Docker Tips
<details>
  <summary>Container 101</summary>

> >- **Docker CLI**<br/>
>  - `docker` _Docker üzerinde kullanabileceğimiz tüm komutları listeler._<br/><br/>
>  - `docker info` _Docker hakkında genel bilgileri verir._<br/><br/>
>  - `docker container --help` _Docker container komutu ile birlikte kullanabileceğim komutları listeler._<br/><br/>
>  - `docker image --help` _Docker image komutu ile birlikte kullanabileceğim komutları listeler._<br/><br/>
>  - `docker image rm --help` _Docker image rm komutu ile birlikte kullanabileceğim komutları listeler._<br/>

> >- **Container Temelleri**<br/>
>  - `docker container run --name new_app1 mtopgul/app1` _Docker container oluştur ve çalıştır._<br/><br/>
>  - `docker run -p 8085:8085 --name web_app mtopgul/web-app1` _Docker container oluştur ve çalıştır._<br/><br/>
>  - `docker run -d -p 8085:8085 --name web_app mtopgul/web-app1` _Docker container oluştur ve arka planda çalıştır._<br/><br/>
>  - `docker run --rm mtopgul/web-app1` _Docker container oluştur, çalıştırır ve container durduğunda containeri siler._<br/><br/>
>  - `docker container ls -a` _Docker container oluştur ve çalıştır._<br/><br/>
>  - `docker logs <CONTAINER_ID, CONTAINER_NAME> -f` _Container loglarını gösterir._<br/><br/>
>  - `docker start <CONTAINER_ID, CONTAINER_NAME> -f` _Container'ı çalıştırır._<br/><br/>
>  - `docker stop <CONTAINER_ID, CONTAINER_NAME> -f` _Container'ı durdurur._<br/><br/>
>  - `docker container rm <CONTAINER_ID> <CONTAINER_ID> ... -f` _Containerları siler._<br/><br/>
>  - `docker rmi <CONTAINER_ID> <CONTAINER_ID> ... -f` _Containerları siler._<br/><br/>
>  - `docker container prune` _Çalışmayan tüm containerleri siler._<br/><br/>
>  - `docker image prune -a` _Tüm imageları siler._<br/><br/>
>  - `docker exec -it <CONTAINER_NAME, CONTAINER_ID> sh` _Continer içerisinde komut satırı açar._<br/><br/>

> >- **Docker Volume**<br/>
>  - `docker volume ls` _Volumeleri listeler._<br/><br/>
>  - `docker volume rm <VOLUME_NAME>` _Volumeu siler._<br/><br/>
>  - `docker volume prune` _Kullanılmayan volumeleri siler._<br/><br/>
>  - `docker volume create <VOLUME_NAME>` _Volumeleri oluşturur._<br/><br/>
>  - `docker volume inspect <VOLUME_NAME>` _Volume detaylarını gösteririr._<br/><br/>
>  - `docker run -v <VOLUME_NAME>:/<NEW_FILE> -p 8085:8085 --name web_app mtopgul/web-app1` _Image oluşturur ve volume ile bağlar._<br/><br/>
>  - `docker run -v <VOLUME_NAME>:/<NEW_FILE>:ro -p 8085:8085 --name web_app mtopgul/web-app1` _Image oluşturur ve volume ile bağlar. Burda volume sadece READ ONLY'dir yazma işlemi yapılamaz._<br/><br/>

> >- **Bind Mounts**<br/>
>  - `docker container run -d -p 80:80 -v C:\docker-staff\container101\website:/usr/share/nginx/html --name my_web nginx` _Bind Mounts._
</details>

<details>
  <summary>Container 102</summary>

> >- **Network**<br/>
>  - `CTRL + PQ` _Container ile konsol bağlantısını keser ama containeri kapatmaz._<br/><br/>
>  - `dokcer network ls` _Networkleri listeler._<br/><br/>
>  - `dokcer network inspect <NETWORK_NAME>` _Network detaylarını gösterir._<br/><br/>
>  - `docker container run -d -p 8080:8080 --net host --name <CONTAINER_NAME> <IMAGE_NAME>` _Conteineri host networküne bağlar._<br/><br/>
>  - `docker network create <NETWORK_NAME> --driver bridge` _Yeni bir network oluşturur._<br/><br/>
>  - `docker network create <NETWORK_NAME> --driver=bridge --subnet=10.10.0.0/16 --ip-range=10.10.10.0/24 --gateway=10.10.10.10` _Özelleştirilmiş bağlantı ayarlı bir network oluşturur._<br/><br/>
>  - `docker network connect <NETWORK_NAME> <CONTAINER_ID>` _Containeri yeni bir networke bağlar._<br/><br/>
>  - `docker network disconnect <NETWORK_NAME> <CONTAINER_ID>` _Containeri networkten çıkarır._<br/><br/>
>  - `docker network rm <NETWORK_NAME>` _Networkü siler._<br/><br/>

> >- **Logging**<br/>
>  - `docker logs <CONTAINER_ID>` _Container loglarını gösterir._<br/><br/>
>  - `docker logs <CONTAINER_ID> -f` _Container loglarını gösterir ve konsolu canlı olarak takip et._<br/><br/>
>  - `docker logs <CONTAINER_ID> --since 5m` _Container loglarını (Son 5 dk) gösterir._<br/><br/>
>  - `docker logs <CONTAINER_ID> --until 5m` _Container loglarını (Son 5 dk hariç) gösterir._<br/><br/>
>  - `docker logs <CONTAINER_ID> -t` _Container loglarını başında oluşturulduğu tarih ile birlikte gösterir._<br/><br/>
>  - `docker logs <CONTAINER_ID> --tail 2` _Son 2 satır container logunu gösterir._<br/><br/>

> >- **Stats and Top**<br/>
>  - `docker top <CONTAINER_ID>` _Container PID, TIME, CMD gibi verilerini gösterir._<br/><br/>
>  - `docker stats` _Tüm containerın hafıza kullanım bilgilerini gösterir._<br/><br/>
>  - `docker stats <CONTAINER_ID>` _Containerların hafıza kullanım bilgilerini gösterir._<br/><br/>

> >- **CPU and Memory Limits**<br/>
>  - `docker container run -d -p 8080:8080 --name w001 --memory=100m <IMAGE_NAME>` _Containera maximum memory limiti atar._<br/><br/>
>  - `docker container run -d -p 8080:8080 --name w001 --memory=100m --memory-swap=200m <IMAGE_NAME>` _Containera maximum 
      memory limiti ve swap alanı atar. Böylece eğer containerin memorysi dolsa bile çökmez, swap alanını kullanabilir._<br/><br/>
>  - `docker container run -d -p 8080:8080 --name w01 --cpus="1.5" <IMAGE_NAME>` _Bilgisayar içinde bulunan çekirdeklerden sadece 1.5 tanesini kullanabileceğini belirtir._<br/><br/>
>  - `docker container run -d -p 8080:8080 --name w01 --cpuset-cpus="0,3" <IMAGE_NAME>` _Bilgisayar içinde bulunan çekirdeklerden 0. ve 3. numaralı çekirdekleri kullanabileceğini belirtir._<br/><br/>

> >- **Environment Variables**<br/>
>  - `Get-ChildItem Env:` _Windows'ta tüm ortam değişkenlerini gösterir._<br/><br/>
>  - `$Env:JAVA_HOME` _Windows'ta isme göre ortam değişkenlenini gösterir._<br/><br/>
>  - `$Env:test="JAVA DEV"` _Windows'ta yeni bir ortam değişkenlenini oluşturur._<br/><br/>
>  - `printenv` _Linux'ta tüm ortam değişkenlerini gösterir._<br/><br/>
>  - `echo $JAVA_HOME` _Linux'ta isme göre ortam değişkenlenini gösterir._<br/><br/>
>  - `export test="JAVA DEV"` _Linux'ta yeni bir ortam değişkenlenini oluşturur._<br/><br/>
>  - `docker container run --env USER=MUHAMMED <CONTAINER_ID>` _Containera yeni bir ortam değişkeni ekler._<br/><br/>
>  - `docker container run --env TEMP <CONTAINER_ID>` _Bulunduğu makina üzerinde ki ortam değişkenini containera ortam değişkeni olarak ekler._<br/><br/>
>  - `docker container run --env-file .\env-list.txt <CONTAINER_ID>` _Dosya içerisinde bulunan değerleri containera ortam değişkeni olarak ekler._<br/><br/>

</details>


<details>
  <summary>Image</summary>

> >- **Dockerfile**<br/> 
> - `docker image build -t <IMAGE_NAME> .` _Dockerfile'dan image üretir._<br/><br/>
> - `docker history <IMAGE_NAME> .` _Image'ın katmanlarını gösterir._<br/><br/>
>>***Dockerfile Parametreleri***
>> - `FROM` Oluşturulacak imajın hangi imajdan oluşturulacağını belirten talimat. Dockerfile içerisinde geçmesi mecburi tek talimat budur. Mutlaka olmalıdır.
>>  - `Ör`: FROM ubuntu:18.04<br/><br/>
>> - `LABEL` İmaj metadata’sına key=value şeklinde değer çiftleri eklemek için kullanılır. Örneğin team=development şeklinde bir etiket eklenerek bu imajın development ekibinin kullanması için yaratıldığı belirtilebilir.
>>  - `Ör`: LABEL version:1.0.8<br/><br/>
>> - `RUN` İmaj oluşturulurken shell’de bir komut çalıştırmak istersek bu talimat kullanılır. Örneğin apt-get install xxx ile xxx isimli uygulamanın bu imaja yüklenmesi sağlanabilir.
>>  - `Ör`: RUN apt-get update<br/><br/>
>> - `WORKDIR` cd xxx komutuyla ile istediğimiz klasöre geçmek yerine bu talimat kullanılarak istediğimiz klasöre geçer ve oradan çalışmaya devam ederiz.
>>  - `Ör`: WORKDIR /usr/src/app<br/><br/>
>> - `USER` gireceğimiz komutları hangi kullanıcı ile çalıştırmasını istiyorsak bu talimat ile onu seçebiliriz.
>>  - `Ör`: USER poweruser<br/><br/>
>> - `COPY` İmaj içine dosya veya klasör kopyalamak için kullanırız
>>  - `Ör`: COPY /source /user/src/app<br/><br/>
>> - `ADD` COPY ile aynı işi yapar yani dosya ya da klasör kopyalarsınız. Fakat ADD bunun yanında dosya kaynağının bir url olmasına da izin verir. Ayrıca ADD ile kaynak olarak bir .tar dosyası belirtilirse bu dosya imaja .tar olarak sıkıştırılmış haliyle değil de açılarak kopyalanır.
>>  - `Ör`: ADD https://wordpress.org/latest.tar.gz /temp<br/><br/>
>> - `ENV` Imaj içinde environment variable tanımlamak için kullanılır
>>  - `Ör`: ENV TEMP_FOLDER="/temp"<br/><br/>
>> - `ARG` ARG ile de variable tanımlarsınız. Fakat bu variable sadece imaj oluşturulurken yani build aşamasında kullanılır. Imajın oluşturulmuş halinde bu variable bulunmaz. ENV ile imaj oluşturulduktan sonra da imaj içinde olmasını istediğiniz variable tanımlarsınız, ARG ile sadece oluştururken kullanmanız gereken variable tanımlarsınız.
>>  - `Ör`: ARG VERSION:1.0<br/><br/>
>> - `VOLUME` Imaj içerisinde volume tanımlanamızı sağlayan talimat. Eğer bu volume host sistemde varsa container bunu kullanır. Yoksa yeni volume oluşturur.
>>  - `Ör`: VOLUME /myvol<br/><br/>
>> - `EXPOSE` Bu imajdan oluşturulacak containerların hangi portlar üstünden erişilebileceğini yani hangi portların yayınlanacağını bu talimatla belirtirsiniz.
>>  - `Ör`: EXPOSE 80/tcp<br/><br/>
>> - `ENTRYPOINT` Bu talimat ile bir containerın çalıştırılabilir bir uygulama gibi ayarlanabilmesini sağlarsınız.
>>  - `Ör`: ENTRYPOINT ["/usr/sbin/apache2ctl", "-D", "FOREGROUND"]<br/><br/>
>> - `CMD` Bu imajdan container yaratıldığı zaman varsayılan olarak çalıştırmasını istediğiniz komutu bu talimat ile belirlersiniz.
>>  - `Ör`: CMD java merhaba<br/><br/>
>> - `HEALTHCHECK` Bu talimat ile Docker'a bir konteynerin hala çalışıp çalışmadığını kontrol etmesini söylebiliriz. Docker varsayılan olarak container içerisinde çalışan ilk processi izler ve o çalıştığı sürece container çalışmaya devam eder. Fakat process çalışsa bile onun düzgün işlem yapıp yapmadığına bakmaz. HEALTHCHECK ile buna bakabilme imkanına kavuşuruz.
>>  - `Ör`: HEALTHCHECK --interval=5m --timeout=3s CMD curl -f http://localhost/ || exit 1<br/><br/>
>> - `SHELL` Dockerfile'ın komutları işleyeceği shell'in hangisi olduğunu belirtiriz. Linux için varsayılan shell ["/bin/sh", "-c"],Windows için ["cmd", "/S", "/C"]. Bunları SHELL talimatı ile değiştirebiliriz.
>>  - `Ör`: SHELL ["powershell", "-command"]<br/><br/>
>
> >- **Add vs Copy**<br/>
> - `COPY` _ile sadece mevcut bir dosyayı image içine atabiliriz._<br/><br/>
> - `COPY` _ile eğer sıkıştırılmış bir dosya atarsak **tar, zip. vb.** dosyayı açmadan atar._<br/><br/>
> - `ADD` _ile mevcut dosyaları ve urlden alınan dosyaları image içine atabiliriz._<br/><br/>
> - `ADD` _ile eğer sıkıştırılmış bir dosya atarsak **tar, zip. vb.** dosyayı açarak atar._<br/><br/>
> - `ADD` _ile urlden sıkıştırılmış bir dosya atarsak **tar, zip. vb.** dosyayı **açmadan** atar._<br/><br/>
> 
> >- **ENTRYPOINT vs CMD**<br/>
> - `CMD` _ile `ENTRYPOINT` neredeyse aynıdır. Fakat `CMD` ile girilen komutu `docker container run` esnasında ezebilirim ._<br/><br/>
>  - `Ör`: `docker container run <CONTAINER_NAME>` komutu ile Dockerfile'da yazılı olan `CMD` komutu çalışır. Fakat `docker container run <CONTAINER_NAME> ls` 
      komutu ile container içinde bulunan dosyayı listeler.
> - `ENTRYPOINT` _Çalışma zamanında değiştirilemez._<br/><br/>
> - `ENTRYPOINT` ve `CMD` _Dockerfile içerisinde aynı anda bulunursa, Docker `CMD` içinde olan parametreleri `ENTRYPOINT`'e parametre olarak geçer ve `ENTRYPOINT`'i çalıştırır._<br/><br/>
> - `ENTRYPOINT` ve `CMD` _Dockerfile içerisinde aynı anda bulunursa, `ENTRYPOINT`'e parametre geçme imkanı sağlanmış olur._<br/><br/>
>  - `docker container run <CONTAINER_NAME> 8.8.8.8`
>
> >- **EXEC vs SHELL**<br/>
> - `Exec Form` _ile ortam değişkenlerine **erişemeyiz**._
>  - `Ör`: `CMD ["echo", "$MSG"]`<br/><br/>
> - `Shell Form` _ile ortam değişkenlerine **erişebiliriz**._
>  - `Ör`: `CMD echo $MSG`<br/><br/>
> - `ENTRYPOINT` ve `CMD` _komutlarını beraber kullanacaksak mutlaka **exec form** kullanılmalıdır._<br/><br/>
>
> >- **Multi Stage Build**<br/>
> - `docker cp <CONTAINER_NAME>:/usr/src/uygulama .` _container içinde bilgisayara dosya kopyalar._
</details>