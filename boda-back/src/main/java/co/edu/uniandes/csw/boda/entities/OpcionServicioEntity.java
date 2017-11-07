/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author sp.joven
 */

@Entity
public class OpcionServicioEntity extends BaseEntity implements Serializable{
    
    private String descripcion;
    private Long  costo;
    private String diasDisponibles;
     private String image;
    
    @OneToMany(mappedBy = "opcionServicio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CalificacionEntity> calificacion;
    
    @PodamExclude
    @ManyToOne
    private ProveedorEntity proveedor;    
    
      
    @PodamExclude
    @OneToMany(mappedBy = "opcionServicio")
    private List<TareaEntity> tareas;
  
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
      public Long getCosto() {
        return costo;
    }

    public void setCosto(Long costo) {
        this.costo = costo;
    }
    public String getDiasDisponibles() {
        return diasDisponibles;
    }

    public void setDiasDisponibles(String diasDisponibles) {
        this.diasDisponibles = diasDisponibles;
    }
  
     public List<CalificacionEntity> getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(List<CalificacionEntity> calificacion) {
        this.calificacion = calificacion;
    }
    
    public List<TareaEntity> getTareas() {
        return tareas;
    }

    public void setTareas(List<TareaEntity> tareas) {
        this.tareas = tareas;
    }
     
    public ProveedorEntity getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorEntity proveedor) {
        this.proveedor = proveedor;
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
