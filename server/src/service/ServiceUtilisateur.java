package service;

import connection.DatabaseConnection;
import model.Model_Message;
import model.Model_CreerCompte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Model_Client;
import model.Model_seconnecter;
import model.Model_utilisateur;

public class ServiceUtilisateur {

    public ServiceUtilisateur() {
        this.con = DatabaseConnection.getInstance().getConnection();
    }

    //Insertion dans la base de donnée pour un utilisateur créer.
    
    public Model_Message creerCompte(Model_CreerCompte data) {
        //  Check user exit
        Model_Message message = new Model_Message();
        try {
            
            //Rechercher si l'utilisateur existe dans la base
            
            PreparedStatement p = con.prepareStatement(CHECK_USER);
            p.setString(1, data.getNomUtilisateur());
            ResultSet r = p.executeQuery();
            if (r.first()) {
                message.setAction(false);
                message.setMessage("Utilisateur existant.");
            } else {
                message.setAction(true);
            }
            r.close();
            p.close();
            if (message.isAction()) {
                con.setAutoCommit(false);
                
                //  Insérer utilisateur enregistrer
                
                p = con.prepareStatement(INSERT_USER, PreparedStatement.RETURN_GENERATED_KEYS);
                p.setString(1, data.getNomUtilisateur());
                p.setString(2, data.getMotDePasse());
                p.execute();
                r=p.getGeneratedKeys();
                r.first();
                int utilisateurID = r.getInt(1);      
                r.close();  
                p.close();
                
                //Céer utilisateur
                
                p=con.prepareStatement(INSERT_USER_ACCOUNT);
                p.setInt(1,utilisateurID);
                p.setString(2,data.getNomUtilisateur());
                p.execute();
                p.close();
                con.commit();
                con.setAutoCommit(true);
                message.setAction(true);
                message.setMessage("Ok");
                message.setData(new Model_utilisateur(utilisateurID, data.getNomUtilisateur(), "", "", true));
            }
        } catch (SQLException e) {
            message.setAction(false);
            message.setMessage("Server Error");
            try {
                if (con.getAutoCommit() == false) {
                    con.rollback();
                    con.setAutoCommit(true);
                }
            } catch (SQLException e1) {
            }
            e.printStackTrace();
        }
        return message;
    }
    
    //Recherche un utilisateur par son ID
    public List<Model_utilisateur> getUser(int exitUser) throws  SQLException {
        List<Model_utilisateur> list = new ArrayList<>();
        PreparedStatement p = con.prepareStatement(SELECT_UTILISATEUR);
        p.setInt(1, exitUser);
        ResultSet res = p.executeQuery();
        while (res.next()) {
           int userID = res.getInt(1);
           String nomUtilisateur = res.getString(2);
           String genre = res.getString(3);
           String sary = res.getString(4);
           list.add(new Model_utilisateur(userID,nomUtilisateur,genre,sary,voirStatus(userID)));
        }
        res.close();
        p.close();
        return list;
    }
    
    public Model_utilisateur seconnecter(Model_seconnecter seConnecter) throws SQLException{
        Model_utilisateur data = null;
        PreparedStatement p = con.prepareStatement(SE_CONNECTER);
        p.setString(1, seConnecter.getNomUtilisateur());
        p.setString(2, seConnecter.getMotDePasse());
        ResultSet res = p.executeQuery();
        if (res.first()){
            int utilisateurID = res.getInt(1);
            String nomUtilisateur = res.getString(2);
            String genre = res.getString(3);
            String sary = res.getString(4);
            data = new Model_utilisateur(utilisateurID, nomUtilisateur,genre, sary, true);
        }
        res.close();
        p.close();
        return data;
    }

    private boolean voirStatus(int utilisateurID){
        List<Model_Client> client = Service.getInstance(null).getListClient();
        for(Model_Client c : client){
            if(c.getUtilisateur().getIDUtilisateur() == utilisateurID){
                return  true; 
            }
        }
        return false;
    }
    //  Liste des requêtes SQL exécuté
    private final String SE_CONNECTER = "SELECT UserID, user_account.nomUtilisateur, genre, ImageString FROM `user` JOIN user_account USING (UserID) WHERE `user`.UserName=BINARY(?) AND `user`.`Password`=BINARY(?) AND user_account.`Status`='1'";
    private final String SELECT_UTILISATEUR = "SELECT UserID,NomUtilisateur, Genre, Image, ImageString FROM user_account WHERE user_account.`Status`='1' and UserID<>? ";
    private final String INSERT_USER = "INSERT INTO user (UserName, `Password`) VALUES (?,?)";
    private final String INSERT_USER_ACCOUNT = "INSERT INTO user_account (UserID, NomUtilisateur,Image) VALUES (?,?,'')";
    private final String CHECK_USER = "SELECT UserID FROM user where UserName =? LIMIT 1";
    //  Instance
    private final Connection con;
}
