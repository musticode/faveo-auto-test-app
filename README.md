# Faveo Auto Test App
Faveo Test ui-api
```
mvn clean test -DsuiteXmlFile=TestNG.xml
```

Allure report <br>
```
mvn allure:serve
```

###Parallel Test Execution
1-Install selenium standalone jar <br>

2-Execute 
```
jar java -jar sele... standalone
```
Execute command
```
mvn clean test -DsuiteXmlFile=ParallelTestNG.xml
```

###Grid Test Run
####Parallel Test Execution

```
cd grid
```
```
java -jar selenium-server-4.0.0.jar standalone
```
```
mvn clean test -DsuiteXmlFile=ParallelTestNG.xml
```
```
mvn allure:serve
```

