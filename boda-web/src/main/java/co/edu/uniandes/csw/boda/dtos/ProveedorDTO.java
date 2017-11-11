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
public class ProveedorDTO {
    
    
    private long id;
    private String name;
    private String especialidad;
    
    /**
     * Clase constructor
     */
    public ProveedorDTO(){
        //Constructor por defecto
    }
    
    public ProveedorDTO(ProveedorEntity proveedor) {
        this.id = proveedor.getId();
        this.name = proveedor.getName();
        this.especialidad = proveedor.getEspecialidad();
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getExpecialidad(){
        return especialidad;
    }
    
    public void setEspecialidad(String especialidad){
        this.especialidad=especialidad;
    }
    
        /**
     * Convertir DTO a Entity
     * @return Un Entity con los valores del DTO 
     */
    public ProveedorEntity toEntity() {
        ProveedorEntity entity = new ProveedorEntity();
        entity.setId(this.id);
        entity.setName(this.name);
        entity.setEspecialidad(this.especialidad);
        return entity;
    }
}
