package test;

import avis.SocialNetwork;

/** 
 * @author B. Prou
 * @date mars 2011
 * @version V0.6
 */

public class TestsInitialisation {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nbTests = 0;
		int nbErreurs = 0;
		
		System.out.println("Tests  initialisation  réseau social  ");
	
		
		try {

			// un réseau social créé ne doit avoir ni membres ni items
			//on test la création et on incrémente le nombre de test
			nbTests++;
			SocialNetwork sn = new SocialNetwork();
			
			//Si on entre dans un des if, c'est qu'il y a une erreur.
			//On incrémentera donc le nombre d'erreur
			if (sn.nbMembers()!= 0) {
				nbErreurs++;
				System.out.println("Erreur 0.1 :  le nombre de membres après création du réseau est non nul");
				System.exit(1);
			}
			if (sn.nbBooks() != 0) {
				nbErreurs++;
				System.out.println("Erreur 0.2 : le nombre de livres après création du réseau est non nul");
				System.exit(1);
			}
			if (sn.nbFilms() != 0) {
				nbErreurs++;
				System.out.println("Erreur 0.3 : le nombre de films après création du réseau est non nul");
				System.exit(1);
			}

			
			// ce n'est pas du test, mais cela peut "rassurer"...
			System.out.println(sn);
			
		}
		//Si on entre dans le catch, c'est qu'il y a une erreur, donc incrémentation du nbErreurs
		catch (Exception e) {
			nbErreurs++;
			System.out.println("Exception non prévue : " + e);
			e.printStackTrace();
			System.exit(1);
		}
		
		//On modifie l'argument qui sera utilisé dans le prochain test
		if ((args != null) && (args.length == 2)) {        
            nbTests = nbTests + new Integer(args[0]);
            nbErreurs = nbErreurs + new Integer(args[1]);       
            args[0] = "" + nbTests;
            args[1] = "" + nbErreurs;
         }
	}

	
}
