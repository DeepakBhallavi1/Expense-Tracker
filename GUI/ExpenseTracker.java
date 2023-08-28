
package GUI;

// IMPORTS

import java.sql.*;                          // Imported for performing task of SQL/MYSQL
import java.util.Date;                      // Imported for taking date as input
import java.sql.ResultSet;                  // Imported store data coming from database
import java.sql.Connection;                 // Imported to establish connection with data base
import javax.swing.JFrame;                  // importing for using Jframe properties
import javax.swing.JOptionPane;             // Imported for Showing PopUp messages 
import javax.swing.table.DefaultTableModel; // Imported for Performing tasks on tables


public class ExpenseTracker extends javax.swing.JFrame {

    public ExpenseTracker() {
        
        initComponents();
        displayCategories(); // show categories while adding expenses
        displayExpenses();   // show recent expenses
        
        // for limiting date selection till current date we will choose range
        DateField.setSelectableDateRange(null,new Date());
        
        // calling a constructor for opening full frame
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
    }
    
    // for adding expense we need to select category 
    // so we need categories so we will fetch category from data base 
    // using this method
    void displayCategories(){
        
        try{
            
            //FIRST NEED TO REMOVE ALL DATA FROM CATEGORY FIELD
            SelectCategories.removeAllItems();
            
            // database connectivity
                Connection con = DatabaseConnection.Mconnection.getConn();  

                // create statement for selecting categories from database
                Statement st = con.createStatement();      

                // use select query for get the data & store it in Result set
                ResultSet res = st.executeQuery("select * from category_information");
                
                // by Default we will show "Select" as a option in category field 
                SelectCategories.addItem("Select");
                
                // now using for loop we will show categories in select category field
                while(res.next()){
                    SelectCategories.addItem(res.getString("category"));
                }
                
                
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
        
    }
    
    
    // METHODS FOR SHOWING EXPENSES IN TABLE
    void displayExpenses(){
        
        // First we will do Exception Handling 
        try{
            // Here our code for showing Entries of Expenses
            
            // For Live Expenses Details We Will clear previous data from table
            DefaultTableModel tableData = (DefaultTableModel)ExpenseTable.getModel();
            
            // now clear data 
            int rows = tableData.getRowCount();
            while(rows-- != 0){
                tableData.removeRow(0);
            }
            
            
            // get the date for showing expenses of current date to last 30 days expenses
            
            // using LocalDate class will show us current date
            // LocalDate class is from version java 8 to till now
            java.time.LocalDate currentDate = java.time.LocalDate.now();
            java.time.LocalDate beforeDate = currentDate.minusDays(30);
            
            
            // database connectivity
            Connection con = DatabaseConnection.Mconnection.getConn();  

            // create statement for inserting category in data base
            Statement st = con.createStatement(); 
            
            // Result Set will store data coming from database
            // We Will Show recent 1 month expenses
            
            // Range Based 
            // ResultSet res = st.executeQuery("select * from expenses where expense_date<='"+currentDate+"' "
                                                                //  + "and expense_date>='"+beforeDate+"' ");
            
            // All DATA
            ResultSet res = st.executeQuery("select * from expenses");
            
            // Total Amount 
            int totalAmount = 0;
            
            // Now set Data on table
            while(res.next()){
                
                totalAmount += res.getInt("amount");
                
                // store data in object array
                Object data[] = {res.getInt("expensesid"),res.getString("name"),res.getString("category"),
                                                       res.getDate("expense_date"),res.getInt("amount")};
                
                // now add row in table
                tableData.addRow(data);
            }
            TotalAmountField.setText(totalAmount+"");
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }

        

    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        DateField = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        AmountField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        SelectCategories = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        NameField = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ExpenseTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        TotalAmountField = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu12 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu3.setText("jMenu3");

        jMenu4.setText("jMenu4");

        jMenu5.setText("jMenu5");

        jMenu6.setText("jMenu6");

        jMenu7.setText("jMenu7");

        jMenu8.setText("jMenu8");

        jMenu9.setText("jMenu9");

        jMenu10.setText("jMenu10");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Expense Tracker");

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        jPanel2.setBackground(new java.awt.Color(51, 0, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Expense");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Date:");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Category:");

        AmountField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmountFieldActionPerformed(evt);
            }
        });
        AmountField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AmountFieldKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Amount:");

        SelectCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectCategoriesActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 153, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Add New Catergory");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(102, 255, 102));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setText("ADD");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Name:");

        NameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameFieldActionPerformed(evt);
            }
        });
        NameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NameFieldKeyTyped(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(153, 255, 153));
        jButton4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton4.setText("Refresh");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DateField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NameField, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(SelectCategories, 0, 167, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(AmountField))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SelectCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(AmountField))
                            .addComponent(jButton3)
                            .addComponent(DateField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {AmountField, DateField, NameField, SelectCategories, jButton1, jButton3, jButton4, jLabel4, jLabel5});

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setText("Recent Expenses:");

        ExpenseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Expense ID", "Name", "Catergory", "Date", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ExpenseTable);

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("REMOVE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(51, 0, 204));
        jPanel3.setForeground(new java.awt.Color(255, 0, 0));

        jLabel6.setBackground(new java.awt.Color(51, 0, 51));
        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Total Expenses:");

        TotalAmountField.setEditable(false);
        TotalAmountField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalAmountFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TotalAmountField)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(TotalAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jMenu11.setText("Menu");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/view expense.jpg"))); // NOI18N
        jMenuItem1.setText("View Expenses");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jMenuItem2.setText("View/Add Category");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exitt.png"))); // NOI18N
        jMenuItem3.setText("Exit App");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem3);

        jMenu12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/About.png"))); // NOI18N
        jMenu12.setText("More...");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/About.png"))); // NOI18N
        jMenuItem4.setText("About Expense Tracker");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem4);

        jMenu11.add(jMenu12);

        jMenuBar1.add(jMenu11);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AmountFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmountFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AmountFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        // we will open "Add Category" Frame Using this button
        
        // create object of "Category.java" & call setVisible function for opning 
        // "Add Category" Frame
        Category obj = new Category();
        obj.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TotalAmountFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalAmountFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalAmountFieldActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
      
        // Close The App and all the frames
         
        // Here we are adding a confirmation 
        //that user really want to exit from the app 
        
        String showMessage = "Do You Want To Close The App ? ";
            
        // confirmation code for Closing App
        int confirmation = JOptionPane.showConfirmDialog(null,showMessage,
                                          "Confirm",JOptionPane.YES_NO_OPTION);
        
        
        // if user select yes than delete particular detail
        if(confirmation == JOptionPane.YES_OPTION){
            // 0 shows a successful exit
            System.exit(0);
        }
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
         new AboutDeveloper().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void NameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameFieldActionPerformed

    private void SelectCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectCategoriesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SelectCategoriesActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        // RE-FRESH THE CATEGORY FIELD
        displayCategories();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        // BUTTON FOR ADDING EXPENSE
        try{
            
            // get Name of Item from user
            String Name = NameField.getText();
            
            // get Selected category
            String Category = (String)SelectCategories.getSelectedItem();
            
            // get date from user
            Date date = DateField.getDate();
            
            // get Amount from user
            String Amount = AmountField.getText();
            
            
            // Process if all fields are filled 
            if(Category.equals("Select")){
                // As by default we are showing "Select" in category so need to take care that 
                // we will not adding "Select" as category
                JOptionPane.showMessageDialog(null, "Please select any category !!!");
            }
            else if(date != null && !Name.equals("") && !Amount.equals("") && !Category.equals("")){
                
                // First we will convert amount in interger
                int AmountInt = Integer.parseInt(Amount);
                
                // Now The Date format of java and SQL is different
                // Basic Date Of Java --> 01/01/1970, Whenever We Call getTime() 
                // Current Date substract Base Date and return time in long format in MiliSecond
                // Now convert in SQL Format
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                
                
                // NOW CONNECT TO DATA BASE AND FIRE THE QUERIES FOR DATA INSERTION
                
                // database connectivity
                Connection con = DatabaseConnection.Mconnection.getConn();  

                // create statement for inserting Expenses in data base
                Statement st = con.createStatement(); 
                
                st.executeUpdate("insert into expenses (name,category,expense_date,amount) values('"+Name+"','"+Category+"','"+sqlDate+"',"+AmountInt+")");
                
                
                // Show Message Of Successful Insertion
                JOptionPane.showMessageDialog(null, "Expense Added Successfully !!!");
                
                 displayExpenses();   // show recent expenses
                
                
            }else{
                // Otherwise
                // Adding Message if User Press ADD button without filling All The Fields
                JOptionPane.showMessageDialog(null, "Please fill all details !!!");
            }
            
            
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void AmountFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AmountFieldKeyTyped
        // TODO add your handling code here:
        
        // Here we are making things like user can not insert character except digits
        
        // get the character from the user
        // evt is a object all the typed characters are stored in evt object
        // so we need access throught method of evt object
        char ch = evt.getKeyChar();   
        
        // Here We Will Use Character Wrapper Class for Checking Type of Character
        if(!Character.isDigit(ch)){
            evt.consume();
        }
        
        // evt.consume(). will consume the character if it is not digit
        // means it will notShow us that if it is not a digit
        
    }//GEN-LAST:event_AmountFieldKeyTyped

    private void NameFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NameFieldKeyTyped
        
        // Here we are making things that user will not type any special character
        // LowerCase and UpperCase character
        
        char ch = evt.getKeyChar();   
        
        // Here We Will Use Character Wrapper Class for Checking Type of Character
        boolean flag = (ch == '&') || (ch == ' ');
        if(!Character.isLowerCase(ch) && !Character.isUpperCase(ch) && !flag){
            evt.consume();
        }
    }//GEN-LAST:event_NameFieldKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        // Here we will delete a particular expense
        
        // for doing this we need a particular row 
        // WE Use below funtion for selecting the row to be deleted
        int rowIndex = ExpenseTable.getSelectedRow();
        
        // If user select any row then only delete the row 
        if(rowIndex != -1){
        
            // get Item name by downcasting in string because it comes in the form of object
            String Item = (String)ExpenseTable.getValueAt(rowIndex,1);
            int ExpenseId = (int)ExpenseTable.getValueAt(rowIndex,0);
            
            String showMessage = "Do You Want To Remove " + "\"" +Item+ "\"" + " From Expense ?";
            
            // confirmation code for deleting Item
            int confirmation = JOptionPane.showConfirmDialog(null,showMessage,
                                         "Confirm",JOptionPane.YES_NO_OPTION);
        
        
            // if user select yes than delete particular Expense
            if(confirmation == JOptionPane.YES_OPTION){
        
            // remove Expense
            try{
            
                // database connectivity
                Connection con = DatabaseConnection.Mconnection.getConn();  
            
                // create state for Deleting Expense from data base
                Statement st = con.createStatement();      // create statement
            
                // delete item from expense table
                st.executeUpdate("delete from expenses where expensesid="+ExpenseId);
            
                // show message of successfull deletion
                JOptionPane.showMessageDialog(null, "\"" +Item+ "\"" + " Successfully Deleted!!!");
            
                // refresh the table data
                displayExpenses();
            
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
            
        }
        else{
            // OTHERWISE SHOW A ALERT MESSAGE
            JOptionPane.showMessageDialog(null,"Please select an item to delete !!!");
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
         // TODO add your handling code here:
        
        // From the menu bar we can directly open "ViewExpense" Frame
        // For this we need to create Object of "ViewExpense.java"
        // Then Call the method "setVisible()"
        new ViewExpense().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
      
        // From the menu bar we can directly open "Category" Frame
        // For this we need to create Object of "Category.java"
        // Then Call the method "setVisible()"
        new Category().setVisible(true);
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public static void main(String args[]) {
        
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExpenseTracker().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AmountField;
    private com.toedter.calendar.JDateChooser DateField;
    private javax.swing.JTable ExpenseTable;
    private javax.swing.JTextField NameField;
    private javax.swing.JComboBox<String> SelectCategories;
    private javax.swing.JTextField TotalAmountField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
