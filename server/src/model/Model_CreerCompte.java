package model;

public class Model_CreerCompte {

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String NomUtilisateur) {
        this.nomUtilisateur = NomUtilisateur;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Model_CreerCompte(String userName, String password) {
        this.nomUtilisateur = userName;
        this.motDePasse = password;
    }

    public Model_CreerCompte() {
    }

    private String nomUtilisateur;
    private String motDePasse;
}
