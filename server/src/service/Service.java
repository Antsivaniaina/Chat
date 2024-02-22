package service;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import model.Model_Message;
import model.Model_CreerCompte;
import javax.swing.JTextArea;
import model.Model_Client;
import model.Model_Envoie_Message;
import model.Model_Recoit_Message;
import model.Model_seDeconnecter;
import model.Model_seconnecter;
import model.Model_utilisateur;

public class Service {

    private static Service instance;
    private SocketIOServer server;
    private final ServiceUtilisateur serviceUtilisateur;
    private final List<Model_Client> listClient;
    private final JTextArea textArea;
    private int PORT_NUMBER;
    private String HOST_NAME;

    public static Service getInstance(JTextArea textArea) {
        if (instance == null) {
            instance = new Service(textArea);
        }
        return instance;
    }
    
    public void setPortandIP(){
    Properties props = new  Properties();
          try (FileInputStream fis = new FileInputStream("conf.properties"))
            {
                props.load(fis);
                this.PORT_NUMBER  = Integer.parseInt(props.getProperty("socket.port").trim());
                this.HOST_NAME  = props.getProperty("socket.host").trim();
            }
          catch (Exception e)
            {
              e.printStackTrace();
            }
    }

    private Service(JTextArea textArea) {
        this.textArea = textArea;
        serviceUtilisateur = new ServiceUtilisateur();
        listClient = new ArrayList<>();
    }

    public void startServer() {
        Configuration config = new Configuration();
        setPortandIP();
        config.setPort(PORT_NUMBER);
        config.setHostname(HOST_NAME);
        server = new SocketIOServer(config);
        server.addConnectListener(new ConnectListener() {
            @Override
            public void onConnect(SocketIOClient sioc) {
               String IP = sioc.getRemoteAddress().toString();
              textArea.append("Un client connecter : "+ IP +"\n");
            }
        });
        
        //Pour créer un compte utilisateur
        server.addEventListener("creercompte", Model_CreerCompte.class, new DataListener<Model_CreerCompte>() {
            @Override
            public void onData(SocketIOClient sioc, Model_CreerCompte t, AckRequest ar) throws Exception {
                Model_Message message = serviceUtilisateur.creerCompte(t);
                ar.sendAckData(message.isAction(), message.getMessage(), message.getData());
                if (message.isAction()) {
                        textArea.append("Utilisateur :" + t.getNomUtilisateur()+ " Pass :" + t.getMotDePasse()+ " enregistré.\n\n");
                        server.getBroadcastOperations().sendEvent("list_utilisateur", (Model_utilisateur) message.getData());
                        ajouterClient(sioc, (Model_utilisateur) message.getData());
                    }
                }
        });
        
        //Lister les utilisateur en temps réel
        server.addEventListener("list_utilisateur", Integer.class, new DataListener<Integer>() {
            @Override
            public void onData(SocketIOClient sioc, Integer userID, AckRequest ar) throws Exception {
                try {
                    List<Model_utilisateur > list = serviceUtilisateur.getUser(userID);
                    sioc.sendEvent("list_utilisateur", list.toArray());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        
        //Pour se connecter
         server.addEventListener("seconnecter", Model_seconnecter.class, new DataListener<Model_seconnecter>() {
            @Override
            public void onData(SocketIOClient sioc, Model_seconnecter t, AckRequest ar) throws Exception {
                Model_utilisateur seconnecter = serviceUtilisateur.seconnecter(t);
                if (seconnecter != null) {
                    ar.sendAckData(true, seconnecter);
                    ajouterClient(sioc, seconnecter);
                    utilisateurConnect(seconnecter.getIDUtilisateur());
                } else {
                    ar.sendAckData(false);
                }
            }
         });
         
         //Pour se deconnecter
         server.addEventListener("deconnexion", Model_seDeconnecter.class, new DataListener<Model_seDeconnecter>() {
            @Override
            public void onData(SocketIOClient sioc, Model_seDeconnecter t, AckRequest ar) throws Exception {
                int utilisateurID = supprimerClient(sioc);
                if(utilisateurID != 0){
                    utilisateurDeconnect(utilisateurID);
                }
            }
         });
         
         //Envoi un message à un utilisateur
         server.addEventListener("envoyer_a_utilisateur", Model_Envoie_Message.class, new DataListener<Model_Envoie_Message>() {
            @Override
            public void onData(SocketIOClient sioc, Model_Envoie_Message t, AckRequest ar) throws Exception {
                envoiAutilisateur(t);
                
            }
         });
         
         
         //Ecoute si un utilisateur se Deconnect
         server.addDisconnectListener(new DisconnectListener(){
            @Override
            public void onDisconnect(SocketIOClient sioc) {
                int utilisateurID = supprimerClient(sioc);
                if(utilisateurID != 0){
                    utilisateurDeconnect(utilisateurID);
                }
            }
         });
        server.start();
        textArea.append("Server start sur : http://" + HOST_NAME +":"+ PORT_NUMBER + "\n\n");
    }
    
    private void utilisateurConnect(int utilisateurID){
        textArea.append("Utilisateur : "+utilisateurID+" connecté.\n\n");
        server.getBroadcastOperations().sendEvent("utilisateur_status", utilisateurID, true);   
    }
    
    private void utilisateurDeconnect(int utilisateurID){
        textArea.append("Utilisateur : "+utilisateurID+" déconnecté.\n\n");
        server.getBroadcastOperations().sendEvent("utilisateur_status", utilisateurID, false);   
    }
    
    private void ajouterClient(SocketIOClient client, Model_utilisateur utilisateur){
        listClient.add(new Model_Client(client,utilisateur));
    }

    public int supprimerClient(SocketIOClient client){
         for(Model_Client d:listClient){
             if(d.getClient() == client){
                listClient.remove(d);
                return d.getUtilisateur().getIDUtilisateur();
             }
         } 
         return 0;
    }
    private void envoiAutilisateur(Model_Envoie_Message data){
        for(Model_Client c:listClient){
            if(c.getUtilisateur().getIDUtilisateur() == data.getPourUtilisateurID()){
               c.getClient().sendEvent("reçoit_par_utilisateur", new Model_Recoit_Message(data.getDepuisUtilisateurID(), data.getTexte()));
                break;
            }
        } 
    }
       
    public List<Model_Client> getListClient() {
        return listClient;
    }
}
