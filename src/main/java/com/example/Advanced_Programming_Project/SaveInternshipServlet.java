package com.example.Advanced_Programming_Project;

import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.beans.InternshipSessionBean;
import model.entity.InternshipEntity;
import model.entity.TutorEntity;

import java.io.IOException;
import java.util.Enumeration;

import static java.lang.Integer.parseInt;

@WebServlet("/save-internship")
public class SaveInternshipServlet extends HttpServlet  {

    @EJB
    InternshipSessionBean internshipSessionBean;

    @Override
    public void init() {    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(true);
        TutorEntity tutor = (TutorEntity) session.getAttribute("tutor");

        int internshipId = parseInt(request.getParameter("id"));
        String missionDescription = request.getParameter("missionDescription");
        String comment = request.getParameter("comment");

        InternshipEntity internship = internshipSessionBean.getInternshipByIdForTutor(internshipId, tutor.getIdTutor());

        internshipSessionBean.editInternshipManagement(internship, missionDescription, comment, request);

        response.sendRedirect(request.getContextPath() + "/gestionServlet");
    }
}
