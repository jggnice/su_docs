use master
go
exec sp_addumpdevice 'disk','cpygbk','F:\理事王\cpygbk.bak'
backup database YGGL to cpygbk

exec sp_addumpdevice 'disk','test','F:\理事王\test.bak'
backup database YGGL to cpygbk with init


exec sp_addumpdevice 'disk','yggllogbk','F:\理事王\YGGLlog.bak'
backup log YGGL to yggllogbak


restore database YGGL from cpygbk with replace

restore database YGGL from cpygbk with norecovery, replace

restore Log YGGL from yggllogbk
