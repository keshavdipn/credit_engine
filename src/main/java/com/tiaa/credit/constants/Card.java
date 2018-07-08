package com.tiaa.credit.constants;

public enum Card {

	VISA("Visa"), MASTERCARD("Master"), AMERICANEXPRESS("Amex"), DISCOVER("Discover");

	private String name;

	private Card(String name) {

		this.name = name;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
