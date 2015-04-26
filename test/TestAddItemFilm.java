package test;

import avis.SocialNetwork;
import exception.BadEntry;
import exception.ItemFilmAlreadyExists;
import exception.MemberAlreadyExists;
import exception.NotMember;
/** 
 * @author C. Manda, C. Herzog
 * @date avril 2015
 * @version V1.0
 */

public class TestAddItemFilm {
	
	public static int addItemFilmBadEntryTest (SocialNetwork sn, String pseudo, String pwd, String titre, String genre, String realisateur, String scenariste, int duree, String idTest, String messErreur){
		// vérifie que l'ajout d'un film (pseudo, pwd, titre, genre, realisateur, scenariste, duree) est refusée (levée de l'exception BadEntry et  pas de modification du sn)
		// si c'est bien le cas, ne fait rien
		// sinon, affiche le message d'erreur passé en paramètre
		int nbFilms = sn.nbFilms();
		try {
			sn.addItemFilm (pseudo, pwd, titre, genre, realisateur, scenariste, duree);
			System.out.println ("Test " + idTest + " : " + messErreur);
			return 1;
		}
		catch (BadEntry e) {
			if (sn.nbFilms() != nbFilms) {
				System.out.println("Test " + idTest + " : l'exception BadEntry a bien été levée mais le nombre de films a été modifié");
				return 1;
			}
			else 
				return 0;
		}
		catch (Exception e) {
			System.out.println ("Test " + idTest + " : exception non prévue. " + e); 
			e.printStackTrace();
			return 1;
		}
	}

	public static int addItemFilmOKTest (SocialNetwork sn, String pseudo, String pwd, String titre, String genre, String realisateur, String scenariste, int duree, String idTest){
		int nbFilms = sn.nbFilms();
		try{
			sn.addItemFilm (pseudo, pwd, titre, genre, realisateur, scenariste, duree);
			if (sn.nbFilms() != nbFilms+1) {
				System.out.println("Test " + idTest + " :  le nombre de itemFilms n'a pas été correctement incrémenté");
				return 1;
			}
			else 
				return 0;
		}
		catch (Exception e) {
			System.out.println ("Test " + idTest + " : exception non prévue. " + e); 
			e.printStackTrace();
			return 1;
		}
	}

	public static int addItemFilmAlreadyExistsTest (SocialNetwork sn, String pseudo, String pwd, String titre, String genre, String realisateur, String scenariste, int duree, String idTest, String messErreur){
		int nbFilms = sn.nbFilms();
		try {
			sn.addItemFilm (pseudo, pwd, titre, genre, realisateur, scenariste, duree);
			System.out.println ("Test " + idTest + " : " + messErreur);
			return 1;
		}
		catch (ItemFilmAlreadyExists e) {
			if (sn.nbFilms() != nbFilms) {
				System.out.println("Test " + idTest + " : l'exception ItemFilmAlreadyExists a bien été levée mais le nombre de itemFilms a été modifié");
				return 1;
			}
			else
				return 0;
		}
		catch (Exception e) {
			System.out.println ("Test " + idTest + " : exception non prévue. " + e); 
			e.printStackTrace();
			return 1;
		}
	}
	
