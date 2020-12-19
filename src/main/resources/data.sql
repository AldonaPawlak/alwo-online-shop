INSERT INTO user_roles(role) values ('CUSTOMER');
INSERT INTO user_roles(role) values ('ADMIN');

INSERT INTO users(email, password, role_id) values ('admin@admin.pl', 'admin123', 2);
INSERT INTO users(email, password, role_id) values ('ala@ala.pl', 'ala123', 1);
INSERT INTO users(email, password, role_id) values ('jurek@jurek.pl', 'jurek123', 1);
INSERT INTO users(email, password, role_id) values ('ula@ula.pl', 'ula123', 1);
INSERT INTO users(email, password, role_id) values ('zenek@zenek.pl', 'zenek123', 1);

INSERT INTO product_types(product_type) values ('TYPE1');
INSERT INTO product_types(product_type) values ('TYPE2');
INSERT INTO product_types(product_type) values ('TYPE3');
INSERT INTO product_types(product_type) values ('TYPE4');
INSERT INTO product_types(product_type) values ('TYPE5');
INSERT INTO product_types(product_type) values ('TYPE6');

INSERT INTO producers(description, name) values ('description_producer1', 'producer1');
INSERT INTO producers(description, name) values ('description_producer2', 'producer2');
INSERT INTO producers(description, name) values ('description_producer3', 'producer3');
INSERT INTO producers(description, name) values ('description_producer4', 'producer4');

INSERT INTO taxes(tax_rate, title) values (23, 'VAT tax');

INSERT INTO categories(category_name, description) values ('categoty1', 'category_description1');
INSERT INTO categories(category_name, description) values ('categoty2', 'category_description2');
INSERT INTO categories(category_name, description) values ('categoty3', 'category_description3');
INSERT INTO categories(category_name, description) values ('categoty4', 'category_description4');
INSERT INTO categories(category_name, description) values ('categoty5', 'category_description5');

INSERT INTO product_categories(product_id, category_id) values (1, 1);
INSERT INTO product_categories(product_id, category_id) values (2, 1);
INSERT INTO product_categories(product_id, category_id) values (3, 1);
INSERT INTO product_categories(product_id, category_id) values (4, 2);
INSERT INTO product_categories(product_id, category_id) values (5, 2);
INSERT INTO product_categories(product_id, category_id) values (1, 2);



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


