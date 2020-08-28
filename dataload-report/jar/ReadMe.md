# Quick Start 
```
This utility does not take any argument from command line.But while running this JAR make sure that updated property file and JAR should be in the same. JAR automatically consumes the property file and generated report based on that

```

## Building
>The main method of the application is at the following path:
> ##### com.load.tracker.dataloadreport.DataloadReportApplication.java

## Dependencies 
```

1.lombok
2.mysql-connector-java or mssql-jdbc
3.spring-boot-starter-actuator
4.spring-boot-starter-data-jpa
5.spring-boot-starter-web
6.spring-boot-starter-data-rest

```

## Parameters File Example

```
############ Application configuration #############
# --------- You can make changes here -------------#           
server.port=8080
access.token=
environment.url=
tenant.id=
created.from=1598553000000
created.to=1598639399999
####################################################


######## Mysql DB configuration ####################
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/springboot
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
####################################################


######## MS SQL server DB configuration ############
#spring.datasource.url=jdbc:sqlserver://localhost;databaseName=springbootdb
#spring.datasource.username=
#spring.datasource.password=
#spring.datasource.driverClassName=com.microsoft.sqlserver.jdbc.SQLServerDriver
#spring.jpa.show-sql=true
#spring.jpa.hibernate.dialect=org.hibernate.dialect.SQLServer2012Dialect
#spring.jpa.hibernate.ddl-auto=create-drop
####################################################

######## DO-NOT MAKE ANY CHANGES HERE ##############
management.endpoints.web.exposure.include=*
management.endpoint.shutdown.enabled=true
endpoints.shutdown.enabled=true
####################################################

```

## Executing

Command to start the utility.
```

java -jar dataload-report-${version}.jar > $logfilepath$

```
