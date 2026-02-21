package com.donate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.donate.bean.Campaign;
import com.donate.util.HibernateUtil;

public class CampaignDAO {
    public Campaign findCampaign(String campaignID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Campaign campaign = session.get(Campaign.class, campaignID);
        session.close();
        return campaign;
    }
    public List<Campaign> viewAllCampaigns() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Campaign> campaigns =session.createQuery("from Campaign", Campaign.class).list();
        session.close();
        return campaigns;
    }
    public boolean insertCampaign(Campaign campaign) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(campaign);
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
    public boolean updateCampaignStatus(String campaignID, String status) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Campaign campaign = session.get(Campaign.class, campaignID);
            if (campaign != null) {
                campaign.setStatus(status);
                session.update(campaign);
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