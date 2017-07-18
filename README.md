### Instructions 
Use pom.xml to load project IDE. 

#### Runtime Enviroment
 JAVA 1.8
 MAVEN 3.3.9

#### Build & RUN
Build the project run following command from ts.assignment

```..:\ts-assignment
mvn clean install
--To skip the test
mvn clean install -DskipTests

-- Run tests
mvn clean test
mvn clean test -Dtest=IPValidationUtilTest
mvn clean test -Dtest=StudentServiceImplTest#getStudentNameListBasedGPA

-- Execute Java Program
mvn clean install exec:java@q1
mvn clean install exec:java@q2
```
### Questions 
#### Q1 - IP Validation 
##### Analysis
IP address validation rules:
* String => A.B.C.D
    * where A,B,C and D => [0,255]
    * leading zero allowed
    * length is not greater than 3
    * IPv4 vs IPVv6
    
IP address : Valid range
* [0*255].[0-255].[0-255].[0-255]
  * [00]0-[00]9
  * [0]10-[0]99
  * [1]00-[1]99
  * [2]00-[2]49
  * [25]0-[25]5
 
##### Run Program
```
 mvn clean install exec:java@q1
 ```
 
Result output:
 ```
 -------- Valid IP Addresses --------
 0.0.0.0
 255.255.255.255
 1.1.1.1
 11.11.11.11
 111.111.111.111
 222.222.222.222
 127.0.0.1
 001.101.123.124
 010.10.243.009
 ```
  
#### Q2 - Rank Students
##### Analysis
 * Id - Unique and Not Null
 * Override equals & hashCode
    * Object becomes meanningfully equal 
 * Combarable
   * Comparing itself with another object.
 * Compartor
   * Comparing two different object
 * Used Compartor 

##### Run Program
```
  mvn clean install exec:java@q2
 ```
  
 Result output:
  ```
  -------- Ranking List - Student Names --------
  Louis
  Lorry
  Samar
  Samil
  Tina
  ```
  
##### Q3 - Timing Measure Tool- Design
This question has very broad scope. Design depends on how often you need to check the method execution time.

###### Analysis
* How to measure method elapsed or execution time
* Use centralised util class to calculate method execution time
  * Annotations
  * Aspectj
  * Configure each method with defined
* What are the data to collect
 * CLASS_NAME + METHOD_NAME -> String
 * Execution start time - Timestamp
    * Start & End time
 * Duration - Method elapsed time (Nano secs) - long 

###### Design & Implementation details

###### Approach 1
 Log the execution details to file then monitor the file. 
 * Using a logging frame log the required data to log files

###### Approach 2
 Real time monitoring with Mbean
 * Store the data in-memory then exposed the data through Mbean
  * Need to monitor in-memory to manage the memory usage
  * Data can be stored in database and the exposed throug application.
 
    

