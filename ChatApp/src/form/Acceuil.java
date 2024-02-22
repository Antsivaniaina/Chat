package form;

import model.Model_utilisateur;
import net.miginfocom.swing.MigLayout;

public class Acceuil extends javax.swing.JLayeredPane {

    private Chat chat;
   public Acceuil() {
        initComponents();
        init();
    }

    private  void init(){
       setLayout(new MigLayout("fillx, filly", "0[200!]5[fill, 100%]5[200!]0", "0[fill]0"));
       this.add(new Menu_gauche()); 
       chat =new Chat();
       this.add(chat);
       this.add(new Menu_droite());
       chat.setVisible(false);
        
    }

    public void setUtilisateur(Model_utilisateur utilisateur){
         chat.setUtilisateur(utilisateur);
         chat.setVisible(true);
    }
      public void majUtilisateur(Model_utilisateur utilisateur){
        chat.majUtilisateur(utilisateur);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 499, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
