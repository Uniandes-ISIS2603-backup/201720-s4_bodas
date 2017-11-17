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
    
    /**
     * Atributo privado aprobada.
     */
    private boolean aprobada;
    
    /**
     * Atributo privado dia.
     */
    @Temporal(TemporalType.DATE)
    private Date  dia;
    
        /**
     * Atributo privado nombre.
     */
    private String nombre;
        /**
     * Atributo privado image.
     */
    private String image;

        /**
     * Atributo privado boda.
     */
    @PodamExclude
    @ManyToOne
    private BodaEntity boda;
    
    /**
     * Atributo privado ubicacion.
     */
    @PodamExclude
    @OneToOne
    private UbicacionEntity ubicacion;
    
     /**
     * Atributo privado opcionServicio.
     */
    @PodamExclude
    @ManyToOne
    private OpcionServicioEntity opcionServicio;
    
    /**
     * Obtiene el atributo boda.
     *
     * @return atributo                boda.
     */
    public BodaEntity getBoda() {
        return boda;
    }
    
    /**
     * Establece el valor del atributo boda.
     *
     * @param boda nuevo valor del atributo
     */
    public void setBoda(BodaEntity boda) {
        this.boda = boda;
    }
    
    /**
     * Obtiene el atributo aprobada.
     *
     * @return atributo aprobada.
     */
    public boolean isAprobada() {
        return aprobada;
    }

    public void setAprobada(boolean aprobada) {
        this.aprobada = aprobada;
    }
    
    /**
     * Obtiene el atributo dia.
     *
     * @return atributo dia.
     */
    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }
    /**
     * Obtiene el atributo nombre.
     *
     * @return atributo nombre.
     */
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
