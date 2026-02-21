package com.donate.service;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.donate.bean.Campaign;
import com.donate.bean.Donor;
import com.donate.bean.Pledge;
import com.donate.util.ActivePledgesExistException;
import com.donate.util.CampaignClosedException;
import com.donate.util.HibernateUtil;
import com.donate.util.ValidationException;

public class DonateService {

    public Donor viewDonorDetails(String donorID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Donor donor = session.get(Donor.class, donorID);
        session.close();
        return donor;
    }

    public List<Donor> viewAllDonors() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Donor> list = session.createQuery("from Donor", Donor.class).list();
        session.close();
        return list;
    }

    public boolean registerNewDonor(Donor donor) {

        if (donor == null ||
                donor.getDonorID() == null || donor.getDonorID().trim().isEmpty() ||
                donor.getFullName() == null || donor.getFullName().trim().isEmpty() ||
                donor.getMobile() == null || donor.getMobile().trim().isEmpty()) {
            return false;
        }

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Donor existing = session.get(Donor.class, donor.getDonorID());
        if (existing != null) {
            session.close();
            return false;
        }

        donor.setStatus("ACTIVE");
        session.save(donor);

        tx.commit();
        session.close();
        return true;
    }

    public Campaign viewCampaignDetails(String campaignID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Campaign campaign = session.get(Campaign.class, campaignID);
        session.close();
        return campaign;
    }

    public List<Campaign> viewAllCampaigns() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Campaign> list = session.createQuery("from Campaign", Campaign.class).list();
        session.close();
        return list;
    }

    public boolean createCampaign(Campaign campaign) {

        if (campaign == null ||
                campaign.getCampaignID() == null ||
                campaign.getCampaignName() == null ||
                campaign.getStartDate() == null ||
                campaign.getEndDate() == null ||
                campaign.getTargetAmount().compareTo(BigDecimal.ZERO) < 0) {
            return false;
        }

        if (campaign.getStartDate().after(campaign.getEndDate())) {
            return false;
        }

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Campaign existing = session.get(Campaign.class, campaign.getCampaignID());
        if (existing != null) {
            session.close();
            return false;
        }

        if (campaign.getStatus() == null) {
            campaign.setStatus("PLANNED");
        }

        session.save(campaign);
        tx.commit();
        session.close();
        return true;
    }

    public boolean recordPledge(String donorID, String campaignID,
                                java.sql.Date pledgeDate, BigDecimal pledgeAmount) {

        try {

            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            Donor donor = session.get(Donor.class, donorID);
            Campaign campaign = session.get(Campaign.class, campaignID);

            if (donor == null || campaign == null ||
                    !"ACTIVE".equals(campaign.getStatus())) {
                session.close();
                return false;
            }

            Pledge pledge = new Pledge();
            pledge.setDonor(donor);
            pledge.setCampaign(campaign);
            pledge.setPledgeDate(pledgeDate);
            pledge.setPledgeAmount(pledgeAmount);
            pledge.setAmountPaid(BigDecimal.ZERO);
            pledge.setPaymentStatus("NOT_PAID");
            pledge.setWriteoffFlag("NO");

            session.save(pledge);

            tx.commit();
            session.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean recordPayment(int pledgeID, BigDecimal paymentAmount) {

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            Pledge pledge = session.get(Pledge.class, pledgeID);
            if (pledge == null) {
                session.close();
                return false;
            }

            BigDecimal newAmount = pledge.getAmountPaid().add(paymentAmount);
            if (newAmount.compareTo(pledge.getPledgeAmount()) > 0) {
                throw new ValidationException();
            }

            pledge.setAmountPaid(newAmount);

            if (newAmount.compareTo(pledge.getPledgeAmount()) == 0)
                pledge.setPaymentStatus("FULLY_PAID");
            else if (newAmount.compareTo(BigDecimal.ZERO) > 0)
                pledge.setPaymentStatus("PARTIALLY_PAID");

            session.update(pledge);

            tx.commit();
            session.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean closeCampaign(String campaignID) {

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            Campaign campaign = session.get(Campaign.class, campaignID);
            if (campaign == null)
                return false;

            campaign.setStatus("CLOSED");
            session.update(campaign);

            tx.commit();
            session.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}