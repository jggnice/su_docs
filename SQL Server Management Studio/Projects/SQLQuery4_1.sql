use YGGL
go

/*_____________1)基本查询*/

/*所有列*/
/*select * from Employees*/
/*给定列*/
/*
select Address , PhoneNumber from Employees
*/
/*使用DISTINCT*/
/*select distinct DepartmentID from Employees
select distinct Sex from Employees*/
/*使用where*/
/*select Address, PhoneNumber from Employees
where EmployeeID = '000001'*//*横向约束*/
/*查询月收入>2000*/
/*
select employeeID from salary
where income > 2000
*/
/*查询1970年以后出生*/
/*
select name,address from employees
where birthday > '1970-01-01'
*/
/*查询财务部员工*/
/*
select name,phonenumber from employees
where DepartmentID = '1'
*/
/*使用as*/
/*select Address as 地址,PhoneNumber as 电话 
from Employees
where Sex=0*/
/*使用case*/
/*
select Name as 姓名,
case
	when sex=1 then '男'
	else '女'
	end as 性别
from employees
*/
/*使用运算符计算实际收入*/
/*
select employeeID,实际收入=income-outcome from salary
*/
/*使用COUNT函数计算员工总数*/
/*
select COUNT(*) as 员工总数 from employees
*/
/*使用Average函数计算平均收入*/
/*
select avg(income) as 平均收入 from salary
*/
/*使用max函数计算员工号码最大值*/
/*
select max(employeeID) as 最大EID from employees
*/
/*使用sum函数计算所员工支出*/
/*
select sum(outcome) as 总支出 from salary
*/
/*使用函数与运算符计算员工实际收入最值*/
/*
select max(income-outcome) as 最高实际收入,
		min(income-outcome) as 最底实际收入		
 from salary
 where EmployeeID in 
 (select EmployeeID from Departments
 where DepartmentName = '财务部' 
 )
*/
/*
select departmentID from Employees
where Name like '王%'
*/
/*
select employeeID,departmentID from Employees
where Address like '%中山%'
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
select employeeID as 编号,income as 收入
into 收入在1500以上的员工
from Salary
where InCome > 1500
*/
/*
select employeeID 编号,name 收入 into 男员工
from Employees where Sex = 1
*/

/*_____________2)子查询*/

/*
select * from Employees 
where DepartmentID = 
(
select DepartmentID from Departments 
where DepartmentName = '财务部'
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
where DepartmentName = '财务部'
)
and
Birthday <= all 
(
select Birthday from Employees where DepartmentID in 
(
select DepartmentID from Departments where DepartmentName = '研发部'
)
)
*/
/*
select name from Employees where DepartmentID in
(
select DepartmentID from Departments where DepartmentName = '研发部'
)
and
EmployeeID in 
(
select EmployeeID from Salary where InCome > all 
(
select InCome from Salary where DepartmentID in
(
select DepartmentID from Departments where DepartmentName = '财务部'
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
select DepartmentID from Departments where DepartmentName = '财务部'
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
select DepartmentID from Departments where DepartmentName = '研发部'
)
)
*/

/*_____________3)连接查询*/


/*
select Employees.*,Salary.* from Employees,Salary 
where employees.EmployeeID = Salary.EmployeeID 
*/
/*
select Employees.*,Departments.* from Employees,Departments
where employees.DepartmentID = Departments.DepartmentID 
*/
/*使用内连接*/
/*
select Departmentname from Departments join Employees on 
employees.DepartmentID = Departments.DepartmentID 
where employees.Name = '王林'
*/
/*
select * from Departments join Employees on 
employees.DepartmentID = Departments.DepartmentID 
where Departments.DepartmentName <> '财务部'
*/

/*
select employees.name,salary.income from Employees left join salary on 
employees.EmployeeID = salary.employeeID 
*/


/*
select name , income ,outcome from Employees,Salary, Departments
where employees.EmployeeID = salary.EmployeeID
and   employees.DepartmentID = Departments.DepartmentID
and   DepartmentName = '财务部'
and   InCome > 2000
*/
/*
select name , income ,outcome from Employees,Salary, Departments
where employees.EmployeeID = salary.EmployeeID
and   employees.DepartmentID = Departments.DepartmentID
and   DepartmentName = '研发部'
and   birthday < '1976-01-01'
*/

/*_____________4)使用聚合函数查询*/


/*
select AVG(income) as '财务部平均收入' from Salary 
where EmployeeID in 
(
select EmployeeID from Employees where DepartmentID in
(
select DepartmentID from Departments where DepartmentName = '财务部'
)
)
*/
/*
select max(income) as '财务部最高收入', min(income) as '财务部最低收入' from Salary 
where EmployeeID in 
(
select EmployeeID from Employees where DepartmentID in
(
select DepartmentID from Departments where DepartmentName = '财务部'
)
)
*/
/*
select AVG(income-OutCome) as '财务部平均实际收入' from Salary 
where EmployeeID in 
(
select EmployeeID from Employees where DepartmentID in
(
select DepartmentID from Departments where DepartmentName = '财务部'
)
)
*/
/*
select max(income-OutCome ) as '财务部实际最高收入', min(income-OutCome ) as '财务部实际最低收入' from Salary 
where EmployeeID in 
(
select EmployeeID from Employees where DepartmentID in
(
select DepartmentID from Departments where DepartmentName = '财务部'
)
)
*/
/*财务部总人数*/
/*
select COUNT(employeeID)财务部总人数 from Employees 
where DepartmentID in
(
select DepartmentID from Departments where DepartmentName = '财务部'
)
*/

/*财务部>2500元的总人数*/
/*
select COUNT(employeeID) as '财务部>2500元的总人数' from Employees 
where EmployeeID in 
(select EmployeeID from Salary where InCome > 2500)
AND DepartmentID = 
(
select DepartmentID from Departments where DepartmentName = '财务部'
)
*/


/*_____________5)查询结果分组和排序*/


/*
select sex ,count (sex) 人数 from employees
group by sex
*/
/*
select DepartmentID ,count (DepartmentID) 人数 from employees
group by DepartmentID
*/
/*
select Education ,count (Education) 人数 from employees
group by Education
*/
/*员工超过2人的*/
/*
select Departments.DepartmentName, count(*) as 人数 from employees ,Departments
where employees.DepartmentID = Departments.DepartmentID
group by Departments.DepartmentName
having count(*) > 2
*/
/*工作年份*/
/*
select WorkYear, count(*) as 人数 from employees
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
select (income-outcome) as 实际收入,employees.*,salary.* from employees,salary
where employees.employeeID = salary.employeeID
order by income-outcome
*/


go