package com.nure.animals.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nure.animals.dao.*;
import com.nure.animals.entities.*;

import java.sql.SQLException;
import java.util.List;

@Controller
public class MainController {
	
	ClientDescription clients = new ClientDescription();
	AnimalsDescription animals = new AnimalsDescription();
	AgriculturalDescription agriculturals = new AgriculturalDescription();
	WildDescription wilds = new WildDescription(); 
	
	@GetMapping("/")
	public String loadMainPage(Model model) {
		List<Client> clientsList = null;
		List<Animals> animalsList = null;
		List<Agricultural> agriculturalsList = null;
		List<Wild> wildsList = null;
		
		try {
			clientsList = clients.getAll();
			animalsList = animals.getAll();
			agriculturalsList = agriculturals.getAll();
			wildsList = wilds.getAll();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("clients", clientsList);
		model.addAttribute("animals", animalsList);
		model.addAttribute("agriculturalAnimals", agriculturalsList);
		model.addAttribute("wildAnimals", wildsList);
		
		return "main";
	}
	
	@PostMapping("/")
	public String getById(
			@RequestParam String clientId,
			@RequestParam String animalId,
			@RequestParam String agrAnimalId,
			@RequestParam String wildAnimalId,
			Model model
			) {
		
		int _clientId = clientId.equals("")? 0: Integer.valueOf(clientId);
		int _animalId = animalId.equals("")? 0: Integer.valueOf(animalId);
		int _agrAnimalId = agrAnimalId.equals("")? 0: Integer.valueOf(agrAnimalId);
		int _wildAnimalId = wildAnimalId.equals("")? 0: Integer.valueOf(wildAnimalId);
		
		if (_clientId == 0 && _animalId == 0 && _agrAnimalId == 0 && _wildAnimalId == 0) {
			List<Client> clientsList = null;
			List<Animals> animalsList = null;
			List<Agricultural> agriculturalsList = null;
			List<Wild> wildsList = null;
			
			try {
				clientsList = clients.getAll();
				animalsList = animals.getAll();
				agriculturalsList = agriculturals.getAll();
				wildsList = wilds.getAll();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			model.addAttribute("clients", clientsList);
			model.addAttribute("animals", animalsList);
			model.addAttribute("agriculturalAnimals", agriculturalsList);
			model.addAttribute("wildAnimals", wildsList);
			
			return "main";
		}
		
		Client client = null;
		Animals animal = null;
		Agricultural agricultural = null;
		Wild wild = null;
		
		try {
			client = clients.getById(_clientId);
			animal = animals.getById(_animalId);
			agricultural = agriculturals.getById(_agrAnimalId);
			wild = wilds.getById(_wildAnimalId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("clients", client);
		model.addAttribute("animals", animal);
		model.addAttribute("agriculturalAnimals", agricultural);
		model.addAttribute("wildAnimals", wild);
		
		return "main";
	}
	
	@GetMapping("/addClient")
	public String loadAddClientPage(Model model) {
		return "add-client";
	}
	
	@PostMapping("/addClient")
	public String addClient(
			@RequestParam String name,
			Model model
			) {
		
		Client c = new Client();
		c.setName(name);
		
		try {
			clients.add(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "main";
	}
	
	@GetMapping("/addAnimal")
	public String loadAddAnimalPage(Model model) {
		return "add-animal";
	}
	
	@PostMapping("/addAnimal")
	public String addAnimal(
			@RequestParam int price,
			@RequestParam String name,
			@RequestParam int idClient,
			Model model
			) {
		
		Animals a = new Animals();
		a.setIdClient(idClient);
		a.setName(name);
		a.setPrice(price);
		
		try {
			animals.add(a);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "main";
	}
	
	@GetMapping("/addAgrAnimal")
	public String loadAddAgrAnimalPage(Model model) {
		return "add-agr-animal";
	}
	
	@PostMapping("/addAgrAnimal")
	public String addAgrAnimal(
			@RequestParam int quantity,
			@RequestParam int idAnimal,
			Model model
			) {
		
		Agricultural a = new Agricultural();
		a.setQuantity(quantity);
		a.setIdAnimals(idAnimal);
		
		try {
			agriculturals.add(a);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "main";
	}
	
	@GetMapping("/addWildAnimal")
	public String loadAddWildAnimalPage(Model model) {
		return "add-wild";
	}
	
	@PostMapping("/addWildAnimal")
	public String addWildAnimal(
			@RequestParam int maxSpeed,
			@RequestParam int idAnimal,
			Model model
			) {
		
		Wild w = new Wild();
		w.setMaxSpeed(maxSpeed);
		w.setIdAnimals(idAnimal);
		
		try {
			wilds.add(w);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "main";
	}
	
	@GetMapping("/delete")
	public String loadDelete(Model model) {
		return "delete";
	}
	
	@PostMapping("/delete")
	public String delete(
			@RequestParam String clientId,
			@RequestParam String animalId,
			@RequestParam String agrAnimalId,
			@RequestParam String wildAnimalId,
			Model model
			) {
		
		int _clientId = clientId.equals("")? 0: Integer.valueOf(clientId);
		int _animalId = animalId.equals("")? 0: Integer.valueOf(animalId);
		int _agrAnimalId = agrAnimalId.equals("")? 0: Integer.valueOf(agrAnimalId);
		int _wildAnimalId = wildAnimalId.equals("")? 0: Integer.valueOf(wildAnimalId);
		
		Client c = new Client(); c.setIdClient(_clientId);
		Animals a = new Animals(); a.setIdAnimals(_animalId);
		Agricultural aa = new Agricultural(); aa.setIdAgricultural(_agrAnimalId);
		Wild wa = new Wild(); wa.setIdWild(_wildAnimalId);
		
		try {
			clients.delete(c);
			animals.delete(a);
			agriculturals.delete(aa);
			wilds.delete(wa);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "main";
	}
}
