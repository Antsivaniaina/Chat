package model;

public class Model_Envoie_Message {

    /**
     * @return the depuisUtilisateurID
     */
    public int getDepuisUtilisateurID() {
        return depuisUtilisateurID;
    }

    /**
     * @param depuisUtilisateurID the depuisUtilisateurID to set
     */
    public void setDepuisUtilisateurID(int depuisUtilisateurID) {
        this.depuisUtilisateurID = depuisUtilisateurID;
    }

    /**
     * @return the pourUtilisateurID
     */
    public int getPourUtilisateurID() {
        return pourUtilisateurID;
    }

    /**
     * @param pourUtilisateurID the pourUtilisateurID to set
     */
    public void setPourUtilisateurID(int pourUtilisateurID) {
        this.pourUtilisateurID = pourUtilisateurID;
    }

    /**
     * @return the texte
     */
    public String getTexte() {
        return texte;
    }

    /**
     * @param texte the texte to set
     */
    public void setTexte(String texte) {
        this.texte = texte;
    }

    public Model_Envoie_Message() {
    }

    public Model_Envoie_Message(int depuisUtilisateurID, int pourUtilisateurID, String texte) {
        this.depuisUtilisateurID = depuisUtilisateurID;
        this.pourUtilisateurID = pourUtilisateurID;
        this.texte = texte;
    }
    
    private int depuisUtilisateurID;
    private int pourUtilisateurID;
    private String texte;
    
}
