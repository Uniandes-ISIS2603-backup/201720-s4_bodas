/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;

/**
 *
 * @author sp.joven
 */

@Entity
public class OpcionServicioEntity extends BaseEntity implements Serializable{
    
    private String descripcion;
    private double  costo;
    private List<String> diasDisponibles;
   // private ArrayList<Calificacion> calificacion;
   // private ArrayList<Tarea> tareas;
   // private Proveedor proveedor;

   

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
      public double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }
    public List<String> getDiasDisponibles() {
        return diasDisponibles;
    }

    public void setDiasDisponibles(List<String> diasDisponibles) {
        this.diasDisponibles = diasDisponibles;
    }
    
    /*
    public Calificacion getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }
    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    */
    
    
}
