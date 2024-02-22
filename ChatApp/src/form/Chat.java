package form;

import component.Chat_Corps;
import component.Pied_Chat;
import component.Titre_Chat;
import event.EventChat;
import event.PublicEvent;
import model.Model_Envoie_Message;
import model.Model_Recoit_Message;
import model.Model_utilisateur;
import net.miginfocom.swing.MigLayout;

public class Chat extends javax.swing.JPanel {

    private Titre_Chat chatTitre;
    private Chat_Corps chatCorps;
    private Pied_Chat piedChat;
    public Chat() {
        initComponents();
        init();
    }
    private void init(){
        setLayout(new MigLayout("fillx", "0[fill]0", "0[]0[100%, bottom]0[shrink 0]0"));
        chatTitre = new Titre_Chat();
        chatCorps = new Chat_Corps();
        piedChat = new Pied_Chat();
        PublicEvent.getInstance().addEventChat(new EventChat() {
            @Override
            public void envoyerMessage(Model_Envoie_Message data) {
                chatCorps.ajoutItemDroite(data);
            }

            @Override
            public void reçoitMessage(Model_Recoit_Message data) {
                if(chatTitre.getUtilisateur().getIDUtilisateur() == data.getDepuisUtilisateurID()){
                    chatCorps.ajoutItemGauche(data);
                }
            }
            
        });
        add(chatTitre,"wrap");
        add(chatCorps,"wrap");
        add(piedChat,"h ::30%");
        
    }
    public void setUtilisateur(Model_utilisateur utilisateur){
        chatTitre.setUserName(utilisateur);
        piedChat.setUtilisateur(utilisateur);
        chatCorps.effacerChat();
    }
    public void majUtilisateur(Model_utilisateur utilisateur){
        chatTitre.majUtilisateur(utilisateur);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 546, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 571, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
