import java.util.List;
import java.util.Scanner;

/**
 * 
 * Cette classe représente l'interface entre l'acteur et le système.
 * C'est une interface console, mais nous envisagerons lors d'un autre incrément une interface graphique
 *
 * Organisation : 
 *   Nous avons une fonction principale qui fait appel à l'authentification
 *   Une fois l'utilisateur authentifié, nous avons une méthode nommée nomdelacteurAction()
 *   Chacune de ses méthodes : 
 *     fait appel à un menu (méthode menuNomActeur)
 *     selon le résultat du menu fait appel à une fonction nomduusecaseUC(), ou revient à la fonction principale pour déconnecter ou quitter
 *   Chacune des méthodes nomduusecaseUC() réalise les flèches du diagramme de séquence correspondant
 *   
 * Nous avons choisi cette organisation afin de mettre en évidence la relation directe entre le programme
 * que nous avons écrit et les diagrammes réalisés au préalable. Même si cela peut parfois sembler artificiel
 * en particulier pour certaines méthodes nomduusecaseUC() qui ne contiennent qu'une ou deux lignes.
 * 
 * Notre interface a donc bien pour rôle de faire de l'affichage et de diriger l'utilisateur vers les différents use case possibles pour lui
 */
public class Main {

	private static Scanner sc = new Scanner(System.in);
	private static Systeme museeDuLouvre = new Systeme();

	/* LE PHOTOGRAPHE */
	
		/* menu */
	
	public static int menuPhotographe()
	{
		System.out.println("1 : Consulter mes travaux photos en cours");
		System.out.println("2 : Consulter les demandes en attente d'un photographe");
		System.out.println("3 : Déconnection");
		System.out.println("4 : Quitter");
		int choix = sc.nextInt();
		sc.nextLine();
		while (choix != 1 && choix != 2 && choix != 3 && choix != 4)
		{
			System.out.println("Choix invalide, essayez encore");
			choix = sc.nextInt();
			sc.nextLine();
		}
		return choix;
	}
	
		/* Use Case */
	
	public static void listeDemandesPrisesEnChargeUC()
	{
		//Flèche 1 de Inc2DSeqListeDemandesPrisesEnCharge
		List<Demande> lstDemandes = museeDuLouvre.listeDemandesPrisesEnCharge();
		int i = 1;
		for (Demande demande : lstDemandes)
		{
			demande.affiche(i);
			i++;
		}
		System.out.println("Entrez 0 pour retourner au menu principal, ou le numéro de la demande sur laquelle vous souhaitez agir");
		int dem = sc.nextInt();
		sc.nextLine();
		if (dem != 0) { 
			System.out.println("0 : retourner au menu principal");
			System.out.println("1 : vous désengager");
			System.out.println("2 : uploader une photo");
			int act = sc.nextInt();
			sc.nextLine();
			if (act == 1) { desengagerUC(lstDemandes,dem); }
			else if (act == 2) { uploaderUC(lstDemandes,dem); }
		}
	}
	
	public static void uploaderUC(List<Demande> listDemandes, int dem) {
		Demande demande = listDemandes.get(dem-1);
		System.out.println("Entrez le chemin du fichier à uploader");
		String chemin = sc.nextLine();
		//Flèche 1 de Inc3DSeqUploader
		museeDuLouvre.uploader(chemin,demande);
	}
	
	public static void desengagerUC(List<Demande> listDemandes, int dem)
	{
		Demande demande = listDemandes.get(dem-1);
		//Flèche 1 de Inc3DSeqDesengager
		museeDuLouvre.desengager(demande);
	}
	
	public static void listeDemandesEnAttenteUC()
	{
		//Flèche 1 de Inc2DSeqListeDemandesEnAttente
		List<Demande> listDemandes = museeDuLouvre.listeDemandesEnAttente();
		//Affichage des demandes géré par l'interface
		int i = 1;
		for (Demande demande : listDemandes)
		{
			demande.affiche(i);
			i++;
		}
		System.out.println("Entrez 0 pour retourner au menu principal, ou le numéro de la demande que vous souhaitez prendre en charge");
		int dem = sc.nextInt();
		sc.nextLine();
		if (dem != 0) { //UC : Prendre en charge une demande
			prendreEnChargeDemandeUC(listDemandes,dem);
		}
	}
	
