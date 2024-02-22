 package model;

import org.json.JSONException;
import org.json.JSONObject;

public class Model_Register {

    public String getUserName() {
        return nomUtilisateur;
    }

    public void setUserName(String userName) {
        this.nomUtilisateur = userName;
    }

    public String getPassword() {
        return motDePasse;
    }

    public void setPassword(String password) {
        this.motDePasse = password;
    }

    public Model_Register(String userName, String password) {
        this.nomUtilisateur = userName;
        this.motDePasse = password;
    }

    public Model_Register() {
    }

    private String nomUtilisateur;
    private String motDePasse;

    public JSONObject toJsonObject() {
        try {
            JSONObject json = new JSONObject();
            json.put("nomUtilisateur", nomUtilisateur);
            json.put("motDePasse", motDePasse);
            return json;
        } catch (JSONException e) {
            return null;
        }
    }
}
