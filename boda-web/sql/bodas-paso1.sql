--Pruebas para Pareja Entity
delete from ServicioEntity_ProveedorEntity;
delete from RegaloEntity_UbicacionEntity;
delete from PagoEntity;
delete from TarjetaCreditoEntity;
delete from TareaEntity;
delete from calificacionentity;
delete from OpcionServicioEntity;
delete from RegaloEntity;
delete from InvitadoEntity;
delete from ProveedorEntity;
delete from ServicioEntity;
delete from UbicacionEntity;
delete from ParejaEntity;
delete from BodaEntity;


Alter table calificacionentity alter column id Restart with 1;

insert into ParejaEntity (correoElec, nombreInd1, nombreInd2, telefono, pago, contrasenia, nombreAbreviado, direccion) values ('fmarsland0@artisteer.com', 'Aaren', 'Ferrell', 86, 1, 'cGUDt68M', 'Agavaceae', '46 Gulseth Place');
insert into ParejaEntity (correoElec, nombreInd1, nombreInd2, telefono, pago, contrasenia, nombreAbreviado, direccion) values ('bsimcoe1@dion.ne.jp', 'Elbertina', 'Baxy', 21493925, 0, '66tNlmFd', 'Asteraceae', '936 Mendota Plaza');
insert into ParejaEntity (correoElec, nombreInd1, nombreInd2, telefono, pago, contrasenia, nombreAbreviado, direccion) values ('cgammack0@foxnews.com', 'Doralia', 'Chauncey', 57015334, 0, 'joMOxXNK', 'bgreenham0', '5892 1st Way');
insert into ParejaEntity (correoElec, nombreInd1, nombreInd2, telefono, pago, contrasenia, nombreAbreviado, direccion) values ('erought1@naver.com', 'Tammie', 'Erv', 85826502, 1, 'V39uUlSMcnS', 'rplowell1', '939 Manufacturers Place');
insert into ParejaEntity (correoElec, nombreInd1, nombreInd2, telefono, pago, contrasenia, nombreAbreviado, direccion) values ('adevita2@digg.com', 'Hermione', 'Asher', 64657474, 1, 'zOtOavmlWdc', 'ajoris3', '97 Fisk Place');


---Fin Pruebas Pareja Entity

--Pruebas BodaEntity
insert into BodaEntity (id, name, fecha, tema, religion, tipoBoda,image) values (1, 'Mafelipe', '3/29/2019', 'Playa', 'Judia', 'Boda de Bronce','https://images.pexels.com/photos/254069/pexels-photo-254069.jpeg');
insert into BodaEntity (id, name, fecha, tema, religion, tipoBoda,image) values (2,'Galen&Rose', '5/2/2018', 'Invierno', 'Ninguna', 'Ninguno','https://images.pexels.com/photos/246490/pexels-photo-246490.jpeg');
insert into BodaEntity (id, name, fecha, tema, religion, tipoBoda,image) values (3,'Roberto&Martha', '10/9/2018', 'Primavera', 'Católica', 'Boda de Oro','https://images.pexels.com/photos/34761/old-people-couple-together-connected.jpg');
---Fin Pruebas BodaEntity

update ParejaEntity Set boda_id =1 where correoElec = 'fmarsland0@artisteer.com';


--Pruebas UbicacionEntity

insert into UbicacionEntity (id, name, latitud, longitud, telefono, direccion) values (1, 'Automotive', 50.1681931, 14.0545902, 24356, '88734 Marcy Avenue');
insert into UbicacionEntity (id, name, latitud, longitud, telefono, direccion) values (2, 'Clothing', -17.8119748, -50.5981252, 38447, '4701 Dorton Place');
insert into UbicacionEntity (id, name, latitud, longitud, telefono, direccion) values (3, 'Home', 55.816131, 37.8768991, 85959, '976 Myrtle Center');
insert into UbicacionEntity (id, name, latitud, longitud, telefono, direccion) values (4, 'HomeLand', 55.816167, 37.8768998, 859591, '976 Myrtle Center');
insert into UbicacionEntity (id, name, latitud, longitud, telefono, direccion) values (5, 'HomeLands', 55.81617, 37.878998, 85591, '976f Myrtle Center');

---Fin Pruebas UbicacionEntity

--Pruebas para Regalo Entity

insert into RegaloEntity (id,name, comprado, imagen, boda_id) values (100, 'Cama', 1, 'https://static.pexels.com/photos/164595/pexels-photo-164595.jpeg',1);
insert into RegaloEntity (id,name, comprado, imagen, boda_id) values (200, 'Platos', 0, 'https://static.pexels.com/photos/6305/holidays-dinner-eating-lunch.jpg',1);
insert into RegaloEntity (id,name, comprado, imagen, boda_id) values (300, 'Lavadora', 0, 'https://static.pexels.com/photos/4414/black-and-white-clean-housework-launderette.jpg',2);

