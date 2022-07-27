-- createTOrder.sql
drop table if exists TOrder;
CREATE TABLE `TOrder` (
  `id`              integer     NOT NULL,
  `custId`          integer     NOT NULL,
  `totalPriceCents` integer     NOT NULL,
  `status`          integer     NOT NULL,
  `discountCode`    text        DEFAULT NULL,
  `orderDt`         text        NOT NULL,
  `deliverDt`       text        DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`custId`) REFERENCES Customer (`id`),
  FOREIGN KEY (`discountCode`) REFERENCES Discount (`code`)
);
