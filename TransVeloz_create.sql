-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2020-11-08 20:30:30.562

-- tables
-- Table: address
CREATE TABLE address (
    address_id int NOT NULL AUTO_INCREMENT,
    driver_id int NULL,
    user_id int NULL,
    company_id int NULL,
    start_travel_id int NULL,
    delivery_travel_id int NULL,
    number varchar(45) NULL,
    street varchar(150) NOT NULL,
    zone varchar(150) NOT NULL,
    city varchar(150) NOT NULL,
    country varchar(150) NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT address_pk PRIMARY KEY (address_id)
);

-- Table: administration
CREATE TABLE administration (
    administration_id int NOT NULL AUTO_INCREMENT,
    person_id int NOT NULL,
    payment_id int NOT NULL,
    email varchar(150) NOT NULL,
    password varchar(150) NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT administration_pk PRIMARY KEY (administration_id)
);

-- Table: bank_account
CREATE TABLE bank_account (
    bank_account_id int NOT NULL AUTO_INCREMENT,
    driver_id int NOT NULL,
    administration_id int NOT NULL,
    account_number int NOT NULL,
    bank varchar(45) NOT NULL,
    account_type varchar(45) NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT bank_account_pk PRIMARY KEY (bank_account_id)
);

-- Table: bank_transaction
CREATE TABLE bank_transaction (
    bank_transaction_id int NOT NULL AUTO_INCREMENT,
    driver_bank_account_id int NOT NULL,
    administration_bank_account_id int NOT NULL,
    amount numeric(12,6) NOT NULL,
    transaction_date timestamp NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT bank_transaction_pk PRIMARY KEY (bank_transaction_id)
);

-- Table: card
CREATE TABLE card (
    card_id int NOT NULL AUTO_INCREMENT,
    user_id int NOT NULL,
    account_number varchar(45) NOT NULL,
    pin varchar(45) NOT NULL,
    bank varchar(45) NOT NULL,
    type_account varchar(45) NOT NULL,
    cvv_code varchar(45) NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT card_pk PRIMARY KEY (card_id)
);

-- Table: company
CREATE TABLE company (
    company_id int NOT NULL AUTO_INCREMENT,
    name varchar(45) NOT NULL,
    email varchar(45) NOT NULL,
    phone varchar(45) NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT company_pk PRIMARY KEY (company_id)
);

-- Table: driver
CREATE TABLE driver (
    driver_id int NOT NULL AUTO_INCREMENT,
    person_id int NOT NULL,
    company_id int NULL,
    birthdate varchar(45) NOT NULL,
    email varchar(150) NOT NULL,
    password varchar(150) NOT NULL,
    picture varchar(45) NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT driver_pk PRIMARY KEY (driver_id)
);

-- Table: h_bank_account
CREATE TABLE h_bank_account (
    h_bank_account_id int NOT NULL AUTO_INCREMENT,
    bank_Account_id int NOT NULL,
    driver_id int NOT NULL,
    administration_id int NOT NULL,
    account_number int NOT NULL,
    bank varchar(45) NOT NULL,
    account_type varchar(45) NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT h_bank_account_pk PRIMARY KEY (h_bank_account_id)
);

-- Table: h_bank_transaction
CREATE TABLE h_bank_transaction (
    h_bank_transaction_id int NOT NULL AUTO_INCREMENT,
    bank_transaction_id int NOT NULL,
    driver_bank_account_id int NOT NULL,
    administration_bank_account_id int NOT NULL,
    amount numeric(10,5) NOT NULL,
    transaction_date timestamp NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT h_bank_transaction_pk PRIMARY KEY (h_bank_transaction_id)
);

-- Table: h_card
CREATE TABLE h_card (
    h_card_id int NOT NULL AUTO_INCREMENT,
    card_id int NOT NULL,
    user_id int NOT NULL,
    account_number varchar(45) NOT NULL,
    pin varchar(45) NOT NULL,
    bank varchar(45) NOT NULL,
    type_account varchar(45) NOT NULL,
    cvv_code varchar(45) NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT h_card_pk PRIMARY KEY (h_card_id)
);

-- Table: h_driver
CREATE TABLE h_driver (
    h_driver_id int NOT NULL AUTO_INCREMENT,
    driver_id int NOT NULL,
    person_id int NOT NULL,
    address_id int NOT NULL,
    company_id int NOT NULL,
    birthdate varchar(45) NOT NULL,
    email varchar(150) NOT NULL,
    password varchar(150) NOT NULL,
    picture varchar(45) NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT h_driver_pk PRIMARY KEY (h_driver_id)
);

