/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
/**
 *
 * @author aj.ortiz10
 */
@Entity
public class ServicioEntity extends BaseEntity implements Serializable  {
    
    private String descripcion;
       
    @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProveedorEntity> proveedores = new ArrayList<>();
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }
    
    public List<ProveedorEntity> getProveedores(){
        return proveedores;
    }
    
    public void setProveedores(List<ProveedorEntity> proveedores){
        this.proveedores=proveedores;
    }
}
