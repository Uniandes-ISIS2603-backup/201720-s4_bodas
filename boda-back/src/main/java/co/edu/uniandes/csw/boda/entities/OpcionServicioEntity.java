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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author sp.joven
 */
@Entity
public class OpcionServicioEntity extends BaseEntity implements Serializable {

    /**
     * Atributo privado descripcion.
     */
    private String descripcion;

    /**
     * Atributo privado costo.
     */
    private Long costo;

    /**
     * Atributo privado diasDisponibles.
     */
    private String diasDisponibles;

    /**
     * Atributo privado image.
     */
    private String image;

    /**
     * Coleccion privada de calificacion.
     */
    @OneToMany(mappedBy = "opcionServicio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CalificacionEntity> calificacion;

    /**
     * Atributo privado proveedor.
     */
    @PodamExclude
    @ManyToOne
    private ProveedorEntity proveedor;

    /**
     * Coleccion privada de tareas.
     */
    @PodamExclude
    @OneToMany(mappedBy = "opcionServicio")
    private List<TareaEntity> tareas;

    /**
     * Obtiene el atributo descripcion.
     *
     * @return atributo boda.
     */
    public String getDescripcion() {
        return descripcion;
    }
    
    /**
     * Establece el valor del atributo descripcion.
     *
     * @param descripcion nuevo valor del atributo
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el atributo costo.
     *
     * @return atributo boda.
     */
    public Long getCosto() {
        return costo;
    }
    
    /**
     * Establece el valor del atributo costo.
     *
     * @param costo nuevo valor del atributo
     */
    public void setCosto(Long costo) {
        this.costo = costo;
    }

    /**
     * Obtiene el atributo diasDisponibles.
     *
     * @return atributo boda.
     */
    public String getDiasDisponibles() {
        return diasDisponibles;
    }
    
    /**
     * Establece el valor del atributo diasDisponibles.
     *
     * @param diasDisponibles nuevo valor del atributo
     */
    public void setDiasDisponibles(String diasDisponibles) {
        this.diasDisponibles = diasDisponibles;
    }

    /**
     * Obtiene la colección de calificacion.
     *
     * @return colección tareas.
     */
    public List<CalificacionEntity> getCalificacion() {
        return calificacion;
    }

    /**
     * Establece el valor de la colección de tareas.
     *
     * @param calificacion nuevo valor de la colección.
     */
    public void setCalificacion(List<CalificacionEntity> calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * Obtiene la colección de tareas.
     *
     * @return colección tareas.
     */
    public List<TareaEntity> getTareas() {
        return tareas;
    }

    /**
     * Establece el valor de la colección de tareas.
     *
     * @param tareas nuevo valor de la colección.
     */
    public void setTareas(List<TareaEntity> tareas) {
        this.tareas = tareas;
    }

    /**
     * Obtiene el atributo proveedor.
     *
     * @return atributo boda.
     */
    public ProveedorEntity getProveedor() {
        return proveedor;
    }
    
    /**
     * Establece el valor del atributo proveedor.
     *
     * @param proveedor nuevo valor del atributo
     */
    public void setProveedor(ProveedorEntity proveedor) {
        this.proveedor = proveedor;
    }

    /**
     * Obtiene el atributo image.
     *
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * Establece el valor del atributo image.
     *
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

}
