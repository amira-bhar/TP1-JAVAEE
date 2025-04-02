package Com.app.metier;

import java.util.ArrayList;
import java.util.List;

public class GestionProduit implements IGestionProduit {
    private List<Produit> produits = new ArrayList<>();

    @Override
    public void ajouterProduit(Produit produit) {
        produits.add(produit);
    }

    @Override
    public List<Produit> getAllProduits() {
        return produits;
    }

    @Override
    public Produit getProduitById(int id) {
        return produits.stream().filter(produit -> produit.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void supprimerProduit(int id) {
        produits.removeIf(produit -> produit.getId() == id);
    }

    @Override
    public void mettreAJourProduit(Produit produit) {
        for (Produit p : produits) {
            if (p.getId() == produit.getId()) {
                p.setNom(produit.getNom());
                p.setDescription(produit.getDescription());
                p.setPrix(produit.getPrix());
                p.setImage(produit.getImage());
                break;
            }
        }
    }
}

