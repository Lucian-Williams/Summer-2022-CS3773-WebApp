-- createCustomer.sql
drop table if exists Customer;
CREATE TABLE `Customer` (
  `id`              int         NOT NULL,
  `name`            varchar(30) DEFAULT NULL,
  `state`           char(2)     DEFAULT NULL, 
  `birthDt`         date        DEFAULT NULL,
  `creatDt`         date        NOT NULL,
  `gender`          char(1)     DEFAULT 'U',  
  PRIMARY KEY (`id`)
);
