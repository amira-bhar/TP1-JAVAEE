import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testmsql {
    public static void main(String[] args) {
        // URL de connexion à MySQL
        String url = "jdbc:mysql://localhost:3306/amitdb"; // Remplace 'testdb' par le nom de ta base
        String user = "root"; // Remplace par ton utilisateur MySQL
        String password = "Android123&"; // Remplace par ton mot de passe MySQL

        try {
            // Charger le driver JDBC (facultatif pour les nouvelles versions de Java)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Établir la connexion
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connexion réussie à la base de données !");

            // Exécuter une requête simple
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT VERSION()");

            // Afficher la version de MySQL
            if (rs.next()) {
                System.out.println("Version de MySQL : " + rs.getString(1));
            }

            // Fermer la connexion
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("✅ Connexion fermée.");

        } catch (ClassNotFoundException e) {
            System.out.println("❌ Driver MySQL introuvable !");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Erreur SQL !");
            e.printStackTrace();
        }
    }
}
