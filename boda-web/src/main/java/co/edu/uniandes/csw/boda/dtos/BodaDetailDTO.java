/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.dtos;

import co.edu.uniandes.csw.boda.entities.BodaEntity;

/**
 *
 * @author vn.gomez
 */
public class BodaDetailDTO extends BodaDTO{
    
    /**
     * Constructor por defecto
     */
    public BodaDetailDTO(){
     //Do nothing because we use the getters and setters methods.
    }
    
     /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public BodaDetailDTO( BodaEntity entity) {
        super(entity);
    }

}
