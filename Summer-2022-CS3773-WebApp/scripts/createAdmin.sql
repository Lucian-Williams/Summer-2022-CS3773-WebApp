-- createAdmin.sql
drop table if exists Admin;
CREATE TABLE `Admin` (
  `id`              integer     NOT NULL,
  `name`            text        NOT NULL, -- use name as salt
  `verifier`        integer     NOT NULL,
  PRIMARY KEY (`id`)
);
