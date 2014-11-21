import java.util.ArrayList;
import java.util.List;

public class Catalogue {

    private List<Photo> photos;
    
    private List<Demande> demandes = new ArrayList<Demande> ();
    
    public Catalogue() {
    	this.photos = new ArrayList<Photo>();
    }

    public void creerDemande(String description, Historien historien) {
    	//Flèche 3 de Inc2DSeqDemanderPhoto
    	Demande demande = new Demande(description,historien,false);
    	demandes.add(demande);
    	//Flèche 4 de Inc2DSeqDemanderPhoto
    	historien.addDemande(demande);
    }

    public List<Demande> listeDemandesEnAttente() {
    	List<Demande> lstDemandes = new ArrayList<Demande>();
    	for(Demande demande : this.demandes) {
    		//Flèche 4 de Inc2DSeqListeDemandesEnAttente
    		if (!demande.estPriseEnCharge()) {
    			lstDemandes.add(demande);
    		}
    	}
    	return lstDemandes;
    }

    public void addPhoto(Photo photo) {
    	this.photos.add(photo);
    }
    
    public List<Photo> getPhotos() {
    	return this.photos;
    }
}
