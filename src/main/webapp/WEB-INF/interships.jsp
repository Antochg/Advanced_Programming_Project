<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
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
        <a class="" href="logout">Logout*</a>
    </button>
    <table>
        <thead>
            <th>Gr</th>
            <th>NOM</th>
            <th>CdC</th>
            <th>Fiche visite</th>
            <th>Fiche eval entr</th>
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
            <th>ADRESSE</th>
            <th>NOTE</th>
            <th>TECH</th>
            <th>NOTE</th>
            <th>COM</th>
        </thead>

<%--        <tbody>--%>
<%--            <c:forEach items="${ employees }" var="employee">--%>
<%--                <tr>--%>
<%--                    <td><c:out value = "${employee.id}"/></td>--%>
<%--                    <td>Maria Anders</td>--%>
<%--                    <td>Germany</td>--%>
<%--                    <td>Maria Anders</td>--%>
<%--                    <td>Germany</td>--%>
<%--                    <td>Maria Anders</td>--%>
<%--                    <td>Germany</td>--%>
<%--                    <td>Maria Anders</td>--%>
<%--                    <td>Germany</td>--%>
<%--                    <td>Germany</td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>
<%--        </tbody>--%>
    </table>

</body>
</html>
