-- createItem.sql
drop table if exists Item;
CREATE TABLE `Item` (
  `id`              integer     NOT NULL,
  `name`            text        NOT NULL,
  `itemType`        integer     DEFAULT NULL,
  `stock`           integer     DEFAULT 0 NOT NULL, 
  `pricecents`      integer     NOT NULL,
  `image`           blob        DEFAULT NULL,
  PRIMARY KEY (`id`)
);
