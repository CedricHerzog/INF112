package avis;

import java.util.LinkedList;



public class Member extends Visiteur {
	
	/** 
	 * @uml.property name="socialNetwork"
	 * @uml.associationEnd multiplicity="(1 1)" inverse="members:avis.SocialNetwork"
	 */
	private SocialNetwork socialNetwork = new avis.SocialNetwork();
	/**
	 * @uml.property  name="review"
	 * @uml.associationEnd  multiplicity="(0 -1)" inverse="member:avis.Review"
	 */
	private LinkedList<Review> review = new LinkedList<Review>();
	/**
	 * @uml.property  name="pseudo"
	 */
	private String pseudo;
	/**
	 * @uml.property  name="password"
	 */
	private String password;
	/**
	 * @uml.property  name="profil"
	 */
	private String profil;

	/**
	 */
	public Member(String pseudo, String password, String profil){
		this.pseudo=pseudo;
		this.password=password;
		this.profil=profil;
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
	 * Getter of the property <tt>pseudo</tt>
	 * @return  Returns the pseudo.
	 * @uml.property  name="pseudo"
	 */
	public String getPseudo() {
		return this.pseudo;
	}

	/**
	 * Setter of the property <tt>pseudo</tt>
	 * @param pseudo  The pseudo to set.
	 * @uml.property  name="pseudo"
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * Getter of the property <tt>password</tt>
	 * @return  Returns the password.
	 * @uml.property  name="password"
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter of the property <tt>password</tt>
	 * @param password  The password to set.
	 * @uml.property  name="password"
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter of the property <tt>profil</tt>
	 * @return  Returns the profil.
	 * @uml.property  name="profil"
	 */
	public String getProfil() {
		return profil;
	}

	/**
	 * Setter of the property <tt>profil</tt>
	 * @param profil  The profil to set.
	 * @uml.property  name="profil"
	 */
	public void setProfil(String profil) {
		this.profil = profil;
	}

		
		/**
		 */
		public void checkId(){
		}

			
			

}
