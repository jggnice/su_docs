use YGGL
go

/*_____________1)������ѯ*/

/*������*/
/*select * from Employees*/
/*������*/
/*
select Address , PhoneNumber from Employees
*/
/*ʹ��DISTINCT*/
/*select distinct DepartmentID from Employees
select distinct Sex from Employees*/
/*ʹ��where*/
/*select Address, PhoneNumber from Employees
where EmployeeID = '000001'*//*����Լ��*/
/*��ѯ������>2000*/
/*
select employeeID from salary
where income > 2000
*/
/*��ѯ1970���Ժ����*/
/*
select name,address from employees
where birthday > '1970-01-01'
*/
/*��ѯ����Ա��*/
/*
select name,phonenumber from employees
where DepartmentID = '1'
*/
/*ʹ��as*/
/*select Address as ��ַ,PhoneNumber as �绰 
from Employees
where Sex=0*/
/*ʹ��case*/
/*
select Name as ����,
case
	when sex=1 then '��'
	else 'Ů'
	end as �Ա�
from employees
*/
/*ʹ�����������ʵ������*/
/*
select employeeID,ʵ������=income-outcome from salary
*/
/*ʹ��COUNT��������Ա������*/
/*
select COUNT(*) as Ա������ from employees
*/
/*ʹ��Average��������ƽ������*/
/*
select avg(income) as ƽ������ from salary
*/
/*ʹ��max��������Ա���������ֵ*/
/*
select max(employeeID) as ���EID from employees
*/
/*ʹ��sum����������Ա��֧��*/
/*
select sum(outcome) as ��֧�� from salary
*/
/*ʹ�ú��������������Ա��ʵ��������ֵ*/
/*
select max(income-outcome) as ���ʵ������,
		min(income-outcome) as ���ʵ������		
 from salary
 where EmployeeID in 
 (select EmployeeID from Departments
 where DepartmentName = '����' 
 )
*/
/*
select departmentID from Employees
where Name like '��%'
*/
/*
select employeeID,departmentID from Employees
where Address like '%��ɽ%'
*/
/*
select name,address,education from Employees
where EmployeeID like '____0_'
*/
/*
select employeeID from Salary 
where InCome between 2000 and 3000
*/

/*
select employeeID from Employees 
where DepartmentID ='1'
or DepartmentID = '2'
*/

/*
select employeeID as ���,income as ����
into ������1500���ϵ�Ա��
from Salary
where InCome > 1500
*/
/*
select employeeID ���,name ���� into ��Ա��
from Employees where Sex = 1
*/

/*_____________2)�Ӳ�ѯ*/

/*
select * from Employees 
where DepartmentID = 
(
select DepartmentID from Departments 
where DepartmentName = '����'
)
*/
/*
select * from Employees 
where EmployeeID in 
(
select EmployeeID from Salary 
where InCome < 2500
)
*/
/*
select name from Employees 
where DepartmentID in 
(
select DepartmentID from Departments 
where DepartmentName = '����'
)
and
Birthday <= all 
(
select Birthday from Employees where DepartmentID in 
(
select DepartmentID from Departments where DepartmentName = '�з���'
)
)
*/
/*
select name from Employees where DepartmentID in
(
select DepartmentID from Departments where DepartmentName = '�з���'
)
and
EmployeeID in 
(
select EmployeeID from Salary where InCome > all 
(
select InCome from Salary where DepartmentID in
(
select DepartmentID from Departments where DepartmentName = '����'
)
)
)
*/
/*
select name from Employees where EmployeeID in 
(
select EmployeeID from Salary where InCome > all 
(
select InCome from Salary where EmployeeID  in 
(
select EmployeeID from Employees where DepartmentID =
(
select DepartmentID from Departments where DepartmentName = '����'
)
)
)
)
*/
/*
select name from Employees where Birthday < all 
(
select Birthday from Employees where DepartmentID in
(
select DepartmentID from Departments where DepartmentName = '�з���'
)
)
*/

/*_____________3)���Ӳ�ѯ*/


/*
select Employees.*,Salary.* from Employees,Salary 
where employees.EmployeeID = Salary.EmployeeID 
*/
/*
select Employees.*,Departments.* from Employees,Departments
where employees.DepartmentID = Departments.DepartmentID 
*/
/*ʹ��������*/
/*
select Departmentname from Departments join Employees on 
employees.DepartmentID = Departments.DepartmentID 
where employees.Name = '����'
*/
/*
select * from Departments join Employees on 
employees.DepartmentID = Departments.DepartmentID 
where Departments.DepartmentName <> '����'
*/

/*
select employees.name,salary.income from Employees left join salary on 
employees.EmployeeID = salary.employeeID 
*/


/*
select name , income ,outcome from Employees,Salary, Departments
where employees.EmployeeID = salary.EmployeeID
and   employees.DepartmentID = Departments.DepartmentID
and   DepartmentName = '����'
and   InCome > 2000
*/
/*
select name , income ,outcome from Employees,Salary, Departments
where employees.EmployeeID = salary.EmployeeID
and   employees.DepartmentID = Departments.DepartmentID
and   DepartmentName = '�з���'
and   birthday < '1976-01-01'
*/

/*_____________4)ʹ�þۺϺ�����ѯ*/


/*
select AVG(income) as '����ƽ������' from Salary 
where EmployeeID in 
(
select EmployeeID from Employees where DepartmentID in
(
select DepartmentID from Departments where DepartmentName = '����'
)
)
*/
/*
select max(income) as '�����������', min(income) as '�����������' from Salary 
where EmployeeID in 
(
select EmployeeID from Employees where DepartmentID in
(
select DepartmentID from Departments where DepartmentName = '����'
)
)
*/
/*
select AVG(income-OutCome) as '����ƽ��ʵ������' from Salary 
where EmployeeID in 
(
select EmployeeID from Employees where DepartmentID in
(
select DepartmentID from Departments where DepartmentName = '����'
)
)
*/
/*
select max(income-OutCome ) as '����ʵ���������', min(income-OutCome ) as '����ʵ���������' from Salary 
where EmployeeID in 
(
select EmployeeID from Employees where DepartmentID in
(
select DepartmentID from Departments where DepartmentName = '����'
)
)
*/
/*����������*/
/*
select COUNT(employeeID)���������� from Employees 
where DepartmentID in
(
select DepartmentID from Departments where DepartmentName = '����'
)
*/

/*����>2500Ԫ��������*/
/*
select COUNT(employeeID) as '����>2500Ԫ��������' from Employees 
where EmployeeID in 
(select EmployeeID from Salary where InCome > 2500)
AND DepartmentID = 
(
select DepartmentID from Departments where DepartmentName = '����'
)
*/


/*_____________5)��ѯ������������*/


/*
select sex ,count (sex) ���� from employees
group by sex
*/
/*
select DepartmentID ,count (DepartmentID) ���� from employees
group by DepartmentID
*/
/*
select Education ,count (Education) ���� from employees
group by Education
*/
/*Ա������2�˵�*/
/*
select Departments.DepartmentName, count(*) as ���� from employees ,Departments
where employees.DepartmentID = Departments.DepartmentID
group by Departments.DepartmentName
having count(*) > 2
*/
/*�������*/
/*
select WorkYear, count(*) as ���� from employees
group by WorkYear
*/
/*
select employees.*,salary.* from employees,salary
where employees.employeeID = salary.employeeID
order by income
*/
/*
select employees.* from employees
order by birthday
*/
/*
select (income-outcome) as ʵ������,employees.*,salary.* from employees,salary
where employees.employeeID = salary.employeeID
order by income-outcome
*/


go