--��.��
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
(1,'<Ա����Ϣ>
	<���� ��� = "000001">����</����>
	<ѧ��>��ר</ѧ��>
	</Ա����Ϣ>')
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
<��˾>
<Ա����Ϣ>
	<Ա��>
	<���� ��� = "000001">����</����>
	<ѧ��>��ר</ѧ��>
	<��������>1966-01-23</��������>
	</Ա��>
	<Ա��>
	<���� ��� = "010008">���ݻ�</����>
	<ѧ��>����</ѧ��>
	<��������>1976-03-28</��������>
	</Ա��>
</Ա����Ϣ>
</��˾>
'
select @xmldoc.query('/��˾/Ա����Ϣ/Ա��/����')as Ա������
select @xmldoc.query('//����[@��� = "000001"]')
select @number = @xmldoc.value('(/��˾/Ա����Ϣ/Ա��/����/@���)[2]','CHAR(6)')
select @number as Ա�����
go
