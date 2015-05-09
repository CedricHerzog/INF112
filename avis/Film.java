package avis;

import java.util.LinkedList;


public class Film extends Item {

	/** 
	 * @uml.property name="review"
	 * @uml.associationEnd multiplicity="(0 -1)" inverse="film:avis.Review"
	 */
	private LinkedList<Review> review = new LinkedList<Review>();
	/**
	 * @uml.property  name="titre"
	 */
	private String titre;
	/**
	 * @uml.property  name="genre"
	 */
	private String genre;
	/**
	 * @uml.property  name="realisateur"
	 */
	private String realisateur;
	/**
	 * @uml.property  name="scenariste"
	 */
	private String scenariste;
	/**
	 * @uml.property  name="duree"
	 */
	private int duree;
	/** 
	 * @uml.property name="socialNetwork"
	 * @uml.associationEnd multiplicity="(1 1)" inverse="films:avis.SocialNetwork"
	 */
	private SocialNetwork socialNetwork = new avis.SocialNetwork();

	/**
	 */
	public Film(String titre, String genre, String realisateur, String scenariste, int duree){
		this.titre=titre;
		this.genre=genre;
		this.realisateur=realisateur;
		this.scenariste=scenariste;
		this.duree=duree;		
	}
	
	public Film(){
		
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
			this.review.addLast(review);
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
