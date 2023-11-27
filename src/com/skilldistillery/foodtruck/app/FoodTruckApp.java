package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {

	private FoodTruck[] fleet = new FoodTruck[5]; 

	public static void main(String[] args) {
		FoodTruckApp app = new FoodTruckApp();
		app.run();
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		int truckCount = 0;

		while (truckCount < 5) {
			System.out.print("Enter the name of the food truck (type 'quit' to stop):");
			String name = sc.nextLine();

			if (name.equalsIgnoreCase("quit")) {
				break;
			}

			System.out.print("Enter the food type:");
			String foodType = sc.nextLine();

			System.out.print("Enter the rating (1-5):");
			int rating = sc.nextInt();
			sc.nextLine(); 

			if (rating < 1 || rating > 5) {
				System.out.println("Invalid rating. Please enter a rating between 1 and 5.");
				continue;
			}

			fleet[truckCount] = new FoodTruck(name, foodType, rating);
			truckCount++;
		}

		while (true) {
			System.out.println();
			System.out.println("**************************************");
			System.out.println("|               MENU        	     |");
			System.out.println("--------------------------------------");
			System.out.println("| 1. List all food trucks            |");
			System.out.println("| 2. Display average rating          |");
			System.out.println("| 3. Display highest-rated food truck|");
			System.out.println("| 4. Quit                            |");
			System.out.println("--------------------------------------");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				listAllTrucks(fleet, truckCount);
				break;
			case 2:
				displayAverageRating(fleet, truckCount);
				break;
			case 3:
				displayHighestRatedTruck(fleet, truckCount);
				break;
			case 4:
				System.out.println("Goodbye!");
				sc.close();
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please enter a number between 1 and 4.");
			}
		}
	}

	public void listAllTrucks(FoodTruck[] fleet, int truckCount) {
		if (truckCount == 0) {
			System.out.println("No trucks to display.");
			return;
		}
		for (int i = 0; i < truckCount; i++) {
			System.out.println(fleet[i]);
		}
	}

	public void displayAverageRating(FoodTruck[] fleet, int truckCount) {
		if (truckCount == 0) {
			System.out.println("No trucks to calculate average rating.");
			return;
		}

		int totalRating = 0;
		for (int i = 0; i < truckCount; i++) {
			totalRating += fleet[i].getRating();
		}

		double averageRating = (double) totalRating / truckCount;
		System.out.println("Average Rating: " + averageRating);
	}

	public void displayHighestRatedTruck(FoodTruck[] fleet, int truckCount) {
		if (truckCount == 0) {
			System.out.println("No trucks to display.");
			return;
		}
		FoodTruck highestRated = fleet[0];
		for (int i = 1; i < truckCount; i++) {
			if (fleet[i].getRating() > highestRated.getRating()) {
				highestRated = fleet[i];
			}
		}
		System.out.println("Highest Rated Truck: " + highestRated);
	}
}

