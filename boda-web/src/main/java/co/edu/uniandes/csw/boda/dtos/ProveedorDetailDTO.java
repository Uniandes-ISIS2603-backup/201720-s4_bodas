/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.dtos;
import co.edu.uniandes.csw.boda.entities.OpcionServicioEntity;
import co.edu.uniandes.csw.boda.entities.ProveedorEntity;
import co.edu.uniandes.csw.boda.entities.RegaloEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aj.ortiz10
 */
public class ProveedorDetailDTO extends ProveedorDTO{
    
     /**
     * Constructor por defecto
     */
     private List<OpcionServicioDTO> opciones;
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
        if (entity.getOpcionesServicio() != null) {
            opciones = new ArrayList<>();
            for (OpcionServicioEntity entityRegalo : entity.getOpcionesServicio()) {
                opciones.add(new OpcionServicioDTO(entityRegalo));
            }
        }
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
    
     public List<OpcionServicioDTO> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<OpcionServicioDTO> ubicacion) {
        this.opciones = ubicacion;
    }
    
}
