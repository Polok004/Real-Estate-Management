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
public class P_OWNER {
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
    
     public P_OWNER()
    {
        
    }
    
    public P_OWNER(Integer ID,String FNAME,String LNAME,String PHONE,String EMAIL,String ADDRESS)
    {
        this.id=ID;
        this.firstname=FNAME;
        this.lastname=LNAME;
        this.phone=PHONE;
        this.email=EMAIL;
        this.address=ADDRESS;
    }
    
    
    public boolean addNewOwner(P_OWNER owner) throws SQLException {
    PreparedStatement ps;
    
    String addQuery = "INSERT INTO `property_own` (`fname`, `lname`, `phone`, `email`, `address`) VALUES (?, ?, ?, ?, ?)";
    
    try {
        ps = DATABASE.getTheConnection().prepareStatement(addQuery);
        ps.setString(1, owner.getFname());
        ps.setString(2, owner.getLname());
        ps.setString(3, owner.getPhone());
        ps.setString(4, owner.getEmail());
        ps.setString(5, owner.getAddress());
        
        return (ps.executeUpdate() > 0);
    } catch (SQLException ex) {
        Logger.getLogger(P_TYPE.class.getName()).log(Level.SEVERE, null, ex);
        return false; // Return false in case of an exception.
    }
}
      public boolean editOwnerData(P_OWNER owner)
      {
          PreparedStatement ps;
    
    String editQuery = "UPDATE `property_own` SET `fname`= ?,`lname`=? ,`phone`=?,`email`=?,`address`=? WHERE `id`=?";
    
    try {
        ps = DATABASE.getTheConnection().prepareStatement(editQuery);
        ps.setString(1, owner.getFname());
        ps.setString(2, owner.getLname());
        ps.setString(3, owner.getPhone());
        ps.setString(4, owner.getEmail());
        ps.setString(5, owner.getAddress());
        ps.setInt(6,owner.getId());
        
        return (ps.executeUpdate() > 0);
    } catch (SQLException ex) {
        Logger.getLogger(P_TYPE.class.getName()).log(Level.SEVERE, null, ex);
        return false; // Return false in case of an exception.
    }
          
}
      
      public boolean deleteOwner(int ownerId) {
    PreparedStatement ps;
    String deleteQuery = "DELETE FROM `property_own` WHERE `id`=?";
    
    try {
        ps = DATABASE.getTheConnection().prepareStatement(deleteQuery);
        ps.setInt(1, ownerId); // Set the first parameter to the owner's ID.
        
        return (ps.executeUpdate() > 0);
    } catch (SQLException ex) {
        Logger.getLogger(P_TYPE.class.getName()).log(Level.SEVERE, null, ex);
        return false; // Return false in case of an exception.
    }
}

     public ArrayList<P_OWNER> ownerList() throws SQLException {
    ArrayList<P_OWNER> list = new ArrayList<>();
    PreparedStatement st;
    ResultSet rs;

    String selectQuery = "SELECT * FROM `property_own`"; // Changed to SELECT

    try {
        st = DATABASE.getTheConnection().prepareStatement(selectQuery); // Use prepareStatement here
        rs = st.executeQuery(); // Use executeQuery here
        P_OWNER owner;
        while (rs.next()) {
            owner = new P_OWNER(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6)
            );
            list.add(owner);
        }
    } catch (SQLException ex) {
        Logger.getLogger(P_TYPE.class.getName()).log(Level.SEVERE, null, ex);
    }

    return list;
}


  
   
     
      
}
