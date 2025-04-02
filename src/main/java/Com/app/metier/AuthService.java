package Com.app.metier;

import Com.app.dao.GestionUserDAO;

public class AuthService implements IAuthService {
    private final GestionUserDAO userDAO;

    public AuthService(GestionUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean login(String username, String password) {
        return userDAO.isValidUser(username, password);
    }

    @Override
    public void logout(String username) {
        System.out.println(username + " s'est déconnecté.");
    }
}
