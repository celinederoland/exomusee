import java.util.ArrayList;
import java.util.List;

public class Historien extends Utilisateur {
    private List<Demande> demandes = new ArrayList<Demande> ();

    public Historien(String nom, int id) { super(nom,id); }

    List<Demande> getDemandes() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.demandes;
    }

    void setDemandes(List<Demande> value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.demandes = value;
    }
    
    void addDemande(Demande demande) {
    	this.demandes.add(demande);
    }

}
