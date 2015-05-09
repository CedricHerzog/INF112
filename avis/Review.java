package avis;


public class Review {

	/**
	 * @uml.property  name="member"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="review:avis.Member"
	 */
	private Member member = new avis.Member();

	/**
	 * @uml.property  name="note"
	 */
	private float note;
	/**
	 * @uml.property  name="commentaire"
	 */
	private String commentaire;
	/**
	 * @uml.property  name="titre"
	 */
	private String titre;
	/** 
	 * @uml.property name="film"
	 * @uml.associationEnd multiplicity="(1 1)" inverse="review:avis.Film"
	 */
	private Film film = new avis.Film();
	/**
	 * @uml.property  name="book"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="review:avis.Book"
	 */
	private Book book = new avis.Book();
	
	public Review(String titre, float note, String commentaire, Member member){
		this.titre=titre;
		this.note=note;
		this.commentaire=commentaire;
		this.member=member;
	}
	

	/**
	 * Getter of the property <tt>member</tt>
	 * @return  Returns the member.
	 * @uml.property  name="member"
	 */
	public Member getMember() {
		return member;
	}

	/**
	 * Setter of the property <tt>member</tt>
	 * @param member  The member to set.
	 * @uml.property  name="member"
	 */
	public void setMember(Member member) {
		this.member = member;
	}

	/**
	 * Getter of the property <tt>note</tt>
	 * @return  Returns the note.
	 * @uml.property  name="note"
	 */
	public float getNote() {
		return note;
	}

	/**
	 * Setter of the property <tt>note</tt>
	 * @param note  The note to set.
	 * @uml.property  name="note"
	 */
	public void setNote(float note) {
		this.note = note;
	}

	/**
	 * Getter of the property <tt>commentaire</tt>
	 * @return  Returns the commentaire.
	 * @uml.property  name="commentaire"
	 */
	public String getCommentaire() {
		return commentaire;
	}

	/**
	 * Setter of the property <tt>commentaire</tt>
	 * @param commentaire  The commentaire to set.
	 * @uml.property  name="commentaire"
	 */
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
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

	/** 
	 * Getter of the property <tt>film</tt>
	 * @return  Returns the film.
	 * @uml.property  name="film"
	 */
	public Film getFilm() {
		return film;
	}

	/** 
	 * Setter of the property <tt>film</tt>
	 * @param film  The film to set.
	 * @uml.property  name="film"
	 */
	public void setFilm(Film film) {
		this.film = film;
	}

	/**
	 * Getter of the property <tt>book</tt>
	 * @return  Returns the book.
	 * @uml.property  name="book"
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * Setter of the property <tt>book</tt>
	 * @param book  The book to set.
	 * @uml.property  name="book"
	 */
	public void setBook(Book book) {
		this.book = book;
	}

}
