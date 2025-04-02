package Com.app.dao;

import Com.app.metier.Produit;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ProduitDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/amitdb";
    private static final String USER = "root";
    private static final String PASSWORD = "amirabdd123*";


    // ✅ Méthode pour récupérer tous les produits
    public List<Produit> getAllProduits() {
        List<Produit> produits = new ArrayList<>();
        String query = "SELECT * FROM produits";

        System.out.println("🔧 Tentative de connexion à la base de données...");

        try (
                Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("🔧 Connexion réussie, récupération des produits...");

            while (rs.next()) {
                Produit produit = new Produit();
                produit.setId(rs.getInt("id"));
                produit.setNom(rs.getString("nom"));
                produit.setDescription(rs.getString("description"));
                produit.setPrix(rs.getBigDecimal("prix"));
                produit.setImage(rs.getString("image"));

                produits.add(produit);
            }

            System.out.println("Nombre de produits récupérés : " + produits.size());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("❌ Erreur lors de la récupération des produits !");
        }
        return produits;
    }




    // ✅ Méthode pour ajouter un produit
    public void ajouterProduit(Produit produit) {
        String query = "INSERT INTO produits (nom, description, prix, image) VALUES (?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, produit.getNom());
            stmt.setString(2, produit.getDescription());
            stmt.setBigDecimal(3, produit.getPrix());
            stmt.setString(4, produit.getImage());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        produit.setId(generatedKeys.getInt(1));
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("❌ Erreur lors de l'ajout du produit !");
        }
    }






}

