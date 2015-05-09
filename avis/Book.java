package avis;

import java.util.LinkedList;


public class Book extends Item {

	/** 
	 * @uml.property name="socialNetwork"
	 * @uml.associationEnd multiplicity="(1 1)" inverse="books:avis.SocialNetwork"
	 */
	private SocialNetwork socialNetwork = new avis.SocialNetwork();

	/**
	 * @uml.property  name="genre"
	 */
	private String genre;
	/**
	 * @uml.property  name="auteur"
	 */
	private String auteur;
	/**
	 * @uml.property  name="nbPages"
	 */
	private int nbPages;
	/**
	 * @uml.property  name="review"
	 * @uml.associationEnd  multiplicity="(0 -1)" inverse="book:avis.Review"
	 */
	private LinkedList<Review> review=new LinkedList<Review>();
	/**
	 * @uml.property  name="titre"
	 */
	private String titre;
	
	public Book(String titre, String genre, String auteur, int nbPages){
		this.titre=titre;
		this.genre=genre;
		this.auteur=auteur;
		this.nbPages=nbPages;
	}
	
	public Book(){
		
	}

	/** 
	 * Getter of the property <tt>socialNetwork</tt>
	 * @return  Returns the socialNetwork.
	 * @uml.property  name="socialNetwork"
	 */
	public SocialNetwork getSocialNetwork() {
		return socialNetwork;
	}

	/** 
	 * Setter of the property <tt>socialNetwork</tt>
	 * @param socialNetwork  The socialNetwork to set.
	 * @uml.property  name="socialNetwork"
	 */
	public void setSocialNetwork(SocialNetwork socialNetwork) {
		this.socialNetwork = socialNetwork;
	}

	/**
	 * Getter of the property <tt>genre</tt>
	 * @return  Returns the genre.
	 * @uml.property  name="genre"
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * Setter of the property <tt>genre</tt>
	 * @param genre  The genre to set.
	 * @uml.property  name="genre"
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * Getter of the property <tt>auteur</tt>
	 * @return  Returns the auteur.
	 * @uml.property  name="auteur"
	 */
	public String getAuteur() {
		return auteur;
	}

	/**
	 * Setter of the property <tt>auteur</tt>
	 * @param auteur  The auteur to set.
	 * @uml.property  name="auteur"
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	/**
	 * Getter of the property <tt>nbPages</tt>
	 * @return  Returns the nbPages.
	 * @uml.property  name="nbPages"
	 */
	public int getNbPages() {
		return nbPages;
	}

	/**
	 * Setter of the property <tt>nbPages</tt>
	 * @param nbPages  The nbPages to set.
	 * @uml.property  name="nbPages"
	 */
	public void setNbPages(int nbPages) {
		this.nbPages = nbPages;
	}

	/**
	 * Getter of the property <tt>review</tt>
	 * @return  Returns the review.
	 * @uml.property  name="review"
	 */
	public LinkedList<Review> getReview() {
		return review;
	}

	/**
	 * Setter of the property <tt>review</tt>
	 * @param review  The review to set.
	 * @uml.property  name="review"
	 */
	public void setReview(LinkedList<Review> review) {
		this.review = review;
	}

		
		/**
		 */
		public void addReview(Review review){
		}

			
			/**
			 */
			public void checkItem(){
			}

			/**
			 * Getter of the property <tt>titre</tt>
			 * @return  Returns the titre.
			 * @uml.property  name="titre"
			 */
			public String getTitre() {
				return titre;
			}

			/**
			 * Setter of the property <tt>titre</tt>
			 * @param titre  The titre to set.
			 * @uml.property  name="titre"
			 */
			public void setTitre(String titre) {
				this.titre = titre;
			}

	

}
