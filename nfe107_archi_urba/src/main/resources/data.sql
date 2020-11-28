-- TABLE CUSTOMER
INSERT INTO TABLE_CUSTOMER (id_customer, email, firstname, lastname, loyalty_points, phone_number) VALUES (1, 'florian.huber.auditeur@lecnam.net', 'Florian', 'Huber', 0, '0606060606')
INSERT INTO TABLE_CUSTOMER (id_customer, email, firstname, lastname, loyalty_points, phone_number) VALUES (2, 'hugo.fuchs-haenel.auditeur@lecnam.net',  'Hugo', 'Fuchs', 0, '0606060606')
INSERT INTO TABLE_CUSTOMER (id_customer, email, firstname, lastname, loyalty_points, phone_number) VALUES (3, 'florian.huber.auditeur@lecnam.net', 'Anthony', 'Dagon', 0, '0606060606')
INSERT INTO TABLE_CUSTOMER (id_customer, email, firstname, lastname, loyalty_points, phone_number) VALUES (4, 'aymeric.jannot.auditeur@lecnam.net', 'Aymeric', 'Jannot', 0,'0606060606')

-- TABLE ADDRESS
INSERT INTO TABLE_ADDRESS (id_address, address_number, city, country, postal_code, street, id_customer) VALUES (1, '8', 'Schiltigheim', 'France', '627300', 'Rue de wissembourg', 1)
INSERT INTO TABLE_ADDRESS (id_address, address_number, city, country, postal_code, street, id_customer) VALUES (2, '3A', 'Lipsheim', 'France', '67250', 'Rue de la croix', 2)
INSERT INTO TABLE_ADDRESS (id_address, address_number, city, country, postal_code, street, id_customer) VALUES (3, '2', 'Kogenheim', 'France', '67230', 'Impasse du hohwald', 3)
INSERT INTO TABLE_ADDRESS (id_address, address_number, city, country, postal_code, street, id_customer) VALUES (4, '48C', 'Obernai', 'France', '67210', 'Rue de selestat', 4)

-- TABLE PRODUCT
INSERT INTO TABLE_PRODUCT (id_product, description, name, price, stock) VALUES (1, 'CLAVIER GAMING MÉCANIQUE RVB SANS FIL LIGHTSPEED LOGITECH G915 TKL SANS PAVÉ NUMÉRIQUE', 'Clavier Logitech G915TKL', 229.00, 87)
INSERT INTO TABLE_PRODUCT (id_product, description, name, price, stock) VALUES (2, 'Découvrez Maytea, une boisson a base de véritable infusion de thé, mariée aux saveurs subtiles de fruits et de plantes', 'MAYTEA Parfum MENTHE', 0.84, 1634)

-- TABLE ORDER STATUS
INSERT INTO TABLE_ORDER_STATUS (id_order_status, description) VALUES (0, 'En cours de création')
INSERT INTO TABLE_ORDER_STATUS (id_order_status, description) VALUES (1, 'En attente de paiement')
INSERT INTO TABLE_ORDER_STATUS (id_order_status, description) VALUES (2, 'Payé')
INSERT INTO TABLE_ORDER_STATUS (id_order_status, description) VALUES (3, 'En cours de préparation')
INSERT INTO TABLE_ORDER_STATUS (id_order_status, description) VALUES (4, 'Prêt à livrer')
INSERT INTO TABLE_ORDER_STATUS (id_order_status, description) VALUES (5, 'En transit')
INSERT INTO TABLE_ORDER_STATUS (id_order_status, description) VALUES (6, 'Livré')


-- TABLE ORDER
INSERT INTO TABLE_ORDER (id_order, date, total_price, id_address, id_customer, id_order_status) VALUES (1, '28/11/2020', 229.0, 3, 3, 0)
INSERT INTO TABLE_ORDER (id_order, date, total_price, id_address, id_customer, id_order_status) VALUES (2, '27/11/2020', 0.84, 1, 1, 0)

-- TABLE ORDER_PRODUCT
INSERT INTO ORDER_PRODUCT (id_order, id_product, quantity) VALUES (1, 1, 2)
INSERT INTO ORDER_PRODUCT (id_order, id_product, quantity) VALUES (2, 2, 1)
