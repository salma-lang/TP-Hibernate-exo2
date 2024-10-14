/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.List;
import ma.projet.classes.Categorie;
import ma.projet.dao.IDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author hp
 */
public class CategorieService implements IDao<Categorie> {

    @Override
    public boolean create(Categorie o) {
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
    public Categorie getById(int id) {
        Session session = null;
        Categorie e  = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (Categorie) session.get(Categorie.class, id);
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
    public List<Categorie> getAll() {
        Session session = null;
        List<Categorie>  categories = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            categories = session.createQuery("from Categorie").list();
            session.getTransaction().commit();
            return categories;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return categories;
    }

   
    
}
