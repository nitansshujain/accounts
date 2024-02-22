#Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim

#Information around who maintains the image
MAINTAINER Nitansshu Jain

# Add the application's jar to the image
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

# execute the application
ENTRYPOINT ["java", "-jar", "accounts-0.0.1-SNAPSHOT.jar"]

# Command to be executed in cmd inside the accounts folder to build the project inside the Docker file
# docker build . -t nitansshujain/accounts:s4
# Here . is the location (here the location is the current location), -t is the tag, nitansshujain is the username of dockerhub, accounts in the project name, s4 is the version

# docker images # to view all the images
# docker inspect image <image_id> # to view the description of the image

# docker run -d -p 8080:8080 <image_name>:<tag_name>  # To create a new container and run, -d is the detached mode, -p is the port, 8080 (second) is the port where docker container will start inside the Docker network, 8080 (first) telling the docker to expose the container to the outside of the Docker network at port 8080 (locally/cloud/VMs)
# docker run -d -p 8081:8080 <image_name>:<tag_name>  # To create a new container same as above, but make sure to change the port (first)

# docker start <image_id>   # To start the existing container
# docker stop <image_id>   # To stop the existing container

# docker ps     # list of running containers
# docker ps -a    # list of stopped containers

# mvn spring-boot:build-image   # To build using buildpack, make sure to run from the correct terminal location, then create container through docker run command

# docker image push docker.io/<image_name>:<tag>     # To push onto docker hub

# docker compose up -d  # creating the images, containers, networks and run those containers using the single command only
# docker compose down   # deleting the images, containers and networks
# docker compose stop   # stopping the containers only
# docker compose start   # starting the containers only

