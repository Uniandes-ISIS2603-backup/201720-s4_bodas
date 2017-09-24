/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author sp.joven
 */

@Entity 
public class TareaEntity extends BaseEntity implements Serializable {
    
     private boolean aprobada;
    private String  dia;
    private String nombre;
    /*
    private BodaEntity boda;
    private UbicacionEntity ubicacion;
    private OpcionServicioEntity opcionServicio;
*/
 
    public boolean getAprobada() {
        return aprobada;
    }

    public void setAprobada(boolean aprobada) {
        this.aprobada = aprobada;
    }
      public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    /*
    public BodaEntity getBoda() {
        return boda;
    }

    public void setBoda(BodaEntity boda) {
        this.boda = boda;
    }
    public UbicacionEntity getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(UbicacionEntity ubicacion) {
        this.ubicacion = ubicacion;
    }
     public OpcionServicioEntity getOpcionServicio() {
        return opcionServicio;
    }

    public void setOpcionServicio(OpcionServicioEntity opcionServicio) {
        this.opcionServicio = opcionServicio;
    }
    */

}
