use YGGL 
/*
EXEC sp_addtype 'ID_type',
'char(6)','not null'
go
*/
/*
if exists
(select name from sysobjects where name = 'Employees3')Drop table Employees3
create table Employees3
(	EmployeeID	ID_type,
	Name		char(10)	not null,
	Education	char(4)		not null,
	Birthday	date		not null,
	Sex			bit			not null default 1,
	WorkYear	tinyint		null,
	Address		varchar(40)	null,
	PhoneNumber	char(12)	null,
	DepartmentID char(3)	not null,
	primary key(EmployeeID)
)
*/

/*
declare @female bit
set @female=0
select * from Employees where Sex=@female
*/
/*
declare @phone char(12)
set @phone=
(select PhoneNumber from Employees where EmployeeID='102201')
select @phone
*/
/*
declare @realincom float
set @realincom=
(select InCome-OutCome from Salary where EmployeeID='000001')
select @realincom
*/
/*
select InCome-OutCome from Salary
*/
/*
select * from Employees where WorkYear > 5
*/
/*
if exists 
(select Name from Employees Where EmployeeID = '111006')
select * from Employees Where EmployeeID = '111006'
else
select '���޴���'
*/
/*
declare @realincom float
set @realincom=
(select InCome-OutCome from Salary where EmployeeID = 
	(select EmployeeID from Employees where Name = '����')
)
if @realincom>3000
select '�������3000'
else
select '���벻����3000'
*/
/*
declare @x int
set @x=1
while @x<5
begin 
	set @x=@x+1
	print 'x='+convert(char(1),@x)
end
*/
/*
declare @x int
set @x=1
while @x<8
begin 
	
	print replicate(' ',8-@x) + replicate(' *',@x)
	set @x=@x+1	
end
*/
/*replicate('*',5)*//*print char(10)*/
/*
select EmployeeID,Name,Address,DepartmentID = 
Case DepartmentID
when 1 then '����'
when 2 then '������Դ��'
when 3 then '����칫��'
when 4 then '�з���'
when 5 then '�г���'
end
from Employees
*/
/*ʹ��if*/
/*
select ABS(-123)
select RAND()
select square(9)
select SQRT(81)
*/
/*
select COUNT(*) as ���� from Employees
where DepartmentID = 
(select DepartmentID from Departments where 
DepartmentName = '����'
)
*/
/*
select Name from Employees,Salary,Departments
where	Employees.EmployeeID = Salary.EmployeeID
and		Employees.DepartmentID = Departments.DepartmentID
and		DepartmentName = '����'
and		Income >= all
(
select Income from Employees,Salary,Departments
where	Employees.EmployeeID = Salary.EmployeeID
and		Employees.DepartmentID = Departments.DepartmentID
and		DepartmentName = '����'
)
*/
/*
select Name from Employees where EmployeeID = 
(select EmployeeID from Salary
where InCome =
(select MAX(Income) from Salary where EmployeeID in 
(select EmployeeID from Employees where DepartmentID = 
(select DepartmentID from Departments where DepartmentName = '����')
)
)
)
*/
/*
select AVG(Income) from Salary 
*/
/*�����ַ���������ַ���ASCIIֵ*/
/*
select ASCII('abc')
select char(97)+CHAR(98)+CHAR(99)
select LEFT('qwecdef',3)
select GETDATE()
select year(getdate())
*/
