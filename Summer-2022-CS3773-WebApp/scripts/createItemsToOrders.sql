-- createItemsToOrders.sql
drop table if exists ItemsToOrders;
CREATE TABLE `ItemsToOrders` (
  `itemId`          int         NOT NULL,
  `orderId`         int         NOT NULL,
  PRIMARY KEY (`itemId`, `orderId`),
  FOREIGN KEY (`itemId`) REFERENCES Item (`id`),
  FOREIGN KEY (`orderId`) REFERENCES TOrder (`id`)
);
