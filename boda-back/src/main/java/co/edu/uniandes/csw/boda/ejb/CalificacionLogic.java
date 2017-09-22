/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.ejb;

import co.edu.uniandes.csw.boda.entities.CalificacionEntity;
import co.edu.uniandes.csw.boda.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.boda.persistence.CalificacionPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author nf.ortiz
 */
@Stateless
public class CalificacionLogic {
    private static final Logger LOGGER = Logger.getLogger(CalificacionLogic.class.getName());
    
     @Inject
    private CalificacionPersistence persistence;
     
    /**
     * Retorna todas las calificaciones
     */
     public CalificacionEntity create(CalificacionEntity entity)throws BusinessLogicException 
     {
        LOGGER.info("Inicia proceso de creación de una calificacion");
        //Verifica que no esten dos calificacion con el mismo id
        if(persistence.find(entity.getId())!=null)
            throw new BusinessLogicException("No pueden existir dos calificacion con el mismo id.");
        
        //Si no existe ninguna pareja con el correo.
        persistence.create(entity);
         return entity;
     }
     
     /**
      * Retorna la lista de calificaciones
      */
     public List<CalificacionEntity> getCalificaciones(){
        LOGGER.info("Inicia proceso de consultar todas las calificaciones");
        return persistence.findAll();
     }
     
     /**
      * Retorna la calificacion con el id dado
      */
     public CalificacionEntity getCalificacion(Long id){
         LOGGER.info("Inicia proceso de consultar  la calificacion con el id dado.");
         return persistence.find(id);
     }
      /**
      * Actualiza la calificacion con el id dado
      */
     public CalificacionEntity updateCalificacion(Long id, CalificacionEntity enity)throws BusinessLogicException{
        LOGGER.info("Inicia proceso de actualizar  la calificacion con el id dado.");
        persistence.update(enity);
         return enity;
     }
     
     /**
      * Borra la calificacion con el id dado
      */
    public void deleteCalificacion(Long id)throws BusinessLogicException{
        LOGGER.info("Inicia proceso de actualizar  la calificacion con el id dado.");
        persistence.delete(id);
    }
}
