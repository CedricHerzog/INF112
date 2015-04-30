package test;

import exception.BadEntry;
import exception.NotItem;
import exception.NotMember;
import avis.SocialNetwork;

/** 
 * @author C. Manda, C. Herzog
 * @date avril 2015
 * @version V1.0
 */

public class TestReviewItemFilm {
	
		/**
		*											Test fonction reviewItemFilm :
		*
		* Les différentes méthodes vérifient que la review d'un film (pseudo, pwd, profil) est refusée (levée de l'exception BadEntry)
		* Si c'est bien le cas, ne fait rien
		* Sinon, affiche le message d'erreur passé en paramètre
		* 
		* @param sn social network
		* @param pseudo pseudo du membre émettant l'opinion
		* @param password son mot de passe
		* @param titre titre du film  concerné
		* @param note la note qu'il donne au film 
		* @param commentaire ses commentaires
		* @param idTest l'id octroyé au test
		* @param messErreur le message d'erreur à afficher
		* 		
		* @return 1 si une anomalie est trouvée, 0 sinon (exception conforme détectée)
		*/
	
	public static int reviewItemFilmBadEntryTest (SocialNetwork sn, String pseudo, String password, String titre, float note, String commentaire, String idTest, String messErreur){
	// Test la levée d'exception BadEntry
		try {
			sn.reviewItemFilm(pseudo, password, titre, note, commentaire);
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
	
	public static int reviewItemFilmNotMemberTest (SocialNetwork sn, String pseudo, String password, String titre, float note, String commentaire, String idTest, String messErreur){
	// Test la levée d'exception NotMember
		try {
			sn.reviewItemFilm(pseudo, password, titre, note, commentaire);
			System.out.println ("Test " + idTest + " : " + messErreur);
			// Aucune exception levée, retourne donc 1
			return 1;
		}
		catch (NotMember e ) {
			// L'exception NotMember est levée, retourne donc 0
			return 0;
		}
		
		catch (Exception e){
			System.out.println ("Test " + idTest + " : exception non prévue. " + e); 
			e.printStackTrace();
			// Une autre exception est levée que NotMember,retourne donc 1
			return 1;
		}
	}
	
	public static int reviewItemFilmNotItemTest (SocialNetwork sn, String pseudo, String password, String titre, float note, String commentaire, String idTest, String messErreur){
		// Test la levée d'exception NotItem
			try {
				sn.reviewItemFilm(pseudo, password, titre, note, commentaire);
				System.out.println ("Test " + idTest + " : " + messErreur);
				// Aucune exception levée, retourne donc 1
				return 1;
			}
			catch (NotItem e ) {
				// L'exception NotItem est levée, retourne donc 0
				return 0;
			}
			
			catch (Exception e){
				System.out.println ("Test " + idTest + " : exception non prévue. " + e); 
				e.printStackTrace();
				// Une autre exception est levée que NotItem,retourne donc 1
				return 1;
			}
		}
	
	public static int reviewItemFilmOKTest (SocialNetwork sn, String pseudo, String password, String titre, float note, String commentaire, String idTest, float moyennedesiree){
		// @param  moyenne 
		float moyenne;
		try{
			moyenne=sn.reviewItemFilm (pseudo, password, titre, note, commentaire);
			if (moyenne!=moyennedesiree )
			{
				System.out.println ("Test " + idTest + " : La valeur de la moyenne de l'ItemFilm est différente de celle attendue");
				// Moyenne différente de celle attendue, retourne donc 1
				return 1;
			}
			else
			{
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
		
		System.out.println("Tests  ajouter review à itemFilms au réseau social  ");
		SocialNetwork sn = new SocialNetwork();
		int nbTests = 0;
		int nbErreurs = 0;
	
		// Initialisation :
		try{
		sn.addMember("Paul", "paul", "Disneyland aussi a eu quelques difficultés à ses débuts !");
		sn.addMember("Antoine", "antoine", "Que la Force soit avec toi.");
		sn.addMember("Paul", "paul", "Quitte à voyager dans le temps au volant d'une voiture, autant en choisir une qui ait de la gueule !");

		sn.addItemFilm ("Paul", "paul", "Jurassic Park", "a", "a", "a", 1);
		sn.addItemFilm ("Antoine", "antoine", "Star Wars", "a", "a", "a", 1);
		sn.addItemFilm ("Alice", "alice", "Back to the Future", "a", "a", "a", 1);
		}
		catch (Exception e){
			System.out.println("Paramètres incorrects lors de la création de membres et de films. Voir tests associés. ");
			System.exit(1);
		}
		
		int nbFilms = sn.nbFilms();
		int nbBooks = sn.nbBooks();
		int nbMembers = sn.nbMembers();


		// <=> fiche numéro 5

		// tentative d'ajout de review avec entrées "incorrectes"
		nbTests++;
		nbErreurs += reviewItemFilmBadEntryTest ( sn, null, "paul", "Titre", 1, "Bien", "5.01", "L'ajout d'une review avec un pseudo non instancié est accepté");
		nbTests++;
		nbErreurs += reviewItemFilmBadEntryTest ( sn,"     ", "paul", "Titre", 1, "Bien", "5.02", "L'ajout d'une review avec un pseudo qui ne contient que des espaces est accepté");
		nbTests++;
		nbErreurs += reviewItemFilmBadEntryTest ( sn, "Paul", null, "Titre", 1, "Bien", "5.03", "L'ajout d'une review avec un password non instancié est accepté");
		nbTests++;
		nbErreurs += reviewItemFilmBadEntryTest ( sn,"Paul", "non", "Titre", 1, "Bien", "5.04", "L'ajout d'une review  avec un password de moins de 4 caractères est accepté");
		nbTests++;
		nbErreurs += reviewItemFilmBadEntryTest ( sn, "Paul", "paul", null, 1, "Bien", "5.05", "L'ajout d'une review avec un titre non instancié est accepté");
		nbTests++;
		nbErreurs += reviewItemFilmBadEntryTest ( sn, "Paul", "paul", "      ", 1, "Bien", "5.06", "L'ajout d'une review avec un titre qui ne contient que des espaces est accepté");
		nbTests++;
		nbErreurs += reviewItemFilmBadEntryTest ( sn,"Paul", "paul", "Titre", 10, "Bien", "5.07", "L'ajout d'une review avec une note non comprise entre 0 et 5 est accepté");
		nbTests++;
		nbErreurs += reviewItemFilmBadEntryTest ( sn,"Paul", "paul", "Titre", 1, null, "5.08", "L'ajout d'une review avec un commentaire non instancié est accepté");


		// <=> fiche numéro 6

		// tentative d'ajout de review avec entrées "correctes"
		nbTests++;
		nbErreurs += reviewItemFilmOKTest ( sn,"Paul", "paul", "Jurassic Park", 5, "Je suis toujours à la recherche d'un plus grand monument du cinéma ", "6.01a", 5);
		nbTests++;
		nbErreurs += reviewItemFilmOKTest ( sn,"Antoine", "antoine", "Star Wars", 4, "Un chef d'oeuvre", "6.01b", 4);
		nbTests++;
		nbErreurs += reviewItemFilmOKTest ( sn,"Alice", "alice", "Back to the Future", 5, "J'adore ! Rendez-vous en 2015 pour retrouver les personnages dans le futur.", "6.01c", 5);
		
		// modification de la review par le même membre (nouvelle note donnée 5, moyenne attendue 5)
		nbTests++;
		nbErreurs += reviewItemFilmOKTest ( sn,"Antoine", "antoine", "Star Wars", 5, "Un chef d'oeuvre, assurément", "6.02", 5);
		
		// ajout d'une seconde review par un autre membre (note donnée 4, moyenne attendue 4.5)
		nbTests++;
		nbErreurs += reviewItemFilmOKTest ( sn,"Alice", "alice", "Star Wars", 4, "Bons fims", "6.03", 9/5);
		
		// modification de la seconde review (nouvelle note donnée 3, moyenne attendue 4)
		nbTests++;
		nbErreurs += reviewItemFilmOKTest ( sn,"Alice", "alice", "Star Wars", 3, "Sympa", "6.04", 4);

		// ajout d'une review pour un film avec un pseudo ne correspodant à aucun membre
		nbTests++;
		nbErreurs += reviewItemFilmNotMemberTest ( sn,"Lili", "alice", "Star Wars", 5, "Cool", "6.05", "L'ajout d'une review avec un pseudo qui n'est pas un membre est accepté");
		
		// ajout d'une review pour un film avec un mot de passe qui ne correspond pas au pseudo du membre
		nbTests++;
		nbErreurs += reviewItemFilmNotMemberTest ( sn,"Alice", "lili", "Star Wars", 5, "Bien", "6.06", "L'ajout d'une review avec un password qui ne correspond pas à un membre est accepté");
		
		// ajout d'une review sur un film qui n'est pas dans la base. 
		nbTests++;
		nbErreurs += reviewItemFilmNotItemTest ( sn,"Paul", "paul", "Indiana Jones", 5, "Un classique", "6.07", "L'ajout d'une review avec un pseudo qui n'est pas un membre est accepté");
		
		nbTests++;
		if (nbFilms != sn.nbFilms()) {
			System.out.println("Erreur  :  le nombre de films après utilisation de reviewItemFilm a été modifié");
			nbErreurs++;
		}
		nbTests++;
		if (nbBooks != sn.nbBooks()) {
			System.out.println("Erreur  :  le nombre de livres après utilisation de reviewItemFilm a été modifié");	
			nbErreurs++;
		}
		nbTests++;
		if (nbMembers != sn.nbMembers()) {
			System.out.println("Erreur  :  le nombre de membres après utilisation de reviewItemFilm a été modifié");	
			nbErreurs++;
		}

		// ce n'est pas du test, mais cela peut "rassurer"...
		System.out.println(sn);

		// bilan du test de addItemFilm
		System.out.println("TestsReviewItemFilm :   " + nbErreurs + " erreur(s) / " +  nbTests + " tests effectués");
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