	public static void prendreEnChargeDemandeUC(List<Demande> listDemandes, int dem)
	{
		Demande demande = listDemandes.get(dem-1);
		//Flèche 1 de Inc2DSeqPrendreEnCharge
		museeDuLouvre.prendreEnChargeDemande(demande);
	}
	
		/* Action (= appel aux différents use case de l'acteur photographe) */
	
	public static int photographeAction()
	{
		System.out.println("Hello philibert");
		int choix = 0;
		while (choix != 3 && choix != 4) {
			choix = menuPhotographe();
			if (choix == 1) { //UC : Liste des demandes prises en charge
				listeDemandesPrisesEnChargeUC();
			}
			else if (choix == 2) { //UC : Liste des demandes en attente
				listeDemandesEnAttenteUC();
			}
		}
		return choix;
	}
	
	/* HISTORIEN */
	
		/* menu */
	
	public static int menuHistorien() {
		System.out.println("1 : Effectuer une demande de travaux photo");
		System.out.println("2 : Consulter mes demandes");
		System.out.println("3 : Déconnection");
		System.out.println("4 : Quitter");

		int choix = sc.nextInt();
		sc.nextLine();
		while (choix != 1 && choix != 2 && choix != 3 && choix != 4)
		{
			System.out.println("You are stupid, try again");
			choix = sc.nextInt();
			sc.nextLine();
		}
		return choix;
	}
	
		/* use case */
	
	public static void demanderPhotoUC()
	{
		System.out.println("Entrez la description de la photo désirée");
		String description = sc.nextLine();
		//flèche 1 de Inc2DSeqDemanderPhoto
		museeDuLouvre.creerDemande(description);
	}
	
	public static void listeDesDemandesFaitesUC()
	{
		System.out.println("Vous pouvez voir la liste de vos demandes");
		//Flèche 1 de Inc2DSeqListeDemandesFaites
		List<Demande> listDemandes = museeDuLouvre.listeDemandesFaites();
		//Affichage des demandes géré par l'interface
		int i = 1;
		for (Demande demande : listDemandes)
		{
			demande.affiche(i);
			i++;
		}
		System.out.println("Entrez 0 pour retourner au menu principal, ou le numéro de la demande sur laquelle vous souhaitez agir");
		int dem = sc.nextInt();
		sc.nextLine();
		if (dem != 0) { 
			System.out.println("0 : retourner au menu principal");
			System.out.println("1 : valider");
			System.out.println("2 : refuser");
			int act = sc.nextInt();
			sc.nextLine();
			if (act == 1) { validerUC(listDemandes,dem); }
			else if (act == 2) { refuserUC(listDemandes,dem); }
		}
	}
	
	public static void validerUC(List<Demande> listDemandes, int dem) {
		Demande demande = listDemandes.get(dem-1);
		//Flèche 1 de Inc3DSeqValider
		museeDuLouvre.valider(demande);
	}
	
	public static void refuserUC(List<Demande> listDemandes, int dem)
	{
		System.out.println("Entrez votre commentaire");
		String com = sc.nextLine();
		Demande demande = listDemandes.get(dem-1);
		//Flèche 1 de Inc2DSeqPrendreEnCharge
		museeDuLouvre.refuser(demande,com);
	}
	
		/* Action (= appel aux différents use case de l'acteur historien) */
	
	public static int historienAction() {
		System.out.println("Hello hubert");
		int choix = 0;
		while (choix != 3 && choix != 4) {
			
			choix = menuHistorien();
			
			if (choix == 1) { //UC : Demander une photo
				demanderPhotoUC();
			}
			else if (choix == 2) { //UC : Liste des demandes faites
				listeDesDemandesFaitesUC();
			}
			
		}
		return choix;
	}
	
	/* UTILISATEUR STANDARD */
	
		/* menu */
	
