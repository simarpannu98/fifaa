/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author simarjit singh pannu
 */
public class Fifaa {
    
    private String name;
    private String team;
    private String country;

    public Fifaa(String Name, String team, String country) {
        setName(Name);
        setTeam(team); 
       setCountry(country);
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String Team) {
        this.team = Team;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
    public void insertIntoDB() throws SQLException
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        
        try{
            //connecting to the database 
           conn = DriverManager.getConnection("jdbc:mysql://aws.computerstudi.es/"

                    + "gc200359541", "gc200359541", "wl3tDZWsQf");

            
      //string to hold values
     // System.out.println("There was an error connecting the database");
      
      String sql = "INSERT INTO football (name ,team , country)" 
              + "VALUES (?,?,?)";
      
       preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
      
      preparedStatement.setString(1,name);
      preparedStatement.setString(2,team);
      preparedStatement.setString(3,country);
    
      preparedStatement.executeUpdate();
      
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
        finally
        {
            if(preparedStatement != null)
                preparedStatement.close();
            
            if(conn != null)
            conn.close();
               
    }
    
}
}
    
    

