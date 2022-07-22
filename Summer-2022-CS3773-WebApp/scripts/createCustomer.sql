-- createCustomer.sql
drop table if exists Customer;
CREATE TABLE `Customer` (
  `id`		    int		NOT NULL,
  `name`	    varchar(30) DEFAULT NULL,
  `baseLoc`         char(2)     DEFAULT NULL, 
  `birthDt`         date        DEFAULT NULL,
  `gender`          char(1)     DEFAULT 'U',  
  PRIMARY KEY (`custNr`)
);
