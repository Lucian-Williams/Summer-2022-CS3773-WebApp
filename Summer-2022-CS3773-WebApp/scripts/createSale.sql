-- createSale.sql
drop table if exists Sale;
CREATE TABLE `Sale` (
  `id`              int         NOT NULL,
  `itemType`        int         NOT NULL,
  `percentOff`      int         NOT NULL,
  `startDt`         date        NOT NULL,
  `expireDt`        date        NOT NULL,
  PRIMARY KEY (`id`)
);
