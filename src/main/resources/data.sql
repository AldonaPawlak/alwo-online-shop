INSERT INTO users(password, user_role, username) values ('$2a$10$CMJOFC33Vh8qgEjiCNd0ouHM.L9neRkdy6gMAMstsLVtYtUa3xt/.', 'CUSTOMER', 'wt@wt.pl');
INSERT INTO users(password, user_role, username) values ('$2a$10$GVKthzo4fSlXAow3/L8h9OYpaqq2zYKlckVg4l4socmsYxbl1MmgK', 'CUSTOMER', 'aldona@aldona.pl');
INSERT INTO users(password, user_role, username) values ('$2a$10$ZyxYZVP90Q706VKi7aoZNepW2lmWMluifJEjyhT7V0/iOh2g.9sFy', 'ADMIN', 'admin@admin.pl');


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

INSERT INTO categories(category_name, description) values ('Children', 'Children');
INSERT INTO categories(category_name, description) values ('Fiction', 'Fiction');
INSERT INTO categories(category_name, description) values ('Non-Fiction', 'Non-Fiction');
INSERT INTO categories(category_name, description) values ('Drama', 'Drama');
INSERT INTO categories(category_name, description) values ('Poetry', 'Poetry');
INSERT INTO categories(category_name, description) values ('Fairy Tale', 'Fairy Tale');

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


INSERT INTO basket_products(quantity, product_id, user_id) values (3, 1, 1);
INSERT INTO basket_products(quantity, product_id, user_id) values (1, 2, 1);
INSERT INTO basket_products(quantity, product_id, user_id) values (2, 3, 1);
INSERT INTO basket_products(quantity, product_id, user_id) values (1, 1, 2);
INSERT INTO basket_products(quantity, product_id, user_id) values (5, 4, 2);

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
