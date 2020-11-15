-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2020-11-15 03:26:23.473

-- tables
-- Table: address
CREATE TABLE address (
    address_id int NOT NULL AUTO_INCREMENT COMMENT 'Self-incrementing primary key of address table.',
    number varchar(45) NULL COMMENT 'the door number that the user''''s home has at the time of entering the address data of the home.
Example:
         N: 2352',
    street varchar(150) NOT NULL COMMENT 'The user enters the specific street where the house or address is located.
Example:
         Street: Carmen',
    zone varchar(150) NOT NULL COMMENT 'The user enters the zone where he lives or where the house or address is located.
Example:
        Zone: Miraflores',
    city varchar(150) NOT NULL COMMENT 'The city is data that the user enters. It is where the user or address lives or is located
Example:
         City: El Alto',
    country varchar(150) NOT NULL COMMENT 'The country is data that the user enters. In which is where the user lives or is located or the address
Example:
         Country: Bolivia',
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT address_pk PRIMARY KEY (address_id)
);

-- Table: administration
CREATE TABLE administration (
    administration_id int NOT NULL AUTO_INCREMENT COMMENT 'Administration table primary key Example: 1',
    person_id int NOT NULL COMMENT 'foreign key that refers to the id of the person table
Example: 2',
    email varchar(150) NOT NULL COMMENT 'name of the user''''s email
Example: juanperez@gmail.com',
    password varchar(150) NOT NULL COMMENT 'password that the administrator will have to access the system
Example: abcABC123',
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT administration_pk PRIMARY KEY (administration_id)
);

-- Table: bank_account
CREATE TABLE bank_account (
    bank_account_id int NOT NULL AUTO_INCREMENT COMMENT 'Self-incrementing primary key of bank_account table.
Example: 4',
    driver_id int NULL COMMENT 'Self-incrementing foreign key of driver table
Example: 3',
    administration_id int NULL COMMENT 'Self-incrementing foreign key of administration table
Example: 2',
    account_number int NOT NULL COMMENT 'Contains the number of the account that de user wants to register.
Example: 1273748493',
    bank varchar(45) NOT NULL COMMENT 'Name of the bank from which the credit card comes
Example: Banco Unión ',
    account_type varchar(45) NOT NULL COMMENT 'Type of accout that the user has
Example: Caja de ahorros',
    status int NOT NULL COMMENT 'Tells us if the bank account is active or not
Example: 1',
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT bank_account_pk PRIMARY KEY (bank_account_id)
);

-- Table: bank_transaction
CREATE TABLE bank_transaction (
    bank_transaction_id int NOT NULL AUTO_INCREMENT COMMENT 'Self-incrementing primary key of ban_transaction
Example: 2',
    driver_bank_account_id int NULL COMMENT 'Self-incrementing foreign key of bank_account
Example: 3',
    administration_bank_account_id int NULL COMMENT 'Self-incrementing foreign key of the administration bank_account
Example: 2',
    amount numeric(12,6) NOT NULL COMMENT 'Amount of money to be transferred
Example: 124.800000',
    transaction_date timestamp NOT NULL COMMENT 'Date of payment
Example: 2020-11-11 03:14:07',
    status int NOT NULL COMMENT 'Tells us if the ban transaction is active or not
Example: 1',
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT bank_transaction_pk PRIMARY KEY (bank_transaction_id)
);

-- Table: card
CREATE TABLE card (
    card_id int NOT NULL AUTO_INCREMENT COMMENT 'Self-incrementing primary key of card
Example: 3',
    user_id int NOT NULL COMMENT 'Self-incrementing foreign key of user table
Example: 2',
    account_number varchar(45) NOT NULL COMMENT 'Contains the number of the account that de user wants to register.
Example: 1273748493',
    pin varchar(45) NOT NULL COMMENT 'Password that the user has  for his credit card.
Example: 1234abc',
    bank varchar(45) NOT NULL COMMENT 'Name of the bank from which the credit card comes
Example: Banco Unión ',
    type_account varchar(45) NOT NULL COMMENT 'Type of accout that the user has
Example: Caja de ahorros',
    cvv_code varchar(45) NOT NULL COMMENT 'Code of security that each card has on the reverse
Example: 1234',
    status int NOT NULL COMMENT 'Tells us if the card is active or not
Example: 1',
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT card_pk PRIMARY KEY (card_id)
);

