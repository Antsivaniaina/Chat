package component;

import event.PublicEvent;
import swing.JIMSendTextPane;
import swing.ScrollBar;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import model.Model_Envoie_Message;
import model.Model_utilisateur;
import net.miginfocom.swing.MigLayout;
import service.Service;

public class Pied_Chat extends javax.swing.JLayeredPane {
    
    private Model_utilisateur utilisateur;
    public Pied_Chat() {
        initComponents();
        init();
    }
    
    public void init(){
        setLayout(new MigLayout("fillx, filly","0[fill]0[]0[]2","2[fill]2"));
        JScrollPane scroll = new JScrollPane();
        scroll.setBorder(null);
        JIMSendTextPane txt = new JIMSendTextPane();
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke) {
                actualiser();
            }
        });
        txt.setHintText("Ecrire un message ...");
        scroll.setViewportView(txt);
        ScrollBar sb = new ScrollBar();
        sb.setPreferredSize(new Dimension(2, 10));
        scroll.setVerticalScrollBar(sb);
        
        add(sb);
        add(scroll, "w 100%");
        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout("filly", "0[]0", "0[bottom]0"));
        panel.setPreferredSize(new Dimension(30, 28));
        panel.setBackground(Color.WHITE);
        JButton cmd = new JButton();
        cmd.setBorder(null);
        cmd.setContentAreaFilled(false);
        cmd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmd.setIcon(new ImageIcon(getClass().getResource("/icon/send.png")));
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String text = txt.getText().trim();
                if (!text.equals("")) {
                    Model_Envoie_Message message = new Model_Envoie_Message(Service.getInstance().getUtilisateur().getIDUtilisateur(), utilisateur.getIDUtilisateur(),text);
                    envoieMessage(message);
                    PublicEvent.getInstance().getEventChat().envoyerMessage(message);
                    txt.setText("");
                    txt.grabFocus();
                    actualiser();
                } else {
                    txt.grabFocus();
                }
            }
        });
        panel.add(cmd);
        add(panel);
    }
    private void actualiser() {
        revalidate();
    }
     
    private void envoieMessage(Model_Envoie_Message data){
        Service.getInstance().getClient().emit("envoyer_a_utilisateur", data.toJsonObject());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public Model_utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Model_utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
