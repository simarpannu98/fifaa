/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @author simarjit singh pannu
 */



public class FXMLDocumentController implements Initializable {

     @FXML private TextField nameTextField;
    @FXML private TextField teamTextField;
    @FXML private TextField countryTextField;
      @FXML private ImageView imageview;
    
    private File ImageFile;
   
     public void saveButtonPushed(ActionEvent event)
    {
          try{

                if(nameTextField.getText().isEmpty()){

            }

            else if(teamTextField.getText().isEmpty()){

               // errorMessg.setText("Last name is mandatory"); 

            }

            else if(countryTextField.getText().isEmpty()){

               //  errorMessg.setText("Phone number is required"); 

            }
           Fifaa s1 = new Fifaa(nameTextField.getText(),teamTextField.getText(),countryTextField.getText()
                   );
           
          // errorMessg.setText("");
      s1.insertIntoDB();  //this will insert all the values into the database
      System.out.println("saved !");
      
      //This will redirect the users to the main table page after they save their share information
      Parent tableViewParent = FXMLLoader.load(getClass().getResource("Table.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage box = (Stage)((Node)event.getSource()).getScene().getWindow();  
        
        box.setScene(tableViewScene);
        box.show();
           }
      
        catch (Exception e)

            {

              //  errorMessg.setText(e.getMessage());

            }
        
      }
      public void ChooseImagePush(ActionEvent event)
    {
        //this will open a scene 
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();  
                
          //this will allow us to choose a file and double check the syntax
          //FileChooser preloaded class 
          FileChooser filechooser = new FileChooser();
          filechooser.setTitle("Open Image");
          
          //This will allow to choose an image either a jpg or a png
          FileChooser.ExtensionFilter jpgFilter = new FileChooser.ExtensionFilter("Image File (*.jpg)",".jpg");
          FileChooser.ExtensionFilter pngFilter = new FileChooser.ExtensionFilter("Image File (*.png)",".png");

          //scene creator
          filechooser.getExtensionFilters().addAll(jpgFilter , pngFilter);
          String userDirectoryString  = System.getProperty("user.home")+"\\Pictures";
          File userDirectory = new File(userDirectoryString);
          
          //create 
          if(!userDirectory.canRead())
              userDirectory = new File(System.getProperty("user.home"));
          
          ImageFile = filechooser.showOpenDialog(stage);
          
          if(ImageFile.isFile())
          {
              try{
                    BufferedImage bufferedImage = ImageIO.read(ImageFile);
        Image image = SwingFXUtils.toFXImage(bufferedImage, null);
        imageview.setImage(image);
                  
              }
              catch(IOException e){
                  System.err.println(e.getMessage());
                  
          }
          
    }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
        try{
            
        ImageFile = new File("./src/images/stock.png");
        BufferedImage bufferedImage = ImageIO.read(ImageFile);
        Image image = SwingFXUtils.toFXImage(bufferedImage, null);
        imageview.setImage(image);
    }
    
    catch(IOException e)
    {
        System.err.println(e.getMessage());
    }
    
    }
       
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
//This will set the default image to the project
    
    
    }
      
    


    
    
    
   

