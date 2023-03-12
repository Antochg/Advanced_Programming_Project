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
import model.beans.StudentSessionBean;
import model.entity.InternshipEntity;
import model.entity.StudentEntity;
import model.entity.TutorEntity;

import java.io.IOException;
import java.util.Collection;

@WebServlet("/gestionServlet")
public class GestionServlet extends HttpServlet {

    @EJB
    InternshipSessionBean internshipSessionBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        TutorEntity tutor = (TutorEntity) session.getAttribute("tutor");

        if(tutor != null){
            Collection<InternshipEntity> interships = internshipSessionBean.getAllIntershipsByTutor(tutor.getIdTutor());
            request.setAttribute("allInterships", interships);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/interships.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
}
