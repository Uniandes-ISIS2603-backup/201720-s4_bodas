/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.persistence;

import co.edu.uniandes.csw.boda.entities.UbicacionEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.Before;
import org.junit.Test;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;


/**
 *
 * @author vn.gomez
 */
@RunWith(Arquillian.class)
public class UbicacionPersistenceTest {
 
     /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Boda, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(UbicacionEntity.class.getPackage())
                .addPackage(UbicacionPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * Inyección de la dependencia a la clase BodaPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private UbicacionPersistence persistence;

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
        em.createQuery("delete from UbicacionEntity").executeUpdate();
    }

     /**
     * Arreglo que contiene el conjunto de datos de prueba
     */
    private List<UbicacionEntity> data = new ArrayList<UbicacionEntity>();
    
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            UbicacionEntity entity = factory.manufacturePojo(UbicacionEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }

    //public BodaPersistenceTest() {
    //}
    
    //@BeforeClass
    //public static void setUpClass() {
    //}
    
    //@AfterClass
    //public static void tearDownClass() {
    //}
    
    //@After
    //public void tearDown() {
    //}

   

    @Test
    public void createUbicacionEntityTest() {
     PodamFactory factory = new PodamFactoryImpl();
     UbicacionEntity newEntity = factory.manufacturePojo(UbicacionEntity.class);
     UbicacionEntity result = persistence.create(newEntity);

     Assert.assertNotNull(result);
     UbicacionEntity entity = em.find(UbicacionEntity.class, result.getId());
     Assert.assertNotNull(entity);
     Assert.assertEquals(newEntity.getName(), entity.getName());
    }
    
    @Test
public void getBodasTest() {
    List<UbicacionEntity> list = persistence.findAll();
    Assert.assertEquals(data.size(), list.size());
    for (UbicacionEntity ent : list) {
        boolean found = false;
        for (UbicacionEntity entity : data) {
            if (ent.getId().equals(entity.getId())) {
                found = true;
            }
        }
        Assert.assertTrue(found);
    }
}
     @Test
    public void getBodaTest() {
    UbicacionEntity entity = data.get(0);
    UbicacionEntity newEntity = persistence.find(entity.getId());
    Assert.assertNotNull(newEntity);
    Assert.assertEquals(entity.getName(), newEntity.getName());
    }
    
    @Test
    public void getBodaByNameTest() {
    UbicacionEntity entity = data.get(0);
    UbicacionEntity newEntity = persistence.findByName(entity.getName());
    Assert.assertNotNull(newEntity);
    Assert.assertEquals(entity.getName(), newEntity.getName());
}

    @Test
    public void updateBodaTest() {
    UbicacionEntity entity = data.get(0);
    PodamFactory factory = new PodamFactoryImpl();
    UbicacionEntity newEntity = factory.manufacturePojo(UbicacionEntity.class);

    newEntity.setId(entity.getId());

    persistence.update(newEntity);

    UbicacionEntity resp = em.find(UbicacionEntity.class, entity.getId());

    Assert.assertEquals(newEntity.getName(), resp.getName());
    }

    @Test
    public void deleteBodaTest() {
    UbicacionEntity entity = data.get(0);
    persistence.delete(entity.getId());
    UbicacionEntity deleted = em.find(UbicacionEntity.class, entity.getId());
    Assert.assertNull(deleted);
    }
   
}


