/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.dtos;

import co.edu.uniandes.csw.boda.entities.ParejaEntity;
import co.edu.uniandes.csw.boda.entities.TarjetaCreditoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nf.ortiz
 */
public class ParejaDetailDTO  extends ParejaDTO {
    
    public BodaDTO boda;
    
    public List<TarjetaCreditoDetailDTO> tarjetas;

    public ParejaDetailDTO() {
        //Constructor por defecto
    }

    public ParejaDetailDTO(ParejaEntity pareja) {
        super(pareja);
        if(pareja.getBoda()!=null)this.boda = new BodaDTO(pareja.getBoda());
        if(pareja.getTarjetasCredito()!=null){
            this.tarjetas = new ArrayList<>();
            for(TarjetaCreditoEntity tarjetita: pareja.getTarjetasCredito())
            {
                tarjetas.add(new TarjetaCreditoDetailDTO(tarjetita));
            }
        }
        
    }

    public BodaDTO getBoda() {
        return boda;
    }

    public void setBoda(BodaDTO boda) {
        this.boda = boda;
    }
    
     /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public ParejaEntity toEntity() {
       ParejaEntity parejaE = super.toEntity();
       if(this.boda!=null){
           System.out.println("ParejaDetailDTO.toEntity() " + this.boda);
           parejaE.setBoda(this.boda.toEntity());
       }
       if(this.tarjetas != null){
        List<TarjetaCreditoEntity> tar = new ArrayList<>();
           for(TarjetaCreditoDTO tarjetito: this.tarjetas){
               tar.add(tarjetito.toEntity());
           }
           parejaE.setTarjetasCredito(tar);
       }
        return parejaE;
    }
}
