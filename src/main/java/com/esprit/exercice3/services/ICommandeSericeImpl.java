package com.esprit.exercice3.services;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.exercice3.entities.Commande;
import com.esprit.exercice3.entities.CommandeRedacteur;
import com.esprit.exercice3.entities.Text;
import com.esprit.exercice3.repository.CommandeRedacteurRepository;
import com.esprit.exercice3.repository.CommandeRepository;
import com.esprit.exercice3.repository.TextRepository;


@Service
public class ICommandeSericeImpl implements CommandeService{

	

	@Autowired
	CommandeRedacteurRepository commanderedacteurRep ;
	
	
	@Autowired
	CommandeRepository commanderepository ;
	
	@Autowired 
	TextRepository textrepository;
	
	
	//Q1
	@Override
	public Set<Commande> AfficherListCommandesEncoursDelivres() {
		
	 Set<Commande> resultat=new HashSet<Commande>();
	
	 for(Commande c:commanderepository.findAll())
	 {
		 //variable de test pour savoir est ce que les texts du commandes en cours
		 //sont délivrer ou pas et la commande contients des texts non vides
		 int test =0;
		 
		 //liste de commande en cours 
		 Set<CommandeRedacteur> Listescommandesencrs=commanderedacteurRep.findByCommande(c);
		
		 
		 //pour asurer la continuité => l'example d dernier valide ne compte pas vrai
	     int test1=1;
		 for (CommandeRedacteur cr:Listescommandesencrs) 
		 { 
			//traitement pour voir est ce que cette commande ou en cours ou non
			 Date date = new Date();
		     SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		     
		 	if (cr.getDeadline().compareTo(date) <= 0 ) {
		 		
			//Les text du chaque redacteur si cette affecation est courrante 
			 Set<Text> Listestexts=textrepository.findByCommanderedacteur(cr); 
		   for (Text t:Listestexts)
		    {
			 	if ( (t.getDelivered_at() == null))
			 	{
			 		
			 	    test1=0;
			 		
			 	}else
			 	{   
			 		test = 1;
			 	}
			 
		    }
		 	}
		 	else {
		 		test=0;
		 	}
		  
		 
		 }
		 if (test == 1 && test1==1)
		  {
		  	 resultat.add(c);
		  }
		 
	 }
		return resultat;
	}
	
	
	
	
	// Q2
	public Set<Commande> AfficherListCommandesValides()
	{
		
		 Set<Commande> resultat=new HashSet<Commande>();
			
		 for(Commande c:commanderepository.findAll())
		 {
			 //variable de test pour savoir est ce que les texts du commandes en cours sont valider ou pas 
			 int test =0;
			 
			 //liste de commande en cours 
			 Set<CommandeRedacteur> Listescommandesencrs=commanderedacteurRep.findByCommande(c);
			 
			 
			 //pour asurer la continuité => l'example d dernier valide ne compte pas vrai
			 int test1=1;
			 for (CommandeRedacteur cr:Listescommandesencrs) {
				//Les text du chaque commande 
				
				 Set<Text> Listestexts=textrepository.findByCommanderedacteur(cr);
				 //on suppose que les textes du cette commandes sont tous validés
				 
			 for (Text t:Listestexts)
			 {
				 	if ( (t.getValidated_at() == null))
				 	{
				 		
				 		test1=0;
				 	}else
				 	{
				 		test = 1;
				 	}
			 }
			 
			
			 
			 }
			 if (test == 1 && test1 == 1 )
			 {
				 resultat.add(c);
			 } 
		 }
			return resultat;
	}
	
	
	
	
	
	
	//Q3
	public Set<Commande> AfficherListeCommanderEnRetards()
	{   //intiliasation du liste du resultat
		Set<Commande> resultat=new HashSet<Commande>();
		
		 for(Commande c:commanderepository.findAll())
		 { 	 //intiliasation
			 int test=0;
			 //liste des commande en affectées a des redacteurs
			 Set<CommandeRedacteur> Listescommandesencrs=commanderedacteurRep.findByCommande(c);
		     
			 //Calcule du nombre totale des textes commandées
			 int nbrtxttotale=0;
			 for (CommandeRedacteur cr:Listescommandesencrs) {
				nbrtxttotale= nbrtxttotale+cr.getNbr_text();
			 }
			 Date date = new Date();
		     SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			 //calcule du nombre des text validées avant le deadline
			 int txtvalidesavantdeadline=0;
			 for (CommandeRedacteur cr:Listescommandesencrs)
			  {
				// On test si le deadline a passer pour tester si cetter commande en retard ou pas 
				if (cr.getDeadline().compareTo(date) >= 0 )
				{
			    Set<Text> Listestexts=textrepository.findByCommanderedacteur(cr);
			    for (Text t:Listestexts)
			    	{
			    		if (t.getValidated_at() != null)
			    		{
			    		txtvalidesavantdeadline=txtvalidesavantdeadline+1;
			    		}
			    	}
				}else 
				{
					test=1;
				}
		      }  
			 //on test si les validées sont inferieure a nbr text totale
			 //et tous les date sont passées
		if (txtvalidesavantdeadline < nbrtxttotale  && test==0)
		{
			resultat.add(c);
		}
	}
		 return resultat;
   }
	
