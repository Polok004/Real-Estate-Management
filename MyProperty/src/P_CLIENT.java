/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
/**
 *
 * @author shoumikbarmanpolok
 */
public class P_CLIENT {
    private int id;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private String address;
    
    public Integer getId()
    {
        return id;
        
    }
    
    public void setId(Integer Id)
    {
        this.id=Id;
    }
    
    
    public String getFname()
    {
        return this.firstname;
    }
    
    public void setFname(String FNAME)
    {
        this.firstname=FNAME;
    }
    public String getLname()
    {
        return this.lastname;
    }
    
    public void setLname(String LNAME)
    {
        this.lastname=LNAME;
    }
    public String getPhone()
    {
        return this.phone;
    }
    
    public void setPhone(String PHONE)
    {
        this.phone=PHONE;
    }
    public String getEmail()
    {
        return this.email;
    }
    
    public void setEmail(String EMAIL)
    {
        this.email=EMAIL;
    }
    public String getAddress()
    {
        return this.address;
    }
    
    public void setAddress(String ADDRESS)
    {
        this.address=ADDRESS;
    }
    
     public P_CLIENT()
    {
        
    }
    
    public P_CLIENT(Integer ID,String FNAME,String LNAME,String PHONE,String EMAIL,String ADDRESS)
    {
        this.id=ID;
        this.firstname=FNAME;
        this.lastname=LNAME;
        this.phone=PHONE;
        this.email=EMAIL;
        this.address=ADDRESS;
    }
    
    
    public boolean addNewClient(P_CLIENT client) throws SQLException {
    PreparedStatement ps;
    
    String addQuery = "INSERT INTO `property_client` (`fname`, `lname`, `phone`, `email`, `address`) VALUES (?, ?, ?, ?, ?)";
    
    try {
        ps = DATABASE.getTheConnection().prepareStatement(addQuery);
        ps.setString(1, client.getFname());
        ps.setString(2, client.getLname());
        ps.setString(3, client.getPhone());
        ps.setString(4, client.getEmail());
        ps.setString(5, client.getAddress());
        
        return (ps.executeUpdate() > 0);
    } catch (SQLException ex) {
        Logger.getLogger(P_CLIENT.class.getName()).log(Level.SEVERE, null, ex);
        return false; // Return false in case of an exception.
    }
}
      public boolean editClientData(P_CLIENT client)
      {
          PreparedStatement ps;
    
    String editQuery = "UPDATE `property_client` SET `fname`= ?,`lname`=? ,`phone`=?,`email`=?,`address`=? WHERE `id`=?";
    
    try {
        ps = DATABASE.getTheConnection().prepareStatement(editQuery);
        ps.setString(1, client.getFname());
        ps.setString(2, client.getLname());
        ps.setString(3, client.getPhone());
        ps.setString(4, client.getEmail());
        ps.setString(5, client.getAddress());
        ps.setInt(6,client.getId());
        
        return (ps.executeUpdate() > 0);
    } catch (SQLException ex) {
        Logger.getLogger(P_CLIENT.class.getName()).log(Level.SEVERE, null, ex);
        return false; // Return false in case of an exception.
    }
          
}
      
      public boolean deleteClient(int clientId) {
    PreparedStatement ps;
    String deleteQuery = "DELETE FROM `property_client` WHERE `id`=?";
    
    try {
        ps = DATABASE.getTheConnection().prepareStatement(deleteQuery);
        ps.setInt(1, clientId); // Set the first parameter to the owner's ID.
        
        return (ps.executeUpdate() > 0);
    } catch (SQLException ex) {
        Logger.getLogger(P_CLIENT.class.getName()).log(Level.SEVERE, null, ex);
        return false; // Return false in case of an exception.
    }
}

     public ArrayList<P_CLIENT> clientList() throws SQLException {
    ArrayList<P_CLIENT> list = new ArrayList<>();
    PreparedStatement st;
    ResultSet rs;

    String selectQuery = "SELECT * FROM `property_client`"; // Changed to SELECT

    try {
        st = DATABASE.getTheConnection().prepareStatement(selectQuery); // Use prepareStatement here
        rs = st.executeQuery(); // Use executeQuery here
        P_CLIENT client;
        while (rs.next()) {
            client = new P_CLIENT(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6)
            );
            list.add(client);
        }
    } catch (SQLException ex) {
        Logger.getLogger(P_CLIENT.class.getName()).log(Level.SEVERE, null, ex);
    }

    return list;
}


  
   
     
      
}
