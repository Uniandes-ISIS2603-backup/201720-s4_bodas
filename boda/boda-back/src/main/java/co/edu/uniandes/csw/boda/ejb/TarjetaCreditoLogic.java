/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.ejb;

import co.edu.uniandes.csw.boda.entities.TarjetaCreditoEntity;
import co.edu.uniandes.csw.boda.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.boda.persistence.TarjetaCreditoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author ca.guerrero
 */
public class TarjetaCreditoLogic {
    private static final Logger LOGGER = Logger.getLogger(TarjetaCreditoLogic.class.getName());

    @Inject
    private TarjetaCreditoPersistence persistence;
    
     /**
     *
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
    public TarjetaCreditoEntity createTarjetaCredito(TarjetaCreditoEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de TarjetaCredito");
        if (persistence.findByNumDeSeg(entity.getNumDeSeg())!= null) {
            throw new BusinessLogicException("Ya existe una TarjetaCredito con el numDeSeg \"" + entity.getNumDeSeg() + "\"");
        }
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de TarjetaCredito");
        return entity;
    }
    
    /**
     *
     * Actualizar una TarjetaCredito.
     *
     * @param id: id de la TarjetaCredito para buscarla en la base de datos.
     * @param entity: TarjetaCredito con los cambios para ser actualizada, por
     * ejemplo el numero.
     * @return la TarjetaCredito con los cambios actualizados en la base de datos.
     */
    public TarjetaCreditoEntity updateTarjetaCredito(Long id, TarjetaCreditoEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar TarjetaCredito con id={0}", id);
        TarjetaCreditoEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar TarjetaCredito con id={0}", entity.getId());
        return newEntity;
    }
    
     /**
     * Borrar un TarjetaCredito
     *
     * @param id: id de la TarjetaCredito a borrar
     */
    public void deleteTarjetaCredito(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar TarjetaCredito con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar TarjetaCredito con id={0}", id);
    }
    
    /**
     *
     * Obtener una TarjetaCredito por medio de su id.
     * 
     * @param id: id de la TarjetaCredito para ser buscada.
     * @return la TarjetaCredito solicitada por medio de su id.
     */
    public TarjetaCreditoEntity getTarjetaCredito(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar TarjetaCredito con id={0}", id);
        TarjetaCreditoEntity tarjeta = persistence.find(id);
        if (tarjeta == null) {
            LOGGER.log(Level.SEVERE, "La TarjetaCredito con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar TarjetaCredito con id={0}", id);
        return tarjeta;
    }
    
    /**
     *
     * Obtener una TarjetaCredito por medio de su numDeSeg.
     * 
     * @param numDeSeg: numero de seguridad de la TarjetaCredito para ser buscada.
     * @return la TarjetaCredito solicitada por medio de su numDeSeg.
     */
    public TarjetaCreditoEntity getTarjetaCreditoByNumDeSeg(Double numDeSeg) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar TarjetaCredito con numDeSeg={0}", numDeSeg);
        TarjetaCreditoEntity tarjeta = persistence.findByNumDeSeg(numDeSeg);
        if (tarjeta == null) {
            LOGGER.log(Level.SEVERE, "La TarjetaCredito con el numDeSeg {0} no existe", numDeSeg);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar TarjetaCredito con numDeSeg={0}", numDeSeg);
        return tarjeta;
    }
    
    /**
     * 
     * Obtener todas las Tarjetas de Credito existentes en la base de datos.
     *
     * @return una lista de Tarjetas de Credito.
     */
    public List<TarjetaCreditoEntity> getTarjetasCredito() {
        LOGGER.info("Inicia proceso de consultar todas las Tarjetas de Credito");
        List<TarjetaCreditoEntity> tarjetas = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las Tarjetas de Credito");
        return tarjetas;
    }
}
