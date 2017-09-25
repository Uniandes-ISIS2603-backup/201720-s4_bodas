/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.dtos;

import co.edu.uniandes.csw.boda.entities.TareaEntity;
import java.util.List;

/**
 *
 * @author sp.joven
 */
public class TareaDetailDTO extends TareaDTO{
    
    
    private UbicacionDTO ubicacion;
  
    /**
     * Constructor por defecto
     */
    public TareaDetailDTO(){
    }
    
     /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
     public TareaDetailDTO(TareaEntity entity) {
        super(entity);
        if (entity.getUbicacion() != null) {
            this.ubicacion= new UbicacionDTO(entity.getUbicacion());
        } else {
            entity.setUbicacion(null);
        }
    }

        
    @Override
    public TareaEntity toEntity() {
        TareaEntity tareaE = super.toEntity();
        if (this.getUbicacion() != null) {
            tareaE.setUbicacion(this.getUbicacion().toEntity());
        }
        return tareaE;
    } 
     
    public UbicacionDTO getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(UbicacionDTO ubicacion) {
        this.ubicacion = ubicacion;
    }
   
}
