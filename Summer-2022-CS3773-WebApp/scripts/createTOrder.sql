-- createTOrder.sql
drop table if exists TOrder;
CREATE TABLE `TOrder` (
  `id`              int         NOT NULL,
  `custId`          int         NOT NULL,
  `totalPriceCents` int         NOT NULL,
  `status`          int         NOT NULL,
  `orderDt`         date        NOT NULL,
  `deliverDt`       date        DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`custId`) REFERENCES Customer (`id`)
);
