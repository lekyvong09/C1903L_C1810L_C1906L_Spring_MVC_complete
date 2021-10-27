# Database - customer table
```
CREATE DATABASE  IF NOT EXISTS customer_tracker;
USE customer_tracker;

DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
  id int(11) NOT NULL AUTO_INCREMENT,
  first_name varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

LOCK TABLES customer WRITE;


INSERT INTO customer VALUES 
	(1,'David','Adams','david@email.com'),
	(2,'John','Doe','john@email.com'),
	(3,'Ajay','Rao','ajay@email.com'),
	(4,'Mary','Public','mary@email.com'),
	(5,'Maxwell','Dixon','max@email.com');

UNLOCK TABLES;

```

# Database - Table users & authorities
```
use customer_tracker;
drop table if exists users;
 create table users (
     username varchar(50) NOT NULL, 
     password varchar(50) NOT NULL, 
     enabled tinyint(1) NOT NULL, 
     PRIMARY KEY (username)
     ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
     
 insert into users values ('ray','{noop}password',1), ('tommy','{noop}password',1);
 
 drop table if exists authorities;
 create table authorities (
     id int(11) NOT NULL AUTO_INCREMENT,
     username varchar(50) NOT NULL, 
     authority varchar(50) NOT NULL, 
     PRIMARY KEY (id),
     UNIQUE KEY authorities_idx_1(username,authority),
     CONSTRAINT authorities_ibfk_1 FOREIGN KEY (username) REFERENCES users (username)
     ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
     
 insert into authorities(username,authority) values ('ray','ROLE_EMPLOYEE'),('ray','ROLE_ADMIN'),('tommy','ROLE_EMPLOYEE');
```


# Database - table user with bcrypt password
```
use customer_tracker;
 set foreign_key_checks = 0;

 drop table if exists users;
 create table users (
     username varchar(50) NOT NULL, 
     password varchar(68) NOT NULL, 
     enabled tinyint(1) NOT NULL, 
     PRIMARY KEY (username)
     ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
     
 insert into users values ('ray','$2a$12$xjosY8TFP4iBjhd/SVwZz.C15uCtAu9BwghBPr0iybUeLjNBJItcK',1), ('tommy','$2a$12$MGOF3pyaPnHMhDGzPL/zzONLYM2Ui6oRvVVXtbPaBnIh1XSB/0b/2',1);

 drop table if exists authorities;
 create table authorities (
     id int(11) NOT NULL AUTO_INCREMENT,
     username varchar(50) NOT NULL, 
     authority varchar(50) NOT NULL, 
     PRIMARY KEY (id),
     UNIQUE KEY authorities_idx_1(username,authority),
     CONSTRAINT authorities_ibfk_1 FOREIGN KEY (username) REFERENCES users (username)
     ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
     
 insert into authorities(username,authority) values ('ray','ROLE_EMPLOYEE'),('ray','ROLE_ADMIN'),('tommy','ROLE_EMPLOYEE');

 set foreign_key_checks = 1;
```


# Database add email to table users
```
use customer_tracker;
 set foreign_key_checks = 0;

 drop table if exists users;
 create table users (
     username varchar(50) NOT NULL, 
     password varchar(68) NOT NULL,
     email varchar(250) NULL,
     enabled tinyint(1) NOT NULL, 
     PRIMARY KEY (username)
     ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
     
 insert into users values ('ray','$2a$12$yrqpXaFZTUXIHkriRkWEu.DiCGPMPj1JKjYEhN3Iqf4mrVRjgJxNK','ray@email.com',1), ('tommy','$2a$12$MGOF3pyaPnHMhDGzPL/zzONLYM2Ui6oRvVVXtbPaBnIh1XSB/0b/2','tommy@email.com',1);
 set foreign_key_checks = 1;
```
