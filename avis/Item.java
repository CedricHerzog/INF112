package avis;

import exception.ItemBookAlreadyExists;
import exception.ItemFilmAlreadyExists;
import exception.NotItem;



public abstract class Item {

	/**
	 * @uml.property  name="nom"
	 */
	private String nom;

	/**
	 * Getter of the property <tt>nom</tt>
	 * @return  Returns the nom.
	 * @uml.property  name="nom"
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter of the property <tt>nom</tt>
	 * @param nom  The nom to set.
	 * @uml.property  name="nom"
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

		
	/**
	 */
	public abstract void addReview(Review review);
			
	/**
	 * @throws ItemFilmAlreadyExists , ItemBookAlreadyExists
	 */
	public abstract void checkIfItemAlreadyExists(SocialNetwork sn) throws ItemBookAlreadyExists, ItemFilmAlreadyExists;
	
	
	/**
	 * @throws NotItem 
	 */
	public abstract void checkIfIsAItem(SocialNetwork sn) throws NotItem;
	
}
