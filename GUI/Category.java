/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package GUI;

import java.sql.*;
import java.sql.ResultSet;
import java.util.Vector;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.awt.HeadlessException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lenovo
 */
public class Category extends javax.swing.JFrame {

    /** Creates new form Category */
    public Category() {
        
        initComponents();
        getCategoryDetails();
        
    }
       
    // this method will display the data in table 
    void getCategoryDetails(){
        
        try{
            
            // store details in DefaultTableModel
            DefaultTableModel tableData = (DefaultTableModel)CategoryDetails.getModel();
            
            // first we need clear the data present in the table
            // because if show live data it will show duplicate entries 
            // so first clear the table data
            
            // store the count of rows already present in table
            int rowCount = tableData.getRowCount();
            
            // remove row present at 0th index
            // after deletion of 0th row next row become 0th row
            while(rowCount-- != 0){
                tableData.removeRow(0);
            }

            // database connectivity
            Connection con = DatabaseConnection.Mconnection.getConn(); 
            
            // create statement
            Statement st = con.createStatement();
           
            // fire the query as fetching the details so store the details in ResultSet
            ResultSet res = st.executeQuery("select * from category_information");
            
            // variable for serial number 
            int serialNumber = 0;
            
            // Now res has all the detail of category_information table
            // from here each row's values will going to display on table CategoryDetails
            while(res.next()){
                   
                // store row in category named string
                String category = res.getString("category");
                
                // we can perform below task in two ways
                
                // 1. store values of rows in a object array
    
                // Object obj[] = {++serialNumber,category};
                // tableData.addRow(obj);
                

                // 2. using java collection
                Vector row = new Vector();
                
                row.add(++serialNumber);
                row.add(category);
                
                tableData.addRow(row);
  
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
        
    }
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        categoryField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        CategoryDetails = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NO.", "Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Category");

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        jPanel2.setBackground(new java.awt.Color(255, 153, 102));

        jLabel1.setBackground(new java.awt.Color(0, 204, 204));
        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add New Category");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setText("Category:");

        categoryField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryFieldActionPerformed(evt);
            }
        });
        categoryField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                categoryFieldKeyTyped(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(102, 255, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(categoryField)
                .addGap(24, 24, 24)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(categoryField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {categoryField, jButton1});

        CategoryDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NO.", "Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(CategoryDetails);

        jButton2.setBackground(new java.awt.Color(204, 153, 0));
        jButton2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jButton2.setText("Remove");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void categoryFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryFieldActionPerformed
        // TODO add your handling code here:
        jButton1ActionPerformed(null);
    }//GEN-LAST:event_categoryFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
   
        try{
            
            // get the Category so we check that it is empty or not
            String category = categoryField.getText();
            
            if(!category.equals("")){
            
                // database connectivity
                Connection con = DatabaseConnection.Mconnection.getConn();  

                // create statement for inserting category in data base
                Statement st = con.createStatement();      

                // insert in category information table
                st.executeUpdate("insert into category_information values('"+category+"')");

                // show message of successfull addition of category
                JOptionPane.showMessageDialog(null, "\""+ category + "\"" +" Added Successfully");

                // for table details live call the funtion for table details
                getCategoryDetails();
                
            }
            else{
                // show message that enter something on field
                JOptionPane.showMessageDialog(null, "Please Enter Category !!!");
            }
             
        }catch(SQLIntegrityConstraintViolationException ex){
            
            try{
                // if category already exist than prompt the message
                // particular category is already exist
                
                // get the catergory
                String duplicateCategory = categoryField.getText(); 
                
                // database connectivity
                Connection con = DatabaseConnection.Mconnection.getConn();  
                
                // this message will pop up when any wrong entry or
                // wrong data is inserted or duplicate data is inserted
                JOptionPane.showMessageDialog(null, "\"" + duplicateCategory + "\"" +" Catergory Already Exist!!!");
            }catch(HeadlessException ex1){
                JOptionPane.showMessageDialog(null, ex1);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
           
        
        // first get the index of selected row
        int rowIndex = CategoryDetails.getSelectedRow();
        
        if(rowIndex != -1){

            // get category by downcasting in string
            String category = (String)CategoryDetails.getValueAt(rowIndex,1);
            String showMessage = "Do You Want To Remove " + "\"" +category + "\"" + " Category ?";
            
            // confirmation code for deleting category
            int confirmation = JOptionPane.showConfirmDialog(null,showMessage,
                                          "Confirm",JOptionPane.YES_NO_OPTION);
        
        
            // if user select yes than delete particular detail
            if(confirmation == JOptionPane.YES_OPTION){
        
                // remove category
                try{
            
                    // database connectivity
                    Connection con = DatabaseConnection.Mconnection.getConn();  
            
                    // create state for deleting category from data base
                    Statement st = con.createStatement();      // create statement
            
                    // delete category from category information table
                    st.executeUpdate("delete from category_information where category='"+category+"' ");
            
                    // show message of successfull deletion
                    JOptionPane.showMessageDialog(null, "\"" + category+ "\"" + " Category Successfully Deleted!!!");
            
                    // refresh the table data
                    getCategoryDetails();
            
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }
        else{
            // OTHERWISE SHOW A ALERT MESSAGE
            JOptionPane.showMessageDialog(null,"Please select a category to delete !!!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void categoryFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_categoryFieldKeyTyped
        
        // Here we are making things that user will not type any special character
        // LowerCase and UpperCase character
        
        char ch = evt.getKeyChar();   
        
        // Here We Will Use Character Wrapper Class for Checking Type of Character
        boolean flag = (ch == '&') || (ch == ' '); // this characters are also allowed
        if(!Character.isLowerCase(ch) && !Character.isUpperCase(ch) && !flag){
            evt.consume();
        }
        
    }//GEN-LAST:event_categoryFieldKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CategoryDetails;
    private javax.swing.JTextField categoryField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
