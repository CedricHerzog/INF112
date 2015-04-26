package test;

public class Test {
    
    
	   public static void main(String[] args) {
           
		   /* On instancie la variable resultats qui sera passée en paramètre des tests et qui 
		    * contient dans l'ordre le nombre d'test et d'erreur.
		    * 
		    * Cette variable doit être un String car le main prend forcément un 
		    * tableau de String en paramètre
		    * 
		    * Si on essaie avec un tableau de int, la signature ne correspondra pas avec la signature 
		    * requise par la JVM, et le code plantera lors de l'éxécution
		    * */
		   
           String [] resultats = new String[] {"0", "0"};
           
           //Lancement du test d'initialisation
           TestsInitialisation.main(resultats);
           System.out.println("\n\n ***************************************\n");
           
           //Lancement du test d'ajout de membre
           TestsAddMember.main(resultats);
           System.out.println("\n\n ***************************************\n");
           
           //Lancement du test d'ajout de film
           TestAddItemFilm.main(resultats);
           System.out.println("\n\n ***************************************\n");
           
           //
           // TestReviewItemFilm.main(resultats);
           
         //  System.out.println("\n\n ***************************************\n");
           
           // .... d'autres appels à des tests
           
           System.out.println("Bilan des Tests :   " + resultats[1] +
                              " erreur(s) / " +  resultats[0] + " tests effectués");
           
       }
    
}