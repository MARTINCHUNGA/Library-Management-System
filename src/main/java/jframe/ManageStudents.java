/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author User
 */
public class ManageStudents extends javax.swing.JFrame {

    /**
     * Creates new form ManageBooks
     */
    String studentName,course,year;
    int studentId;
    DefaultTableModel model;
    public ManageStudents() {
        initComponents();
        setStudentDetails();
    }
    
    //method to add student details in the database
    public boolean addStudent(){
        
         boolean isAdded = false;
        
         studentId = Integer.parseInt(text_studentid.getText());
         studentName = text_studentName.getText();
         course = combo_studentCourse.getSelectedItem().toString();
         year = combo_studentYear.getSelectedItem().toString();
//         author = text_bookauthor.getText();
//         quantity = Integer.parseInt(text_bookquantity.getText());
         
         
         try{
             Connection con = DBConnection.getConnection();
             String sql = "insert into student_details values(?,?,?,?)";
             PreparedStatement prest = con.prepareStatement(sql);
             prest.setInt(1, studentId);
             prest.setString(2, studentName);
             prest.setString(3, course);
             prest.setString(4, year);
             
             int rowCount =  prest.executeUpdate();
             
             if(rowCount > 0){
               isAdded = true;
             } else {
                 isAdded = false;
             }   
         }catch(Exception e){
             e.printStackTrace(); 
         }
         return isAdded;
    }
    
    //clear table before inserting method
    public void clearTable(){
       
        DefaultTableModel mods = (DefaultTableModel) studentTableDetails.getModel();
        mods.setRowCount(0);
    }
    //method to update student details
    public boolean updateStudent(){
         boolean isUpdated = false;       
         studentId = Integer.parseInt(text_studentid.getText());
         studentName = text_studentName.getText();
         course = combo_studentCourse.getSelectedItem().toString();
         year = combo_studentYear.getSelectedItem().toString();
         
         try{
           Connection con = DBConnection.getConnection();
           String sql = "update student_details set name = ?, course = ?, year = ? where student_id = ?";
           PreparedStatement prest = con.prepareStatement(sql);
           prest.setString(1, studentName);
           prest.setString(2,course);
           prest.setString(3, year);
           prest.setInt(4, studentId);
           
           int rowCount = prest.executeUpdate();
           
           if(rowCount > 0){
             isUpdated = true;
           }else {
             isUpdated = false;
           }
           
           
         }catch(Exception e){
           e.printStackTrace();
         }
         
         return isUpdated;
       
    }
    
    //method to delete book entry in the table
    public boolean deleteStudentEntry(){
      
        boolean isDeleted = false;
        studentId = Integer.parseInt(text_studentid.getText());
        
        try{
           Connection con = DBConnection.getConnection();
           String sql = "delete from student_details where student_id = ?";
           PreparedStatement prest = con.prepareStatement(sql);
           prest.setInt(1, studentId);
           int rowCount = prest.executeUpdate();
           
           if(rowCount > 0){
             isDeleted = true;
           }else{
             isDeleted = false;          
           }
        }catch(Exception e){
             e.printStackTrace();
        }     
        return isDeleted;
    }
    
    //method to get book details from database and display in the table
    public void setStudentDetails(){
        
        try{
             Connection con = DBConnection.getConnection();
             Statement stat = con.createStatement();
              ResultSet rs = stat.executeQuery("select * from student_details");
                      
              while(rs.next()){
                String student_Id = rs.getString("student_id");
                String student_name = rs.getString("name");
                String studentCourse = rs.getString("course");
                String studentYear = rs.getString("year");
                
                Object[] obj = {student_Id, student_name, studentCourse, studentYear};
                
                model = (DefaultTableModel)studentTableDetails.getModel();
                
                model.addRow(obj);
              }
  
        } catch (Exception e){
           e.printStackTrace();
        }
    
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        text_studentid = new app.bolivia.swing.JCTextField();
        jLabel3 = new javax.swing.JLabel();
        text_studentName = new app.bolivia.swing.JCTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new necesario.RSMaterialButtonCircle();
        combo_studentYear = new javax.swing.JComboBox<>();
        combo_studentCourse = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        studentTableDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("<Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 6, 57, 28));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 40));

        jLabel2.setText("Student Id");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 120, 30));

