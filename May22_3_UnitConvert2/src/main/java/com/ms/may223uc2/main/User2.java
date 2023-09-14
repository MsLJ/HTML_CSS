package com.ms.may223uc2.main;

public class User2 {
	private String name;
	private double height;
	private double weight;
	private double bmi;
	private String result;
	private String file;
	
	public User2() {
		// TODO Auto-generated constructor stub
	}

	public User2(String name, double height, double weight, double bmi, String result, String file) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
		this.result = result;
		this.file = file;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
	
	
	
}