-- createItem.sql
drop table if exists Item;
CREATE TABLE `Item` (
  `id`              integer     PRIMARY KEY,
  `name`            text        NOT NULL,
  `stock`           integer     DEFAULT 0 NOT NULL, 
  `pricecents`      integer     NOT NULL,
  `imagepath`       text        DEFAULT NULL
);
