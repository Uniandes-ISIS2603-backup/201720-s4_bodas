/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;

/**
 *
 * @author vn.gomez
 */
@Entity
public class BodaEntity extends BaseEntity implements Serializable {  
    
    private String lugar;
    private Date fecha;
    private String tema;
    private String religion;
    private String tipoBoda;

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getTipoBoda() {
        return tipoBoda;
    }

    public void setTipoBoda(String tipoBoda) {
        this.tipoBoda = tipoBoda;
    }
   
}
