merge into Students
using stu1 on students.userID=stu1.UserID
when matched then update set 
students.UserID=stu1.UserID,
students.UserType=stu1.UserType,
students.UserName=stu1.UserName,
students.UserPassword=stu1.UserPassword,
students.Sex=stu1.Sex,
students.Spec=stu1.Spec
when not matched then insert values(stu1.UserID,stu1.UserType,stu1.UserName,stu1.UserPassword,stu1.Sex,stu1.Spec)
when not matched by SOURCE then delete;