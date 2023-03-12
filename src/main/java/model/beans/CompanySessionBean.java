package model.beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import model.entity.CompanyEntity;
import model.entity.StudentEntity;
import model.entity.TutorEntity;

import java.util.List;

@Stateless
public class CompanySessionBean {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public CompanyEntity getCompanyByNameAddress(String name, String address){
        Query q = entityManager.createQuery(
                        "select c from CompanyEntity c where c.name = ?1 and c.address = ?2")
                .setParameter(1, name)
                .setParameter(2, address);
        List<CompanyEntity> company = q.getResultList();
        return company.size() == 1 ? company.get(0) : null;
    }

    public CompanyEntity addCompany(String companyName, String companyAddress, HttpServletRequest request) {
        entityManager.getTransaction().begin();

        CompanyEntity company = new CompanyEntity();

        company.setName(companyName);
        company.setAddress(companyAddress);

        entityManager.persist(company);
        entityManager.getTransaction().commit();

        return company;
    }
}
