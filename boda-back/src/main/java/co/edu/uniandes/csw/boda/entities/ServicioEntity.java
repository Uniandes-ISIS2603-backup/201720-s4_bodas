/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import uk.co.jemos.podam.common.PodamExclude;
/**
 *
 * @author aj.ortiz10
 */
@Entity
public class ServicioEntity extends BaseEntity implements Serializable  {
    
    
    private String descripcion;
    @PodamExclude  
    @ManyToMany
    private List<ProveedorEntity> proveedores;
    
    private String image;

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
    
     /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }
}
