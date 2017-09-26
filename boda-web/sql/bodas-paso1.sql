--Pruebas para Pareja Entity
delete from RegaloEntity_UbicacionEntity;
delete from ParejaEntity;
delete from RegaloEntity;
delete from InvitadoEntity;
delete from calificacionentity;
delete from OpcionServicioEntity;

delete from TareaEntity;
insert into ParejaEntity (correoElec, nombreInd1, nombreInd2, telefono, pago, contrasenia, nombreAbreviado, direccion) values ('fmarsland0@artisteer.com', 'Aaren', 'Ferrell', 86, 1, 'cGUDt68M', 'Agavaceae', '46 Gulseth Place');
insert into ParejaEntity (correoElec, nombreInd1, nombreInd2, telefono, pago, contrasenia, nombreAbreviado, direccion) values ('bsimcoe1@dion.ne.jp', 'Elbertina', 'Baxy', 79, 0, '66tNlmFd', 'Asteraceae', '936 Mendota Plaza');
---Fin Pruebas Pareja Entity

--Pruebas BodaEntity
delete from BodaEntity;
insert into BodaEntity (id, name, fecha, tema, religion, tipoBoda) values (1, 'Kris', '3/29/2017', 'tema2', 'judia', 'deRubí');
insert into BodaEntity (id, name, fecha, tema, religion, tipoBoda) values (2,'Galen', '5/2/2017', 'tema2', 'ninguna', 'dePlata');
insert into BodaEntity (id, name, fecha, tema, religion, tipoBoda) values (3,'Malanie', '10/9/2016', 'tema3', 'católica', 'deRubí');
---Fin Pruebas BodaEntity

--Pruebas UbicacionEntity
delete from UbicacionEntity;
insert into UbicacionEntity (id, name, latitud, longitud, telefono, direccion) values (1, 'Automotive', 50.1681931, 14.0545902, 24356, '88734 Marcy Avenue');
insert into UbicacionEntity (id, name, latitud, longitud, telefono, direccion) values (2, 'Clothing', -17.8119748, -50.5981252, 38447, '4701 Dorton Place');
insert into UbicacionEntity (id, name, latitud, longitud, telefono, direccion) values (3, 'Home', 55.816131, 37.8768991, 85959, '976 Myrtle Center');
insert into UbicacionEntity (id, name, latitud, longitud, telefono, direccion) values (4, 'HomeLand', 55.816167, 37.8768998, 859591, '976 Myrtle Center');

---Fin Pruebas UbicacionEntity

--Pruebas para Regalo Entity

insert into RegaloEntity (id,name, comprado, imagen, boda_id) values (100, 'Cama', 1, 'https://robohash.org/addeseruntvero.jpg?size=50x50&set=set1',1);
insert into RegaloEntity (id,name, comprado, imagen, boda_id) values (200, 'Tendidos', 0, 'https://robohash.org/estutomnis.jpg?size=50x50&set=set1',1);
insert into RegaloEntity (id,name, comprado, imagen, boda_id) values (300, 'Lavadora', 0, 'https://robohash.org/eadoloremquearchitecto.bmp?size=50x50&set=set1',2);

insert into RegaloEntity_UbicacionEntity (regaloentity_id,locations_id ) values (100,1);
insert into RegaloEntity_UbicacionEntity (regaloentity_id,locations_id ) values (100,2);
insert into RegaloEntity_UbicacionEntity (regaloentity_id,locations_id ) values (200,2);
insert into RegaloEntity_UbicacionEntity (regaloentity_id,locations_id ) values (200,3);



--Pruebas para Invitado Entity

insert into InvitadoEntity (id,name, documento, correo, asistencia, categoria, boda_id) values (1,'Miguel', 90570, 'mloughnan0@noaa.gov', 1, 'trabajo',1);
insert into InvitadoEntity (id,name, documento, correo, asistencia, categoria, boda_id) values (2,'Maddi', 82444, 'mpettengell1@yahoo.com', 0, 'trabajo',1);
insert into InvitadoEntity (id,name, documento, correo, asistencia, categoria, boda_id) values (3,'Griffy', 97900, 'gdeaguirre2@sina.com.cn', 0, 'familia',2);


--Pruebas para Tarea Entity
insert into TareaEntity(id,aprobada, dia,nombre) values (12,0,'3/29/2017', 'Nombre');
insert into TareaEntity(id,aprobada, dia,nombre) values (13,1,'3/29/2017', 'Nombre1');
insert into TareaEntity(id,aprobada, dia,nombre) values (14,0,'3/29/2017', 'Nombre2');
---Fin Calificacion Tarea Entity

--Pruebas para OpcionServicio Entity

insert into OpcionServicioEntity(id,descripcion, costo,diasDisponibles) values (12,'descripcion1',12 ,'Lunes');
insert into OpcionServicioEntity(id,descripcion, costo,diasDisponibles) values (13,'descripcion2',14 ,'Martes');
insert into OpcionServicioEntity(id,descripcion, costo,diasDisponibles) values (14,'descripcion3',13 ,'Miercoles');
---Fin Calificacion OpcionServicio Entity


--Pruebas para Calificacion Entity
insert into calificacionentity (opcionservicio_id,comentario, calificacionNum,id) values (12,'kQBADEH JERKKW ZDSI', 4,1);
insert into calificacionentity (opcionservicio_id,comentario, calificacionNum,id) values (12,'oFABDOL YEZPUU ETSN', 5,2);
insert into calificacionentity (opcionservicio_id,comentario, calificacionNum,id) values (12,'gQUMMPI DNPMSV DIWL', 5,3);
insert into calificacionentity (opcionservicio_id,comentario, calificacionNum,id) values (13,'mGKZXTE POZSBU ODLB', 2,4);
---Fin Calificacion Pareja Entity

--Pruebas ProveedorEntity
delete from ProveedorEntity;
insert into  ProveedorEntity (name, especialidad) values ('Babbleblab', 'Ingamar');
insert into  ProveedorEntity (name, especialidad) values ('Demizz', 'Hillary');
insert into  ProveedorEntity (name, especialidad) values ('Topiczoom', 'Langston');
insert into  ProveedorEntity (name, especialidad) values ('Yodel', 'Townsend');
---Fin Pruebas ProveedorEntity

--Pruebas ServicioEntity
delete from ServicioEntity;
insert into ServicioEntity (name, descripcion) values ('SALICYLIC ACID', 'Merrick');
insert into ServicioEntity (name, descripcion) values ('Morphine Sulfate', 'Mandrake');
insert into ServicioEntity (name, descripcion) values ('Glycerin', 'Almo');
insert into ServicioEntity (name, descripcion) values ('RISEDRONATE SODIUM', 'Kingsford');
---Fin Pruebas ServicioEntity