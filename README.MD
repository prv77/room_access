1.

Execute command in mysql console before run application:
"create schema testcase character set = utf8 collate = utf8_bin;"

2.

Set "spring.datasource.username" & "spring.datasource.password" on you values in application.properties Set "
spring.datasource.url" for you db server

3.

Run application:
"java -jar /path/to/jar/file access-0.0.1-SNAPSHOT.jar"

Request example on localhost:
GET http://localhost:8080/check?roomId=1&entrance=true&keyId=3

Notes:

On startup database initiate test data. For use in prod, set setting "spring.datasource.initialization-mode=never" in application.properties.
