
public class Photo {
	
	private String chemin;
	
	public void setChemin(String value)
	{
		this.chemin = value;
	}
	
	public String getChemin()
	{
		return this.chemin;
	}
	
    /* Cinquième flèche de Inc1DSeqAffichageEtape2 */
    public void afficher() {
    	System.out.println("Je suis une photo et je m'affiche");
    	System.out.println("Chemin d'accès : " + this.chemin);
    }

    /* constructeur généré par modelio */ 
    public Photo(String chemin) {
    	this.chemin = chemin;
    }

}