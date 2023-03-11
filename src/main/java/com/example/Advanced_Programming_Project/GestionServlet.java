package com.example.Advanced_Programming_Project;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.beans.StudentSessionBean;
import model.beans.TutorBean;
import model.entity.StudentEntity;
import model.entity.TutorEntity;

import java.io.IOException;
import java.util.List;

@WebServlet("/gestionServlet")
public class GestionServlet extends HttpServlet {

    @EJB
    StudentSessionBean studentSessionBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        int tutorId = (int) session.getAttribute("tutorId");
        List<StudentEntity> students = studentSessionBean.getAllStudents();
//        List<StudentEntity> students = studentSessionBean.getAllStudentsByTutor(tutorId);

        System.out.println(tutorId);
        System.out.println(students.size());

        if(students != null){
            request.setAttribute("students", students);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/interships.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }

    }
}
