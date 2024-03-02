
import java.awt.Color;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author shoumikbarmanpolok
 */
public class SALES extends javax.swing.JFrame {
        
       P_REGISTER type=new P_REGISTER();
       HashMap<String,Integer> map=type.getAgentMap();
    /**
     * Creates new form SALES
     */
    public SALES() throws SQLException {
        initComponents();
        bindCombo();
            Border pannel_border=BorderFactory.createMatteBorder(0,0,4,0,Color.white);
         jLabel_prtype.setBorder(pannel_border);
         
         fillJtableProperties();
            jTable_property.setRowHeight(40);
        jTable_property.setSelectionBackground(Color.black);
        jTable_property.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTable_property.getColumnModel().getColumn(1).setPreferredWidth(40);
        
        jTable_property.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTable_property.getColumnModel().getColumn(3).setPreferredWidth(80);
        
         fillJtableClients();
         jTable_client.setRowHeight(50);
        jTable_client.setSelectionBackground(Color.black);
        
  
       
        jTable_client.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTable_client.getColumnModel().getColumn(1).setPreferredWidth(25);
        jTable_client.getColumnModel().getColumn(2).setPreferredWidth(25);
      // jTable_client.getColumnModel().getColumn().setPreferredWidth(25);
        
        fillJtableSales();
        jTable_client1.setRowHeight(40);
        jTable_client1.setSelectionBackground(Color.black);
        jTable_client1.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTable_client1.getColumnModel().getColumn(2).setPreferredWidth(30);
        jTable_client1.getColumnModel().getColumn(4).setPreferredWidth(120);
        jTable_client1.getColumnModel().getColumn(5).setPreferredWidth(120);
        
    }
     
    
     public void bindCombo()
    {
        
        for(String s : map.keySet())
        {
            jComboBox1.addItem(s);
        }
    }
     public void fillJtableProperties() throws SQLException
    {
        P_PROPERTY property=new P_PROPERTY();
        ArrayList<P_PROPERTY> propertyList=property.propertiesList();
       
        
        String[] colNames={"ID","Owner Id","Price","Status"};
        Object[][] rows=new Object[propertyList.size()][4];
        for(int i=0;i<propertyList.size();i++)
        {
            rows[i][0]=propertyList.get(i).getId();
           
            rows[i][1]=propertyList.get(i).getOwnerId();
            rows[i][2]=propertyList.get(i).getPrice();
            
            if(new P_SALES().propertyIsNotSold(propertyList.get(i).getId()))
            {
                rows[i][3]="Available";
                
            }
            else
            {
                rows[i][3]="Sold";
            }
           
            
            
        }
        DefaultTableModel model=new DefaultTableModel(rows,colNames);
         jTable_property.setModel(model);
       jTable_property.setRowHeight(40);
        jTable_property.setSelectionBackground(Color.black);
        jTable_property.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTable_property.getColumnModel().getColumn(1).setPreferredWidth(40);
        
        jTable_property.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTable_property.getColumnModel().getColumn(3).setPreferredWidth(80);
    }
    
     
      public void fillJtableClients() throws SQLException
    {
         P_CLIENT client=new P_CLIENT();
        ArrayList<P_CLIENT> clientList=client.clientList();
        String[] colNames={"ID","First Name","Last Name"};
        Object[][] rows=new Object[clientList.size()][3];
        for(int i=0;i<clientList.size();i++)
        {
            rows[i][0]=clientList.get(i).getId();
            rows[i][1]=clientList.get(i).getFname();
            rows[i][2]=clientList.get(i).getLname();
            
            
        }
        DefaultTableModel model=new DefaultTableModel(rows,colNames);
        jTable_client.setModel(model);
          jTable_client.setRowHeight(50);
        jTable_client.setSelectionBackground(Color.black);
        
  
       
        jTable_client.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTable_client.getColumnModel().getColumn(1).setPreferredWidth(25);
        jTable_client.getColumnModel().getColumn(2).setPreferredWidth(25);
      // jTable_client.getColumnModel().getColumn().setPreferredWidth(25);
       
    }
      
