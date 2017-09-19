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
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author mf.valllejo
 */
@Entity
public class RegaloEntity extends BaseEntity implements Serializable {
    
    private String imagen;
    private boolean comprado;
    
    @PodamExclude
    @ManyToOne
    private BodaEntity boda;
    
    @PodamExclude
    @ManyToMany
    private List<UbicacionEntity> locations;

    public BodaEntity getBoda() {
        return boda;
    }

    public void setBoda(BodaEntity boda) {
        this.boda = boda;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public boolean isComprado() {
        return comprado;
    }

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }
    
}
