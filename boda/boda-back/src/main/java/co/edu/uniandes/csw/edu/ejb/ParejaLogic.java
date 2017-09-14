/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.edu.ejb;

import co.edu.uniandes.csw.boda.entities.ParejaEntity;
import co.edu.uniandes.csw.boda.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.boda.persistence.ParejaPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author nf.ortiz
 */
@Stateless
public class ParejaLogic {
    private static final Logger LOGGER = Logger.getLogger(ParejaLogic.class.getName());
    
     @Inject
    private ParejaPersistence persistence;
     
     /* Solicita a Persistence crear una Pareja. */
     public ParejaEntity create(ParejaEntity entity)throws BusinessLogicException 
     {
        LOGGER.info("Inicia proceso de creación de una pareja");
        //Verifica que no esten dos parejas con el mismo correo
        if(persistence.find(entity.getCorreoElec())!=null)
            throw new BusinessLogicException("No pueden existir dos parejas con el mismo correo.");
        
        //Si no existe ninguna pareja con el correo.
        persistence.create(entity);
         return entity;
     }
     
     /*
     Solicita todas las Parejas
     */
     public List<ParejaEntity> getParejas(){
         LOGGER.info("Inicia proceso de consultar todas las parejas");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<ParejaEntity> parejas  = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las parejas");
        return parejas;
     }
     
     /*
     Solicita la pareja por el id String
     */
      public ParejaEntity getCity(String id)throws BusinessLogicException{          
            LOGGER.info("Inicia proceso de buscar la pareja por Id");
            ParejaEntity buscado = persistence.find(id);
            if(buscado == null )throw new BusinessLogicException("No existe una Pareja con el id \"" + id +"\"");
            LOGGER.info("Termina proceso de buscar la pareja por Id");
            return buscado;
        }
      
     /**
      *Actualiza una pareja con el id Dado y la informacion
      *@throws si no se encuentra una pareja con el id dado arroja exception
      */
      public ParejaEntity updatePareja(String id, ParejaEntity entity)throws BusinessLogicException
      {
          LOGGER.info("Inicia proceso de actualizar pareja");
          
          //Verifica que exista una pareja con el id dado
          if(persistence.find(id)==null) throw new BusinessLogicException("No existe una pareja con el id dado.");
          
          //Actualiza la pareja si existe
          persistence.update(entity);
          return entity;
      }
      
      /**
       * Borra una ciudad con el id Dado
       * @throws
       */
      public void removePareja(String id) throws BusinessLogicException
      {
         LOGGER.info("Inicia proceso de eliminar Pareja");
        if (persistence.find(id)==null) throw new BusinessLogicException("No existe una Pareja con el id \"" + id+"\"");
        persistence.delete(id);
          LOGGER.info("Termina proceso de eliminar una city");  
      }
}
