/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author aj.ortiz10
 */
@Entity
public class ProveedorEntity extends BaseEntity implements Serializable{
    
    private String especialidad;
    
    @PodamExclude
    @ManyToOne
    private ServicioEntity servicio;
    
    @PodamExclude
    @OneToMany(mappedBy="proveedor", cascade = CascadeType.ALL)
    private List<OpcionServicioEntity> opcionesServicio;  
    
    public String getEspecialidad(){
        return especialidad;
    }
    
    public void setEspecialidad(String especialidad){
        this.especialidad=especialidad;
    }
    
    public ServicioEntity getServicio(){
        return servicio;
    }
    
    public void setServicio(ServicioEntity servicio){
        this.servicio=servicio;
    }
    public List<OpcionServicioEntity> getOpcionesServicio(){
        return opcionesServicio;
    }
    
    public void setOpcionesServicio(List<OpcionServicioEntity> servicio){
        this.opcionesServicio=servicio;
    }
}
