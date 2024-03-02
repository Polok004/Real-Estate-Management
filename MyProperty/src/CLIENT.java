/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author shoumikbarmanpolok
 */
public class CLIENT extends javax.swing.JFrame {

    /**
     * Creates new form CLIENT
     */
    public CLIENT() throws SQLException {
        initComponents();
        Border pannel_border=BorderFactory.createMatteBorder(0,0,4,0,Color.red);
         jLabel_prtype.setBorder(pannel_border);
         fillJtableWithClientData();
    }
    public void fillJtableWithClientData() throws SQLException
    {
        P_CLIENT client=new P_CLIENT();
        ArrayList<P_CLIENT> clientList=client.clientList();
        String[] colNames={"ID","First Name","Last Name","Phone","Email","Address"};
        Object[][] rows=new Object[clientList.size()][6];
        for(int i=0;i<clientList.size();i++)
        {
            rows[i][0]=clientList.get(i).getId();
            rows[i][1]=clientList.get(i).getFname();
            rows[i][2]=clientList.get(i).getLname();
            rows[i][3]=clientList.get(i).getPhone();
            rows[i][4]=clientList.get(i).getEmail();
            rows[i][5]=clientList.get(i).getAddress();
            
        }
        DefaultTableModel model=new DefaultTableModel(rows,colNames);
        jTable.setModel(model);
        jTable.setRowHeight(40);
        jTable.setSelectionBackground(Color.black);
        jTable.getColumnModel().getColumn(0).setPreferredWidth(25);
        jTable.getColumnModel().getColumn(5).setPreferredWidth(150);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_id = new javax.swing.JTextField();
        jTextField_first = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_address = new javax.swing.JTextArea();
        jButton_edit = new javax.swing.JButton();
        jButton_remove = new javax.swing.JButton();
        jButton_refresh = new javax.swing.JButton();
        jButton_add = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField_second = new javax.swing.JTextField();
        jTextField_phone = new javax.swing.JTextField();
        jTextField_email = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel_prtype = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel1.setText("              ID:");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel2.setText("    Address:");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel3.setText(" First Name:");

        jTextField_id.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jTextField_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_idActionPerformed(evt);
            }
        });

        jTextField_first.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jTextField_first.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_firstActionPerformed(evt);
            }
        });

        jTextArea_address.setColumns(20);
        jTextArea_address.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jTextArea_address.setRows(5);
        jScrollPane1.setViewportView(jTextArea_address);

        jButton_edit.setBackground(new java.awt.Color(153, 0, 153));
        jButton_edit.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jButton_edit.setText("Edit");
        jButton_edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_editActionPerformed(evt);
            }
        });

        jButton_remove.setBackground(new java.awt.Color(255, 0, 0));
        jButton_remove.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jButton_remove.setText("Remove");
        jButton_remove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_removeActionPerformed(evt);
            }
        });

        jButton_refresh.setBackground(new java.awt.Color(255, 255, 0));
        jButton_refresh.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jButton_refresh.setText("Refresh");
        jButton_refresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_refreshActionPerformed(evt);
            }
        });

        jButton_add.setBackground(new java.awt.Color(0, 204, 51));
        jButton_add.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jButton_add.setText("Add");
        jButton_add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_addActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel4.setText("Second Name:");

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel5.setText("       Email:");

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel6.setText("      Phone:");

        jTextField_second.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jTextField_second.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_secondActionPerformed(evt);
            }
        });

        jTextField_phone.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jTextField_phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_phoneActionPerformed(evt);
            }
        });

        jTextField_email.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jTextField_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_emailActionPerformed(evt);
            }
        });

        jTable.setBackground(new java.awt.Color(0, 102, 102));
        jTable.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_second)
                            .addComponent(jTextField_phone)
                            .addComponent(jTextField_email)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                            .addComponent(jTextField_first))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 103, Short.MAX_VALUE)
                .addComponent(jButton_add, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jButton_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jButton_remove, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jButton_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField_first, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField_second, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField_email, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_remove, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_add, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(148, 148, 148))
        );

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        jLabel_prtype.setFont(new java.awt.Font("Helvetica Neue", 1, 48)); // NOI18N
        jLabel_prtype.setText("Clients");
        jLabel_prtype.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(482, 482, 482)
                .addComponent(jLabel_prtype, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel_prtype, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_idActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField_idActionPerformed

    private void jTextField_firstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_firstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_firstActionPerformed

    private void jButton_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_editActionPerformed
        // TODO add your handling code here:
        // int ownerId=Integer.valueOf(jTextField_id.getText());
        String fname=jTextField_first.getText();
        String lname=jTextField_second.getText();
        String phone=jTextField_phone.getText();
        String email=jTextField_email.getText();
        String address=jTextArea_address.getText();

        P_CLIENT client=new P_CLIENT();
        try{

            int clientId=Integer.valueOf(jTextField_id.getText());

            if(fname.trim().equals("") || lname.trim().equals("")||phone.trim().equals("")||email.trim().equals("")||address.trim().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter The Client Information First ","Add Client",1);
            }
            else{

                if(client.editClientData(new P_CLIENT(clientId,fname,lname,phone,email,address)))
                {
                    JOptionPane.showMessageDialog(null,"Client Data Edited To The System","Edit Client",1);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Client Data NOT Edited To The System","Edit Client",2);
                }

            }
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Enter Valid Data","Edit Client",2);
        }

    }//GEN-LAST:event_jButton_editActionPerformed

    private void jButton_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_removeActionPerformed
        // TODO add your handling code here:

        try{
            int client_id=Integer.valueOf(jTextField_id.getText());
            P_CLIENT client=new P_CLIENT();
            if(jTextField_id.getText().trim().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter The Client Id","Empty Id",2);
            }
            else
            {
                int yes_or_no=JOptionPane.showConfirmDialog(null,"Do you want to delete this Client","Delete Client",JOptionPane.YES_NO_OPTION);
                if(yes_or_no==JOptionPane.YES_OPTION)
                {
                    if(client.deleteClient(client_id))
                    {
                        JOptionPane.showMessageDialog(null,"Client Deleted","Delete Client",1);
                              jTextField_id.setText("");
                              jTextField_first.setText("");
                              jTextField_second.setText("");
                              jTextField_email.setText("");
                              jTextField_phone.setText("");
                              jTextArea_address.setText("");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Operation Failed","Delete Client",2);
                    }

                }
            }
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Enter Valid Data","Delete Client",2);
        }

    }//GEN-LAST:event_jButton_removeActionPerformed

    private void jButton_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_refreshActionPerformed
        try {
            // TODO add your handling code here:
            fillJtableWithClientData();
                              jTextField_id.setText("");
                              jTextField_first.setText("");
                              jTextField_second.setText("");
                              jTextField_email.setText("");
                              jTextField_phone.setText("");
                              jTextArea_address.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_refreshActionPerformed

    private void jButton_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addActionPerformed
        // TODO add your handling code here:
        String fname=jTextField_first.getText();
        String lname=jTextField_second.getText();
        String phone=jTextField_phone.getText();
        String email=jTextField_email.getText();
        String address=jTextArea_address.getText();

        P_CLIENT client=new P_CLIENT();

        if(fname.trim().equals("") || lname.trim().equals("")||phone.trim().equals("")||email.trim().equals("")||address.trim().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Enter The Client Information First ","Add Client",1);
        }
        else{

            try{
                if(client.addNewClient(new P_CLIENT(0,fname,lname,phone,email,address)))
                {
                    JOptionPane.showMessageDialog(null,"New Client Added To The System","Add Client",1);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Client NOT Added To The System","Add Client",2);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton_addActionPerformed

    private void jTextField_secondActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_secondActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_secondActionPerformed

    private void jTextField_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_phoneActionPerformed

    private void jTextField_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_emailActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // TODO add your handling code here:
        int selectedRowIndex=jTable.getSelectedRow();
        jTextField_id.setText(jTable.getValueAt(selectedRowIndex,0).toString());
        jTextField_first.setText(jTable.getValueAt(selectedRowIndex,1).toString());
        jTextField_second.setText(jTable.getValueAt(selectedRowIndex,2).toString());
        jTextField_phone.setText(jTable.getValueAt(selectedRowIndex,3).toString());
        jTextField_email.setText(jTable.getValueAt(selectedRowIndex,4).toString());
        jTextArea_address.setText(jTable.getValueAt(selectedRowIndex,5).toString());
    }//GEN-LAST:event_jTableMouseClicked

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
            java.util.logging.Logger.getLogger(CLIENT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CLIENT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CLIENT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CLIENT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CLIENT().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_add;
    private javax.swing.JButton jButton_edit;
    private javax.swing.JButton jButton_refresh;
    private javax.swing.JButton jButton_remove;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_prtype;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JTextArea jTextArea_address;
    private javax.swing.JTextField jTextField_email;
    private javax.swing.JTextField jTextField_first;
    private javax.swing.JTextField jTextField_id;
    private javax.swing.JTextField jTextField_phone;
    private javax.swing.JTextField jTextField_second;
    // End of variables declaration//GEN-END:variables
}
