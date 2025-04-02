package Com.app.Controller;

import Com.app.metier.IAuthService;
import Com.app.metier.AuthService;
import Com.app.dao.GestionUserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class AuthController extends HttpServlet {
    private IAuthService authService;

    @Override
    public void init() throws ServletException {
        this.authService = new AuthService(new GestionUserDAO()); // Injection de dépendance
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (authService.login(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            session.setMaxInactiveInterval(30 * 60); // 30 minutes

            Cookie userCookie = new Cookie("username", username);
            userCookie.setMaxAge(30 * 60);
            response.addCookie(userCookie);

            response.sendRedirect("home.jsp");
        } else {
            request.setAttribute("error", "Nom d'utilisateur ou mot de passe incorrect.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