insert into RegaloEntity_UbicacionEntity (regaloentity_id,locations_id ) values (100,1);
insert into RegaloEntity_UbicacionEntity (regaloentity_id,locations_id ) values (100,2);
insert into RegaloEntity_UbicacionEntity (regaloentity_id,locations_id ) values (200,2);
insert into RegaloEntity_UbicacionEntity (regaloentity_id,locations_id ) values (200,3);



--Pruebas para Invitado Entity

insert into InvitadoEntity (id,name, documento, correo, asistencia, categoria, boda_id) values (1,'Miguel', 90570, 'mloughnan0@noaa.gov', 1, 'trabajo',1);
insert into InvitadoEntity (id,name, documento, correo, asistencia, categoria, boda_id) values (2,'Maddi', 82444, 'mpettengell1@yahoo.com', 0, 'trabajo',1);
insert into InvitadoEntity (id,name, documento, correo, asistencia, categoria, boda_id) values (3,'Griffy', 97900, 'gdeaguirre2@sina.com.cn', 0, 'familia',2);
insert into InvitadoEntity (id, name, documento, correo, asistencia, categoria, boda_id) values (6, 'Adah O''Lochan', 389257353, 'aolochan5@bbb.org', 0, 'trabajo', 2);
insert into InvitadoEntity (id, name, documento, correo, asistencia, categoria, boda_id) values (7, 'Courtnay Sommersett', 235286536, 'csommersett6@cbslocal.com', 0, 'familia', 2);
insert into InvitadoEntity (id, name, documento, correo, asistencia, categoria, boda_id) values (8, 'Melina Gibbetts', 52660220, 'mgibbetts7@constantcontact.com', 0, 'familia', 5);
insert into InvitadoEntity (id, name, documento, correo, asistencia, categoria, boda_id) values (10, 'Kizzie Tolan', 859644071, 'ktolan9@amazon.de', 0, 'familia', 3);
insert into InvitadoEntity (id, name, documento, correo, asistencia, categoria, boda_id) values (11, 'Giana Lathy', 602042642, 'glathya@wikia.com', 1, 'familia', 4);
insert into InvitadoEntity (id, name, documento, correo, asistencia, categoria, boda_id) values (12, 'Doria Revey', 821785894, 'dreveyb@php.net', 1, 'familia', 1);


--Pruebas ProveedorEntity

insert into  ProveedorEntity (id, name, especialidad,imagen) values (100,'Andres Carne de Res', 'Comida Latina','https://images.pexels.com/photos/597422/pexels-photo-597422.jpeg');
insert into  ProveedorEntity (id, name, especialidad,imagen) values (200,'Rosas y Claveles', 'Arreglos de flores','https://images.pexels.com/photos/15239/flower-roses-red-roses-bloom.jpg');
insert into  ProveedorEntity (id, name, especialidad,imagen) values (300,'WOK', 'Comida Asiática','https://images.pexels.com/photos/357756/pexels-photo-357756.jpeg');
insert into  ProveedorEntity (id, name, especialidad,imagen) values (400,'DJ InTheHouse', 'Música para cualquier tipo de evento','https://images.pexels.com/photos/374703/pexels-photo-374703.jpeg');
insert into  ProveedorEntity (id, name, especialidad,imagen) values (500,'MasLindo', 'Música para cualquier tipo de evento','https://images.pexels.com/photos/332688/pexels-photo-332688.jpeg');
insert into  ProveedorEntity (id, name, especialidad,imagen) values (600,'Casa de Eventos', 'Atender y Decorar Eventos','https://images.pexels.com/photos/206673/pexels-photo-206673.jpeg');
insert into  ProveedorEntity (id, name, especialidad,imagen) values (700,'Primi', 'Comida Italiana','https://images.pexels.com/photos/2232/vegetables-italian-pizza-restaurant.jpg');
insert into  ProveedorEntity (id, name, especialidad,imagen) values (800,'Harry Sasson', 'Comida de mar y mediterráneo','https://images.pexels.com/photos/629093/pexels-photo-629093.jpeg');
insert into  ProveedorEntity (id, name, especialidad,imagen) values (900,'MacroEventos', 'Atender eventos y Musica','https://images.pexels.com/photos/5156/people-eiffel-tower-lights-night.jpg');
insert into  ProveedorEntity (id, name, especialidad,imagen) values (1000,'Iglesia Minuto de Dios', 'Boda Católica','https://images.pexels.com/photos/161081/eucharist-body-of-christ-church-mass-161081.jpeg');
insert into  ProveedorEntity (id, name, especialidad,imagen) values (1100,'Nicolukas', 'Pastelería','https://images.pexels.com/photos/416534/pexels-photo-416534.jpeg');
insert into  ProveedorEntity (id, name, especialidad,imagen) values (1200,'Alexis Vargas', 'Alquiler y compra de vestidos','https://images.pexels.com/photos/313702/pexels-photo-313702.jpeg');

