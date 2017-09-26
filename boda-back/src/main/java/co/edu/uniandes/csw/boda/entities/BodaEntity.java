/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author vn.gomez
 */
@Entity
public class BodaEntity extends BaseEntity implements Serializable {  
    
    private String lugar;
    
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private String tema;
    private String religion;
    private String tipoBoda;
    
    @PodamExclude
    @OneToOne
    private ParejaEntity pareja;
    
    @PodamExclude
    @OneToMany(mappedBy="boda", cascade = CascadeType.ALL)
    private List<InvitadoEntity> invitados = new ArrayList();
    
    @PodamExclude
    @OneToMany(mappedBy="boda", cascade = CascadeType.ALL)

    private List<RegaloEntity> regalos = new ArrayList();
    
    @PodamExclude
    @OneToMany(mappedBy="boda", cascade = CascadeType.ALL)
    private List<TareaEntity> tareas;

    public List<TareaEntity> getTareas() {
        return tareas;
    }

    public void setTareas(List<TareaEntity> tareas) {
        this.tareas = tareas;
    }

    public List<InvitadoEntity> getInvitados() {
        return invitados;
    }

    public void setInvitados(List<InvitadoEntity> invitados) {
        this.invitados = invitados;
    }

    public List<RegaloEntity> getRegalos() {
        return regalos;
    }

    public void setRegalos(List<RegaloEntity> regalos) {
        this.regalos = regalos;
    }

    public ParejaEntity getPareja() {
        return pareja;
    }

    public void setPareja(ParejaEntity pareja) {
        this.pareja = pareja;
    }
    
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