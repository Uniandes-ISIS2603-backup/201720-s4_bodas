
package co.edu.uniandes.csw.boda.ejb;
import co.edu.uniandes.csw.boda.entities.OpcionServicioEntity;
import co.edu.uniandes.csw.boda.entities.ProveedorEntity;
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
    
      @Inject
      ProveedorLogic proveedorLogic;
      
      /**
     * Crea una opcionServicio
     * @param entity
     * @param proveedorId
     * @return OpcionServicioEntity
     * @throws BusinessLogicException
     */
     public OpcionServicioEntity create(Long proveedorId,OpcionServicioEntity entity)throws BusinessLogicException 
     {
        LOGGER.info("Inicia proceso de creación de una opcion de servicio");
        ProveedorEntity proveedor = proveedorLogic.findProveedorById(proveedorId);
        entity.setProveedor(proveedor);
        if(entity.getCosto()<0)
          {
               throw new BusinessLogicException("El costo no puede ser negativo.");
          }
        //Verifica que no esten dos opcionServicio con el mismo id
        if(persistence.find(entity.getId())!=null)
            throw new BusinessLogicException("No pueden existir dos opciones de servicio con el mismo id.");
        
        //Si no existe ninguna opcion de servicio con el id.
        persistence.create(entity);
         return entity;
     }
    
    /**
     * Consulta  laa opcionesServicio
     * @param proveedorId
     * @return Lista de OpcionServicioEntity
     * @throws BusinessLogicException
     */
     public List<OpcionServicioEntity> getOpcionesServicio(Long proveedorId) throws BusinessLogicException{
         LOGGER.info("Inicia proceso de consultar todas las opciones de servicio");
           ProveedorEntity proveedor= proveedorLogic.findProveedorById(proveedorId);
            if (proveedor.getOpcionesServicio() == null) {
            throw new BusinessLogicException("El proveedor que consulta aún no tiene opciones de servicio");
        }
        if (proveedor.getOpcionesServicio().isEmpty()) {
            throw new BusinessLogicException("El proveedor que consulta aún no tiene opciones de servicio");
        }

        return proveedor.getOpcionesServicio();
    }
     /**
     * Consulta una opcionServicio con el id dado
     * @param id
     * @return OpcionServicioEntity
     * @throws BusinessLogicException
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
      * @param proveedorId
      * @param entity
      * @return OpcionServicioEntity
     * @throws co.edu.uniandes.csw.boda.exceptions.BusinessLogicException
      * @throws BussinesLogicException si no se encuentra una opcionServicio con el id dado
      */
      public OpcionServicioEntity updateOpcionServicio(Long proveedorId, OpcionServicioEntity entity)throws BusinessLogicException
      {
          
        ProveedorEntity proveedor = proveedorLogic.findProveedorById(proveedorId);

        entity.setProveedor(proveedor);
         if(entity.getCosto()<0)
          {
               throw new BusinessLogicException("El costo no puede ser negativo.");
          }
         
          //Verifica que exista una opcionServicio con el id dado
          if(persistence.find(proveedorId)==null) 
          {
              throw new BusinessLogicException("No existe una opcion servicio con el id dado.");
          }
          entity.setPago(entity.getPago());
          entity.setBoda(entity.getBoda());
          //Actualiza la opcion servicio
          persistence.update(entity);
          return entity;
      }
         
      /**
     * Elimina una opcionServicio con el id dado
     * @param id
     * @throws BusinessLogicException
     */
      public void removeOpcionServicio(Long id) throws BusinessLogicException
      {
         LOGGER.info("Inicia proceso de eliminar opcion servicio");
        if (persistence.find(id)==null) throw new BusinessLogicException("No existe una opcion servicio con el id \"" + id+"\"");
        persistence.delete(id);
          LOGGER.info("Termina proceso de eliminar una opcion servicio");  
      }
      
       /**
       * Encuentra una opcionServicio con el id Dado
       * @param id
       * @throws BusinessLogicException si no existe la opcionServicio con el id dado
       * @return OpcionServicioEntity
       */
 public OpcionServicioEntity findOpcionServicioById(Long id) throws BusinessLogicException{
        if(persistence.find(id)==null) throw new BusinessLogicException("No existe una opcion servicio con el id dado.");
        return persistence.find(id);
    }


}
