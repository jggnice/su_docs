use YGGL
create table Student
(
���� char(6)	not null,
�Ա� char(2)	not null
check(�Ա� in('��','Ů'))
)
insert into Student	values('130001','��')
use YGGL
go
create table Salary2
(	EmployeeID	char(6)		not null primary key,
	InCome		float		not null,
	OutCome		float		not null,
check(Income>=outcome)	
)
go
insert into Salary2 values('130001',120,121)

create table Employees6
(
ѧ�� char(6)	,
��������	date	not null
check(��������>'1980-01-01')
)
use YGGL
go
alter table Employees
add	constraint	Depart	check(DepartmentID>=1 and DepartmentID<=5)

INSERT INTO Employees VALUES('000002','����','��ר','1966-01-23',1,8,'��ɽ·32-1-508','83355668','8')

create rule list_rule
as @list in('����','�з���','������Դ��','���۲�')
go
exec sp_bindrule	'list_rule','Departments.DepartmentName'
go

create rule work_year_rule
as @list>=0 and @list<=20
go
exec sp_bindrule	'work_year_rule','Employees.Workyear'
go


use YGGL
go
create table Salary3
(	EmployeeID	char(6)		not null primary key,
	InCome		float		not null,
	OutCome		float		not null,
foreign key (EmployeeID)
references Salary(EmployeeID)
on update cascade
on delete cascade
)
/****ʵ��7***/
use YGGL
go
create trigger EmployeesIns on dbo.Employees
for insert,update
as
begin 
	if
((select DepartmentID from inserted )not in 
(select DepartmentID from Departments)	
	)
	rollback
end
go

use YGGL
go
create trigger EmployeesUpdate on dbo.Departments
for update
as
begin 
	update Employees
	set DepartmentID = (select DepartmentID from inserted)
	where DepartmentID=(select DepartmentID from deleted)
end
go

use YGGL
go
create trigger EmployeesDelete on dbo.Departments
for delete
as
begin 
	delete from Employees
	where DepartmentID=(select DepartmentID from deleted)
end
go

use YGGL
go
create trigger Employee_exists on dbo.Salary
instead of insert
as
begin 
	declare @EmployeeID char(6)
	select @EmployeeID = EmployeeID from inserted
	if(@EmployeeID in (select EmployeeID from Employees))
	insert into Salary select * from inserted
	else
	print 'Ա���Ų�����'	
end
go
insert into Salary values ('111111',2500.3,123.2)

