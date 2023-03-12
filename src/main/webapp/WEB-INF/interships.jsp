<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="model.entity.StudentEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Gestion étudiants</title>
</head>
<body>
    <h2>Tableau affichage étudiants</h2>
    <button class="">
        <a class="" href="logout">Logout</a>
    </button>
    <table>
        <thead>
            <th>Groupe</th>
            <th>Nom</th>
            <th>Prénom</th>
            <th>CdC</th>
            <th>Fiche visite</th>
            <th>Fiche eval</th>
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
        </thead>

        <tbody>
            <c:forEach items="${ allInterships }" var="interships">
                <tr>
                    <td><c:out value = "${interships.student.level}"/></td>
                    <td><c:out value = "${interships.student.lastname}"/></td>
                    <td><c:out value = "${interships.student.name}"/></td>
                    <td>CdC</td>
                    <td><input type="checkbox" <c:out value="${interships.visitSheet}"/>><c:out value="${interships.visitSheet ? 'true' : 'false'}"/></td>
                    <td>Fiche eval</td>
                    <td>Sondage web</td>
                    <td>Rappport rendu</td>
                    <td>Soutenance</td>
                        <%-- Visite --%>
                    <td>Visite planifiée</td>
                    <td>Visite faite</td>
                        <%-- Fin visite --%>
                    <td>Debut</td>
                    <td>Fin</td>
                    <td>Entr.</td>
                    <td>MdS</td>
                    <td>Adresse</td>
                    <td>Note technique</td>
                    <td>Note communication</td>
               </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
