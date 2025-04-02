
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Liste des Produits</title>
</head>
<body>
    <h1>Liste des Produits</h1>
    <table border="1">
        <tr>
            <th>Nom</th><th>Description</th><th>Prix</th><th>Image</th>
        </tr>
        <c:forEach var="produit" items="${produits}">
            <tr>
                <td>${produit.nom}</td>
                <td>${produit.description}</td>
                <td>${produit.prix} €</td>
                <td>${produit.image}</td>
            </tr>
        </c:forEach>
    </table>
 <a href="home.jsp">Retour à home</a>
</body>
</html>