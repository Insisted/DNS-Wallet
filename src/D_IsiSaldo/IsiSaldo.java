package D_IsiSaldo;

import Database.User;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class IsiSaldo extends javax.swing.JFrame {
    private JFrame x;
    private Stack<String> PIN = new Stack<>();
    private boolean visibleAST = true;
    private Stack<User> userList;
    private int rek;
    
    public IsiSaldo() {
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon("C:\\Users\\steve\\Documents\\NetBeansProjects\\ASD DNS\\src\\A_Opening\\Logo.png").getImage());
    }
    
    public IsiSaldo(JFrame x, Stack<User> userList, long rek){
        this.x = x;
        this.x.dispose();
        super.setTitle("DNS - Top Up");
        this.rek = Integer.valueOf(rek%100 + "");
        this.userList = userList;
        
        initComponents();
        setIconImage(new ImageIcon("C:\\Users\\steve\\Documents\\NetBeansProjects\\ASD DNS\\src\\A_Opening\\Logo.png").getImage());
        setLocationRelativeTo(null);
        
        jam();
    }
    
    private void jam(){
        time.setHorizontalAlignment(JLabel.RIGHT);
        tickTock();
        
        Timer timers = new Timer();
        TimerTask tt = new TimerTask(){
            @Override
            public void run() {
                tickTock();
            }
        };
        timers.scheduleAtFixedRate(tt, 1, 1000);
    }
    private void tickTock() {
        time.setText(new SimpleDateFormat("E, d MMM y, HH:mm:ss ").format(new Date()));
    }
    
    private String ast(){
        if(visibleAST)
            return String.join("", PIN);
        return "*".repeat(PIN.size());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        time = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnIsi = new javax.swing.JButton();
        btnTF = new javax.swing.JButton();
        btnMutasi = new javax.swing.JButton();
        btnInbox = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnBackFrame = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        txtAngka = new javax.swing.JTextField();
        btn0 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnBackspace = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        PINVisibility = new javax.swing.JButton();
        btnEnter = new javax.swing.JButton();
        txtSaldo = new javax.swing.JTextField();
        btn1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lupaPIN = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(435, 400));
        setResizable(false);

        jPanel1.setLayout(null);

        time.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        time.setText("jLabel3");
        jPanel1.add(time);
        time.setBounds(255, 340, 158, 16);

        jPanel3.setBackground(new java.awt.Color(64, 176, 145));
        jPanel3.setPreferredSize(new java.awt.Dimension(110, 460));
        jPanel3.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(64, 176, 145));
        jPanel4.setLayout(new java.awt.GridLayout(4, 1, 0, 20));

        btnIsi.setBackground(new java.awt.Color(102, 255, 204));
        btnIsi.setText("Top Up");
        btnIsi.setEnabled(false);
        btnIsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIsiActionPerformed(evt);
            }
        });
        jPanel4.add(btnIsi);

        btnTF.setBackground(new java.awt.Color(102, 255, 204));
        btnTF.setText("Transfer");
        btnTF.setEnabled(false);
        btnTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTFActionPerformed(evt);
            }
        });
        jPanel4.add(btnTF);

        btnMutasi.setBackground(new java.awt.Color(102, 255, 204));
        btnMutasi.setText("Mutasi");
        btnMutasi.setEnabled(false);
        btnMutasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMutasiActionPerformed(evt);
            }
        });
        jPanel4.add(btnMutasi);

        btnInbox.setBackground(new java.awt.Color(102, 255, 204));
        btnInbox.setText("Ganti PIN");
        btnInbox.setEnabled(false);
        btnInbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInboxActionPerformed(evt);
            }
        });
        jPanel4.add(btnInbox);

        jPanel3.add(jPanel4);
        jPanel4.setBounds(10, 150, 90, 170);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/A_Opening/Logo.png"))); // NOI18N
        jPanel3.add(jLabel7);
        jLabel7.setBounds(6, 70, 100, 60);

        btnBackFrame.setBackground(new java.awt.Color(221, 240, 255));
        btnBackFrame.setText("???");
        btnBackFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackFrameActionPerformed(evt);
            }
        });
        jPanel3.add(btnBackFrame);
        btnBackFrame.setBounds(10, 20, 90, 22);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 0, 110, 360);

        btn3.setText("3");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        jPanel1.add(btn3);
        btn3.setBounds(234, 160, 43, 36);

        btn4.setText("4");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        jPanel1.add(btn4);
        btn4.setBounds(134, 210, 43, 36);

        btn5.setText("5");
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        jPanel1.add(btn5);
        btn5.setBounds(184, 210, 43, 36);

        btn6.setText("6");
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        jPanel1.add(btn6);
        btn6.setBounds(234, 210, 43, 36);

        btn7.setText("7");
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        jPanel1.add(btn7);
        btn7.setBounds(134, 260, 43, 36);

        btn8.setText("8");
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        jPanel1.add(btn8);
        btn8.setBounds(184, 260, 43, 36);

        btn9.setText("9");
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });
        jPanel1.add(btn9);
        btn9.setBounds(234, 260, 43, 36);

        txtAngka.setEditable(false);
        txtAngka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAngkaActionPerformed(evt);
            }
        });
        jPanel1.add(txtAngka);
        txtAngka.setBounds(130, 122, 218, 30);

        btn0.setText("0");
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });
        jPanel1.add(btn0);
        btn0.setBounds(184, 310, 43, 36);

        jLabel2.setText("Masukkan PIN");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(130, 100, 130, 16);

        btnBackspace.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnBackspace.setText("BACKSPACE");
        btnBackspace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackspaceActionPerformed(evt);
            }
        });
        jPanel1.add(btnBackspace);
        btnBackspace.setBounds(294, 162, 96, 31);

        btn2.setText("2");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        jPanel1.add(btn2);
        btn2.setBounds(184, 160, 43, 36);

        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel1.add(btnClear);
        btnClear.setBounds(294, 212, 96, 31);

        PINVisibility.setText("????");
        PINVisibility.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PINVisibilityActionPerformed(evt);
            }
        });
        jPanel1.add(PINVisibility);
        PINVisibility.setBounds(350, 122, 46, 30);

        btnEnter.setText("ENTER");
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });
        jPanel1.add(btnEnter);
        btnEnter.setBounds(294, 262, 96, 31);

        txtSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoActionPerformed(evt);
            }
        });
        jPanel1.add(txtSaldo);
        txtSaldo.setBounds(130, 50, 270, 30);

        btn1.setText("1");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn1);
        btn1.setBounds(134, 160, 43, 36);

        jLabel1.setText("Jumlah Pengisian Saldo (Min: Rp. 10.000)");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(130, 30, 270, 16);

        lupaPIN.setForeground(new java.awt.Color(0, 204, 255));
        lupaPIN.setText("Lupa PIN?");
        lupaPIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lupaPINFocusGained(evt);
            }
        });
        lupaPIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lupaPINMouseClicked(evt);
            }
        });
        jPanel1.add(lupaPIN);
        lupaPIN.setBounds(340, 100, 70, 16);

        jLabel4.setForeground(new java.awt.Color(51, 255, 255));
        jLabel4.setText("________");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(340, 100, 70, 16);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/A_Opening/Asd kel (7).png"))); // NOI18N
        jPanel1.add(jLabel8);
        jLabel8.setBounds(0, 0, 420, 360);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAngkaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAngkaActionPerformed

    }//GEN-LAST:event_txtAngkaActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        PIN.push(btn2.getText());

        txtAngka.setText(ast());
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        PIN.push(btn3.getText());

        txtAngka.setText(ast());
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        PIN.push(btn4.getText());

        txtAngka.setText(ast());
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        PIN.push(btn5.getText());

        txtAngka.setText(ast());
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        PIN.push(btn6.getText());

        txtAngka.setText(ast());
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        PIN.push(btn7.getText());

        txtAngka.setText(ast());
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        PIN.push(btn8.getText());

        txtAngka.setText(ast());
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        PIN.push(btn9.getText());

        txtAngka.setText(ast());
    }//GEN-LAST:event_btn9ActionPerformed

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
        PIN.push(btn0.getText());

        txtAngka.setText(ast());
    }//GEN-LAST:event_btn0ActionPerformed

    private void btnBackspaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackspaceActionPerformed
        PIN.pop();
        
        txtAngka.setText(ast());
    }//GEN-LAST:event_btnBackspaceActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        PIN.clear();
        
        txtAngka.setText(ast());
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
        String text = txtSaldo.getText().trim();
        double saldo = Pattern.compile("^(\\d*\\.)?\\d+$").matcher(text).find()? Double.parseDouble(text):-1;

        if(saldo < 10000)
            JOptionPane.showMessageDialog(this, "Pengisian Saldo Harus Lebih Besar dari Rp. 10.000", "Warning", 1, null);
        else{
            if(userList.get(this.rek).cekPIN(String.join("", PIN))){
                JOptionPane.showMessageDialog(this, "Top Up Berhasil", "Berhasil", 1, null);
                userList.get(this.rek).addSaldo(saldo);
                
                this.dispose();
                this.x.setVisible(true);
            }
            else
                JOptionPane.showMessageDialog(this, "PIN yang anda masukkan salah", "Warning", 2, null);
        }
    }//GEN-LAST:event_btnEnterActionPerformed

    private void txtSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoActionPerformed
        
    }//GEN-LAST:event_txtSaldoActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        PIN.push(btn1.getText());

        txtAngka.setText(ast());
    }//GEN-LAST:event_btn1ActionPerformed

    private void lupaPINFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lupaPINFocusGained

    }//GEN-LAST:event_lupaPINFocusGained

    private void lupaPINMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lupaPINMouseClicked
        new X_GantiPIN.GantiPIN(this, userList, userList.get(rek).getNoRek()).setVisible(true);
    }//GEN-LAST:event_lupaPINMouseClicked

    private void PINVisibilityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PINVisibilityActionPerformed
        visibleAST = !visibleAST;
        txtAngka.setText(ast());
    }//GEN-LAST:event_PINVisibilityActionPerformed

    private void btnIsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIsiActionPerformed
        new D_IsiSaldo.IsiSaldo(this, userList, userList.get(this.rek).getNoRek()).setVisible(true);
    }//GEN-LAST:event_btnIsiActionPerformed

    private void btnTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTFActionPerformed
        new D_Transfer.Transfer(this, userList, this.rek).setVisible(true);
    }//GEN-LAST:event_btnTFActionPerformed

    private void btnMutasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMutasiActionPerformed
        new D_Mutasi.MutasiForm(this, userList, userList.get(rek).getNoRek()).setVisible(true);
    }//GEN-LAST:event_btnMutasiActionPerformed

    private void btnBackFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackFrameActionPerformed
        this.x.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackFrameActionPerformed

    private void btnInboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInboxActionPerformed
        new X_GantiPIN.GantiPIN(this, userList, userList.get(this.rek).getNoRek()).setVisible(true);
    }//GEN-LAST:event_btnInboxActionPerformed

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
            java.util.logging.Logger.getLogger(IsiSaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IsiSaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IsiSaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IsiSaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IsiSaldo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PINVisibility;
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnBackFrame;
    private javax.swing.JButton btnBackspace;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnEnter;
    private javax.swing.JButton btnInbox;
    private javax.swing.JButton btnIsi;
    private javax.swing.JButton btnMutasi;
    private javax.swing.JButton btnTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lupaPIN;
    private javax.swing.JLabel time;
    private javax.swing.JTextField txtAngka;
    private javax.swing.JTextField txtSaldo;
    // End of variables declaration//GEN-END:variables
}
