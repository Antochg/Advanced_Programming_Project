<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="model.entity.StudentEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Gestion étudiants</title>
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            font-family: Raleway, sans-serif;
        }

        body {
            background: linear-gradient(90deg, #C7C5F4, #776BCC);
        }
        h2{
            display: flex;
            justify-content: center;
        }
        thead{visibility: hidden;}
        thead tr{
            height: 0px;
        }
        tbody{opacity: 1}
        tr{
            display: flex;
            justify-content: center;
            height: 200px;
            width: 93%;
            margin-bottom: 30px;
            margin-left: auto;
            margin-right: auto;
            border: white 1px solid;
            padding: 12px 12px;
            background-color: lavender;
        }
        #user--info{
            display: flex;
            justify-content: center;
            flex-direction: column;
            width: 220px;
            margin-right: 30px;
        }
        #checked--info{
            width: 180px;
            justify-content: space-between;
            display: flex;
            flex-wrap: wrap;
            margin-right: 30px;
        }
        #date--info, #note--info{
            display: flex;
            justify-content: center;
            flex-direction: column;
            width: 110px;
            margin-right: 30px;
        }
        #supervisor--info{
            display: flex;
            justify-content: center;
            flex-direction: column;
            margin-right: 30px;
        }
        .cta {
            background: #fff;
            font-size: 14px;
            padding: 16px 20px;
            border-radius: 26px;
            border: 1px solid #D4D3E8;
            text-transform: uppercase;
            font-weight: 700;
            display: flex;
            justify-content: center;
            align-items: center;
            width: 100%;
            color: #4C489D;
            box-shadow: 0px 2px 2px #5C5696;
            cursor: pointer;
            transition: .2s;
        }

        .cta:active,
        .cta:focus,
        .cta:hover {
            border-color: #6A679E;
            outline: none;
        }
        .btn{
            margin-top: auto;
            margin-bottom: auto;
        }
        .btn--access{
            margin-right: 20px;
        }
        .btn--save{
            margin-left: auto;
            margin-right: auto;
            margin-bottom: 30px;
            width: 10%;
        }
        a{
            color: #4C489D;
            text-decoration: none;
        }

    </style>
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
        <form class="filter" method="get" action="filter-internships">
            <input type="text" id="search-field" name="name" placeholder="Search by student names">

            <button type="submit">Search</button>
        </form>

        <c:forEach items="${ allInterships }" var="internship">
                <input form="form-internships" type="hidden" name="internshipsIds" value="${internship.idInternship}">
                <tr>
                    <td id="user--info">
                        <label>Groupe</label>
                        <input form="form-internships" type="text" name="internship_${internship.idInternship}_level" value="${internship.student.level}">


                        <label>Nom</label>
                        <input form="form-internships" type="text" name="internship_${internship.idInternship}_name" value="${internship.student.name}">


                        <label>Prénom</label>
                        <input form="form-internships" type="text" name="internship_${internship.idInternship}_lastname" value="${internship.student.lastname}">
                    </td>
                    <td id="checked--info">
                        <label>Cahier des charges</label>
                        <input form="form-internships" type="checkbox" name="internship_${internship.idInternship}_specifications" ${internship.specifications ? "checked" : ""} value="true">
                        <input form="form-internships" type="hidden" name="internship_${internship.idInternship}_specifications" value="false">
                        <br>

                        <label>Fiche visite</label>
                        <input form="form-internships" type="checkbox" name="internship_${internship.idInternship}_visitSheet" ${internship.visitSheet ? "checked" : ""} value="true">
                        <input form="form-internships" type="hidden" name="internship_${internship.idInternship}_visitSheet" value="false">
                        <br>

                        <label>Fiche évaluation</label>
                        <input form="form-internships" type="checkbox" name="internship_${internship.idInternship}_companyEvalSheet" ${internship.companyEvalSheet ? "checked" : ""} value="true">
                        <input form="form-internships" type="hidden" name="internship_${internship.idInternship}_companyEvalSheet" value="false">
                        <br>

                        <label>Sondage web</label>
                        <input form="form-internships" type="checkbox" name="internship_${internship.idInternship}_webSurvey" ${internship.webSurvey ? "checked" : ""} value="true">
                        <input form="form-internships" type="hidden" name="internship_${internship.idInternship}_webSurvey" value="false">
                        <br>

                        <label>Rapport rendu</label>
                        <input form="form-internships" type="checkbox" name="internship_${internship.idInternship}_reportDelivered" ${internship.reportDelivered ? "checked" : ""} value="true">
                        <input form="form-internships" type="hidden" name="internship_${internship.idInternship}_reportDelivered" value="false">
                        <br>

                        <label>Soutenance</label>
                        <input form="form-internships" type="checkbox" name="internship_${internship.idInternship}_presentation" ${internship.presentation ? "checked" : ""} value="true">
                        <input form="form-internships" type="hidden" name="internship_${internship.idInternship}_presentation" value="false">
                        <br>
                        <%-- Visite --%>

                        <label>Visite planifiée</label>
                        <input form="form-internships" type="checkbox" name="internship_${internship.idInternship}_planned" ${internship.planned ? "checked" : ""} value="true">
                        <input form="form-internships" type="hidden" name="internship_${internship.idInternship}_planned" value="false">
                        <br>

                        <label>Visite faite</label>
                        <input form="form-internships" type="checkbox" name="internship_${internship.idInternship}_done" ${internship.done ? "checked" : ""} value="true">
                        <input form="form-internships" type="hidden" name="internship_${internship.idInternship}_done" value="false">
                    </td>
                        <%-- Fin visite --%>
                    <td id="date--info">
                        <label>Date de début</label>
                        <input form="form-internships" type="date" name="internship_${internship.idInternship}_startDate" value="${internship.startDate}">
                        <br><br>

                        <label>Date de fin</label>
                        <input form="form-internships" type="date" name="internship_${internship.idInternship}_endDate" value="${internship.endDate}">
                    </td>
                    <td id="supervisor--info">
                        <label>Maitre de stage :</label>
                        <p>${internship.supervisor}</p>
                    </td>
                    <td id="note--info">
                        <label>Note technique</label>
                        <input form="form-internships" type="text" name="internship_${internship.idInternship}_level" value="${internship.technicalNote}">
                        <br><br>

                        <label>Note de communication</label>
                        <input form="form-internships" type="text" name="internship_${internship.idInternship}_level" value="${internship.communicationNote}">
                    </td>
                    <td class="btn btn--access">
                        <button class="cta">
                            <a class="" href="internship/${internship.idInternship}">Accéder</a>
                        </button>
                    </td>
                    <td class="btn btn--delete">
                        <form method="post" action="delete-internship">
                            <input type="hidden" name="internship_delete" value="${internship.idInternship}">
                            <button class="cta" type="submit">
                                Supprimer
                            </button>
                        </form>
                    </td>
               </tr>
            </c:forEach>
        </tbody>
    </table>

    <form id="form-internships" method="post" action="save-internships">
        <button class="btn--save cta" type="submit">Save</button>
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
