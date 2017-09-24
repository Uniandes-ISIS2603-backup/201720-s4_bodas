/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.resources;

import co.edu.uniandes.csw.boda.dtos.OpcionServicioDetailDTO;
import co.edu.uniandes.csw.boda.ejb.OpcionServicioLogic;
import co.edu.uniandes.csw.boda.entities.OpcionServicioEntity;
import co.edu.uniandes.csw.boda.exceptions.BusinessLogicException;
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
 * @author sp.joven
 */

@Path("opcionServicios")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class OpcionServicioResource {
    


    
    @Inject
    private OpcionServicioLogic opcionServicioLogic;
    
    private static final Logger LOGGER = Logger.getLogger(OpcionServicioResource.class.getName());
     
    /**
     * POST http://localhost:8080/bodas-web/api/opcionServicios Ejemplo
     * json: { "name":"Norma" }
     *
     * @param opcionServicio correponde a la representación java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     la base de datos y el tipo del objeto java. Ejemplo: { "type":
     "TareaDetailDTO", "id": 1, "name": "Norma" }
     * @throws BusinessLogicException
     */
    @POST
    public OpcionServicioDetailDTO createOpcionServicio(OpcionServicioDetailDTO opcionServicio) throws BusinessLogicException {
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        OpcionServicioEntity opcionServicioEntity =opcionServicio.toEntity();
        // Invoca la lógica para crear la boda nueva
        OpcionServicioEntity nuevaOpcion = opcionServicioLogic.create(opcionServicioEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        return new  OpcionServicioDetailDTO(nuevaOpcion);
    }

    /**
     * GET para todas las opcionesServicio.
     * http://localhost:8080/boda-web/api/opcionesServicio
     * 
     * @return la lista de todas las opciones de servicio en objetos json DTO.
     * @throws BusinessLogicException
     */
  @GET
    public List<OpcionServicioDetailDTO> getOpcionesServicio() throws BusinessLogicException {
        return listEntity2DetailDTO(opcionServicioLogic.getOpcionesServicio());
    }

    /**
     * GET para una opcion servicio
     * http://localhost:8080/boda-web/api/opcionServicios/1
     *
     * @param id corresponde al id de la tarea buscada.
     * @return La opcion servicio encontrada.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la opcion servicio buscada se retorna un 404 con
     * el mensaje.
     */
    @GET
    @Path("{id: \\d+}")
    public OpcionServicioDetailDTO getOpcionServicio(@PathParam("id") Long id) throws BusinessLogicException {
       OpcionServicioDetailDTO cd= new OpcionServicioDetailDTO(opcionServicioLogic.findOpcionServicioById(id));
        if(cd==null)
       {
           throw new  WebApplicationException("No existe una opcon servicio con el id dado",404);
       }
        return  cd;
    }

    /**
     * PUT 
     * http://localhost:8080/boda-web/api/opcionServicios/1 Ejemplo
     * json { "id": 1, "name": "cambio de nombre" }
     *
     * @param id corresponde a la tarea a actualizar.
     * @param opcion corresponde a al objeto con los cambios que se van a
     * realizar.
     * @return La opcion actualizado.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la opcion a actualizar se retorna un
     * 404 con el mensaje.
     */
    @PUT
    @Path("{id: \\d+}")
    public OpcionServicioDetailDTO updateOpcionServicio(@PathParam("id") Long id, OpcionServicioDetailDTO opcion) throws BusinessLogicException {
       //throw  new UnsupportedOperationException("Este servicio no ha sido implementado");
       OpcionServicioDetailDTO cd= new OpcionServicioDetailDTO(opcionServicioLogic.updateOpcionServicio(id, opcion.toEntity()));
       if(cd==null)
       {
           throw new  WebApplicationException("No existe una opcion con el id dado",404);
       }
       
       return cd;
    }

    /**
     * DELETE http://localhost:8080/boda-web/api/opcionServicios/1
     *
     * @param id corresponde a la tareas a borrar.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la opcion a actualizar se retorna un
     * 404 con el mensaje.
     *
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteOpcionServicio(@PathParam("id") Long id) throws BusinessLogicException {
        
       if(opcionServicioLogic.findOpcionServicioById(id)==null)
       {
           throw new  WebApplicationException("No existe una opcion con el id dado",404);
       }
       opcionServicioLogic.removeOpcionServicio(id);
    }

    /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos BodaEntity a una lista de
      objetos BodaDetailDTO (json)
     *
     * @param entityList corresponde a la lista de tarea de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de bodas en forma DTO (json)
     */
    private List<OpcionServicioDetailDTO> listEntity2DetailDTO(List<OpcionServicioEntity> entityList) {
        List<OpcionServicioDetailDTO> list = new ArrayList<>();
        for (OpcionServicioEntity entity : entityList) {
            list.add(new OpcionServicioDetailDTO(entity));
        }
        return list;
    }


    
}