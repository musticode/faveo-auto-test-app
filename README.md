# Faveo Auto Test App
Faveo Test ui-api
```
mvn clean test -DsuiteXmlFile=TestNG.xml
```

Allure report <br>
```
mvn allure:serve
```

### Parallel Test Execution
1-Install selenium standalone jar <br>

2-Execute 
```
jar java -jar sele... standalone
```
Execute command
```
mvn clean test -DsuiteXmlFile=ParallelTestNG.xml
```

### Grid Test Run
#### Parallel Test Execution

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
#### Docker setup and test run

```
@BeforeSuite
public void startContainer{
    CommonMethods.runTerminalCommand("docker-compose up", "Registered a node"); 
}
```

### Docker Selenoid
```
sudo network create selenoid
```
```
sudo docker-compose up
```
### Docker Selenium
create docker compose file:
https://github.com/SeleniumHQ/docker-selenium <br>
start docker selenium
```
sudo docker-compose up
```
kill process:
```
sudo docker-compose down
```

### API Test Execution
```
mvn clean test -DsuiteXmlFile=APITestNG.xml
```
### UI Test Execution in Jenkins
Start jenkins service <br>
Start selenium hub via: 
```
docker-compose up
```
Selenium hub containers should be running <br>
Go to localhost:4444 <br>
UI Tests will be run in 4444 port in a browser containers

```
mvn clean test -DsuiteXmlFile=JenkinsBuild.xml
```

## Test Suite Planning in project 
- class name: BaseTestFactory (extends DriverManager)
- Setup method initialized before methods, this usage make test **dependent** with login etc
- Teardown methods works after each methods


