## Exercice 2 - Gestion des commandes et produits

## 1. Création des entités
Dans le package ma.projet.classes, définissez plusieurs classes qui représentent les entités de la base de données. Les principales classes sont :

-Produit : Représente un produit avec des attributs comme reference, prix, et une relation avec Categorie.

-Categorie : Représente une catégorie de produits.

-Commande : Représente une commande passée par un client.

-LigneCommandeProduit : Associe les commandes aux produits avec la quantité commandée.

## 2 . Configuration Hibernate
Comme dans l’exercice précédent, configurez Hibernate avec un fichier hibernate.cfg.xml qui inclura les détails de connexion à la base de données et la gestion des transactions.

## 3. Interface et Service
-Créez une interface IDao qui définira des méthodes génériques pour les opérations CRUD.

-Implémentez des classes service pour gérer les entités Produit, Categorie, Commande, et LigneCommande. Par exemple, dans ProduitService, vous définirez des méthodes pour ajouter, supprimer et rechercher des produits dans la base de données.

## 4. Méthodes supplémentaires
Ajoutez des méthodes spécifiques pour afficher des informations supplémentaires :

-Liste des produits par catégorie : Cette méthode retournera tous les produits appartenant à une catégorie spécifique.

-Produits commandés entre deux dates : Vous devrez récupérer toutes les commandes passées entre deux dates.

-Produits avec un prix supérieur à 100 DH : Filtrez les produits dont le prix dépasse cette valeur.

## 5. Tests et validation
Créez une classe de test où vous allez initialiser les services et exécuter des requêtes pour vérifier que toutes les fonctionnalités fonctionnent correctement.


