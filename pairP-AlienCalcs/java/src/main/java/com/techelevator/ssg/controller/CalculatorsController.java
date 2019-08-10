package com.techelevator.ssg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.ssg.model.calculators.AlienCalculators;

@Controller
public class CalculatorsController {
	
	
	@RequestMapping("/alienAge")
	public String alienAge(ModelMap modelMap) {
		modelMap.put("planets", AlienCalculators.PLANETS);
		return "alienAge";
	}
	
	@RequestMapping("/alienAgeResult")
	public String alienAgeResult(@RequestParam int earthAge, @RequestParam String planetName, ModelMap modelMap) {
		modelMap.put("alienAge", AlienCalculators.calculateAlienAge(earthAge, planetName));
		return "alienAgeResult";
	}

	@RequestMapping("/alienWeight")
	public String alienWeight(ModelMap modelMap) {
		modelMap.put("planets", AlienCalculators.PLANETS);
		return "alienWeight";
	}
	
	@RequestMapping("/alienWeightResult")
	public String alienWeightResult(@RequestParam int earthWeight, @RequestParam String planetName, ModelMap modelMap) {
		modelMap.put("alienWeight", AlienCalculators.calculateAlienWeight(earthWeight, planetName));
		return "alienWeightResult";
	}

	@RequestMapping("/alienTravelTime")
	public String alienTravelTime(ModelMap modelMap) {
		modelMap.put("planets", AlienCalculators.PLANETS);
		modelMap.put("modes", AlienCalculators.MODES);
		return "alienTravelTime";
	}
	
	@RequestMapping("/alienTravelTimeResult")
	public String alienTravelTimeResult(@RequestParam int earthAge, @RequestParam String planetName,
			@RequestParam String transportationMode, ModelMap modelMap) {
		modelMap.put("travelTime", AlienCalculators.calculateTravelTime(planetName, transportationMode));
		return "alienTravelTimeResult";
	}
}
