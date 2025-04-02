package Com.app.Controller;

import Com.app.dao.ProduitDAO;
import Com.app.metier.Produit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/ajouterProduit")
public class ProduitControllerAjout extends HttpServlet {
    private ProduitDAO produitDAO;

    @Override
    public void init() throws ServletException {
        produitDAO = new ProduitDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp"); // Redirection si non connecté
            return;
        }

        request.getRequestDispatcher("ajouterProduit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp"); // Redirection si non connecté
            return;
        }

        String nom = request.getParameter("nom");
        String description = request.getParameter("description");
        BigDecimal prix = new BigDecimal(request.getParameter("prix"));
        String image = request.getParameter("image");

        Produit produit = new Produit(0, nom, description, prix, image);
        produitDAO.ajouterProduit(produit);

        // Ajouter un message de confirmation en session
        session.setAttribute("successMessage", "Le produit a été ajouté avec succès.");

        response.sendRedirect("ajouterProduit"); // Redirection vers la même page pour afficher le message
    }
}

