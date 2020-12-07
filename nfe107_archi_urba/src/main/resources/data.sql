-- TABLE CUSTOMER
INSERT INTO TABLE_CUSTOMER (id_customer, firstname, lastname, email, phone_number, loyalty_points) VALUES (1, 'Florian', 'Huber', 'florian.huber.auditeur@lecnam.net', '0606060606', 0)
INSERT INTO TABLE_CUSTOMER (id_customer, firstname, lastname, email, phone_number, loyalty_points) VALUES (2, 'Hugo', 'Fuchs', 'hugo.fuchs-haenel.auditeur@lecnam.net', '0606060606', 0)
INSERT INTO TABLE_CUSTOMER (id_customer, firstname, lastname, email, phone_number, loyalty_points) VALUES (3, 'Anthony', 'Dagon', 'florian.huber.auditeur@lecnam.net', '0606060606', 0)
INSERT INTO TABLE_CUSTOMER (id_customer, firstname, lastname, email, phone_number, loyalty_points) VALUES (4, 'Aymeric', 'Jannot', 'aymeric.jannot.auditeur@lecnam.net', '0606060606', 0)

-- TABLE ADDRESS
INSERT INTO TABLE_ADDRESS (id_address, address_number, city, country, postal_code, street, id_customer) VALUES (1, '8', 'Schiltigheim', 'France', '67300', 'Rue de Wissembourg', 1)
INSERT INTO TABLE_ADDRESS (id_address, address_number, city, country, postal_code, street, id_customer) VALUES (2, '3A', 'Lipsheim', 'France', '67250', 'Rue de la Croix', 2)
INSERT INTO TABLE_ADDRESS (id_address, address_number, city, country, postal_code, street, id_customer) VALUES (3, '2', 'Kogenheim', 'France', '67230', 'Impasse du Hohwald', 3)
INSERT INTO TABLE_ADDRESS (id_address, address_number, city, country, postal_code, street, id_customer) VALUES (4, '48C', 'Obernai', 'France', '67210', 'Rue de Selestat', 4)

-- TABLE PRODUCT
INSERT INTO TABLE_PRODUCT (id_product, name, description, price, stock) VALUES (1, 'CLAVIER GAMING MÉCANIQUE RVB SANS FIL LIGHTSPEED LOGITECH G915 TKL SANS PAVÉ NUMÉRIQUE', 'Clavier Logitech G915TKL', 229.00, 87)
INSERT INTO TABLE_PRODUCT (id_product, name, description, price, stock) VALUES (2, 'Découvrez Maytea, une boisson a base de véritable infusion de thé, mariée aux saveurs subtiles de fruits et de plantes', 'MAYTEA Parfum MENTHE', 0.84, 1634)
INSERT INTO TABLE_PRODUCT (id_product, name, description, price, stock) VALUES (3, 'BMW i3', 'La BMW i3 ne suit aucune tendance, elle est l’expression d’un style de vie assumé. Son langage stylistique futuriste lui confère également de la clarté à l’extérieur et une ambiance « lounge » à l’intérieur..', 39950.00, 3)
INSERT INTO TABLE_PRODUCT (id_product, name, description, price, stock) VALUES (4, 'One Piece - Tome 1 : À l’aube d’une grande aventure', 'Il y a quelque temps existait un homme, Gold Roger, répondant au titre de Roi des pirates. Lors de son exécution, le souverain des mers prononça quelques mots, déclarant avoir caché son trésor, le One Piece, quelque part dans le monde, et quiconque pouvait s’en emparer.', 6.90, 17)
INSERT INTO TABLE_PRODUCT (id_product, name, description, price, stock) VALUES (5, 'One Piece - Tome 2 : Aux prises avec Baggy et ses hommes !', 'Luffy atterrit sur une île occupée par Baggy et son groupe, un équipage de pirates redoutable.', 6.90, 12)
INSERT INTO TABLE_PRODUCT (id_product, name, description, price, stock) VALUES (6, 'One Piece - Tome 3 : Une vérité qui blesse', 'Luffy affronte Baggy. Ce dernier admet vouer une haine sans nom envers Shanks. En effet, tous deux ont appris les rudiments de la piraterie sur le même navire, et un malencontreux incident a provoqué la descente aux enfers de Baggy…' , 6.90, 11)

-- TABLE ORDER STATUS
INSERT INTO TABLE_ORDER_STATUS (id_order_status, description) VALUES (0, 'En cours de création')
INSERT INTO TABLE_ORDER_STATUS (id_order_status, description) VALUES (1, 'En attente de paiement')
INSERT INTO TABLE_ORDER_STATUS (id_order_status, description) VALUES (2, 'Payé')
INSERT INTO TABLE_ORDER_STATUS (id_order_status, description) VALUES (3, 'En cours de préparation')
INSERT INTO TABLE_ORDER_STATUS (id_order_status, description) VALUES (4, 'Prêt à livrer')
INSERT INTO TABLE_ORDER_STATUS (id_order_status, description) VALUES (5, 'En transit')
INSERT INTO TABLE_ORDER_STATUS (id_order_status, description) VALUES (6, 'Livré')

-- TABLE ORDER
INSERT INTO TABLE_ORDER (id_order, date, price, id_customer, id_address, id_order_status) VALUES (1, '29/10/2020', 8.4, 2, 2, 0)
INSERT INTO TABLE_ORDER (id_order, date, price, id_customer, id_address, id_order_status) VALUES (2, '29/10/2020', 229.00, 3, 3, 0)
INSERT INTO TABLE_ORDER (id_order, date, price, id_customer, id_address, id_order_status) VALUES (3, '29/10/2020', 52950.00, 1, 1, 0)
INSERT INTO TABLE_ORDER (id_order, date, price, id_customer, id_address, id_order_status) VALUES (4, '29/10/2020', 20.7, 4, 4, 0)

-- TABLE ORDER_PRODUCT
INSERT INTO ORDER_PRODUCT (id_order, id_product, quantity) VALUES (1, 1, 10)
INSERT INTO ORDER_PRODUCT (id_order, id_product, quantity) VALUES (2, 2, 1)
INSERT INTO ORDER_PRODUCT (id_order, id_product, quantity) VALUES (3, 3, 1)
INSERT INTO ORDER_PRODUCT (id_order, id_product, quantity) VALUES (4, 4, 1)
INSERT INTO ORDER_PRODUCT (id_order, id_product, quantity) VALUES (4, 5, 1)
INSERT INTO ORDER_PRODUCT (id_order, id_product, quantity) VALUES (4, 6, 1)