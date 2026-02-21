package com.donate.bean;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name="CAMPAIGN_TBL")
public class Campaign {

    @Id
    @Column(name="CAMPAIGN_ID")
    private String campaignID;

    @Column(name="CAMPAIGN_NAME")
    private String campaignName;

    @Column(name="START_DATE")
    private Date startDate;

    @Column(name="END_DATE")
    private Date endDate;

    @Column(name="TARGET_AMOUNT")
    private BigDecimal targetAmount;

    @Column(name="STATUS")
    private String status;

	public String getCampaignID() {
		return campaignID;
	}

	public void setCampaignID(String campaignID) {
		this.campaignID = campaignID;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public BigDecimal getTargetAmount() {
		return targetAmount;
	}

	public void setTargetAmount(BigDecimal targetAmount) {
		this.targetAmount = targetAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
	    return "Campaign{" +
	            "campaignID='" + campaignID + '\'' +
	            ", campaignName='" + campaignName + '\'' +
	            ", startDate=" + startDate +
	            ", endDate=" + endDate +
	            ", targetAmount=" + targetAmount +
	            ", status='" + status + '\'' +
	            '}';
	}
}