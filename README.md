# spring-demo-mysql

This is a simple Spring Boot application that uses MySQL as a database.

## Prerequisites

* Java 8
* Maven 3.3.9
* MySQL 5.7
* Docker 17.09.0-ce
* Docker Compose 1.16.1
* Git 2.14.1
* IDE (IntelliJ IDEA, Eclipse, etc.)
* Postman
* Browser (Chrome, Firefox, etc.)
* Terminal
* Text Editor (Sublime Text, Atom, etc.)
* Curl

## Getting Started

### Clone the repository

```bash
git clone https://github.com/asimsharf/spring-demo-mysql.git
cd spring-demo-mysql
```

### Start MySQL

```bash
docker-compose up -d

# To stop MySQL
docker-compose down

# To start MySQL
docker-compose up -d

# To restart MySQL
docker-compose restart
```

### Create the database

```bash
docker exec -it mysql mysql -uroot -p

# Enter the password: root
mysql> create database spring_demo;
mysql> exit

# To verify the database
docker exec -it mysql mysql -uroot -p

# Enter the password: root

mysql> show databases;
```

```sql
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| spring_demo        |
| sys                |
+--------------------+

mysql> exit
```

### Run the application

```bash

# To run the application
mvn spring-boot:run

# To stop the application
mvn spring-boot:stop
```
