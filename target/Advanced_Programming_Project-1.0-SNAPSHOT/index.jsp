<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>TP2</title>
    </head>

    <body>
        <form name="frm_index" action="login-servlet" method="POST">
            <label>Login : </label><input type="text" name="loginForm" /><br />
            <label>Password : </label><input type="text" name="passForm" /><br />
            <input type="submit" name="btn_Send" value="Send" />
        </form>
    </body>
</html>