package com.shopping;

import java.math.BigDecimal;
import java.util.Objects;

public class Produit {

    private long id;
    private String libelle;
    private BigDecimal prix;

    public Produit(long id, String libelle, BigDecimal prix){
        this.id = id;
        this.libelle = libelle;
        this.prix = prix;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produit produit = (Produit) o;
        return id == produit.id &&
                Objects.equals(libelle, produit.libelle) &&
                Objects.equals(prix, produit.prix);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, libelle, prix);
    }
}