-- Table: h_payment
CREATE TABLE h_payment (
    h_payment_id int NOT NULL AUTO_INCREMENT,
    payment_id int NOT NULL,
    travel_id int NOT NULL,
    date_payment timestamp NOT NULL,
    payment_status varchar(45) NOT NULL,
    ammount numeric(10,5) NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT h_payment_pk PRIMARY KEY (h_payment_id)
);

-- Table: h_travel
CREATE TABLE h_travel (
    h_travel_id int NOT NULL AUTO_INCREMENT,
    travel_id int NOT NULL,
    user_id int NOT NULL,
    driver_id int NOT NULL,
    travel_status varchar(45) NOT NULL,
    start_address varchar(150) NOT NULL,
    delivery_address varchar(150) NOT NULL,
    date_delivery timestamp NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT h_travel_pk PRIMARY KEY (h_travel_id)
);

-- Table: h_user
CREATE TABLE h_user (
    h_user_id int NOT NULL AUTO_INCREMENT,
    user_id int NOT NULL,
    person_id int NOT NULL,
    address_id int NOT NULL,
    birthdate date NOT NULL,
    email varchar(150) NOT NULL,
    password varchar(150) NOT NULL,
    picture varchar(45) NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT h_user_pk PRIMARY KEY (h_user_id)
);

-- Table: h_vehicle
CREATE TABLE h_vehicle (
    h_vehicle_id int NOT NULL AUTO_INCREMENT,
    vehicle_id int NOT NULL,
    driver_id int NOT NULL,
    license_plate varchar(45) NOT NULL,
    capacity numeric(10,4) NOT NULL,
    vehicle_type varchar(45) NOT NULL,
    price numeric(10,4) NOT NULL,
    vehicle_status varchar(45) NOT NULL,
    pictures varchar(300) NOT NULL,
    brand varchar(45) NOT NULL,
    vehicle_model varchar(45) NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT h_vehicle_pk PRIMARY KEY (h_vehicle_id)
);

-- Table: payment
CREATE TABLE payment (
    payment_id int NOT NULL AUTO_INCREMENT,
    travel_id int NOT NULL,
    date_payment timestamp NOT NULL,
    payment_status varchar(45) NOT NULL,
    amount numeric(12,6) NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT payment_pk PRIMARY KEY (payment_id)
);

-- Table: person
CREATE TABLE person (
    person_id int NOT NULL AUTO_INCREMENT,
    first_name varchar(150) NOT NULL,
    first_surname varchar(150) NOT NULL,
    second_surname varchar(150) NULL,
    ci varchar(45) NOT NULL,
    phone varchar(45) NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT person_pk PRIMARY KEY (person_id)
);

-- Table: score
CREATE TABLE score (
    score_id int NOT NULL AUTO_INCREMENT,
    vehicle_id int NOT NULL,
    user_id int NOT NULL,
    score numeric(2,1) NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT score_pk PRIMARY KEY (score_id)
);

-- Table: transaction
CREATE TABLE transaction (
    tx_id int NOT NULL AUTO_INCREMENT,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT transaction_pk PRIMARY KEY (tx_id)
);

-- Table: travel
CREATE TABLE travel (
    travel_id int NOT NULL AUTO_INCREMENT,
    user_id int NOT NULL,
    driver_id int NOT NULL,
    travel_status varchar(45) NOT NULL,
    date_delivery timestamp NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT travel_pk PRIMARY KEY (travel_id)
);

-- Table: user
CREATE TABLE user (
    user_id int NOT NULL AUTO_INCREMENT,
    person_id int NOT NULL,
    birthdate date NOT NULL,
    email varchar(150) NOT NULL,
    password varchar(150) NOT NULL,
    picture varchar(45) NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (user_id)
);

-- Table: vehicle
CREATE TABLE vehicle (
    vehicle_id int NOT NULL AUTO_INCREMENT,
    driver_id int NOT NULL,
    license_plate varchar(45) NOT NULL,
    capacity numeric(12,6) NOT NULL,
    vehicle_type varchar(45) NOT NULL,
    price numeric(12,6) NOT NULL,
    vehicle_status varchar(45) NOT NULL,
    pictures varchar(300) NULL,
    brand varchar(45) NOT NULL,
    vehicle_model varchar(45) NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT vehicle_pk PRIMARY KEY (vehicle_id)
);

