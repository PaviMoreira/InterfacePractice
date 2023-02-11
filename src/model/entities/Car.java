package model.entities;

public class Car {
	private String model;
	private Double hourCost;
	private Double dailyCost;
	
	public Car() {	
	}

	public Car(String model, Double hourCost, Double dailyCost) {
		this.model = model;
		this.hourCost = hourCost;
		this.dailyCost = dailyCost;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Double getHourCost() {
		return hourCost;
	}

	public void setHourCost(Double hourCost) {
		this.hourCost = hourCost;
	}

	public Double getDailyCost() {
		return dailyCost;
	}

	public void setDailyCost(Double dailyCost) {
		this.dailyCost = dailyCost;
	}

}
