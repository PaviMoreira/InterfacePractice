package model.entities;

import java.time.LocalDateTime;

import model.exceptions.CarException;

public class Rental {

	private LocalDateTime pickupDate;
	private LocalDateTime returnDate;

	private Car car;
	private Invoice invoice;

	public Rental() {
	}

	public Rental(LocalDateTime pickupDate, LocalDateTime returnDate, Car car) {
		if (!returnDate.isAfter(pickupDate)) {
			throw new CarException("Return date must be after pickup date.");
		}
		this.pickupDate = pickupDate;
		this.returnDate = returnDate;
		this.car = car;
	}

	public LocalDateTime getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(LocalDateTime pickupDate) {
		this.pickupDate = pickupDate;
	}

	public LocalDateTime getReturnDate() {
		return returnDate;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Car getCar() {
		return car;
	}

	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
}
