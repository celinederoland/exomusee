
public abstract class EtatDemande {

    public Demande demande;

    public EtatDemande(Demande demande) {
    	this.demande = demande;
    }
    
    public abstract boolean estPriseEnCharge();

    public abstract EtatDemande prendreEnCharge(Photographe photographe);

    public abstract EtatDemande desengager();

    public abstract EtatDemande refuser();
    
    public abstract EtatDemande valider();

    public abstract EtatDemande uploader();

    public abstract void affiche();
}
