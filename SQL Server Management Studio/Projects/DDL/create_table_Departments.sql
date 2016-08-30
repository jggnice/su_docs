use YGGL
go
create table Departments

(	
	DepartmentID		char(3)		not null primary key,	
	DepartmentName		char(20)	not null,	
	Note				char(100)	null,
)
go