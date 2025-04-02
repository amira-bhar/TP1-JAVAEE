package Com.app.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Supprimer la session
        }

        // Supprimer le cookie utilisateur
        Cookie userCookie = new Cookie("username", "");
        userCookie.setMaxAge(0); // Expiration immédiate
        response.addCookie(userCookie);

        response.sendRedirect("login.jsp"); // Redirection vers la page de connexion
    }
}
