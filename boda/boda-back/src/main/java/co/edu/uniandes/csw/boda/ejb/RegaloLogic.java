/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.ejb;

import co.edu.uniandes.csw.boda.entities.RegaloEntity;
import co.edu.uniandes.csw.boda.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.boda.persistence.RegaloPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author mf.valllejo
 */
@Stateless
public class RegaloLogic {
    
    private static final Logger LOGGER = Logger.getLogger(RegaloLogic.class.getName());

    @Inject
    private RegaloPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    public RegaloEntity createRegalo(RegaloEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de un regalo");
        if (persistence.findByName(entity.getName()) != null){
            throw new BusinessLogicException("Ya existe un regalo con el nombre \"" + entity.getName() + "\"");
        }
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de regalo");
        return entity;
    }

    public List<RegaloEntity> getRegalos() {
        LOGGER.info("Inicia proceso de consultar todas los Regalos");
        List<RegaloEntity> regalos = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas los Regalos");
        return regalos;
    }

    public RegaloEntity get(Long id) {
        return persistence.find(id);
    }

    public RegaloEntity update(RegaloEntity entity) {
        return persistence.update(entity);
    }

    public void delete(Long id) {
        persistence.delete(id);
    }
    
}