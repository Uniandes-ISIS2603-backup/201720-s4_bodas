/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.resources;

import co.edu.uniandes.csw.boda.dtos.TarjetaCreditoDetailDTO;
import co.edu.uniandes.csw.boda.ejb.TarjetaCreditoLogic;
import co.edu.uniandes.csw.boda.entities.TarjetaCreditoEntity;
import co.edu.uniandes.csw.boda.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.boda.persistence.TarjetaCreditoPersistence;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author ca.guerrero
 */
@Path("tarjetasCredito")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class TarjetaCreditoResource {
    @Inject
    TarjetaCreditoLogic editorialLogic;
    
    private static final Logger LOGGER = Logger.getLogger(TarjetaCreditoPersistence.class.getName());
    
    /**
     * POST http://localhost:8080/boda-web/api/parejas/tarjetasCredito Ejemplo
     * json: {"numero": 0000 0000 0000 0000, "numDeSeg": 000, "fechaVen":"05-Dic-2017", "nombreBanco": "BancaMia}
     *
     * @param tarjeta correponde a la representación java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     * la base de datos y el tipo del objeto java. Ejemplo: { "type":
     * "tarjetaDetailDTO", "id": 1, "numero": "0000 0000 0000 0000", "nombreBanco": "BancaMia" }
     * @throws BusinessLogicException
     */
    @POST
    public TarjetaCreditoDetailDTO createTarjetaCredito(TarjetaCreditoDetailDTO tarjeta) throws BusinessLogicException {
        TarjetaCreditoEntity tarjetaEntity = tarjeta.toEntity();
        TarjetaCreditoEntity nuevoTarjeta = editorialLogic.createTarjetaCredito(tarjetaEntity);
        return new TarjetaCreditoDetailDTO(nuevoTarjeta);
    }
    /**
     * PUT http://localhost:8080/boda-web/api/parejas/tarjetasCredito/1 Ejemplo
     * json { "id": 1, "name": "cambio de nombre" }
     *
     * @param id corresponde a la editorial a actualizar.
     * @param tarjeta corresponde a al objeto con los cambios que se van a
     * realizar.
     * @return La tarjeta actualizada.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la tarjeta a actualizar se retorna un
     * 404 con el mensaje.
     */
    @PUT
    @Path("{id: \\d+}")
    public TarjetaCreditoDetailDTO updateTarjetaCredito(@PathParam("id") Long id, TarjetaCreditoDetailDTO tarjeta) throws BusinessLogicException {
        tarjeta.setId(id);
        TarjetaCreditoEntity entity = editorialLogic.getTarjetaCredito(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /tarjetasCredito/" + id + " no existe.", 404);
        }
        return new TarjetaCreditoDetailDTO(editorialLogic.updateTarjetaCredito(id, tarjeta.toEntity()));
    }
}
