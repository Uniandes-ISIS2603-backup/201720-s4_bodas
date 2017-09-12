/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.persistence;

import co.edu.uniandes.csw.boda.entities.OpcionServicioEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author sp.joven
 */

@RunWith(Arquillian.class)
public class OpcionServicioPersistenceTest {
    
     /**
     * Inyección de la dependencia a la clase OpcionServicioPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private OpcionServicioPersistence persistence;
    /**
     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
     * datos por fuera de los métodos que se están probando.
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Variable para marcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction utx;

     /**
     *
     */
    private List<OpcionServicioEntity> data = new ArrayList<OpcionServicioEntity>();
    
    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de OpcionServicio, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(OpcionServicioEntity.class.getPackage())
                .addPackage(OpcionServicioPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    @Test
    public void createOpcionServicioEntityTest() {
    PodamFactory factory = new PodamFactoryImpl();
    OpcionServicioEntity newEntity = factory.manufacturePojo(OpcionServicioEntity.class);
    OpcionServicioEntity result = persistence.create(newEntity);

    Assert.assertNotNull(result);
    OpcionServicioEntity entity = em.find(OpcionServicioEntity.class, result.getId());
    Assert.assertNotNull(entity);
    Assert.assertEquals(newEntity.getName(), entity.getName());
}
     @Test
     public void getOpcionServiciosTest() {
    List<OpcionServicioEntity> list = persistence.findAll();
    Assert.assertEquals(data.size(), list.size());
    for (OpcionServicioEntity ent : list) {
        boolean found = false;
        for (OpcionServicioEntity entity : data) {
            if (ent.getId().equals(entity.getId())) {
                found = true;
            }
        }
        Assert.assertTrue(found);
    }
}
    @Test
    public void updateOpcionServicioTest() {
    OpcionServicioEntity entity = data.get(0);
    PodamFactory factory = new PodamFactoryImpl();
    OpcionServicioEntity newEntity = factory.manufacturePojo(OpcionServicioEntity.class);
    newEntity.setId(entity.getId());
    persistence.update(newEntity);
    OpcionServicioEntity resp = em.find(OpcionServicioEntity.class, entity.getId());
    Assert.assertEquals(newEntity.getName(), resp.getName());
}
    @Test
    public void getOpcionServicioByNameTest() {
    OpcionServicioEntity entity = data.get(0);
    OpcionServicioEntity newEntity = persistence.findByName(entity.getName());
    Assert.assertNotNull(newEntity);
    Assert.assertEquals(entity.getName(), newEntity.getName());
}
    @Test
    public void deleteOpcionServicioTest() {
    OpcionServicioEntity entity = data.get(0);
    persistence.delete(entity.getId());
    OpcionServicioEntity deleted = em.find(OpcionServicioEntity.class, entity.getId());
    Assert.assertNull(deleted);
}
    @Test
    public void getOpcionServicioTest() {
    OpcionServicioEntity entity = data.get(0);
    OpcionServicioEntity newEntity = persistence.find(entity.getId());
    Assert.assertNotNull(newEntity);
    Assert.assertEquals(entity.getName(), newEntity.getName());
    }
    
    public OpcionServicioPersistenceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    
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
        em.createQuery("delete from OpcionServicioEntity").executeUpdate();
    }


 private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            OpcionServicioEntity entity = factory.manufacturePojo(OpcionServicioEntity.class);

            em.persist(entity);
            data.add(entity);
        }
 } 
    @After
    public void tearDown() {
    }
      
}