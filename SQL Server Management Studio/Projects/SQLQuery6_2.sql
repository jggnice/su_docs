use YGGL 
go
create index depart_ind
on Employees (DepartmentID)
go 
create index Ad_ind
on employees (Name ,Address )

create unique index Dep_ind 
on Departments(DepartmentName )

use YGGL
go
alter index all 
on employees rebuild

drop index depart_ind on employees
drop index Ad_ind on employees

use YGGL
go
create table Employees5
(	EmployeeID	char(6)		not null primary key,
	Name		char(10)	not null,
	Education	char(4)		not null,	
	Sex			bit			not null default 1,
	constraint UK_id unique (employeeID )
)
go

alter table employees5
drop constraint UK_id
go
--存储过程
use YGGL 
go
create procedure test @NUMBER1 int output as
begin
declare @NUMBER2 int
set @NUMBER2 = (select count(*) from Employees )
set @NUMBER1 = @NUMBER2
end
go

/*
declare @num int 
exec test @num output 
select @num 
*/

create procedure compa @ID1 char(6) ,@ID2 char(6) ,@BJ int output as
begin 
declare @SR1 float ,@SR2 float 
select @SR1 = income - outcome from salary where EmployeeID = @ID1
select @SR2 = income - outcome from salary where EmployeeID = @ID2
if(@ID1>@ID2) set @BJ = 0
else set @BJ = 1
end
go

/*
declare @rs int 
exec compa '000001','108991',@rs output 
select @rs
*/

create procedure EmployeeAdd
(
@employeeid char(6),
@name char(10),
@education char(4),
@birthday datetime ,
@workyear tinyint ,
@sex bit ,
@address char(40) ,
@phonenumber char(12),
@departmentid char(3) 
)
as
begin 

insert into Employees 
values 
(
@employeeid,
@name,
@education,
@birthday,
@workyear,
@sex,
@address,
@phonenumber,
@departmentid
)

end

return 
go

exec EmployeeAdd '990230','刘朝','本科','840909',2,1,'武汉小洪山5号','85465213','3'
go

create procedure IS_TOP_THREE @EM_ID char(6),@OK bit output as
begin 
declare @X_EM_ID char(6)  
declare @ACT_IN int ,@SEQ int
declare SALARY_DIS cursor for 
select EmployeeID ,income - outcome from salary order by income -outcome desc
set @SEQ = 0
set @OK = 0
open salary_dis
 fetch salary_dis into @X_EM_ID ,@ACT_IN
 while @SEQ <3 and @OK =0
 begin 
 set @SEQ = @SEQ +1
 if(@X_EM_ID = @EM_ID)
 set @OK =1
  fetch salary_dis into @X_EM_ID ,@ACT_IN
 end
 close salary_dis
 deallocate salary_dis
end
go
declare  @OK  bit
exec IS_TOP_THREE '108991',@OK output 
select @OK
go