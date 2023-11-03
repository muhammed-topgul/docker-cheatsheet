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
>>     _Bilgisayarım üzerinde bulunan bir dizini doğrudan docker üzerinde gösterebiliyorum. 
        Docker doğrudan bu dosyayı okur. Bilgisayar üzerinde yapılan değişiklikler docker'ı da etkiler._
</details>