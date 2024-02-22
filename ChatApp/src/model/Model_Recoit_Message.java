package model;

import org.json.JSONException;
import org.json.JSONObject;

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

    public Model_Recoit_Message(Object json) {
        JSONObject obj = (JSONObject) json;
        try {
            depuisUtilisateurID = obj.getInt("depuisUtilisateurID");
            texte = obj.getString("texte");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Model_Recoit_Message(int depuisUtilisateurID, String texte) {
        this.depuisUtilisateurID = depuisUtilisateurID;
        this.texte = texte;
    }
    
    private int depuisUtilisateurID;
    private String texte;
    
        public JSONObject toJsonObject() {
        try {
            JSONObject json = new JSONObject();
            json.put("depuisUtilisateurID", getDepuisUtilisateurID());
            json.put("texte", getTexte());
            return json;
        } catch (JSONException e) {
            return null;
        }
    }
}
