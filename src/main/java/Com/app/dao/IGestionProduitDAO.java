package Com.app.dao;

import Com.app.metier.Produit;
import java.util.List;

public interface IGestionProduitDAO {
    List<Produit> getAllProduits();
    void ajouterProduit(Produit produit);
    Produit getProduitById(int id);
    void supprimerProduit(int id);
    void mettreAJourProduit(Produit produit);
}
