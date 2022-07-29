-- createTOrder.sql
drop table if exists TOrder;
CREATE TABLE `TOrder` (
  `id`              integer     PRIMARY KEY,
  `custId`          integer     NOT NULL,
  `totalPriceCents` integer     NOT NULL,
  `status`          integer     NOT NULL,
  `discountCode`    text        DEFAULT NULL,
  `orderDt`         text        NOT NULL,
  `deliverDt`       text        DEFAULT NULL,
  FOREIGN KEY (`custId`) REFERENCES Customer (`id`),
  FOREIGN KEY (`discountCode`) REFERENCES Discount (`code`)
);
