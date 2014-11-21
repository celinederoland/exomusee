import java.util.ArrayList;
import java.util.List;

public class Systeme {
    private List<Oeuvre> oeuvre = new ArrayList<Oeuvre> ();

    private List<Departement> departement = new ArrayList<Departement> ();
    
    private Catalogue catalogue;
    
    private List<Utilisateur> utilisateur = new ArrayList<Utilisateur> ();

	private Utilisateur utilisateurCourant;

    /* Première flèche de Inc1DSeqParLettreEtape2 */
    public List<Oeuvre> consulter(String lettre) {
    	List<Oeuvre> list = new ArrayList<Oeuvre> (); 
    	/* Le cas d'erreur "plusieurs lettres entrées" est ici traité implicitement
    	 * puisqu'on ne retient que le premier caractère
    	 */
    	char l = lettre.charAt(0);
    	
        /* Boucle loop de Inc1DSeqParLettreEtape2 */
    	for (Oeuvre o : oeuvre)
    	{
    		/* Flèche getPremiereLettre de Inc1DSeqParLettreEtape2 */
    		if (o.getPremiereLettre() == l)
    		{
    			list.add(o);
    		}
    	}
    	return list;
    }

	/* Première Flèche de Inc1DSeqParDepEtape2 */
    public List<Oeuvre> consulter(Departement departement) {
    	/* Deuxième Flèche de Inc1DSeqParDepEtape2 */
    	return departement.getOeuvre();
    }

