package com.tiaa.credit.constants;

public enum Card {

	VISA("Visa", "4"), MASTERCARD("Master", "5"), AMERICANEXPRESS("Amex", "37"), DISCOVER("Discover", "6");

	private String name;
	private String bankId;

	private Card(String name, String bankId) {

		this.name = name;
		this.bankId = bankId;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

}
