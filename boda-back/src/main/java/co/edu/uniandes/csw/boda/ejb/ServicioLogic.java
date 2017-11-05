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
        LOGGER.info("Inicia proceso de creación del servicio");
        // Invoca la persistencia para crear el servicio
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación del servicio");
        return entity;
    }

    /**
     * 
     * Obtener todas los servicios existentes en la base de datos.
     *
     * @return una lista de servicios.
     */
    public List<ServicioEntity> getServicios() {
        LOGGER.info("Inicia proceso de consultar todos los servicios");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<ServicioEntity> Servicios = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los servicios");
        return Servicios;
    }
    
    
    public ServicioEntity getServicio(Long id)throws BusinessLogicException{
        LOGGER.info("Inicia proceso de buscar el servicio por Id");
        ServicioEntity buscado = persistence.find(id);
        if(buscado == null )throw new BusinessLogicException("No existe un Servicio con el id \"" + id +"\"");
            LOGGER.info("Termina proceso de buscar el sevicio por Id");
        return persistence.find(id);
    }

    public ServicioEntity update(Long id,ServicioEntity entity)throws BusinessLogicException
    {
        LOGGER.info("Inicia proceso de actualizar el servicio");
        
        //Verifica que exista una pareja con el id dado
        if(persistence.find(id)==null) throw new BusinessLogicException("No existe un servicio con el id dado.");
          
        return persistence.update(entity);
    }

    public void deleteServicio(Long id)throws BusinessLogicException
    {
        LOGGER.info("Inicia proceso de eliminar un Servicio");
        if (persistence.find(id)==null) throw new BusinessLogicException("No existe un servicio con el id \"" + id+"\"");
        persistence.delete(id);
        LOGGER.info("Termina proceso de eliminar un Servicio"); 
    }
}
