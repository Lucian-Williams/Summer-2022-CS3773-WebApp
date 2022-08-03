-- createSale.sql
drop table if exists Sale;
CREATE TABLE `Sale` (
  `id`              integer     PRIMARY KEY,
  `itemId`          integer     NOT NULL,
  `percentOff`      integer     NOT NULL,
  `startDt`         text        NOT NULL,
  `expireDt`        text        NOT NULL,
  FOREIGN KEY (`itemId`) REFERENCES Item (`id`)
);
