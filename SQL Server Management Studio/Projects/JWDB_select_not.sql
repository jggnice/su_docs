Use JWDB
/*
select top (2) * from Students 

where UserID not in
(select top (4) UserID from Students)
*/

select top(2) * from Grade where UserID= '����'
and CourseID not in
(select top(150) CourseID from Grade where UserID= '����')

delete from Grade where UserID like '%���س�%'

delete from Students where UserID like '%���س�%'

select top(100) * from Students where 
UserID not in
(select top(150) UserID from Students
)