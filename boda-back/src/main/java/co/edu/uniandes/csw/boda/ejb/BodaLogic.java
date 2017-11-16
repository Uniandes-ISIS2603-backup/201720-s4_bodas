/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.ejb;

import co.edu.uniandes.csw.boda.entities.BodaEntity;
import co.edu.uniandes.csw.boda.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.boda.persistence.BodaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author vn.gomez
 */
@Stateless
public class BodaLogic {
        private static final Logger LOGGER = Logger.getLogger(BodaLogic.class.getName());
        
        @Inject
        private BodaPersistence persistence;
        
     /**
     * Crea una boda
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
        public BodaEntity create(BodaEntity entity)throws BusinessLogicException 
     {
        LOGGER.log(Level.INFO, "Inicia proceso de crear una boda ");
        
        return persistence.create(entity);
     }
    /**
     * 
     * Obtener todas las bodas existentes en la base de datos.
     *
     * @return una lista de bodas.
     */
    public List<BodaEntity> getBodas() {
        LOGGER.info("Inicia proceso de consultar todas las bodas");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<BodaEntity> bodas = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las bodas");
        return bodas;
    }
  
     /**
     * Actualiza una boda con el id dado y la informacion
     * @param entity
     * @return BodaEntity
      */
    public BodaEntity updateBoda(BodaEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar una boda ");
        entity.setOpcionServicio(entity.getOpcionServicio());
        return persistence.update(entity);
    }
      
      public BodaEntity findBodaById(Long id) throws BusinessLogicException{
        if(persistence.find(id)==null) 
        {
            throw new BusinessLogicException("No existe una boda con el id dado.");
        }
        return persistence.find(id);
    }
    
    /**
       * Borra una boda con el id dado
       * @param id
       * @throws co.edu.uniandes.csw.boda.exceptions.BusinessLogicException
       */
      public void removeBoda(Long id) throws BusinessLogicException
      {
         LOGGER.info("Inicia proceso de eliminar una Boda");
         if (persistence.find(id)==null) 
         {
             throw new BusinessLogicException("No existe una Boda con el id \"" + id+"\"");
         }
         persistence.delete(id);
         LOGGER.info("Termina proceso de eliminar una boda");  
      }    
}
