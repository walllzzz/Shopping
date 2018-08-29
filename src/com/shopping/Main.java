package com.shopping;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // initialisation des classes
        ProduitHelper gestionProduit = new ProduitHelper();
        Panier panier = new Panier();
        Scanner sc = new Scanner(System.in);

        // Affichage la liste des produits
        System.out.println("ID Produit -- Libelle -- prix");
        gestionProduit.getListProduits().stream().map( p -> p.getId() + " -- "+ p.getLibelle() + " -- "+ p.getPrix()).forEach(System.out::println);

        int choix = 0 ;
        while (choix != 5 ) {
            System.out.println("Choisir une action : ");
            System.out.println("1 - Ajouter du produit. ");
            System.out.println("2 - Supprimer un produit. ");
            System.out.println("3 - consulter les produits du panier. ");
            System.out.println("4 - consulter le montant du panier. ");
            System.out.println("5 - Exit");
            choix = sc.nextInt();
            if(choix == 1 ) {
                System.out.println("1 - Ajouter un produit au panier : ");
                System.out.println("id Produit : ");
                long idProduit = sc.nextLong();
                System.out.println("quantité : ");
                int quantite = sc.nextInt();
                Produit produit = gestionProduit.getProduitByid(idProduit);
                panier.ajoutProduit(produit, quantite);
            } else if (choix == 2 ){
                System.out.println("2 - Supprimer un produit du panier: ");
                System.out.println("id Produit : ");
                long idProduit = sc.nextLong();
                Produit produit = gestionProduit.getProduitByid(idProduit);
                panier.supprimerProduit(produit);
            } else if (choix == 3 ){
                System.out.println("3 - consulter les produits du panier: ");
                panier.recupererListProduit().stream().map( p -> p.getLibelle() ).forEach(System.out::println);
            } else if(choix == 4 ){
                System.out.println("4 - consulter le montant du panier: ");
                System.out.println("Total panier : "+panier.calculerTotal());
            }

        }

    }

}
