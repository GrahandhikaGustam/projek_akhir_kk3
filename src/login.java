import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class login extends javax.swing.JFrame {
    
        Connection conn =null;
        Statement st = null;
    /**
     * Creates new form login
     */
    public login(java.awt.Frame parent, boolean modal) {
        initComponents();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
                conn=DriverManager.getConnection("jdbc:mysql://localhost/apotek","root","");
                st=conn.createStatement();
            JOptionPane.showMessageDialog(null, "Berhasil Terkoneksi");
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Gagal Terkoneksi Karena " + ex);
        }
    }


    private void CekLogin(){
    try{
        if(txtusername.getText().equals("") || txtpassword.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Data Tidak Boleh Kosong", "Pesan", JOptionPane.ERROR_MESSAGE);
            txtusername.requestFocus();
            HapusLayar();
        }else{
        st = conn.createStatement();
        String sql = ("SELECT * FROM tblogin WHERE username ='"+txtusername.getText()+"' AND password ='"+String.valueOf(txtpassword.getText())+"'");
        ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
            this.dispose();
            new Obat().setVisible(true);
        }else{
            JOptionPane.showMessageDialog(rootPane, "UserName dan Password Salah\nAtau Akun Belum Terdaftar", "Pesan",
            JOptionPane.ERROR_MESSAGE);
        
            HapusLayar();
        } 
        }
        }catch(Exception e){
        e.printStackTrace();

}
    }
    
    private void HapusLayar(){
txtusername.setText("");
txtpassword.setText("");
txtusername.setEnabled(true);
txtpassword.setEnabled(true);
    
}
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        txtpassword = new javax.swing.JTextField();
        btnlogin = new javax.swing.JButton();
        btnregister = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel1.setText("APOTEK HUSADA PRIMA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 22, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Username");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 148, 70, -1));
        getContentPane().add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 117, 226, -1));
        getContentPane().add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 148, 226, -1));

        btnlogin.setBackground(new java.awt.Color(255, 255, 255));
        btnlogin.setText("Login");
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });
        getContentPane().add(btnlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 215, -1, -1));

        btnregister.setBackground(new java.awt.Color(255, 255, 255));
        btnregister.setText("Register");
        btnregister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregisterActionPerformed(evt);
            }
        });
        getContentPane().add(btnregister, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 215, -1, -1));

        jLabel4.setFont(new java.awt.Font("Georgia", 1, 16)); // NOI18N
        jLabel4.setText("Login");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 50, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\Documents\\1x\\Pengertian-Apotek-Adalah-Arti-Pengelolaan-Tugas-dan-Fungsi-serta-Syarat-Pendirian-500x320.jpg")); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnregisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregisterActionPerformed
        this.setVisible(false);
        new register(null, true).setVisible(true);
    }//GEN-LAST:event_btnregisterActionPerformed

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
        CekLogin();
    }//GEN-LAST:event_btnloginActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
       login dialog = new login(new javax.swing.JFrame(),
    true);
                dialog.addWindowListener(new
    java.awt.event.WindowAdapter() {
                    @Override
                    public void
    windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                   }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlogin;
    private javax.swing.JButton btnregister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
