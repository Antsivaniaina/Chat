package service;

import event.PublicEvent;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import java.io.FileInputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import model.Model_Recoit_Message;
import model.Model_utilisateur;

public class Service {

    private static Service instance;
    private Socket client;
    private int PORT_NUMBER;
    private String HOST_NAME;
    private Model_utilisateur utilisateur; 

    public static Service getInstance() {
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }

    private Service() {
    }
    //Configuration de l'Hostname et le port d'ecoute du client Socket
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
    
    //Connexion au serveur SOCKET
    public void startServer() {
        setPortandIP();
        try {
            client = IO.socket("http://" + HOST_NAME + ":" + PORT_NUMBER);
            
            //Affichage des utilisateur sur la barre gauche si l'événement ""List_utilisateur" est activer par la réussi de la connexion à l'APP
            client.on("list_utilisateur", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    //Lister les utilisateurs
                    List<Model_utilisateur> utilisateurs = new ArrayList<>();
                    for(Object o:os){
                        Model_utilisateur u = new Model_utilisateur(o);
                        if(u.getIDUtilisateur() != utilisateur.getIDUtilisateur()){
                            utilisateurs.add(u);                        
                        }
                    }
                    //Envoies des données utilisateurs pour l'affichage au MENU GAUCHE
                    PublicEvent.getInstance().getEventMenuGauche().nouveauUtilisateur(utilisateurs);
                        
                }
            });
            
            client.on("utilisateur_status", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                   int utilisateurID = (Integer) os[0];
                   boolean status = (Boolean) os[1];
                   if(status){
                       //Connexion
                       PublicEvent.getInstance().getEventMenuGauche().utilisateurConnexion(utilisateurID);
                   }else{
                       //Deconnexion
                       PublicEvent.getInstance().getEventMenuGauche().utilisateurDeconnexion(utilisateurID);
                   }
                }
            });
            
            client.on("reçoit_par_utilisateur", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    Model_Recoit_Message messageRecu = new Model_Recoit_Message(os[0]);
                    PublicEvent.getInstance().getEventChat().reçoitMessage(messageRecu);
                }
            });
            //Tentative de connexion au server SOCKET
            client.open();
            
        } catch (URISyntaxException e) {
            error(e);
        }
    }

    public Socket getClient() {
        return client;
    }


    /**
     * @return the utilisateur
     */
    public Model_utilisateur getUtilisateur() {
        return utilisateur;
    }

    /**
     * @param utilisateur the utilisateur to set
     */
    public void setUtilisateur(Model_utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    private void error(Exception e) {
        System.err.println(e);
    }
}
