-- Insertar datos en la tabla de tipos de producto
INSERT INTO type_product (name) VALUES ('Ring');
INSERT INTO type_product (name) VALUES ('Earring');
INSERT INTO type_product (name) VALUES ('Necklace');
INSERT INTO type_product (name) VALUES ('Bracelet');

-- Insertar datos en la tabla de materiales
INSERT INTO material_product (name) VALUES ('Gold');
INSERT INTO material_product (name) VALUES ('Silver');
INSERT INTO material_product (name) VALUES ('Stainless Steel');

-- Insertar productos
INSERT INTO products (name, type_product_id, material_product_id, description, quantity, price)
VALUES
    -- Anillos (tipo=1)
    ('Gold Floral Ring', 1, 1, 'Anillo de 20mm de diámetro. Summer Collection 2025.', 30, 29.99),
    ('Silver Cherry Ring', 1, 2, 'Anillo de 20mm de diámetro. Spring Collection 2025.', 25, 19.99),
    ('Steel Snow Ring', 1, 3, 'Anillo de 20mm de diámetro. Winter Collection 2025.', 20, 24.99),

    -- Pendientes (tipo=2)
    ('Gold Floral Earring', 2, 1, 'Pendientes cierre presión. Summer Collection 2025.', 30, 19.99),
    ('Silver Cherry Earring', 2, 2, 'Pendientes cierre presión. Spring Collection 2025.', 25, 12.99),
    ('Steel Snow Earring', 2, 3, 'Pendientes cierre presión. Winter Collection 2025.', 20, 14.99),

    -- Collares (tipo=3)
    ('Gold Floral Necklace', 3, 1, 'Collar de 35cm de longitud. Summer Collection 2025.', 30, 39.99),
    ('Silver Cherry Necklace', 3, 2, 'Collar de 35cm de longitud. Spring Collection 2025.', 25, 29.99),
    ('Steel Snow Necklace', 3, 3, 'Collar de 35cm de longitud. Winter Collection 2025.', 20, 34.99),

    -- Pulseras (tipo=4)
    ('Gold Floral Bracelet', 4, 1, 'Bracelet of 20cm length. Summer Collection 2025.', 30, 24.99),
    ('Silver Cherry Bracelet', 4, 2, 'Bracelet of 20cm length. Spring Collection 2025.', 25, 18.99),
    ('Steel Snow Necklace', 4, 3, 'Bracelet of 20cm length. Winter Collection 2025.', 20, 21.99);


