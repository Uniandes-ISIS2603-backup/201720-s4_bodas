--Pruebas para Pareja Entity
delete from ParejaEntity;
insert into ParejaEntity (correoElec, nombreInd1, nombreInd2, telefono, pago, contrasenia, nombreAbreviado, direccion) values ('fmarsland0@artisteer.com', 'Aaren', 'Ferrell', 86, 1, 'cGUDt68M', 'Agavaceae', '46 Gulseth Place');
insert into ParejaEntity (correoElec, nombreInd1, nombreInd2, telefono, pago, contrasenia, nombreAbreviado, direccion) values ('bsimcoe1@dion.ne.jp', 'Elbertina', 'Baxy', 79, 0, '66tNlmFd', 'Asteraceae', '936 Mendota Plaza');
---Fin Pruebas Pareja Entity

--Pruebas BodaEntity
delete from BodaEntity;
insert into BodaEntity (name, fecha, tema, religion, tipoBoda) values ('Kris', '3/29/2017', 'tema2', 'judia', 'deRubí');
insert into BodaEntity (name, fecha, tema, religion, tipoBoda) values ('Galen', '5/2/2017', 'tema2', 'ninguna', 'dePlata');
insert into BodaEntity (name, fecha, tema, religion, tipoBoda) values ('Malanie', '10/9/2016', 'tema3', 'católica', 'deRubí');
---Fin Pruebas BodaEntity

--Pruebas UbicacionEntity
delete from UbicacionEntity;
insert into UbicacionEntity (name, latitud, longitud, telefono, direccion) values ('Automotive', 50.1681931, 14.0545902, 24356, '88734 Marcy Avenue');
insert into UbicacionEntity (name, latitud, longitud, telefono, direccion) values ('Clothing', -17.8119748, -50.5981252, 38447, '4701 Dorton Place');
insert into UbicacionEntity (name, latitud, longitud, telefono, direccion) values ('Home', 55.816131, 37.8768991, 85959, '976 Myrtle Center');
---Fin Pruebas UbicacionEntity


--Pruebas para Calificacion Entity
delete from calificacionentity;
insert into calificacionentity (comentario, calificacionNum) values ('kQBADEH JERKKW ZDSI', 4);
insert into calificacionentity (comentario, calificacionNum) values ('oFABDOL YEZPUU ETSN', 5);
insert into calificacionentity (comentario, calificacionNum) values ('gQUMMPI DNPMSV DIWL', 5);
insert into calificacionentity (comentario, calificacionNum) values ('mGKZXTE POZSBU ODLB', 2);
---Fin Calificacion Pareja Entity

--Pruebas para Invitado Entity
delete from InvitadoEntity;
insert into InvitadoEntity (name, documento, correo, asistencia, categoria) values ('Miguel', 90570, 'mloughnan0@noaa.gov', 1, 'trabajo');
insert into InvitadoEntity (name, documento, correo, asistencia, categoria) values ('Maddi', 82444, 'mpettengell1@yahoo.com', 0, 'trabajo');
insert into InvitadoEntity (name, documento, correo, asistencia, categoria) values ('Griffy', 97900, 'gdeaguirre2@sina.com.cn', 0, 'familia');

--Pruebas para Regalo Entity
delete from RegaloEntity;
insert into RegaloEntity (name, comprado, imagen) values ( 'Cama', 1, 'https://robohash.org/addeseruntvero.jpg?size=50x50&set=set1');
insert into RegaloEntity (name, comprado, imagen) values ( 'Tendidos', 0, 'https://robohash.org/estutomnis.jpg?size=50x50&set=set1');
insert into RegaloEntity (name, comprado, imagen) values ( 'Lavadora', 0, 'https://robohash.org/eadoloremquearchitecto.bmp?size=50x50&set=set1');