package avis;

import java.util.LinkedList;


import exception.BadEntry;
import exception.ItemFilmAlreadyExists;
import exception.ItemBookAlreadyExists;
import exception.MemberAlreadyExists;
import exception.NotItem;
import exception.NotMember;

/** 
 * @author A. Beugnard, 
 * @author G. Ouvradou
 * @author B. Prou
 * @date février - mars 2011
 * @version V0.6
 */


/** 
 * <p>
 * <b>Système de mutualisation d'opinions portant sur des domaines
 * variés (littérature, cinéma, art, gastronomie, etc.) et non limités.</b>
 * </p>
 * <p>
 * L'accès aux items et aux opinions qui leurs sont associées
 * est public. La création d'item et le dépôt d'opinion nécessite en revanche 
 * que l'utilisateur crée son profil au préalable.
 * </p>
 * <p>
 * Lorsqu'une méthode peut lever deux types d'exception, et que les conditions sont réunies 
 * pour lever l'une et l'autre, rien ne permet de dire laquelle des deux sera effectivement levée.
 * </p>
 * <p>
 * Dans une version avancée (version 2), une opinion peut également
 * être évaluée. Chaque membre se voit dans cette version décerner un "karma" qui mesure
 * la moyenne des notes portant sur les opinions qu'il a émises.
 * L'impact des opinions entrant dans le calcul de la note moyenne attribuée à un item
 * est pondéré par le karma des membres qui les émettent.
 * </p>
 */

public class SocialNetwork {


	/** 
	 * @uml.property name="members"
	 * @uml.associationEnd multiplicity="(0 -1)" ordering="true" inverse="socialNetwork:avis.Member"
	 */
	private LinkedList<Member> members= new LinkedList<Member>() ;


	/** 
	 * @uml.property name="films"
	 * @uml.associationEnd multiplicity="(0 -1)" ordering="true" inverse="socialNetwork:avis.Film"
	 */
	private LinkedList<Film> films = new LinkedList<Film>();


	/** 
	 * @uml.property name="books"
	 * @uml.associationEnd multiplicity="(0 -1)" ordering="true" inverse="socialNetwork:avis.Book"
	 */
	private LinkedList<Book> books;


	/**
	 * constructeur de <i>SocialNetwok</i> 
	 * 
	 */

	public SocialNetwork() {
	}

	/**
	 * Obtenir le nombre de membres du <i>SocialNetwork</i>
	 * 
	 * @return le nombre de membres
	 */
	public int nbMembers() {
		return members.size();
	}

	/**
	 * Obtenir le nombre de films du <i>SocialNetwork</i>
	 * 
	 * @return le nombre de films
	 */
	public int nbFilms() {
		return films.size();
	}

	/**
	 * Obtenir le nombre de livres du <i>SocialNetwork</i>
	 * 
	 * @return le nombre de livres
	 */
	public int nbBooks() {
		return 0;
	}


	/**
	 * Ajouter un nouveau membre au <i>SocialNetwork</i>
	 * 
	 * @param pseudo son pseudo
	 * @param password son mot de passe 
	 * @param profil un slogan choisi par le membre pour se définir
	 * 
	 * @throws BadEntry :
	 * <ul>
	 *  <li>  si le pseudo n'est pas instancié ou a moins de 1 caractère autre que des espaces .  </li>
	 *  <li>  si le password n'est pas instancié ou a moins de 4 caractères autres que des leadings or trailing blanks. </li>
	 *  <li>  si le profil n'est pas instancié.  </li>
	 * </ul><br>       
	 * 
	 * @throws MemberAlreadyExists membre de même pseudo déjà présent dans le <i>SocialNetwork</i> (même pseudo : indifférent à  la casse  et aux leadings et trailings blanks)
	 * 
	 */
	public void addMember(String pseudo, String password, String profil) throws BadEntry, MemberAlreadyExists  {
		//On istancie un nouveau membre
		Member member= new Member(pseudo, password, profil);
		
		//On test toutes les possibilités du BadEntry
		if(pseudo==null||pseudo.trim().length()<1||password==null||profil==null||password.trim().length()<4){
			//On renvoi le BadEntry si nécessaire
			throw new BadEntry("test");
		}
		else{
			//Sinon, on parcourt le tableau à la recherche d'une correspondance. 
			for (Member m : members)
			{
				//Si il y a correspondance, on renvoi une exception MemberAlreadyExists
				if (m.getPseudo().trim().equalsIgnoreCase(pseudo.trim())){
					throw new MemberAlreadyExists();

				}
			}
			//Si tout se passe bien, on ajoute le membre
			members.addLast(member);
		}
	}


