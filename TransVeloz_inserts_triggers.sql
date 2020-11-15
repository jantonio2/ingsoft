
DELIMITER |
CREATE TRIGGER trigger_insert_h_person
AFTER INSERT ON person
FOR EACH ROW
BEGIN
	insert into h_person values (null,new.person_id,new.first_name,new.first_surname,new.second_surname,new.ci,new.phone,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER trigger_update_h_person
AFTER UPDATE ON person
FOR EACH ROW
BEGIN
	insert into h_person values (null,new.person_id,new.first_name,new.first_surname,new.second_surname,new.ci,new.phone,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
DELIMITER ;

insert into person values (null,'Juan','Peralta','Flores','8344502','73935655',1, 1, '192.168.1.100', 0, now());
insert into person values (null,'Luis','Mamani','Mamani','6345502','73935622',1, 1, '192.168.1.100', 0, now());
insert into person values (null,'Maria','Lima','Mamani','9974505','63935612',1, 1, '192.168.1.100', 0, now());
insert into person values (null,'Carmen','Flores','Flores','3444506','73933422',1, 1, '192.168.1.100', 0, now());
insert into person values (null,'Marco','Linares','Flores','6324505','63935435',1, 1, '192.168.1.100', 0, now());
insert into person values (null,'Hugo','Peres','Gutierrez','9734502','73935622',1, 1, '192.168.1.100', 0, now());
insert into person values (null,'Pedro','Artiaga','Flores','1244504','63935621',1, 1, '192.168.1.100', 0, now());
insert into person values (null,'German','Choque','Lima','6684502','73935612',1, 1, '192.168.1.100', 0, now());
insert into person values (null,'Armando','Fuentes','Choque','4844501','63936522',1, 1, '192.168.1.100', 0, now());
insert into person values (null,'Lorena','Alvarado','Flores','8000502','63935523',1, 1, '192.168.1.100', 0, now());

insert into address values (null,'187B','Calle 1','San Mateo','La Paz','Bolivia',1, 1, '192.168.1.100', 1, now());
insert into address values (null,'187B','Vita','Florida','La Paz','Bolivia',1, 1, '192.168.1.100', 1, now());
insert into address values (null,'187B','Mendoza','Pacaje','La Paz','Bolivia',1, 1, '192.168.1.100', 1, now());
insert into address values (null,'187B','Florida','Arcaza','La Paz','Bolivia',1, 1, '192.168.1.100', 1, now());
insert into address values (null,'187B','Barbado','Libertad','La Paz','Bolivia',1, 1, '192.168.1.100', 1, now());
insert into address values (null,'187B','Calle 7','Obrajes','La Paz','Bolivia',1, 1, '192.168.1.100', 1, now());
insert into address values (null,'187B','Calle 6','Calacoto','La Paz','Bolivia',1, 1, '192.168.1.100', 1, now());
insert into address values (null,'187B','Calle 3','Los Pinos','La Paz','Bolivia',1, 1, '192.168.1.100', 1, now());
insert into address values (null,'187B','Calle 9','Obrajes','La Paz','Bolivia',1, 1, '192.168.1.100', 1, now());
insert into address values (null,'187B','Calle 10','Achumani','La Paz','Bolivia',1, 1, '192.168.1.100', 1, now());
insert into address values (null,'187B','Calle 11','Obrajes','La Paz','Bolivia',1, 1, '192.168.1.100', 1, now());
insert into address values (null,'187B','Calle 2','Calacoto','La Paz','Bolivia',1, 1, '192.168.1.100', 1, now());
insert into address values (null,'187B','Calle 6','Tejar','La Paz','Bolivia',1, 1, '192.168.1.100', 1, now());
insert into address values (null,'187B','Calle 6','Los Pinos','La Paz','Bolivia',1, 1, '192.168.1.100', 1, now());
insert into address values (null,'187B','Calle 8','Obrajes','La Paz','Bolivia',1, 1, '192.168.1.100', 1, now());
insert into address values (null,'187B','Calle 1','Calacoto','La Paz','Bolivia',1, 1, '192.168.1.100', 1, now());


DELIMITER |
CREATE TRIGGER trigger_insert_h_user
AFTER INSERT ON user
FOR EACH ROW
BEGIN
	insert into h_user values (null,new.user_id,new.person_id,new.address_id,new.birthdate,new.email,new.password,new.picture,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER trigger_update_h_user
AFTER UPDATE ON user
FOR EACH ROW
BEGIN
	insert into h_user values (null,new.user_id,new.person_id,new.address_id,new.birthdate,new.email,new.password,new.picture,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
DELIMITER ;

insert into user values (null,1,1,'1984-10-24','juanperalta@gmail','juanperalta',null,1, 1, '192.168.1.100', 0, now());
insert into user values (null,2,2,'1985-10-24','luismamani@gmail','luismamani',null,1, 1, '192.168.1.100', 0, now());
insert into user values (null,3,3,'1986-10-24','marialima@gmail','marialima',null,1, 1, '192.168.1.100', 0, now());
insert into user values (null,4,4,'1987-10-24','carmenflores@gmail','carmenflores',null,1, 1, '192.168.1.100', 0, now());
insert into user values (null,5,5,'1988-10-24','marcolinares@gmail','marcolinares',null,1, 1, '192.168.1.100', 0, now());


insert into company values(null,6,'Pumari','pumari@gmail','78495164',1,1, '192.168.1.100', 0, now());
insert into company values(null,7,'Rapidito','rapidito@gmail','61487329',1,1, '192.168.1.100', 0, now());
insert into company values(null,8,'Traslados','traslados@gmail','68943578',1,1, '192.168.1.100', 0, now());

DELIMITER |
CREATE TRIGGER trigger_insert_h_driver
AFTER INSERT ON driver	
FOR EACH ROW
BEGIN
	insert into h_driver values (null,new.driver_id,new.person_id,new.company_id,new.address_id,new.birthdate,new.email,new.password,new.picture,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER trigger_update_h_driver
AFTER UPDATE ON driver	
FOR EACH ROW
BEGIN
	insert into h_driver values (null,new.driver_id,new.person_id,new.company_id,new.address_id,new.birthdate,new.email,new.password,new.picture,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
DELIMITER ;


insert into driver values (null,6,1,9,'1984-10-24','hugoperes@gmail','hugoperes',null,1, 1, '192.168.1.100', 0, now());
insert into driver values (null,7,2,10,'1985-10-24','pedroartiaga@gmail','pedroartiaga',null,1, 1, '192.168.1.100', 0, now());
insert into driver values (null,8,3,11,'1986-10-24','germanchoque@gmail','germanchoque',null,1, 1, '192.168.1.100', 0, now());
insert into driver values (null,9,null,12,'1987-10-24','armandofuentes@gmail','armandofuentes',null,1, 1, '192.168.1.100', 0, now());


DELIMITER |
CREATE TRIGGER trigger_insert_h_travel
AFTER INSERT ON travel
FOR EACH ROW
BEGIN
	insert into h_travel values (null,new.travel_id,new.user_id,new.driver_id,new.start_address_id,new.delivery_address_id,new.travel_status,new.date_delivery,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER trigger_update_h_travel
AFTER UPDATE ON travel
FOR EACH ROW
BEGIN
	insert into h_travel values (null,new.travel_id,new.user_id,new.driver_id,new.start_address_id,new.delivery_address_id,new.travel_status,new.date_delivery,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
DELIMITER ;


insert into travel values(null,1,1,13,14,'Confirmado',now(),1, 1, '192.168.1.100', 0, now());	

DELIMITER |
CREATE TRIGGER trigger_insert_h_card
AFTER INSERT ON card
FOR EACH ROW
BEGIN
	insert into h_card values (null,new.card_id,new.user_id,new.account_number,new.pin,new.bank,new.type_account,new.cvv_code,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER trigger_update_h_card
AFTER UPDATE ON card
FOR EACH ROW
BEGIN
	insert into h_card values (null,new.card_id,new.user_id,new.account_number,new.pin,new.bank,new.type_account,new.cvv_code,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
DELIMITER ;

insert into card values(null,1,'15487956','1245','Banco Union','Bolsa de ahorros','734',1, 1, '192.168.1.100', 1, now());
insert into card values(null,2,'78651897','12946','Banco Cnetral','Bolsa de ahorros','984',1, 1, '192.168.1.100', 1, now());




DELIMITER |
CREATE TRIGGER trigger_insert_h_vehicle
AFTER INSERT ON vehicle
FOR EACH ROW
BEGIN
	insert into h_vehicle values (null,new.vehicle_id,new.driver_id,new.license_plate,new.capacity,new.vehicle_type,new.price,new.vehicle_status,new.pictures,new.brand,new.vehicle_model,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER trigger_update_h_vehicle
AFTER UPDATE ON vehicle
FOR EACH ROW
BEGIN
	insert into h_vehicle values (null,new.vehicle_id,new.driver_id,new.license_plate,new.capacity,new.vehicle_type,new.price,new.vehicle_status,new.pictures,new.brand,new.vehicle_model,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
DELIMITER ;

insert into vehicle values (null,1,'789HBG',45.84459,'Camioneta',100.25,'Ocupado',null,'Toyota','2020',1, 1, '192.168.1.100', 1, now());
insert into vehicle values (null,2,'889HBG',65.84459,'Flota',100.25,'Disponible',null,'Toyota','2020',1, 1, '192.168.1.100', 1, now());
insert into vehicle values (null,3,'189HBG',35.84459,'Volqueta',100.25,'Ocupado',null,'Toyota','2020',1, 1, '192.168.1.100', 1, now());
insert into vehicle values (null,4,'289HBG',85.84459,'Minibus',100.25,'Disponible',null,'Toyota','2020',1, 1, '192.168.1.100', 1, now());



insert into score values(null,1,1,3.5,1, 1, '192.168.1.100', 1, now());
insert into score values(null,2,2,4.5,1, 1, '192.168.1.100', 1, now());
insert into score values(null,3,1,4.2,1, 1, '192.168.1.100', 1, now());
insert into score values(null,4,3,5.0,1, 1, '192.168.1.100', 1, now());

insert into administration values(null,10,'admi@email','admi',1, 1, '192.168.1.100', 1, now());

DELIMITER |
CREATE TRIGGER trigger_insert_h_payment
AFTER INSERT ON payment
FOR EACH ROW
BEGIN
	insert into h_payment values (null,new.payment_id,new.travel_id,new.administration_id,new.date_payment,new.payment_status,new.amount,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER trigger_update_h_payment
AFTER UPDATE ON payment
FOR EACH ROW
BEGIN
	insert into h_payment values (null,new.payment_id,new.travel_id,new.administration_id,new.date_payment,new.payment_status,new.amount,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
DELIMITER ;

insert into payment values(null,1,1,now(),'Confirmado',7845.36548,1, 1, '192.168.1.100', 1, now());
insert into payment values(null,1,1,now(),'Cancelado',135.36548,1, 1, '192.168.1.100', 1, now());




DELIMITER |
CREATE TRIGGER trigger_insert_h_bank_account
AFTER INSERT ON bank_account
FOR EACH ROW
BEGIN
	insert into h_bank_account values (null,new.bank_account_id,new.driver_id,new.administration_id,new.account_number,new.bank,new.account_type,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER trigger_update_h_bank_account
AFTER UPDATE ON bank_account
FOR EACH ROW
BEGIN
	insert into h_bank_account values (null,new.bank_account_id,new.driver_id,new.administration_id,new.account_number,new.bank,new.account_type,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
DELIMITER ;

insert into bank_account values(null,null,1,'78165','Banco Union','Bolsa de Ahorros',1, 1, '192.168.1.100', 1, now());
insert into bank_account values(null,1,null,'78165','Banco Union','Bolsa de Ahorros',1, 1, '192.168.1.100', 1, now());

DELIMITER |
CREATE TRIGGER trigger_insert_h_bank_transaction
AFTER INSERT ON bank_transaction
FOR EACH ROW
BEGIN
	insert into h_bank_transaction values (null,new.bank_transaction_id,new.driver_bank_account_id,new.administration_bank_account_id,new.amount,new.transaction_date,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER trigger_update_h_bank_transaction
AFTER UPDATE ON bank_transaction
FOR EACH ROW
BEGIN
	insert into h_bank_transaction values (null,new.bank_transaction_id,new.driver_bank_account_id,new.administration_bank_account_id,new.amount,new.transaction_date,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|	 
DELIMITER ;


insert into bank_transaction values(null,null,2,850.50,now(),1, 1, '192.168.1.100', 1, now());
insert into bank_transaction values(null,1,null,790.80,now(),1, 1, '192.168.1.100', 1, now());
