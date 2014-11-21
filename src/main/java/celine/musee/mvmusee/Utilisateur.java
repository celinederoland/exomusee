
public class Utilisateur {
    protected int identifiant;

    protected String nom;

    public Utilisateur(String nom, int id)
    {
    	this.nom = nom;
    	this.identifiant = id;
    }
    
    int getIdentifiant() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.identifiant;
    }

    void setIdentifiant(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.identifiant = value;
    }

    String getNom() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.nom;
    }

    void setNom(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.nom = value;
    }

}
