package component;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;

public class Chat_gauche extends javax.swing.JLayeredPane {

    public Chat_gauche() {
        initComponents();
        txt.setBackground(new Color(218,228,241));
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

        txt = new component.Chat_Item();

        setLayer(txt, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.Chat_Item txt;
    // End of variables declaration//GEN-END:variables
}
