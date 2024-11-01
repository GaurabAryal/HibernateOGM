package com.example;

import com.example.entities.TestEntity;
import org.bson.types.ObjectId;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan({"com.example.controllers", "com.example.repositories", "com.example.config"})
@EnableJpaRepositories(basePackages = "com.example.repositories")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ogm-mongodb");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        TestEntity entity = new TestEntity();
        entity.setId(ObjectId.get());
        entity.setEmail("foo@foobar.com");
        em.persist(entity);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}