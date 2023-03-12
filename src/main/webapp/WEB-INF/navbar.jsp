<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav>
    <span>${tutor.getName()} ${tutor.getLastname()}</span>
    <button class="">
        <a class="" href="<%=request.getContextPath()%>/logout">Logout</a>
    </button>
</nav>
