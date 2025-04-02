<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Accueil</title>
</head>
<body>
    <%
        HttpSession sessionObj = request.getSession(false);
        String username = (sessionObj != null) ? (String) sessionObj.getAttribute("user") : null;

        if (username == null) {
            response.sendRedirect("login.jsp");
            return;
        }
    %>

    <h2>Bienvenue, <%= username %> !</h2>

    <ul>
        <li><a href="produits">Voir les articles</a></li>
        <li><a href="ajouterProduit">Ajouter un produit</a></li>
        <li><a href="logout">Se déconnecter</a></li>
    </ul>
</body>
</html>
