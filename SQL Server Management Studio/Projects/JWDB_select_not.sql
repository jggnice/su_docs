Use JWDB
/*
select top (2) * from Students 

where UserID not in
(select top (4) UserID from Students)
*/

select top(2) * from Grade where UserID= '聪明'
and CourseID not in
(select top(150) CourseID from Grade where UserID= '聪明')

delete from Grade where UserID like '%四重唱%'

delete from Students where UserID like '%四重唱%'

select top(100) * from Students where 
UserID not in
(select top(150) UserID from Students
)