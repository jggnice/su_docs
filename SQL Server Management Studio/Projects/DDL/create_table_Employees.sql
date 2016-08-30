use YGGL
go
create table Employees
(	EmployeeID	char(6)		not null primary key,
	Name		char(10)	not null,
	Education	char(4)		not null,
	Birthday	date		not null,
	Sex			bit			not null default 1,
	WorkYear	tinyint		null,
	Address		varchar(40)	null,
	PhoneNumber	char(12)	null,
	DepartmentID char(3)	not null,
)
go