/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author simarjit singh pannu
 */
public class TableController implements Initializable {

    
    @FXML private TableView<Fifaa> footballTable;
    @FXML private TableColumn<Fifaa , String> name;
@FXML private TableColumn<Fifaa , String> team;
@FXML private TableColumn<Fifaa , String> country;
@FXML private Button editButton;
    /**
     * Initializes the controller class.
     */


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
          name.setCellValueFactory(new PropertyValueFactory<Fifaa , String>("name"));
        team.setCellValueFactory(new PropertyValueFactory<Fifaa , String>("team"));
        country.setCellValueFactory(new PropertyValueFactory<Fifaa , String>("country"));
        
         try{
            LoadBall();
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }   
    public void LoadBall() throws SQLException
    {
         ObservableList< Fifaa> fifa = FXCollections.observableArrayList();
       
        Connection conn = null; 
        Statement statement = null;
        ResultSet resultSet = null;
        
        try {
            //connecting to the database
            conn = DriverManager.getConnection("jdbc:mysql://aws.computerstudi.es/"

                    + "gc200359541", "gc200359541", "wl3tDZWsQf");
            
            //remember to change the table name here
            
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM football");
            
            while(resultSet.next())
                    {
                        Fifaa newfifa = new Fifaa(resultSet.getString("name"),
                                                         resultSet.getString("team"),
                                                          resultSet.getString("country")
                                                          
                        );
                                                        
                                //double check here
                     fifa.add(newfifa);   
                     
                    }
            footballTable.getItems().addAll(fifa);
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
        
        finally{
            
            if( conn != null)
                conn.close();
       if (statement != null)
           statement.close();
        if( resultSet != null)
            resultSet.close();
        }
    }
    public void NewButtonpush(ActionEvent event) throws IOException
    {
        
                 Parent tableViewParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage box = (Stage)((Node)event.getSource()).getScene().getWindow();  
        
        box.setScene(tableViewScene);
        box.show();
         
    }
        
        
    
    
    
    
}

