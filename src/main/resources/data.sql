INSERT INTO users(password, user_role, username) values ('$2a$10$CMJOFC33Vh8qgEjiCNd0ouHM.L9neRkdy6gMAMstsLVtYtUa3xt/.', 'CUSTOMER', 'wt@wt.pl');
INSERT INTO users(password, user_role, username) values ('$2a$10$GVKthzo4fSlXAow3/L8h9OYpaqq2zYKlckVg4l4socmsYxbl1MmgK', 'CUSTOMER', 'aldona@aldona.pl');
INSERT INTO users(password, user_role, username) values ('$2a$10$ZyxYZVP90Q706VKi7aoZNepW2lmWMluifJEjyhT7V0/iOh2g.9sFy', 'ADMIN', 'admin@admin.pl');


INSERT INTO product_types(product_type) values ('Book');
INSERT INTO product_types(product_type) values ('Audiobook');
INSERT INTO product_types(product_type) values ('Ebook');
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

INSERT INTO products(author, description, is_active, name, price, stock, producer_id, product_type_id, tax_id, url)
values ('author1', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', true, 'The Shadow of the Wind', 120, 10, 1, 1, 1, '0.jpg');
INSERT INTO products(author, description, is_active, name, price, stock, producer_id, product_type_id, tax_id, url)
values ('author2', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', true, 'A Novel Bookstore', 150, 8, 1, 1, 1, '1.jpg');
INSERT INTO products(author, description, is_active, name, price, stock, producer_id, product_type_id, tax_id, url)
values ('author3', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', true, 'My Dark Vanessa', 200, 5, 2, 1, 1, '2.jpg');
INSERT INTO products(author, description, is_active, name, price, stock, producer_id, product_type_id, tax_id, url)
values ('author4', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', true, 'The Midnight Library', 150, 9, 3, 2, 1, '3.jpg');
INSERT INTO products(author, description, is_active, name, price, stock, producer_id, product_type_id, tax_id, url)
values ('author5', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', true, 'Historia Pewnego Związku', 330, 12, 3, 2, 1,'4.jpg');

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

INSERT INTO payment_methods(description, payment_method, url) values ('Traditional transfer, pay at the post office or in your bank.', 'Traditional bank transfer', 'banktransfer.jpg');
INSERT INTO payment_methods(description, payment_method, url) values ('Payment by card or bank transfer, pay quickly and conveniently, by credit card or online transfer. ', 'Internet payment PayU', 'payu.jpg');
INSERT INTO payment_methods(description, payment_method, url) values ('Cash on delivery, pay when you receive the package. ', 'Cash on delivery', 'cashondelivery.jpg');

INSERT INTO shipment_statuses(shipment_status) values ('INITIAL');
INSERT INTO shipment_statuses(shipment_status) values ('PACKED');
INSERT INTO shipment_statuses(shipment_status) values ('PICKEDUP');
INSERT INTO shipment_statuses(shipment_status) values ('SHIPPED');
INSERT INTO shipment_statuses(shipment_status) values ('DELIVERED');

INSERT INTO shipment_methods(shipment_method, shipment_cost) values ('INPOST', 10);
INSERT INTO shipment_methods(shipment_method, shipment_cost) values ('DHL', 12);
INSERT INTO shipment_methods(shipment_method, shipment_cost) values ('POST', 8);

INSERT INTO order_statuses(order_status) values ('INCOMPLETE');
INSERT INTO order_statuses(order_status) values ('COMPLETE');
INSERT INTO order_statuses(order_status) values ('BACKORDERED');
INSERT INTO order_statuses(order_status) values ('CANCELED');
INSERT INTO order_statuses(order_status) values ('DECLINED');

INSERT INTO shipments(shipment_method_id, shipment_status_id) values ( 1, 1 );
INSERT INTO payments(payment_method_id, payment_status_id) values ( 1, 1 );