	//Q4
	public void Caluculercoutparaffectation()
	{   
		 
		 for (CommandeRedacteur cr:commanderedacteurRep.findAll())
		 {
			 //nombre totale de text
			 int nbrtotal=cr.getNbr_text();
			 // nombre de texts valides et livrées par affectations
			 int nbrvalide=0;
			 int nbrlivrees=0;
			  for (Text t:textrepository.findByCommanderedacteur(cr))
			  {
				  if (t.getDelivered_at() != null) {
					  nbrlivrees++;
				  }
				  if (t.getValidated_at() != null) {
					  nbrvalide++;
				  }
			  }
			  //tester cette ligne est aureel ou pas , 2 traitements differents
			 if (cr.isReel())
			 { 
				 //Pour une commande affectée au réel 
				 
				 
				 //init variables
				 
				 double coutachat=0;
			 	 double totalefacture=0;
			 	 int totale_text_ajoute=0;
			 	 
			 	 //calcul du facture totale de tous les text validéesdu commande affectée e
			 	 //t le nombre totale de mot ajoutées
				  for (Text t:textrepository.findByCommanderedacteur(cr)) 
				  {  
					  //calcul du text ajouter au totale
					  totale_text_ajoute=totale_text_ajoute+t.getTotal_number_of_text_added();
					
					  if (t.getValidated_at() != null )
					{
						totalefacture=totalefacture+(t.getTotal_number_of_text_added()*cr.getTarif());
					}
				  }
				  //on test si les mots ajoutées sont superieure du mot_max attendu + 10% ou pas
				  if (  totale_text_ajoute > ((0.1*cr.getNbr_mot_max())+cr.getNbr_mot_max()))
					 { 
					  coutachat=(cr.getNbr_mot_max()*1.1)+
				       ((totale_text_ajoute- cr.getNbr_mot_achete())*cr.getTarif());
					
					 }else 
					 {
						 coutachat= cr.getTarif()*totale_text_ajoute;
					 }
				  System.out.print(cr.getRedacteur()+ " | " + cr.getCommande() +" | "
					 + coutachat + " | "+ totalefacture);
			 }
			 else
			 {  
				 //Pour une commande affectée ferme 
				 
				 double coutachat=(cr.getNbr_mot_achete()*cr.getTarif())*nbrlivrees;
				 double coutachatestime=(cr.getNbr_mot_achete()*cr.getTarif())*nbrtotal;
				 double totalefacture=(cr.getNbr_mot_achete()*cr.getTarif())*nbrvalide;
				 
				 System.out.print(cr.getRedacteur()+ " | " + cr.getCommande() +" | "
						 + coutachat + " | " + coutachatestime + "|"+ totalefacture);
			 }
			 
			
		 }
		
	}

}
