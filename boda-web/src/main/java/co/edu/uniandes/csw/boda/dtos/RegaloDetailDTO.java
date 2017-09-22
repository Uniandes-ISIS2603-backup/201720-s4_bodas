/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.dtos;

import co.edu.uniandes.csw.boda.entities.RegaloEntity;

/**
 *
 * @author mf.valllejo
 */
public class RegaloDetailDTO extends RegaloDTO{

    public RegaloDetailDTO() {
    }

    public RegaloDetailDTO(RegaloEntity entity) {
        super(entity);
    }

    @Override
    public RegaloEntity toEntity() {
        return super.toEntity(); 
    }
    
}
