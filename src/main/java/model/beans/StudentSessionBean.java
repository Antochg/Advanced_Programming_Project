package model.beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import model.entity.StudentEntity;

import java.util.List;

@Stateless
public class StudentSessionBean {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<StudentEntity> getAllStudents(){
        Query q = entityManager.createQuery("select e from StudentEntity e");
        return q.getResultList();
    }
}
