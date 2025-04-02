package Com.app.metier;

import Com.app.dao.UserDAO;

public class AuthService {
    private UserDAO userDAO;

    public AuthService() {
        this.userDAO = new UserDAO();
    }

    public boolean authenticate(String username, String password) {
        return userDAO.isValidUser(username, password);
    }
}



