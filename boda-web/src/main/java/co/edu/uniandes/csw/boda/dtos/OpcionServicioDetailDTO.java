/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.dtos;

import co.edu.uniandes.csw.boda.entities.CalificacionEntity;
import co.edu.uniandes.csw.boda.entities.OpcionServicioEntity;
import co.edu.uniandes.csw.boda.entities.TareaEntity;
import java.util.ArrayList;
import java.util.List;




/**
 *
 * @author sp.joven
 */
public class OpcionServicioDetailDTO extends OpcionServicioDTO {
    
    
    List<CalificacionDTO>calificaciones;
    private List<TareaDTO> tareas;
    
     /**
     * Constructor por defecto
     */
    public OpcionServicioDetailDTO(){
        //Constructor por defecto
    }
    
     /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
   
     public OpcionServicioDetailDTO(OpcionServicioEntity entity) {
         super(entity);
         if(entity.getCalificacion()!=null){
             this.calificaciones = new ArrayList<>();
            for (CalificacionEntity ent :  entity.getCalificacion()){
                this.calificaciones.add(new CalificacionDTO(ent));
            }
         }
         if(entity.getTareas()!=null){
             this.tareas = new ArrayList<>();
            for (TareaEntity ent :  entity.getTareas()){
                this.tareas.add(new TareaDTO(ent));
            }
         }
        
    }

    public List<CalificacionDTO> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<CalificacionDTO> calificaciones) {
        this.calificaciones = calificaciones;
    }
     public List<TareaDTO> getTareas() {
        return tareas;
    }

    public void seTareas(List<TareaDTO> tareas) {
        this.tareas = tareas;
    }

    @Override
    public OpcionServicioEntity toEntity() {
        OpcionServicioEntity m = super.toEntity();
        if(calificaciones != null){
            List<CalificacionEntity> lista= new ArrayList<>();
            for (CalificacionDTO c : calificaciones)
            {
                lista.add(c.toEntity());
            }
            m.setCalificacion(lista);
        }
         if(tareas != null){
            List<TareaEntity> lista= new ArrayList<>();
            for (TareaDTO c : tareas)
            {
                lista.add(c.toEntity());
            }
            m.setTareas(lista);
        }
        return m; //To change body of generated methods, choose Tools | Templates.
    }
    
}


