/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneCommandedeProduit {
   @EmbeddedId
    private LigneCommandeProduitId pk;
    
    private int quantite;
    
    @ManyToOne
     @JoinColumn(name = "produitId", insertable = false, updatable = false)
     private Produit produit;
    
    @ManyToOne
     @JoinColumn(name = "commandeId", insertable = false, updatable = false)
    private Commande commande;
    

    public LigneCommandedeProduit() {
    }

    public LigneCommandedeProduit(int quantite, Produit produit, Commande commande) {
        this.quantite = quantite;
        this.produit = produit;
        this.commande = commande;
    }

    public LigneCommandeProduitId getPk() {
        return pk;
    }

    public void setPk(LigneCommandeProduitId pk) {
        this.pk = pk;
    }

 

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
    
    

}
