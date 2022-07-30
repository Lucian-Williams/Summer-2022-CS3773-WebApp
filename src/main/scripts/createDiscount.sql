-- createDiscount.sql
drop table if exists Discount;
CREATE TABLE `Discount` (
  `code`            text        NOT NULL,
  `percentOff`      integer     NOT NULL,
  `startDt`         text        NOT NULL,
  `expireDt`        text        NOT NULL,
  PRIMARY KEY (`code`)
);
