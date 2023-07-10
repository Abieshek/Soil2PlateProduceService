SET SQL_SAFE_UPDATES=0;

use soil2plateproduceservice;

CREATE TABLE `foods` (
  `food_id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `name` VARCHAR(255) ,
  `food_CO2` FLOAT NOT NULL DEFAULT 0,
  `image_link` VARCHAR(512)
);

INSERT INTO foods (name, food_CO2, image_link) VALUES   ('Egg', 1, 'https://www.wattagnet.com/ext/resources/2021/10/21/brown-and-white-eggs.jpeg'),
                                                        ('Apple', 1, 'https://extension.umn.edu/sites/extension.umn.edu/files/Two%20apples%20close-up_screen.jpg'),
                                                        ('Banana', 1, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQCl-IXbysY825_xdvHu_mCe_uBzK94mFWnXIBBpAOVDl55LIdclWKgCre8qe7qyaDSdp4&usqp=CAU'),
                                                        ('Vegetable', 1, 'https://image.com'),
                                                        ('Avocado', 1, 'https://www.logees.com/media/catalog/product/cache/088d41982d5ddfc4a0a1e449b5ddd946/R/2/R2129-6G-large.jpg'),
                                                        ('Potato', 1, 'https://www.tastingtable.com/img/gallery/types-of-potatoes-and-when-to-use-them/intro-1653161267.webp');

CREATE TABLE `produce` (
  `produce_id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `farmer_id` INT,
  `food_id` INT,
  `name` VARCHAR(255),
  `type` VARCHAR(255) ,
  `price` FLOAT,
  `quantity` INT DEFAULT 0,
  `description` VARCHAR(255),
  `available_from` DATE,
  `available_until` DATE,
  `surplus_status` BOOL DEFAULT false,
  `produce_CO2` FLOAT,
  `carbohydrates` INT,
  `calories` INT,
  `vitamins` VARCHAR(255),
  `allergy_information` VARCHAR(255),
  `image_link` VARCHAR(512)
);

ALTER TABLE `produce` ADD FOREIGN KEY (`food_id`) REFERENCES `foods` (`food_id`);
ALTER TABLE produce ENGINE = InnoDB;
ALTER TABLE foods ENGINE = InnoDB;

