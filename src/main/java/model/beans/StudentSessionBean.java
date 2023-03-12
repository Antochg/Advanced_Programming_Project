package model.beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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

    public StudentEntity getStudentByNameLastname(String name, String lastname){
        Query q = entityManager.createQuery(
                "select s from StudentEntity s where s.name = ?1 and s.lastname = ?2")
                .setParameter(1, name)
                .setParameter(2, lastname);
        List<StudentEntity> students = q.getResultList();
        return students.size() == 1 ? students.get(0) : null;
    }

    public StudentEntity addStudent(String studentLastname, String studentName, String studentGroup, HttpServletRequest request) {
        entityManager.getTransaction().begin();

        HttpSession session = request.getSession(true);
        TutorEntity tutor = (TutorEntity) session.getAttribute("tutor");

        StudentEntity newStudent = new StudentEntity();
        newStudent.setLastname(studentLastname);
        newStudent.setName(studentName);
        newStudent.setLevel(studentGroup);
        newStudent.setTutor(tutor);

        entityManager.persist(newStudent);
        entityManager.getTransaction().commit();

        return newStudent;
    }
}
