<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            font-family: Raleway, sans-serif;
        }

        .nav {
            display: flex;
            flex-direction: row;
            justify-content: flex-end;
            background-color: #734fbf;
            height: 50px;
            margin-bottom: 20px;
            align-items: center;
        }

        .text {
            color: white;
            font-size: 17px;
            text-align: center;
            text-decoration: none;
        }

        .button {
            display: flex;
            width: 60px;
            height: 20px;
            background-color: transparent;
            border: none;
        }

        .vertical_separator {
            border-left: 2px solid #D1D1D4;
            height: 30px;
            margin: auto 10px auto 10px;
        }
    </style>
</head>
<nav class="nav">
    <span class="text">${tutor.getName()} ${tutor.getLastname()}</span>
    <div class="vertical_separator"></div>
    <button class="button">
        <a class="text" href="<%=request.getContextPath()%>/logout">Logout</a>
    </button>
</nav>
