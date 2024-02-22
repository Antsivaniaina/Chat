package model;

import org.json.JSONException;
import org.json.JSONObject;

public class Model_utilisateur {

    public int getIDUtilisateur() {
        return IDUtilisateur;
    }

    public void setIDUtilisateur(int IDUtilisateur) {
        this.IDUtilisateur = IDUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSary() {
        return sary;
    }

    public void setSary(String sary) {
        this.sary = sary;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Model_utilisateur(int userID, String userName, String gender, String sary, boolean status) {
        this.IDUtilisateur = userID;
        this.nomUtilisateur = userName;
        this.genre = gender;
        this.sary = sary;
        this.status = status;
    }

    public Model_utilisateur(Object json) {
        JSONObject obj = (JSONObject) json;
        try {
            IDUtilisateur = obj.getInt("idutilisateur");
            nomUtilisateur = obj.getString("nomUtilisateur");
            genre = obj.getString("genre");
            sary = obj.getString("sary");
            status = obj.getBoolean("status");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private int IDUtilisateur;
    private String nomUtilisateur;
    private String genre;
    private String sary;
    private boolean status;
}
