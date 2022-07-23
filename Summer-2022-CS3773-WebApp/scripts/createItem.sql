-- createItem.sql
drop table if exists Item;
CREATE TABLE `Item` (
  `id`              int         NOT NULL,
  `name`            varchar(30) NOT NULL,
  `itemType`        int         NOT NULL,
  `stock`           int         DEFAULT 0 NOT NULL, 
  `pricecents`      int         NOT NULL,
  `image`           blob        DEFAULT NULL,
  PRIMARY KEY (`id`)
);
