use master
go
exec sp_addumpdevice 'disk','cpygbk','F:\������\cpygbk.bak'
backup database YGGL to cpygbk

exec sp_addumpdevice 'disk','test','F:\������\test.bak'
backup database YGGL to cpygbk with init


exec sp_addumpdevice 'disk','yggllogbk','F:\������\YGGLlog.bak'
backup log YGGL to yggllogbak


restore database YGGL from cpygbk with replace

restore database YGGL from cpygbk with norecovery, replace

restore Log YGGL from yggllogbk
