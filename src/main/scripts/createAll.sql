-- createAll.sql
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

-- createSale.sql
drop table if exists Sale;
CREATE TABLE `Sale` (
  `itemId`          integer     NOT NULL,
  `percentOff`      integer     NOT NULL,
  `startDt`         text        NOT NULL,
  `expireDt`        text        NOT NULL,
  FOREIGN KEY (`itemId`) REFERENCES Item (`id`)
);

-- createTOrder.sql
drop table if exists TOrder;
CREATE TABLE `TOrder` (
  `id`              integer     PRIMARY KEY,
  `custId`          integer     NOT NULL,
  `totalPriceCents` integer     NOT NULL,
  `status`          text        NOT NULL,
  `discountCode`    text        DEFAULT NULL,
  `orderDt`         text        NOT NULL,
  `deliverDt`       text        DEFAULT NULL,
  FOREIGN KEY (`custId`) REFERENCES Customer (`id`),
  FOREIGN KEY (`discountCode`) REFERENCES Discount (`code`)
);

-- createAdmin.sql
drop table if exists Admin;
CREATE TABLE `Admin` (
  `id`              integer     PRIMARY KEY,
  `name`            text        NOT NULL, -- use name as salt
  `verifier`        integer     NOT NULL
);

-- createCustomer.sql
drop table if exists Customer;
CREATE TABLE `Customer` (
  `id`              integer     PRIMARY KEY,
  `name`            text        DEFAULT NULL,
  `state`           text        DEFAULT NULL, 
  `birthDt`         text        DEFAULT NULL,
  `creatDt`         text        NOT NULL,
  `status`          text        NOT NULL DEFAULT 'ACTIVE',
  `gender`          text        DEFAULT 'U'
);

-- createDiscount.sql
drop table if exists Discount;
CREATE TABLE `Discount` (
  `code`            text        NOT NULL,
  `percentOff`      integer     NOT NULL,
  `startDt`         text        NOT NULL,
  `expireDt`        text        NOT NULL,
  PRIMARY KEY (`code`)
);

-- createItem.sql
drop table if exists Item;
CREATE TABLE `Item` (
  `id`              integer     PRIMARY KEY,
  `name`            text        NOT NULL,
  `stock`           integer     DEFAULT 0 NOT NULL, 
  `pricecents`      integer     NOT NULL,
  `imagepath`       text        DEFAULT NULL
);
