
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.ejb;

import co.edu.uniandes.csw.boda.entities.InvitadoEntity;
import co.edu.uniandes.csw.boda.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.boda.persistence.InvitadoPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author mf.valllejo
 */
@Stateless
public class InvitadoLogic {

    private static final Logger LOGGER = Logger.getLogger(InvitadoLogic.class.getName());

    @Inject
    InvitadoPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    public InvitadoEntity createInvitado(InvitadoEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de un invitado");
        if (persistence.findByDocumento(entity.getDocumento())!=null){
            throw new BusinessLogicException("Ya existe un Invitado con el documento \"" + entity.getDocumento() + "\"");
        }
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de invitado");
        return entity;
    }

    public List<InvitadoEntity> getInvitados() {
        LOGGER.info("Inicia proceso de consultar todas los Invitados");
        List<InvitadoEntity> invitados = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas los Invitados");
        return invitados;
    }

    public InvitadoEntity get(Long id) {
        return persistence.find(id);
    }

    public InvitadoEntity update(InvitadoEntity entity) {
        return persistence.update(entity);
    }

    public void delete(Long id) {
        persistence.delete(id);
    }

}