package com.donate.util;

public class CampaignClosedException extends Exception {
	public String toString() {
		return"Campaign is not active";
	}
}
