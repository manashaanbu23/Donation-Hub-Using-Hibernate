package com.donate.bean;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "PLEDGE_TBL")
public class Pledge {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pledge_seq_gen")
	@SequenceGenerator(
	        name = "pledge_seq_gen",
	        sequenceName = "PLEDGE_SEQ",
	        allocationSize = 1
	)
    @Column(name = "PLEDGE_ID")
    private Long pledgeId;

    @ManyToOne
    @JoinColumn(name = "DONOR_ID")
    private Donor donor;

    @ManyToOne
    @JoinColumn(name = "CAMPAIGN_ID")
    private Campaign campaign;

    @Column(name = "PLEDGE_DATE")
    private Date pledgeDate;

    @Column(name = "PLEDGE_AMOUNT")
    private BigDecimal pledgeAmount;

    @Column(name = "AMOUNT_PAID")
    private BigDecimal amountPaid;

    @Column(name = "PAYMENT_STATUS")
    private String paymentStatus;

    @Column(name = "WRITEOFF_FLAG")
    private String writeoffFlag;

    // ✅ Correct Getter
    public Long getPledgeId() {
        return pledgeId;
    }

    // ✅ Correct Setter
    public void setPledgeId(Long pledgeId) {
        this.pledgeId = pledgeId;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public Date getPledgeDate() {
        return pledgeDate;
    }

    public void setPledgeDate(Date pledgeDate) {
        this.pledgeDate = pledgeDate;
    }

    public BigDecimal getPledgeAmount() {
        return pledgeAmount;
    }

    public void setPledgeAmount(BigDecimal pledgeAmount) {
        this.pledgeAmount = pledgeAmount;
    }

    public BigDecimal getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getWriteoffFlag() {
        return writeoffFlag;
    }

    public void setWriteoffFlag(String writeoffFlag) {
        this.writeoffFlag = writeoffFlag;
    }

    @Override
    public String toString() {
        return "Pledge{" +
                "pledgeId=" + pledgeId +
                ", donor=" + (donor != null ? donor.getDonorID() : null) +
                ", campaign=" + (campaign != null ? campaign.getCampaignID() : null) +
                ", pledgeDate=" + pledgeDate +
                ", pledgeAmount=" + pledgeAmount +
                ", amountPaid=" + amountPaid +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", writeoffFlag='" + writeoffFlag + '\'' +
                '}';
    }
}