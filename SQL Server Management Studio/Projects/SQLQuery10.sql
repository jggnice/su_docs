--ʵ��10
declare @xmldoc xml
set @xmldoc = '<Ա����Ϣ>
	<���� ��� = "000001">����</����>
	<�Ա�>��</�Ա�>
	<ѧ��>��ר</ѧ��>
	</Ա����Ϣ>'
select @xmldoc as ����ڵ�ǰ����
set @xmldoc.modify('insert <��������>1991-02-10</��������>after(/Ա����Ϣ/�Ա�)[1]')
select @xmldoc ����ڵ������
go


declare @xmldoc xml
set @xmldoc = '<Ա����Ϣ>
	<���� ��� = "000001">����</����>
	<�Ա�>��</�Ա�>
	<ѧ��>��ר</ѧ��>
	</Ա����Ϣ>'
select @xmldoc as ǰ����
set @xmldoc.modify('delete (/Ա����Ϣ/�Ա�)[1]')
select @xmldoc ������
go


declare @xmldoc xml
set @xmldoc = '<Ա����Ϣ>
	<���� ��� = "000001">����</����>
	<�Ա�>��</�Ա�>
	<ѧ��>��ר</ѧ��>
	</Ա����Ϣ>'
select @xmldoc as ǰ����
set @xmldoc.modify('replace value of (/Ա����Ϣ/����/@���)[1] with "000003"')
select @xmldoc ������
go


declare @xmldoc xml
set @xmldoc = '<Ա����Ϣ>
	<���� ��� = "000001">����</����>
	<�Ա�>��</�Ա�>
	<ѧ��>��ר</ѧ��>
	</Ա����Ϣ>'

select @xmldoc.exist('/Ա����Ϣ/����/@���') as λֵ
go

select * from Employees where WorkYear > 3 
for xml raw,root('Ա����Ϣ')
go


select * from Employees where WorkYear > 3 
for xml auto,root('Ա����Ϣ')
go

select PhoneNumber '@��ϵ�绰',
EmployeeID 'Ա����Ϣ/���',
Name 'Ա����Ϣ/����',
WorkYear 'Ա����Ϣ/����ʱ��'
 from Employees
 where Education = '˶ʿ'
 for xml path('˶ʿԱ��'),root('��Ԫ��')
 go
 
 
 select 
 Income-outcome 'Ա����Ϣ/@ʵ������',
 Name 'Ա����Ϣ/@����',
 Employees.EmployeeID 'Ա����Ϣ/���',

WorkYear 'Ա����Ϣ/����ʱ��'
 from Employees,Salary
 where Employees.EmployeeID = Salary.EmployeeID
 and (Income-outcome)>2000
 for xml path('ʵ���������2000��Ա��'),root('��Ԫ��')
 go
 