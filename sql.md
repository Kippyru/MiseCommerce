CREATE TABLE cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    telefono VARCHAR(20),
    direccion VARCHAR(200),
    ciudad VARCHAR(100),
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE categoria (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255)
);

CREATE TABLE producto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    descripcion VARCHAR(255),
    precio DOUBLE NOT NULL,
    stock INT NOT NULL DEFAULT 0;,
    imagen_url VARCHAR(255),

    categoria_id BIGINT NOT NULL,

    CONSTRAINT fk_product_categoria
        FOREIGN KEY (categoria_id)
        REFERENCES categoria(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE carrito (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
cliente_id VARCHAR(100) NOT NULL,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE carrito_item (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
carrito_id BIGINT NOT NULL,
product_id BIGINT NOT NULL,
cantidad INT NOT NULL DEFAULT 1,

    CONSTRAINT fk_carrito_item_carrito
        FOREIGN KEY (carrito_id) REFERENCES carrito(id)
        ON DELETE CASCADE
);