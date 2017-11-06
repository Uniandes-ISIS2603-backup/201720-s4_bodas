/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.entities;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;


/**
 *
 * @author sp.joven
 */

@Entity 
public class TareaEntity extends BaseEntity implements Serializable {
    
    private boolean aprobada;
    @Temporal(TemporalType.DATE)
    private Date  dia;
    private String nombre;
    private String image;

    @PodamExclude
    @ManyToOne
    private BodaEntity boda;
    

    public BodaEntity getBoda() {
        return boda;
    }

    public void setBoda(BodaEntity boda) {
        this.boda = boda;
    }
    
    @PodamExclude
    @OneToOne
    private UbicacionEntity ubicacion;
    
    @PodamExclude
    @ManyToOne
    private OpcionServicioEntity opcionServicio;
    public boolean isAprobada() {
        return aprobada;
    }

    public void setAprobada(boolean aprobada) {
        this.aprobada = aprobada;
    }
      public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     public OpcionServicioEntity getOpcionServicio() {
        return opcionServicio;
    }

    public void setOpcionServicio(OpcionServicioEntity opcionServicio) {
        this.opcionServicio = opcionServicio;
    }

    public UbicacionEntity getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(UbicacionEntity ubicacion) {
        this.ubicacion = ubicacion;
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
