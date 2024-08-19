Create database freight_transport_region_terminals;

use freight_transport_region_terminals;

drop table if exists ftr_terminals;

create table ftr_terminals(
terminal_id varchar(20) primary key,
terminal_name varchar(100),
country varchar(30),
item_type varchar(100),
terminal_description varchar(200),
capacity BigInt,
available_capacity BigInt,
status varchar(200),
harbor_location varchar(30)
);

insert into `freight_transport_region_terminals`.`ftr_terminals`(`terminal_id`,`terminal_name`,`country`,`item_type`,`terminal_description`,`capacity`,`available_capacity`,`status`,`harbor_location`) values("T1","Kakinada","India","Computer Hardware","T1-Computer Hardware","30000","10000","Available","Chennai Port");

insert into `freight_transport_region_terminals`.`ftr_terminals`(`terminal_id`,`terminal_name`,`country`,`item_type`,`terminal_description`,`capacity`,`available_capacity`,`status`,`harbor_location`) values("T2","Hazira","India","Oil Container","T2-OilContainer","40000","10000","NotAvailable","Paradip Port");

insert into `freight_transport_region_terminals`.`ftr_terminals`(`terminal_id`,`terminal_name`,`country`,`item_type`,`terminal_description`,`capacity`,`available_capacity`,`status`,`harbor_location`) values("T3","Klang","Singapore","Wood","T3-Wood","85000","78000","Available","Jurong");

insert into `freight_transport_region_terminals`.`ftr_terminals`(`terminal_id`,`terminal_name`,`country`,`item_type`,`terminal_description`,`capacity`,`available_capacity`,`status`,`harbor_location`) values("T4","Saint John","Canada","Motorcycles","T4-Motorcycles","85000","73000","Available","Port Hawkesbury");

insert into `freight_transport_region_terminals`.`ftr_terminals`(`terminal_id`,`terminal_name`,`country`,`item_type`,`terminal_description`,`capacity`,`available_capacity`,`status`,`harbor_location`) values("T5","Brisbane","Australia","Electronics","T5-Electronics","50000","12000","NotAvailable","Sydney Harbor");

insert into `freight_transport_region_terminals`.`ftr_terminals`(`terminal_id`,`terminal_name`,`country`,`item_type`,`terminal_description`,`capacity`,`available_capacity`,`status`,`harbor_location`) values("T6","Haldia","India","Computer Hardware","T6-Computer Hardware","37500","19000","NotAvailable","Visakhapatnam Port");

insert into `freight_transport_region_terminals`.`ftr_terminals`(`terminal_id`,`terminal_name`,`country`,`item_type`,`terminal_description`,`capacity`,`available_capacity`,`status`,`harbor_location`) values("T7","Tanjung","Singapore","Oil Container","T7-OilContainer","89000","50000","Available","Tanjong Pagar");

insert into `freight_transport_region_terminals`.`ftr_terminals`(`terminal_id`,`terminal_name`,`country`,`item_type`,`terminal_description`,`capacity`,`available_capacity`,`status`,`harbor_location`) values("T8","Busan","South Korea","Wood","T8-Wood","24900","9900","NotAvailable","Busan Port");

insert into `freight_transport_region_terminals`.`ftr_terminals`(`terminal_id`,`terminal_name`,`country`,`item_type`,`terminal_description`,`capacity`,`available_capacity`,`status`,`harbor_location`) values("T9","Montreal","Canada","Motorcycles","T9-Motorcycles","87000","24000","NotAvailable","Halifax");

insert into `freight_transport_region_terminals`.`ftr_terminals`(`terminal_id`,`terminal_name`,`country`,`item_type`,`terminal_description`,`capacity`,`available_capacity`,`status`,`harbor_location`) values("T10","Fremantle","Australia","Electronics","T10-Electronics","94700","20000","Available","Sydney Harbor");

select * from ftr_terminals;
