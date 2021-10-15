/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Locale;
import javax.swing.JOptionPane;

//------ Login page class 
//-----------------------------------------------------------------------------------------------------------------------//

public class loginCheck extends javax.swing.JFrame {
    
    //Sets connection to database as null
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    
    
    /**
     * Creates new form loginCheck
     * @param lcl
     */
    
   //Constructor
    
    public loginCheck(Locale lcl) {
           //Sets default language for login page according to selected language
        Locale.setDefault(lcl);
           //Creates components of GUI for login
        initComponents();
    }
   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    //All components in the login GUI
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        signinButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("javaProject/Bundle"); // NOI18N
        jLabel4.setText(bundle.getString("loginCheck.jLabel4.text")); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(585, 376));
        setSize(new java.awt.Dimension(585, 376));
        getContentPane().setLayout(null);

        jLabel1.setText(bundle.getString("loginCheck.jLabel1.text")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(90, 130, 120, 16);

        jLabel2.setText(bundle.getString("loginCheck.jLabel2.text")); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 170, 140, 20);

        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });
        getContentPane().add(usernameField);
        usernameField.setBounds(230, 130, 229, 22);

        signinButton.setBackground(new java.awt.Color(255, 255, 255));
        signinButton.setText(bundle.getString("loginCheck.signinButton.text")); // NOI18N
        signinButton.setFocusPainted(false);
        signinButton.setPreferredSize(new java.awt.Dimension(500, 500));
        signinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signinButtonActionPerformed(evt);
            }
        });
        getContentPane().add(signinButton);
        signinButton.setBounds(280, 220, 170, 50);

        resetButton.setBackground(new java.awt.Color(255, 255, 255));
        resetButton.setText(bundle.getString("loginCheck.resetButton.text")); // NOI18N
        resetButton.setFocusPainted(false);
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        getContentPane().add(resetButton);
        resetButton.setBounds(90, 220, 170, 50);

        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });
        getContentPane().add(passwordField);
        passwordField.setBounds(230, 170, 229, 22);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText(bundle.getString("loginCheck.jLabel3.text")); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 70, 540, 60);

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\Downloads\\My Post (7).jpg")); // NOI18N
        jLabel5.setText(bundle.getString("loginCheck.jLabel5.text")); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(-140, -10, 830, 420);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Signing in button
    
    private void signinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signinButtonActionPerformed

        //Get the username and password as entered by user
        
        String username = usernameField.getText();
        String password = passwordField.getText();
        
        
       //Get the usernames and passwords stored in the database
       
                 try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=detail;user=sa;password=123";
            Connection con = DriverManager.getConnection(url);
            String sql = "Select * from login where username=? and password =?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            
            //If the username and password match
            if(rs.next()){
                JOptionPane.showMessageDialog(rootPane, "Access granted");
                
                //Creates object of next page after login is a success
                
                searchRecord search = new searchRecord();
                search.setVisible(true);
              
            }
            
            //If the username and password dont match
            else{
                JOptionPane.showMessageDialog(rootPane, "Access denied", "Message", JOptionPane.WARNING_MESSAGE);
                
            }
            con.close();
        }
                 
       //Error shown if username and password cannot to taken from the database
                 
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

            
       
        
    }//GEN-LAST:event_signinButtonActionPerformed

    //Username field
    
    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        
  
        
    }//GEN-LAST:event_usernameFieldActionPerformed

    //Reset button
    
    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        
         usernameField.setText("");
         passwordField.setText("");
        
    }//GEN-LAST:event_resetButtonActionPerformed

    //Password field
    
    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    //Components of GUI declaration

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton signinButton;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}