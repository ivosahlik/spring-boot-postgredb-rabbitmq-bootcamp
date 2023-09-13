## docker
docker ps

## run postgredb, rabbitmq and clamav, is need to have docker ran
docker-compose up
docker-compose down

## apps - you can run it on localhost, there is connect to rabbitmq, postgredb and clamav(check with antivirus)
producer -> port 8080
consumer -> port 8081
cron –> port 8082

## Swagger UI for producer is here:
http://localhost:8080/swagger-ui.html

## Design

-> docs/asciidoc/output -> there is bootcamp-manual.pdf