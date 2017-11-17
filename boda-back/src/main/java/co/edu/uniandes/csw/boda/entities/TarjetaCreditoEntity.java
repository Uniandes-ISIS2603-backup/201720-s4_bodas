package co.edu.uniandes.csw.boda.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author ca.guerrero
 */
@Entity
public class TarjetaCreditoEntity extends BaseEntity implements Serializable{
    
    /**
     * Atributo privado numero.
     */
    private Long numero;
    /**
     * Atributo privado numDeSeg.
     */
    private int numDeSeg;
    
    /**
     * Atributo privado fechaVen.
     */    
    @Temporal(TemporalType.DATE)
    private Date fechaVen;
    
    /**
     * Atributo privado pareja.
     */    
    @PodamExclude
    @ManyToOne
    private ParejaEntity pareja;
    
    /**
     * Coleccion privada de pagos.
     */   
    @PodamExclude
    @OneToMany(mappedBy = "tarjetaCredito", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PagoEntity> pagos;
    
    /**
     * Obtiene el atributo fechaVen.
     *
     * @return atributo fechaVen.
     */    
    public Date getFechaVen() {
        return fechaVen;
    }
    
    /**
     * Establece el valor del atributo fechaVen.
     *
     * @param fechaVen nuevo valor del atributo
     */
    public void setFechaVen(Date fechaVen) {
        this.fechaVen = fechaVen;
    }
    
    /**
     * Obtiene el atributo numero.
     *
     * @return atributo numero.
     */    
    public Long getNumero() {
        return numero;
    }
    
    /**
     * Establece el valor del atributo numero.
     *
     * @param numero nuevo valor del atributo
     */
    public void setNumero(Long numero) {
        this.numero = numero;
    }
    
    /**
     * Obtiene el atributo numDeSeg.
     *
     * @return atributo numDeSeg.
     */
    public int getNumDeSeg() {
        return numDeSeg;
    }
    
    /**
     * Establece el valor del atributo numDeSeg.
     *
     * @param numDeSeg nuevo valor del atributo
     */
    public void setNumDeSeg(int numDeSeg) {
        this.numDeSeg = numDeSeg;
    }
    
    /**
     * Obtiene la colección de pagos.
     *
     * @return colección pagos.
     */
    public List<PagoEntity> getPagos() {
        return pagos;
    }
    
    /**
     * Establece el valor de la colección de pagos.
     *
     * @param pagos nuevo valor de la colección.
     */
    public void setPagos(List<PagoEntity> pagos) {
        this.pagos = pagos;
    }
    
    /**
     * Obtiene el atributo pareja.
     *
     * @return atributo pareja.
     */
    public ParejaEntity getPareja() {
        return pareja;
    }
    
    /**
     * Establece el valor del atributo pareja.
     *
     * @param pareja nuevo valor del atributo
     */
    public void setPareja(ParejaEntity pareja) {
        this.pareja = pareja;
    }
}