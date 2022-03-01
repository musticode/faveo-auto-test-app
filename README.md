# faveo-auto-test-app
Faveo Test ui-api

mvn clean test -DsuiteXmlFile=TestNG.xml

Allure report <br>
mvn allure:serve

###Parallel Test Execution
1-Install selenium standalone jar <br>
2-Execute selenium "jar java -jar sele... standalone" <br>
3-Execute command: mvn clean test -DsuiteXmlFile=ParallelTestNG.xml
a

###Grid Test Run

1-cd grid <br>
2-type in local terminal1: java -jar selenium-server-4.0.0.jar standalone <br>
3-type in local terminal2: mvn clean test -DsuiteXmlFile=ParallelTestNG.xml
