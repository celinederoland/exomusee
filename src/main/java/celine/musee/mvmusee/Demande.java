import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Demande {
    private String description;

    private Photographe photographeEnCharge;

    private Historien demandeur;
    
    private boolean urgent;
    
    private List<String> commentaires;

    private Photo photo;
    
    private EtatDemande etat;

    private Date date;
    
    public Demande(String description, Historien historien, boolean pUrg) {
    	this.description = description;
    	this.demandeur = historien;
    	this.urgent = pUrg;
    	this.date = new Date();
    	this.commentaires = new ArrayList<String>();
    	//flèches 4 et 5 de Inc2DSeqDemanderPhoto
    	this.etat = new EtatEnAttentePriseEnCharge(this);
    }

    public boolean estPriseEnCharge() {
		return (!(this.photographeEnCharge == null));
    }

    void setPhotographeEnCharge(Photographe photographe) {
    	this.photographeEnCharge = photographe;
    }

    Photographe getPhotographeEnCharge() {
		return photographeEnCharge;
    }

    String getDescription() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.description;
    }

    void setDescription(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.description = value;
    }

    Historien getDemandeur() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.demandeur;
    }

    boolean isUrgent() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.urgent;
    }

    void setUrgent(boolean value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.urgent = value;
    }

    List<String> getCommentaires() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.commentaires;
    }

    void setCommentaires(List<String> value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.commentaires = value;
    }

    Photo getPhoto() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.photo;
    }

    void setPhoto(Photo value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.photo = value;
    }

    public boolean hasPhoto() {
    	return (!(this.photo == null));
    }

    public void addCommentaire(String commentaire) {
    	this.commentaires.add(commentaire);
    }

    public void refuser(String commentaire) {
    	this.addCommentaire(commentaire);
    	this.etat = this.etat.refuser();
    }

    public void valider() {
    	this.etat = this.etat.valider();
    }
    
    public boolean isValid() {
    	return false;
    }

    EtatDemande getEtat() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.etat;
    }

    void setEtat(EtatDemande value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.etat = value;
    }

    public void prendreEnCharge(Photographe photographe) {
    	this.setEtat(this.etat.prendreEnCharge(photographe));
    	this.setPhotographeEnCharge(photographe);
    }

    public void desengager() {
    	this.etat = this.etat.desengager();
    	this.photographeEnCharge.remDemande(this);
    	this.setPhotographeEnCharge(null);
    }

    public void uploader(String chemin) {
    	//Flèches 3 et + de Inc3DSeqUploader
    	if (this.hasPhoto()) {
    		this.setPhoto(null);
    	}
    	Photo photo = new Photo(chemin);
    	this.setPhoto(photo); //destroy se fait tout seul grâce au garbage collector
    	this.etat = this.etat.uploader();
    }

    public void affiche(int i) {
		System.out.println("----------------------------------------------------");
		System.out.println("----------------------------------------------------");
		System.out.println(i + " : " + this.getDescription());
		System.out.println("Date : " + this.date);
		System.out.println("demandé par : " + this.getDemandeur().getNom());
		this.etat.affiche();
		System.out.println("----------------------------------------------------");
		if (this.hasPhoto()) { System.out.println("Photo : " + this.getPhoto().getChemin()); }
		System.out.println("----------------------------------------------------");
		System.out.println();
    }
}