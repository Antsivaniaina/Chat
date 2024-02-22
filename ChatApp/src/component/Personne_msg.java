package component;

import event.PublicEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.Model_utilisateur;

public class Personne_msg extends javax.swing.JLayeredPane{
 
    public Model_utilisateur getUtilisateur() {
        return utilisateur;
    }
    
    private boolean mouseOver;
    private final Model_utilisateur utilisateur;

    public Personne_msg(Model_utilisateur utilisateur) {
        this.utilisateur = utilisateur;
        initComponents();
        lblNom.setText(utilisateur.getNomUtilisateur());
        activeStatus.setActive(utilisateur.isStatus());
        init();
    }
    
    public void majStatus(){
        activeStatus.setActive(utilisateur.isStatus());
    }
    private void init() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                setBackground(new Color(187,214,250));
                mouseOver = true;
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setBackground(new Color(169,202,246));
                mouseOver = false;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(mouseOver){
                    PublicEvent.getInstance().getEventMain().selectUtilisateur(utilisateur);
                }
            }
            
        });
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageAvatar1 = new swing.ImageAvatar();
        lblStatus = new javax.swing.JLabel();
        activeStatus = new swing.ActiveStatus();
        lblNom = new javax.swing.JLabel();

        setBackground(new java.awt.Color(169, 202, 246));
        setOpaque(true);
        setPreferredSize(new java.awt.Dimension(200, 50));

        imageAvatar1.setBorderSize(0);
        imageAvatar1.setImage(new javax.swing.ImageIcon(getClass().getResource("/icon/user.png"))); // NOI18N

        lblStatus.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(150, 147, 147));
        lblStatus.setText("Nouveau");

        activeStatus.setActive(true);

        lblNom.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        lblNom.setForeground(new java.awt.Color(27, 26, 26));
        lblNom.setText("Nom");

        setLayer(imageAvatar1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(lblStatus, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(activeStatus, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(lblNom, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblStatus)
                        .addGap(3, 3, 3)
                        .addComponent(activeStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblNom))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblStatus)
                            .addComponent(activeStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ActiveStatus activeStatus;
    private swing.ImageAvatar imageAvatar1;
    private javax.swing.JLabel lblNom;
    private javax.swing.JLabel lblStatus;
    // End of variables declaration//GEN-END:variables

  
}
