# Mutant detector API
### Purpose
To detect mutant dna strings using,as input, a six dna strings sequence. 
### Project construction stack
- Java 8
- MongoDb 3.6
- Embeded Tomcat server 8.5
- Apache Maven 3.5
- Spring Boot 2.0
- Jacoco Junit libs
### Cloud location
- Heroku cloud engine under url https://mutant-detector.herokuapp.com/
- Mongo database hosted in AWS cloud via mLab platform https://mlab.com

### Local setup instructions
- Download and install [Apache Maven](https://maven.apache.org/download.cgi)
- Download and install [MongoDb Community Edition](https://www.mongodb.com/download-center#community)
Standard MongoDb installation proposes listener port 27017 but in case your local installation uses a different one, it can be set updating [spring.data.mongodb.uri](https://github.com/jguzman-ar/mutant-detector/blob/master/src/main/resources/application.properties) in the project resource before packaging again.
- Clone this [repository](https://github.com/jguzman-ar/mutant-detector.git)
- Position under the project root path and run command 
 ```mvn clean package```
- Execute either ```mvn spring-boot:run``` or position under target project folder and execute```java -jar mutant-detector-1.0.0.jar```

### Usage
Once the application is up and running, API endpoints can be tested locally using any rest client GUI or directly curling from console as follow:

##### API Mutant
-----
```
POST localhost:8080/mutant
{
    "dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}
```
or 
```
curl -v -X POST https://mutant-detector.herokuapp.com/mutant -H 'Content-Type: application/json' -d '{"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]}'
```
```
Response: 200 - OK
```

```
POST localhost:8080/mutant
{
	"dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGACGG", "GACCTA", "TCACTG"]
}
```
or
```
curl -v -X POST https://mutant-detector.herokuapp.com/mutant -H 'Content-Type: application/json' -d '{"dna":["ATGCGA","CAGTGC","TTATGT","AGACGG","GACCTA","TCACTG"]}'
```
```
Response: 403 - Forbidden
```
##### API Stats
-----
```
GET https://mutant-detector.herokuapp.com/stats
``` 
or 
```
curl -v https://mutant-detector.herokuapp.com/stats -H 'Content-Type: application/json'
```
```
Response 200 - OK 
{
    "count_mutant_dna": 2,
    "count_human_dna": 2,
    "ratio": 1
}
```
----
### Unit testing coverage

To run the coverage report position on the project root path and execute ```mvn test``` then locate the report under folder
\mutant-detector\target\jacoco-ut\index.html. Current figures: 
###### Total instructions coverage: 86%
###### Total logical branches coverage: 80%
### Load testing 
Tested the API performance `locally` using Apache Jmeter tool. For replicating the load test scenarios wrote a [jmx](https://github.com/jguzman-ar/mutant-detector/blob/master/src/test/java/com/magneto/resources/mutant-detector.jmx) that uses a random dna [file](https://github.com/jguzman-ar/mutant-detector/blob/master/src/test/java/com/magneto/resources/randomDna.csv) as test input. 
##### Testing considerations: 
- Local tests were performed with "out of the box" settings for MongoDb and Tomcat Web Server.
- Persistence Thread Pool executor settings were setup on application [properties](https://github.com/jguzman-ar/mutant-detector/blob/master/src/main/resources/application.properties) and can be tweaked for optimal results by setting pool size and queue capacity.

##### Tested load with figures: 
Concurrent threads: 1000
Ramp up time: 5 seconds
Loop count: 10 times
Total samples: 20000
Minimum response times: 2 milliseconds
Average response times: 618 milliseconds
Maximum response times: 1524 milliseconds
Error percentage: 0 %
Throughput: 1086 requests/second








