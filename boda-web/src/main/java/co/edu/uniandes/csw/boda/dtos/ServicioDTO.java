/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.dtos;

import co.edu.uniandes.csw.boda.entities.ServicioEntity;

/**
 *
 * @author aj.ortiz10
 */
public class ServicioDTO {
    
    private Long id;
    private String name;
    public String descripcion;
    
    public ServicioDTO(){

    }
    
    /**
     * Conviertir Entity a DTO
     * (Crea un nuevo DTO con los valores que recibe en  la entidad que viene de argumento.
     * @param city: Es la entidad que se va a convertir a DTO 
     */
    public ServicioDTO(ServicioEntity servicio) {
        this.id = servicio.getId();
        this.name = servicio.getName();
        this.descripcion = servicio.getDescripcion();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }
    
    /**
     * Convertir DTO a Entity
     * @return Un Entity con los valores del DTO 
     */
    public ServicioEntity toEntity() {
        ServicioEntity entity = new ServicioEntity();
        entity.setId(this.id);
        entity.setName(this.name);
        entity.setDescripcion(this.descripcion);
        return entity;
    }
}
