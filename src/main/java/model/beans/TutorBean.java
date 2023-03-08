package model.beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import model.entity.TutorEntity;

@Stateless
public class TutorBean {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public TutorBean() {}

    public TutorEntity getTutor(String login, String password) {
        Query query = entityManager.createQuery("SELECT t FROM TutorEntity t WHERE t.login = ?1 AND t.password = ?2")
                .setParameter(1, login)
                .setParameter(2, password);
        TutorEntity tutor = (TutorEntity) query.getSingleResult();
        return tutor;
    }
}
