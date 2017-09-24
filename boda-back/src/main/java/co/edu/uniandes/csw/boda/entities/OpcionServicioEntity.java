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
import javax.persistence.OneToMany;

/**
 *
 * @author sp.joven
 */

@Entity
public class OpcionServicioEntity extends BaseEntity implements Serializable{
    
    private String descripcion;
    private Long  costo;
    private String diasDisponibles;
    
    @OneToMany(mappedBy = "opcionServicio", cascade = CascadeType.ALL, orphanRemoval = true)
     private List<CalificacionEntity> calificacion;
   //private Proveedor proveedor;    
   // private ArrayList<Tarea> tareas;
   

   

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
    /*
   

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    */
    
    
}
