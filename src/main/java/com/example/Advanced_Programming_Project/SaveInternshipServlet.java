package com.example.Advanced_Programming_Project;

import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.beans.InternshipSessionBean;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/save-internship")
public class SaveInternshipServlet extends HttpServlet  {

    @EJB
    InternshipSessionBean internshipSessionBean;

    @Override
    public void init() {    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //IDs de l'ensemble des internships dans le dashboard du tuteur
        //String[] internshipIds = request.getParameterValues("internshipsIds");
        //internshipSessionBean.updateInternships(internshipIds, request);


        Enumeration<String> parameterNames = request.getParameterNames();

        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            System.out.println(paramName +" "+ request.getParameter(paramName));
        }

        response.sendRedirect(request.getContextPath() + "/gestionServlet");
    }
}
