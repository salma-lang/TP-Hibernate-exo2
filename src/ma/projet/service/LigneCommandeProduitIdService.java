/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.List;
import ma.projet.classes.LigneCommandeProduitId;
import ma.projet.dao.IDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author hp
 */
public class LigneCommandeProduitIdService implements IDao<LigneCommandeProduitId> {

    @Override
    public boolean create(LigneCommandeProduitId o) {
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
    public LigneCommandeProduitId getById(int id) {
         Session session = null;
        LigneCommandeProduitId e  = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (LigneCommandeProduitId) session.get(LigneCommandeProduitId.class, id);
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
    public List<LigneCommandeProduitId> getAll() {
        Session session = null;
        List<LigneCommandeProduitId>  LigneCommandeProduitIds = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
           LigneCommandeProduitIds = session.createQuery("from LigneCommandeProduitId").list();
            session.getTransaction().commit();
            return LigneCommandeProduitIds;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return LigneCommandeProduitIds;
    }
  }

   

