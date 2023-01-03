use product;
create table product1(
product_id int not null primary key auto_increment,
product_Description varchar(210),
product_price varchar(215),
product_name varchar(230),
product_quantity varchar(240)
);
use product;
create table productitem(
product_id int not null primary key auto_increment,
product_description varchar(210),
product_price varchar(220),
product_name varchar(220),
product_quantity varchar(230)
);
desc productitem;
use product;
use product;
create table userdetails(
FirstName varchar(255),
LastName  varchar(255),
EmailId  varchar(255),
MobileNumber varchar(255),
UserName  varchar(255),
Password varchar(255),
primary key(UserName)
);
desc userdatails;
desc userdetails;
use product;

create table buy_product_history(
SRNO int not null auto_increment,
USERNAME varchar(255),
PRODUCT_NAME varchar(255),
PRODUCT_QUANTITY varchar(255),
PRICE varchar(255),
TOTAL_PRICE varchar(255),
primary key(SRNO)
);
desc buy_product_history;
use product;
insert into productitem(product_description,product_price,product_name,product_quantity)
values('fancy watch','990','watch',10),
('asus laptop with 5GB RAM silver color','50000','asus laptop',15),
('boots headphone with blue color bluetooth connected','1000','boots headphone',13),
('smartphone samsung RAM-4GB','25000','samsung phone',7),
('Bajaj iron with white color','750','iron',12),
('Havells wind Storm 3 blade','3409','Fan',18),
('whirlpool 7kg fully automatic','17000','washing machine',6),
('AQUA PURE RO water purifier','9000',' water purifier',11),
('single door direct cool refrigerator','17500','refrigerator',8),
('mixer phillips 750watt 5 jars','7550','mixer grinder',14);

select * from productitem;
commit;
select * from userdetails;
commit;
select * from userdetails;
commit;
select *from userdetails;
commit;

commit;
select * from userdetails;
commit;
select * from userdetails;
delete from userdetails where USERNAME='admin';
select * from  userdetails;
delete from userdetails;
select * from buy_product_history;
set	sql_safe_updates=0;
delete from userdetails;
select * from userdetails;
delete from buy_product_history;
select * from userdetails;
commit;
select * from userdetails;
delete from userdetails where UserName='admin';
select * from buy_product_history;
delete from userdetails where UserName='admin';
select * from buy_product_history;	
select 									




