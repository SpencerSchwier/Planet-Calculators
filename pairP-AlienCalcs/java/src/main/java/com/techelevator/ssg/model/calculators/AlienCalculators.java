package com.techelevator.ssg.model.calculators;

public class AlienCalculators {
	
	public static final Planet[] PLANETS = {
		new Planet("Mercury", 87.96, 0.37, 56_974_146L),
		new Planet("Venus", 224.68, 0.90, 25_724_767L),
		new Planet("Mars", 686.98, 0.38, 48_678_219L),
		new Planet("Jupiter", 4329.63, 2.65, 390_674_710L),
		new Planet("Saturn", 10751.44, 1.13, 792_248_270L),
		new Planet("Uranus", 30685.55, 1.09, 1_692_662_530L),
		new Planet("Neptune", 60155.65, 1.43, 2_703_959_960L),
	};
	
	public static final Transportation[] MODES = {
		new Transportation("Walking", 3),
		new Transportation("Car", 100),
		new Transportation("Bullet Train", 200),
		new Transportation("Boeing 747", 570),
		new Transportation("Concorde", 1350),
	};

	private static Planet getPlanetByName(String planetName) {
		Planet result = null;
		for (Planet p : PLANETS) {
			if (p.getName().equals(planetName)) {
				result = p;
			}
		}
		return result;
	}
	
	private static Transportation getTransportationByMode(String transportationMode) {
		Transportation result = null;
		for (Transportation t : MODES) {
			if (t.getName().equals(transportationMode)) {
				result = t;
			}
		}
		return result;
	}
	
	// Calculate the your age in terms of a named planet
	public static double calculateAlienAge(int earthYears, String planetName) {
		return (earthYears * 365) / getPlanetByName(planetName).getEarthDaysPerYear(); 
	} 
	
	// Calculate the your weight in terms of a named planet
	public static double calculateAlienWeight(int earthWeight, String planetName) {
		return earthWeight * getPlanetByName(planetName).getEarthRelativeGravity(); 
	} 
	
	// Calculate the your weight in terms of a named planet
	public static double calculateTravelTime(String planetName, String transportationMode) {
		return getPlanetByName(planetName).getEarthDistance() / getTransportationByMode(transportationMode).getSpeed() / 8760.00; 
	} 
}
