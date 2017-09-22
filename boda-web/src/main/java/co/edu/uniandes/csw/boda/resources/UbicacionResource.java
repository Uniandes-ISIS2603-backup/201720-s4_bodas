/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.resources;

import co.edu.uniandes.csw.boda.dtos.UbicacionDetailDTO;
import co.edu.uniandes.csw.boda.entities.UbicacionEntity;
import co.edu.uniandes.csw.boda.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.boda.ejb.UbicacionLogic;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author vn.gomez
 */
@Path("ubicaciones")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class UbicacionResource {
   
    @Inject
    private UbicacionLogic ubicacionLogic;
    
    private static final Logger LOGGER = Logger.getLogger(UbicacionResource.class.getName());
     
    /**
     * POST http://localhost:8080/boda-web/api/ubicaciones Ejemplo
     * json: { "name":"Falabella",  "latitud":"205867", "longitud":"105867", "telefono":"3333333", "direccion":"cra # calle 55, Bogotá"}
     *
     * @param ubicacion correponde a la representación java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     la base de datos y el tipo del objeto java. Ejemplo: { "type":
     "UbicacionDetailDTO", "id": 1, "name": "Falabella" }
     * @throws BusinessLogicException
     */
    @POST
    public UbicacionDetailDTO createUbicacion(UbicacionDetailDTO ubicacion) throws BusinessLogicException {
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        UbicacionEntity ubicacionEntity = ubicacion.toEntity();
        // Invoca la lógica para crear la ubicacion nueva
        UbicacionEntity nuevaUbicacion = ubicacionLogic.create(ubicacionEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        return new  UbicacionDetailDTO(nuevaUbicacion);
    }

    /**
     * GET para todas las ubicaciones.
     * http://localhost:8080/boda-web/api/ubicaciones
     *
     * @return la lista de todas las ubicaciones en objetos json DTO.
     * @throws BusinessLogicException
     */
    @GET
    public List<UbicacionDetailDTO> getUbicaciones() throws BusinessLogicException {
        return listEntity2DetailDTO(ubicacionLogic.getUbicaciones());
    }

    /**
     * GET para una Ubicacion
     * http://localhost:8080/boda-web/api/ubicaciones/1
     *
     * @param id corresponde al id de la Ubicacion buscada.
     * @return La Ubicacion encontrada. Ejemplo: { "type": "UbicacionDetailDTO",
     "id": 1, "name": "Falabella" }
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la Ubicacion  buscada se retorna un 404 con
     * el mensaje.
     */
    @GET
    @Path("{id: \\d+}")
    public UbicacionDetailDTO getUbicacion(@PathParam("id") Long id) throws BusinessLogicException {
       UbicacionDetailDTO cd= new UbicacionDetailDTO(ubicacionLogic.findUbicacionById(id));
        if(cd==null)
       {
           throw new  WebApplicationException("Lo sentimos, no existe una ubicacion con el id dado",404);
       }
        return  cd;
    }

    /**
     * PUT 
     * http://localhost:8080/boda-web/api/ubicaciones/1 Ejemplo
     * json { "id": 1, "name": "cambio de nombre" }
     *
     * @param id corresponde a la ubicacion a actualizar.
     * @param ubicacion corresponde a al objeto con los cambios que se van a
     * realizar.
     * @return La ubicacion actualizada.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la ubicacion a actualizar se retorna un
     * 404 con el mensaje.
     */
    @PUT
    @Path("{id: \\d+}")
    public UbicacionDetailDTO updateUbicacion(@PathParam("id") Long id, UbicacionDetailDTO ubicacion) throws BusinessLogicException {
       //throw  new UnsupportedOperationException("Este servicio no ha sido implementado");
       UbicacionDetailDTO cd= new UbicacionDetailDTO(ubicacionLogic.updateUbicacion(id, ubicacion.toEntity()));
       if(cd==null)
       {
           throw new  WebApplicationException("No existe una ubicacion con el id dado",404);
       }
     return cd;
    }

/**
     * DELETE http://localhost:8080/boda-web/api/ubicaciones/1
     *
     * @param id corresponde a la ubicacion a borrar.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la ubicacion a actualizar se retorna un
     * 404 con el mensaje.
     *
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteUbicacion(@PathParam("id") Long id) throws BusinessLogicException {
        
       if(ubicacionLogic.findUbicacionById(id)==null)
       {
           throw new  WebApplicationException("No existe un ubicacion con el id dado",404);
       }
       ubicacionLogic.removeUbicacion(id);
    }

    /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos UbicacionEntity a una lista de
      objetos UbicacionDetailDTO (json)
     *
     * @param entityList corresponde a la lista de ubicaciones de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de ubicaciones en forma DTO (json)
     */
    private List<UbicacionDetailDTO> listEntity2DetailDTO(List<UbicacionEntity> entityList) {
        List<UbicacionDetailDTO> list = new ArrayList<>();
        for (UbicacionEntity entity : entityList) {
            list.add(new UbicacionDetailDTO(entity));
        }
        return list;
    }
    

}


    


