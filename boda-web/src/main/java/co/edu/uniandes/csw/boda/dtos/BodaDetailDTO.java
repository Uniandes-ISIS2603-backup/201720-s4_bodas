/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.dtos;

import co.edu.uniandes.csw.boda.entities.BodaEntity;
import co.edu.uniandes.csw.boda.entities.InvitadoEntity;
import co.edu.uniandes.csw.boda.entities.RegaloEntity;
import co.edu.uniandes.csw.boda.entities.TareaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vn.gomez
 */
public class BodaDetailDTO extends BodaDTO{
    
    private List<RegaloDTO> regalos;
    private List<InvitadoDTO> invitados;
    private List<TareaDTO> tareas;
    /**
     * Constructor por defecto
     */
    public BodaDetailDTO(){
       //Constructor por defecto
    }
    
     /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public BodaDetailDTO( BodaEntity entity) {
        super(entity);
        if (entity.getRegalos() != null) {
            regalos = new ArrayList<>();
            for (RegaloEntity entityRegalo : entity.getRegalos()) {
                regalos.add(new RegaloDTO(entityRegalo));
            }
        }
         if (entity.getInvitados() != null) {
            invitados = new ArrayList<>();
            for (InvitadoEntity entityInvitado : entity.getInvitados()) {
                invitados.add(new InvitadoDTO(entityInvitado));
            }
        }
         if (entity.getTareas() != null) {
            tareas = new ArrayList<>();
            for (TareaEntity entityTarea : entity.getTareas()) {
                tareas.add(new TareaDTO(entityTarea));
            }
        }

    }
    
    
    @Override
    public BodaEntity toEntity() {
        BodaEntity bodaE = super.toEntity();
        if (regalos != null) {
            List<RegaloEntity> regalosEntity = new ArrayList<>();
            for (RegaloDTO dtoRegalo : regalos) {
                regalosEntity.add(dtoRegalo.toEntity());
            }
            bodaE.setRegalos(regalosEntity);
        }
        if (invitados != null) {
            List<InvitadoEntity> invitadosEntity = new ArrayList<>();
            for (InvitadoDTO dtoInvitado : invitados) {
                invitadosEntity.add(dtoInvitado.toEntity());
            }
            bodaE.setInvitados(invitadosEntity);
        }
        if (tareas != null) {
            List<TareaEntity> tareasEntity = new ArrayList<>();
            for (TareaDTO dtoTarea : tareas) {
                tareasEntity.add(dtoTarea.toEntity());
            }
            bodaE.setTareas(tareasEntity);
        }
        return bodaE;
    }

    public List<RegaloDTO> getRegalos() {
        return regalos;

    }

    public void setRegalos(List<RegaloDTO> regalos) {
        this.regalos = regalos;
    }

    public List<InvitadoDTO> getInvitados() {
        return invitados;
    }

    public void setInvitados(List<InvitadoDTO> invitados) {
        this.invitados = invitados;
    }

    public List<TareaDTO> getTareas() {
        return tareas;
    }

    public void setTareas(List<TareaDTO> tareas) {
        this.tareas = tareas;
    }
    
    

    
}
