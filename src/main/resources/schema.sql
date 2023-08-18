CREATE TABLE prices (
    price_id int NOT NULL auto_increment,
    brand_id int NOT NULL,
    product_id int NOT NULL,
    start_date DATETIME NOT NULL,
    end_date DATETIME NOT NULL,
    price decimal(7,2) NOT NULL,
    currency char(3) NOT NULL,
    priority int NOT NULL,
    primary key (price_id)
);