-- createSale.sql
drop table if exists Sale;
CREATE TABLE `Sale` (
  `id`              integer     NOT NULL,
  `itemId`          integer     NOT NULL,
  `percentOff`      integer     NOT NULL,
  `startDt`         text        NOT NULL,
  `expireDt`        text        NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`itemId`) REFERENCES Item (`id`)
);
