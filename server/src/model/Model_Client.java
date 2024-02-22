  package model;

import com.corundumstudio.socketio.SocketIOClient;

public class Model_Client {

    public SocketIOClient getClient() {
        return client;
    }

    public void setClient(SocketIOClient client) {
        this.client = client;
    }

    public Model_utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Model_utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Model_Client(SocketIOClient client, Model_utilisateur user) {
        this.client = client;
        this.utilisateur = user;
    }

    public Model_Client() {
    }

    private SocketIOClient client;
    private Model_utilisateur utilisateur;
}
