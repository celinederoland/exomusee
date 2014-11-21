
public class EtatEnAttentePhoto extends EtatDemande {

	public EtatEnAttentePhoto(Demande demande) {
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
		EtatDemande etat = new EtatEnAttentePriseEnCharge(this.demande);
		return etat;
	}

	@Override
	public EtatDemande refuser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EtatDemande uploader() {
		// TODO Auto-generated method stub
		EtatDemande etat = new EtatEnAttenteValidation(this.demande);
		return etat;
	}

	public void affiche() {
		System.out.println("Demande prise en charge par : " + this.demande.getPhotographeEnCharge().getNom());
		if (this.demande.hasPhoto()) { 
			System.out.println("Photo : " + this.demande.getPhoto().getChemin() + " REFUSEE "); 
		}
		System.out.println("----------------------------------------------------");
		for (String com : this.demande.getCommentaires()) {
			System.out.println(com);
			System.out.println("----------------------------------------------------");
		}
	}

	@Override
	public EtatDemande valider() {
		// TODO Auto-generated method stub
		return null;
	}
}
