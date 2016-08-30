CREATE DATABASE YGGL2
ON
(
	NAME='YGGL_Data',
	FILENAME='F:\YGGL.mdf',
	SIZE=10 MB,
	MAXSIZE=50 MB,
	FILEGROWTH=5%
)
LOG ON
(
	NAME='YGGL_Log',
	FILENAME='F:\YGGL_Log.Ldf',
	SIZE=2 MB,
	MAXSIZE=5 MB,
	FILEGROWTH=1 MB
)
GO