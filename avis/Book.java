package avis;

import java.util.Collection;


public class Book extends Item {

	/** 
	 * @uml.property name="socialNetwork"
	 * @uml.associationEnd multiplicity="(1 1)" inverse="book:avis.SocialNetwork"
	 */
	private SocialNetwork socialNetwork = new avis.SocialNetwork();

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
	 * @uml.property  name="reviewBook"
	 * @uml.associationEnd  multiplicity="(0 -1)" inverse="book:avis.ReviewBook"
	 */
	private Collection reviewBook;

	/**
	 * Getter of the property <tt>reviewBook</tt>
	 * @return  Returns the reviewBook.
	 * @uml.property  name="reviewBook"
	 */
	public Collection getReviewBook() {
		return reviewBook;
	}

	/**
	 * Setter of the property <tt>reviewBook</tt>
	 * @param reviewBook  The reviewBook to set.
	 * @uml.property  name="reviewBook"
	 */
	public void setReviewBook(Collection reviewBook) {
		this.reviewBook = reviewBook;
	}

	/**
	 * @uml.property  name="genre"
	 */
	private String genre;

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
	 * @uml.property  name="auteur"
	 */
	private String auteur;

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
	 * @uml.property  name="nbPages"
	 */
	private int nbPages;

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
	 * @uml.property  name="review"
	 * @uml.associationEnd  multiplicity="(0 -1)" inverse="book:avis.Review"
	 */
	private Collection review;

	/**
	 * Getter of the property <tt>review</tt>
	 * @return  Returns the review.
	 * @uml.property  name="review"
	 */
	public Collection getReview() {
		return review;
	}

	/**
	 * Setter of the property <tt>review</tt>
	 * @param review  The review to set.
	 * @uml.property  name="review"
	 */
	public void setReview(Collection review) {
		this.review = review;
	}

		
		/**
		 */
		public void addReview(){
		}

			
			/**
			 */
			public void checkItem(){
			}

	

}
