package model.services;

import java.time.Duration;

import model.entities.Car;
import model.entities.Invoice;
import model.entities.Rental;

public class RentalService {
	private Double pricePerHour;
	private Double pricePerDay;
	private TaxService taxService = new TaxService();

	public RentalService(Car car, TaxService taxService) {
		this.pricePerHour = car.getHourCost();
		this.pricePerDay = car.getDailyCost();
		this.taxService = taxService;
	}

	public void processInvoice(Rental rental) {

		Double minutes = (double) Duration.between(rental.getPickupDate(), rental.getReturnDate()).toMinutes();
		Double hours = minutes / 60.0;
		Double basicPayment;
		
		if (hours <= 12) {
			basicPayment = pricePerHour * Math.ceil(hours);
		} else {
			basicPayment = pricePerDay * Math.ceil(hours/24);
		}

		rental.setInvoice(new Invoice(basicPayment, taxService.tax(basicPayment)));
	}

}
