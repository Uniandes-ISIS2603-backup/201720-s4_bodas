package co.edu.uniandes.csw.boda.entities;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author ca.guerrero
 */
@Entity
public class PagoEntity extends BaseEntity implements Serializable{
    private Double montoTotal;
    
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    /**
     * Atributo privado tarjetaCredito.
     */
    @PodamExclude
    @ManyToOne
    private TarjetaCreditoEntity tarjetaCredito;
    
    /**
     * Atributo privado opcionServicio.
     */
    @PodamExclude
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="opcionServicio_id")
    private OpcionServicioEntity opcionServicio;

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public TarjetaCreditoEntity getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(TarjetaCreditoEntity tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public OpcionServicioEntity getOpcionServicio() {
        return opcionServicio;
    }

    public void setOpcionServicio(OpcionServicioEntity opcionServicio) {
        this.opcionServicio = opcionServicio;
    }
}