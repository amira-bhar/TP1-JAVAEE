package Com.app.metier;

import java.util.List;

public interface IGestionProduit {
    void ajouterProduit(Produit produit);
    List<Produit> getAllProduits();
    Produit getProduitById(int id);
    void supprimerProduit(int id);
    void mettreAJourProduit(Produit produit);
}

