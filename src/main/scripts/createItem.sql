-- createItem.sql
drop table if exists Item;
CREATE TABLE `Item` (
  `id`              integer     PRIMARY KEY,
  `name`            text        NOT NULL,
  `itemType`        integer     DEFAULT NULL,
  `stock`           integer     DEFAULT 0 NOT NULL, 
  `pricecents`      integer     NOT NULL,
  `image`           blob        DEFAULT NULL
);
