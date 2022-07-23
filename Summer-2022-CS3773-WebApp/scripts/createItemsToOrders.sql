-- createItemsToOrders.sql
drop table if exists ItemsToOrders;
CREATE TABLE `ItemsToOrders` (
  `itemId`          int         NOT NULL,
  `orderId`         int         NOT NULL,
  `quantity`        int         NOT NULL DEFAULT 1,
  PRIMARY KEY (`itemId`, `orderId`),
  FOREIGN KEY (`itemId`) REFERENCES Item (`id`),
  FOREIGN KEY (`orderId`) REFERENCES TOrder (`id`)
);
