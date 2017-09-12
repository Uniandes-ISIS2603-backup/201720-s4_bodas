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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author nf.ortiz
 */
@Entity
public class ParejaEntity implements Serializable{
    
    @Id
    private String correoElec;
    
    private String nombreInd1;
    
    private String nombreInd2;
    
    private int telefono;
    
    private String direccion;
    
    private boolean pago;
    
    private String contrasenia;
    
    private String nombreAbreviado;

    public BodaEntity getBoda() {
        return boda;
    }

    public void setBoda(BodaEntity boda) {
        this.boda = boda;
    }

    public List<TarjetaCreditoEntity> getTarjetasCredito() {
        return tarjetasCredito;
    }

    public void setTarjetasCredito(List<TarjetaCreditoEntity> tarjetasCredito) {
        this.tarjetasCredito = tarjetasCredito;
    }

    @PodamExclude
    @OneToOne(mappedBy = "pareja")
    private BodaEntity boda;
    
    @PodamExclude
    @OneToMany(mappedBy = "pareja", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TarjetaCreditoEntity> tarjetasCredito;    
    
    public String getCorreoElec() {
        return correoElec;
    }

    public void setCorreoElec(String correoElec) {
        this.correoElec = correoElec;
    }

    public String getNombreInd1() {
        return nombreInd1;
    }

    public void setNombreInd1(String nombreInd1) {
        this.nombreInd1 = nombreInd1;
    }

    public String getNombreInd2() {
        return nombreInd2;
    }

    public void setNombreInd2(String nombreInd2) {
        this.nombreInd2 = nombreInd2;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombreAbreviado() {
        return nombreAbreviado;
    }

    public void setNombreAbreviado(String nombreAbreviado) {
        this.nombreAbreviado = nombreAbreviado;
    }
    
    
}
