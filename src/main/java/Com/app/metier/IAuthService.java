package Com.app.metier;


public interface IAuthService {
    boolean login(String username, String password);
    void logout(String username);
}
