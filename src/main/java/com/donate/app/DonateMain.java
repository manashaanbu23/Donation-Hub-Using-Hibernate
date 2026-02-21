package com.donate.app;
import com.donate.bean.Campaign;
import com.donate.bean.Donor;
import com.donate.service.DonateService;
public class DonateMain {
    public static void main(String[] args) {
        DonateService donateService = new DonateService();
        System.out.println("--- Community Donation & Pledge Tracking Console ---");
        try {
            Donor donor = new Donor();
            donor.setDonorID("DNR9001");
            donor.setFullName("Luffy");
            donor.setEmail("luffystrawhats@example.org");
            donor.setMobile("9876599123");
            donor.setCity("Tokyo");
            boolean result = donateService.registerNewDonor(donor);
            System.out.println(result ? "DONOR REGISTERED" : "DONOR REGISTRATION FAILED");
        } catch (Exception e) {
            System.out.println("System Error: " + e.getMessage());
        }
        try {
            Campaign campaign = new Campaign();
            campaign.setCampaignID("CMP3026C");
            campaign.setCampaignName("Relief Fund 2025");
            campaign.setStartDate(new java.sql.Date(System.currentTimeMillis()));
            campaign.setEndDate(new java.sql.Date(System.currentTimeMillis() + 30L * 24 * 60 * 60 * 1000));
            campaign.setTargetAmount(new java.math.BigDecimal("150000.00"));
            campaign.setStatus("ACTIVE");
            boolean result = donateService.createCampaign(campaign);
            System.out.println(result ? "CAMPAIGN CREATED" : "CAMPAIGN CREATION FAILED");
        } catch (Exception e) {
            System.out.println("System Error: " + e.getMessage());
        }
        try {
            java.sql.Date pledgeDate = new java.sql.Date(System.currentTimeMillis());
            boolean result = donateService.recordPledge(
                    "DNR9001",
                    "CMP3026C",
                    pledgeDate,
                    new java.math.BigDecimal("7000.00")
            );
            System.out.println(result ? "PLEDGE RECORDED" : "PLEDGE FAILED");
        } catch (Exception e) {
            System.out.println("System Error: " + e.getMessage());
        }
    }
}