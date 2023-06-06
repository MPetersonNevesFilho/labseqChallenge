# Labseq Challenge

This project was developed as part of a professional challenge, a back-end was requested to calculate a recursive mathematical solution and, optionally, a front-end to carry out requests to the back-end. The mathematical problem is this below:
 - n=0 => l(0) = 0
 - n=1 => l(1) = 1
 - n=2 => l(2) = 0
 - n=3 => l(3) = 1
 - n>3 => l(n) = l(n-4) + l(n-3)

Also, one of the goals was to solve N=10,000 in less than 10 seconds, the expected answer is: 69950566878097184013157744477635556727868849589082998911839343197880823215346221009722233023943602770307729191665655398407165768121564186987192397693071609846919453430811144389823875683774480880281479951416523467736343974525549960389427464841013320746241755697990287429747307066048835194835534301361435435171244963037487135503198565459610125773779110841477593382691667903942271834984619627946845583317271714790127086723614783681640902031022970893247841818337935296805019561967546398282596597404334400595273408222818081762762981879844447410743730739725556081175617700994424267694361314464204552899258977619983936670456553201627025301979470684612183482967552781789171894406131379502874476544298881442363169258726593616997962614541232149734611181684936265928412294383549494959124156102645749161099774806409315657803977415799277767229630141831326718534674913706653355139

## Organization

Inside this repository you will find three big folders, one to store the backend, another one for the frontend and the last one for the file with the guidelines of this challenge.

### Back-End Quarkus (code-with-quarkus)

Maven was used for compilation automation, in addition, an accepted suggestion was the construction of the back-end using the Quarkus framework, in which a structure of folders and files similar to the construction of an SQL solution was implemented due to its clarity and objectivity. Finally, the project was placed in a container used by Docker.

### Front-End React Js. (frontchallenge)

React Js. + Vite was used to build the front-end due to my familiarity with the library, in which a single page was implemented where the name of the challenge (Labseq) was used as the business name.

### API Documentation
The application is simple, it has only three endpoints, details are covered in the documentation. [Link to Open API | LabseqChallenge | 1.0 | MPetersonNevesFilho | SwaggerHub](https://app.swaggerhub.com/apis/MPetersonNevesFilho/LabseqChallenge/1.0)


## Running the project

To run the project your machine needs to have some software installed to be used.

### Prerequisites
 - Maven version 3.8.6 or above with Java version 17.0.4.1 or above
 - Docker version 20.10.17 or above


### Turn on
1. Clone the repository yo tour local machine.
2. Navigate to the back-end directory and run the following command in your terminal to make file.jar with the project
```bash
mvn package -DskipTests
```
3. Run your docker
4. In the same directory, build and run the docker image using docker-compose
```bash
docker-compose up
```
5. After the docker are up and running, access the [URL Localhost on port 8080](http://localhost:8080/)
6. Now you can make requests through the front-end, choose a value of N.
