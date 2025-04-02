package Com.app.Controller;

import Com.app.dao.GestionProduitDAO;
import Com.app.metier.Produit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/produits")
public class ProduitController extends HttpServlet {
    private GestionProduitDAO produitDAO;

    @Override
    public void init() throws ServletException {
        produitDAO = new GestionProduitDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("🔧 Appel de la méthode doGet()");
        List<Produit> produits = produitDAO.getAllProduits();
        System.out.println("Nombre de produits récupérés : " + produits.size());

        if (produits == null || produits.isEmpty()) {
            System.out.println("⚠️ Aucune donnée récupérée depuis la base !");
        } else {
            for (Produit p : produits) {
                System.out.println("✅ Produit trouvé : " + p.getNom());
            }
        }

        request.setAttribute("produits", produits);
        request.getRequestDispatcher("listeProduits.jsp").forward(request, response);
    }




}