-- Table: company
CREATE TABLE company (
    company_id int NOT NULL AUTO_INCREMENT COMMENT 'Self-incrementing primary key of company table.',
    address_id int NOT NULL COMMENT 'Self-incrementing foreign key of address table
Example: 
                    2',
    name varchar(45) NOT NULL COMMENT 'The name of the company or organization that the driver is affiliated with
Example:
        Altamirano Heavy Transport',
    email varchar(45) NOT NULL COMMENT 'It is the general email of the company in which the driver is affiliated
Example:
        heavy.transport.altamirano@company.com',
    phone varchar(45) NOT NULL COMMENT 'It is the phone number or cell phone number of the company.
Example:
     Tel: 22 383 483',
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT company_pk PRIMARY KEY (company_id)
);

-- Table: driver
CREATE TABLE driver (
    driver_id int NOT NULL AUTO_INCREMENT COMMENT 'Driver table primary key
Example: 1',
    person_id int NOT NULL COMMENT 'foreign key that refers to the id of the person table
Example: 2',
    company_id int NULL COMMENT 'foreign key that refers to the id of the company table
Example: 3',
    address_id int NOT NULL COMMENT 'foreign key that refers to the id of the person table
Example: 4',
    birthdate varchar(45) NOT NULL COMMENT 'date of birth corresponding to the user
Example: 1999-01-0',
    email varchar(150) NOT NULL COMMENT 'driver''''s email address
Example: juanperez@gmail.com',
    password varchar(150) NOT NULL COMMENT 'password that the administrator will have to access the system
Example: abcABC123',
    picture varchar(45) NULL COMMENT 'Image certifying the identity of the driver
Example: https://mypage/MostrarFoto.aspx',
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
    driver_id int NULL,
    administration_id int NULL,
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
    driver_bank_account_id int NULL,
    administration_bank_account_id int NULL,
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
    company_id int NULL,
    address_id int NOT NULL,
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
    administration_id int NOT NULL,
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

-- Table: h_person
CREATE TABLE h_person (
    h_person_id int NOT NULL AUTO_INCREMENT,
    person_id int NOT NULL,
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
    CONSTRAINT h_person_pk PRIMARY KEY (h_person_id)
);

-- Table: h_travel
CREATE TABLE h_travel (
    h_travel_id int NOT NULL AUTO_INCREMENT,
    travel_id int NOT NULL,
    user_id int NOT NULL,
    driver_id int NOT NULL,
    start_address_id int NOT NULL,
    delivery_address_id int NOT NULL,
    travel_status varchar(45) NOT NULL,
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
    pictures varchar(300) NULL,
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
    payment_id int NOT NULL AUTO_INCREMENT COMMENT 'Self-incrementing primary key of payment.
Example: 1',
    travel_id int NOT NULL COMMENT 'Self-incrementing foreign key of Travel.
Example: 3',
    administration_id int NOT NULL COMMENT 'Self-incrementing foreign key of administration.
Example: 4',
    date_payment timestamp NOT NULL COMMENT 'Date of payment
Example: 2020-11-11 03:14:07',
    payment_status varchar(45) NOT NULL COMMENT 'Provides payment status
Example: In proccess.
                 indicted
                 failed',
    amount numeric(12,6) NOT NULL COMMENT 'Amount of money to be transferred
Example: 124.800000',
    status int NOT NULL COMMENT 'Tells us if the payment is active or not
Example: 1',
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT payment_pk PRIMARY KEY (payment_id)
);

-- Table: person
CREATE TABLE person (
    person_id int NOT NULL AUTO_INCREMENT COMMENT 'Self-incrementing primary key of person table.',
    first_name varchar(150) NOT NULL COMMENT 'It is the name of the user or driver with whom it is registered in the system
Example:
  - Maria
  - Juan Carlos',
    first_surname varchar(150) NOT NULL COMMENT 'It is the first surname of the user or driver with whom he is registered in the system.
Example:
  - Mendoza
  - Arquiaga',
    second_surname varchar(150) NULL COMMENT 'It is the second last name of the user or driver with whom he is registered in the system.
Example:
  - Mamani
  - Ramos',
    ci varchar(45) NOT NULL COMMENT 'It is the identity card of the user or driver
Example:
     - Juan has CI: 9434234',
    phone varchar(45) NOT NULL COMMENT 'It is where the user or driver enters their cell phone number
Example:
    - 75693233',
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT person_pk PRIMARY KEY (person_id)
);

-- Table: score
CREATE TABLE score (
    score_id int NOT NULL AUTO_INCREMENT COMMENT 'Main key of the score table to be auto incremented
Example: 3',
    vehicle_id int NOT NULL COMMENT 'foreign key that refers to the id of the vehicle table
Example: 4',
    user_id int NOT NULL COMMENT 'foreign key that refers to the id of the user table
Example: 4',
    score numeric(2,1) NOT NULL COMMENT 'Driver Score
Example: 7.5',
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
    travel_id int NOT NULL AUTO_INCREMENT COMMENT 'Self-incrementing primary key of travel table.',
    user_id int NOT NULL COMMENT 'Self-incrementing foreign key of user table
Example: 
                    2',
    driver_id int NOT NULL COMMENT 'Self-incrementing foreign key of driver table
Example: 
                    7',
    start_address_id int NOT NULL COMMENT 'Self-incrementing foreign key of start address table 
of the merchandise to be transported
Example:
                    11',
    delivery_address_id int NOT NULL COMMENT 'Self-incrementing foreign key of delivery address table of the merchandise to the delivery address
Example:
                    9',
    travel_status varchar(45) NOT NULL COMMENT 'The travel status is divided into the following categories, which are:
            - Available
            - With Goods
            - Delivered
Example:
              Status: Delivered',
    date_delivery timestamp NOT NULL COMMENT 'It is the date of delivery of the merchandise that is being transported by the driver
Example:
          2020-12-23 11:12:07',
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT travel_pk PRIMARY KEY (travel_id)
);

-- Table: user
CREATE TABLE user (
    user_id int NOT NULL AUTO_INCREMENT COMMENT 'Self-incrementing primary key of user table.',
    person_id int NOT NULL COMMENT 'Self-incrementing foreign key of person table
Example: 
                    6',
    address_id int NOT NULL COMMENT 'Self-incrementing foreign key of address table
Example: 
                    2',
    birthdate date NOT NULL COMMENT 'It is the date of birth that the user or driver enters. Where it has the following format: Year - Month - Day (yyyy "-" mm "-" dd).
Example:
       1997 - 03 - 14',
    email varchar(150) NOT NULL COMMENT 'It is the Email that the user or driver has.
Example:
       mariarojas@example.com',
    password varchar(150) NOT NULL COMMENT 'It is the password that the user or driver enters.
Example:
       Password: 1234456abc',
    picture varchar(45) NULL COMMENT 'It is the profile photo of the user or driver. Where when registering, the profile photo has a generic user image by default.
',
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (user_id)
);

-- Table: vehicle
CREATE TABLE vehicle (
    vehicle_id int NOT NULL AUTO_INCREMENT COMMENT 'Main key of the vehicle table to be auto incremented
Example: 3',
    driver_id int NOT NULL COMMENT 'foreign key that refers to the id of the driver table
Example: 4',
    license_plate varchar(45) NOT NULL COMMENT 'driver plate number
Example: 696-SGI',
    capacity numeric(12,6) NOT NULL COMMENT 'capacity in tons that the vehicle can transport
Example: 2.5',
    vehicle_type varchar(45) NOT NULL COMMENT 'description of the type of vehicle
Example: Tonelaje medio',
    price numeric(12,6) NOT NULL COMMENT 'vehicle use cost
Example 300.99',
    vehicle_status varchar(45) NOT NULL COMMENT 'Vehicle status in real time
Example: Disponible',
    pictures varchar(300) NULL COMMENT 'Image certifying the identity of the vehicle
Example: https://mypage/MostrarFoto.aspx',
    brand varchar(45) NOT NULL COMMENT 'Vehicle brand
Example: Toyota',
    vehicle_model varchar(45) NOT NULL COMMENT 'vehicle model name
Example: Toyota Corolla 200',
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT vehicle_pk PRIMARY KEY (vehicle_id)
);

-- foreign keys
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

-- Reference: company_address (table: company)
ALTER TABLE company ADD CONSTRAINT company_address FOREIGN KEY company_address (address_id)
    REFERENCES address (address_id);

-- Reference: driver_address (table: driver)
ALTER TABLE driver ADD CONSTRAINT driver_address FOREIGN KEY driver_address (address_id)
    REFERENCES address (address_id);

-- Reference: driver_company (table: driver)
ALTER TABLE driver ADD CONSTRAINT driver_company FOREIGN KEY driver_company (company_id)
    REFERENCES company (company_id);

-- Reference: driver_person (table: driver)
ALTER TABLE driver ADD CONSTRAINT driver_person FOREIGN KEY driver_person (person_id)
    REFERENCES person (person_id);

-- Reference: payment_administration (table: payment)
ALTER TABLE payment ADD CONSTRAINT payment_administration FOREIGN KEY payment_administration (administration_id)
    REFERENCES administration (administration_id);

-- Reference: payment_travel (table: payment)
ALTER TABLE payment ADD CONSTRAINT payment_travel FOREIGN KEY payment_travel (travel_id)
    REFERENCES travel (travel_id);

-- Reference: score_user (table: score)
ALTER TABLE score ADD CONSTRAINT score_user FOREIGN KEY score_user (user_id)
    REFERENCES user (user_id);

-- Reference: score_vehicle (table: score)
ALTER TABLE score ADD CONSTRAINT score_vehicle FOREIGN KEY score_vehicle (vehicle_id)
    REFERENCES vehicle (vehicle_id);

-- Reference: travel2_address (table: travel)
ALTER TABLE travel ADD CONSTRAINT travel2_address FOREIGN KEY travel2_address (start_address_id)
    REFERENCES address (address_id);

-- Reference: travel_address (table: travel)
ALTER TABLE travel ADD CONSTRAINT travel_address FOREIGN KEY travel_address (delivery_address_id)
    REFERENCES address (address_id);

-- Reference: travel_driver (table: travel)
ALTER TABLE travel ADD CONSTRAINT travel_driver FOREIGN KEY travel_driver (driver_id)
    REFERENCES driver (driver_id);

-- Reference: travel_user (table: travel)
ALTER TABLE travel ADD CONSTRAINT travel_user FOREIGN KEY travel_user (user_id)
    REFERENCES user (user_id);

-- Reference: user_address (table: user)
ALTER TABLE user ADD CONSTRAINT user_address FOREIGN KEY user_address (address_id)
    REFERENCES address (address_id);

-- Reference: user_person (table: user)
ALTER TABLE user ADD CONSTRAINT user_person FOREIGN KEY user_person (person_id)
    REFERENCES person (person_id);

-- Reference: vehicle_driver (table: vehicle)
ALTER TABLE vehicle ADD CONSTRAINT vehicle_driver FOREIGN KEY vehicle_driver (driver_id)
    REFERENCES driver (driver_id);

-- End of file.

