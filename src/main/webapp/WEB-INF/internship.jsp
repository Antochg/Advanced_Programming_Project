<%@ page import="model.entity.StudentEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Detail - {Student}</title>
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

        .container {
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
        }

        .screen {
            background: linear-gradient(90deg, #5D54A4, #7C78B8);
            position: relative;
            width: 1000px;
            box-shadow: 0px 0px 24px #5C5696;
            padding:20px;
        }

        .screen__content {
            z-index: 1;
            position: relative;
            height: 100%;
        }

        .title {
            text-align: center;
            color: #D1D1D4;
        }

        .box {
            display: flex;
            justify-content: flex-start;
            align-items: center;
            background-color: lavender;
            flex-direction: column;
            width: 100%;
            min-height:300px;
            box-shadow: 0px 2px 1px 1px black;
            margin:10px;
            flex: 1 1 250px;
            max-width: 500px;
            min-width: 250px;
            border-radius: 5px;
        }

        .box_title {
            display:flex;
            flex:1;
            flex-direction: column;
            background-color: #c0c0ff;
            width: 100%;
            text-align: center;
            justify-content: center;
            min-height: 50px;
            border-radius: 5px;
            border-end-end-radius: 0px;
            border-end-start-radius: 0px;
        }

        .box_content {
            display:flex;
            flex-direction: column;
            justify-content: center;
            flex:5;
            width: 100%;
        }

        .top_box {
            display: flex;
            flex-direction: row;
            flex-wrap: wrap;
            justify-content: center;
        }

        .bottom_box {
            display: flex;
            flex-direction: row;
        }

        .pfp {
            flex: 3;
            margin: 5px;
            margin-left: auto;
            margin-right: auto;
            width: 60px;
            height: 60px;
            object-fit: contain;
        }

        .attribute {
            display:flex;
            flex: 1;
            flex-direction: row;
            justify-content: space-between;
            width: 80%;
            border-top: 1px solid lightgray;
            padding: 5px;
            margin: auto;
            flex-wrap: wrap;
        }

        .company_name {
            flex: 1;
            margin: 5px;
            margin-left: auto;
            margin-right: auto;
            color: lightseagreen;
            font-size: 20px;
        }

        .centered {
            margin-left: auto;
            margin-right: auto;
        }

        .bold {
            font-weight: bold;
        }

        .address_input {
            width: 150px;
        }

        .separator {
            color: #D1D1D4;
            margin: 20px 20px 10px;
            padding:0;
            border:0;
            border-top: 1px solid #ccc;
        }

        .back_button {
            display: flex;
            width: 60px;
            height: 20px;
            color: #D1D1D4;
            font-size: 17px;
            background-color: transparent;
            text-align: center;
            border: none;
            margin: auto;
        }

        .back_button:hover {
            opacity: 70%;
        }

        .back_button:active {
            opacity: 40%;
        }
    </style>
</head>
<body>
<%@ include file="navbar.jsp" %>
<div class="container">
    <div class="screen">
        <div class="screen__content">
            <h1 class="title">Fiche des détails</h1>
            <hr class="separator">
            <section class="top_box">

                <%-- Student info --%>
                <article class="box">
                    <h2 class="box_title">Détail du stagiaire</h2>
                    <div class="box_content">
                        <img class="pfp" src="https://media.discordapp.net/attachments/1065177544556560394/1084136995359567962/image.png" alt="test">
                        <p class="attribute">
                            <span class="bold">Identifiant</span>
                            <c:out>${requestScope.current_student.getIdStudent()}</c:out>
                        </p>
                        <p class="attribute">
                            <span class="bold">Nom</span>
                            <c:out>${requestScope.current_student.getLastname()}</c:out>
                        </p>
                        <p class="attribute">
                            <span class="bold">Prénom</span>
                            <c:out>${requestScope.current_student.getName()}</c:out>
                        </p>
                        <p class="attribute">
                            <span class="bold">Group</span>
                            <c:out>${requestScope.current_student.getLevel()}</c:out>
                        </p>
                    </div>
                </article>

                <%-- Company info --%>
                <article class="box">
                    <h2 class="box_title">Détail de l'entreprise</h2>
                    <div class="box_content">
                        <p class="company_name bold"><c:out>${requestScope.current_company.getName()}</c:out></p>
                        <p class="attribute">
                            <span class="bold">Adresse de l'entreprise</span>
                            <textarea placeholder="{CompanyAddress}" class="address_input">${requestScope.current_company.getAddress()}</textarea>
                        </p>
                        <p class="attribute">
                            <span class="bold">Maître d'apprentissage</span>
                            <c:out>${requestScope.current_internship.getSupervisor()}</c:out>
                        </p>
                        <p class="attribute">
                            <span class="bold">Date de début</span>
                            <c:out>${requestScope.current_internship.getStartDate()}</c:out>
                        </p>
                        <p class="attribute">
                            <span class="bold">Date de fin</span>
                            <c:out>${requestScope.current_internship.getEndDate()}</c:out>
                        </p>
                    </div>
                </article>

            </section>

            <section class="bottom_box">

                <%-- Internship info --%>
                <article class="box centered">
                    <h2 class="box_title">Gestion du stage</h2>
                    <div class="box_content">
                        <div class="attribute">
                            <span class="bold">Description de la mission</span>
                            <textarea class></textarea>
                        </div>
                        <div class="attribute">
                            <span class="bold">Commentaire</span>
                            <textarea></textarea>
                        </div>
                        <div class="attribute">
                            <span class="bold">Remplir la fiche de visite</span>
                            <span></span>
                        </div>
                    </div>
                </article>
            </section>
            <button type="button" class="back_button">
                <a class="back_button" href="${requestScope.back_path}">Retour</a>
            </button>
        </div>
    </div>
</div>
<br/>

</body>
</html>