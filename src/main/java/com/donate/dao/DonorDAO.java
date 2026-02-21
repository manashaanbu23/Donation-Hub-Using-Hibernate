package com.donate.dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.donate.bean.Donor;
import com.donate.util.HibernateUtil;
public class DonorDAO {
    public Donor findDonor(String donorID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Donor donor = session.get(Donor.class, donorID);
        session.close();
        return donor;
    }
    public List<Donor> viewAllDonors() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Donor> donors =session.createQuery("from Donor", Donor.class).list();
        session.close();
        return donors;
    }
    public boolean insertDonor(Donor donor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(donor);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }
    public boolean updateDonorStatus(String donorID, String status) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Donor donor = session.get(Donor.class, donorID);
            if (donor != null) {
                donor.setStatus(status);
                session.update(donor);
                tx.commit();
                return true;
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return false;
    }
    public boolean deleteDonor(String donorID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Donor donor = session.get(Donor.class, donorID);

            if (donor != null) {
                session.delete(donor);
                tx.commit();
                return true;
            }

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return false;
    }
}