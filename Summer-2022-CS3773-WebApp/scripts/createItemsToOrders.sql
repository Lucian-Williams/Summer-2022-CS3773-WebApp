-- createItemsToOrders.sql
drop table if exists ItemsToOrders;
CREATE TABLE `ItemsToOrders` (
  `itemId`          integer     NOT NULL,
  `orderId`         integer     NOT NULL,
  `quantity`        integer     NOT NULL DEFAULT 1,
  PRIMARY KEY (`itemId`, `orderId`),
  FOREIGN KEY (`itemId`) REFERENCES Item (`id`),
  FOREIGN KEY (`orderId`) REFERENCES TOrder (`id`)
);
