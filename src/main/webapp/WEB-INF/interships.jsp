<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="model.entity.StudentEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Gestion étudiants</title>
</head>
<body>
    <%@ include file="navbar.jsp" %>
    <h2>Tableau affichage étudiants</h2>
    <table>
        <thead>
            <th>Groupe</th>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Cahier des Charges</th>
            <th>Fiche visite</th>
            <th>Fiche évaluation</th>
            <th>Sondage web</th>
            <th>Rappport rendu</th>
            <th>Soutenance</th>
            <%-- Visite --%>
            <th>Visite planifiée</th>
            <th>Visite faite</th>
            <%-- Fin visite --%>
            <th>Debut</th>
            <th>Fin</th>
            <th>Entr.</th>
            <th>MdS</th>
            <th>Adresse</th>
            <th>Note technique</th>
            <th>Note communication</th>
            <th></th>
            <th></th>
        </thead>

        <tbody>
            <c:forEach items="${ allInterships }" var="internship">
                <input form="form-internships" type="hidden" name="internshipsIds" value="${internship.idInternship}">
                <tr>
                    <td>
                        <input form="form-internships" type="text" name="internship_${internship.idInternship}_level" value="${internship.student.level}">
                    </td>
                    <td>
                        <input form="form-internships" type="text" name="internship_${internship.idInternship}_name" value="${internship.student.name}">
                    </td>
                    <td>
                        <input form="form-internships" type="text" name="internship_${internship.idInternship}_lastname" value="${internship.student.lastname}">
                    </td>
                    <td>
                        <input form="form-internships" type="checkbox" name="internship_${internship.idInternship}_specifications" ${internship.specifications ? "checked" : ""} value="true">
                        <input form="form-internships" type="hidden" name="internship_${internship.idInternship}_specifications" value="false">
                    </td>
                    <td>
                        <input form="form-internships" type="checkbox" name="internship_${internship.idInternship}_visitSheet" ${internship.visitSheet ? "checked" : ""} value="true">
                        <input form="form-internships" type="hidden" name="internship_${internship.idInternship}_visitSheet" value="false">
                    </td>
                    <td>
                        <input form="form-internships" type="checkbox" name="internship_${internship.idInternship}_companyEvalSheet" ${internship.companyEvalSheet ? "checked" : ""} value="true">
                        <input form="form-internships" type="hidden" name="internship_${internship.idInternship}_companyEvalSheet" value="false">
                    </td>
                    <td>
                        <input form="form-internships" type="checkbox" name="internship_${internship.idInternship}_webSurvey" ${internship.webSurvey ? "checked" : ""} value="true">
                        <input form="form-internships" type="hidden" name="internship_${internship.idInternship}_webSurvey" value="false">
                    </td>
                    <td>
                        <input form="form-internships" type="checkbox" name="internship_${internship.idInternship}_reportDelivered" ${internship.reportDelivered ? "checked" : ""} value="true">
                        <input form="form-internships" type="hidden" name="internship_${internship.idInternship}_reportDelivered" value="false">
                    </td>
                    <td>
                        <input form="form-internships" type="checkbox" name="internship_${internship.idInternship}_presentation" ${internship.presentation ? "checked" : ""} value="true">
                        <input form="form-internships" type="hidden" name="internship_${internship.idInternship}_presentation" value="false">
                    </td>
                        <%-- Visite --%>
                    <td>
                        <input form="form-internships" type="checkbox" name="internship_${internship.idInternship}_planned" ${internship.planned ? "checked" : ""} value="true">
                        <input form="form-internships" type="hidden" name="internship_${internship.idInternship}_planned" value="false">
                    </td>
                    <td>
                        <input form="form-internships" type="checkbox" name="internship_${internship.idInternship}_done" ${internship.done ? "checked" : ""} value="true">
                        <input form="form-internships" type="hidden" name="internship_${internship.idInternship}_done" value="false">
                    </td>
                        <%-- Fin visite --%>
                    <td>
                        <input form="form-internships" type="date" name="internship_${internship.idInternship}_startDate" value="${internship.startDate}">
                    </td>
                    <td>
                        <input form="form-internships" type="date" name="internship_${internship.idInternship}_endDate" value="${internship.endDate}">
                    </td>
                    <td>Entr.</td>
                    <td>MdS</td>
                    <td>Adresse</td>
                    <td>Note technique</td>
                    <td>Note communication</td>
                    <td>
                        <button>
                            <a class="" href="internship/${internship.idInternship}">Accéder</a>
                        </button>
                    </td>
                    <td>
                        <form method="post" action="delete-internship">
                            <input type="hidden" name="internship_delete" value="${internship.idInternship}">
                            <button type="submit">
                                Supprimer
                            </button>
                        </form>
                    </td>
               </tr>
            </c:forEach>
        </tbody>
    </table>

    <form id="form-internships" method="post" action="save-internships">
        <button type="submit">Save</button>
    </form>

    <form id="add-form-internships" method="post" action="add-internship" style="display:none">
        <label>Etudiant</label>
        <input form="add-form-internships" type="text" name="new_student_lastname" value="" placeholder="Nom">
        <input form="add-form-internships" type="text" name="new_student_name" value="" placeholder="Prénom">
        <input form="add-form-internships" type="text" name="new_student_group" value="" placeholder="Groupe">

        <label>Entreprise</label>
        <input form="add-form-internships" type="text" name="new_company_name" value="" placeholder="Nom">
        <input form="add-form-internships" type="text" name="new_company_address" value="" placeholder="Adresse">

        <label>Stage</label>
        <input form="add-form-internships" type="date" name="new_internship_begin_date" value="" placeholder="Date de début">
        <input form="add-form-internships" type="date" name="new_internship_end_date" value="" placeholder="Date de fin">
        <input form="add-form-internships" type="text" name="new_internship_supervisor" value="" placeholder="Maître de stage">
        <button type="submit">Sauvegarder</button>
    </form>

    <button type="button" onclick="showAddForm()">Ajouter un étudiant</button>

</body>
</html>

<script>
    function showAddForm() {
        let x = document.getElementById("add-form-internships");
        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
    }
</script>
