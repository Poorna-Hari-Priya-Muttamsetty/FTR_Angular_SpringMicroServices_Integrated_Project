Create database freight_transport_region_vehicles;

use freight_transport_region_vehicles;

drop table if exists ftr_vehicles;

create table ftr_vehicles(
vehicle_number varchar(20) primary key,
vehicle_name varchar(50),
max_lifting_capacity BigInt,
retire_date Date,
vehicle_status varchar(30),
harbor_location varchar(30),
country varchar(30)
);

insert into `freight_transport_region_vehicles`.`ftr_vehicles`(`vehicle_number`,`vehicle_name`,`max_lifting_capacity`,`retire_date`,`vehicle_status`,`harbor_location`,`country`) values("UE7890","Tower crane","1980","2030-12-20","InProgress","Chennai Port","India");

insert into `freight_transport_region_vehicles`.`ftr_vehicles`(`vehicle_number`,`vehicle_name`,`max_lifting_capacity`,`retire_date`,`vehicle_status`,`harbor_location`,`country`) values("WK7876","Fireplace crane","7100","2022-01-21","InProgress","Paradip Port","India");

insert into `freight_transport_region_vehicles`.`ftr_vehicles`(`vehicle_number`,`vehicle_name`,`max_lifting_capacity`,`retire_date`,`vehicle_status`,`harbor_location`,`country`) values("DG8986","Double treadwheel crane","2.5","2025-03-22","InProgress","Jurong","Singapore");

insert into `freight_transport_region_vehicles`.`ftr_vehicles`(`vehicle_number`,`vehicle_name`,`max_lifting_capacity`,`retire_date`,`vehicle_status`,`harbor_location`,`country`) values("VQ7890","Crawler crane","250","2030-12-23","InProgress","Port Hawkesbury","Canada");

insert into `freight_transport_region_vehicles`.`ftr_vehicles`(`vehicle_number`,`vehicle_name`,`max_lifting_capacity`,`retire_date`,`vehicle_status`,`harbor_location`,`country`) values("BH2343","Aerial crane","1000","2022-01-21","InProgress","Sydney Harbor","Australia");

insert into `freight_transport_region_vehicles`.`ftr_vehicles`(`vehicle_number`,`vehicle_name`,`max_lifting_capacity`,`retire_date`,`vehicle_status`,`harbor_location`,`country`) values("NM1012","Fireplace crane","2.5","2025-03-22","InActive","Visakhapatnam Port","India");

insert into `freight_transport_region_vehicles`.`ftr_vehicles`(`vehicle_number`,`vehicle_name`,`max_lifting_capacity`,`retire_date`,`vehicle_status`,`harbor_location`,`country`) values("SD3456","Double treadwheel crane","3","2030-12-26","Active","Tanjong Pagar","Singapore");

insert into `freight_transport_region_vehicles`.`ftr_vehicles`(`vehicle_number`,`vehicle_name`,`max_lifting_capacity`,`retire_date`,`vehicle_status`,`harbor_location`,`country`) values("CT7867","Crawler crane","550","2024-05-27","InActive","Busan Port","SouthKorea");

insert into `freight_transport_region_vehicles`.`ftr_vehicles`(`vehicle_number`,`vehicle_name`,`max_lifting_capacity`,`retire_date`,`vehicle_status`,`harbor_location`,`country`) values("ER5849","Deck crane","40","2032-09-28","Active","Halifax","Canada");

insert into `freight_transport_region_vehicles`.`ftr_vehicles`(`vehicle_number`,`vehicle_name`,`max_lifting_capacity`,`retire_date`,`vehicle_status`,`harbor_location`,`country`) values("KY8876","Tower crane","19.8","2030-06-29","InActive","Sydney Harbor","Australia");

select * from ftr_vehicles;