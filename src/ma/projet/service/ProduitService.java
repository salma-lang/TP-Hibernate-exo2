/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.Date;
import java.util.List;
import ma.projet.classes.Categorie;
import ma.projet.classes.Produit;
import ma.projet.dao.IDao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author hp
 */
public class ProduitService implements IDao<Produit> {

    @Override
    public boolean create(Produit o) {

        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return false;
    }

    @Override
    public Produit getById(int id) {
        Session session = null;
        Produit e  = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (Produit) session.get(Produit.class, id);
            session.getTransaction().commit();
            return e;
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return e;

    }

    @Override
    public List<Produit> getAll() {
         Session session = null;
        List<Produit>  produits = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            produits = session.createQuery("from Produit").list();
            session.getTransaction().commit();
            return produits;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return produits;

  
}
       public List<Produit> findByCategorie(Categorie categorie) {
        Session session = null;
        List<Produit> produits = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            produits = session.createQuery("from Produit p where p.categorie = :categorie")
                    .setParameter("categorie", categorie).list();

            session.getTransaction().commit();
            return produits;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return produits;
    }
    
   public List<Produit> findBetweenDates(Date startDate, Date endDate) {
    Session session = null;
    List<Produit> produits = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        // Utilisation de HQL pour récupérer les produits entre deux dates
        produits = session.createQuery(
                "SELECT DISTINCT p FROM Produit p " +
                "JOIN p.ligneCommandeProduits lcp " +
                "JOIN lcp.commande c " +
                "WHERE c.date BETWEEN :startDate AND :endDate")
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .list();
                          
        session.getTransaction().commit();
        return produits;
    } catch (HibernateException e) {
        if (session != null && session.getTransaction() != null) {
            session.getTransaction().rollback();
        }
        e.printStackTrace();
    } finally {
        if (session != null) {
            session.close();
        }
    }
    return produits;
}
   
  public List<Produit> getProduitsPrixSuperieur(float prix) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Produit> produits = session.createQuery("from Produit p where p.prix > :prix")
                                        .setParameter("prix", prix)
                                        .list();
        session.close();
        return produits;
    }

}

   