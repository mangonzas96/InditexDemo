INSERT INTO brands (brand_ref, name) VALUES (1, 'ZARA');

INSERT INTO products (product_ref, brand_ref, name, description) VALUES (35455, 1, 'CAMISA FLUIDA', 'Camisa relaxed fit confeccionada en tejido fluido con mezcla de modal. Cuello bowling y manga larga acabada en puño con botón. Bajo con aberturas laterales. Cierre frontal de botonadura.');

INSERT INTO prices (product_ref, start_date, end_date, price, currency, priority) VALUES (35455, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 35.50, 'EUR', 0);
INSERT INTO prices (product_ref, start_date, end_date, price, currency, priority) VALUES (35455, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 25.45, 'EUR', 1);
INSERT INTO prices (product_ref, start_date, end_date, price, currency, priority) VALUES (35455, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 30.50, 'EUR', 1);
INSERT INTO prices (product_ref, start_date, end_date, price, currency, priority) VALUES (35455, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 38.95, 'EUR', 1);