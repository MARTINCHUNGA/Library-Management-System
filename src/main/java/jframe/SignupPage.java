/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class SignupPage extends javax.swing.JFrame {

    /**
     * Creates new form SignupPage
     */
    public SignupPage() {
        initComponents();
    }
    
    //method to insert details in the database
    public void insertSignupDetails(){
     //Get values  from textfields
     String name = text_username.getText();
     String password = text_password.getText();
     String email = text_email.getText();
     String phoneNumber = text_phone_number.getText();
     
     try{
            Connection con = DBConnection.getConnection();
            String sql = "insert into users(name,password,email,phoneNumber) values(?,?,?,?)";
            PreparedStatement pot = con.prepareStatement(sql);
            
            pot.setString(1, name);
            pot.setString(2, password);
            pot.setString(3, email);
            pot.setString(4,  phoneNumber);
            
            
            int updatedRowCount = pot.executeUpdate();
            
            
            if(updatedRowCount > 0){
             JOptionPane.showMessageDialog(this, "User details updated successfuly");
             LogIn login = new LogIn();
             login.setVisible(true);
             dispose();
            } else {
              JOptionPane.showMessageDialog(this, "Something went wrong...");
            }
            
     }catch(Exception e){
        e.printStackTrace();
     }
    }
    
    //Provide the validation method
    public boolean validateUserDetails(){
      String name = text_username.getText();
      String password = text_password.getText();
      String email = text_email.getText();
      String phoneNumber = text_phone_number.getText();
      
      if(name.equals("")){
         JOptionPane.showMessageDialog(this, "Please enter your username");
         return false;
      } 
      if(password.equals("")){
         JOptionPane.showMessageDialog(this, "Please enter your password");
         return false;
      } 
      if(email.equals("") || !email.matches("^(.+)@(.+)$")){
         JOptionPane.showMessageDialog(this, "Please enter valid email");
         return false;
      } 
      if(phoneNumber.equals("")){
         JOptionPane.showMessageDialog(this, "Please enter your phone Number");
         return false;
      } 
          return true;
      
    }
    
    //insert unique names only
    public boolean checkDuplicateUser(){
        String name = text_username.getText();
        boolean isExist = false;
        
        try{
             Connection con = DBConnection.getConnection();
             PreparedStatement pot = con.prepareStatement("select * from users where name = ?");
             pot.setString(1, name);
             ResultSet rs = pot.executeQuery();
             
             if(rs.next()){
               isExist = true;
             } else {
               isExist = false;
             }
        } catch (Exception e){
             
            e.printStackTrace();
        }
        return isExist;
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
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        text_username = new app.bolivia.swing.JCTextField();
        jLabel3 = new javax.swing.JLabel();
        text_password = new app.bolivia.swing.JCTextField();
        jLabel8 = new javax.swing.JLabel();
        text_email = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        text_phone_number = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle2 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new necesario.RSMaterialButtonCircle();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 51, 51));
        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 255));
        jLabel2.setText("   Create Your Account ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 150, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(0, 51, 51));
        jLabel5.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("                    SIGN UP");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 210, 30));

        jLabel6.setBackground(new java.awt.Color(0, 51, 51));
        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 255));
        jLabel6.setText("   Create Your Account ");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 150, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Password");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 110, 20));

        text_username.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        text_username.setForeground(new java.awt.Color(102, 102, 255));
        text_username.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        text_username.setPlaceholder("Enter Username");
        text_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                text_usernameFocusLost(evt);
            }
        });
        jPanel2.add(text_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Username");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 110, 20));

        text_password.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        text_password.setForeground(new java.awt.Color(102, 102, 255));
        text_password.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        text_password.setPlaceholder("Enter Username");
        jPanel2.add(text_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        jLabel8.setText("Email");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 80, 20));

        text_email.setPlaceholder("Enter Your Email");
        jPanel2.add(text_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, -1));

        jLabel9.setText("Phone Number");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 90, 20));

        text_phone_number.setPlaceholder("Enter Phone number");
        jPanel2.add(text_phone_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, -1, -1));

        rSMaterialButtonCircle2.setText("LOG IN");
        jPanel2.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 180, 60));

        rSMaterialButtonCircle3.setText("SIGN UP");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 180, 60));

        jLabel1.setBackground(new java.awt.Color(0, 51, 51));
        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 30, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 580));

        jLabel4.setBackground(new java.awt.Color(0, 51, 51));
        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("                    SIGN UP");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 210, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 580));

        setSize(new java.awt.Dimension(502, 579));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        // TODO add your handling code here:
        //call validaUserDetails method
        if( validateUserDetails() == true){
            
            if(checkDuplicateUser() == false){
              insertSignupDetails();   
            } else{
              JOptionPane.showMessageDialog(this, "Username already exists..!!");
            }
        }
        
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        //code to exit the frame
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void text_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_text_usernameFocusLost
        // TODO add your handling code here:
        if(checkDuplicateUser() == true){
         JOptionPane.showMessageDialog(this, "Username already exists..!!");
        }
    }//GEN-LAST:event_text_usernameFocusLost

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
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignupPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private app.bolivia.swing.JCTextField text_email;
    private app.bolivia.swing.JCTextField text_password;
    private app.bolivia.swing.JCTextField text_phone_number;
    private app.bolivia.swing.JCTextField text_username;
    // End of variables declaration//GEN-END:variables
}