package com.hualuo.service.gitlab;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author Joseph
 * @create 2018/12/01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EclipseJpaTest {

    @PersistenceContext
    EntityManager entityManager;

    @Test
    public void testEclipseLink() throws Exception {
        assertNotNull(entityManager);
        Map<String, Object> properties = entityManager.getProperties();
        properties.forEach((k, v) -> {
            System.out.print(k);
            System.out.print(" ====> ");
            System.out.println(v);
        });
        String ddl = (String) properties.get("eclipselink.ddl-generation");
        assertNotNull(ddl);
        assertEquals("create-or-extend-tables", ddl);
        System.out.println("=====================");
        System.out.println("Eclipselink Test PASSED!");
    }
}
