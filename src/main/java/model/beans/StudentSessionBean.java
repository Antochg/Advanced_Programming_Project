package model.beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import model.entity.StudentEntity;
import model.entity.TutorEntity;

import java.util.List;

@Stateless
public class StudentSessionBean {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<StudentEntity> getAllStudents(){
        Query q = entityManager.createQuery("select e from StudentEntity e");
        return q.getResultList();
    }

    public List<StudentEntity> getAllStudentsByTutor(int tutorId){
        Query q = entityManager.createQuery(
                "select s from StudentEntity s join InternshipEntity i on s.idStudent = i.studentEntity.idStudent where s.tutorEntity.idTutor = ?1")
                .setParameter(1, tutorId);
        List<StudentEntity> students = q.getResultList();
        return students.size() > 1 ? students : null;
    }

    public StudentEntity getStudent(int studentId){
        Query q = entityManager.createQuery(
                        "select s from StudentEntity s join InternshipEntity i on s.idStudent = i.studentEntity.idStudent join CompanyEntity c on c.idCompany = i.companyEntity.idCompany where s.idStudent = ?1")
                .setParameter(1, studentId);
        List<StudentEntity> students = q.getResultList();
        return students.size() == 1 ? students.get(0) : null;
    }
}