-- foreign keys
-- Reference: address_company (table: address)
ALTER TABLE address ADD CONSTRAINT address_company FOREIGN KEY address_company (company_id)
    REFERENCES company (company_id);

-- Reference: address_driver (table: address)
ALTER TABLE address ADD CONSTRAINT address_driver FOREIGN KEY address_driver (driver_id)
    REFERENCES driver (driver_id);

-- Reference: address_travel (table: address)
ALTER TABLE address ADD CONSTRAINT address_travel FOREIGN KEY address_travel (start_travel_id)
    REFERENCES travel (travel_id);

-- Reference: address_travel_2 (table: address)
ALTER TABLE address ADD CONSTRAINT address_travel_2 FOREIGN KEY address_travel_2 (delivery_travel_id)
    REFERENCES travel (travel_id);

-- Reference: address_user (table: address)
ALTER TABLE address ADD CONSTRAINT address_user FOREIGN KEY address_user (user_id)
    REFERENCES user (user_id);

-- Reference: administration_payment (table: administration)
ALTER TABLE administration ADD CONSTRAINT administration_payment FOREIGN KEY administration_payment (payment_id)
    REFERENCES payment (payment_id);

-- Reference: administration_person (table: administration)
ALTER TABLE administration ADD CONSTRAINT administration_person FOREIGN KEY administration_person (person_id)
    REFERENCES person (person_id);

-- Reference: bank_account_administration (table: bank_account)
ALTER TABLE bank_account ADD CONSTRAINT bank_account_administration FOREIGN KEY bank_account_administration (administration_id)
    REFERENCES administration (administration_id);

-- Reference: bank_account_driver (table: bank_account)
ALTER TABLE bank_account ADD CONSTRAINT bank_account_driver FOREIGN KEY bank_account_driver (driver_id)
    REFERENCES driver (driver_id);

-- Reference: bank_transaction1_bank_account (table: bank_transaction)
ALTER TABLE bank_transaction ADD CONSTRAINT bank_transaction1_bank_account FOREIGN KEY bank_transaction1_bank_account (driver_bank_account_id)
    REFERENCES bank_account (bank_account_id);

-- Reference: bank_transaction2_bank_account (table: bank_transaction)
ALTER TABLE bank_transaction ADD CONSTRAINT bank_transaction2_bank_account FOREIGN KEY bank_transaction2_bank_account (administration_bank_account_id)
    REFERENCES bank_account (bank_account_id);

-- Reference: card_user (table: card)
ALTER TABLE card ADD CONSTRAINT card_user FOREIGN KEY card_user (user_id)
    REFERENCES user (user_id);

-- Reference: driver_company (table: driver)
ALTER TABLE driver ADD CONSTRAINT driver_company FOREIGN KEY driver_company (company_id)
    REFERENCES company (company_id);

-- Reference: driver_person (table: driver)
ALTER TABLE driver ADD CONSTRAINT driver_person FOREIGN KEY driver_person (person_id)
    REFERENCES person (person_id);

-- Reference: payment_travel (table: payment)
ALTER TABLE payment ADD CONSTRAINT payment_travel FOREIGN KEY payment_travel (travel_id)
    REFERENCES travel (travel_id);

-- Reference: score_user (table: score)
ALTER TABLE score ADD CONSTRAINT score_user FOREIGN KEY score_user (user_id)
    REFERENCES user (user_id);

-- Reference: score_vehicle (table: score)
ALTER TABLE score ADD CONSTRAINT score_vehicle FOREIGN KEY score_vehicle (vehicle_id)
    REFERENCES vehicle (vehicle_id);

-- Reference: travel_driver (table: travel)
ALTER TABLE travel ADD CONSTRAINT travel_driver FOREIGN KEY travel_driver (driver_id)
    REFERENCES driver (driver_id);

-- Reference: travel_user (table: travel)
ALTER TABLE travel ADD CONSTRAINT travel_user FOREIGN KEY travel_user (user_id)
    REFERENCES user (user_id);

-- Reference: user_person (table: user)
ALTER TABLE user ADD CONSTRAINT user_person FOREIGN KEY user_person (person_id)
    REFERENCES person (person_id);

-- Reference: vehicle_driver (table: vehicle)
ALTER TABLE vehicle ADD CONSTRAINT vehicle_driver FOREIGN KEY vehicle_driver (driver_id)
    REFERENCES driver (driver_id);

-- End of file.

