package model.beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import jakarta.servlet.http.HttpServletRequest;
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

        }
        entityManager.getTransaction().commit();
    }
}
