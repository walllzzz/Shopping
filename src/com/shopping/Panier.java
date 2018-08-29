package com.shopping;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Panier {
    // map qui contient le produit et la quantité
    private Map<Produit, Integer> produits;

    /**
     * Constructeur
     */
    public Panier(){
        // initialisation du panier
        produits = new HashMap<>();
    }

    /**
     * ajouter un produit au panier
     * @param produit produit à ajouter
     * @param quantite quantite
     */
    public void ajoutProduit(Produit produit, int quantite){
        Integer value = this.produits.get(produit);
        if(value == null )
            this.produits.put(produit, quantite);
        else
            this.produits.put(produit, value + quantite);
    }

    /**
     * supprimer un produit du panier
     * @param produit produit à supprimer
     */
    public void supprimerProduit(Produit produit){
        this.produits.remove(produit);
    }

    /**
     * Calculer le montant total du panier
     *
     * @return total
     */
    public BigDecimal calculerTotal(){
        BigDecimal total = new BigDecimal(0);
        for (Produit produit : produits.keySet()) {
            // récupèrer la quantité
            Integer quantite = produits.get(produit);
            BigDecimal totalProduit = produit.getPrix().multiply( new BigDecimal(quantite));
            total= total.add(totalProduit);
        }
        return total;
    }

    /**
     * get List Produit
     * @return
     */
    public Set<Produit> recupererListProduit(){
        return produits.keySet();
    }
}
