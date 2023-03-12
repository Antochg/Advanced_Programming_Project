package com.example.Advanced_Programming_Project;

import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.beans.InternshipSessionBean;

import java.io.IOException;

@WebServlet("/delete-internship")
public class DeleteInternshipServlet extends HttpServlet  {

    @EJB
    InternshipSessionBean internshipSessionBean;

    @Override
    public void init() {    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int internshipId = Integer.parseInt(request.getParameter("internship_delete"));
        System.out.println(internshipId);
        boolean deleted = internshipSessionBean.deleteInternship(internshipId);
        System.out.println(deleted);
        response.sendRedirect(request.getContextPath() + "/gestionServlet");
    }


}
