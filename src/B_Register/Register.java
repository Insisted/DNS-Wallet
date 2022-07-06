package B_Register;

import Database.User;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;
import javax.swing.DefaultListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Register extends javax.swing.JFrame {
    //SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy");
    //SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
    //Calendar currentCalendar = Calendar.getInstance();
    //Date currentTime = currentCalendar.getTime();
    //date.setText(dateFormat.format(currentTime));
    private DefaultListSelectionModel model;
    private int batas = new Date().getYear();
    private final Pattern cekNama = Pattern.compile("^[a-zA-Z\\s]+$");
    private Stack<String> PIN = new Stack<>();
    private boolean visibleAST = true;
    private int umur;
    private Stack<User> userList;
    private JFrame x;
    
    public Register() {        
        initialize();
    }
    
    public Register(JFrame x, Stack<User> userList){
        this.userList = userList;
        this.x = x;
        
        this.x.dispose();
        initialize();
    }
    
    private void initialize() {
        super.setTitle("Registrasi Akun");
        super.setBounds(370, 150, 683, 384);
        
        initComponents();
        setIconImage(new ImageIcon("C:\\Users\\steve\\Documents\\NetBeansProjects\\ASD DNS\\src\\A_Opening\\Logo.png").getImage());
        boxNama.setToolTipText("Huruf Abjad");
        boxIbu.setToolTipText("Huruf Abjad");
        
        cmbRek.setSelectedIndex(-1);
        cmbRek.setEnabled(false);
        infoUmur.setText("❗ Harus berumur 5 - " + batas + " tahun");
        
        setLocationRelativeTo(null);
        
        jam();
    }
    
    private void calcUmur(Date bDay) {
        Date date = new Date();
        int cDate = date.getDate(), cMonth = date.getMonth(), cYear = date.getYear();
        int bDate = bDay.getDate(), bMonth = bDay.getMonth(), bYear = bDay.getYear();
                
        this.umur = cYear - bYear - (cDate >= bDate && cMonth >= bMonth? 0:1);
    }
    
    private void jam(){
        time.setHorizontalAlignment(JLabel.RIGHT);
        //time.setFont(UIManager.getFont("Label.font").deriveFont(Font.BOLD, 14f));
        tickTock();
        
        /*
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tickTock();
            }
        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.setInitialDelay(0);
        timer.start();*/
        
        
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
        //time.setText(DateFormat.getDateTimeInstance().format(new Date()));
    }
    
    private Stack<String> verify(){
        Date bDay = new Date();
        int jenisRek = cmbRek.getSelectedIndex();
        
        Stack<String> message = new Stack<>();
        
        try{
            bDay = ((Calendar) kalender.getModel().getValue()).getTime();
            calcUmur(bDay);
        }
        catch(java.lang.NullPointerException E){
            message.add("Harap Memilih Tanggal Lahir");
        }
        
        
        if(!cekNama.matcher(boxNama.getText()).find() || !cekNama.matcher(boxIbu.getText()).find())
            message.add("Nama hanya berupa huruf");
        if(comboGender.getSelectedIndex() == 0)
            message.add("Tentukan jenis kelamin anda");
        if(this.umur < 5 || this.umur > batas)
            message.add("Minimal berumur 5 tahun dan maksimal " + batas + " tahun");
        if((this.umur <= 15 && jenisRek == 1 || this.umur > 15 && jenisRek == 0 || jenisRek == -1) && cmbRek.isEnabled())
            message.add("Jenis rekening tidak sesuai");
        
        
        message.add(message.isEmpty()? null:"Y");
        
        return message;
    }
    
    private String ast(){
        if(visibleAST)
            return String.join("", PIN);
        return "*".repeat(PIN.size());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        tabPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        labelNama = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelGender = new javax.swing.JLabel();
        boxIbu = new javax.swing.JTextField();
        labelJenis = new javax.swing.JLabel();
        boxNama = new javax.swing.JTextField();
        btnNext = new javax.swing.JButton();
        comboGender = new javax.swing.JComboBox<>();
        cmbRek = new javax.swing.JComboBox<>();
        kalender = new org.jdatepicker.JDatePicker();
        jLabel1 = new javax.swing.JLabel();
        infoUmur = new javax.swing.JLabel();
        btnBackFrame = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnClear = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btnEnter = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        txtAngka = new javax.swing.JTextField();
        btn9 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btn0 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btnBackspace = new javax.swing.JButton();
        PINVisibility = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        time = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(435, 400));
        setPreferredSize(new java.awt.Dimension(435, 400));
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        jPanel3.setLayout(null);

        tabPane.setBackground(new java.awt.Color(221, 240, 255));
        tabPane.setForeground(new java.awt.Color(153, 153, 153));
        tabPane.setEnabled(false);

        jPanel1.setOpaque(false);

        labelNama.setText("Nama");

        jLabel2.setText("Nama Ibu");

        labelGender.setText("Gender");

        boxIbu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxIbuActionPerformed(evt);
            }
        });

        labelJenis.setText("Jenis Rekening");

        boxNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxNamaActionPerformed(evt);
            }
        });

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        comboGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Pria", "Wanita" }));
        comboGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboGenderActionPerformed(evt);
            }
        });

        cmbRek.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kreatif (5 - 15)", "Dewasa (16 - 122)" }));
        cmbRek.setMinimumSize(new java.awt.Dimension(206, 22));
        cmbRek.setPreferredSize(new java.awt.Dimension(206, 22));
        cmbRek.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cmbRekMousePressed(evt);
            }
        });
        cmbRek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRekActionPerformed(evt);
            }
        });

        kalender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kalenderActionPerformed(evt);
            }
        });

        jLabel1.setText("Tanggal Lahir");

        infoUmur.setBackground(new java.awt.Color(255, 0, 51));
        infoUmur.setForeground(new java.awt.Color(255, 0, 51));

        btnBackFrame.setBackground(new java.awt.Color(221, 240, 255));
        btnBackFrame.setText("❮");
        btnBackFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackFrameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(67, 67, 67)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(labelJenis)
                                .addComponent(labelGender)
                                .addComponent(labelNama)
                                .addComponent(jLabel2))
                            .addGap(27, 27, 27)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(infoUmur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(kalender, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNext, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmbRek, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnBackFrame)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(boxNama)
                                .addComponent(comboGender, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(boxIbu, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBackFrame)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNama))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelGender))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxIbu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kalender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbRek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelJenis))
                .addGap(4, 4, 4)
                .addComponent(infoUmur, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNext)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        tabPane.addTab("Pribadi", jPanel1);

        jPanel2.setOpaque(false);

        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btn3.setText("3");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btnEnter.setText("ENTER");
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });

        btn4.setText("4");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btn1.setText("1");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn5.setText("5");
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btn6.setText("6");
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        btn7.setText("7");
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });

        btn8.setText("8");
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });

        txtAngka.setEditable(false);
        txtAngka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAngkaActionPerformed(evt);
            }
        });

        btn9.setText("9");
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });

        jLabel5.setText("Masukkan PIN");

        btn0.setText("0");
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });

        btn2.setText("2");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btnBackspace.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnBackspace.setText("BACKSPACE");
        btnBackspace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackspaceActionPerformed(evt);
            }
        });

        PINVisibility.setText("👁");
        PINVisibility.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PINVisibilityActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(221, 240, 255));
        btnBack.setText("❮");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBackspace, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtAngka, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PINVisibility, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAngka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PINVisibility, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBackspace, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        tabPane.addTab("Akun", jPanel2);

        jPanel3.add(tabPane);
        tabPane.setBounds(0, 0, 420, 330);

        time.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel3.add(time);
        time.setBounds(260, 340, 150, 16);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/A_Opening/Asd kel (7).png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(0, 0, 420, 360);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boxNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxNamaActionPerformed
        
    }//GEN-LAST:event_boxNamaActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        Stack<String> cek = verify();
        
        if(cek.pop() != null)
            JOptionPane.showMessageDialog(this, String.join("\n", cek), "Warning", 2);
        else
            tabPane.setSelectedIndex(1);
    }//GEN-LAST:event_btnNextActionPerformed

    private void kalenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kalenderActionPerformed
        model = new DefaultListSelectionModel();
        Calendar date = (Calendar) kalender.getModel().getValue();
        Date bDay = date.getTime();
        calcUmur(bDay);
        
        if(umur > 15 && umur <= batas)
            model.addSelectionInterval(0, 0);
        else if(umur >= 5 && umur <= 15)
            model.addSelectionInterval(1, 1);
                
        cmbRek.setEnabled(umur >= 5 && umur <= 122);
        infoUmur.setVisible(!cmbRek.isEnabled());
        cmbRek.setRenderer(new JComboBoxItem(model));
    }//GEN-LAST:event_kalenderActionPerformed

    private void cmbRekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRekActionPerformed
       
    }//GEN-LAST:event_cmbRekActionPerformed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        
    }//GEN-LAST:event_formKeyTyped

    private void comboGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboGenderActionPerformed

    private void boxIbuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxIbuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxIbuActionPerformed

    private void cmbRekMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbRekMousePressed
       
    }//GEN-LAST:event_cmbRekMousePressed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        PIN.clear();
        txtAngka.setText(String.join("", PIN));
    }//GEN-LAST:event_btnClearActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        // TODO add your handling code here:
        PIN.push(btn3.getText());

        txtAngka.setText(ast());
    }//GEN-LAST:event_btn3ActionPerformed

    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
        if(PIN.size() != 6){
            JOptionPane.showMessageDialog(this, "Panjang PIN harus 6 digit", "Warning", 2);
        }
        else{
            long rek = 123400000000L + userList.size();
            JOptionPane.showMessageDialog(this, "Akun Berhasil dibuat!\nNo. Rek anda adalah " + rek, "Confirm", 1);
            userList.add(new User(rek, boxNama.getText().trim(), boxIbu.getText().trim(), comboGender.getSelectedIndex(), this.umur, cmbRek.getSelectedIndex(), String.join("", PIN)));
            new A_Opening.Opening(this, userList).setVisible(true);
        }
    }//GEN-LAST:event_btnEnterActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        // TODO add your handling code here:
        PIN.push(btn4.getText());

        txtAngka.setText(ast());
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
        PIN.push(btn1.getText());

        txtAngka.setText(ast());
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        // TODO add your handling code here:
        PIN.push(btn5.getText());

        txtAngka.setText(ast());
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        // TODO add your handling code here:
        PIN.push(btn6.getText());

        txtAngka.setText(ast());
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        // TODO add your handling code here
        PIN.push(btn7.getText());

        txtAngka.setText(ast());
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        // TODO add your handling code here:
        PIN.push(btn8.getText());

        txtAngka.setText(ast());
    }//GEN-LAST:event_btn8ActionPerformed

    private void txtAngkaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAngkaActionPerformed

    }//GEN-LAST:event_txtAngkaActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        // TODO add your handling code here:
        PIN.push(btn9.getText());

        txtAngka.setText(ast());
    }//GEN-LAST:event_btn9ActionPerformed

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
        // TODO add your handling code here:
        PIN.push(btn0.getText());

        txtAngka.setText(ast());
    }//GEN-LAST:event_btn0ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        // TODO add your handling code here:
        PIN.push(btn2.getText());

        txtAngka.setText(ast());
    }//GEN-LAST:event_btn2ActionPerformed

    private void btnBackspaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackspaceActionPerformed
        PIN.pop();
        txtAngka.setText(ast());
    }//GEN-LAST:event_btnBackspaceActionPerformed

    private void PINVisibilityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PINVisibilityActionPerformed
        visibleAST = !visibleAST;
        txtAngka.setText(ast());
    }//GEN-LAST:event_PINVisibilityActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        tabPane.setSelectedIndex(0);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnBackFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackFrameActionPerformed
        this.x.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackFrameActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Register().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PINVisibility;
    private javax.swing.JTextField boxIbu;
    private javax.swing.JTextField boxNama;
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
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBackFrame;
    private javax.swing.JButton btnBackspace;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnEnter;
    private javax.swing.JButton btnNext;
    private javax.swing.JComboBox<String> cmbRek;
    private javax.swing.JComboBox<String> comboGender;
    private javax.swing.JLabel infoUmur;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private org.jdatepicker.JDatePicker kalender;
    private javax.swing.JLabel labelGender;
    private javax.swing.JLabel labelJenis;
    private javax.swing.JLabel labelNama;
    private javax.swing.JTabbedPane tabPane;
    private javax.swing.JLabel time;
    private javax.swing.JTextField txtAngka;
    // End of variables declaration//GEN-END:variables
}
