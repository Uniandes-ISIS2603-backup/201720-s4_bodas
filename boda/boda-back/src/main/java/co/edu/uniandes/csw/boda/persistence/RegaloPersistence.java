/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.persistence;

import co.edu.uniandes.csw.boda.entities.InvitadoEntity;
import co.edu.uniandes.csw.boda.entities.RegaloEntity;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author mf.valllejo
 */
@Stateless
public class RegaloPersistence {
    private static final Logger LOGGER = Logger.getLogger(RegaloPersistence.class.getName());
    
    @PersistenceContext(unitName = "bodaPU")
    protected EntityManager em;
    
    public RegaloEntity find(Long id){
        return em.find(RegaloEntity.class, id);
    }
    
    public List<RegaloEntity>  findAll(){
        TypedQuery query = em.createQuery("select u from RegaloEntity u", RegaloEntity.class);
        return query.getResultList();
    }
    
    public RegaloEntity create(RegaloEntity entity) {
        em.persist(entity);
        return entity;
    }
    
    public RegaloEntity update(RegaloEntity entity) {
        return em.merge(entity);
    }
    
    public void delete(Long id){
        RegaloEntity entity = em.find(RegaloEntity.class, id);
        em.remove(entity);
    }
}