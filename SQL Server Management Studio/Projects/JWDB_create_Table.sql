use JWDB
go
/*
create table Students
(	UserID		varchar(10)		not null primary key,
	UserType	int				null default 0,
	UserName	varchar(10)		null,
	UserPassword varchar(15)	null,
	Sex			char(2)			null default 'ÄÐ',
	Spec		varchar(20)		null default 'ÐÅÏ¢'
)
*/
/*
create table Course
(	CourseID	varchar(10)		not null primary key,	
	CourseName	varchar(20)			null,
	Credit			int				null default 4,
	Teacher		varchar(15)			null,
	Daytime		varchar(20)			null,
	Description1 varchar(50)		null
)
*/
/*
create table Grade
(	UserID		varchar(10)		not null ,
	CourseID	varchar(10)		not null ,
	Gmark		int				null,
	primary key (UserID,CourseID),
	Foreign key (UserID) references Students(UserID),
	Foreign key (CourseID) references Course(CourseID)
)
*/
create table TeacherCourse
(	UserID		varchar(10)		not null ,
	CourseID	varchar(10)		not null ,
	primary key (UserID,CourseID),
	Foreign key (UserID) references Students(UserID),
	Foreign key (CourseID) references Course(CourseID)
)

go