	/**
	 * Ajouter un nouvel item de film au <i>SocialNetwork</i> 
	 * 
	 * @param pseudo le pseudo du membre
	 * @param password le password du membre 
	 * @param titre le titre du film
	 * @param genre son genre (aventure, policier, etc.)
	 * @param realisateur le réalisateur
	 * @param scenariste le scénariste
	 * @param duree sa durée en minutes
	 * 
	 * @throws BadEntry :
	 * <ul>
	 *  <li>  si le pseudo n'est pas instancié ou a moins de 1 caractère autre que des espaces .  </li>
	 *  <li>  si le password n'est pas instancié ou a moins de 4 caractères autres que des leadings or trailing blanks. </li>
	 *  <li>  si le titre n'est pas instancié ou a moins de 1 caractère autre que des espaces.  </li>
	 *  <li>  si le genre n'est pas instancié. </li>
	 *  <li>  si le réalisateur n'est pas instancié. </li>
	 *  <li>  si le scénariste n'est pas instancié. </li>
	 *  <li>  si la durée n'est pas positive.  </li>
	 * </ul><br>       
	 * @throws NotMember : si le pseudo n'est pas celui d'un membre ou si le pseudo et le password ne correspondent pas.
	 * @throws ItemFilmAlreadyExists : item film de même titre  déjà présent (même titre : indifférent à  la casse  et aux leadings et trailings blanks)
	 * 
	 */
	public void addItemFilm(String pseudo, String password, String titre, String genre, String realisateur, String scenariste, int duree) throws BadEntry, NotMember, ItemFilmAlreadyExists {
		
		//Instanciation d'un film avec les paramètre passés en argument.
		Film film = new Film(titre, genre, realisateur, scenariste, duree);
		
		//On test toutes les possibilités d'un BadEntry afin de renvoyer l'exception lors d'un mauvaise saisie des arguments
		if(pseudo==null||pseudo.trim().length()<1||password==null||password.trim().length()<4||titre==null||titre.trim().length()<1||genre==null||realisateur==null||scenariste==null||duree<=0){
			throw new BadEntry("test");
		}
		//Si il n'y a pas de problème de saisie, on test si le membre existe
		else
		{ 
			//Initialisation d'une variable "state" utilisée pour le test des IDs 
			int state=0;
			//On parcourt le tableau de membres de SocialNetwork à la recherche d'un membre correspondant.
			for (Member m : members)
			{
				//Si on trouve une correspondance, on passe la variable "state" à 1.
				if ((m.getPseudo().trim().equalsIgnoreCase(pseudo.trim()) && m.getPassword().trim().equalsIgnoreCase(password.trim()))){
					state=1;
				}
			}
			//Si on ne trouve pas de correspondance, on renvoi une exception NotMember
			if(state!=1){
				throw new NotMember("Test");
			}
			
			//On parcourt les films à la recherche d'une correspondance
			for (Film f : films)
			{
				//Si il y a correspondance, on renvoi une exception ItemFilmAlreadyExists
				if (f.getTitre().trim().equalsIgnoreCase(titre.trim())){
					throw new ItemFilmAlreadyExists();
				}
			}
			
			//Si tous les test sont passés, on ajoute le film à la liste du SN
			films.addLast(film);
		}
	}

	/**
	 * Ajouter un nouvel item de livre au <i>SocialNetwork</i> 
	 * 
	 * @param pseudo le pseudo du membre
	 * @param password le password du membre 
	 * @param titre le titre du livre
	 * @param genre son genre (roman, essai, etc.)
	 * @param auteur l'auteur
	 * @param nbPages le nombre de pages
	 * 
	 * @throws BadEntry :
	 * <ul>
	 *  <li>  si le pseudo n'est pas instancié ou a moins de 1 caractère autre que des espaces .  </li>
	 *  <li>  si le password n'est pas instancié ou a moins de 4 caractères autres que des leadings or trailing blanks. </li>
	 *  <li>  si le titre n'est pas instancié ou a moins de 1 caractère autre que des espaces.  </li>
	 *  <li>  si le genre n'est pas instancié. </li>
	 *  <li>  si l'auteur n'est pas instancié. </li>
	 *  <li>  si le nombre de pages n'est pas positif.  </li>
	 * </ul><br>       
	 * @throws NotMember : si le pseudo n'est pas celui d'un membre ou si le pseudo et le password ne correspondent pas.
	 * @throws ItemBookAlreadyExists item livre de même titre  déjà présent (même titre : indifférent à la casse  et aux leadings et trailings blanks)
	 * 
	 * 
	 */
	public void addItemBook(String pseudo, String password, String titre, String genre, String auteur, int nbPages) throws  BadEntry, NotMember, ItemBookAlreadyExists{

	}

	/**
	 * Consulter les items du <i>SocialNetwork</i> par nom
	 * 
	 * @param nom son nom (eg. titre d'un film, d'un livre, etc.)
	 * 
	 * @throws BadEntry : si le nom n'est pas instancié ou a moins de 1 caractère autre que des espaces.  </li>
	 * 
	 * @return LinkedList <String> : la liste des représentations de tous les items ayant ce nom 
	 * Cette représentation contiendra la note de l'item s'il a été noté.
	 * (une liste vide si aucun item ne correspond) 
	 */
	public LinkedList <String> consultItems(String nom) throws BadEntry {
		return new LinkedList <String> ();
	}



