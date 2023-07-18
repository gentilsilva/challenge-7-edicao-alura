CREATE TABLE tb_testimony (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_picture VARCHAR(100) NOT NULL,
    user_testimony TEXT NOT NULL,
    user_name VARCHAR(100) NOT NULL,
    active TINYINT DEFAULT 1

);