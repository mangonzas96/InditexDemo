CREATE TABLE brands (
    brand_id int NOT NULL auto_increment,
    brand_ref int NOT NULL UNIQUE,
    name varchar(100) NOT NULL,
    PRIMARY KEY (brand_id)
);

CREATE TABLE products (
    product_id int NOT NULL auto_increment,     
    product_ref int NOT NULL UNIQUE,
    brand_ref int NOT NULL,
    name varchar(100) NOT NULL,
    description varchar(500) NOT NULL,
    PRIMARY KEY (product_id),
    FOREIGN KEY (brand_ref) REFERENCES brands(brand_ref)
);

CREATE TABLE prices (
    price_id int NOT NULL auto_increment,
    product_ref int NOT NULL,
    start_date DATETIME NOT NULL,
    end_date DATETIME NOT NULL,
    price decimal(7,2) NOT NULL,
    currency char(3) NOT NULL,
    priority int NOT NULL,
    PRIMARY KEY (price_id),
    FOREIGN KEY (product_ref) REFERENCES products(product_ref)
);