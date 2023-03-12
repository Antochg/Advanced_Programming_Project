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
import model.entity.InternshipEntity;
import model.entity.TutorEntity;

import java.io.IOException;
import java.util.List;

@WebServlet("/filter-internships")
public class FilterInternshipsServlet extends HttpServlet  {

    @EJB
    InternshipSessionBean internshipSessionBean;

    @Override
    public void init() {    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(true);

        TutorEntity tutor = (TutorEntity) session.getAttribute("tutor");

        if(tutor != null){
            String name = request.getParameter("name");
            List<InternshipEntity> internships = internshipSessionBean.searchInternships(name, tutor.getIdTutor());
            request.setAttribute("allInterships", internships);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/interships.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
}
