-- createCustomer.sql
drop table if exists Customer;
CREATE TABLE `Customer` (
  `id`              integer     PRIMARY KEY,
  `name`            text        DEFAULT NULL,
  `state`           text        DEFAULT NULL, 
  `birthDt`         text        DEFAULT NULL,
  `creatDt`         text        NOT NULL,
  `status`          text        NOT NULL DEFAULT 'ACTIVE',
  `gender`          text        DEFAULT 'U'
);
