use YGGL 
go


/* 
create view DS_view
as select * from Departments
*/
/*
create view Employees_view(EmployeeID,Name,RealIncome)
as select Employees.EmployeeID,Name,income-outcome from employees,salary
where Employees.EmployeeID = salary.employeeID
*/
/*
create view Employees_view2(EmployeeID,Name,departmentName,RealIncome)
as select Employees.EmployeeID,Name,departmentName,income-outcome from employees,salary,departments
where Employees.EmployeeID = salary.employeeID
and employees.departmentID = departments.departmentID
*/
/*
select departmentName from DS_view
where departmentID = '3'
*/
/*
select realincome from employees_view
where name = '����'
*/
/*3)������ͼ*/
/*(1) ����*/
/*
insert into DS_view values('6','��沿','���ҵ��')
*/
/*
update DS_view 
set DepartmentName = '��������' where DepartmentID = '5'
*/
/*
update Employees_view 
set Name = '����' where EmployeeID = '000001'
*/
/*
delete from DS_view 
where DepartmentID = '1'
*/
/*
drop view DS_view
*/
go