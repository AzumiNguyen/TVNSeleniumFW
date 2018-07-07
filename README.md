# TVNSeleniumFW

Selenium course
created by [Ha Do](https://cuhavp.github.io/)
copyright by *[TVN](http://www.testingvn.com/)*

## Setting up . . .

1. Install and setup [Java JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
2. Download and setup [Maven](https://maven.apache.org/)
3. Install [Intellij Community](https://www.jetbrains.com/idea/download)
4. Install browsers(chrome, firefox, COCOC)

## How to run
```batch
$ mvn clean install -Dtest.suite=<path/to/your/xml/file> allure:report
```
## Where are reports

1. ScreenShot: 
```
**/reports/screenshot/
```

2. Excel Report:

```batch
**/reports/excel/
```

3. Html Report ([Allure Report](https://docs.qameta.io/allure/latest/#_testng))
```batch
**/target/site/allure-maven-plugin/index.html
```
