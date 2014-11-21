
public class EtatValide extends EtatDemande {

	public EtatValide(Demande demande) {
		super(demande);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean estPriseEnCharge() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public EtatDemande prendreEnCharge(Photographe photographe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EtatDemande desengager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EtatDemande refuser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EtatDemande uploader() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void affiche() {
		System.out.println("Demande effectuée par : " + this.demande.getPhotographeEnCharge().getNom());
		if (this.demande.hasPhoto()) { 
			System.out.println("Photo : " + this.demande.getPhoto().getChemin() + " VALIDE "); 
		}
	}

	@Override
	public EtatDemande valider() {
		// TODO Auto-generated method stub
		return null;
	}

}
