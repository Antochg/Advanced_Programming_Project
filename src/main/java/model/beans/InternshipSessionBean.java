package model.beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import jakarta.servlet.http.HttpServletRequest;
import model.entity.CompanyEntity;
import model.entity.InternshipEntity;
import model.entity.StudentEntity;

import java.sql.Date;
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

    public void updateInternships(String[] internshipIds, HttpServletRequest request){
        entityManager.getTransaction().begin();

        for (String internshipId : internshipIds) {
            InternshipEntity internship = entityManager.createQuery("select i from InternshipEntity i where i.idInternship = ?1", InternshipEntity.class)
                    .setParameter(1, Integer.parseInt(internshipId))
                    .getSingleResult();

            internship.getStudent().setLevel(request.getParameter("internship_" + internshipId + "_level"));
            internship.getStudent().setName(request.getParameter("internship_" + internshipId + "_name"));
            internship.getStudent().setLastname(request.getParameter("internship_" + internshipId + "_lastname"));
            internship.setSpecifications(Boolean.parseBoolean(request.getParameter("internship_" + internshipId + "_specifications")));
            internship.setVisitSheet(Boolean.parseBoolean(request.getParameter("internship_" + internshipId + "_visitSheet")));
            internship.setCompanyEvalSheet(Boolean.parseBoolean(request.getParameter("internship_" + internshipId + "_companyEvalSheet")));
            internship.setWebSurvey(Boolean.parseBoolean(request.getParameter("internship_" + internshipId + "_webSurvey")));
            internship.setReportDelivered(Boolean.parseBoolean(request.getParameter("internship_" + internshipId + "_reportDelivered")));
            internship.setPresentation(Boolean.parseBoolean(request.getParameter("internship_" + internshipId + "_presentation")));
            internship.setPlanned(Boolean.parseBoolean(request.getParameter("internship_" + internshipId + "_planned")));
            internship.setDone(Boolean.parseBoolean(request.getParameter("internship_" + internshipId + "_done")));
            internship.setStartDate(Date.valueOf(request.getParameter("internship_" + internshipId + "_startDate")));
            internship.setEndDate(Date.valueOf(request.getParameter("internship_" + internshipId + "_endDate")));
        }
        entityManager.getTransaction().commit();
    }

    public void editInternshipManagement(InternshipEntity internship, String missionDescription, String comment, HttpServletRequest request) {
        entityManager.getTransaction().begin();

        internship.setMissionDescription(missionDescription);
        internship.setComments(comment);

        entityManager.persist(internship);
        entityManager.getTransaction().commit();
    }

    public void addInternship(String internshipBeginDate, String internshipEndDate, String internshipSupervisor, StudentEntity student, CompanyEntity company, HttpServletRequest request){
        entityManager.getTransaction().begin();

        InternshipEntity internship = new InternshipEntity();

        internship.setSpecifications(false);
        internship.setVisitSheet(false);
        internship.setCompanyEvalSheet(false);
        internship.setWebSurvey(false);
        internship.setReportDelivered(false);
        internship.setPresentation(false);
        internship.setPlanned(false);
        internship.setDone(false);
        internship.setStartDate(Date.valueOf(internshipBeginDate));
        internship.setEndDate(Date.valueOf(internshipEndDate));
        internship.setSupervisor(internshipSupervisor);
        internship.setCompany(company);
        internship.setStudent(student);

        entityManager.persist(internship);
        entityManager.getTransaction().commit();
    }

    public boolean deleteInternship(int internshipId) {
        entityManager.getTransaction().begin();
        InternshipEntity internship = entityManager.find(InternshipEntity.class, internshipId);

        if(internship != null){
            entityManager.remove(internship);
            entityManager.getTransaction().commit();
            return true;
        } else {
            entityManager.getTransaction().rollback();
            return false;
        }
    }
}
