-- createAdmin.sql
drop table if exists Admin;
CREATE TABLE `Admin` (
  `id`              integer     PRIMARY KEY,
  `name`            text        NOT NULL, -- use name as salt
  `verifier`        integer     NOT NULL
);