        text_studentid.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        text_studentid.setForeground(new java.awt.Color(102, 102, 255));
        text_studentid.setPlaceholder("Enter Student Id");
        text_studentid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_studentidActionPerformed(evt);
            }
        });
        jPanel1.add(text_studentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        jLabel3.setText("Student name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 120, 30));

        text_studentName.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        text_studentName.setForeground(new java.awt.Color(102, 102, 255));
        text_studentName.setPlaceholder("Enter Student Name");
        text_studentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_studentNameActionPerformed(evt);
            }
        });
        jPanel1.add(text_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        jLabel4.setText("Course");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 120, 30));

        jLabel5.setText("Year");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 120, 30));

        rSMaterialButtonCircle1.setText("DELETE");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 90, 50));

        rSMaterialButtonCircle2.setText("ADD");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 90, 50));

        rSMaterialButtonCircle3.setText("UPDATE");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 80, 50));

        combo_studentYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "One", "Two", "Three", "Four", "Five" }));
        combo_studentYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_studentYearActionPerformed(evt);
            }
        });
        jPanel1.add(combo_studentYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 200, 30));

        combo_studentCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Computer Science", "Network Engineering", "Statistics", "Chemistry", "Mathematics", "Physics", " " }));
        combo_studentCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_studentCourseActionPerformed(evt);
            }
        });
        jPanel1.add(combo_studentCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 200, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 900));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 255));
        jLabel6.setText("X");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 22, -1));

        studentTableDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "Course", "Year"
            }
        ));
        studentTableDetails.setColorBackgoundHead(new java.awt.Color(204, 204, 255));
        studentTableDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        studentTableDetails.setColorForegroundHead(new java.awt.Color(0, 112, 192));
        studentTableDetails.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        studentTableDetails.setRowHeight(35);
        studentTableDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentTableDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(studentTableDetails);

        jLabel7.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 204));
        jLabel7.setText("Manage The Students");

        jPanel5.setBackground(new java.awt.Color(102, 0, 102));
        jPanel5.setForeground(new java.awt.Color(204, 0, 51));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addGap(299, 299, 299)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 126, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 356, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 860, 900));

        setSize(new java.awt.Dimension(1200, 900));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        HomePage homePage = new HomePage();
        homePage.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void text_studentidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_studentidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_studentidActionPerformed

    private void text_studentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_studentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_studentNameActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        // TODO add your handling code here:
        
        
         if(deleteStudentEntry() == true){
           JOptionPane.showMessageDialog(this, "Student deleted successfully..");
           clearTable();
           setStudentDetails();
           
        } else {
           JOptionPane.showMessageDialog(this, "Something is wrong. Student not deleted");

        }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        // TODO add your handling code here:
        //call the addBook method here
        if(addStudent() == true){
           JOptionPane.showMessageDialog(this, "Student added successfully..!!");
           clearTable();
           setStudentDetails();
           
        } else {
           JOptionPane.showMessageDialog(this, "Something is wrong. Student not added");

        }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        // TODO add your handling code here:
         if(updateStudent() == true){
           JOptionPane.showMessageDialog(this, "Student updated successfully..!!");
           clearTable();
           setStudentDetails();
           
        } else {
           JOptionPane.showMessageDialog(this, "Something is wrong. Student not updated");

        }
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void studentTableDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentTableDetailsMouseClicked
        // TODO add your handling code here:
        int row_number = studentTableDetails.getSelectedRow();
        TableModel mod = studentTableDetails.getModel();
        
        text_studentid.setText(mod.getValueAt(row_number, 0).toString());
        text_studentName.setText(mod.getValueAt(row_number, 1).toString());
        combo_studentCourse.setSelectedItem(mod.getValueAt(row_number, 2).toString());
        combo_studentYear.setSelectedItem(mod.getValueAt(row_number, 3).toString());
//        text_bookauthor.setText(mod.getValueAt(row_number, 2).toString());
//        text_bookquantity.setText(mod.getValueAt(row_number, 3).toString());
    }//GEN-LAST:event_studentTableDetailsMouseClicked

    private void combo_studentYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_studentYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_studentYearActionPerformed

    private void combo_studentCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_studentCourseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_studentCourseActionPerformed

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
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_studentCourse;
    private javax.swing.JComboBox<String> combo_studentYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojeru_san.complementos.RSTableMetro studentTableDetails;
    private app.bolivia.swing.JCTextField text_studentName;
    private app.bolivia.swing.JCTextField text_studentid;
    // End of variables declaration//GEN-END:variables
}