INSERT INTO produce (farmer_id, food_id ,name, type, price, quantity, description, available_from, available_until, surplus_status, produce_CO2, carbohydrates, calories, vitamins, allergy_information, image_link)
VALUES  (1, (SELECT food_id FROM foods WHERE food_id = 1), 'Free-Range Egg', 'Egg', 8.99, 12, 'it is cage free egg', '2023-05-31', '2023-07-21', true, 1.02, 222, 323, 'vitamin E, folate', 'egg allergy', 'https://upload.wikimedia.org/wikipedia/commons/7/75/FreeRangeEgg.jpg'),
        (1, (SELECT food_id FROM foods WHERE food_id = 1), 'Organic Egg', 'Egg', 8.99, 12, 'it is cage free egg', '2023-05-31', '2023-07-21', true, 1.02, 222, 323, 'vitamin E, folate', 'egg allergy', 'https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcQ6lgLZjOOAVXuJj3BMEjO4VBb7t2-sudOeDkLvQcpo58fu99Xyy3evs_XlpLYEhjr0FQr-DtWTlN1ixk5WLhbip8MTG56e8Vl9qSPuW8l9y7Z8BAMjT87U'),
        (1, (SELECT food_id FROM foods WHERE food_id = 1), 'Pastured Egg', 'Egg', 8.99, 12, 'it is cage free egg', '2023-05-31', '2023-07-21', true, 1.02, 222, 323, 'vitamin E, folate', 'egg allergy', 'https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcSr4nnPeZk12llqct7Mazs9kSZcJUqfkpCaerIfOiKB8Oi1lFyrUyM0e_Tny28np_KqXvBIFJ9AibaV_HzPF-hiHiwBF4V38PAIWEpBxlw'),
        (1, (SELECT food_id FROM foods WHERE food_id = 2), 'Empire Apple', 'fruit', 6.99, 5, 'it is an organic Empire apple', '2023-06-10', '2023-07-21', true, 1.2, 222, 323, 'Vitamin B6, E, B1, C', 'fruits allergy', 'https://www.jessicagavin.com/wp-content/uploads/2020/10/empire-apples-1.jpg'),
        (1, (SELECT food_id FROM foods WHERE food_id = 2), 'Fuji Apple', 'fruit', 6.99, 5, 'it is an organic Fuji apple', '2023-06-10', '2023-07-21', true, 1.2, 222, 323, 'Vitamin B6, E, B1, C', 'fruits allergy', 'https://www.jessicagavin.com/wp-content/uploads/2020/10/types-of-apples-fuji.jpg'),
        (1, (SELECT food_id FROM foods WHERE food_id = 2), 'Pink Lady Apple', 'fruit', 6.99, 5, 'it is an organic Pink Lady apple', '2023-06-10', '2023-07-21', true, 1.2, 222, 323, 'Vitamin B6, E, B1, C', 'fruits allergy', 'https://www.jessicagavin.com/wp-content/uploads/2020/10/types-of-apples-pink-lady.jpg'),
        (1, (SELECT food_id FROM foods WHERE food_id = 2), 'Honey Crisp Apple', 'fruit', 6.99, 5, 'it is an organic Honey Crisp apple', '2023-06-10', '2023-07-21', true, 1.2, 222, 323, 'Vitamin B6, E, B1, C', 'fruits allergy', 'https://www.jessicagavin.com/wp-content/uploads/2020/10/types-of-apples-honeycrisp.jpg'),
        (1, (SELECT food_id FROM foods WHERE food_id = 2), 'Envy Apple', 'fruit', 6.99, 5, 'it is an organic Envy apple', '2023-06-10', '2023-07-21', true, 1.2, 222, 323, 'Vitamin B6, E, B1, C', 'fruits allergy', 'https://www.jessicagavin.com/wp-content/uploads/2020/10/types-of-apples-envy.jpg'),
        (1, (SELECT food_id FROM foods WHERE food_id = 3), 'LADY FINGER Banana', 'fruit', 5.19, 10, 'it is an Organic Banana', '2023-06-01', '2023-07-21', true, 1.2, 222, 323, 'Vitamins B6, C, E', 'fruits allergy', 'https://www.butter-n-thyme.com/wp-content/uploads/2022/12/Lady-Finger-bananas.jpg'),
        (1, (SELECT food_id FROM foods WHERE food_id = 3), 'BLUE JAVA Banana', 'fruit', 9.99, 6, 'it is an organic Orange', '2023-06-11', '2023-07-12', true, 1.2, 222, 323, 'Vitamin C', 'citrus allergy', 'https://www.butter-n-thyme.com/wp-content/uploads/2022/12/Blue-Java-bananas.jpg'),
        (1, (SELECT food_id FROM foods WHERE food_id = 5), 'Hass Avocado', 'fruit', 4, 9.99, 'it is an Organic Hass Avocado', '2023-06-02', '2023-08-01', true, 1.02, 122, 329, 'Vitamins C, K, E, B6', 'fruits allergy', 'https://insanelygoodrecipes.com/wp-content/uploads/2022/10/Sliced-Organic-Hass-Avocado-1024x1024.webp'),
        (1, (SELECT food_id FROM foods WHERE food_id = 5), 'Bacon Avocado', 'fruit', 5, 10, 'it is an Organic Mango - Non GMO', '2023-06-03', '2023-06-30', true, 1.01, 221, 223, 'Vitamin A, C', 'Avocado allergy', 'https://insanelygoodrecipes.com/wp-content/uploads/2022/10/Green-Smooth-Bacon-Avocados-1024x1024.webp'),
        (1, (SELECT food_id FROM foods WHERE food_id = 5), 'Fuerte Avocado', 'fruit', 5, 10, 'it is an Organic Fuerte Avocado - Non GMO', '2023-06-03', '2023-06-30', true, 1.01, 221, 223, 'Vitamin A, C', 'Avocado allergy', 'https://insanelygoodrecipes.com/wp-content/uploads/2022/10/Green-Smooth-Bacon-Avocados-1024x1024.webp'),
        (1, (SELECT food_id FROM foods WHERE food_id = 5), 'Red Avocado', 'fruit', 5, 10, 'it is an Organic Mango - Non GMO', '2023-06-03', '2023-06-30', true, 1.01, 221, 223, 'Vitamin A, C', 'Avocado allergy', 'https://previews.123rf.com/images/efired/efired1706/efired170600077/81034605-closeup-view-of-fresh-ripe-avocados-on-dark-background-red-fruits-healthy-eco-food-product-of.jpg'),
        (1, (SELECT food_id FROM foods WHERE food_id = 5), 'Stewart Avocado', 'fruit', 5, 10, 'it is an Organic Stewart Avocado - Non GMO', '2023-06-03', '2023-06-30', true, 1.01, 221, 223, 'Vitamin A, C', 'Avocado allergy', 'https://specialtyproduce.com/sppics/11472.png'),
        (1, (SELECT food_id FROM foods WHERE food_id = 6), 'Russet Potato', 'Vegetable', 5, 10, 'it is an Organic Russet Potato', '2023-06-04', '2023-06-29', true, 1.2, 222, 323, 'vitamin B-complex', 'potatoes allergy', 'https://insanelygoodrecipes.com/wp-content/uploads/2022/10/Russet.webp'),
        (1, (SELECT food_id FROM foods WHERE food_id = 6), 'Red Potato', 'Vegetable', 5, 10, 'it is an Organic Red  Potato', '2023-06-04', '2023-06-29', true, 1.2, 222, 323, 'vitamin B-complex, C', 'potatoes allergy', 'https://images.albertsons-media.com/is/image/ABS/184500048?$ng-ecom-pdp-desktop$&defaultImage=Not_Available'),
        (1, (SELECT food_id FROM foods WHERE food_id = 6), 'Sweet Potato', 'Vegetable', 5, 10, 'it is an Organic Sweet Potato', '2023-06-04', '2023-06-29', true, 1.2, 222, 323, 'vitamin B-complex, C', 'potatoes allergy', 'https://target.scene7.com/is/image/Target/GUEST_29dce6fc-271e-434c-9bbb-a971b7b570c6?wid=325&hei=325&qlt=80&fmt=pjpeg'),
        (1, (SELECT food_id FROM foods WHERE food_id = 6), 'Petite Potato', 'Vegetable', 5, 10, 'it is an Organic Petite Potato', '2023-06-04', '2023-06-29', true, 1.2, 222, 323, 'vitamin B-complex, C', 'potatoes allergy', 'https://images.albertsons-media.com/is/image/ABS/184500048?$ng-ecom-pdp-tn$&defaultImage=Not_Available');

SELECT * FROM produce;