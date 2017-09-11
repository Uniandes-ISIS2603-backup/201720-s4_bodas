/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.persistence;

import co.edu.uniandes.csw.boda.entities.RegaloEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author mf.valllejo
 */
public class RegaloPersistenceTest {
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(RegaloEntity.class.getPackage())
                .addPackage(RegaloPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    public RegaloPersistenceTest() {
    }
    
    /**
     * Inyección de la dependencia a la clase XYZPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private RegaloPersistence persistence;

    /**
     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
     * datos por fuera de los métodos que se están probando.
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Variable para martcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction utx;

     /**
     *
     */
    private List<RegaloEntity> data = new ArrayList<RegaloEntity>();
    
    @Before
    public void setUp() {
        try {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    
    private void clearData() {
        em.createQuery("delete from RegaloEntity").executeUpdate();
    }


    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            RegaloEntity entity = factory.manufacturePojo(RegaloEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Test of find method, of class RegaloPersistence.
     */
    @Test
    public void testFind() throws Exception {
        RegaloEntity entity = data.get(0);
        RegaloEntity newEntity = persistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }

    /**
     * Test of findAll method, of class RegaloPersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        List<RegaloEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (RegaloEntity ent : list) {
            boolean found = false;
            for (RegaloEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Test of create method, of class RegaloPersistence.
     */
    @Test
    public void testCreate() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        RegaloEntity newEntity = factory.manufacturePojo(RegaloEntity.class);
        RegaloEntity result = persistence.create(newEntity);

        Assert.assertNotNull(result);
        RegaloEntity entity = em.find(RegaloEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }

    /**
     * Test of update method, of class RegaloPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        RegaloEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        RegaloEntity newEntity = factory.manufacturePojo(RegaloEntity.class);

        newEntity.setId(entity.getId());

        persistence.update(newEntity);

        RegaloEntity resp = em.find(RegaloEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
    }

    /**
     * Test of Delete method, of class RegaloPersistence.
     */
    @Test
    public void testDelete() throws Exception {
        RegaloEntity entity = data.get(0);
        persistence.delete(entity.getId());
        RegaloEntity deleted = em.find(RegaloEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
}
