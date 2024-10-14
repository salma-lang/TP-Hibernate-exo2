/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exo2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import ma.projet.classes.Categorie;
import ma.projet.classes.Commande;
import ma.projet.classes.LigneCommandeProduitId;
import ma.projet.classes.LigneCommandedeProduit;
import ma.projet.classes.Produit;
import ma.projet.service.CategorieService;
import ma.projet.service.CommandeService;
import ma.projet.service.LigneCommandeService;
import ma.projet.service.ProduitService;

/**
 *
 * @author hp
 */
public class Exo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        
        
        CategorieService categorieService = new CategorieService();
        ProduitService produitService = new ProduitService();
        CommandeService commandeService = new CommandeService();
        LigneCommandeService ligneCommandeService = new LigneCommandeService();
        
        
         // Créer des catégories
        Categorie c1 = new Categorie("categorie1", "telephone");
        Categorie c2 = new Categorie("categorie2", "routeur");
        categorieService.create(c1);
        categorieService.create(c2);


    
        
     
    // Créer des produits
        Produit p1 = new Produit("produit1", 3000, c1);
        Produit p2 = new Produit("produit2", 800, c2);
        Produit p3 = new Produit("produit3", 400, c2);
        produitService.create(p1);
        produitService.create(p2);
        produitService.create(p3);
     
        
        
        //Afficher la liste des produits par catégorie
         System.out.println("les produits dans la catégorie routeur sont:");
        List<Produit> produitsC2 = produitService.findByCategorie(c2);
        for (Produit produit : produitsC2) {
            System.out.println(produit.getReference() + " - Prix: " + produit.getPrix());
       }
 

          System.out.println("\nles produits dans la catégorie telephone sont:");
       List<Produit> produitsC1 = produitService.findByCategorie(c1);
        for (Produit produit : produitsC1) {
            System.out.println(produit.getReference() + " - Prix: " + produit.getPrix());
        }
  
        
        //Creation des commandes 
        Commande commande1 = new Commande();
        commande1.setDate(new Date());
        commandeService.create(commande1);

        LigneCommandedeProduit ligne1 = new LigneCommandedeProduit(2,p1,commande1);
        ligne1.setPk(new LigneCommandeProduitId(commande1.getId(), p1.getId()));
        ligneCommandeService.create(ligne1);

        LigneCommandedeProduit ligne2 = new LigneCommandedeProduit(1,p2,commande1);
        ligne2.setPk(new LigneCommandeProduitId(commande1.getId(), p2.getId()));
        ligneCommandeService.create(ligne2);

        LigneCommandedeProduit ligne3 = new LigneCommandedeProduit(3,p3,commande1);
        ligne3.setPk(new LigneCommandeProduitId(commande1.getId(), p3.getId()));
        ligneCommandeService.create(ligne3);
  
      
       // Afficher la liste des produits commandés entre deux dates. 
        System.out.println("\nLa liste des produits commandés entre deux dates");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = sdf.parse("2024-10-13");
            Date endDate = sdf.parse("2024-10-13");

            List<Produit> produitsEntreDeuxDates = produitService.findBetweenDates(startDate, endDate);
            
            for (Produit p : produitsEntreDeuxDates) {
                System.out.println("Reference: " + p.getReference()
                        + ", Prix: " + p.getPrix());
            }
   
      
          // Afficher les produits commandés dans une commande donnée:
            System.out.println("\nLes produits commandés dans une commande donnée");
        List<Produit> produitsCommande = commandeService.getProduitsCommande(commande1.getId());
        System.out.println("Produits de la commande " + commande1.getId() + ":"+"            Date :" + new SimpleDateFormat("dd/MM/yyyy").format(commande1.getDate()));
        for (Produit pc : produitsCommande) {
            System.out.println(" - " + pc.getReference()+"      Prix : " +pc.getPrix()+"          Quantité : "+pc.getPrix());
        }
  
        //Afficher La liste des produits dont le prix est supérieur à 100 DH 
        System.out.println("\nLa liste des produits dont le prix est supérieur à 100 DH");
        float prixMin = 100;
        List<Produit> produitsCher = produitService.getProduitsPrixSuperieur(prixMin);
        System.out.println("Produits avec un prix supérieur à " + prixMin + " DH:");
        for (Produit p : produitsCher) {
            System.out.println(" - " + p.getReference() + " : " + p.getPrix() + " DH");
        }
    
    }
        } 
 
 
 

    
    
  
    

