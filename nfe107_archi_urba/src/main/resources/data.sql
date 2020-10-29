-- TABLE ADDRESS
INSERT INTO TABLE_ADDRESS (id_address, address_number, city, country, postal_code, street) VALUES (1, '8', 'Schiltigheim', 'France', '627300', 'Rue de wissembourg')
INSERT INTO TABLE_ADDRESS (id_address, address_number, city, country, postal_code, street) VALUES (2, '3A', 'Lipsheim', 'France', '67250', 'Rue de la croix')
INSERT INTO TABLE_ADDRESS (id_address, address_number, city, country, postal_code, street) VALUES (3, '4', 'Kogenheim', 'France', '67230', 'Impasse du hohwald')
INSERT INTO TABLE_ADDRESS (id_address, address_number, city, country, postal_code, street) VALUES (4, '48C', 'Obernai', 'France', '67210', 'Rue de selestat')


-- TABLE CUSTOMER
INSERT INTO TABLE_CUSTOMER (id_customer, firstname, lastname, email, phone_number, address) VALUES (1, 'Florian', 'Huber', 'florian.huber.auditeur@lecnam.net', '0606060606', 1)
INSERT INTO TABLE_CUSTOMER (id_customer, firstname, lastname, email, phone_number, address) VALUES (2, 'Hugo', 'Fuchs', 'hugo.fuchs-haenel.auditeur@lecnam.net', '0606060606', 2)
INSERT INTO TABLE_CUSTOMER (id_customer, firstname, lastname, email, phone_number, address) VALUES (3, 'Anthony', 'Dagon', 'florian.huber.auditeur@lecnam.net', '0606060606', 3)
INSERT INTO TABLE_CUSTOMER (id_customer, firstname, lastname, email, phone_number, address) VALUES (4, 'Aymeric', 'Jannot', 'aymeric.jannot.auditeur@lecnam.net', '0606060606', 4)
INSERT INTO TABLE_ADDRESS_CUSTOMERS (ADDRESS_ID_ADDRESS, CUSTOMERS_ID_CUSTOMER) VALUES (1, 1)
INSERT INTO TABLE_ADDRESS_CUSTOMERS (ADDRESS_ID_ADDRESS, CUSTOMERS_ID_CUSTOMER) VALUES (2, 2)
INSERT INTO TABLE_ADDRESS_CUSTOMERS (ADDRESS_ID_ADDRESS, CUSTOMERS_ID_CUSTOMER) VALUES (3, 3)
INSERT INTO TABLE_ADDRESS_CUSTOMERS (ADDRESS_ID_ADDRESS, CUSTOMERS_ID_CUSTOMER) VALUES (4, 4)

-- TABLE PRODUCT
INSERT INTO TABLE_PRODUCT (id_product, name, description, price) VALUES (1, 'BMW Série 1', 'La Nouvelle BMW Série 1 est jeune, cool et urbaine. Par ses proportions compactes, sa ligne de toit fluide, ses courbes dynamiques et affûtées, elle promet une agilité et un plaisir de conduire immédiats. L’habitacle est contemporain.', 24850.00)
INSERT INTO TABLE_PRODUCT (id_product, name, description, price) VALUES (2, 'BMW M135i xDrive', 'Plus de « wow ! » : le design sportif innovant de la Nouvelle BMW M135i xDrive semble avoir été pensé pour capter immédiatement tous les regards. LLes projecteurs Full LED se combinent pour produire une forte première impression.', 52950.00)
INSERT INTO TABLE_PRODUCT (id_product, name, description, price) VALUES (3, 'BMW i3', 'La BMW i3 ne suit aucune tendance, elle est l’expression d’un style de vie assumé. Son langage stylistique futuriste lui confère également de la clarté à l’extérieur et une ambiance « lounge » à l’intérieur..', 39950.00)

-- TABLE ORDER
INSERT INTO TABLE_ORDER (id_order, date, total_price) VALUES (1, '29/10/2020', 24850.00)
INSERT INTO ORDERS_PRODUCTS (id_product, id_order) VALUES (1, 1)
INSERT INTO TABLE_ORDER (id_order, date, total_price) VALUES (2, '29/10/2020', 39950.00)
INSERT INTO ORDERS_PRODUCTS (id_product, id_order) VALUES (3, 2)
INSERT INTO TABLE_ORDER (id_order, date, total_price) VALUES (3, '29/10/2020', 52950.00)
INSERT INTO ORDERS_PRODUCTS (id_product, id_order) VALUES (2, 3)
INSERT INTO CUSTOMERS_ORDERS (ID_ORDER, ID_CUSTOMER) VALUES (1, 1)
INSERT INTO CUSTOMERS_ORDERS (ID_ORDER, ID_CUSTOMER) VALUES (2, 2)
INSERT INTO CUSTOMERS_ORDERS (ID_ORDER, ID_CUSTOMER) VALUES (3, 2)
