###### Docker Tips
<details>
  <summary>Container 101</summary>

> >>- **Docker CLI**<br/>
>>  - `docker` _Docker üzerinde kullanabileceğimiz tüm komutları listeler._<br/>
>>  - `docker info` _Docker hakkında genel bilgileri verir._<br/>
>>  - `docker container --help` _Docker container komutu ile birlikte kullanabileceğim komutları listeler._<br/>
>>  - `docker image --help` _Docker image komutu ile birlikte kullanabileceğim komutları listeler._<br/>
>>  - `docker image rm --help` _Docker image rm komutu ile birlikte kullanabileceğim komutları listeler._<br/>

> >>- **Container Temelleri**<br/>
>>  - `docker container run --name new_app1 mtopgul/app1` _Docker container oluştur ve çalıştır._<br/>
>>  - `docker run -p 8085:8085 --name web_app mtopgul/web-app1` _Docker container oluştur ve çalıştır._<br/>
>>  - `docker run -d -p 8085:8085 --name web_app mtopgul/web-app1` _Docker container oluştur ve arka planda çalıştır._<br/>
>>  - `docker run --rm mtopgul/web-app1` _Docker container oluştur, çalıştırır ve container durduğunda containeri siler._<br/>
>>  - `docker container ls -a` _Docker container oluştur ve çalıştır._<br/>
>>  - `docker logs <CONTAINER_ID, CONTAINER_NAME> -f` _Container loglarını gösterir._<br/>
>>  - `docker start <CONTAINER_ID, CONTAINER_NAME> -f` _Container'ı çalıştırır._<br/>
>>  - `docker stop <CONTAINER_ID, CONTAINER_NAME> -f` _Container'ı durdurur._<br/>
>>  - `docker container rm <CONTAINER_ID> <CONTAINER_ID> ... -f` _Containerları siler._<br/>
>>  - `docker rmi <CONTAINER_ID> <CONTAINER_ID> ... -f` _Containerları siler._<br/>
>>  - `docker container prune` _Çalışmayan tüm containerleri siler._<br/>
>>  - `docker image prune -a` _Tüm imageları siler._<br/>
>>  - `docker exec -it <CONTAINER_NAME, CONTAINER_ID> sh` _Continer içerisinde komut satırı açar._<br/>

> >>- **Docker Volume**<br/>
>>  - `docker volume ls` _Volumeleri listeler._<br/>
>>  - `docker volume rm <VOLUME_NAME>` _Volumeu siler._<br/>
>>  - `docker volume prune` _Kullanılmayan volumeleri siler._<br/>
>>  - `docker volume create <VOLUME_NAME>` _Volumeleri oluşturur._<br/>
>>  - `docker volume inspect <VOLUME_NAME>` _Volume detaylarını gösteririr._<br/>
>>  - `docker run -v <VOLUME_NAME>:/<NEW_FILE> -p 8085:8085 --name web_app mtopgul/web-app1` _Image oluşturur ve volume ile bağlar._<br/>
>>  - `docker run -v <VOLUME_NAME>:/<NEW_FILE>:ro -p 8085:8085 --name web_app mtopgul/web-app1` _Image oluşturur ve volume ile bağlar. Burda volume sadece READ ONLY'dir yazma işlemi yapılamaz._<br/>

> >>- **Bind Mounts**<br/>
>>  - `docker container run -d -p 80:80 -v C:\docker-staff\container101\website:/usr/share/nginx/html --name my_web nginx` _Bind Mounts._<br/>
>>     _<br/>Bilgisayarım üzerinde bulunan bir dizini doğrudan docker üzerinde gösterebiliyorum. 
        Docker doğrudan bu dosyayı okur. Bilgisayar üzerinde yapılan değişiklikler docker'ı da etkiler._
</details>

<details>
  <summary>Container 102</summary>

> >>- **Network**<br/>
>>  - `CTRL + PQ` _Container ile konsol bağlantısını keser ama containeri kapatmaz._<br/>
>>  - `dokcer network ls` _Networkleri listeler._<br/>
>>  - `dokcer network inspect <NETWORK_NAME>` _Network detaylarını gösterir._<br/>
>>  - `docker container run -d -p 8080:8080 --net host --name <CONTAINER_NAME> <IMAGE_NAME>` _Conteineri host networküne bağlar._<br/>
>>  - `docker network create <NETWORK_NAME> --driver bridge` _Yeni bir network oluşturur._<br/>
>>  - `docker network create <NETWORK_NAME> --driver=bridge --subnet=10.10.0.0/16 --ip-range=10.10.10.0/24 --gateway=10.10.10.10` _Özelleştirilmiş bağlantı ayarlı bir network oluşturur._<br/>
>>  - `docker network connect <NETWORK_NAME> <CONTAINER_ID>` _Containeri yeni bir networke bağlar._<br/>
>>  - `docker network disconnect <NETWORK_NAME> <CONTAINER_ID>` _Containeri networkten çıkarır._<br/>
>>  - `docker network rm <NETWORK_NAME>` _Networkü siler._<br/>

> >>- **Logging**<br/>
>>  - `docker logs <CONTAINER_ID>` _Container loglarını gösterir._<br/>
>>  - `docker logs <CONTAINER_ID> -f` _Container loglarını gösterir ve konsolu canlı olarak takip et._<br/>
>>  - `docker logs <CONTAINER_ID> --since 5m` _Container loglarını (Son 5 dk) gösterir._<br/>
>>  - `docker logs <CONTAINER_ID> --until 5m` _Container loglarını (Son 5 dk hariç) gösterir._<br/>
>>  - `docker logs <CONTAINER_ID> -t` _Container loglarını başında oluşturulduğu tarih ile birlikte gösterir._<br/>
>>  - `docker logs <CONTAINER_ID> --tail 2` _Son 2 satır container logunu gösterir._<br/>

> >>- **Stats and Top**<br/>
>>  - `docker top <CONTAINER_ID>` _Container PID, TIME, CMD gibi verilerini gösterir._<br/>
>>  - `docker stats` _Tüm containerın hafıza kullanım bilgilerini gösterir._<br/>
>>  - `docker stats <CONTAINER_ID>` _Containerların hafıza kullanım bilgilerini gösterir._<br/>

</details>