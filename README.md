[![Java CI with Maven](https://github.com/VitaliyPunko/Anderson_JavaCource/actions/workflows/maven.yml/badge.svg?branch=main)](https://github.com/VitaliyPunko/Anderson_JavaCource/actions/workflows/maven.yml)
[![Build](https://github.com/VitaliyPunko/Anderson_JavaCource/actions/workflows/build.yml/badge.svg?branch=main)](https://github.com/VitaliyPunko/Anderson_JavaCource/actions/workflows/build.yml)

# Andersen_JavaCource

## Requirements

* JDK 11
* Apache Maven
* mySQL

You can download mySQL here: [https://www.mysql.com/downloads](https://www.mysql.com/downloads).

## Setting

After installing mySQL you need to create a user:

```
CREATE USER 'bestuser'@'localhost' IDENTIFIED BY 'bestuser';
GRANT ALL PRIVILEGES ON *.* TO 'bestuser'@'localhost' WITH GRANT OPTION;
```

And a database:

```
drop database if exists andersen;
create database andersen;
use andersen;
```

## Build application:

```
mvn clean install
```

## Start application

To start an application:

```
 java -jar ./target/Andersen_JavaCource-1.0-SNAPSHOT.jar
```

Server up on [http://localhost:8090](http://localhost:8090).