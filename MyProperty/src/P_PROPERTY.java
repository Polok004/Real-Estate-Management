
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author shoumikbarmanpolok
 */
public class P_PROPERTY {
    private int id;
    private int type;
    private int size;
    private int ownerId;
    private String price;
    private String address;
    private int bedrooms;
    private int bathrooms;
    private int age;
    private boolean balcone;
    private boolean pool;
    private boolean backyard;
    private boolean garage;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isBalcone() {
        return balcone;
    }

    public void setBalcone(boolean balcone) {
        this.balcone = balcone;
    }

    public boolean isPool() {
        return pool;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }

    public boolean isBackyard() {
        return backyard;
    }

    public void setBackyard(boolean backyard) {
        this.backyard = backyard;
    }

    public boolean isGarage() {
        return garage;
    }

    public void setGarage(boolean garage) {
        this.garage = garage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
     public P_PROPERTY()
    {
        
    }
    
    public P_PROPERTY(int ID,int TYPE,int SIZE,int OWNER_ID,String PRICE,String ADDRESS,int BEDROOMS,int BATHROOMS,int AGE,boolean BALCONE,boolean POOL,boolean BACKYARD,boolean GARAGE,String DESCRIPTION)
    {
        this.id=ID;
        this.type=TYPE;
        this.size=SIZE;
        this.ownerId=OWNER_ID;
        this.price=PRICE;
        this.address=ADDRESS;
        this.bathrooms=BATHROOMS;
        this.bedrooms=BEDROOMS;
        this.age=AGE;
        this.description=DESCRIPTION;
        this.balcone=BALCONE;
        this.pool=POOL;
        this.backyard=BACKYARD;
        this.garage=GARAGE;
        
    }
    public boolean addNewProperty(P_PROPERTY property) throws SQLException
    {
         PreparedStatement ps;
    
    String addQuery = "INSERT INTO `the_property`(`type`, `square_feet`, `ownerId`, `price`, `address`, `bedrooms`, `bathrooms`, `age`, `balcone`, `pool`, `backyard`, `garage`, `description`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        ps=DATABASE.getTheConnection().prepareStatement(addQuery);
        ps.setInt(1,property.getType());
        ps.setInt(2,property.getSize());
        ps.setInt(3,property.getOwnerId());
        ps.setString(4,property.getPrice());
        ps.setString(5,property.getAddress());
        ps.setInt(6,property.getBedrooms());
        ps.setInt(7,property.getBathrooms());
        ps.setInt(8,property.getAge());
        ps.setBoolean(9,property.isBalcone());
        ps.setBoolean(10,property.isPool());
        ps.setBoolean(11,property.isBackyard());
        ps.setBoolean(12,property.isGarage());
        ps.setString(13,property.getDescription());
                     
        return (ps.executeUpdate()>0);
    }
    
    
    public boolean editNewProperty(P_PROPERTY property) throws SQLException {
    PreparedStatement ps;

    String editQuery = "UPDATE `the_property` SET `type`=?, `square_feet`=?, `ownerId`=?, `price`=?, `address`=?, `bedrooms`=?, `bathrooms`=?, `age`=?, `balcone`=?, `pool`=?, `backyard`=?, `garage`=?, `description`=? WHERE `id`=?";

    ps = DATABASE.getTheConnection().prepareStatement(editQuery);
    ps.setInt(1, property.getType());
    ps.setInt(2, property.getSize());
    ps.setInt(3, property.getOwnerId());
    ps.setString(4, property.getPrice());
    ps.setString(5, property.getAddress());
    ps.setInt(6, property.getBedrooms());
    ps.setInt(7, property.getBathrooms());
    ps.setInt(8, property.getAge());
    ps.setBoolean(9, property.isBalcone());
    ps.setBoolean(10, property.isPool());
    ps.setBoolean(11, property.isBackyard());
    ps.setBoolean(12, property.isGarage());
    ps.setString(13, property.getDescription());
    ps.setInt(14, property.getId());

    return (ps.executeUpdate() > 0);
}

    
    public boolean removeProperty(int propertyId)
    {
         PreparedStatement ps;
    String deleteQuery = "DELETE FROM `the_property` WHERE `id`=?";
    
    try {
        ps = DATABASE.getTheConnection().prepareStatement(deleteQuery);
        ps.setInt(1, propertyId); // Set the first parameter to the owner's ID.
        
        return (ps.executeUpdate() > 0);
    } catch (SQLException ex) {
        Logger.getLogger(P_PROPERTY.class.getName()).log(Level.SEVERE, null, ex);
        return false; // Return false in case of an exception.
    }
    }
    
    
    public P_PROPERTY findProperty(int propertyId) throws SQLException
    {
         PreparedStatement ps;
         ResultSet rs;
        
         String searchQuery="SELECT * FROM `the_property` WHERE `id` = ? ";
          P_PROPERTY property = null;
         try{
             
             ps=DATABASE.getTheConnection().prepareStatement(searchQuery);
              ps.setInt(1,propertyId);
             rs=ps.executeQuery();
             
             if(rs.next())
             {
                 // `id`, `type`, `square_feet`, `ownerId`, `price`, `address`, `bedrooms`, `bathrooms`, `age`, `balcone`, `pool`, `backyard`, `garage`, `description` FROM `the_property`
                 property=new P_PROPERTY(rs.getInt("id"),rs.getInt("type"),rs.getInt("square_feet"),
                          rs.getInt("ownerId"),rs.getString("price"),rs.getString("address"),
                         rs.getInt("bedrooms"),rs.getInt("bathrooms"),rs.getInt("age"),
                         rs.getBoolean("balcone"),rs.getBoolean("pool"),rs.getBoolean("backyard"),
                         rs.getBoolean("garage")
                         ,rs.getString("description"));
             }
             
             return property;
             
             
         }catch (SQLException ex) {
        Logger.getLogger(P_PROPERTY.class.getName()).log(Level.SEVERE, null, ex);
       
    }
        return property;
    }
    
    public ArrayList<P_PROPERTY> propertiesList()
    {   
        
        ArrayList<P_PROPERTY> list=new ArrayList<P_PROPERTY>();
      PreparedStatement st;
    ResultSet rs;

    String selectQuery = "SELECT * FROM `the_property`"; // Changed to SELECT

    try {
        st = DATABASE.getTheConnection().prepareStatement(selectQuery); // Use prepareStatement here
        rs = st.executeQuery(); // Use executeQuery here
        P_PROPERTY property;
        while (rs.next()) {
              property=new P_PROPERTY(rs.getInt("id"),rs.getInt("type"),rs.getInt("square_feet"),
                          rs.getInt("ownerId"),rs.getString("price"),rs.getString("address"),
                         rs.getInt("bedrooms"),rs.getInt("bathrooms"),rs.getInt("age"),
                         rs.getBoolean("balcone"),rs.getBoolean("pool"),rs.getBoolean("backyard"),
                         rs.getBoolean("garage")
                         ,rs.getString("description"));
            list.add(property);
        }
    } catch (SQLException ex) {
        Logger.getLogger(P_PROPERTY.class.getName()).log(Level.SEVERE, null, ex);
    }

    return list;
    }
    
    
    public ArrayList<P_PROPERTY> propertiesListByType(int typeid)
    {   
        
    ArrayList<P_PROPERTY> list=new ArrayList<P_PROPERTY>();
    PreparedStatement ps;
    ResultSet rs;

    String selectQuery = "SELECT * FROM `the_property` WHERE `type`=?"; // Changed to SELECT

    try {
        ps = DATABASE.getTheConnection().prepareStatement(selectQuery); // Use prepareStatement here
        ps.setInt(1, typeid);
        rs = ps.executeQuery(); // Use executeQuery here
        P_PROPERTY property;
        while (rs.next()) {
              property=new P_PROPERTY(rs.getInt("id"),rs.getInt("type"),rs.getInt("square_feet"),
                          rs.getInt("ownerId"),rs.getString("price"),rs.getString("address"),
                         rs.getInt("bedrooms"),rs.getInt("bathrooms"),rs.getInt("age"),
                         rs.getBoolean("balcone"),rs.getBoolean("pool"),rs.getBoolean("backyard"),
                         rs.getBoolean("garage")
                         ,rs.getString("description"));
            list.add(property);
        }
    } catch (SQLException ex) {
        Logger.getLogger(P_PROPERTY.class.getName()).log(Level.SEVERE, null, ex);
    }

    return list;
    }
    
    public boolean addImage(int propertyId,String the_image_path) throws SQLException
    {
        FileInputStream propertyImage ;
        try{
        try {
            PreparedStatement ps;
            String addQuery = "INSERT INTO `property-images`(`property_id`, `the_image`) VALUES (?,?)";
            propertyImage = new FileInputStream(new File(the_image_path));
            ps=DATABASE.getTheConnection().prepareStatement(addQuery);
            ps.setInt(1,propertyId);
            ps.setBinaryStream(2, propertyImage);
            
            return (ps.executeUpdate()>0);
        } catch (FileNotFoundException ex) {
           // Logger.getLogger(P_PROPERTY.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null,ex.getMessage()+"Invalid File","Image",2);
            return false;
        } 
        }catch (SQLException ex) {
        Logger.getLogger(P_PROPERTY.class.getName()).log(Level.SEVERE, null, ex);
        return false;
    }
    }
    
    public HashMap<byte[],Integer> propertyImagesList(int propertyId)
    {   
        
        HashMap<byte[],Integer> list=new HashMap<byte[],Integer>();
      PreparedStatement ps;
    ResultSet rs;

    String selectQuery = "SELECT * FROM `property-images` WHERE `property_id`=?"; // Changed to SELECT

    try {
        ps = DATABASE.getTheConnection().prepareStatement(selectQuery); // Use prepareStatement here
        ps.setInt(1, propertyId);
        rs = ps.executeQuery(); // Use executeQuery here
 
        while (rs.next()) {
              list.put(rs.getBytes("the_image"), rs.getInt("id"));
        }
    } catch (SQLException ex) {
        Logger.getLogger(P_PROPERTY.class.getName()).log(Level.SEVERE, null, ex);
    }

    return list;
    }
    
     public byte[] getImageById(int imageId)
    {   
        
      // byte[] image;
      PreparedStatement ps;
    ResultSet rs;

    String selectQuery = "SELECT `the_image` FROM `property-images` WHERE `id`=?"; // Changed to SELECT

    try {
        ps = DATABASE.getTheConnection().prepareStatement(selectQuery); // Use prepareStatement here
        ps.setInt(1, imageId);
        rs = ps.executeQuery(); // Use executeQuery here
 
        if (rs.next()) {
             return rs.getBytes("the_image");
        }
        else
        {
            return null;
        }
    } catch (SQLException ex) {
        Logger.getLogger(P_PROPERTY.class.getName()).log(Level.SEVERE, null, ex);
        return null;
    }

    
    }
     
     public boolean removePropertyImage(int imageId)
    {   
        
      // byte[] image;
      PreparedStatement ps;
    ResultSet rs;

    String deleteQuery = "DELETE FROM `property-images` WHERE `id`=?"; // Changed to SELECT

    try {
        ps = DATABASE.getTheConnection().prepareStatement(deleteQuery); // Use prepareStatement here
        ps.setInt(1, imageId);
       return (ps.executeUpdate()>0);
    } catch (SQLException ex) {
        Logger.getLogger(P_PROPERTY.class.getName()).log(Level.SEVERE, null, ex);
        return false;
    }   

    
 }
     
     public ArrayList<P_PROPERTY> propertiesListByOwner(int ownerId)
    {   
        
        ArrayList<P_PROPERTY> list=new ArrayList<>();
      PreparedStatement ps;
    ResultSet rs;

    String selectQuery = "SELECT * FROM `the_property` WHERE `ownerId`=?"; // Changed to SELECT

    try {
        ps = DATABASE.getTheConnection().prepareStatement(selectQuery); // Use prepareStatement here
        ps.setInt(1, ownerId);
        rs = ps.executeQuery(); // Use executeQuery here
        P_PROPERTY property;
        while (rs.next()) {
              property=new P_PROPERTY(rs.getInt("id"),rs.getInt("type"),rs.getInt("square_feet"),
                          rs.getInt("ownerId"),rs.getString("price"),rs.getString("address"),
                         rs.getInt("bedrooms"),rs.getInt("bathrooms"),rs.getInt("age"),
                         rs.getBoolean("balcone"),rs.getBoolean("pool"),rs.getBoolean("backyard"),
                         rs.getBoolean("garage")
                         ,rs.getString("description"));
            list.add(property);
        }
    } catch (SQLException ex) {
        Logger.getLogger(P_PROPERTY.class.getName()).log(Level.SEVERE, null, ex);
    }

    return list;
    }
    
      public String getPropertyTypeById(int propertyId) {
        PreparedStatement ps;
        ResultSet rs;

        String selectQuery = "SELECT `type` FROM `the_property` WHERE `id`=?";

        try {
            ps = DATABASE.getTheConnection().prepareStatement(selectQuery);
            ps.setInt(1, propertyId);
            rs = ps.executeQuery();

            if (rs.next()) {
                // Assuming that the property type is stored as a String in the database.
                return rs.getString("type");
            } else {
                return null; // Property not found for the given ID.
            }
        } catch (SQLException ex) {
            Logger.getLogger(P_PROPERTY.class.getName()).log(Level.SEVERE, null, ex);
            return null; // Return null in case of an exception.
        }
    }
     
     
}