<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Ajouter un Produit</title>
</head>
<body>
    <h1>Ajouter un Nouveau Produit</h1>

    <%-- Afficher le message de confirmation s'il existe --%>
    <%
        String successMessage = (String) session.getAttribute("successMessage");
        if (successMessage != null) {
    %>
        <p style="color: green;"><%= successMessage %></p>
    <%
        session.removeAttribute("successMessage"); // Supprimer après affichage
        }
    %>

    <form action="ajouterProduit" method="post">
        <label for="nom">Nom :</label><br>
        <input type="text" id="nom" name="nom" required><br><br>

        <label for="description">Description :</label><br>
        <textarea id="description" name="description" required></textarea><br><br>

        <label for="prix">Prix :</label><br>
        <input type="number" id="prix" name="prix" step="0.01" required><br><br>

        <label for="image">Image :</label><br>
        <input type="text" id="image" name="image" required><br><br>

        <input type="submit" value="Ajouter le Produit">
    </form>

    <br>
    <a href="produits">Retour à la Liste des Produits</a>
</body>
</html>

