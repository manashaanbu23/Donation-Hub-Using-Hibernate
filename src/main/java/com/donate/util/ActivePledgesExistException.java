package com.donate.util;

public class ActivePledgesExistException extends Exception{
	public String toString() {
		return "Cannot close:Active Pledge exist";
	}
}
