import java.util.ArrayList;
import java.util.List;

public class Oeuvre {
    private String nom;

    private String description;

    private Departement departement;

    private List<Photo> photo = new ArrayList<Photo> ();

    /* Deuxième flèche de Inc1DSeqParLettreEtape2 */
    public char getPremiereLettre() {
    	return this.getNom().charAt(0);
    }

    /* Troisième flèche de Inc1DSeqAffichageEtape2 */
    public void afficher() {
    	System.out.println("Je suis une oeuvre et je vais m'afficher" );
    	System.out.println("nom : " + this.getNom());
        /* Quatrième flèche de Inc1DSeqAffichageEtape2 */
    	this.getDepartement().afficher();
    	System.out.println("description : " + this.getDescription());
    	System.out.println("Je vais maintenant demander à mes photos de s'afficher");
    	for (Photo p : photo)
    	{
    	    /* Cinquième flèche de Inc1DSeqAffichageEtape2 */
    		p.afficher();
    	}
    }
    
    
    /* Nous avons demandé à modélio de créé des getters et setters sur tous les attributs des objets */

    String getNom() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.nom;
    }

    void setNom(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.nom = value;
    }

    String getDescription() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.description;
    }

    void setDescription(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.description = value;
    }
    
    Departement getDepartement() {
        // Nous avons écrit cette méthode nous même car la création de getter n'a pas fonctionné
    	// (nous n'avons pas réussi à mettre des getters/setters des 2 côtés d'une
    	// relation navigable dans les deux sens)
        return this.departement;
    }

    void setDepartement(Departement value) {
        // Nous avons écrit cette méthode nous même car la création de setter n'a pas fonctionné
    	// (nous n'avons pas réussi à mettre des getters/setters des 2 côtés d'une
    	// relation navigable dans les deux sens)
    	this.departement = value;
    }
    
    List<Photo> getPhoto() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.photo;
    }

    void setPhoto(List<Photo> value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.photo = value;
    }
    
    /* constructeur généré par modelio et modifié par nous*/

    public Oeuvre(String pnom, String pdescription, Departement pdepartement) {
    	this.nom = pnom;
    	this.departement = pdepartement;
    	this.description = pdescription;
    }

}