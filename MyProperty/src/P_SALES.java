
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author shoumikbarmanpolok
 */
public class P_SALES {
    private int id;
    private int propertyId;
    private int clientId;
    private String finalPrice;
    private String sellingDate;
    private String agent;

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }
    
    public P_SALES()
    {
        
    }
    public P_SALES(Integer ID,Integer PROPERTY_ID,Integer CLIENT_ID,String FINAL_PRICE,String SELLING_DATE,String AGENT)
    {
        this.id=ID;
        this.propertyId=PROPERTY_ID;
        this.clientId=CLIENT_ID;
        this.finalPrice=FINAL_PRICE;
        this.sellingDate=SELLING_DATE;
        this.agent=AGENT;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(String finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getSellingDate() {
        return sellingDate;
    }

    public void setSellingDate(String sellingDate) {
        this.sellingDate = sellingDate;
    }
    
    
    public boolean addNewSales(P_SALES sale) throws SQLException {
    PreparedStatement ps;
    
    String addQuery = "INSERT INTO `sale`(`property_id`, `client_id`, `final_price`, `sale_date`,`agent`) VALUES (?,?,?,?,?)";
    
    try {
        ps = DATABASE.getTheConnection().prepareStatement(addQuery);
        ps.setInt(1, sale.getPropertyId());
        ps.setInt(2, sale.getClientId());
        ps.setString(3, sale.getFinalPrice());
        ps.setString(4, sale.getSellingDate());
        ps.setString(5, sale.getAgent());
        
        return (ps.executeUpdate() > 0);
    } catch (SQLException ex) {
        Logger.getLogger(P_SALES.class.getName()).log(Level.SEVERE, null, ex);
        return false; // Return false in case of an exception.
    }
}

     public boolean editSaleData(P_SALES sale) throws ParseException {
    PreparedStatement ps;
    
    //String editQuery = "UPDATE `sale` SET `property_id`=?, `client_id`=?, `final_price`=?, `sale_date`=?,, `agent`=? WHERE `id`=?";
    String editQuery = "UPDATE `sale` SET `property_id`=?, `client_id`=?, `final_price`=?, `sale_date`=?, `agent`=? WHERE `id`=?";
    try {
        ps = DATABASE.getTheConnection().prepareStatement(editQuery);
        ps.setInt(1, sale.getPropertyId());
        ps.setInt(2, sale.getClientId());
        ps.setString(3, sale.getFinalPrice());
        
        // Format the date to 'YYYY-MM-DD' before setting it in the prepared statement.
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date parsedDate = sdf.parse(sale.getSellingDate());
        String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(parsedDate);
        
        ps.setString(4, formattedDate);
        ps.setInt(6, sale.getId());
        ps.setString(5, sale.getAgent());
        
        return (ps.executeUpdate() > 0);
    } catch (SQLException | ParseException ex) {
        Logger.getLogger(P_SALES.class.getName()).log(Level.SEVERE, null, ex);
        return false; // Return false in case of an exception.
    }
}

      
      public boolean deleteSale(int saleId) {
    PreparedStatement ps;
    String deleteQuery = "DELETE FROM `sale` WHERE `id`=?";
    
    try {
        ps = DATABASE.getTheConnection().prepareStatement(deleteQuery);
        ps.setInt(1, saleId); // Set the first parameter to the owner's ID.
        
        return (ps.executeUpdate() > 0);
    } catch (SQLException ex) {
        Logger.getLogger(P_SALES.class.getName()).log(Level.SEVERE, null, ex);
        return false; // Return false in case of an exception.
    }
}
      
      
    public ArrayList<P_SALES> clientList() throws SQLException {
    ArrayList<P_SALES> list = new ArrayList<>();
    PreparedStatement st;
    ResultSet rs;

    String selectQuery = "SELECT * FROM `sale`"; // Changed to SELECT

    try {
        st = DATABASE.getTheConnection().prepareStatement(selectQuery); // Use prepareStatement here
        rs = st.executeQuery(); // Use executeQuery here
        P_SALES sales;
        while (rs.next()) {
            sales = new P_SALES(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6)  
            );
            list.add(sales);
        }
    } catch (SQLException ex) {
        Logger.getLogger(P_SALES.class.getName()).log(Level.SEVERE, null, ex);
    }

    return list;
}
     public boolean propertyIsNotSold(int propertyId) throws SQLException {
        PreparedStatement ps;
        ResultSet rs;

        // Query to check if the property is already sold
        String checkQuery = "SELECT * FROM `sale` WHERE `property_id` = ?";

        try {
            ps = DATABASE.getTheConnection().prepareStatement(checkQuery);
            ps.setInt(1, propertyId);
            rs = ps.executeQuery();

            // If there's an existing sale record, return false (property is already sold)
            return !rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(P_SALES.class.getName()).log(Level.SEVERE, null, ex);
            return false; // Return false in case of an exception.
        }
    }
     public boolean propertyExists(int propertyId) throws SQLException {
    PreparedStatement ps;
    ResultSet rs;

    String checkQuery = "SELECT * FROM `the_property` WHERE `id` = ?";

    try {
        ps = DATABASE.getTheConnection().prepareStatement(checkQuery);
        ps.setInt(1, propertyId);
        rs = ps.executeQuery();

        // If the property exists, return true
        return rs.next();
    } catch (SQLException ex) {
        Logger.getLogger(P_SALES.class.getName()).log(Level.SEVERE, null, ex);
        return false; // Return false in case of an exception.
    }
}

public boolean clientExists(int clientId) throws SQLException {
    PreparedStatement ps;
    ResultSet rs;

    String checkQuery = "SELECT * FROM `property_client` WHERE `id` = ?";

    try {
        ps = DATABASE.getTheConnection().prepareStatement(checkQuery);
        ps.setInt(1, clientId);
        rs = ps.executeQuery();

        // If the client exists, return true
        return rs.next();
    } catch (SQLException ex) {
        Logger.getLogger(P_SALES.class.getName()).log(Level.SEVERE, null, ex);
        return false; // Return false in case of an exception.
    }
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

    String getPropertyType() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
