package component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import model.Model_utilisateur;

public class Titre_Chat extends javax.swing.JLayeredPane {

    private Model_utilisateur utilisateur;
    public Titre_Chat() {
        initComponents();
    }
    
    public void setUserName(Model_utilisateur utilisateur) {
        this.utilisateur = utilisateur;
        nom.setText(utilisateur.getNomUtilisateur());
        if(utilisateur.isStatus()){
            statusActive();
        }else{
            setStatusText("Offline");
        }
    }

    public void majUtilisateur(Model_utilisateur utilisateur){
        if(this.utilisateur == utilisateur){
            nom.setText(utilisateur.getNomUtilisateur());
            if(utilisateur.isStatus()){
            statusActive();
            }else{
                setStatusText("Offline");
            }
        }
    }
    public void statusActive() {
        status.setText("En ligne");
        status.setForeground(new java.awt.Color(40, 147, 59));
    }

    public void setStatusText(String text) {
        status.setText(text);
        status.setForeground(new Color(160, 160, 160));
    }
   @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponent(grphcs);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        nom = new javax.swing.JLabel();
        status = new javax.swing.JLabel();

        setBackground(new java.awt.Color(169, 202, 246));

        jLayeredPane1.setBackground(new java.awt.Color(255, 153, 153));
        jLayeredPane1.setLayout(new java.awt.GridLayout(0, 1));

        nom.setBackground(new java.awt.Color(38, 37, 40));
        nom.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        nom.setForeground(new java.awt.Color(43, 42, 42));
        nom.setText("Nom");
        jLayeredPane1.add(nom);

        status.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        status.setForeground(new java.awt.Color(0, 204, 51));
        status.setText("En ligne");
        jLayeredPane1.add(status);

        setLayer(jLayeredPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(308, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel nom;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the utilisateur
     */
    public Model_utilisateur getUtilisateur() {
        return utilisateur;
    }
}
