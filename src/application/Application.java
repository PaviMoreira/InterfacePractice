package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Car;
import model.entities.Rental;
import model.exceptions.CarException;
import model.services.RentalService;
import model.services.TaxService;

public class Application {
	public static void main(String[] args) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		Scanner read = new Scanner(System.in);

		Car car = new Car();
		Rental rent = new Rental();

		System.out.println("Enter rental data: \nCar model: ");
		car.setModel(read.nextLine());

		try {
			System.out.println("Pickup (dd/MM/yyyy hh:mm):");
			rent.setPickupDate(LocalDateTime.parse(read.nextLine(), dtf));
			System.out.println("Return (dd/MM/yyyy hh:mm):");
			rent.setReturnDate(LocalDateTime.parse(read.nextLine(), dtf));
		} catch (CarException e) {
			System.out.println("Erro: invalid date format");
		}

		try {
			System.out.println("Enter price per hour:");
			car.setHourCost(read.nextDouble());
			System.out.println("Enter price per day:");
			car.setDailyCost(read.nextDouble());
			rent.setCar(car);
		} catch (CarException e) {
			System.out.println("Erro: value");
		}

		RentalService service = new RentalService(rent.getCar(), new TaxService());

		service.processInvoice(rent);

		System.out.println(rent.getInvoice().toString());

		read.close();
	}
}
