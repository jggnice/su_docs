use JWDB
go

/*
truncate table Students
INSERT INTO Students(UserID) VALUES('Mr Ma')
INSERT INTO Students(UserID) VALUES('Chenminxin')
INSERT INTO Students(UserID) VALUES('Fliu')
INSERT INTO Students(UserID) VALUES('CuiJie')
INSERT INTO Students(UserID) VALUES('Huan Fei')
INSERT INTO Students(UserID) VALUES('Wang')
Update Students set UserPassWord = UserID
Update Students set UserName = UserID
*/

truncate table Course
INSERT INTO Course(CourseID,CourseName,Teacher,Daytime,Description1) VALUES('ISCN0001','数值分析','chenminxin','151631323334','逸夫楼434'+char(10)+'单周三只上12节')
INSERT INTO Course(CourseID,CourseName,Teacher,Daytime,Description1) VALUES('ISCN0002','软件设计基础','Mr ding','13144344','逸夫楼134')
INSERT INTO Course(CourseID,CourseName,Teacher,Daytime,Description1) VALUES('ISCN0003','算法实践','fliu','21222324','逸夫楼131')
INSERT INTO Course(CourseID,CourseName,Teacher,Daytime,Description1) VALUES('ISCN0004','马克思原理','Mr xiang','5556','微笑楼301')
INSERT INTO Course(CourseID,CourseName,Teacher,Daytime,Description1) VALUES('ISCN0005','数据库原理','Mr cui','171845464748','逸夫楼434')
INSERT INTO Course(CourseID,CourseName,Teacher,Daytime,Description1) VALUES('ISCN0006','JAVA编程','Mr ma','51525354','数科院机房')
INSERT INTO Course(CourseID,CourseName,Teacher,Daytime,Description1) VALUES('ISCN0007','考研英语','Mr zhang','2526','逸夫楼205')
INSERT INTO Course(CourseID,CourseName,Teacher,Daytime,Description1) VALUES('ISCN0008','学术英语','Micel Jackson','5758','逸夫楼405')
INSERT INTO Course(CourseID,CourseName,Teacher,Daytime,Description1) VALUES('ISCN0009','定向运动','Mr Mou','2526','东教楼310')


truncate table Grade
INSERT INTO Grade(UserID,CourseID) VALUES('1507402001','ISCN0001')
INSERT INTO Grade(UserID,CourseID) VALUES('1507402001','ISCN0002')
INSERT INTO Grade(UserID,CourseID) VALUES('1507402001','ISCN0003')
INSERT INTO Grade(UserID,CourseID) VALUES('1507402002','ISCN0001')
INSERT INTO Grade(UserID,CourseID) VALUES('1507402002','ISCN0005')
INSERT INTO Grade(UserID,CourseID) VALUES('1507402002','ISCN0006')
INSERT INTO Grade(UserID,CourseID) VALUES('1507402002','ISCN0007')
INSERT INTO Grade(UserID,CourseID) VALUES('1507402003','ISCN0001')
INSERT INTO Grade(UserID,CourseID) VALUES('1507402003','ISCN0009')
INSERT INTO Grade(UserID,CourseID) VALUES('1507402003','ISCN0001')
INSERT INTO Grade(UserID,CourseID) VALUES('1507402003','ISCN0002')
INSERT INTO Grade(UserID,CourseID) VALUES('1507402003','ISCN0003')
INSERT INTO Grade(UserID,CourseID) VALUES('1507402003','ISCN0004')
Update Grade set Gmark = 95
Update Grade set Gmark = 88 where CourseID = 'ISCN0004'
Update Grade set Gmark = 81 where CourseID = 'ISCN0002'

truncate table TeacherCourse
INSERT INTO TeacherCourse(UserID,CourseID) VALUES('Mr Ma','ISCN0001')
INSERT INTO TeacherCourse(UserID,CourseID) VALUES('Chenminxin','ISCN0002')
INSERT INTO TeacherCourse(UserID,CourseID) VALUES('Fliu','ISCN0003')
INSERT INTO TeacherCourse(UserID,CourseID) VALUES('CuiJie','ISCN0004')
INSERT INTO TeacherCourse(UserID,CourseID) VALUES('Huan Fei','ISCN0005')
INSERT INTO TeacherCourse(UserID,CourseID) VALUES('Wang','ISCN0006')
INSERT INTO TeacherCourse(UserID,CourseID) VALUES('Wang','ISCN0005')
INSERT INTO TeacherCourse(UserID,CourseID) VALUES('Wang','ISCN0004')
INSERT INTO TeacherCourse(UserID,CourseID) VALUES('Wang','ISCN0003')
INSERT INTO TeacherCourse(UserID,CourseID) VALUES('Wang','ISCN0002')
INSERT INTO TeacherCourse(UserID,CourseID) VALUES('Wang','ISCN0001')

go

INSERT INTO Grade(UserID,CourseID)
select UserID,CourseID from Students,Course
where UserID not in (select UserID from Grade)
and CourseID not in ((select CourseID from Grade))
go


INSERT INTO Grade(UserID,CourseID)
select  distinct  '1507402001',CourseID from Students,Course

delete from Grade 
where CourseID = 'ISCN0001'

INSERT INTO Grade(UserID,CourseID)
select  distinct  UserID,'ISCN0001' from Students,Course
where UserID in (select UserID from Students where Spec = '金融数学')

INSERT INTO Grade(UserID,CourseID)
select  distinct  UserID,CourseID from Students,Course
where UserID in (select UserID from Students where Spec like '%师范%')
and CourseID = (select CourseID from Course where CourseName like '%马克思%')
go

select * from Grade where CourseID = (select CourseID from Course where CourseName = '数值分析')
go
delete from Grade where UserID in 
(
select UserID from Students where UserType = 1
)
go

