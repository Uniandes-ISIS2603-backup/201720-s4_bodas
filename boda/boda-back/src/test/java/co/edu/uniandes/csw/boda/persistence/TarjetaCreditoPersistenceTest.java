/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.persistence;

import co.edu.uniandes.csw.boda.entities.TarjetaCreditoEntity;
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
 * @author ca.guerrero
 */
@RunWith(Arquillian.class)

public class TarjetaCreditoPersistenceTest {
    /**
     * Inyección de la dependencia a la clase TarjetaCreditoPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private TarjetaCreditoPersistence persistence;

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
    private List<TarjetaCreditoEntity> data = new ArrayList<TarjetaCreditoEntity>();
    
    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Pago, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(TarjetaCreditoEntity.class.getPackage())
                .addPackage(TarjetaCreditoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    public TarjetaCreditoPersistenceTest() {
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
     em.createQuery("delete from TarjetaCreditoEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            TarjetaCreditoEntity entity = factory.manufacturePojo(TarjetaCreditoEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class TarjetaCreditoPersistence.
     */
    @Test
    public void createTarjetaEntityTest() {
    PodamFactory factory = new PodamFactoryImpl();
    TarjetaCreditoEntity newEntity = factory.manufacturePojo(TarjetaCreditoEntity.class);
    TarjetaCreditoEntity result = persistence.create(newEntity);
    Assert.assertNotNull(result);
    TarjetaCreditoEntity entity = em.find(TarjetaCreditoEntity.class, result.getId());
    Assert.assertNotNull(entity);
    Assert.assertEquals(newEntity.getNumDeSeg(), entity.getNumDeSeg());
    }

    /**
     * Test of update method, of class TarjetaCreditoPersistence.
     */
    @Test
    public void updateTarjetaCreditoEntityTest()  {
    TarjetaCreditoEntity entity = data.get(0);
    PodamFactory factory = new PodamFactoryImpl();
    TarjetaCreditoEntity newEntity = factory.manufacturePojo(TarjetaCreditoEntity.class);

    newEntity.setId(entity.getId());

    persistence.update(newEntity);

    TarjetaCreditoEntity resp = em.find(TarjetaCreditoEntity.class, entity.getId());

    Assert.assertEquals(newEntity.getNumDeSeg(), resp.getNumDeSeg());
    }

    /**
     * Test of delete method, of class TarjetaCreditoPersistence.
     */
    @Test
    public void deleteTarjetaCreditoTest()  {
    TarjetaCreditoEntity entity = data.get(0);
    persistence.delete(entity.getId());
    TarjetaCreditoEntity deleted = em.find(TarjetaCreditoEntity.class, entity.getId());
    Assert.assertNull(deleted);
    }

    /**
     * Test of find method, of class TarjetaCreditoPersistence.
     */
    @Test
    public void findTarjetaCretidoTest()  {
    TarjetaCreditoEntity entity = data.get(0);
    TarjetaCreditoEntity newEntity = persistence.find(entity.getId());
    Assert.assertNotNull(newEntity);
    Assert.assertEquals(entity.getNumDeSeg(), newEntity.getNumDeSeg());
    }

    /**
     * Test of findAll method, of class TarjetaCreditoPersistence.
     */
    @Test
    public void findAllTarjetaCreditoTest()  {
        List<TarjetaCreditoEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (TarjetaCreditoEntity ent : list) {
        boolean found = false;
        for (TarjetaCreditoEntity entity : data) {
            if (ent.getId().equals(entity.getId())) {
                found = true;
            }
        }
        Assert.assertTrue(found);
    }
    }
}