
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class P_REGISTER {
    private int id;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private String address;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
     public P_REGISTER()
    {
        
    }
    
    public P_REGISTER(Integer ID,String FNAME,String LNAME,String EMAIL,String PASSWORD,String PHONE,String ADDRESS)
    {
        this.id=ID;
        this.firstname=FNAME;
        this.lastname=LNAME;
        this.phone=PHONE;
        this.email=EMAIL;
        this.address=ADDRESS;
        this.password=PASSWORD;
        
    }
    
       public P_REGISTER(Integer ID,String FNAME,String LNAME,String EMAIL,String PHONE,String ADDRESS)
    {
        this.id=ID;
        this.firstname=FNAME;
        this.lastname=LNAME;
        this.phone=PHONE;
        this.email=EMAIL;
        this.address=ADDRESS;
      
        
    }
    
    
  /*  public boolean addNewAgent(P_REGISTER agent) throws SQLException {
    PreparedStatement ps;
    
    String addQuery = "INSERT INTO `users`( `username`, `password`, `firstname`, `lastname`, `phone`, `Address`) VALUES (?,?,?,?,?,?)";
    //INSERT INTO `users`( `username`, `password`, `firstname`, `lastname`, `phone`, `Address`) VALUES (?,?,?,?,?,?)
    try {
        ps = DATABASE.getTheConnection().prepareStatement(addQuery);
        ps.setString(1, agent.getEmail());
        ps.setString(2, agent.getPassword());
        ps.setString(3, agent.getFirstname());
        ps.setString(4, agent.getLastname());
        ps.setString(5, agent.getPhone());
        ps.setString(6, agent.getAddress());
        
        return (ps.executeUpdate() > 0);
    } catch (SQLException ex) {
        Logger.getLogger(P_REGISTER.class.getName()).log(Level.SEVERE, null, ex);
        return false; // Return false in case of an exception.
    }
}*/
       public boolean addNewAgent(P_REGISTER agent) throws SQLException {
    PreparedStatement ps;
    ResultSet rs;

    // Check if the username (email) already exists
    String checkQuery = "SELECT * FROM `users` WHERE `username`=?";
    try {
        ps = DATABASE.getTheConnection().prepareStatement(checkQuery);
        ps.setString(1, agent.getEmail());
        rs = ps.executeQuery();

        if (rs.next()) {
            // Username (email) already exists
            JOptionPane.showMessageDialog(null, "Username  already exists. Please choose a different username.", "Add Agent", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    } catch (SQLException ex) {
        Logger.getLogger(P_REGISTER.class.getName()).log(Level.SEVERE, null, ex);
        return false; // Return false in case of an exception.
    }

    // If username doesn't exist, proceed with account creation
    String addQuery = "INSERT INTO `users`(`username`, `password`, `firstname`, `lastname`, `phone`, `Address`) VALUES (?,?,?,?,?,?)";
    try {
        ps = DATABASE.getTheConnection().prepareStatement(addQuery);
        ps.setString(1, agent.getEmail());
        ps.setString(2, agent.getPassword());
        ps.setString(3, agent.getFirstname());
        ps.setString(4, agent.getLastname());
        ps.setString(5, agent.getPhone());
        ps.setString(6, agent.getAddress());

        return (ps.executeUpdate() > 0);
    } catch (SQLException ex) {
        Logger.getLogger(P_REGISTER.class.getName()).log(Level.SEVERE, null, ex);
        return false; // Return false in case of an exception.
    }
}

    
    
     public HashMap<String, Integer> getAgentMap() {
        HashMap<String, Integer> map = new HashMap<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DATABASE.getTheConnection(); // Ensure that you have a valid connection here.SELECT * FROM `users`
            ps = connection.prepareStatement("SELECT * FROM `users`");
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("username");
                map.put(name, id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(P_REGISTER.class.getName()).log(Level.SEVERE, null, ex);
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
                 Logger.getLogger(P_REGISTER.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return map;
    }
    
    public ArrayList<P_REGISTER> agentList() throws SQLException {
    ArrayList<P_REGISTER> list = new ArrayList<>();
    PreparedStatement st;
    ResultSet rs;

    String selectQuery = "SELECT * FROM `users`"; // Changed to SELECT

    try {
        st = DATABASE.getTheConnection().prepareStatement(selectQuery); // Use prepareStatement here
        rs = st.executeQuery(); // Use executeQuery here
        P_REGISTER agent;
        while (rs.next()) {
            agent = new P_REGISTER(
                rs.getInt(1),
                rs.getString(4),
                rs.getString(5),
                rs.getString(2),
                rs.getString(3),
                rs.getString(6),
                rs.getString(7)
            );
            list.add(agent);
        }
    } catch (SQLException ex) {
        Logger.getLogger(P_REGISTER.class.getName()).log(Level.SEVERE, null, ex);
    }

    return list;
      }
    
    
  public boolean editAgentData(P_REGISTER agent) {
    PreparedStatement ps;

    String editQuery = "UPDATE `users` SET `username`=?, `password`=?, `firstname`=?, `lastname`=?, `phone`=?, `Address`=? WHERE `id`=?";
    
    try {
        ps = DATABASE.getTheConnection().prepareStatement(editQuery);
        ps.setString(1, agent.getEmail()); // username
        ps.setString(2, agent.getPassword());
        ps.setString(3, agent.getFirstname());
        ps.setString(4, agent.getLastname());
        ps.setString(5, agent.getPhone());
        ps.setString(6, agent.getAddress());
        ps.setInt(7, agent.getId());
        
        return (ps.executeUpdate() > 0);
    } catch (SQLException ex) {
        Logger.getLogger(P_REGISTER.class.getName()).log(Level.SEVERE, null, ex);
        return false; // Return false in case of an exception.
    }
}


      
      public String getPasswordById(int userId) {
    String password = null;
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        connection = DATABASE.getTheConnection();
        String selectQuery = "SELECT `password` FROM `users` WHERE `id`=?";
        ps = connection.prepareStatement(selectQuery);
        ps.setInt(1, userId);
        rs = ps.executeQuery();

        if (rs.next()) {
            password = rs.getString("password");
        }
    } catch (SQLException ex) {
        Logger.getLogger(P_REGISTER.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(P_REGISTER.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    return password;
}
      
         public boolean deleteAgent(int ownerId) {
    PreparedStatement ps;
    String deleteQuery = "DELETE FROM `users` WHERE `id`=?";
    
    try {
        ps = DATABASE.getTheConnection().prepareStatement(deleteQuery);
        ps.setInt(1, ownerId); // Set the first parameter to the owner's ID.
        
        return (ps.executeUpdate() > 0);
    } catch (SQLException ex) {
        Logger.getLogger(P_REGISTER.class.getName()).log(Level.SEVERE, null, ex);
        return false; // Return false in case of an exception.
    }
         }
         
         
     public boolean validatePassword() {
    try {
        String query = "SELECT `password` FROM `users` WHERE `id` = ?";
        PreparedStatement ps = DATABASE.getTheConnection().prepareStatement(query);
        ps.setInt(1, this.getId());
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            String storedPassword = rs.getString("password");
            return this.getPassword().equals(storedPassword);
        } else {
            return false; // Agent with the given ID not found.
        }
    } catch (SQLException ex) {
        Logger.getLogger(P_REGISTER.class.getName()).log(Level.SEVERE, null, ex);
        return false; // Return false in case of an exception.
    }
}
     
     public String getPasswordByUsername(String username) {
    String password = null;
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        connection = DATABASE.getTheConnection();
        String selectQuery = "SELECT `password` FROM `users` WHERE `username`=?";
        ps = connection.prepareStatement(selectQuery);
        ps.setString(1, username);
        rs = ps.executeQuery();

        if (rs.next()) {
            password = rs.getString("password");
        }
    } catch (SQLException ex) {
        Logger.getLogger(P_REGISTER.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(P_REGISTER.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    return password;
}


}
