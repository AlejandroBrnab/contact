DROP TABLE contacts IF EXISTS;
CREATE TABLE contacts
(
    id INTEGER NOT NULL AUTO_INCREMENT,
    contactid VARCHAR(36) NOT NULL,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    phonenumber VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL
);