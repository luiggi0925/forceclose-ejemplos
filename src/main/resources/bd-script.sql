CREATE DATABASE encuestas
GO
USE encuestas
GO
CREATE TABLE dbo.encuesta (
	id bigint PRIMARY KEY IDENTITY(1,1) NOT NULL,
	titulo nvarchar(50)
)
GO
CREATE TABLE dbo.pregunta (
	id bigint PRIMARY KEY IDENTITY(1,1),
	texto nvarchar(100),
	encuesta_id bigint NOT NULL,
	FOREIGN KEY (encuesta_id) REFERENCES dbo.encuesta(id)
)
GO

ALTER TABLE dbo.encuesta ADD enable int
GO
