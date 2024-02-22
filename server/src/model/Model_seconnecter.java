package model;

public class Model_seconnecter {

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Model_seconnecter(String userName, String password) {
        this.nomUtilisateur = userName;
        this.motDePasse = password;
    }

    public Model_seconnecter() {
    }

    private String nomUtilisateur;
    private String motDePasse;
}
