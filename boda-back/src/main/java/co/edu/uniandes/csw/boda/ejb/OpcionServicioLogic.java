/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.ejb;

import co.edu.uniandes.csw.boda.entities.OpcionServicioEntity;
import co.edu.uniandes.csw.boda.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.boda.persistence.OpcionServicioPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author sp.joven
 */

@Stateless
public class OpcionServicioLogic {
         private static final Logger LOGGER = Logger.getLogger(OpcionServicioLogic.class.getName());
    
     @Inject
    private OpcionServicioPersistence persistence;
    
     
      /**
     * Crea una opcionServicio
     * @param entity
     * @return OpcionServicioEntity
     * @throws BusinessLogicException
     */
     public OpcionServicioEntity create(OpcionServicioEntity entity)throws BusinessLogicException 
     {
        LOGGER.info("Inicia proceso de creación de una opcion de servicio");
        //Verifica que no esten dos opcionServicio con el mismo id
        if(persistence.find(entity.getId())!=null)
            throw new BusinessLogicException("No pueden existir dos opciones de servicio con el mismo id.");
        
        //Si no existe ninguna opcion de servicio con el id.
        persistence.create(entity);
         return entity;
     }
      /*
     Solicita todas las opcionesServicio existentes
     */
     public List<OpcionServicioEntity> getOpcionesServicio(){
         LOGGER.info("Inicia proceso de consultar todas las opciones de servicio");
        List<OpcionServicioEntity> opciones  = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las opcionesServicio");
        return opciones;
     }
     /*
      *Solicita una tarea con el id dado 
      * @param id
      * @return OpcionServicioEntity
      *@throws si no se encuentra una opcionServicio con el id dado arroja BussinesLogicException
      */
      public OpcionServicioEntity getOpcionServicio(Long id)throws BusinessLogicException{          
            LOGGER.info("Inicia proceso de buscar la tarea por Id");
            OpcionServicioEntity buscado = persistence.find(id);
            if(buscado == null )throw new BusinessLogicException("No existe una opcionServicio con el id \"" + id +"\"");
            LOGGER.info("Termina proceso de buscar la opcionServicio por Id");
            return buscado;
        }
      
       /**
      *Actualiza una opcionServicio con el id Dado y la informacion
      * @param id
      * @param entity
      * @return OpcionServicioEntity
      *@throws si no se encuentra una opcionServicio con el id dado arroja BussinesLogicException
      */
      public OpcionServicioEntity updateOpcionServicio(Long id, OpcionServicioEntity entity)throws BusinessLogicException
      {
          LOGGER.info("Inicia proceso de actualizar opcionServicio");
          
          //Verifica que exista una opcionServicio con el id dado
          if(persistence.find(id)==null) throw new BusinessLogicException("No existe una opcion servicio con el id dado.");
          
          //Actualiza la opcion servicio
          persistence.update(entity);
          return entity;
      }
           
      /**
       * Borra una opcionServicio con el id Dado
       * @param id
       * @throws BusinessLogicException si no existe la opcionServicio con el id dado
       */
      public void removeOpcionServicio(Long id) throws BusinessLogicException
      {
         LOGGER.info("Inicia proceso de eliminar opcion servicio");
        if (persistence.find(id)==null) throw new BusinessLogicException("No existe una opcion servicio con el id \"" + id+"\"");
        persistence.delete(id);
          LOGGER.info("Termina proceso de eliminar una opcion servicio");  
      }
 public OpcionServicioEntity findOpcionServicioById(Long id) throws BusinessLogicException{
        if(persistence.find(id)==null) throw new BusinessLogicException("No existe una opcion servicio con el id dado.");
        return persistence.find(id);
    }


}
