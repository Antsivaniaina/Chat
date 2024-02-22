package form;

import event.PublicEvent;
import model.Model_seconnecter;

public class Page_Login extends javax.swing.JPanel {

    public Page_Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_titre = new javax.swing.JLabel();
        mdp_user = new swing.TextField();
        nom_user = new swing.TextField();
        btn_creercompte = new swing.Button();
        btn_seconnecter = new swing.Button();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(295, 386));
        setRequestFocusEnabled(false);

        lbl_titre.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lbl_titre.setForeground(new java.awt.Color(46, 44, 44));
        lbl_titre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_titre.setText("Se connecter");

        mdp_user.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        mdp_user.setLabelText("Mot de passe");
        mdp_user.setLineColor(new java.awt.Color(46, 44, 44));
        mdp_user.setOpaque(true);
        mdp_user.setTextColor(new java.awt.Color(46, 44, 44));

        nom_user.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        nom_user.setLabelText("Nom d'utilisateur");
        nom_user.setLineColor(new java.awt.Color(46, 44, 44));
        nom_user.setMargin(new java.awt.Insets(6, 6, 2, 6));
        nom_user.setTextColor(new java.awt.Color(46, 44, 44));

        btn_creercompte.setBackground(new java.awt.Color(66, 127, 229));
        btn_creercompte.setForeground(new java.awt.Color(255, 255, 255));
        btn_creercompte.setText("Créer compte");
        btn_creercompte.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btn_creercompte.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_creercompte.setPreferredSize(new java.awt.Dimension(97, 45));
        btn_creercompte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_creercompteActionPerformed(evt);
            }
        });

        btn_seconnecter.setBackground(new java.awt.Color(66, 127, 229));
        btn_seconnecter.setForeground(new java.awt.Color(255, 255, 255));
        btn_seconnecter.setText("Se connecter");
        btn_seconnecter.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btn_seconnecter.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_seconnecter.setPreferredSize(new java.awt.Dimension(95, 45));
        btn_seconnecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_seconnecterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_titre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nom_user, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(mdp_user, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(btn_creercompte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_seconnecter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_titre)
                .addGap(30, 30, 30)
                .addComponent(nom_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(mdp_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_seconnecter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(btn_creercompte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_creercompteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_creercompteActionPerformed
        // TODO add your handling code here:
        PublicEvent.getInstance().getEventLogin().retourCreerCompte();
    }//GEN-LAST:event_btn_creercompteActionPerformed

    private void btn_seconnecterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_seconnecterActionPerformed
        // TODO add your handling code here:
        PublicEvent.getInstance().getEventLogin().seConnecter(new Model_seconnecter(nom_user.getText().trim(), mdp_user.getText().trim())); 
        nom_user.setText("");
        mdp_user.setText("");
    }//GEN-LAST:event_btn_seconnecterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btn_creercompte;
    private swing.Button btn_seconnecter;
    private javax.swing.JLabel lbl_titre;
    private swing.TextField mdp_user;
    private swing.TextField nom_user;
    // End of variables declaration//GEN-END:variables
}
