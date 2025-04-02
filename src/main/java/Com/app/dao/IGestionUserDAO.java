package Com.app.dao;

import Com.app.metier.User;

public interface IGestionUserDAO {
    boolean isValidUser(String username, String password);
    void addUser(User user);
    User getUserByUsername(String username);
}
