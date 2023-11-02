###### Docker Tips
<details>
  <summary>Container 101</summary>

> - **Docker CLI**<br/>
>>  - `docker` _docker üzerinde kullanabileceğimiz tüm komutları listeler._<br/>
>>  - `docker info` _docker hakkında genel bilgileri verir._<br/>
>>  - `docker container --help` _docker container komutu ile birlikte kullanabileceğim komutları listeler._<br/>
>>  - `docker image --help` _docker image komutu ile birlikte kullanabileceğim komutları listeler._<br/>
>>  - `docker image rm --help` _docker image rm komutu ile birlikte kullanabileceğim komutları listeler._<br/>

> - **Container Temelleri**<br/>
>>  - `docker container run --name new_app1 mtopgul/app1` _docker container oluştur ve çalıştır._<br/>
>>  - `docker run -p 8089:8085 --name web_app mtopgul/web-app1` _docker container oluştur ve çalıştır._<br/>
>>  - `docker run -d -p 8089:8085 --name web_app mtopgul/web-app1` _docker container oluştur ve arka planda çalıştır._<br/>
>>  - `docker container ls -a` _docker container oluştur ve çalıştır._<br/>
>>  - `docker logs <CONTAINER_ID, CONTAINER_NAME> -f` _Container loglarını gösterir._<br/>
>>  - `docker start <CONTAINER_ID, CONTAINER_NAME> -f` _Container'ı çalıştırır._<br/>
>>  - `docker stop <CONTAINER_ID, CONTAINER_NAME> -f` _Container'ı durdurur._<br/>
>>  - `docker container rm <CONTAINER_ID> <CONTAINER_ID> ... -f` _Containerları siler._<br/>
>>  - `docker rmi <CONTAINER_ID> <CONTAINER_ID> ... -f` _Containerları siler._<br/>
</details>