        public void fillJtableSales() throws SQLException
    {
         P_SALES client=new P_SALES();
        ArrayList<P_SALES> clientList=client.clientList();
        String[] colNames={"ID","Property","Client","Price","Date","Agent"};
        Object[][] rows=new Object[clientList.size()][6];
        for(int i=0;i<clientList.size();i++)
        {
            rows[i][0]=clientList.get(i).getId();
            rows[i][1]=clientList.get(i).getPropertyId();
            rows[i][2]=clientList.get(i).getClientId();
            rows[i][3]=clientList.get(i).getFinalPrice();
            rows[i][4]=clientList.get(i).getSellingDate();
            rows[i][5]=clientList.get(i).getAgent();
            
        }
        DefaultTableModel model=new DefaultTableModel(rows,colNames);
        jTable_client1.setModel(model);
         jTable_client1.setRowHeight(40);
        jTable_client1.setSelectionBackground(Color.black);
        jTable_client1.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTable_client1.getColumnModel().getColumn(2).setPreferredWidth(30);
        jTable_client1.getColumnModel().getColumn(4).setPreferredWidth(120);
        jTable_client1.getColumnModel().getColumn(5).setPreferredWidth(120);
       
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
        jLabel_prtype = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel_property_Id = new javax.swing.JLabel();
        jTextField_id = new javax.swing.JTextField();
        jTextField_pId = new javax.swing.JTextField();
        jButton_edit = new javax.swing.JButton();
        jButton_remove = new javax.swing.JButton();
        jButton_refresh = new javax.swing.JButton();
        jButton_add = new javax.swing.JButton();
        jLabel_client = new javax.swing.JLabel();
        jLabel_date = new javax.swing.JLabel();
        jLabel_price = new javax.swing.JLabel();
        jTextField_cId = new javax.swing.JTextField();
        jTextField_price = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_property = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_client = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_client1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jButton_add_property = new javax.swing.JButton();
        jButton_add_client = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel_price1 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 102, 51));

        jPanel2.setBackground(new java.awt.Color(0, 153, 0));

        jLabel_prtype.setFont(new java.awt.Font("Helvetica Neue", 1, 48)); // NOI18N
        jLabel_prtype.setText("Sales");
        jLabel_prtype.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(496, 496, 496)
                .addComponent(jLabel_prtype, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel_prtype, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel1.setText("              ID:");

        jLabel_property_Id.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel_property_Id.setText("Property ID:");

        jTextField_id.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jTextField_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_idActionPerformed(evt);
            }
        });

        jTextField_pId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_pIdActionPerformed(evt);
            }
        });

        jButton_edit.setBackground(new java.awt.Color(255, 0, 204));
        jButton_edit.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jButton_edit.setText("Edit");
        jButton_edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_editActionPerformed(evt);
            }
        });

        jButton_remove.setBackground(new java.awt.Color(255, 153, 153));
        jButton_remove.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jButton_remove.setText("Remove");
        jButton_remove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_removeActionPerformed(evt);
            }
        });

        jButton_refresh.setBackground(new java.awt.Color(0, 255, 255));
        jButton_refresh.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jButton_refresh.setText("Refresh");
        jButton_refresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_refreshActionPerformed(evt);
            }
        });

        jButton_add.setBackground(new java.awt.Color(0, 204, 102));
        jButton_add.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jButton_add.setText("Add");
        jButton_add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_addActionPerformed(evt);
            }
        });

        jLabel_client.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel_client.setText("  Client ID:");

        jLabel_date.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel_date.setText("      Date :");

        jLabel_price.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel_price.setText("Final Price:");

        jTextField_cId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_cIdActionPerformed(evt);
            }
        });

        jTextField_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_priceActionPerformed(evt);
            }
        });

        jTable_property.setBackground(new java.awt.Color(255, 153, 153));
        jTable_property.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jTable_property.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_property.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_propertyMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_property);

        jTable_client.setBackground(new java.awt.Color(255, 255, 102));
        jTable_client.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jTable_client.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_client.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_clientMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable_client);

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel7.setText("Clients List :");

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel8.setText("Properties List :");

        jDateChooser1.setDateFormatString("dd/MM/yyyy");
        jDateChooser1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N

        jTable_client1.setBackground(new java.awt.Color(102, 102, 255));
        jTable_client1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jTable_client1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_client1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_client1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable_client1);

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel9.setText("Sales List :");

        jButton_add_property.setBackground(new java.awt.Color(0, 153, 153));
        jButton_add_property.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jButton_add_property.setText("Add");
        jButton_add_property.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_add_property.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_add_propertyActionPerformed(evt);
            }
        });

        jButton_add_client.setBackground(new java.awt.Color(0, 153, 102));
        jButton_add_client.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jButton_add_client.setText("Add");
        jButton_add_client.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_add_client.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_add_clientActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel2.setText("Agent :");

        jLabel_price1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel_price1.setText("Password :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel_property_Id)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_pId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel_client, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField_cId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel_price)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField_price, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel_price1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton_add, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton_remove, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel_date)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                    .addComponent(jButton_refresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 215, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_add_client, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
                        .addGap(28, 28, 28)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton_add_property, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(398, 398, 398))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                                .addComponent(jScrollPane4))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_pId, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_property_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField_cId, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_client, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_price, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_price, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_price1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_date, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton_add, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_remove, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton_add_property, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_add_client, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(197, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable_clientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_clientMouseClicked
        // TODO add your handling code here:
          int selectedRowIndex=jTable_client.getSelectedRow();
          jTextField_cId.setText(jTable_client.getValueAt(selectedRowIndex,0).toString());
    }//GEN-LAST:event_jTable_clientMouseClicked

    private void jTable_propertyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_propertyMouseClicked
        // TODO add your handling code here:
        int selectedRowIndex=jTable_property.getSelectedRow();
        //jTextField_id.setText(jTable_property.getValueAt(selectedRowIndex,0).toString());
        jTextField_pId.setText(jTable_property.getValueAt(selectedRowIndex,0).toString());
        //jTextField_cId.setText(jTable_property.getValueAt(selectedRowIndex,2).toString());
        jTextField_price.setText(jTable_property.getValueAt(selectedRowIndex,2).toString());
       // jTextField_date.setText(jTable_property.getValueAt(selectedRowIndex,4).toString());

    }//GEN-LAST:event_jTable_propertyMouseClicked

    private void jTextField_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_priceActionPerformed

    private void jTextField_cIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_cIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_cIdActionPerformed

    private void jButton_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addActionPerformed
        // TODO add your handling code here:
       // int id=Integer.valueOf(jTextField_id.getText());
       try{
        int propertyId=Integer.valueOf(jTextField_pId.getText());
        int clientid=Integer.valueOf(jTextField_cId.getText());
        String finalPrice=jTextField_price.getText();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String sellingate=dateFormat.format(jDateChooser1.getDate());
        String agentname=jComboBox1.getSelectedItem().toString();
        String password=String.valueOf(jPasswordField1.getPassword());
        P_SALES sale=new P_SALES(0,propertyId,clientid,finalPrice,sellingate,agentname);
     //new P_SALES().propertyExists(propertyId) &&   
        if(new P_SALES().propertyIsNotSold(propertyId))
        {
            if(new P_SALES().clientExists(clientid)){
                if(password.equals(new P_REGISTER().getPasswordByUsername(agentname))){
            
        try {
            if(new P_SALES().addNewSales(sale))
            {
                JOptionPane.showMessageDialog(null,"A New Sale Has Been Created","Add Sale",1);
            }
            else
                    {
                        JOptionPane.showMessageDialog(null,"Sale Has NOT Been Created","Add Sale",2);
                    }
        } catch (SQLException ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
       }else{ 
                    
                JOptionPane.showMessageDialog(null,"Incorrect Password","Add Sale",2);
        }
                    
            }
        else
        {
            JOptionPane.showMessageDialog(null,"NO PROPERTY ID OR CLIENT ID EXIST","Add Sale",2);
        }
        }else
        {
            JOptionPane.showMessageDialog(null,"Property Already sold","Add Sale",2);
        }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"No Sale Added","Add Sale",2);
        }
       

    }//GEN-LAST:event_jButton_addActionPerformed

    private void jButton_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_refreshActionPerformed
        try {
            //
            fillJtableSales();
            fillJtableProperties();
            fillJtableClients();
            
                              jTextField_id.setText("");
                              jTextField_cId.setText("");
                              jTextField_pId.setText("");
                              jTextField_price.setText("");
                              jDateChooser1.setDate(null); 
                              jPasswordField1.setText("");
                              jComboBox1.setSelectedItem(null);
        } catch (SQLException ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_refreshActionPerformed

    private void jButton_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_removeActionPerformed
        // TODO add your handling code here:
        
        
        try{
         int id=Integer.valueOf(jTextField_id.getText());
         
          String agentname=jComboBox1.getSelectedItem().toString();
        String password=String.valueOf(jPasswordField1.getPassword());
   //     P_SALES sale=new P_SALES(id,propertyId,clientid,finalPrice,sellingate);
        if(password.equals(new P_REGISTER().getPasswordByUsername(agentname)) || password.equals(new P_REGISTER().getPasswordById(1))){
        if(new P_SALES().deleteSale(id))
        {
            JOptionPane.showMessageDialog(null,"Sale Has Been Deleted","Delete Sale",1);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Sale Has NOT Been Deleted","Delete Sale",2);
        }
        }else{ 
                    
                JOptionPane.showMessageDialog(null,"Incorrect Password","Add Sale",2);
        }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"No Sale Deleted","Delete Sale",2);
        }
    }//GEN-LAST:event_jButton_removeActionPerformed

    private void jButton_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_editActionPerformed
        // TODO add your handling code here:
        // int ownerId=Integer.valueOf(jTextField_id.getText());
        try{
         int id=Integer.valueOf(jTextField_id.getText());
        int propertyId=Integer.valueOf(jTextField_pId.getText());
        int clientid=Integer.valueOf(jTextField_cId.getText());
        String finalPrice=jTextField_price.getText();
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
        String sellingate=dateFormat.format(jDateChooser1.getDate());
        String agentname=jComboBox1.getSelectedItem().toString();
        String password=String.valueOf(jPasswordField1.getPassword());
        P_SALES sale=new P_SALES(id,propertyId,clientid,finalPrice,sellingate,agentname);
         if(password.equals(new P_REGISTER().getPasswordByUsername(agentname)) || password.equals(new P_REGISTER().getPasswordById(1))){
        if(new P_SALES().editSaleData(sale))
        {
            JOptionPane.showMessageDialog(null,"Sale Has Been Updated","Updated Sale",1);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Sale Has NOT Been Updated","Updated Sale",2);
        }
        }else{ 
                    
                JOptionPane.showMessageDialog(null,"Incorrect Password","Add Sale",2);
        }
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"No Sale Updated","Update Sale ",2);
        }
    }//GEN-LAST:event_jButton_editActionPerformed

    private void jTextField_pIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_pIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_pIdActionPerformed

    private void jTextField_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_idActionPerformed

    private void jTable_client1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_client1MouseClicked
        // TODO add your handling code here:
        int selectedRowIndex=jTable_client1.getSelectedRow();
        jTextField_id.setText(jTable_client1.getValueAt(selectedRowIndex,0).toString());
        jTextField_pId.setText(jTable_client1.getValueAt(selectedRowIndex,1).toString());
        jTextField_cId.setText(jTable_client1.getValueAt(selectedRowIndex,2).toString());
        jTextField_price.setText(jTable_client1.getValueAt(selectedRowIndex,3).toString());
        jComboBox1.setSelectedItem(jTable_client1.getValueAt(selectedRowIndex,5).toString());
        Date saleDate;
        try {
            saleDate = new SimpleDateFormat("yyyy-MM-dd").parse(jTable_client1.getValueAt(selectedRowIndex, 4).toString());
            jDateChooser1.setDate(saleDate);
        } catch (ParseException ex) {
            Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_jTable_client1MouseClicked

    private void jButton_add_propertyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_add_propertyActionPerformed
        // TODO add your handling code here:
                   PROPERTY propertyform = null;
                  propertyform = new PROPERTY();
                   // this.setVisible(false);
                    propertyform.setVisible(true);
                    propertyform.pack();
                    propertyform.setLocationRelativeTo(null);
                    propertyform.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton_add_propertyActionPerformed

    private void jButton_add_clientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_add_clientActionPerformed
        // TODO add your handling code here:
                   CLIENT clientform = null;
        try {
            clientform = new CLIENT();
        } catch (SQLException ex) {
            Logger.getLogger(MAIN_APP.class.getName()).log(Level.SEVERE, null, ex);
        }
                   // this.setVisible(false);
                    clientform.setVisible(true);
                    clientform.pack();
                    clientform.setLocationRelativeTo(null);
                    clientform.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton_add_clientActionPerformed

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
            java.util.logging.Logger.getLogger(SALES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SALES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SALES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SALES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SALES().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(SALES.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_add;
    private javax.swing.JButton jButton_add_client;
    private javax.swing.JButton jButton_add_property;
    private javax.swing.JButton jButton_edit;
    private javax.swing.JButton jButton_refresh;
    private javax.swing.JButton jButton_remove;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_client;
    private javax.swing.JLabel jLabel_date;
    private javax.swing.JLabel jLabel_price;
    private javax.swing.JLabel jLabel_price1;
    private javax.swing.JLabel jLabel_property_Id;
    private javax.swing.JLabel jLabel_prtype;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable_client;
    private javax.swing.JTable jTable_client1;
    private javax.swing.JTable jTable_property;
    private javax.swing.JTextField jTextField_cId;
    private javax.swing.JTextField jTextField_id;
    private javax.swing.JTextField jTextField_pId;
    private javax.swing.JTextField jTextField_price;
    // End of variables declaration//GEN-END:variables
}
