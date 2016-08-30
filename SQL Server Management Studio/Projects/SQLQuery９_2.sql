--９.２
exec sp_addsrvrolemember 'yan','sysadmin'
go
use YGGL
exec sp_addrolemember 'db_owner','yan'
go

create role myrole authorization dbo
go
--9.3
grant create table to yan
go

grant select ,delete on salary to yan
go

deny delete ,update on departments to yan
go

revoke select ,delete on salary from yan
go 
--10.1
create table tableA
(
num Int not null primary key ,
info XML not null 
)
insert into tableA values 
(1,'<员工信息>
	<姓名 编号 = "000001">王林</姓名>
	<学历>大专</学历>
	</员工信息>')
go

insert into tableA(num,info)
select 2 as num,
* from openrowset (bulk N'E:\Employ.xml',single_blob)
as info
go
select * from tableA 
go

declare @xmldoc xml
declare @number char(6)
set @xmldoc = 
'
<公司>
<员工信息>
	<员工>
	<姓名 编号 = "000001">王林</姓名>
	<学历>大专</学历>
	<出生日期>1966-01-23</出生日期>
	</员工>
	<员工>
	<姓名 编号 = "010008">伍容华</姓名>
	<学历>本科</学历>
	<出生日期>1976-03-28</出生日期>
	</员工>
</员工信息>
</公司>
'
select @xmldoc.query('/公司/员工信息/员工/姓名')as 员工姓名
select @xmldoc.query('//姓名[@编号 = "000001"]')
select @number = @xmldoc.value('(/公司/员工信息/员工/姓名/@编号)[2]','CHAR(6)')
select @number as 员工编号
go
