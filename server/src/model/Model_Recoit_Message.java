package model;

public class Model_Recoit_Message {

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

    public Model_Recoit_Message() {
       
    }

    public Model_Recoit_Message(int depuisUtilisateurID, String texte) {
        this.depuisUtilisateurID = depuisUtilisateurID;
        this.texte = texte;
    }
    
    private int depuisUtilisateurID;
    private String texte;
    
}
