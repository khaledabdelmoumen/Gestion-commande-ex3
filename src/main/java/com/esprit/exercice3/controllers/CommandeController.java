package com.esprit.exercice3.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.exercice3.entities.Commande;
import com.esprit.exercice3.repository.CommandeRepository;
import com.esprit.exercice3.services.CommandeService;

@RestController
@RequestMapping("/commande")
public class CommandeController {
	
	@Autowired
	CommandeService Cs;
	
	


	//Q1
	@GetMapping("/getcommandeencoursdelivres")
	public Set<Commande> getcommandesencoursdelivrees()
	{		
		return Cs.AfficherListCommandesEncoursDelivres();
	}
	
	
	//Q2
	@GetMapping("/getcommandeencoursvalides")
	public Set<Commande> getcommandesencoursvalides()
	{		
		return Cs.AfficherListCommandesEncoursValides();
	}
	
	//Q3
	@GetMapping("/getcommandesenretard")
	public Set<Commande> getcommandesenretard()
	{		
		return Cs.AfficherListeCommanderEnRetards();
	}

}
