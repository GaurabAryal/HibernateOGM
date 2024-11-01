//package com.example.repositories;
//
//import com.example.entities.TestEntity;
//import org.aspectj.weaver.ast.Test;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.List;
//
//@Repository
//public interface TestEntityRepository extends CrudRepository<TestEntity, String> {
//
////    @PersistenceContext
////    private EntityManager entityManager;
//    public static final String NAME = "";
//
//    //    public List<TestEntity> findAll() {
////
//////        List<TestEntity> res = entityManager.createQuery("from TestEntity", TestEntity.class).getResultList();
////
//////        String jpql = "SELECT t FROM TestEntity t";
//////        List<TestEntity> results = entityManager.createQuery(jpql, TestEntity.class).getResultList();
//////        return results;
////        String query1 = "{ $or: [ { email: { $regex: '^alice', $options: 'i' } }, { email: { $regex: '^bob', $options: 'i' } } ] }";
////        List<TestEntity> res = entityManager.createNativeQuery( query1, TestEntity.class ).getResultList();
////        return res;
////    }
////    @Query("{'" + NAME + "': ?0}")
//    @Query("{'email': ?0}")
//    List<TestEntity> findAll();
//
//}
package com.example.repositories;

import com.example.entities.TestEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestEntityRepository extends CrudRepository<TestEntity, String> {

    @Query("SELECT t FROM TestEntity t") // JPQL query
    List<TestEntity> findAll();
}
