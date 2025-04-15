-- Insertar datos en la tabla de tipos de producto
INSERT INTO type_product (id, name) VALUES (1, 'Ring'), (2, 'Earring'), (3, 'Bracelet'), (4, 'Necklace');

-- Insertar datos en la tabla de materiales
INSERT INTO material_product (id, name) VALUES (1, 'Gold'), (2, 'Silver'), (3, 'Stainless steel');

-- Insertar productos
INSERT INTO products (id, name, type_product_id, material_product_id, description, quantity, price)
VALUES
    (1, 'Collar floral', 1, 1, 'Collar de 15 cm.', 2, 25.99),
    (2, 'Pulsera floral', 2, 2, 'Pulsera de 8 cm.', 2, 15.99),
    (3, 'Anillo floral', 3, 3, 'Anillo talla 12.', 2, 20.99);