# spring-boot-h2

## Docker step
#Clone your code
    git clone https://github.com/up1/workshop-20190325.git ./workshop cd workshop
#Build jar file
    docker container run --rm -w /src -v $(pwd):/src maven:3.6.0-jdk-8-alpine mvn package
#Run spring boot from step 2
    docker container run -d -w /src -v $(pwd)/target/demo.jar:/src/demo.jar -p 9999:8080 openjdk:8u191-jre-alpine3.9 java -jar demo.jar
#Create Docker image from Dockerfile
###Inside Dockerfile
    FROM openjdk:8u191-jre-alpine3.9
    WORKDIR /src
    COPY ./target/demo.jar /src/demo.jar
    EXPOSE 8080
    CMD ["java", "-jar", "demo.jar"]
    
docker image build -t {your docker hub}/demoapp:1.0 .

docker container run -d -p 9999:8080 {your docker hub}/demoapp:1.0
  
#deploy docker container from docker image
### push image to docker hub
docker login

docker image push {your docker hub}/demoapp1.0

#Remove container
docker container stop $(docker container ps -q)
docker container prune