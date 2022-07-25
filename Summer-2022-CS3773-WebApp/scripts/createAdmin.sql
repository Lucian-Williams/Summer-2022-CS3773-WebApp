-- createAdmin.sql
drop table if exists Admin;
CREATE TABLE `Admin` (
  `id`              int         NOT NULL,
  `name`            varchar(30) NOT NULL,
  `pwHash`          int         NOT NULL,
  PRIMARY KEY (`id`)
);
