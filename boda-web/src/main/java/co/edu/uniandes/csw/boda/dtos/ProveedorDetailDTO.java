/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.dtos;
import co.edu.uniandes.csw.boda.entities.OpcionServicioEntity;
import co.edu.uniandes.csw.boda.entities.ProveedorEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aj.ortiz10
 */
public class ProveedorDetailDTO extends ProveedorDTO{
    
    private List<OpcionServicioDTO> opcionesDeServicio;
     /**
     * Constructor por defecto
     */
    public ProveedorDetailDTO() {
        //Constructor por defecto
        super();
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public ProveedorDetailDTO(ProveedorEntity entity) {
        super(entity);
        if (entity.getOpcionesDeServicio() != null) {
            opcionesDeServicio = new ArrayList<>();
            for (OpcionServicioEntity entityUbicacion : entity.getOpcionesDeServicio()) {
                opcionesDeServicio.add(new OpcionServicioDTO(entityUbicacion));
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
        if (opcionesDeServicio != null) {
            List<OpcionServicioEntity> opcionesDeServicioEntity = new ArrayList<>();
            for (OpcionServicioDTO dtoAuthor : opcionesDeServicio) {
                opcionesDeServicioEntity.add(dtoAuthor.toEntity());
            }
            ProveedorE.setServicios(opcionesDeServicioEntity);
        }
        return ProveedorE;
    }
    
    public List<OpcionServicioDTO> getOpcionesDeServicio() {
        return opcionesDeServicio;
    }

    public void setOpcionesDeServicio(List<OpcionServicioDTO> opcionesDeServicio) {
        this.opcionesDeServicio = opcionesDeServicio;
    }
}
