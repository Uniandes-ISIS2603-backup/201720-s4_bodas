/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.ejb;

import co.edu.uniandes.csw.boda.entities.BodaEntity;
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

    @Inject
    BodaLogic bodaLogic;

    public TareaEntity create(Long bodaId, TareaEntity entity) throws BusinessLogicException {

        BodaEntity boda = bodaLogic.findBodaById(bodaId);
        entity.setBoda(boda);
        if (persistence.find(entity.getId()) != null) {
            throw new BusinessLogicException("No pueden existir dos tareas con el mismo id.");
        }
        persistence.create(entity);
        return entity;
    }

    /*
     Solicita todas las Tareas existentes
     */
    public List<TareaEntity> getTareas(Long bodaId) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de consultar todas las tareas");
        BodaEntity boda = bodaLogic.findBodaById(bodaId);
             
        if (boda.getTareas() == null) {
            throw new BusinessLogicException("La boda que consulta aún no tiene tareas");
        }
        if (boda.getTareas().isEmpty()) {
            throw new BusinessLogicException("La boda que consulta aún no tiene tareas");
        }
        return boda.getTareas();
    }

    /*
     Solicita la tarea por el id
     */
    public TareaEntity getTarea(Long id) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de buscar la tarea por Id");
        TareaEntity buscado = persistence.find(id);
        if (buscado == null) {
            throw new BusinessLogicException("No existe una tarea con el id \"" + id + "\"");
        }
        LOGGER.info("Termina proceso de buscar la tarea por Id");
        return buscado;
    }

    /**
     * Actualiza una tarea con el id Dado y la informacion
     *
     * @param bodaId
     * @param id
     * @param entity
     * @return TareaEntity
     * @throws co.edu.uniandes.csw.boda.exceptions.BusinessLogicException
     *
     */
    public TareaEntity updateTarea(Long bodaId, TareaEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de actualizar tarea");
        BodaEntity boda = bodaLogic.findBodaById(bodaId);

        entity.setBoda(boda);
        if(entity.getDia().after(boda.getFecha()))
        {
             throw new BusinessLogicException("No puede reagendar una tarea para despues de "+boda.getFecha());
        }
       
        return persistence.update(entity);
    }

    /**
     * Borra una tarea con el id Dado
     *
     * @param id
     * @throws BusinessLogicException si no existe la tarea con el id dado
     */
    public void removeTarea(Long id) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de eliminar tarea");
        if (persistence.find(id) == null) {
            throw new BusinessLogicException("No existe una Tarea con el id \"" + id + "\"");
        }
        persistence.delete(id);
        LOGGER.info("Termina proceso de eliminar una tarea");
    }

    /**
     * Encuentra una opcionServicio con el id Dado
     *
     * @param id
     * @throws BusinessLogicException si no existe la opcionServicio con el id
     * dado
     * @return TareaEntity
     */
    public TareaEntity findTareaById(Long id) throws BusinessLogicException {
        if (persistence.find(id) == null) {
            throw new BusinessLogicException("No existe una tarea con el id dado.");
        }
        return persistence.find(id);
    }
}
