/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Axel
 */
public class TetrisMainMenu extends javax.swing.JFrame {

    /**
     * Creates new form TetrisMainMenu
     */
    public TetrisMainMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        soloButton = new javax.swing.JButton();
        offlineButton = new javax.swing.JButton();
        onlineButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tetris");
        setMaximumSize(new java.awt.Dimension(590, 215));
        setMinimumSize(new java.awt.Dimension(590, 215));
        setPreferredSize(new java.awt.Dimension(530, 215));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tetris");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 6, 565, 27);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Choose your game mode :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 51, 565, 17);

        soloButton.setText("Solo");
        soloButton.setMaximumSize(new java.awt.Dimension(55, 25));
        soloButton.setMinimumSize(new java.awt.Dimension(55, 25));
        soloButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                soloButtonMouseClicked(evt);
            }
        });
        soloButton.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                soloButtonComponentShown(evt);
            }
        });
        getContentPane().add(soloButton);
        soloButton.setBounds(240, 80, 110, 23);

        offlineButton.setText("VS Offline");
        offlineButton.setMaximumSize(new java.awt.Dimension(55, 25));
        offlineButton.setMinimumSize(new java.awt.Dimension(55, 25));
        offlineButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                offlineButtonMouseClicked(evt);
            }
        });
        getContentPane().add(offlineButton);
        offlineButton.setBounds(240, 120, 110, 23);

        onlineButton.setText("VS Online");
        onlineButton.setMaximumSize(new java.awt.Dimension(55, 25));
        onlineButton.setMinimumSize(new java.awt.Dimension(55, 25));
        onlineButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onlineButtonMouseClicked(evt);
            }
        });
        getContentPane().add(onlineButton);
        onlineButton.setBounds(240, 160, 110, 23);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Tetris-Cover-600x300.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 590, 200);

        pack();
    }// </editor-fold>                        

    private void soloButtonComponentShown(java.awt.event.ComponentEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void soloButtonMouseClicked(java.awt.event.MouseEvent evt) {                                        
        new SoloFrame();
        this.setVisible(false);
    }                                       

    private void offlineButtonMouseClicked(java.awt.event.MouseEvent evt) {                                           
        new MultiLocalFrame();
        this.setVisible(false);
    }                                          

    private void onlineButtonMouseClicked(java.awt.event.MouseEvent evt) {                                          
        new MultiOnlineFrame();
        this.setVisible(false);
    }                                         

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
            java.util.logging.Logger.getLogger(TetrisMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TetrisMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TetrisMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TetrisMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TetrisMainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton offlineButton;
    private javax.swing.JButton onlineButton;
    private javax.swing.JButton soloButton;
    // End of variables declaration                   
}
