use bank;

create table acounts(formNo int primary key,firstName varchar(30),fatherName varchar(30),surname varchar(30),mobileNO long,email varchar(100),gender char(10),Bdate varchar(50),address varchar(100),city char(30),state char(30),pinCode long);
select * from acounts;
ALTER TABLE acounts MODIFY COLUMN  formNo int primary key;
ALTER TABLE acounts MODIFY COLUMN  Bdate varchar(50);
delete from acounts where formno=4197;
drop table acounts;


create table AcountsAditionalDetail(formNo int primary key ,adhar_number varchar(12),pan_number varchar(10),acount_type varchar(10));
insert into AcountsAditionalDetail values(2377,'635452322112','harsh9665d','Carent');
select * from AcountsAditionalDetail;
delete from AcountsAditionalDetail where formNo=4197 ;
                                                          
                                                          
create table Acountno(formno int primary key,acount_number varchar(12),pin_number varchar(4),count varchar(10));
select * from Acountno;
insert into Acountno values(2377,'635452322112','9665');
alter table Acountno add count varchar(10);
delete from Acountno where formno=4197 ;

create table transactions(pin varchar(4) primary key,amount varchar(10),type_of_transaction varchar(10),transaction_date varchar(300) );
alter table transactions add column balance varchar(30);
select * from transactions;
ALTER TABLE transactions MODIFY COLUMN  transaction_date varchar(200);

create table accounts (pin varchar(4) primary key,balance varchar(10));
select * from accounts; 
