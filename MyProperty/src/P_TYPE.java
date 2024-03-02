/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.mysql.cj.xdevapi.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
 /*
 * @author shoumikbarmanpolok
 */
public class P_TYPE {
    
    
    private int id;
    private String name;
    private String description;
    
    public Integer getId()
    {
        return id;
        
    }
    
    public void setId(Integer Id)
    {
        this.id=Id;
    }
    
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String NAME)
    {
        this.name=NAME;
    }
    
    public String getDescription()
    {
        return this.description;
    }
    
    public void setDescription(String DESCRIPTION)
    {
        this.description=DESCRIPTION;
    }
    
    public P_TYPE()
    {
        
    }
    
    public P_TYPE(Integer ID,String NAME,String DESCRIPTION)
    {
        this.id=ID;
        this.name=NAME;
        this.description=DESCRIPTION;
    }
    
    public boolean execTypeQuery(String queryType, P_TYPE type) throws SQLException {
        PreparedStatement ps;

        if (queryType.equals("add")) {
            try {
                ps = DATABASE.getTheConnection().prepareStatement("INSERT INTO `property_type` (`name`, `description`) VALUES (?, ?)");
                // Your code to set parameters and execute the statement goes here.
                ps.setString(1,type.getName());
                ps.setString(2,type.getDescription());
                
                return (ps.executeUpdate() > 0);
                
            } catch (SQLException ex) {
                Logger.getLogger(P_TYPE.class.getName()).log(Level.SEVERE, null, ex);
                return false; // Return false in case of an exception.
            }
        }
        
       else if (queryType.equals("edit")) {
    try {
        ps = DATABASE.getTheConnection().prepareStatement("UPDATE `property_type` SET `name`=?, `description`=? WHERE `id` = ?");
        // Your code to set parameters and execute the statement goes here.
        ps.setString(1, type.getName());
        ps.setString(2, type.getDescription());
        ps.setInt(3, type.getId());

        return (ps.executeUpdate() > 0);

    } catch (SQLException ex) {
        Logger.getLogger(P_TYPE.class.getName()).log(Level.SEVERE, null, ex);
        return false; // Return false in case of an exception.
    }
}

        
        else  if (queryType.equals("remove")) {
            try {
                ps = DATABASE.getTheConnection().prepareStatement("DELETE FROM `property_type` WHERE `id` = ?");
                // Your code to set parameters and execute the statement goes here.
        
                ps.setInt(1,type.getId());
                
                return (ps.executeUpdate() > 0);
                
            } catch (SQLException ex) {
                Logger.getLogger(P_TYPE.class.getName()).log(Level.SEVERE, null, ex);
                return false; // Return false in case of an exception.
            }
        }
        
        else
        {
            JOptionPane.showMessageDialog(null, "Enter The Correct Query(add,edit,remove)","Invalid Operation",2);
            return false;
        }
        
        
    }
    public HashMap<String, Integer> getTypesMap() {
        HashMap<String, Integer> map = new HashMap<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DATABASE.getTheConnection(); // Ensure that you have a valid connection here.
            ps = connection.prepareStatement("SELECT * FROM `property_type`");
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                map.put(name, id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(P_TYPE.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                // Handle the exception or log it.
                 Logger.getLogger(P_TYPE.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return map;
    }
    
     public HashMap<Integer, String> getTypesMap1() {
        HashMap<Integer, String> map1 = new HashMap<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DATABASE.getTheConnection(); // Ensure that you have a valid connection here.
            ps = connection.prepareStatement("SELECT * FROM `property_type`");
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                map1.put(id, name);
            }
        } catch (SQLException ex) {
            Logger.getLogger(P_TYPE.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                // Handle the exception or log it.
                 Logger.getLogger(P_TYPE.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return map1;
    }

       public P_TYPE getTypeById(Integer id)
       {
        PreparedStatement ps ;
        ResultSet rs ;
        
        P_TYPE type=new P_TYPE();
        
        try{
            ps = DATABASE.getTheConnection().prepareStatement("SELECT * FROM `property_type` WHERE `id`=?");
            ps.setInt(1,id);
            rs = ps.executeQuery();
           // type=new P_TYPE();
            
            if(rs.next())
            {
                type.setId(id);
                type.setName(rs.getString(2));
                type.setDescription(rs.getString(3));
            }
        }
         catch (SQLException ex) {
                // Handle the exception or log it.
                 Logger.getLogger(P_TYPE.class.getName()).log(Level.SEVERE, null, ex);
            }
        return type;
       }

}
