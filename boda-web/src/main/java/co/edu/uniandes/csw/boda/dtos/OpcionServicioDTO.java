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
public class OpcionServicioDTO {
   


/**
 * OpcionServicioDTO Objeto de transferencia de datos de opcioin de servicio. Los DTO
 * contienen las representaciones de los JSON que se transfieren entre el
 * cliente y el servidor. 
 *
 * @author sp.joven
 */
  private Long id;
  private String descripcion;
  private Long  costo;
  private String diasDisponibles;   
  
    
    
    /**
     * Constructor por defecto
     */
    public OpcionServicioDTO() {
    }
    
    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param opcionServicio: Es la entidad que se va a convertir a DTO
     */
    public OpcionServicioDTO(OpcionServicioEntity opcionServicio) {
        
        this.id=opcionServicio.getId();
        this.descripcion = opcionServicio.getDescripcion();
        this.costo = opcionServicio.getCosto();
        this.diasDisponibles = opcionServicio.getDiasDisponibles();
    }
    public Long getId() {
        return id;
    }

    public void setID(Long id) {
        this.id =id;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion =descripcion;
    }
    
    public String getDiasDisponibles() {
        return diasDisponibles;
    }

    public void setDiasDisponibles(String diasDisponibles) {
        this.diasDisponibles = diasDisponibles;
    }
    public Long getCosto() {
        return costo;
    }

    public void setCosto(Long costo) {
        this.costo =costo;
    }
    
    /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    public OpcionServicioEntity toEntity() {
        OpcionServicioEntity entity = new OpcionServicioEntity();
        entity.setId(this.id);
        entity.setDescripcion(this.descripcion);
        entity.setCosto(this.costo);
        entity.setDiasDisponibles(this.diasDisponibles);
        return entity;
    }
    
}

