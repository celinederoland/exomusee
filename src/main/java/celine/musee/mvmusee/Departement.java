import java.util.ArrayList;
import java.util.List;

public class Departement {
    private String nom;

    private List<Oeuvre> oeuvre = new ArrayList<Oeuvre> ();
    
    /* Deuxième flèche de Inc1DSeqParDepEtape2 */
    List<Oeuvre> getOeuvre() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.oeuvre;
    }
    
    /* Quatrième flèche de Inc1DSeqAffichageEtape2 */
    public void afficher() {
    	System.out.println("département :" + this.getNom());
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

    void setOeuvre(List<Oeuvre> value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.oeuvre = value;
    }

    /* constructeur généré par modelio et modifié par nous */
    
    public Departement(String pnom) {
    	this.nom = pnom;
    }
}
