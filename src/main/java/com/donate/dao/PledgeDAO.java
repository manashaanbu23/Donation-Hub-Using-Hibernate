package com.donate.dao;
import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.donate.bean.Pledge;
import com.donate.util.HibernateUtil;

public class PledgeDAO {
    public boolean insertPledge(Pledge pledge) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(pledge);
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
    public boolean updatePledgePayment(int pledgeID,
                                       BigDecimal newAmountPaid,
                                       String newPaymentStatus) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Pledge pledge = session.get(Pledge.class, pledgeID);

            if (pledge != null) {
                pledge.setAmountPaid(newAmountPaid);
                pledge.setPaymentStatus(newPaymentStatus);
                session.update(pledge);
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
    public Pledge findPledge(int pledgeID) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Pledge pledge = session.get(Pledge.class, pledgeID);
        session.close();

        return pledge;
    }
    public List<Pledge> findPledgesByDonor(String donorID) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Pledge> pledges = session.createQuery(
                "from Pledge p where p.donor.donorID = :donorID",
                Pledge.class)
                .setParameter("donorID", donorID)
                .list();

        session.close();
        return pledges;
    }
    public List<Pledge> findPledgesByCampaign(String campaignID) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Pledge> pledges = session.createQuery(
                "from Pledge p where p.campaign.campaignID = :campaignID",
                Pledge.class)
                .setParameter("campaignID", campaignID)
                .list();

        session.close();
        return pledges;
    }
    public List<Pledge> findActivePledgesForDonor(String donorID) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Pledge> pledges = session.createQuery(
                "from Pledge p where p.donor.donorID = :donorID " +
                "and p.writeoffFlag = 'NO' " +
                "and (p.paymentStatus = 'NOT_PAID' or p.paymentStatus = 'PARTIALLY_PAID')",
                Pledge.class)
                .setParameter("donorID", donorID)
                .list();

        session.close();
        return pledges;
    }
    public List<Pledge> findActivePledgesForCampaign(String campaignID) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Pledge> pledges = session.createQuery(
                "from Pledge p where p.campaign.campaignID = :campaignID " +
                "and p.writeoffFlag = 'NO' " +
                "and (p.paymentStatus = 'NOT_PAID' or p.paymentStatus = 'PARTIALLY_PAID')",
                Pledge.class)
                .setParameter("campaignID", campaignID)
                .list();

        session.close();
        return pledges;
    }
}