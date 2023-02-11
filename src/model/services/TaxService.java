package model.services;

public class TaxService {
	
	public Double tax(double ammount) {
		if (ammount <= 100.0) {
			return ammount * 0.2;
		} else {
			return ammount * 0.15;
		}
	}
}
