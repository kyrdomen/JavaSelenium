# Requirements
* Java 18
* Maven 3
* Allure 2


## Java Installation
Java version 18 is required.
Command:
```bash
$ java --version
```
Ensure your JAVA_HOME environment to the location of the installed JDK.
## Maven Installation
1. Download Maven
2. Unzip the distribution archive to the directory you wish to install Maven.
3. Add Maven to the PATH
4. Verify Maven was correctly installed
```bash
$ mvn --version
```
## Allure Installation
1. Download Allure
2. Unzip the distribution archive to the directory you wish to install Allure.
3. Add Allure to the PATH
4. Verify Allure was correctly installed
```bash
$ allure --version
```

## How to build project
```bash
$ mvn package
```
### Setup

* Clone the repo
* Install dependencies `mvn compile`
## How to run tests

* To run Suite with Chrome, run `mvn clean test`
* To run Suite with Firefox, run `mvn clean test -Dbrowser="firefox"`
* To run Suite with Edge, run `mvn clean test -Dbrowser="edge"`

## How to see test report
```bash
$ allure serve
```
# Built with
- Selenium : Browser automation framework
- Maven : Build automation & dependency management
- TestNG : Testing framework, control flow of tests
- Allure : Report tool
- Webdrivers : Webdriver Manager

### Implements
* Page Object Model
* Business Object Model
* Singleton Webdriver Factory
* Selenium By locators for elements
* Selenium Relative Locators