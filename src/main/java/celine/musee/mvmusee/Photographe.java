import java.util.ArrayList;
import java.util.List;

public class Photographe extends Utilisateur {
    private List<Demande> demandes = new ArrayList<Demande> ();
    
    public Photographe(String nom, int id) { super(nom,id); }
    
    public List<Demande> getDemandes() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.demandes;
    }

    public void setDemandes(List<Demande> value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.demandes = value;
    }

    public void addDemande(Demande demande) {
    	this.demandes.add(demande);
    }

    public void remDemande(Demande demande) {
    	this.demandes.remove(demande);
    }
}
