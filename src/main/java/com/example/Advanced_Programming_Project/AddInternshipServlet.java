package com.example.Advanced_Programming_Project;

import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.beans.CompanySessionBean;
import model.beans.InternshipSessionBean;
import model.beans.StudentSessionBean;
import model.beans.TutorBean;
import model.entity.CompanyEntity;
import model.entity.StudentEntity;

import java.io.IOException;

@WebServlet("/add-internship")
public class AddInternshipServlet extends HttpServlet {

    @EJB
    StudentSessionBean studentSessionBean;

    @EJB
    InternshipSessionBean internshipSessionBean;

    @EJB
    CompanySessionBean companySessionBean;

    @Override
    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String studentLastname = request.getParameter("new_student_lastname");
        String studentName = request.getParameter("new_student_name");
        String studentGroup = request.getParameter("new_student_group");

        StudentEntity student = studentSessionBean.addStudent(studentLastname, studentName, studentGroup, request);

        String companyName = request.getParameter("new_company_name");
        String companyAddress = request.getParameter("new_company_address");

        CompanyEntity company = companySessionBean.getCompanyByNameAddress(companyName, companyAddress);
        if(company == null) {
            company = companySessionBean.addCompany(companyName, companyAddress, request);
        }

        String internshipBeginDate = request.getParameter("new_internship_begin_date");
        String internshipEndDate = request.getParameter("new_internship_end_date");
        String internshipSupervisor = request.getParameter("new_internship_supervisor");

        internshipSessionBean.addInternship(internshipBeginDate, internshipEndDate, internshipSupervisor, student, company, request);

        response.sendRedirect(request.getContextPath() + "/gestionServlet");
    }
}

