/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.ejb;


import co.edu.uniandes.csw.boda.entities.TareaEntity;
import co.edu.uniandes.csw.boda.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.boda.persistence.TareaPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author sp.joven
 */

@Stateless
public class TareaLogic {
     private static final Logger LOGGER = Logger.getLogger(TareaLogic.class.getName());
    
     @Inject
    private TareaPersistence persistence;
     
      /* Solicita a Persistence crear una Tarea. */
     public TareaEntity create(TareaEntity entity)throws BusinessLogicException 
     {
        LOGGER.info("Inicia proceso de creación de una tarea");
        //Verifica que no esten dos tareas con el mismo id
        if(persistence.find(entity.getId())!=null)
            throw new BusinessLogicException("No pueden existir dos tareas con el mismo id.");
        
        //Si no existe ninguna tarea con el id.
        persistence.create(entity);
         return entity;
     }
      /*
     Solicita todas las Tareas existentes
     */
     public List<TareaEntity> getTareas(){
         LOGGER.info("Inicia proceso de consultar todas las tareas");
        List<TareaEntity> tareas  = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las tareas");
        return tareas;
     }
     /*
     Solicita la tarea por el id
     */
      public TareaEntity getTarea(Long id)throws BusinessLogicException{          
            LOGGER.info("Inicia proceso de buscar la tarea por Id");
            TareaEntity buscado = persistence.find(id);
            if(buscado == null )throw new BusinessLogicException("No existe una tarea con el id \"" + id +"\"");
            LOGGER.info("Termina proceso de buscar la tarea por Id");
            return buscado;
        }
      
       /**
      *Actualiza una tarea con el id Dado y la informacion
      * @param id
      * @param entity
      * @return TareaEntity
      *@throws si no se encuentra una pareja con el id dado arroja BussinesLogicException
      */
      public TareaEntity updateTarea(Long id, TareaEntity entity)throws BusinessLogicException
      {
          LOGGER.info("Inicia proceso de actualizar tarea");
          
          //Verifica que exista una tarea con el id dado
          if(persistence.find(id)==null) throw new BusinessLogicException("No existe una tarea con el id dado.");
          
          //Actualiza la tarea
          persistence.update(entity);
          return entity;
      }
           
      /**
       * Borra una tarea con el id Dado
       * @param id
       * @throws BusinessLogicException si no existe la tarea con el id dado
       */
      public void removeTarea(Long id) throws BusinessLogicException
      {
         LOGGER.info("Inicia proceso de eliminar tarea");
        if (persistence.find(id)==null) throw new BusinessLogicException("No existe una Tarea con el id \"" + id+"\"");
        persistence.delete(id);
          LOGGER.info("Termina proceso de eliminar una tarea");  
      }
       public TareaEntity findTareaById(Long id) throws BusinessLogicException{
        if(persistence.find(id)==null) throw new BusinessLogicException("No existe una tarea con el id dado.");
        return persistence.find(id);
    }
}
