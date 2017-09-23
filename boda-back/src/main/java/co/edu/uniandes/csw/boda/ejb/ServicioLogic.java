/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.ejb;

import co.edu.uniandes.csw.boda.entities.ServicioEntity;
import co.edu.uniandes.csw.boda.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.boda.persistence.ServicioPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author aj.ortiz10
 */
@Stateless
public class ServicioLogic {
    
    private static final Logger LOGGER = Logger.getLogger(ServicioLogic.class.getName());

    @Inject
    private ServicioPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    /**
     *
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
    public ServicioEntity createServicio(ServicioEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Default");
        // Invoca la persistencia para crear la Default
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de Default");
        return entity;
    }

    /**
     * 
     * Obtener todas las Defaultes existentes en la base de datos.
     *
     * @return una lista de Defaultes.
     */
    public List<ServicioEntity> getServicio() {
        LOGGER.info("Inicia proceso de consultar todas las Defaultes");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<ServicioEntity> Default = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las Defaultes");
        return Default;
    }
    
    
    public ServicioEntity getServicio(Long id){
        return persistence.find(id);
    }

    public ServicioEntity update(ServicioEntity entity)
    {
        return persistence.update(entity);
    }

    public void deleteServicio(Long id)
    {
        persistence.delete(id);
    }
}
