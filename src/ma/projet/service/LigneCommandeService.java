/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.Date;
import java.util.List;
import ma.projet.classes.LigneCommandedeProduit;
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
public class LigneCommandeService implements IDao<LigneCommandedeProduit> {

    @Override
    public boolean create(LigneCommandedeProduit o) {

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
        return false;    }

    @Override
    public LigneCommandedeProduit getById(int id) {
        Session session = null;
        LigneCommandedeProduit e  = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (LigneCommandedeProduit) session.get(LigneCommandedeProduit.class, id);
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
    public List<LigneCommandedeProduit> getAll() {
       Session session = null;
        List<LigneCommandedeProduit>  lignesCommande = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            lignesCommande = session.createQuery("from LigneCommandedeProduit").list();
            session.getTransaction().commit();
            return lignesCommande;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return lignesCommande;    }
    
  
}
    

