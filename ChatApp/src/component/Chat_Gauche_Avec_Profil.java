package component;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;

public class Chat_Gauche_Avec_Profil extends javax.swing.JLayeredPane {

    public Chat_Gauche_Avec_Profil() {
        initComponents();
        txt.setBackground(new Color(218,228,241));
    }
    
    public void afficheProfile(String utilisateur) {
        txt.afficheProfile(utilisateur);
    }

    public void setImageProfile(Icon image) {
        imageProfile.setImage(image);
    } 
    public void setText(String text) { 
        if (text.equals("")) {
            txt.hideText();
        } else {
            txt.setText(text);
        }
    }
    
    public void ajoutImage(Icon... image){
        txt.ajouterImage(false, image);
    }
     public void ajoutImage(String... image){
        txt.ajouterImage(false, image);
    }
    
    public void afficheTime(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
        String dateFormater = sdf.format(date);
        txt.afficheTime(dateFormater);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        imageProfile = new swing.ImageAvatar();
        txt = new component.Chat_Item();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        imageProfile.setBorderSize(0);
        imageProfile.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/chat/icon/testing/dog.jpg"))); // NOI18N
        imageProfile.setMaximumSize(new java.awt.Dimension(31, 31));
        imageProfile.setMinimumSize(new java.awt.Dimension(31, 31));

        jLayeredPane1.setLayer(imageProfile, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jLayeredPane1);
        add(txt);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ImageAvatar imageProfile;
    private javax.swing.JLayeredPane jLayeredPane1;
    private component.Chat_Item txt;
    // End of variables declaration//GEN-END:variables
}
