package model;

public class Model_seDeconnecter {

    /**
     * @return the IDUtilisateur
     */
    public int getIDUtilisateur() {
        return IDUtilisateur;
    }

    /**
     * @param IDUtilisateur the IDUtilisateur to set
     */
    public void setIDUtilisateur(int IDUtilisateur) {
        this.IDUtilisateur = IDUtilisateur;
    }

    public Model_seDeconnecter() {
    }

    public Model_seDeconnecter(int IDUtilisateur) {
        this.IDUtilisateur = IDUtilisateur;
    }

    private int IDUtilisateur;
}
