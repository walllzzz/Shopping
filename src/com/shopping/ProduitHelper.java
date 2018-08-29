package com.shopping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProduitHelper {

    private static List<Produit> listProduits;

    public ProduitHelper(){
        initListProduit();
    }

    /**
     * iniitaliser la liste des produits
     */
    private void initListProduit(){
        // initialiser la liste des produits
        listProduits = new ArrayList<Produit>();
        listProduits.add(new Produit(0, "Lait", new BigDecimal("1")));
        listProduits.add(new Produit(1, "Pain", new BigDecimal("1.5")));
        listProduits.add(new Produit(2, "Huile", new BigDecimal("3")));
        listProduits.add(new Produit(3, "Frommage", new BigDecimal("5")));
    }

    /**
     * get list produit
     * @return
     */
    public List<Produit> getListProduits(){
        return listProduits;
    }

    /**
     * get produit by Id
     * @param id
     * @return
     */
    public Produit getProduitByid(long id){
        List<Produit> produits = listProduits.stream().filter(p -> p.getId() == id).collect(Collectors.toList());
        // si le produit est inexistant ou y en a plusieurs on génére une exception
        if(produits.size() != 1){
            throw new IllegalStateException();
        }
        return produits.get(0);
    }
}
