/*
create function check_id(@id char(3))returns int as
begin
declare @num int
if exists 
(select DepartmentID from Departments where @id = DepartmentID)
select @num = 0
else
select @num = -1
return @num
end
go
*/
/*
use YGGL
go
declare @num int
select @num = dbo.check_id('2')
if	@num = 0
insert into Employees
values('990210','��Ӣ','����','1982-03-24',0,4,'�Ͼ�����·2��','8497534','2')
go
*/



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