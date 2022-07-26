-- createDiscount.sql
drop table if exists Discount;
CREATE TABLE `Discount` (
  `code`            text        NOT NULL,
  `percentOff`      integer     NOT NULL,
  `maxDollarAmount` integer     NOT NULL,
  `status`          integer     NOT NULL,
  `expireDt`        text        NOT NULL,
  PRIMARY KEY (`code`)
);
