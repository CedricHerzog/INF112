package test;

import java.util.LinkedList;

import exception.BadEntry;
import avis.SocialNetwork;

/** 
 * @author C. Manda, C. Herzog
 * @date avril 2015
 * @version V1.0
 */

public class TestConsultItem {
	
		/**
		*											Test fonction reviewItemBook :
		*
		* Les différentes méthodes vérifient que la review d'un Book (pseudo, pwd, profil) est refusée (levée de l'exception BadEntry)
		* Si c'est bien le cas, ne fait rien
		* Sinon, affiche le message d'erreur passé en paramètre
		* 
		* @param sn social network
		* @param pseudo pseudo du membre émettant l'opinion
		* @param password son mot de passe
		* @param titre titre du Book  concerné
		* @param note la note qu'il donne au Book 
		* @param commentaire ses commentaires
		* @param idTest l'id octroyé au test
		* @param messErreur le message d'erreur à afficher
		* 		
		* @return 1 si une anomalie est trouvée, 0 sinon (exception conforme détectée)
		*/
	
	public static int consultItemsBadEntryTest (SocialNetwork sn, String nom, String idTest, String messErreur){
	// Test la levée d'exception BadEntry
		try {
			sn.consultItems(nom);
			System.out.println ("Test " + idTest + " : " + messErreur);
			// Aucune exception levée, retourne donc 1
			return 1;
		}
		catch (BadEntry e ) {
			// L'exception BadEntry est levée, retourne donc 0
			return 0;
		}
		
		catch (Exception e){
			System.out.println ("Test " + idTest + " : exception non prévue. " + e); 
			e.printStackTrace();
			// Une autre exception est levée que BadEntry,retourne donc 1
			return 1;
		}
	}
	
	public static int consultItemsOKTest (SocialNetwork sn,String nom, String idTest){
		// @param  moyenne 
				LinkedList<String> resultat;
				try{
					resultat=sn.consultItems(nom);
					if (resultat.isEmpty())
					{
						System.out.println ("Test " + idTest + " : le résultat est vide");
						// Moyenne différente de celle attendue, retourne donc 1
						return 1;
					}
					else
					{
						System.out.println(resultat);
						return 0;
					}

				}
				catch (Exception e) {
					System.out.println ("Test " + idTest + " : exception non prévue. " + e); 
					e.printStackTrace();
					return 1;
				}
	}
	
	/* *************************************************************************************************************************************************************************** */
	
	public static void main(String[] args) {
		
		System.out.println("Tests  ajouter review à itemBooks au réseau social  ");
		SocialNetwork sn = new SocialNetwork();
		int nbTests = 0;
		int nbErreurs = 0;
	
		// Initialisation :
		try{
		sn.addMember("Paul", "paul", "Disneyland aussi a eu quelques difficultés à ses débuts !");
		sn.addMember("Antoine", "antoine", "Que la Force soit avec toi.");
		sn.addMember("Alice", "alice", "Quitte à voyager dans le temps au volant d'une voiture, autant en choisir une qui ait de la gueule !");

		sn.addItemBook ("Paul", "paul", "Jurassic Park", "a", "a", 1);
		sn.addItemBook ("Antoine", "antoine", "Star Wars", "a", "a", 1);
		sn.addItemBook ("Alice", "alice", "Back to the Future", "a", "a", 1);
		
		sn.addItemFilm ("Paul", "paul", "Jurassic Park", "a", "a", "a", 1);
		sn.addItemFilm ("Antoine", "antoine", "Star Wars", "a", "a", "a", 1);
		sn.addItemFilm ("Alice", "alice", "Back to the Future", "a", "a", "a", 1);
		
		sn.reviewItemBook ("Paul", "paul", "Star Wars", 3, "Bof");
		sn.reviewItemBook ("Paul", "paul", "Back to the future", 4, "Pas mal");
		sn.reviewItemBook ("Antoine", "antoine", "Back to the future", 5, "Très bien");
		
		sn.reviewItemFilm ("Paul", "paul", "Star Wars", 3, "Bof");
		sn.reviewItemFilm ("Paul", "paul", "Back to the future", 4, "Pas mal");
		sn.reviewItemFilm ("Antoine", "antoine", "Back to the future", 5, "Très bien");
		}
		catch (Exception e){
			System.out.println("Paramètres incorrects lors de la création de membres et de Books. Voir tests associés. ");
			System.exit(1);
		}
		
		int nbBooks = sn.nbBooks();
		int nbFilms = sn.nbFilms();
		int nbMembers = sn.nbMembers();


		// <=> fiche numéro 5

		// tentative d'ajout de review avec entrées "incorrectes"
		nbTests++;
		nbErreurs += consultItemsBadEntryTest ( sn, null, "5.01", "La recherche d'items avec un nom non instancié est accepté");
		nbTests++;
		nbErreurs += consultItemsBadEntryTest ( sn, " ", "5.02", "La recherche d'item avec un nom qui ne contient que des espaces est accepté");


		// <=> fiche numéro 6

		// tentative d'ajout de review avec entrées "correctes"
		nbTests++;
		nbErreurs += consultItemsOKTest ( sn,"Star Wars", "6.01a");
		nbTests++;
		nbErreurs += consultItemsOKTest ( sn,"Jurassic Park", "6.01b");
		nbTests++;
		nbErreurs += consultItemsOKTest ( sn,"Back to the future", "6.01c");
		
		
		
		
		nbTests++;
		if (nbBooks != sn.nbBooks()) {
			System.out.println("Erreur  :  le nombre de Books après utilisation de reviewItemBook a été modifié");
			nbErreurs++;
		}
		nbTests++;
		if (nbFilms != sn.nbFilms()) {
			System.out.println("Erreur  :  le nombre de Films après utilisation de reviewItemBook a été modifié");	
			nbErreurs++;
		}
		nbTests++;
		if (nbMembers != sn.nbMembers()) {
			System.out.println("Erreur  :  le nombre de membres après utilisation de reviewItemBook a été modifié");	
			nbErreurs++;
		}

		// ce n'est pas du test, mais cela peut "rassurer"...
		System.out.println(sn);
		// bilan du test de addItemBook
		System.out.println("TestsReviewItemBook :   " + nbErreurs + " erreur(s) / " +  nbTests + " tests effectués");
		//On modifie l'argument qui sera utilisé dans le prochain test
				//Comme l'argument est de type string, on doit effectuer des conversion de type
				if ((args != null) && (args.length == 2)) {        
		            nbTests = nbTests + new Integer(args[0]);
		            nbErreurs = nbErreurs + new Integer(args[1]);       
		            args[0] = "" + nbTests;
		            args[1] = "" + nbErreurs;
		         }
	}
}