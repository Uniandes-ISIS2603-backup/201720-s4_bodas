--Pruebas para Pareja Entity
delete from BodaEntity;
delete from ParejaEntity;


insert into ParejaEntity (correoElec, nombreInd1, nombreInd2, telefono, pago, contrasenia, nombreAbreviado, direccion) values ('fmarsland0@artisteer.com', 'Aaren', 'Ferrell', 86, 1, 'cGUDt68M', 'Agavaceae', '46 Gulseth Place');
insert into ParejaEntity (correoElec, nombreInd1, nombreInd2, telefono, pago, contrasenia, nombreAbreviado, direccion) values ('bsimcoe1@dion.ne.jp', 'Elbertina', 'Baxy', 79, 0, '66tNlmFd', 'Asteraceae', '936 Mendota Plaza');



/*
insert into BodaEntity (pareja_correoelec,lugar, fecha, tema, religion, tipoBoda) values ('fmarsland0@artisteer.com','Thackeray', '2016-12-12', 'Persian', 'University of South Carolina - Union', 'aggregate cutting-edge e-business');
insert into BodaEntity (pareja_correoelec,lugar, fecha, tema, religion, tipoBoda) values ('fmarsland0@artisteer.com','Susan', '2017-03-09', 'Māori', 'Davidson College', 'transform integrated metrics');
insert into BodaEntity (pareja_correoelec,lugar, fecha, tema, religion, tipoBoda) values ('bsimcoe1@dion.ne.jp','Oneill', '2017-03-06', 'Dzongkha', 'Vitebsk State University', 'harness web-enabled content');
insert into BodaEntity (pareja_correoelec,lugar, fecha, tema, religion, tipoBoda) values ('bsimcoe1@dion.ne.jp','Shasta', '2017-04-08', 'English', 'Dokkyo University School of Medicine', 'deliver back-end infrastructures');
*/
---Fin Pruebas Pareja Entity

--Pruebas para Calificacion Entity
delete from calificacionentity;
insert into calificacionentity (comentario, calificacionNum) values ('kQBADEH JERKKW ZDSI', 4);
insert into calificacionentity (comentario, calificacionNum) values ('oFABDOL YEZPUU ETSN', 5);
insert into calificacionentity (comentario, calificacionNum) values ('gQUMMPI DNPMSV DIWL', 5);
insert into calificacionentity (comentario, calificacionNum) values ('mGKZXTE POZSBU ODLB', 2);
---Fin Calificacion Pareja Entity

--Pruebas para Invitado Entity
delete from InvitadoEntity;
insert into InvitadoEntity (id, name, documento, correo, asistencia, categoria) values (1, 'Miguel', 90570, 'mloughnan0@noaa.gov', 1, 'trabajo');
insert into InvitadoEntity (id, name, documento, correo, asistencia, categoria) values (2, 'Maddi', 82444, 'mpettengell1@yahoo.com', 0, 'trabajo');
insert into InvitadoEntity (id, name, documento, correo, asistencia, categoria) values (3, 'Griffy', 97900, 'gdeaguirre2@sina.com.cn', 0, 'familia');

--Pruebas para Regalo Entity
delete from RegaloEntity;
insert into RegaloEntity (id, name, comprado, imagen) values (1, 'Cama', 1, 'https://robohash.org/addeseruntvero.jpg?size=50x50&set=set1');
insert into RegaloEntity (id, name, comprado, imagen) values (2, 'Tendidos', 0, 'https://robohash.org/estutomnis.jpg?size=50x50&set=set1');
insert into RegaloEntity (id, name, comprado, imagen) values (3, 'Lavadora', 0, 'https://robohash.org/eadoloremquearchitecto.bmp?size=50x50&set=set1');