	public static int addItemFilmNotMemberTest (SocialNetwork sn, String pseudo, String pwd, String titre, String genre, String realisateur, String scenariste, int duree, String idTest, String messErreur){
		int nbFilms = sn.nbFilms();
		try {
			sn.addItemFilm (pseudo, pwd, titre, genre, realisateur, scenariste, duree);
			System.out.println ("Test " + idTest + " : " + messErreur);
			return 1;
		}
		catch (NotMember e) {
			if (sn.nbFilms() != nbFilms) {
				System.out.println("Test " + idTest + " : l'exception ItemFilmAlreadyExists a bien été levée mais le nombre de itemFilms a été modifié");
				return 1;
			}
			else
				return 0;
		}
		catch (Exception e) {
			System.out.println ("Test " + idTest + " : exception non prévue. " + e); 
			e.printStackTrace();
			return 1;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nbLivres = 0;
		int nbFilms = 0;
		int nbMembres = 0;

		int nbTests = 0;
		int nbErreurs = 0;
		
		System.out.println("Tests  ajouter des itemFilms au réseau social  ");


		SocialNetwork sn = new SocialNetwork();

		// tests de additemFilm
		nbFilms = sn.nbFilms();
		nbLivres = sn.nbBooks();
		nbMembres = sn.nbMembers();
		
		//Instanciation de membres
		try {
			sn.addMember("Antoine", "antoine", "grand amoureux de la littérature");
			sn.addMember("Alice", "alice", "20 ans, sexy");
			sn.addMember("Paul", "paul", "lecteur impulsif");
		} catch (BadEntry e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MemberAlreadyExists e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		// <=> fiche numéro 3

		// tentative d'ajout de itemFilms avec entrées "incorrectes"

		nbTests++;
		nbErreurs += addItemFilmBadEntryTest ( sn, null, "antoine", "a", "", "", "", 1, "1.1", "L'ajout d'un itemFilm dont le pseudo n'est pas instancié est accepté");
		nbTests++;
		nbErreurs += addItemFilmBadEntryTest ( sn, " ", "antoine", "a", "", "", "", 1, "1.2", "L'ajout d'un itemFilm dont le pseudo ne contient que des espaces est accepté");
		nbTests++;
		nbErreurs += addItemFilmBadEntryTest ( sn, "Antoine", null, "a", "", "", "", 1, "1.3", "L'ajout d'un itemFilm dont le password n'est pas instancié est accepté");
		nbTests++;
		nbErreurs += addItemFilmBadEntryTest ( sn, "Antoine", "   qwd", "a", "", "", "", 1, "1.4", "L'ajout d'un itemFilm dont le password a moins de 4 caratères et est accepté");
		nbTests++;
		nbErreurs += addItemFilmBadEntryTest ( sn, "Antoine", "antoine", null, "", "", "", 1, "1.5", "L'ajout d'un itemFilm dont le titre n'est pas instancié est accepté");
		nbTests++;
		nbErreurs += addItemFilmBadEntryTest ( sn, "Antoine", "antoine", " ", "", "", "", 1, "1.6", "L'ajout d'un itemFilm dont le titre ne contient que des espaces est accepté");
		nbTests++;
		nbErreurs += addItemFilmBadEntryTest ( sn, "Antoine", "antoine", "a", null, "", "", 1, "1.7", "L'ajout d'un itemFilm dont le genre n'est pas instancié est accepté");
		nbTests++;
		nbErreurs += addItemFilmBadEntryTest ( sn, "Antoine", "antoine", "a", "", null, "", 1, "1.8", "L'ajout d'un itemFilm dont le réalisateur n'est pas instancié est accepté");
		nbTests++;
		nbErreurs += addItemFilmBadEntryTest ( sn, "Antoine", "antoine", "a", "", "", null, 1, "1.9", "L'ajout d'un itemFilm dont le scénariste n'est pas instancié est accepté");
		nbTests++;
		nbErreurs += addItemFilmBadEntryTest ( sn, "Antoine", "antoine", "a", "", "", "", 0, "1.10", "L'ajout d'un itemFilm dont la durée non positive est accepté");


		// <=> fiche numéro 4

		// ajout de 3 itemFilms avec entrées "correctes"

		nbTests++;
		nbErreurs += addItemFilmOKTest (sn, "Paul", "paul", "Jurassic Park", "", "", "", 1, "2.1a");
		nbTests++;
		nbErreurs += addItemFilmOKTest (sn, "Antoine", "antoine", "Star Wars", "", "", "", 1, "2.1b");
		nbTests++;
		nbErreurs += addItemFilmOKTest (sn, "Alice", "alice", "Back to the Future", "", "", "", 1, "2.1c");

		// tentative d'ajout de membre "existant"

		nbTests++;
		nbErreurs += addItemFilmAlreadyExistsTest(sn, "Paul", "paul", new String("Jurassic Park"), "", "", "", 1, "2.2", "L'ajout d'un itemFilm avec le titre du premier itemFilm ajouté est accepté");
		nbTests++;
		nbErreurs += addItemFilmAlreadyExistsTest(sn, "Alice", "alice",  new String("Back to the Future"), "", "", "", 1, "2.3", "L'ajout d'un itemFilm avec le titre du dernier itemFilm ajouté est accepté");
		nbTests++;
		nbErreurs += addItemFilmAlreadyExistsTest(sn, "Antoine", "antoine", new String("staR warS"), "", "", "", 1, "2.4", "L'ajout d'un itemFilm  avec un titre existant (avec casse différente) est accepté");
		nbTests++;
		nbErreurs += addItemFilmAlreadyExistsTest(sn, "Antoine", "antoine", new String(" Star Wars "), "", "", "", 1, "2.5", "L'ajout d'un itemFilm avec un titre existant (avec leading et trailing blanks) est accepté");		

		// tentative d'ajout de itemFilm avec un mauvais membre
		nbTests++;
		nbErreurs += addItemFilmNotMemberTest(sn, "Michel", "paul", "Lord of the Ring", "", "", "", 1, "2.6", "L'ajout d'un itemFilm avec un mauvais membre est accepté");
		nbTests++;
		nbErreurs += addItemFilmNotMemberTest(sn, "Paul", "antoine", "Harry Potter", "", "", "", 1, "2.7", "L'ajout d'un itemFilm avec un pseudo est un password qui ne correspondent pas est accepté");
		
		
		nbTests++;
		if (nbFilms != sn.nbFilms()) {
			System.out.println("Erreur  :  le nombre de films après utilisation de addItemFilm a été modifié");
			nbErreurs++;
		}
		nbTests++;
		if (nbLivres != sn.nbBooks()) {
			System.out.println("Erreur  :  le nombre de livres après utilisation de addItemFilm a été modifié");	
			nbErreurs++;
		}
		nbTests++;
		if (nbMembres != sn.nbMembers()) {
			System.out.println("Erreur  :  le nombre de membres après utilisation de addItemFilm a été modifié");	
			nbErreurs++;
		}

		// ce n'est pas du test, mais cela peut "rassurer"...
		System.out.println(sn);

		// bilan du test de addItemFilm
		System.out.println("TestsAddItemFilm :   " + nbErreurs + " erreur(s) / " +  nbTests + " tests effectués");

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
