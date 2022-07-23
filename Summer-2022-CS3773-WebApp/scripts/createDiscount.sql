-- createDiscount.sql
drop table if exists Discount;
CREATE TABLE `Discount` (
  `code`            int         NOT NULL,
  `orderId`         int         DEFAULT NULL,
  `percentOff`      int         NOT NULL,
  `maxDollarAmount` int         NOT NULL,
  `status`          int         NOT NULL,
  `expireDt`        date        NOT NULL,
  PRIMARY KEY (`code`),
  FOREIGN KEY (`orderId`) REFERENCES TOrder (`id`)
);
