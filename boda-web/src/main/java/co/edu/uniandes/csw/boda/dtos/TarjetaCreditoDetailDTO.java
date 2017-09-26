/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.dtos;

import co.edu.uniandes.csw.boda.entities.TarjetaCreditoEntity;

/**
 *
 * @author ca.guerrero
 */
public class TarjetaCreditoDetailDTO extends TarjetaCreditoDTO {
    
    
    /**
     * Constructor por defecto
     */
    public TarjetaCreditoDetailDTO() {
        super();
    }
    
    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public TarjetaCreditoDetailDTO(TarjetaCreditoEntity entity) {
        super(entity);
    }
    
    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public TarjetaCreditoEntity toEntity() {
        return super.toEntity();
    }
}
