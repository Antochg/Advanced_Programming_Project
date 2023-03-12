package model.beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import model.entity.InternshipEntity;
import model.entity.StudentEntity;

import java.util.List;

@Stateless
public class InternshipSessionBean {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<InternshipEntity> getAllIntershipsByTutor(int tutorId){
        Query q = entityManager.createQuery(
                "select i from InternshipEntity i join i.student s join s.tutor t where t.idTutor = ?1", InternshipEntity.class)
                .setParameter(1, tutorId);
        List<InternshipEntity> internships = q.getResultList();
        return internships.size() > 0 ? internships : null;
    }

    public InternshipEntity getInternshipByIdForTutor(int internshipId, int tutorId) {
        Query q = entityManager.createQuery(
                        "select i from InternshipEntity i join i.student s join s.tutor t where t.idTutor = ?1 and i.idInternship = ?2", InternshipEntity.class)
                .setParameter(1, tutorId)
                .setParameter(2, internshipId);
        InternshipEntity internship = (InternshipEntity) q.getSingleResult();

        return internship;
    }
}
