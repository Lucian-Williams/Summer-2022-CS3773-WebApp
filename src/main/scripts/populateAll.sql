-- populateAll.sql
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

INSERT INTO `Admin`
(name, verifier)
VALUES
    ('Mike Olin', 1431513),
    ('Luis Ortega', 846163),
    ('Jimbo Teepose', 2293814),
    ('John Smith', 11296),
    ('Perry Sona', 551026);

INSERT INTO `Customer`
(name, state, birthDt, creatDt, status, gender)
VALUES
    ('Kirby', NULL, '1992-04-27', '2022-07-31', 'ACTIVE', 'M'),
    ('Loid', 'KY', NULL, '2022-07-30', 'CLOSED', 'M'),
    ('Chell', 'MI', NULL, '2022-07-31', 'ACTIVE', 'F'),
    ('M1911', 'CT', '1911-03-29', '2022-04-20', 'BANNED', 'U');

INSERT INTO `Item`
(name, stock, pricecents, imagepath)
VALUES
    ('Hydraulic Press', 7, 99999, 'hydraulic_press.png'),
    ('Huntsman Spider', 56, 4999, 'huntsman_spider.png'),
    ('Pullup Bar', 28, 9999, 'pullup_bar.png'),
    ('T-72 MBT', 46, 9999999, 't-72_mbt.png');

INSERT INTO `Discount`
(code, percentOff, startDt, expireDt)
VALUES
    ('TWILIGHTSPARKLE', 5, '2022-07-30', '2022-08-01');

INSERT INTO `Sale`
(itemId, percentOff, startDt, expireDt)
VALUES
    (2, 90, '2022-07-31', '2022-08-05'),
    (4, 50, '2022-02-24', '2022-08-05');

INSERT INTO `TOrder`
(custId, totalPriceCents, status, disCountCode, orderDt, deliverDt)
VALUES
    (1, 109250, 'FULFILLED', 'TWILIGHTSPARKLE', '2022-07-31', '2022-07-31'),
    (2, 9500, 'PLACED', 'TWILIGHTSPARKLE', '2022-08-01', NULL),
    (3, 5000000, 'CANCELLED', NULL, '2022-07-31', NULL),
    (3, 9500, 'FULFILLED', 'TWILIGHTSPARKLE', '2022-07-31', '2022-08-01');

INSERT INTO `ItemsToOrders`
(itemId, orderId, quantity)
VALUES
    (1, 1, 1),
    (2, 1, 30),
    (3, 2, 1),
    (4, 3, 1),
    (3, 4, 1);
