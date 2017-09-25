/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.dtos;

import co.edu.uniandes.csw.boda.entities.OpcionServicioEntity;




/**
 *
 * @author sp.joven
 */
public class OpcionServicioDetailDTO extends OpcionServicioDTO {
     /**
     * Constructor por defecto
     */
    public OpcionServicioDetailDTO(){
        //Constructor por defecto
    }
    
     /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
   
     public OpcionServicioDetailDTO(OpcionServicioEntity entity) {
        super(entity);
    }
    
}


