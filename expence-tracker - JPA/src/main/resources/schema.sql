Create table if not exists expenses(
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
    category VARCHAR(50) NOT NULL ,
    price DOUBLE NOT NULL,
    date DATE NOT NULL
);