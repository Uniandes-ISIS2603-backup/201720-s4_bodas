/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.resources;

import co.edu.uniandes.csw.boda.dtos.InvitadoDetailDTO;
import co.edu.uniandes.csw.boda.ejb.InvitadoLogic;
import co.edu.uniandes.csw.boda.entities.InvitadoEntity;
import co.edu.uniandes.csw.boda.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
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
 * @author mf.valllejo
 */
@Path("invitados")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class InvitadoResource {
    
    @Inject
    InvitadoLogic invitadoLogic;
    
    @POST
    public InvitadoDetailDTO createInvitado(InvitadoDetailDTO invitado) throws BusinessLogicException {
        InvitadoEntity invitadoEntity = invitado.toEntity();
        InvitadoEntity nuevoInvitado = invitadoLogic.createInvitado(invitadoEntity);
        return new InvitadoDetailDTO(nuevoInvitado);
    }
    
    @GET
    public List<InvitadoDetailDTO> getInvitados() throws BusinessLogicException {
        return listEntity2DetailDTO(invitadoLogic.getInvitados());
    }
    
    @PUT
    @Path("{id: \\d+}")
    public InvitadoDetailDTO updateInvitado(@PathParam("id") Long id, InvitadoDetailDTO invitado) throws BusinessLogicException {
        invitado.setId(id);
        InvitadoEntity entity = invitadoLogic.get(id);
        if(entity != null){
            throw new WebApplicationException("El recurso /invitados/" + id + " no existe.", 404);
        }
        return new InvitadoDetailDTO(invitadoLogic.update(invitado.toEntity()));
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteInvitado(@PathParam("id") Long id) throws BusinessLogicException {
        InvitadoEntity entity = invitadoLogic.get(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /invitados/" + id + " no existe.", 404);
        }
        invitadoLogic.delete(id);
    }
    
    private List<InvitadoDetailDTO> listEntity2DetailDTO(List<InvitadoEntity> entityList) {
        List<InvitadoDetailDTO> list = new ArrayList<>();
        for (InvitadoEntity entity : entityList) {
            list.add(new InvitadoDetailDTO(entity));
        }
        return list;
    }
}