--Pruebas ServicioEntity
insert into ServicioEntity (id, name, descripcion, image) values (1, 'Vestidos', 'Te ofrecemos una gran variedad de opciones y proveedores para que encuentres tu vestido ideal', 'https://images.pexels.com/photos/265722/pexels-photo-265722.jpeg');
insert into ServicioEntity (id, name, descripcion, image) values (2, 'Flores', 'Encuentra las flores ideales para tu matrimonio, que tu día especial sea el más vivo y colorido','https://images.pexels.com/photos/306066/pexels-photo-306066.jpeg');
insert into ServicioEntity (id, name, descripcion, image) values (5, 'Catering', 'Comida para la boda: Entrada, Platos Fuertes y Picadas', 'http://media.bodaclick.com/img/img_reportajes/19942_1359111008_51026360c7dda.jpg');
insert into ServicioEntity (id, name, descripcion, image) values (6, 'Decoración', 'Decoración para la boda', 'http://media.bodaclick.com/img/img_reportajes/19942_1359111008_51026360c7dda.jpg');
insert into ServicioEntity (id, name, descripcion, image) values (7, 'Música', 'DJ o Música en vivo para la boda', 'http://media.bodaclick.com/img/img_reportajes/19942_1359111008_51026360c7dda.jpg');
insert into ServicioEntity (id, name, descripcion, image) values (8, 'Entretenimiento', 'Bailes y Presentaciones', 'http://media.bodaclick.com/img/img_reportajes/19942_1359111008_51026360c7dda.jpg');
insert into ServicioEntity (id, name, descripcion, image) values (9, 'Estética', 'Maquillaje, Peinado y Manicure', 'http://media.bodaclick.com/img/img_reportajes/19942_1359111008_51026360c7dda.jpg');
insert into ServicioEntity (id, name, descripcion, image) values (10, 'Fotografía y Filmación', 'Fotografía y Filmación para el evento', 'http://media.bodaclick.com/img/img_reportajes/19942_1359111008_51026360c7dda.jpg');
insert into ServicioEntity (id, name, descripcion, image) values (11, 'Transporte', 'Transporte de los invistados para el evento', 'http://media.bodaclick.com/img/img_reportajes/19942_1359111008_51026360c7dda.jpg');
insert into ServicioEntity (id, name, descripcion, image) values (12, 'Pastelería', 'Pastel y postre para el evento', 'http://media.bodaclick.com/img/img_reportajes/19942_1359111008_51026360c7dda.jpg');
insert into ServicioEntity (id, name, descripcion, image) values (13, 'Bebidas', 'Bebidas y Licores para el evento', 'http://media.bodaclick.com/img/img_reportajes/19942_1359111008_51026360c7dda.jpg');
---Fin Pruebas ServicioEntity


insert into ServicioEntity_ProveedorEntity (servicioentity_id, proveedores_id ) values (1,100);
insert into ServicioEntity_ProveedorEntity (servicioentity_id, proveedores_id ) values (1,200);
insert into ServicioEntity_ProveedorEntity (servicioentity_id, proveedores_id ) values (1,300);
insert into ServicioEntity_ProveedorEntity (servicioentity_id, proveedores_id ) values (2,100);
insert into ServicioEntity_ProveedorEntity (servicioentity_id, proveedores_id ) values (2,200);
insert into ServicioEntity_ProveedorEntity (servicioentity_id, proveedores_id ) values (2,400);
insert into ServicioEntity_ProveedorEntity (servicioentity_id, proveedores_id ) values (11,100);
insert into ServicioEntity_ProveedorEntity (servicioentity_id, proveedores_id ) values (11,400);
insert into ServicioEntity_ProveedorEntity (servicioentity_id, proveedores_id ) values (12,100);
insert into ServicioEntity_ProveedorEntity (servicioentity_id, proveedores_id ) values (12,300);
insert into ServicioEntity_ProveedorEntity (servicioentity_id, proveedores_id ) values (5,100);
insert into ServicioEntity_ProveedorEntity (servicioentity_id, proveedores_id ) values (5,200);
insert into ServicioEntity_ProveedorEntity (servicioentity_id, proveedores_id ) values (6,300);
insert into ServicioEntity_ProveedorEntity (servicioentity_id, proveedores_id ) values (6,100);
insert into ServicioEntity_ProveedorEntity (servicioentity_id, proveedores_id ) values (7,400);
insert into ServicioEntity_ProveedorEntity (servicioentity_id, proveedores_id ) values (7,300);
insert into ServicioEntity_ProveedorEntity (servicioentity_id, proveedores_id ) values (8,100);
insert into ServicioEntity_ProveedorEntity (servicioentity_id, proveedores_id ) values (8,200);
insert into ServicioEntity_ProveedorEntity (servicioentity_id, proveedores_id ) values (9,200);
insert into ServicioEntity_ProveedorEntity (servicioentity_id, proveedores_id ) values (9,300);
insert into ServicioEntity_ProveedorEntity (servicioentity_id, proveedores_id ) values (10,300);
insert into ServicioEntity_ProveedorEntity (servicioentity_id, proveedores_id ) values (10,400);
insert into ServicioEntity_ProveedorEntity (servicioentity_id, proveedores_id ) values (11,300);


