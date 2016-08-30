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
INSERT INTO Course(CourseID,CourseName,Teacher,Daytime,Description1) VALUES('ISCN0001','��ֵ����','chenminxin','151631323334','�ݷ�¥434'+char(10)+'������ֻ��12��')
INSERT INTO Course(CourseID,CourseName,Teacher,Daytime,Description1) VALUES('ISCN0002','�����ƻ���','Mr ding','13144344','�ݷ�¥134')
INSERT INTO Course(CourseID,CourseName,Teacher,Daytime,Description1) VALUES('ISCN0003','�㷨ʵ��','fliu','21222324','�ݷ�¥131')
INSERT INTO Course(CourseID,CourseName,Teacher,Daytime,Description1) VALUES('ISCN0004','���˼ԭ��','Mr xiang','5556','΢Ц¥301')
INSERT INTO Course(CourseID,CourseName,Teacher,Daytime,Description1) VALUES('ISCN0005','���ݿ�ԭ��','Mr cui','171845464748','�ݷ�¥434')
INSERT INTO Course(CourseID,CourseName,Teacher,Daytime,Description1) VALUES('ISCN0006','JAVA���','Mr ma','51525354','����Ժ����')
INSERT INTO Course(CourseID,CourseName,Teacher,Daytime,Description1) VALUES('ISCN0007','����Ӣ��','Mr zhang','2526','�ݷ�¥205')
INSERT INTO Course(CourseID,CourseName,Teacher,Daytime,Description1) VALUES('ISCN0008','ѧ��Ӣ��','Micel Jackson','5758','�ݷ�¥405')
INSERT INTO Course(CourseID,CourseName,Teacher,Daytime,Description1) VALUES('ISCN0009','�����˶�','Mr Mou','2526','����¥310')


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
where UserID in (select UserID from Students where Spec = '������ѧ')

INSERT INTO Grade(UserID,CourseID)
select  distinct  UserID,CourseID from Students,Course
where UserID in (select UserID from Students where Spec like '%ʦ��%')
and CourseID = (select CourseID from Course where CourseName like '%���˼%')
go

select * from Grade where CourseID = (select CourseID from Course where CourseName = '��ֵ����')
go
delete from Grade where UserID in 
(
select UserID from Students where UserType = 1
)
go

