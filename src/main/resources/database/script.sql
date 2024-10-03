CREATE DATABASE foofast_db;
USE foofast_db;

CREATE TABLE `Categories` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL UNIQUE,
    `is_active` TINYINT DEFAULT 1,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `Categories` (`name`)
VALUES ('Beverage'), 
       ('Food');


CREATE TABLE `Discounts` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `percent` INT NOT NULL ,
    `start_date` DATE NOT NULL,
    `end_date` DATE NOT NULL,
    `is_active` TINYINT DEFAULT 1,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `Discounts` (`percent`,  `start_date`, `end_date`, `is_active`)
VALUES 
    (10, '2024-06-01', '2024-06-30', 1),
    (20, '2024-12-01', '2024-12-31', 1),
    (15, '2024-09-01', '2024-09-30', 1),
    (25,  '2024-03-01', '2024-03-31', 1),
    (5,  '2024-01-01', '2024-01-31', 1);



CREATE TABLE `Products` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    `price` BIGINT NOT NULL,
    `quantity_in_stock` INT NOT NULL,
    `image` VARCHAR(255) DEFAULT NULL,
    `purchase_count` INT DEFAULT 0,
    `is_active` TINYINT DEFAULT 1,
    `category_id` INT NOT NULL,
    `discount_id` INT DEFAULT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`category_id`) REFERENCES `Categories`(`id`),
    FOREIGN KEY (`discount_id`) REFERENCES `Discounts`(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `Products` (`name`, `price`, `quantity_in_stock`, `image`, `purchase_count`, `is_active`, `category_id`, `discount_id`)
VALUES 
    ('Coca Cola', 10, 100, '/images/coca_cola.png', 50, 1, 100, 10001),
    ('Pepsi', 9, 150, '/images/pepsi.png', 60, 1, 100, NULL),
    ('Burger', 5, 200, '/images/burger.png', 120, 1, 101, 10002),
    ('Pizza', 12, 80, '/images/pizza.png', 70, 1, 101, NULL),
    ('Sandwich', 6, 150, '/images/sandwich.png', 90, 1, 101, 10004),
    ('Orange Juice', 8, 120, '/images/orange_juice.png', 40, 1, 100, 10001),
    ('Apple Juice', 7, 130, '/images/apple_juice.png', 45, 1, 100, 10003),
	('French Fries', 4, 180, '/images/french_fries.png', 110, 1, 101, NULL),
	('Chicken Wings', 15, 90, '/images/chicken_wings.png', 100, 1, 101, 10001),
	('Taco', 9, 60, '/images/taco.png', 80, 1, 101, 10001),
	('Milkshake', 10, 140, '/images/milkshake.png', 50, 1, 100, 10002);
    



CREATE TABLE `Roles` (
	`id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL UNIQUE,
    `is_active` TINYINT DEFAULT 1,
    
    PRIMARY KEY(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `Roles` (`name`)
VALUES ('User'), 
       ('Admin');
       
CREATE TABLE `Users` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(255) NOT NULL,
    `last_name` VARCHAR(255) NOT  NULL,
    `password` varchar(255) NOT NULL,
    `email` varchar(255) NOT NULL UNIQUE,
	`username` varchar(255) UNIQUE ,
    `phone` VARCHAR(20) UNIQUE,
    `is_active` TINYINT DEFAULT 1,
    `role_id` INT NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`role_id`) REFERENCES `Roles`(`id`)
)  ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `Users` (`first_name`, `last_name`, `password`,`email`, `username`, `phone`, `is_active`, `role_id`)
VALUES
('John', 'Doe', 'password123',"john123@gmail.com", 'johndoe', '123-456-7890', 1, 1),
('Jane', 'Smith', 'password123',"jane123@gmail.com", 'janesmith', '123-456-7891', 1, 1),
('Alice', 'Johnson', 'password123',"alice123@gmail.com", 'alicejohnson', '123-456-7892', 1, 2),
('Bob', 'Brown', 'password123',"bob123@gmail.com", 'bobbrown', '123-456-7893', 1, 2),
('Charlie', 'Davis', 'password123',"charlie@gmail.com", 'charliedavis', '123-456-7894', 1, 1),
('David', 'Wilson', 'password123',"david123@gmail.com", 'davidwilson', '123-456-7895', 1, 2),
('Emily', 'Moore', 'password123',"emily123@gmail.com", 'emymoore', '123-456-7896', 1, 1),
('Frank', 'Taylor', 'password123',"frank123@gmail.com", 'franktaylor', '123-456-7897', 1, 2),
('Grace', 'Anderson', 'password123',"grace123@gmail.com", 'graceanderson', '123-456-7898', 1, 1),
('Hannah', 'Thomas', 'password123',"hannah123@gmail.com", 'hannahthomas', '123-456-7899', 1, 2);



CREATE TABLE `Invoices` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `total_price` BIGINT NOT NULL, 
    `time_print_invoice` DATETIME NOT NULL,
    `note` LONGTEXT DEFAULT NULL,
    `is_active` TINYINT DEFAULT 1,
    `user_id` BIGINT NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_id`) REFERENCES `Users`(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `Invoices` (`total_price`, `time_print_invoice`,  `is_active`, `user_id`)
VALUES
(70.00, '2024-09-15 14:30:00',  1, 10000),
(64.00, '2024-09-15 15:00:00',  1, 10002),
(90.00, '2024-09-16 09:00:00',  1, 10000),
(200.00, '2024-09-16 10:00:00', 1, 10003);



CREATE TABLE `Invoices_detail` (
    `invoice_id` BIGINT NOT NULL,             
    `product_id` BIGINT NOT NULL,             
    `quantity` INT NOT NULL,                  
    `price_per_list` BIGINT NOT NULL, 
    PRIMARY KEY (`invoice_id`, `product_id`), 
    FOREIGN KEY (`invoice_id`) REFERENCES `Invoices`(`id`),
    FOREIGN KEY (`product_id`) REFERENCES `Products`(`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `Invoices_detail` (`invoice_id`, `product_id`, `quantity`, `price_per_list`)
VALUES
(1000000, 1000002, 2, 10.00), 
(1000000, 1000003, 5, 60.00), 
(1000001, 1000004, 3, 24.00), 
(1000001, 1000005, 5, 40.00), 
(1000002, 1000001, 10, 90.00), 
(1000003, 1000003, 10, 120.00), 
(1000003, 1000005, 10, 80.00);
