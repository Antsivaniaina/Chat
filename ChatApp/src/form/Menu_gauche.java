package form;

import component.Personne_msg;
import event.EventMenuGauche;
import event.PublicEvent;
import java.awt.Component;
import swing.ScrollBar;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import model.Model_utilisateur;
import net.miginfocom.swing.MigLayout;

public class Menu_gauche extends javax.swing.JLayeredPane {
    
    private List<Model_utilisateur> compteutilisateur;

    public Menu_gauche() {
        initComponents();
        init();
    }

    public void init(){
        sp.setVerticalScrollBar(new ScrollBar());
        menuList.setLayout(new MigLayout("fillx", "0[]0", "0[]0"));
        compteutilisateur = new ArrayList<>();
        PublicEvent.getInstance().addEventMenuGauche(new EventMenuGauche() {
            @Override
            public void nouveauUtilisateur(List<Model_utilisateur> utilisateur) {
                for(Model_utilisateur d:utilisateur){
                    compteutilisateur.add(d);
                    menuList.add(new Personne_msg(d), "wrap");
                    actualiserMsg();
                }
            }

            @Override
            public void utilisateurConnexion(int utilisateurID) {
                for(Model_utilisateur u : compteutilisateur){
                    if(u.getIDUtilisateur() == utilisateurID){
                        u.setStatus(true);
                        PublicEvent.getInstance().getEventMain().majUtilisateur(u);
                        break;
                    }
                }
                if (menuMsg.isSelected()) {
                    for (Component com : menuList.getComponents()) {
                        Personne_msg personne = (Personne_msg) com;
                        if (personne.getUtilisateur().getIDUtilisateur() == utilisateurID) {
                            personne.majStatus();
                            break;
                        }
                    }
                }
            }

            @Override
            public void utilisateurDeconnexion(int utilisateurID) {
                 for(Model_utilisateur u : compteutilisateur){
                    if(u.getIDUtilisateur() == utilisateurID){
                        u.setStatus(false);
                        PublicEvent.getInstance().getEventMain().majUtilisateur(u);
                        break;
                    }
                }
                if (menuMsg.isSelected()) {
                    for (Component com : menuList.getComponents()) {
                        Personne_msg personne = (Personne_msg) com;
                        if (personne.getUtilisateur().getIDUtilisateur() == utilisateurID) {
                            personne.majStatus();
                            break;
                        }
                    }
                }
            }
            
        });
        afficherPersonne();
    }
    
    private void afficherPersonne() {
        menuList.removeAll();
        for (Model_utilisateur d:compteutilisateur) {
            menuList.add(new Personne_msg(d), "wrap");
        }
        actualiserMsg();
    }

    private void afficherGroup() {
        menuList.removeAll();
        for (int i = 0; i < 5; i++) {
            menuList.add(new Personne_msg(null), "wrap");
        }
        actualiserMsg();
    }

    private void afficherMsg() {
        //  test data
        menuList.removeAll();
        for (int i = 0; i < 10; i++) {
            menuList.add(new Personne_msg(null), "wrap");
        }
        actualiserMsg();
    }
    
    public void viderMenuGauche(){
        menuList.removeAll();
        actualiserMsg();
    }

    private void actualiserMsg() {
        menuList.repaint();
        menuList.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JLayeredPane();
        menuMsg = new component.MenuBoutton();
        menuGroup = new component.MenuBoutton();
        sp = new javax.swing.JScrollPane();
        menuList = new javax.swing.JLayeredPane();

        setBackground(new java.awt.Color(169, 202, 246));

        menu.setBackground(new java.awt.Color(66, 155, 248));
        menu.setOpaque(true);
        menu.setLayout(new java.awt.GridLayout(1, 3));

        menuMsg.setIconSelected(new javax.swing.ImageIcon(getClass().getResource("/icon/message_selected.png"))); // NOI18N
        menuMsg.setIconSimple(new javax.swing.ImageIcon(getClass().getResource("/icon/message.png"))); // NOI18N
        menuMsg.setSelected(true);
        menuMsg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMsgActionPerformed(evt);
            }
        });
        menu.add(menuMsg);

        menuGroup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/group.png"))); // NOI18N
        menuGroup.setIconSelected(new javax.swing.ImageIcon(getClass().getResource("/icon/group_selected.png"))); // NOI18N
        menuGroup.setIconSimple(new javax.swing.ImageIcon(getClass().getResource("/icon/group.png"))); // NOI18N
        menuGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGroupActionPerformed(evt);
            }
        });
        menu.add(menuGroup);

        sp.setBackground(new java.awt.Color(220, 214, 249));
        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        menuList.setBackground(new java.awt.Color(169, 202, 246));
        menuList.setOpaque(true);

        javax.swing.GroupLayout menuListLayout = new javax.swing.GroupLayout(menuList);
        menuList.setLayout(menuListLayout);
        menuListLayout.setHorizontalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        menuListLayout.setVerticalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 613, Short.MAX_VALUE)
        );

        sp.setViewportView(menuList);

        setLayer(menu, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(sp, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(sp)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void menuMsgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMsgActionPerformed
        // TODO add your handling code here:
        if (!menuMsg.isSelected()) {
            menuMsg.setSelected(true);
            menuGroup.setSelected(false);
            afficherPersonne()  ;
        }
    }//GEN-LAST:event_menuMsgActionPerformed

    private void menuGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGroupActionPerformed
        // TODO add your handling code here:
        if (!menuGroup.isSelected()) {
            menuMsg.setSelected(false);
            menuGroup.setSelected(true);
            afficherGroup();
        }
    }//GEN-LAST:event_menuGroupActionPerformed
@Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane menu;
    private component.MenuBoutton menuGroup;
    private javax.swing.JLayeredPane menuList;
    private component.MenuBoutton menuMsg;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
