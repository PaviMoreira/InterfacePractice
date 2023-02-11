package model.entities;

public class Invoice {
	public Double basicPayment;
	public Double Tax;

	public Invoice(Double basicPayment, Double tax) {
		this.basicPayment = basicPayment;
		this.Tax = tax;
	}

	public Invoice() {

	}

	public Double getBasicPayment() {
		return basicPayment;
	}

	public void setBasicPayment(Double basicPayment) {
		this.basicPayment = basicPayment;
	}

	public Double getTax() {
		return Tax;
	}

	public void setTax(Double tax) {
		Tax = tax;
	}

	@Override
	public String toString() {
		return "Basic Payment: " + basicPayment + "\nTax: " + Tax + "\nTotal payment: " + (basicPayment+Tax);
	}
	
	

}
