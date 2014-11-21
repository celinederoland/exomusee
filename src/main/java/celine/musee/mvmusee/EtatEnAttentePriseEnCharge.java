
public class EtatEnAttentePriseEnCharge extends EtatDemande {

	public EtatEnAttentePriseEnCharge(Demande demande) {
		super(demande);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean estPriseEnCharge() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EtatDemande prendreEnCharge(Photographe photographe) {
		// TODO Auto-generated method stub
		EtatDemande etat = new EtatEnAttentePhoto(this.demande);
		return etat;
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
		System.out.println("Demande en attente");
	}

	@Override
	public EtatDemande valider() {
		// TODO Auto-generated method stub
		return null;
	}
}
