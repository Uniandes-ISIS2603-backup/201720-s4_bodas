/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.persistence;

import co.edu.uniandes.csw.boda.entities.InvitadoEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * @author mf.valllejo
 */
@Stateless
public class InvitadoPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(InvitadoPersistence.class.getName());
    
    @PersistenceContext(unitName = "bodaPU")
    protected EntityManager em;
    
    public InvitadoEntity find(Long id){
        return em.find(InvitadoEntity.class, id);
    }
    
    public List<InvitadoEntity>  findAll(){
        Query q = em.createQuery("select u from InvitadoEntity u");
        return q.getResultList();
    }
    
    public InvitadoEntity create(InvitadoEntity entity) {
        em.persist(entity);
        return entity;
    }
    
    public InvitadoEntity update(InvitadoEntity entity) {
        return em.merge(entity);
    }
    
    public void delete(Long id){
        InvitadoEntity entity = em.find(InvitadoEntity.class, id);
        em.remove(entity);
    }
    
    public InvitadoEntity findByDocumento(Long documento){
        LOGGER.log(Level.INFO, "Consultando invitado por documento ", documento);
        TypedQuery query = em.createQuery("Select e From InvitadoEntity e where e.documento = :documento", InvitadoEntity.class);
        query = query.setParameter("documento", documento);
        List<InvitadoEntity> same = query.getResultList();
        InvitadoEntity result; 
        if (same == null ) {
            result = null;
        } else if (same.isEmpty()) {
             result = null;
        } else {
            result =  same.get(0);
        }
        return result;
    }
}