	/* Première Flèche de Inc1DSeqAffichage */
    public void consulter(Oeuvre oeuvre) {
    	/* Deuxième Flèche de Inc1DSeqAffichage */
		oeuvre.afficher();
    }

    
    /* Constructeur : on code en dur les objets ici */
    public Systeme() {
    	Departement d1 = new Departement("Peinture");
    	Departement d2 = new Departement("Sculpture");
    	Departement d3 = new Departement("Art abstrait");
    	this.departement.add(d1);
    	this.departement.add(d2);
    	this.departement.add(d3);
    	
    	Oeuvre joconde = new Oeuvre("joconde","blablabla",d1);
    	Oeuvre lepenseur = new Oeuvre("penseur","blablabla",d2);
    	Oeuvre scream = new Oeuvre("scream","blablabla",d1);
    	Oeuvre fleur = new Oeuvre("fleur","blablabla",d1);
    	Oeuvre bulles = new Oeuvre("bulles","blablabla",d3);
    	Oeuvre bulletin = new Oeuvre("bulletintintin","blablabla",d3);

    	
    	this.oeuvre.add(joconde);
    	this.oeuvre.add(lepenseur);
    	this.oeuvre.add(scream);
    	this.oeuvre.add(fleur);
    	this.oeuvre.add(bulles);
    	this.oeuvre.add(bulletin);
    	
    	List<Oeuvre> l1 = new ArrayList<Oeuvre> ();
    	l1.add(joconde);
    	l1.add(scream);
    	l1.add(fleur);

    	List<Oeuvre> l2 = new ArrayList<Oeuvre> ();
    	l2.add(lepenseur);
    	
    	List<Oeuvre> l3 = new ArrayList<Oeuvre> ();
    	l3.add(bulles);
    	l3.add(bulletin);
    	
    	d1.setOeuvre(l1);
    	d2.setOeuvre(l2);
    	d3.setOeuvre(l3);
    	
    	Photo jocondeDeFace = new Photo("/home/images/jocFace.jpg");
    	Photo jocondeDeCote = new Photo("/home/images/jocCote.jpg");
    	List<Photo> l = new ArrayList<Photo>();
    	l.add(jocondeDeFace);
    	l.add(jocondeDeCote);
    	joconde.setPhoto(l);
    	
    	
    	Historien hub = new Historien("hubert", 1);
    	Photographe phi = new Photographe("philibert",2);
    	List<Utilisateur> ul = new ArrayList<Utilisateur>();
    	ul.add(hub);
    	ul.add(phi);
    	this.setUtilisateur(ul);
    	
    	Catalogue cata = new Catalogue();
    	this.catalogue = cata;
    }
    
    
    /* Nous avons demandé à modélio de créé des getters et setters sur tous les attributs des objets */
    
    
    List<Oeuvre> getOeuvre() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.oeuvre;
    }

    void setOeuvre(List<Oeuvre> value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.oeuvre = value;
    }
    
    List<Departement> getDepartement() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.departement;
    }

    void setDepartement(List<Departement> value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.departement = value;
    }
    
    public void creerDemande(String description) {
    	if (this.utilisateurCourant instanceof Historien)
    	{
    		Historien histo = (Historien) this.utilisateurCourant;
        	//flèche 2 de Inc2DSeqDemanderPhoto
        	this.catalogue.creerDemande(description, histo);
    	}
    }

    public List<Demande> listeDemandesEnAttente() {
    	if (this.utilisateurCourant instanceof Photographe)
    	{
        	//flèche 2 de Inc2DSeqListeDemandesEnAttente
        	return this.catalogue.listeDemandesEnAttente();
    	}
    	return null;
    }

    public List<Demande> listeDemandesFaites() {
    	if (this.utilisateurCourant instanceof Historien)
    	{
    		Historien histo = (Historien) this.utilisateurCourant;
        	//flèche 2 de Inc2DSeqListeDemandesFaites
        	return histo.getDemandes();
    	}
    	return null;
    }

    public List<Demande> listeDemandesPrisesEnCharge() {
       	if (this.utilisateurCourant instanceof Photographe)
    	{
       		Photographe ph = (Photographe) this.utilisateurCourant;
        	//flèche 2 de Inc2DSeqListeDemandesPrisesEnCharge
        	return ph.getDemandes();
    	}
       	return null;
    }

    public void prendreEnChargeDemande(Demande demande) {
       	if (this.utilisateurCourant instanceof Photographe)
    	{
       		Photographe ph = (Photographe) this.utilisateurCourant;
        	//flèche 2 de Inc2DSeqPrendreEnCharge
        	demande.prendreEnCharge(ph);
        	//flèche 3 de Inc2DSeqPrendreEnCharge
        	ph.addDemande(demande);
    	}
    }
    
    List<Utilisateur> getUtilisateur() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.utilisateur;
    }

    void setUtilisateur(List<Utilisateur> value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.utilisateur = value;
    }
    
    public void desengager(Demande demande) {
    	demande.desengager();
    }

    public void uploader(String cheminAcces, Demande demande) {
    	//Flèche 2 de Inc3DSeqUploader
    	demande.uploader(cheminAcces);
    }

    public void valider(Demande demande) {
    	//Flèche 2 de Inc3DSeqValider
    	demande.valider();
    	this.catalogue.addPhoto(demande.getPhoto());
    }

    public void refuser(Demande demande, String commentaire) {
    	//Flèche 2 de Inc3DSeqRefuser
    	demande.refuser(commentaire);
    }
    
    /**
     * La méthode authentifier n'apparait pas dans nos diagrammes car elle ne fait pas partie de l'incrément 2.
     * Elle est cependant nécessaire pour que notre interface puisse différencier les acteurs.
     * Nous avons donc créé ici une méthode simpliste qui permet d'authentifier :
     * 	un historien avec le login hubert
     *  un photographe avec le login philibert
     *  un utilisateur standard avec n'importe quel autre login
     */
    public String authentifier(String login) {
    	if (login.equals("hubert")) { 
    		this.utilisateurCourant = this.utilisateur.get(0);
    		return "historien"; 
    	}
    	if (login.equals("philibert")) {
    		this.utilisateurCourant = this.utilisateur.get(1);
    		return "photographe";
    	}
    	this.utilisateurCourant = null;
    	return "anonyme";
    }
    
    public Catalogue getCatalogue() {
    	return this.catalogue;
    }
}
