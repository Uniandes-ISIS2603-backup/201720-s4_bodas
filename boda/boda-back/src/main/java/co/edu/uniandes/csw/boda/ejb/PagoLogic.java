/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.ejb;

import co.edu.uniandes.csw.boda.entities.PagoEntity;
import co.edu.uniandes.csw.boda.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.boda.persistence.PagoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ca.guerrero
 */
@Stateless
public class PagoLogic {
    private static final Logger LOGGER = Logger.getLogger(PagoLogic.class.getName());

    @Inject
    private PagoPersistence persistence;

    /**
     *
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
    public PagoEntity createPago(PagoEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Pago");
        if (persistence.find(entity.getId())!= null) {
            throw new BusinessLogicException("Ya existe un Pago con el id \"" + entity.getId() + "\"");
        }
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de Pago");
        return entity;
    }
    
     /**
     *
     * Actualizar un Pago.
     *
     * @param id: id del Pago para buscarlo en la base de datos.
     * @param entity: Pago con los cambios para ser actualizado, por
     * ejemplo el montoTotal.
     * @return el Pago con los cambios actualizados en la base de datos.
     */
    public PagoEntity updatePago(Long id, PagoEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar Pago con id={0}", id);
        PagoEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar Pago con id={0}", entity.getId());
        return newEntity;
    }
    
     /**
     *
     * Obtener un Pago por medio de su id.
     * 
     * @param id: id del Pago para ser buscado.
     * @return el Pago solicitado por medio de su id.
     */
    public PagoEntity getTarjetaCredito(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar Pago con id={0}", id);
        PagoEntity pago = persistence.find(id);
        if (pago == null) {
            LOGGER.log(Level.SEVERE, "El Pago con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar Pago con id={0}", id);
        return pago;
    }
    
    /**
     * 
     * Obtener todas las Tarjetas de Credito existentes en la base de datos.
     *
     * @return una lista de Tarjetas de Credito.
     */
    public List<PagoEntity> getTarjetasCredito() {
        LOGGER.info("Inicia proceso de consultar todos los Pagos");
        List<PagoEntity> pagos = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los Pagos");
        return pagos;
    }
}
