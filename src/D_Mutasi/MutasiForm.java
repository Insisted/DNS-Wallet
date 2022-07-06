package D_Mutasi;

import Database.Mutasi;
import Database.User;
import java.awt.Color;
import java.awt.Component;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class MutasiForm extends javax.swing.JFrame {

    private User user;
    private JFrame x;
    private Stack<User> userList;
    private int rek;
    private Queue<Mutasi> mutasi;
    private Queue<Mutasi> tempMutasi;
    private DefaultTableModel model;
    private Date awal;
    private Date batas;
    private NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

    public MutasiForm() {
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon("C:\\Users\\steve\\Documents\\NetBeansProjects\\ASD DNS\\src\\A_Opening\\Logo.png").getImage());
    }

    public MutasiForm(JFrame x, Stack<User> userList, long rek) {
        this.x = x;
        this.x.dispose();
        super.setTitle("DNS - Mutasi");
        this.userList = userList;
        this.rek = Integer.valueOf("" + rek % 100);
        this.mutasi = userList.get(this.rek).getMutasi();
        
        initComponents();
        setIconImage(new ImageIcon("C:\\Users\\steve\\Documents\\NetBeansProjects\\ASD DNS\\src\\A_Opening\\Logo.png").getImage());
                
        Object kolom[] = {"Tanggal", "Nama", "No. Rek", "Jumlah", "Berita"};
        Object data[][] = {};
        model = new DefaultTableModel(data, kolom);
        tblMutasi.setModel(model);
        tblMutasi.setFocusable(false);

        setLocationRelativeTo(null);
        txtRek.setText(userList.get(this.rek).getNoRek() + "");
        
        jam();
    }

    private void jam() {
        time.setHorizontalAlignment(JLabel.RIGHT);
        tickTock();

        Timer timers = new Timer();
        TimerTask tt = new TimerTask() {
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

    private void fillTable(String jenis) {
        tempMutasi = new LinkedList<>();
        model = (DefaultTableModel) tblMutasi.getModel();
        model.setRowCount(0);

        for (Mutasi m : mutasi) {
            if (m.getWaktu().after(awal) && m.getWaktu().before(batas) && (jenis.equals("Semua") || jenis.equals(m.getJenis()))) {
                model.addRow(new Object[]{new SimpleDateFormat("d/MM HH:mm:ss\n").format(m.getWaktu()), 
                                        m.getNamaTujuan(), m.getRekTujuan(), nf.format(m.getTotal()), m.getPesan()});

                tblMutasi.setModel(model);
                tempMutasi.add(m);
                
                tblMutasi.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
                    @Override
                    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                        final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                        c.setBackground(jenis.equals("Semua")? Color.CYAN : m.getJenis().equals("Uang Masuk")? Color.GREEN : Color.RED);
                        return c;
                    }
                });
            }
        }
    }
    
    private void sort(JLabel l, String s){
        //🢕🢗
        boolean sorting = false;
        String mark = "";
                
        if(!s.equals("🢗")){
            mark = "🢗";
            l.setVerticalAlignment(JLabel.TOP);
            sorting = true;
            
        }
        else{
            mark = "🢕";
            l.setVerticalAlignment(JLabel.BOTTOM);
        }
        
        x1.setText(x1 == l? mark:"");
        x2.setText(x2 == l? mark:"");
        x3.setText(x3 == l? mark:"");
        x4.setText(x4 == l? mark:"");
        x5.setText(x5 == l? mark:"");
        
        int size = tblMutasi.getRowCount();
        Object[][] rows = new String[size][5];
        String[] cond = new String[size];
        
        for(int i = 0; i < size; i++){
            for(int j = 0; j < 5; j++){
                rows[i][j] = tblMutasi.getValueAt(i, j).toString();
            }
            
            cond[i] = tblMutasi.getValueAt(i, Integer.valueOf(l.getName())).toString();
        }
        
        sorted(rows, cond, sorting);
    }
    
    private void sorted(Object[][] s, String[] arr, boolean sorting){
        for(int i = -1; ++i < arr.length - 1;) {                
            for(int j = -1; ++j < arr.length - 1;) {
                int a = arr[j].compareTo(arr[j+1]);
                
                if(sorting? a > 0 : a < 0) {
                    String tem = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tem;
                    
                    Object[] temp = s[j+1];
                    s[j+1] = s[j];
                    s[j] = temp;
                }
            }
        }

        Object kolom[] = {"Tanggal", "Nama", "No. Rek", "Jumlah", "Berita"};
        model = new DefaultTableModel(s, kolom);
        tblMutasi.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        tabPane = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jenisTF = new javax.swing.JComboBox<>();
        btnKonf = new javax.swing.JButton();
        txtRek = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tglAwal = new org.jdatepicker.JDatePicker();
        tglAkhir = new org.jdatepicker.JDatePicker();
        jPanel3 = new javax.swing.JPanel();
        x3 = new javax.swing.JLabel();
        x4 = new javax.swing.JLabel();
        x1 = new javax.swing.JLabel();
        x2 = new javax.swing.JLabel();
        x5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMutasi = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnIsi = new javax.swing.JButton();
        btnTF = new javax.swing.JButton();
        btnMutasi = new javax.swing.JButton();
        btnInbox = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnBackFrame = new javax.swing.JButton();
        time = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(545, 400));
        setResizable(false);

        jPanel4.setLayout(null);

        tabPane.setBackground(new java.awt.Color(221, 240, 255));
        tabPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabPaneMouseClicked(evt);
            }
        });

        jPanel2.setOpaque(false);

        jenisTF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua", "Uang Masuk", "Uang Keluar" }));

        btnKonf.setText("Next");
        btnKonf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKonfActionPerformed(evt);
            }
        });

        txtRek.setText(" ");

        jLabel1.setText("No. Rek");

        jLabel2.setText("Jenis Transaksi");

        jPanel1.setBackground(new java.awt.Color(221, 240, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("Periode Mutasi");

        jLabel4.setText("Dari Tanggal:");

        jLabel5.setText("Hingga Tanggal:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tglAkhir, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                    .addComponent(tglAwal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tglAwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tglAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jenisTF, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtRek, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(172, 172, 172)
                                .addComponent(btnKonf)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRek))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jenisTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnKonf))
        );

        tabPane.addTab("Masa", jPanel2);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(null);

        x3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        x3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        x3.setMaximumSize(new java.awt.Dimension(51, 16));
        x3.setName("2"); // NOI18N
        x3.setPreferredSize(new java.awt.Dimension(51, 16));
        x3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                x3MouseClicked(evt);
            }
        });
        jPanel3.add(x3);
        x3.setBounds(170, 10, 80, 20);

        x4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        x4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        x4.setMinimumSize(new java.awt.Dimension(51, 16));
        x4.setName("3"); // NOI18N
        x4.setPreferredSize(new java.awt.Dimension(51, 16));
        x4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                x4MouseClicked(evt);
            }
        });
        jPanel3.add(x4);
        x4.setBounds(250, 10, 80, 20);

        x1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        x1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        x1.setMinimumSize(new java.awt.Dimension(51, 16));
        x1.setName("0"); // NOI18N
        x1.setPreferredSize(new java.awt.Dimension(51, 16));
        x1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                x1MouseClicked(evt);
            }
        });
        jPanel3.add(x1);
        x1.setBounds(10, 10, 80, 20);

        x2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        x2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        x2.setMinimumSize(new java.awt.Dimension(51, 16));
        x2.setName("1"); // NOI18N
        x2.setPreferredSize(new java.awt.Dimension(51, 16));
        x2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                x2MouseClicked(evt);
            }
        });
        jPanel3.add(x2);
        x2.setBounds(90, 10, 80, 20);

        x5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        x5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        x5.setMinimumSize(new java.awt.Dimension(51, 16));
        x5.setName("4"); // NOI18N
        x5.setPreferredSize(new java.awt.Dimension(51, 16));
        x5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                x5MouseClicked(evt);
            }
        });
        jPanel3.add(x5);
        x5.setBounds(330, 10, 80, 20);

        tblMutasi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblMutasi.setFocusable(false);
        tblMutasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMutasiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblMutasi);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(6, 7, 410, 290);

        tabPane.addTab("Daftar", jPanel3);

        jPanel4.add(tabPane);
        tabPane.setBounds(110, 0, 420, 330);

        jPanel5.setBackground(new java.awt.Color(64, 176, 145));
        jPanel5.setPreferredSize(new java.awt.Dimension(110, 460));
        jPanel5.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(64, 176, 145));
        jPanel6.setLayout(new java.awt.GridLayout(4, 1, 0, 20));

        btnIsi.setBackground(new java.awt.Color(102, 255, 204));
        btnIsi.setText("Top Up");
        btnIsi.setEnabled(false);
        btnIsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIsiActionPerformed(evt);
            }
        });
        jPanel6.add(btnIsi);

        btnTF.setBackground(new java.awt.Color(102, 255, 204));
        btnTF.setText("Transfer");
        btnTF.setEnabled(false);
        btnTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTFActionPerformed(evt);
            }
        });
        jPanel6.add(btnTF);

        btnMutasi.setBackground(new java.awt.Color(102, 255, 204));
        btnMutasi.setText("Mutasi");
        btnMutasi.setEnabled(false);
        btnMutasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMutasiActionPerformed(evt);
            }
        });
        jPanel6.add(btnMutasi);

        btnInbox.setBackground(new java.awt.Color(102, 255, 204));
        btnInbox.setText("Ganti PIN");
        btnInbox.setEnabled(false);
        btnInbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInboxActionPerformed(evt);
            }
        });
        jPanel6.add(btnInbox);

        jPanel5.add(jPanel6);
        jPanel6.setBounds(10, 150, 90, 170);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/A_Opening/Logo.png"))); // NOI18N
        jPanel5.add(jLabel7);
        jLabel7.setBounds(6, 70, 100, 60);

        btnBackFrame.setBackground(new java.awt.Color(221, 240, 255));
        btnBackFrame.setText("❮");
        btnBackFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackFrameActionPerformed(evt);
            }
        });
        jPanel5.add(btnBackFrame);
        btnBackFrame.setBounds(10, 20, 90, 22);

        jPanel4.add(jPanel5);
        jPanel5.setBounds(0, 0, 110, 360);

        time.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        time.setText("jLabel6");
        jPanel4.add(time);
        time.setBounds(350, 340, 170, 16);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/A_Opening/Asd kel (7).png"))); // NOI18N
        jPanel4.add(jLabel8);
        jLabel8.setBounds(110, 0, 420, 360);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKonfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKonfActionPerformed
        awal = new Date(1990, 1, 1);
        batas = new Date();

        try{
            Date times = ((Calendar) tglAwal.getModel().getValue()).getTime();
            awal = new Date(times.getYear(), times.getMonth(), times.getDate());
            batas = ((Calendar) tglAkhir.getModel().getValue()).getTime();
        }
        catch(java.lang.NullPointerException E){
            JOptionPane.showMessageDialog(this, "Harap Memiliih Tanggal yang Valid");
        }

        long masa = (batas.getTime() - awal.getTime()) / (1000 * 60 * 60 * 24);
        long batasMasa = (new Date().getTime() - awal.getTime()) / (1000 * 60 * 60 * 24);
        
        if(batas.after(new Date()))
            JOptionPane.showMessageDialog(this, "Tanggal Akhir Lebih Besar dari Tanggal Hari Ini");
        else if(batas.before(awal))
            JOptionPane.showMessageDialog(this, "Tanggal Awal Lebih Besar dari Tanggal Akhir");
        else if(batasMasa > 31)
            JOptionPane.showMessageDialog(this, "Mutasi Rekening Maksimal 31 Hari yang Lalu");
        else if(masa > 7 || masa < 0)
            JOptionPane.showMessageDialog(this, "Periode Mutasi yang Dapat Dipilih 7 Hari");
        else {
            fillTable(jenisTF.getSelectedItem() + "");
            tabPane.setSelectedIndex(1);
        }
    }//GEN-LAST:event_btnKonfActionPerformed

    private void tblMutasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMutasiMouseClicked
        int index = tblMutasi.getSelectedRow();
        Mutasi m = null;

        for (Mutasi mut : mutasi) {
            boolean cekRek = tblMutasi.getValueAt(index, 2).toString().equals(mut.getRekTujuan() + "");
            boolean cekTgl = tblMutasi.getValueAt(index, 0).toString().equals(new SimpleDateFormat("d/MM HH:mm:ss\n").format(mut.getWaktu()) + "");
            if (cekRek && cekTgl) {
                m = mut;
                break;
            }
        }
        
        String pesan = "Transfer " + m.getJenis().split(" ")[1] + " Berhasil\n" + new SimpleDateFormat("d/MM HH:mm:ss\n").format(m.getWaktu()) + "\n"
                + m.getRekTujuan() + "\n" + m.getNamaTujuan() + "\n" + nf.format(m.getTotal()) + "\n\nBerita:\n" + m.getPesan();

        JOptionPane.showMessageDialog(this, pesan, "m-Transfer", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_tblMutasiMouseClicked

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

    private void tabPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPaneMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabPaneMouseClicked

    private void x1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_x1MouseClicked
        sort(x1, x1.getText());
    }//GEN-LAST:event_x1MouseClicked

    private void x2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_x2MouseClicked
        sort(x2, x2.getText());
    }//GEN-LAST:event_x2MouseClicked

    private void x3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_x3MouseClicked
        sort(x3, x3.getText());
    }//GEN-LAST:event_x3MouseClicked

    private void x4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_x4MouseClicked
        sort(x4, x4.getText());
    }//GEN-LAST:event_x4MouseClicked

    private void x5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_x5MouseClicked
        sort(x5, x5.getText());
    }//GEN-LAST:event_x5MouseClicked

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
            java.util.logging.Logger.getLogger(MutasiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MutasiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MutasiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MutasiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MutasiForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackFrame;
    private javax.swing.JButton btnInbox;
    private javax.swing.JButton btnIsi;
    private javax.swing.JButton btnKonf;
    private javax.swing.JButton btnMutasi;
    private javax.swing.JButton btnTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jenisTF;
    private javax.swing.JTabbedPane tabPane;
    private javax.swing.JTable tblMutasi;
    private org.jdatepicker.JDatePicker tglAkhir;
    private org.jdatepicker.JDatePicker tglAwal;
    private javax.swing.JLabel time;
    private javax.swing.JLabel txtRek;
    private javax.swing.JLabel x1;
    private javax.swing.JLabel x2;
    private javax.swing.JLabel x3;
    private javax.swing.JLabel x4;
    private javax.swing.JLabel x5;
    // End of variables declaration//GEN-END:variables
}
