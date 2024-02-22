package main;

import event.EventImageView;
import event.EventMain;
import event.PublicEvent;
import swing.ComponentResizer;
import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import form.Menu_gauche;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import model.Model_seDeconnecter;
import model.Model_utilisateur;
import service.Service;

public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
        init();
    }
    
    //Fonction exécuter lors du démmarage de l'APP
    private void init(){
        setIconImage(new ImageIcon(getClass().getResource("/icon/icon.png")).getImage());
        ComponentResizer com = new ComponentResizer();
        com.registerComponent(this);
        com.setMinimumSize(new Dimension(800, 500));
        com.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        com.setSnapSize(new Dimension(10,10));
        btn_deconnexion.setVisible(false);
        login.setVisible(true);
        chargement.setVisible(false);
        afficher_Image.setVisible(false);
        acceuil.setVisible(false);   
        initEvent();
        
        //Lancer la connexion au server SOCKET ==> Création d'un socket client
        Service.getInstance().startServer();
    }
    
    private void initEvent() {
        //Fonction executer lors de l'appel de l'evennement MAIN EventMain()
        PublicEvent.getInstance().addEventMain(new EventMain() {
            
            //Affichage de ma page de Chargement avec le GIF
            @Override
            public void showLoading(boolean show) {
                chargement.setVisible(show);
            }
            
            //Affichage de la page d'acceuil de l'APP et listage des Utilisateur sur le MENU GAUCHE
            @Override
            public void initChat() {
                acceuil.setVisible(true);
                login.setVisible(false);
                btn_deconnexion.setVisible(true);
                Service.getInstance().getClient().emit("list_utilisateur", Service.getInstance().getUtilisateur().getIDUtilisateur());
            }

            @Override
            public void selectUtilisateur(Model_utilisateur utilisateur) {
                acceuil.setUtilisateur(utilisateur);
           }

            @Override
            public void majUtilisateur(Model_utilisateur utilisateur) {
                acceuil.majUtilisateur(utilisateur);
            }

            @Override
            public void endChat() {
            acceuil.setVisible(false);
            login.setVisible(true);
            Menu_gauche menu = new Menu_gauche();
            menu.viderMenuGauche();
            btn_deconnexion.setVisible(false);
            }
     
        });
        
        //Fonction exécuter lors de l'affichage d'un IMAGE en GROS PLAN
        PublicEvent.getInstance().addEventImageView(new EventImageView() {
            //Affichage de l'image'
            @Override
            public void viewImage(Icon image) {
                afficher_Image.afficheImage(image); 
            }
            
            //Téléchargement de l'image
            @Override
            public void saveImage(Icon image) {
                System.out.println("Image télécharge");
            }

        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        border = new javax.swing.JPanel();
        background = new javax.swing.JPanel();
        titre = new javax.swing.JPanel();
        btn_close = new javax.swing.JButton();
        btn_Min = new javax.swing.JButton();
        btn_deconnexion = new javax.swing.JButton();
        corps = new javax.swing.JLayeredPane();
        chargement = new form.Chargement();
        login = new form.Login();
        acceuil = new form.Acceuil();
        afficher_Image = new form.Afficher_Image();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        border.setBackground(new java.awt.Color(222, 216, 230));

        background.setBackground(new java.awt.Color(255, 255, 255));

        titre.setBackground(new java.awt.Color(229, 229, 229));
        titre.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                titreMouseDragged(evt);
            }
        });
        titre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                titreMousePressed(evt);
            }
        });

        btn_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close.png"))); // NOI18N
        btn_close.setToolTipText("Fermer");
        btn_close.setContentAreaFilled(false);
        btn_close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });

        btn_Min.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/minimized.png"))); // NOI18N
        btn_Min.setToolTipText("Reduire");
        btn_Min.setContentAreaFilled(false);
        btn_Min.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Min.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MinActionPerformed(evt);
            }
        });

        btn_deconnexion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout.png"))); // NOI18N
        btn_deconnexion.setToolTipText("Se déconnecter");
        btn_deconnexion.setContentAreaFilled(false);
        btn_deconnexion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_deconnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deconnexionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout titreLayout = new javax.swing.GroupLayout(titre);
        titre.setLayout(titreLayout);
        titreLayout.setHorizontalGroup(
            titreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titreLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_deconnexion, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Min, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_close, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        titreLayout.setVerticalGroup(
            titreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_close, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(titreLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(titreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_deconnexion, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btn_Min, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        corps.setLayout(new java.awt.CardLayout());
        corps.add(chargement, "card5");
        corps.add(login, "card4");
        corps.add(acceuil, "card2");
        corps.setLayer(afficher_Image, javax.swing.JLayeredPane.MODAL_LAYER);
        corps.add(afficher_Image, "card3");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(corps, javax.swing.GroupLayout.DEFAULT_SIZE, 1072, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(titre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(corps, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout borderLayout = new javax.swing.GroupLayout(border);
        border.setLayout(borderLayout);
        borderLayout.setHorizontalGroup(
            borderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        borderLayout.setVerticalGroup(
            borderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(border, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(border, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private int pX;
    private int pY;
    
    private void titreMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titreMouseDragged
        // TODO add your handling code here:
         this.setLocation(this.getLocation().x + evt.getX() - pX, this.getLocation().y + evt.getY() - pY);
    }//GEN-LAST:event_titreMouseDragged

    private void titreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titreMousePressed
        // TODO add your handling code here:
        pX = evt.getX();
        pY = evt.getY();
    }//GEN-LAST:event_titreMousePressed

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
         System.exit(0);
    }//GEN-LAST:event_btn_closeActionPerformed

    private void btn_MinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MinActionPerformed
        // TODO add your handling code here:
         this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btn_MinActionPerformed

    private void btn_deconnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deconnexionActionPerformed
        // TODO add your handling code here:
        PublicEvent.getInstance().getEventLogin().seDeConnecter(new Model_seDeconnecter(Service.getInstance().getUtilisateur().getIDUtilisateur()));         
    }//GEN-LAST:event_btn_deconnexionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        FlatArcIJTheme.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private form.Acceuil acceuil;
    private form.Afficher_Image afficher_Image;
    private javax.swing.JPanel background;
    private javax.swing.JPanel border;
    private javax.swing.JButton btn_Min;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_deconnexion;
    private form.Chargement chargement;
    private javax.swing.JLayeredPane corps;
    private form.Login login;
    private javax.swing.JPanel titre;
    // End of variables declaration//GEN-END:variables
}
