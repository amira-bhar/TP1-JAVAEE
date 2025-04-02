<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.Cookie" %>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Connexion</title>
</head>
<body>
    <h2>Connexion</h2>

    <%
        String savedUsername = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    savedUsername = cookie.getValue();
                }
            }
        }

        if (request.getParameter("error") != null) {
    %>
        <p style="color: red;">Nom d'utilisateur ou mot de passe incorrect.</p>
    <% } %>

    <form action="login" method="post">
        <label>Nom d'utilisateur :</label>
        <input type="text" name="username" value="<%= (savedUsername != null) ? savedUsername : "" %>" required><br><br>

        <label>Mot de passe :</label>
        <input type="password" name="password" required><br><br>

        <button type="submit">Se connecter</button>
    </form>
</body>
</html>

