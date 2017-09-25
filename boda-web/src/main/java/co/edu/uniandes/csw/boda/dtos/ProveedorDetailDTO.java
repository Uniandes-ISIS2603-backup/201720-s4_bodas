/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.dtos;
import co.edu.uniandes.csw.boda.entities.ProveedorEntity;

/**
 *
 * @author aj.ortiz10
 */
public class ProveedorDetailDTO extends ProveedorDTO{
    
     /**
     * Constructor por defecto
     */
    public ProveedorDetailDTO() {
        //Constructor por defecto
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public ProveedorDetailDTO(ProveedorEntity entity) {
        super(entity);
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public ProveedorEntity toEntity() {
        ProveedorEntity ProveedorE = super.toEntity();
        return ProveedorE;
    }
}
