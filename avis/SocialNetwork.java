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
	private LinkedList<Book> books = new LinkedList<Book>();


	/**
	 * constructeur de <i>SocialNetwok</i> 
	 * 
	 */

	public SocialNetwork() {
	}

	/**
	 * Obtenir une copie de la liste des membres
	 * 
	 * @return la linkedList des membres.
	 */
	public LinkedList<Member> getListMembers() {
		// voir si on peut faire une copie pour plus de sécurité
		return members;
	}
	
	/**
	 * Obtenir une copie de la liste des films
	 * 
	 * @return la linkedList des films.
	 */
	public LinkedList<Film> getListFilms() {
		// voir si on peut faire une copie pour plus de sécurité
		return films;
	}

	
	/**
	 * Obtenir une copie de la liste des livres
	 * 
	 * @return la linkedList des livres.
	 */
	public LinkedList<Book> getListBooks() {
		// voir si on peut faire une copie pour plus de sécurité
		return books;
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
		return books.size();
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
			//Test le membre existe ?
			Member MemberTest = new Member(pseudo,password,null);
			MemberTest.checkId(this);
						
			//Test : le film existe ?
			film.checkIfItemAlreadyExists(this);
			
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

		//Instanciation d'un film avec les paramètre passés en argument.
		Book book = new Book(titre, genre, auteur, nbPages);

		//On test toutes les possibilités d'un BadEntry afin de renvoyer l'exception lors d'un mauvaise saisie des arguments
		if(pseudo==null||pseudo.trim().length()<1||password==null||password.trim().length()<4||titre==null||titre.trim().length()<1||genre==null||auteur==null||nbPages<=0){
			throw new BadEntry("test");
		}
		else
		{ 
			//Test : le membre existe ?
			Member MemberTest = new Member(pseudo,password,null);
			MemberTest.checkId(this);
			
			//Test : le livre existe ?
			book.checkIfItemAlreadyExists(this);

			//Si tous les test sont passés, on ajoute le film à la liste du SN
			books.addLast(book);
		}
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
		if(nom==null||nom.trim().length()<1){
			throw new BadEntry("test");
		}
		
		LinkedList<String> resultat = new LinkedList<String>();
		for(Film film : films){
			if(film.getTitre().trim().equalsIgnoreCase(nom.trim())){
				resultat.addLast(film.toString());;
			}
		}
		for(Book book : books){
			if(book.getTitre().trim().equalsIgnoreCase(nom.trim())){
				resultat.addLast(book.toString());;
			}
		}
		
		return resultat;
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

		//On test toutes les possibilités du BadEntry
		if(pseudo==null||pseudo.trim().length()<1||password==null||password.trim().length()<4||titre==null||titre.trim().length()<1||note<0||note>5||commentaire==null){
			//On renvoi le BadEntry si nécessaire
			throw new BadEntry("test");
		}

		//Test : le membre existe ?
		Member MemberTest = new Member(pseudo,password,null);
		MemberTest.checkId(this);

		//Test : l'item n'existe pas ?
		Film FilmTest = new Film(titre);
		FilmTest.checkIfIsAItem(this);
		
		/*--------------------------------------------------------------------------------------------------------------*/
		Review review;
		float moyenne=0;
		int nbOccurence=0;

		for(Member member : members){
			if(member.getPseudo().trim().equalsIgnoreCase(pseudo.trim())){
				review = new Review(titre,note,commentaire,member);	


				for(Film film : films){
					if(film.getTitre().trim().equalsIgnoreCase(titre.trim())){

						if(!film.getReview().isEmpty()){




							for(Review reviewElement : film.getReview()){
								if(reviewElement.getMember().getPseudo().trim().equalsIgnoreCase(pseudo.trim())){
									film.getReview().remove(reviewElement);
								}
								
							}
							
							
							film.addReview(review);
							
							
						}
						else{
							film.addReview(review);
						}
						for(Review reviewElement : film.getReview()){
							nbOccurence++;
							moyenne=((moyenne*(nbOccurence-1))+reviewElement.getNote())/nbOccurence;
						}

					}
				}

			}
		}

		return moyenne;
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
		//On test toutes les possibilités du BadEntry
				if(pseudo==null||pseudo.trim().length()<1||password==null||password.trim().length()<4||titre==null||titre.trim().length()<1||note<0||note>5||commentaire==null){
					//On renvoi le BadEntry si nécessaire
					throw new BadEntry("test");
				}

				//Test : le membre existe ?
				Member MemberTest = new Member(pseudo,password,null);
				MemberTest.checkId(this);

				//Test : l'item n'existe pas ?
				Book BookTest = new Book(titre);
				BookTest.checkIfIsAItem(this);
				
				/*--------------------------------------------------------------------------------------------------------------*/
				
				Review review;
				float moyenne=0;
				int nbOccurence=0;

				for(Member member : members){
					if(member.getPseudo().trim().equalsIgnoreCase(pseudo.trim())){
						review = new Review(titre,note,commentaire,member);	


						for(Book book : books){
							if(book.getTitre().trim().equalsIgnoreCase(titre.trim())){

								if(!book.getReview().isEmpty()){




									for(Review reviewElement : book.getReview()){
										if(reviewElement.getMember().getPseudo().trim().equalsIgnoreCase(pseudo.trim())){
											book.getReview().remove(reviewElement);
										}
										
									}
									
									
									book.addReview(review);
									
									
								}
								else{
									
									book.addReview(review);
								}
								for(Review reviewElement : book.getReview()){
									nbOccurence++;
									moyenne=((moyenne*(nbOccurence-1))+reviewElement.getNote())/nbOccurence;
								}

							}
						}

					}
				}
				
				return moyenne;
	}


	/**
	 * Obtenir une représentation textuelle du <i>SocialNetwork</i>.
	 * 
	 * @return la chaîne de caractères représentation textuelle du <i>SocialNetwork</i> 
	 */
	public String toString() {
		String retour;
		retour="\n Nombre de membre: "+members.size()+"\n---------------------\n";
		for(Member member : members){
			retour+=member.toString() + "\n";
		}
		retour+="\n Nombre de films: "+films.size()+"\n---------------------\n";
		for(Film film : films){
			retour+=film.toString() + "\n";
		}
		retour+="\n Nombre de books: "+books.size()+"\n---------------------\n";
		for(Book book : books){
			retour+=book.toString() + "\n";
		}
		
		return retour;
	}



}