	/**
	 * Donner son opinion sur un item film.
	 * Ajoute l'opinion de ce membre sur ce film au <i>SocialNetwork</i> 
	 * Si une opinion de ce membre sur ce film  préexiste, elle est mise à jour avec ces nouvelles valeurs.
	 * 
	 * @param pseudo pseudo du membre émettant l'opinion
	 * @param password son mot de passe
	 * @param titre titre du film  concerné
	 * @param note la note qu'il donne au film 
	 * @param commentaire ses commentaires
	 * 
	 * @throws BadEntry :
	 * <ul>
	 *  <li>  si le pseudo n'est pas instancié ou a moins de 1 caractère autre que des espaces .  </li>
	 *  <li>  si le password n'est pas instancié ou a moins de 4 caractères autres que des leadings or trailing blanks. </li>
	 *  <li>  si le titre n'est pas instancié ou a moins de 1 caractère autre que des espaces.  </li>
	 *  <li>  si la note n'est pas comprise entre 0.0 et 5.0. </li>
	 *  <li>  si le commentaire n'est pas instancié. </li>
	 * </ul><br>       
	 * @throws NotMember : si le pseudo n'est pas celui d'un membre ou si le pseudo et le password ne correspondent pas.
	 * @throws NotItem : si le titre n'est pas le titre d'un film.
	 * 
	 * @return la note moyenne des notes sur ce film  
	 */
	public float reviewItemFilm(String pseudo, String password, String titre, float note, String commentaire) throws BadEntry, NotMember, NotItem {
		return 0.0f;
	}



	/**
	 * Donner son opinion sur un item livre.
	 * Ajoute l'opinion de ce membre sur ce livre au <i>SocialNetwork</i> 
	 * Si une opinion de ce membre sur ce livre  préexiste, elle est mise à jour avec ces nouvelles valeurs.
	 * 
	 * @param pseudo pseudo du membre émettant l'opinion
	 * @param password son mot de passe
	 * @param titre titre du livre  concerné
	 * @param note la note qu'il donne au livre 
	 * @param commentaire ses commentaires
	 * 
	 * @throws BadEntry :
	 * <ul>
	 *  <li>  si le pseudo n'est pas instancié ou a moins de 1 caractère autre que des espaces .  </li>
	 *  <li>  si le password n'est pas instancié ou a moins de 4 caractères autres que des leadings or trailing blanks. </li>
	 *  <li>  si le titre n'est pas instancié ou a moins de 1 caractère autre que des espaces.  </li>
	 *  <li>  si la note n'est pas comprise entre 0.0 et 5.0. </li>
	 *  <li>  si le commentaire n'est pas instancié. </li>
	 * </ul><br>       
	 * @throws NotMember : si le pseudo n'est pas celui d'un membre ou si le pseudo et le password ne correspondent pas.
	 * @throws NotItem : si le titre n'est pas le titre d'un livre.
	 * 
	 * @return la note moyenne des notes sur ce livre
	 */
	public float reviewItemBook(String pseudo, String password, String titre, float note, String commentaire) throws BadEntry, NotMember, NotItem {
		return 0.0f;
	}


	/**
	 * Obtenir une représentation textuelle du <i>SocialNetwork</i>.
	 * 
	 * @return la chaîne de caractères représentation textuelle du <i>SocialNetwork</i> 
	 */
	public String toString() {
		return "";
	}


	/**
	 * Getter of the property <tt>members</tt>
	 * @return  Returns the member.
	 * @uml.property  name="members"
	 */
	public LinkedList<Member> getMembers() {
		return members;
	}

	/**
	 * Setter of the property <tt>members</tt>
	 * @param members  The member to set.
	 * @uml.property  name="members"
	 */
	public void setMembers(LinkedList<Member> members) {
		this.members = members;
	}

	/**
	 * Getter of the property <tt>films</tt>
	 * @return  Returns the film.
	 * @uml.property  name="films"
	 */
	public LinkedList<Film> getFilms() {
		return films;
	}

	/**
	 * Setter of the property <tt>films</tt>
	 * @param films  The film to set.
	 * @uml.property  name="films"
	 */
	public void setFilms(LinkedList<Film> films) {
		this.films = films;
	}

	/**
	 * Getter of the property <tt>books</tt>
	 * @return  Returns the book.
	 * @uml.property  name="books"
	 */
	public LinkedList<Book> getBooks() {
		return books;
	}

	/**
	 * Setter of the property <tt>books</tt>
	 * @param books  The book to set.
	 * @uml.property  name="books"
	 */
	public void setBooks(LinkedList<Book> books) {
		this.books = books;
	}





}
