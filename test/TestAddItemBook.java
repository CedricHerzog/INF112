package test;

import avis.SocialNetwork;
import exception.BadEntry;
import exception.ItemBookAlreadyExists;
import exception.MemberAlreadyExists;
import exception.NotMember;
/** 
 * @author C. Manda, C. Herzog
 * @date avril 2015
 * @version V1.0
 */

public class TestAddItemBook {
	
	public static int addItemBookBadEntryTest (SocialNetwork sn, String pseudo, String pwd, String titre, String genre, String auteur, int nbPages, String idTest, String messErreur){
		// vérifie que l'ajout d'un Book (pseudo, pwd, titre, genre, realisateur, scenariste, duree) est refusée (levée de l'exception BadEntry et  pas de modification du sn)
		// si c'est bien le cas, ne fait rien
		// sinon, affiche le message d'erreur passé en paramètre
		int nbBooks = sn.nbBooks();
		try {
			sn.addItemBook (pseudo, pwd, titre, genre, auteur, nbPages);
			System.out.println ("Test " + idTest + " : " + messErreur);
			return 1;
		}
		catch (BadEntry e) {
			if (sn.nbBooks() != nbBooks) {
				System.out.println("Test " + idTest + " : l'exception BadEntry a bien été levée mais le nombre de Books a été modifié");
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

	public static int addItemBookOKTest (SocialNetwork sn, String pseudo, String pwd, String titre, String genre, String auteur, int nbPages, String idTest){
		int nbBooks = sn.nbBooks();
		try{
			sn.addItemBook (pseudo, pwd, titre, genre, auteur, nbPages);
			if (sn.nbBooks() != nbBooks+1) {
				System.out.println("Test " + idTest + " :  le nombre de itemBooks n'a pas été correctement incrémenté");
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

	public static int addItemBookAlreadyExistsTest (SocialNetwork sn, String pseudo, String pwd, String titre, String genre, String auteur, int nbPages, String idTest, String messErreur){
		int nbBooks = sn.nbBooks();
		try {
			sn.addItemBook (pseudo, pwd, titre, genre, auteur, nbPages);
			System.out.println ("Test " + idTest + " : " + messErreur);
			return 1;
		}
		catch (ItemBookAlreadyExists e) {
			if (sn.nbBooks() != nbBooks) {
				System.out.println("Test " + idTest + " : l'exception ItemBookAlreadyExists a bien été levée mais le nombre de itemBooks a été modifié");
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
	
	public static int addItemBookNotMemberTest (SocialNetwork sn, String pseudo, String pwd, String titre, String genre, String auteur, int nbPages, String idTest, String messErreur){
		int nbBooks = sn.nbBooks();
		try {
			sn.addItemBook (pseudo, pwd, titre, genre, auteur, nbPages);
			System.out.println ("Test " + idTest + " : " + messErreur);
			return 1;
		}
		catch (NotMember e) {
			if (sn.nbBooks() != nbBooks) {
				System.out.println("Test " + idTest + " : l'exception ItemBookAlreadyExists a bien été levée mais le nombre de itemBooks a été modifié");
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
		int nbFilms = 0;
		int nbMembres = 0;

		int nbTests = 0;
		int nbErreurs = 0;
		
		System.out.println("Tests  ajouter des itemBooks au réseau social  ");


		SocialNetwork sn = new SocialNetwork();

		
		
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
		// tests de additemBook
				nbFilms = sn.nbFilms();
				nbMembres = sn.nbMembers();

		// <=> fiche numéro 3

		// tentative d'ajout de itemBooks avec entrées "incorrectes"

		nbTests++;
		nbErreurs += addItemBookBadEntryTest ( sn, null, "antoine", "a", "a", "a", 1, "3.1", "L'ajout d'un itemBook dont le pseudo n'est pas instancié est accepté");
		nbTests++;
		nbErreurs += addItemBookBadEntryTest ( sn, " ", "antoine", "a", "a", "a",  1, "3.2", "L'ajout d'un itemBook dont le pseudo ne contient que des espaces est accepté");
		nbTests++;
		nbErreurs += addItemBookBadEntryTest ( sn, "Antoine", null, "a", "a", "a",  1, "3.3", "L'ajout d'un itemBook dont le password n'est pas instancié est accepté");
		nbTests++;
		nbErreurs += addItemBookBadEntryTest ( sn, "Antoine", "   qwd", "a", "a", "a",  1, "3.4", "L'ajout d'un itemBook dont le password a moins de 4 caratères et est accepté");
		nbTests++;
		nbErreurs += addItemBookBadEntryTest ( sn, "Antoine", "antoine", null, "a", "a",  1, "3.5", "L'ajout d'un itemBook dont le titre n'est pas instancié est accepté");
		nbTests++;
		nbErreurs += addItemBookBadEntryTest ( sn, "Antoine", "antoine", " ", "a", "a",  1, "3.6", "L'ajout d'un itemBook dont le titre ne contient que des espaces est accepté");
		nbTests++;
		nbErreurs += addItemBookBadEntryTest ( sn, "Antoine", "antoine", "a", null, "a",  1, "3.7", "L'ajout d'un itemBook dont le genre n'est pas instancié est accepté");
		nbTests++;
		nbErreurs += addItemBookBadEntryTest ( sn, "Antoine", "antoine", "a", "a", null,  1, "3.8", "L'ajout d'un itemBook dont le réalisateur n'est pas instancié est accepté");
		nbTests++;
		nbErreurs += addItemBookBadEntryTest ( sn, "Antoine", "antoine", "a", "a", "a", 0, "3.10", "L'ajout d'un itemBook dont la durée non positive est accepté");


		// <=> fiche numéro 4

		// ajout de 3 itemBooks avec entrées "correctes"

		nbTests++;
		nbErreurs += addItemBookOKTest (sn, "Paul", "paul", "Jurassic Park", "a", "a", 1, "4.1a");
		nbTests++;
		nbErreurs += addItemBookOKTest (sn, "Antoine", "antoine", "Star Wars", "a", "a",  1, "4.1b");
		nbTests++;
		nbErreurs += addItemBookOKTest (sn, "Alice", "alice", "Back to the Future", "a", "a", 1, "4.1c");

		// tentative d'ajout de membre "existant"

		nbTests++;
		nbErreurs += addItemBookAlreadyExistsTest(sn, "Paul", "paul", new String("Jurassic Park"), "a", "a", 1, "4.2", "L'ajout d'un itemBook avec le titre du premier itemBook ajouté est accepté");
		nbTests++;
		nbErreurs += addItemBookAlreadyExistsTest(sn, "Alice", "alice",  new String("Back to the Future"), "a", "a", 1, "4.3", "L'ajout d'un itemBook avec le titre du dernier itemBook ajouté est accepté");
		nbTests++;
		nbErreurs += addItemBookAlreadyExistsTest(sn, "Antoine", "antoine", new String("staR warS"), "a", "a",  1, "4.4", "L'ajout d'un itemBook  avec un titre existant (avec casse différente) est accepté");
		nbTests++;
		nbErreurs += addItemBookAlreadyExistsTest(sn, "Antoine", "antoine", new String(" Star Wars "), "a", "a", 1, "4.5", "L'ajout d'un itemBook avec un titre existant (avec leading et trailing blanks) est accepté");

		// tentative d'ajout de itemBook avec un mauvais membre
		nbTests++;
		nbErreurs += addItemBookNotMemberTest(sn, "Michel", "paul", "Lord of the Ring", "a", "a", 1, "4.6", "L'ajout d'un itemBook avec un mauvais membre est accepté");
		nbTests++;
		nbErreurs += addItemBookNotMemberTest(sn, "Paul", "antoine", "Harry Potter", "a", "a", 1, "4.7", "L'ajout d'un itemBook avec un pseudo est un password qui ne correspondent pas est accepté");
		
		nbTests++;
		if (nbFilms != sn.nbFilms()) {
			System.out.println("Erreur  :  le nombre de livres après utilisation de addItemBook a été modifié");	
			nbErreurs++;
		}
		nbTests++;
		if (nbMembres != sn.nbMembers()) {
			System.out.println("Erreur  :  le nombre de membres après utilisation de addItemBook a été modifié");	
			nbErreurs++;
		}

		// ce n'est pas du test, mais cela peut "rassurer"...
		System.out.println(sn);

		// bilan du test de addItemBook
		System.out.println("TestsAddItemBook :   " + nbErreurs + " erreur(s) / " +  nbTests + " tests effectués");

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
