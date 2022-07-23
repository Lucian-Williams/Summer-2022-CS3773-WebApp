-- createDiscount.sql
drop table if exists Discount;
CREATE TABLE `Discount` (
  `code`            int         NOT NULL,
  `percentOff`      int         NOT NULL,
  `maxDollarAmount` int         NOT NULL,
  `status`          int         NOT NULL,
  `expireDt`        date        NOT NULL,
  PRIMARY KEY (`code`)
);
