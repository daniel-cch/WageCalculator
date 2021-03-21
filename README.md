# WageCalculator
Java console application that calculates the total wage that ACME has to pay each employee for the time they have worked.

## Solution
First data is fetched and parsed from a data.txt file. In the parsing process the application checks if the format is correct in order to continue with the process. The format that the application expects is the following: RENE=MO10:-12:00 {NAME}={Day}{LocalTime}:{LocalTime}, time must be in {HH:mm} format, start time must not be after end time, each employee must be in a separate line, and must not contain white spaces. If this format is not met the application can throw an exception and exit the application. Also the program uses the day to later map the input day to check if the day that the employee worked on is a weekday or weekend.

All data is parsed via split() method on the line of each employee fetching name, day, and time worked. Once the data is retrieved and parsed it is retrieved by a controller in order to calculate the wage that needs to be paid to each employee.

For the calculation the application checks if the employee worked in one or multiple of the time frames below and if the employee worked on a weekday or weekend. And multiplies the hours worked in time frame and amount to be paid in time frame in order to get a daily wage. Then the application adds all of the working days in order to get a final amount that the employee needs to get paid; returning a result list that is later displayed by the presenter.

Monday - Friday
00:01 - 09:00 25 USD
09:01 - 18:00 15 USD
18:01 - 00:00 25 USD

Saturday - Sunday
00:01 - 09:00 30 USD
09:01 - 18:00 20 USD
18:01 - 00:00 25 USD

## Architecture
My architecture is based on a Clean Architecture proposed by Robert Martin and uses MVC as a design pattern in order to accomplish its purpose. This architecture we have the following structure:

#### Data Layer
Data contains the repository that is going to fetch data and is going to implement an interface that contains all the methods in order to decouple the Data and Domain layer.

#### Domain Layer
Domain contains all the business logic of our application. Also contains our Controllers, Models, Repository interfaces and Utilis.

##### Controlles - Domain Sublayer 
Controllers fetch data from the repository and also returns values specified by our business logic.

##### Models - Domain Sublayer 
Models contain all the representations we need for our data.

##### Repository - Domain Sublayer
Repository contains all the interfaces that are going to be implemented by the Data layer. Also these interfaces decouple the Data and Domain layer, and enforce business logic on the Data layer.

##### Utils - Domain Sublayer
Utils contains static final variables that contain some logic that don’t need a whole class.


#### View Layer
View contains all the files that are going to call controllers in order to get results and display data.

## Prerequisites
- Java 16 SDK installed
- IntelliJ idea (optional) 

## Installation
From terminal (data.txt is needed inside src folder in order to work)
```sh
cd src
javac Main.java
java Main 
```

From IntelliJ idea (data.txt must be in project main folder)
- Run main.java from Intellij idea

#### Output
```sh
The amount to pay RENE is: 215 USD
The amount to pay ASTRID is: 85 USD

Process finished with exit code -1
```

## Authors
* Daniel Cabrera
