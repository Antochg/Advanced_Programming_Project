package com.example.Advanced_Programming_Project;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.beans.InternshipSessionBean;
import model.entity.CompanyEntity;
import model.entity.InternshipEntity;
import model.entity.StudentEntity;
import model.entity.TutorEntity;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/internship/*")
public class InternshipServlet extends HttpServlet {
    @EJB
    InternshipSessionBean internshipSessionBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        TutorEntity tutor = (TutorEntity) session.getAttribute("tutor");

        StudentEntity student;
        InternshipEntity internship;
        CompanyEntity company;

        if(tutor != null) {
            String pathInfo = request.getPathInfo();
            int internshipId = Integer.parseInt(pathInfo.replaceAll("[\\D]", ""));
            //List<InternshipEntity> internships = internshipSessionBean.getAllIntershipsByTutor(tutor.getIdTutor());
            try {
                internship = internshipSessionBean.getInternshipByIdForTutor(internshipId, tutor.getIdTutor());
            } catch(Exception e) {
                throw e;
            }

            student = internship.getStudent();
            company = internship.getCompany();
            if(student.getTutorEntity().equals(tutor)) {
                request.setAttribute("current_student", student);
                request.setAttribute("current_internship", internship);
                request.setAttribute("current_company", company);
            }
            request.setAttribute("back_path", request.getContextPath()+"/gestionServlet");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/internship.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }

    }
}