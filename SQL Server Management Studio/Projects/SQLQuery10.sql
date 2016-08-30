--实验10
declare @xmldoc xml
set @xmldoc = '<员工信息>
	<姓名 编号 = "000001">王林</姓名>
	<性别>男</性别>
	<学历>大专</学历>
	</员工信息>'
select @xmldoc as 插入节点前数据
set @xmldoc.modify('insert <出生日期>1991-02-10</出生日期>after(/员工信息/性别)[1]')
select @xmldoc 插入节点后数据
go


declare @xmldoc xml
set @xmldoc = '<员工信息>
	<姓名 编号 = "000001">王林</姓名>
	<性别>男</性别>
	<学历>大专</学历>
	</员工信息>'
select @xmldoc as 前数据
set @xmldoc.modify('delete (/员工信息/性别)[1]')
select @xmldoc 后数据
go


declare @xmldoc xml
set @xmldoc = '<员工信息>
	<姓名 编号 = "000001">王林</姓名>
	<性别>男</性别>
	<学历>大专</学历>
	</员工信息>'
select @xmldoc as 前数据
set @xmldoc.modify('replace value of (/员工信息/姓名/@编号)[1] with "000003"')
select @xmldoc 后数据
go


declare @xmldoc xml
set @xmldoc = '<员工信息>
	<姓名 编号 = "000001">王林</姓名>
	<性别>男</性别>
	<学历>大专</学历>
	</员工信息>'

select @xmldoc.exist('/员工信息/姓名/@编号') as 位值
go

select * from Employees where WorkYear > 3 
for xml raw,root('员工信息')
go


select * from Employees where WorkYear > 3 
for xml auto,root('员工信息')
go

select PhoneNumber '@联系电话',
EmployeeID '员工信息/编号',
Name '员工信息/姓名',
WorkYear '员工信息/工作时间'
 from Employees
 where Education = '硕士'
 for xml path('硕士员工'),root('根元素')
 go
 
 
 select 
 Income-outcome '员工信息/@实际收入',
 Name '员工信息/@姓名',
 Employees.EmployeeID '员工信息/编号',

WorkYear '员工信息/工作时间'
 from Employees,Salary
 where Employees.EmployeeID = Salary.EmployeeID
 and (Income-outcome)>2000
 for xml path('实际收入大于2000的员工'),root('根元素')
 go
 