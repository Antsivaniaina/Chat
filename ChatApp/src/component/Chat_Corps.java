package component;

import swing.ScrollBar;
import java.awt.Adjustable;
import java.awt.Color;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.Icon;
import javax.swing.JScrollBar;
import model.Model_Envoie_Message;
import model.Model_Recoit_Message;
import net.miginfocom.swing.MigLayout;

public class Chat_Corps extends javax.swing.JPanel {

    public Chat_Corps() {
        initComponents();
        init();
//        ajoutItemDroite("Mety sa we aaaaannnnn");
//        ajoutItemGauche("Hello World\nWay To Mety\n","Mianja");
//        ajoutItemDroite("Mety sa we aaaaannnnn");
//        ajoutItemGauche("Hello Worldfqdsgdrrrrrrrrrrrrrkbkjgbrqgrkjgbdfbgkdfbg;fbgkdfugbrgeoirbgoebgoebrgobrogberogbeorbgobogebrgobrogberogebrroebrogbeorbgoerbg","Rasta");
//        ajoutItemDroite("Mety sa we aaaaannnnn");
//        ajoutItemDroite("Mety sa we aaaaannnnn");
//        ajoutDate("06/16/2024");
//        String img[] = {"LRMj,K-:?G9G_JIon}WqD~ITRPs,","LCGlo@00.R~o.9DOO[%L02?aJ7D*"};
//        ajoutItemGauche("hello\nerererew\newewe","Rasta", new ImageIcon(getClass().getResource("/com/chat/icon/testing/dog.jpg")),new ImageIcon(getClass().getResource("/com/chat/icon/testing/pic.jpg")));
//        ajoutItemGauche("hello\nerererew\newewe","Rasta", new ImageIcon(getClass().getResource("/com/chat/icon/testing/pic.jpg")));
//        ajoutItemGauche("Hello World\nWay\nTo\nMety\n","Rasta");
//        ajoutDate("Aujourd'hui");
//        ajoutItemGauche("","Rija",new ImageIcon(getClass().getResource("/com/chat/icon/testing/1.jpg")));
//        ajoutItemDroite("Mety sa we aaaaannnnn",new ImageIcon(getClass().getResource("/com/chat/icon/testing/dog.jpg")),new ImageIcon(getClass().getResource("/com/chat/icon/testing/pic.jpg")));
//        
    }
 
    private void init(){
        corps.setLayout(new MigLayout("fillx", "", "0[]0"));
        sp.setVerticalScrollBar(new ScrollBar());
        sp.getVerticalScrollBar().setBackground(Color.WHITE); 
    }
    
    public void ajoutItemGauche(Model_Recoit_Message data) {
        //Chat_Gauche_Avec_Profil item = new Chat_Gauche_Avec_Profil();
        Chat_gauche item = new Chat_gauche();
        item.setText(data.getTexte());
        //item.ajoutImage(image);
        item.afficheTime();
       // item.afficheProfile(utilisateur);
        corps.add(item, "wrap, w 100::80%");
        repaint();
        revalidate();
    }
    
    public void ajoutItemGauche(String text, String utilisateur, String[] image) {
        Chat_Gauche_Avec_Profil item = new Chat_Gauche_Avec_Profil();
        item.setText(text);
        item.ajoutImage(image);
        item.afficheTime();
        item.afficheProfile(utilisateur);
        corps.add(item, "wrap, w 100::80%");
        //  ::80% set max with 80%
        corps.repaint();
        corps.revalidate();
        
    }

    public void ajoutItemDroite(Model_Envoie_Message data) {
        Chat_droite item = new Chat_droite();
        item.setText(data.getTexte());
       // item.ajoutImage(image); 
        corps.add(item, "wrap, al right, w 100::80%");
        repaint();
        revalidate();
        item.afficheTime();
        scrollToBottom();
    } 
    public void ajoutItemDroite(String text,String[] image) {
        Chat_droite item = new Chat_droite();
        item.setText(text);
        item.ajoutImage(image); 
        corps.add(item, "wrap, al right, w 100::80%");
        //  ::80% set max with 80%
        corps.repaint();
        corps.revalidate();
        item.afficheTime();
        scrollToBottom();
        
    } 
     public void ajoutDate(String date) {
        Chat_Date item = new Chat_Date();
        item.setDate(date);
        corps.add(item, "wrap, al center");
        corps.repaint();
        corps.revalidate();
    }
    private void scrollToBottom() {
        JScrollBar verticalBar = sp.getVerticalScrollBar();
        AdjustmentListener downScroller = new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                Adjustable adjustable = e.getAdjustable();
                adjustable.setValue(adjustable.getMaximum());
                verticalBar.removeAdjustmentListener(this);
            }
        };
        verticalBar.addAdjustmentListener(downScroller);
    }
    
    public void effacerChat(){
        corps.removeAll();
        repaint();
        revalidate();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        corps = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        corps.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout corpsLayout = new javax.swing.GroupLayout(corps);
        corps.setLayout(corpsLayout);
        corpsLayout.setHorizontalGroup(
            corpsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 904, Short.MAX_VALUE)
        );
        corpsLayout.setVerticalGroup(
            corpsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 659, Short.MAX_VALUE)
        );

        sp.setViewportView(corps);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel corps;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
