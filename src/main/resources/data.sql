INSERT INTO users(username, password, user_role) values ('admin@admin.pl', 'admin123', 'ADMIN');
INSERT INTO users(username, password, user_role) values ('ala@ala.pl', 'ala123', 'CUSTOMER');
INSERT INTO users(username, password, user_role) values ('jurek@jurek.pl', 'jurek123', 'CUSTOMER');
INSERT INTO users(username, password, user_role) values ('ula@ula.pl', 'ula123', 'CUSTOMER');
INSERT INTO users(username, password, user_role) values ('zenek@zenek.pl', 'zenek123', 'CUSTOMER');

INSERT INTO product_types(product_type) values ('PRODUCT_TYPE_1');
INSERT INTO product_types(product_type) values ('PRODUCT_TYPE_2');
INSERT INTO product_types(product_type) values ('PRODUCT_TYPE_3');
INSERT INTO product_types(product_type) values ('PRODUCT_TYPE_4');
INSERT INTO product_types(product_type) values ('PRODUCT_TYPE_5');
INSERT INTO product_types(product_type) values ('PRODUCT_TYPE_6');

INSERT INTO producers(description, name) values ('description_producer1', 'producer1');
INSERT INTO producers(description, name) values ('description_producer2', 'producer2');
INSERT INTO producers(description, name) values ('description_producer3', 'producer3');
INSERT INTO producers(description, name) values ('description_producer4', 'producer4');

INSERT INTO taxes(tax_rate, title) values (23, 'VAT tax');

INSERT INTO categories(category_name, description) values ('category1', 'category_description1');
INSERT INTO categories(category_name, description) values ('category2', 'category_description2');
INSERT INTO categories(category_name, description) values ('category3', 'category_description3');
INSERT INTO categories(category_name, description) values ('category4', 'category_description4');
INSERT INTO categories(category_name, description) values ('category5', 'category_description5');

INSERT INTO products(description, is_active, name, price, stock, producer_id, product_type_id, tax_id)
values ('description1', true, 'product1', 120, 10, 1, 1, 1);
INSERT INTO products(description, is_active, name, price, stock, producer_id, product_type_id, tax_id)
values ('description2', true, 'product2', 150, 8, 1, 1, 1);
INSERT INTO products(description, is_active, name, price, stock, producer_id, product_type_id, tax_id)
values ('description3', true, 'product3', 200, 5, 2, 1, 1);
INSERT INTO products(description, is_active, name, price, stock, producer_id, product_type_id, tax_id)
values ('description4', true, 'product4', 550, 9, 3, 2, 1);
INSERT INTO products(description, is_active, name, price, stock, producer_id, product_type_id, tax_id)
values ('description5', true, 'product5', 330, 12, 3, 2, 1);

INSERT INTO product_categories(category_id, product_id) values (1, 1);
INSERT INTO product_categories(category_id, product_id) values (1, 2);
INSERT INTO product_categories(category_id, product_id) values (1, 3);
INSERT INTO product_categories(category_id, product_id) values (2, 4);
INSERT INTO product_categories(category_id, product_id) values (2, 5);
INSERT INTO product_categories(category_id, product_id) values (2, 1);


INSERT INTO basket_products(quantity, total_price, product_id, user_id) values (3, 360, 1, 1);
INSERT INTO basket_products(quantity, total_price, product_id, user_id) values (1, 150, 2, 1);
INSERT INTO basket_products(quantity, total_price, product_id, user_id) values (2, 400, 3, 1);
INSERT INTO basket_products(quantity, total_price, product_id, user_id) values (1, 120, 1, 2);
INSERT INTO basket_products(quantity, total_price, product_id, user_id) values (5, 2750, 4, 3);

INSERT INTO payment_statuses(payment_status) values ('WAITING');
INSERT INTO payment_statuses(payment_status) values ('PROCESSED');
INSERT INTO payment_statuses(payment_status) values ('FAILED');
INSERT INTO payment_methods(payment_method) values ('CARD');

INSERT INTO shipment_statuses(shipment_status) values ('INITIAL');
INSERT INTO shipment_statuses(shipment_status) values ('PACKED');
INSERT INTO shipment_statuses(shipment_status) values ('PICKEDUP');
INSERT INTO shipment_statuses(shipment_status) values ('SHIPPED');
INSERT INTO shipment_statuses(shipment_status) values ('DELIVERED');

INSERT INTO shipment_methods(shipment_method, shipment_cost) values ('INPOST', 10);
INSERT INTO shipment_methods(shipment_method, shipment_cost) values ('DHL', 12);
INSERT INTO shipment_methods(shipment_method, shipment_cost) values ('Poczta', 8);

INSERT INTO order_statuses(order_status) values ('INCOMPLETE');
INSERT INTO order_statuses(order_status) values ('COMPLETE');
INSERT INTO order_statuses(order_status) values ('BACKORDERED');
INSERT INTO order_statuses(order_status) values ('CANCELED');
INSERT INTO order_statuses(order_status) values ('DECLINED');

INSERT INTO shipments(shipment_method_id, shipment_status_id) values ( 1, 1 );
INSERT INTO payments(payment_method_id, payment_status_id) values ( 1, 1 );