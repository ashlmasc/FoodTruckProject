package com.skilldistillery.foodtruck.entities;

public class FoodTruck {
	private String name;
	private String foodType;
	private int rating;

	public FoodTruck(String name, String foodType, int rating) {
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public String getFoodType() {
		return foodType;
	}

	public int getRating() {
		return rating;
	}

	public String toString() {
		String foodTrucksOutput = "Name: " + name + "\n" + "Type of Food: " + foodType + "\n" + "Rating: " + rating + "\n\n";
		return foodTrucksOutput;
				
	}
}