---Fin Pruebas ProveedorEntity

--Pruebas para OpcionServicio Entity
insert into OpcionServicioEntity(id,descripcion, costo,diasDisponibles,proveedor_id,image,boda_id) values (12,'descripcion1',12 ,'Lunes',100 ,'http://lorempixel.com/242/200/',1);
insert into OpcionServicioEntity(id,descripcion, costo,diasDisponibles,proveedor_id,image,boda_id) values (13,'descripcion2',14 ,'Martes',100,'http://lorempixel.com/242/200/',1);
insert into OpcionServicioEntity(id,descripcion, costo,diasDisponibles,proveedor_id,image,boda_id) values (14,'descripcion3',13 ,'Miercoles', 200,'http://lorempixel.com/242/200/',2);
---Fin Calificacion OpcionServicio Entity

--Pruebas para Calificacion Entity
insert into calificacionentity (opcionservicio_id,comentario, calificacionNum) values (12,'kQBADEH JERKKW ZDSI', 4);
insert into calificacionentity (opcionservicio_id,comentario, calificacionNum) values (12,'oFABDOL YEZPUU ETSN', 5);
insert into calificacionentity (opcionservicio_id,comentario, calificacionNum) values (12,'gQUMMPI DNPMSV DIWL', 5);
insert into calificacionentity (opcionservicio_id,comentario, calificacionNum) values (13,'mGKZXTE POZSBU ODLB', 2);
---Fin Calificacion Pareja Entity

--Pruebas para Tarea Entity
insert into TareaEntity(opcionservicio_id,id,aprobada, dia,nombre, ubicacion_id,image) values (12,12,0,'2/11/2017', 'Prueba de vestido',1,'http://media.bodaclick.com/img/img_reportajes/19942_1359111008_51026360c7dda.jpg');
insert into TareaEntity(opcionservicio_id,id,aprobada, dia,nombre, ubicacion_id,image) values (13,13,1,'1/2/2017', 'Floristería',1,'https://www.kukyflor.com/blog/wp-content/uploads/2014/11/flores-boda-casamiento-matrimonio-altar-novia.jpg');
insert into TareaEntity(opcionservicio_id,id,aprobada, dia,nombre, ubicacion_id,image) values (12,14,0,'3/13/2017', 'Fotografía',2,'http://img3.woman.es/8a/b4/b8/10-preguntas-novia-debe-fotografo-boda-640x422.jpg');
---Fin Calificacion Tarea Entity




---Pruebas TarjetaCreditoEntity
delete from TarjetaCreditoEntity;
insert into TarjetaCreditoEntity (numero, name, numDeSeg, fechaVen, pareja_correoElec) values (4445556667778889, 'Banca Mia', 777, '3/8/2022','fmarsland0@artisteer.com');
insert into TarjetaCreditoEntity (numero, name, numDeSeg, fechaVen, pareja_correoElec) values (7894561230789456, 'Banca Tuya', 456, '6/29/2017', 'fmarsland0@artisteer.com');
insert into TarjetaCreditoEntity (numero, name, numDeSeg, fechaVen, pareja_correoElec) values (7777771111115556, 'Banca Nuestra', 123, '1/12/2019', 'bsimcoe1@dion.ne.jp');
---Fin Pruebas TarjetaCreditoEntity

---Pruebas PagoEntity
insert into PagoEntity (id, name, montoTotal, fecha, tarjetaCredito_numero) values (1, 'Pago por mesas', 150000, '4/4/2017',4445556667778889);
insert into PagoEntity (id, name, montoTotal, fecha, tarjetaCredito_numero) values (2, 'Pago por transporte', 200000, '6/29/2017', 4445556667778889);
insert into PagoEntity (id, name, montoTotal, fecha, tarjetaCredito_numero) values (3, 'Pago por banquete', 30000, '3/14/2017', 7894561230789456);
insert into PagoEntity (id, name, montoTotal, fecha, tarjetaCredito_numero) values (4, 'Pago por sillas', 70000, '1/12/2017', 7777771111115556);
---Fin Pruebas PagoEntity