	public static int menuUtilisateur()
	{
		System.out.println("1 : chercher une oeuvre");
		System.out.println("2 : voir toutes les photos du catalogue"); //sert juste à vérifier qu'une photo a été validée
		System.out.println("3 : déconnection");
		System.out.println("4 : quitter"); 
		int choix = sc.nextInt();
		sc.nextLine();
		while (choix != 1 && choix != 2 && choix != 3 && choix != 4)
		{
			System.out.println("Choix invalide, entrez à nouveau un choix");
			choix = sc.nextInt();
			sc.nextLine();
		}
		return choix;
	}
	
		/* use case */
	
	public static List<Oeuvre> consulterParDepUC(Departement dep)
	{
		System.out.println("vous avez choisi une recherche par département");
		// Flèche 1 de Inc1DSeqParLettreEtape2 
		List<Oeuvre> oeuvreList = museeDuLouvre.consulter(dep);	
		return oeuvreList;	
	}
	
	public static List<Oeuvre> consulterParLettreUC(String str)
	{
		System.out.println("vous avez choisi une recherche alphabétique");
		// Flèche 1 de Inc1DSeqParLettreEtape2
		List<Oeuvre> oeuvreList = museeDuLouvre.consulter(str);
		return oeuvreList;
	}
	
	public static void consulterFicheUC(Oeuvre oeuvre)
	{
		// Flèche 1 de Inc1DSeqAffichageEtape2
		museeDuLouvre.consulter(oeuvre);
		System.out.println();
	}
	
		/* Action (= appel aux différents use case de l'acteur utilisateur) */

	
	public static int utilisateurAction()
	{
		System.out.println("Hello anonyme");
		int choix = 0;
		while (choix != 3 && choix != 4) {
						
			choix = menuUtilisateur();

			if (choix == 1) {
				//Affichage des départements
				System.out.println("entrer une lettre ou sélectionner un département");
				List<Departement> list = museeDuLouvre.getDepartement();
				int i = 1;
				for (Departement departement : list)
				{
					System.out.println(i + " : " + departement.getNom());
					i++;
				}
				String str = sc.nextLine();
				
				List<Oeuvre> oeuvreList;
				
				if (estUnEntier(str)) //UC : Consulter par département
				{
					oeuvreList = consulterParDepUC(list.get(Integer.parseInt(str) - 1));		
				}
				else //UC : Consulter par lettre
				{
					oeuvreList = consulterParLettreUC(str);		
				}
		
				//Affichage des oeuvres
				i = 1;
				for (Oeuvre oeuvre : oeuvreList)
				{
					System.out.println(i + " : " + oeuvre.getNom());
					i++;
				}
		
				Integer n = sc.nextInt();
				sc.nextLine();	
				Oeuvre oeuvre = oeuvreList.get(n - 1);
				//UC : Consulter une fiche
				consulterFicheUC(oeuvre);
			}
			else if (choix == 2) {
				List<Photo> lstPhotos = museeDuLouvre.getCatalogue().getPhotos();
				for (Photo photo : lstPhotos) {
					photo.afficher();
					System.out.println("---------------------------");
				}
			}
		}
		return choix;
	}
	
	
	/**
	 * Fonction principale : réalise l'authentification
	 * Puis appelle la fonction correspondant à l'acteur authentifié
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int choix = 0;
		while (choix != 4)
		{
			//Authentification
			System.out.println("entrez votre nom d'utilisateur (anonyme autorisé)");
			String login = sc.nextLine();
			String statut = museeDuLouvre.authentifier(login);
			
			//Différenciation des acteurs
			if (statut == "photographe") {
				choix = photographeAction();
			}
			else if (statut == "historien") {
				choix = historienAction();
			}
			else {
				choix = utilisateurAction();
			}
		}
		System.out.println("Au revoir");
		sc.close();
	}
	
	/* Petite fonction utilitaire pour différencier les réponses de l'utilisateur (lettre ou nombre)*/
	public static boolean estUnEntier(String chaine) {
		try {
			Integer.parseInt(chaine);
		} catch (NumberFormatException e){
			return false;
		}
 
		return true;
	}

}
