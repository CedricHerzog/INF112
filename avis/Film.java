package avis;

import java.util.Collection;


public class Film extends Item {

	/** 
	 * @uml.property name="socialNetwork"
	 * @uml.associationEnd multiplicity="(1 1)" inverse="film:avis.SocialNetwork"
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
	 * @uml.property name="reviewFilm"
	 * @uml.associationEnd multiplicity="(0 -1)" inverse="film:avis.ReviewFilm"
	 */
	private Collection reviewFilm;

	/** 
	 * Getter of the property <tt>reviewFilm</tt>
	 * @return  Returns the reviewFilm.
	 * @uml.property  name="reviewFilm"
	 */
	public Collection getReviewFilm() {
		return reviewFilm;
	}

	/** 
	 * Setter of the property <tt>reviewFilm</tt>
	 * @param reviewFilm  The reviewFilm to set.
	 * @uml.property  name="reviewFilm"
	 */
	public void setReviewFilm(Collection reviewFilm) {
		this.reviewFilm = reviewFilm;
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
	 * @uml.property  name="realisateur"
	 */
	private String realisateur;

	/**
	 * Getter of the property <tt>realisateur</tt>
	 * @return  Returns the realisateur.
	 * @uml.property  name="realisateur"
	 */
	public String getRealisateur() {
		return realisateur;
	}

	/**
	 * Setter of the property <tt>realisateur</tt>
	 * @param realisateur  The realisateur to set.
	 * @uml.property  name="realisateur"
	 */
	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}

	/**
	 * @uml.property  name="scenariste"
	 */
	private String scenariste;

	/**
	 * Getter of the property <tt>scenariste</tt>
	 * @return  Returns the scenariste.
	 * @uml.property  name="scenariste"
	 */
	public String getScenariste() {
		return scenariste;
	}

	/**
	 * Setter of the property <tt>scenariste</tt>
	 * @param scenariste  The scenariste to set.
	 * @uml.property  name="scenariste"
	 */
	public void setScenariste(String scenariste) {
		this.scenariste = scenariste;
	}

	/**
	 * @uml.property  name="duree"
	 */
	private int duree;

	/**
	 * Getter of the property <tt>duree</tt>
	 * @return  Returns the duree.
	 * @uml.property  name="duree"
	 */
	public int getDuree() {
		return duree;
	}

	/**
	 * Setter of the property <tt>duree</tt>
	 * @param duree  The duree to set.
	 * @uml.property  name="duree"
	 */
	public void setDuree(int duree) {
		this.duree = duree;
	}

	/** 
	 * @uml.property name="review"
	 * @uml.associationEnd multiplicity="(0 -1)" inverse="film:avis.Review"
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

				
				/**
				 */
				public Film(){
				}

}
