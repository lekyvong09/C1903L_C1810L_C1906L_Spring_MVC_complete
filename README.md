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
