create database freight_transport_region_workitems;

use freight_transport_region_workitems;

drop table if exists ftr_workitems;

create table ftr_workitems(
workitem_id varchar(20) primary key,
user_id BigInt,
item_name varchar(200),
item_type varchar(200),
item_description varchar(200),
message_to_recipient varchar(200),
quantity varchar(100),
source_country varchar(30),
destination_country varchar(30),
selected_harbor_location varchar(200),
shipping_date Date,
amount BigInt
);

insert into `freight_transport_region_workitems`.`ftr_workitems`(`workitem_id`,`user_id`,`item_name`,`item_type`,`item_description`,`message_to_recipient`,`quantity`,`source_country`,`destination_country`,`selected_harbor_location`,`shipping_date`,`amount`) values("J2012","10001", "UPS", "Computer Hardware", "Luminous Inverter battery", "Please confirm oncereceived.", "7500", "India", "Singapore", "Tanjong Pagar", "2020-08-12", "119992500");

insert into `freight_transport_region_workitems`.`ftr_workitems`(`workitem_id`,`user_id`,`item_name`,`item_type`,`item_description`,`message_to_recipient`,`quantity`,`source_country`,`destination_country`,`selected_harbor_location`,`shipping_date`,`amount`) values('J2013','10002', 'Aviation Turbine Fuel', 'Oil Container', 'Fuel for Jet', 'Please confirm once received.','9200 litre', 'Singapore', 'Malaysia', 'Johor Port', '2020-08-24', '207368');

insert into `freight_transport_region_workitems`.`ftr_workitems`(`workitem_id`,`user_id`,`item_name`,`item_type`,`item_description`,`message_to_recipient`,`quantity`,`source_country`,`destination_country`,`selected_harbor_location`,`shipping_date`,`amount`) values('J2014','10003', 'Round pole milling machine', 'Wood', 'EMTEX 20mm Drilling and Milling MachineDM20', 'Please confirm once received.', '1500', 'India', 'Australia', 'Sydney Harbor', '2020-10-17','195000000');

insert into `freight_transport_region_workitems`.`ftr_workitems`(`workitem_id`,`user_id`,`item_name`,`item_type`,`item_description`,`message_to_recipient`,`quantity`,`source_country`,`destination_country`,`selected_harbor_location`,`shipping_date`,`amount`) values('J2015','10004', 'Honda Dio', 'Motorcycles', 'Honda', 'Please confirm once received.', '1331', 'India','Canada', 'Port Hawkesbury', '2020-11-04', '84300216');

insert into `freight_transport_region_workitems`.`ftr_workitems`(`workitem_id`,`user_id`,`item_name`,`item_type`,`item_description`,`message_to_recipient`,`quantity`,`source_country`,`destination_country`,`selected_harbor_location`,`shipping_date`,`amount`) values('J2016','10005', 'Washing Machine', 'Electronics', 'Whirlpool 6.5 Kg Fully-Automatic Top Load', 'Pleaseconfirm once received.', '3000','India', 'Singapore', 'Jurong', '2020-11-09', '40470000');

select * from ftr_workitems;



drop table if exists ftr_workitem_terminal;

create table ftr_workitem_terminal(
workitem_id varchar(10) primary key,
terminal_id varchar(10)
);

insert into `freight_transport_region_workitems`.`ftr_workitem_terminal` (`workitem_id`, `terminal_id`)values('J2012','T1');

insert into `freight_transport_region_workitems`.`ftr_workitem_terminal` (`workitem_id`, `terminal_id`)values('J2013','T2');

insert into `freight_transport_region_workitems`.`ftr_workitem_terminal` (`workitem_id`, `terminal_id`)values('J2016','T5');

insert into `freight_transport_region_workitems`.`ftr_workitem_terminal` (`workitem_id`, `terminal_id`)values('J2014','T7');

insert into `freight_transport_region_workitems`.`ftr_workitem_terminal` (`workitem_id`, `terminal_id`)values('J2015','T9');

select * from ftr_workitem_terminal;


drop table if exists ftr_vehicle_workItem;

create table ftr_vehicle_workItem(
workitem_id varchar(20) primary key,
vehicle_number varchar(20),
driver_id varchar(20),
assigned_workitem_status varchar(20)
);

insert into `freight_transport_region_workitems`.`ftr_vehicle_workitem`(`workitem_id`,`vehicle_number`,`driver_id`,`assigned_workitem_status`)values('J2012','UE7890','D111','InProgress');

insert into `freight_transport_region_workitems`.`ftr_vehicle_workitem`(`workitem_id`,`vehicle_number`,`driver_id`,`assigned_workitem_status`)values('J2013','WK7876','D112','InProgress');

insert into `freight_transport_region_workitems`.`ftr_vehicle_workitem`(`workitem_id`,`vehicle_number`,`driver_id`,`assigned_workitem_status`)values('J2014','DG8986','D113','Completed');

insert into `freight_transport_region_workitems`.`ftr_vehicle_workitem`(`workitem_id`,`vehicle_number`,`driver_id`,`assigned_workitem_status`)values('J2015','VQ7890','D114','InProgress');

insert into `freight_transport_region_workitems`.`ftr_vehicle_workitem`(`workitem_id`,`vehicle_number`,`driver_id`,`assigned_workitem_status`)values('J2016','BH2343','D115','Completed');

select * from ftr_vehicle_workitem;




drop table if exists ftr_harbor;

create table ftr_harbor(
country varchar(30) primary key,
available_harbor_locations varchar(200)
);

insert into `freight_transport_region_workitems`.`ftr_harbor` (`country`, `available_harbor_locations`)values('Singapore', 'Tanjong Pagar, Jurong');

insert into `freight_transport_region_workitems`.`ftr_harbor` (`country`, `available_harbor_locations`)values('Malaysia', 'Johor Port, Puteri, Telaga Harbor, Marina, Penang');

insert into `freight_transport_region_workitems`.`ftr_harbor` (`country`, `available_harbor_locations`)values('Australia', 'Sydney Harbor');

insert into `freight_transport_region_workitems`.`ftr_harbor` (`country`, `available_harbor_locations`)values('Canada', 'Port Hawkesbury, Halifax');

INSERT INTO `freight_transport_region_workitems`.`ftr_harbor` (`country`,`available_harbor_locations`) VALUES ('France', 'Old Port Of Marseille, Grand Port Maritime of Dunkirk');

select * from ftr_harbor;
commit;



