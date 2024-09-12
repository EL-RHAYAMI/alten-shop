CREATE TABLE product (
                         id BIGINT AUTO_INCREMENT,
                         code VARCHAR(9) NOT NULL,
                         name VARCHAR(50) NOT NULL,
                         description VARCHAR NOT NULL,
                         price DOUBLE NOT NULL,
                         quantity INT NOT NULL,
                         inventory_status VARCHAR(20) NOT NULL,
                         category VARCHAR(30) NOT NULL,
                         image VARCHAR,
                         rating INT,
                         PRIMARY KEY (id),
                         CONSTRAINT UQ_code UNIQUE (code)
);