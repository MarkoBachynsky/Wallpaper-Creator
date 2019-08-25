package System.UI;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 * The UI Controller Class responsible for functionality to the User Interface.
 * 
 * @author Marko S. Bachynsky
 * @since 1.0
 */

public class UIController implements Initializable
{
	public Stage				StageMain;
	@FXML
	public BorderPane			BorderPaneMain;
	@FXML
	public ImageView			ImageViewMain;
	@FXML
	public Button				ButtonCreateSingle;
	@FXML
	public Button				ButtonCreateMultiple;
	@FXML
	public TextField			TextFieldChoiceLocation;
	@FXML
	public Button				ButtonBrowseChoiceLocation;
	@FXML
	public ChoiceBox<String>	ChoiceBoxTargetResolution;
	@FXML
	public TextField			TextFieldCustomWidth;
	@FXML
	public TextField			TextFieldCustomHeight;
	@FXML
	public Button				ButtonLoselessResolution;
	@FXML
	public ChoiceBox<String>	ChoiceBoxBlackBarPlacement;
	@FXML
	public TextField			TextFieldBlackBarHeight;
	@FXML
	public TextField			TextFieldBackgroundOpacity;
	@FXML
	public Slider				SliderBlackBarHeight;
	@FXML
	public Slider				SliderBackgroundOpacity;
	@FXML
	public TextField			TextFieldCreatedLocation;
	@FXML
	public Button				ButtonBrowseCreatedLocation;
	@FXML
	public Button				ButtonOpenCreatedLocation;
	@FXML
	public TextArea				TextAreaLog;
	@FXML
	public Button				ButtonCreate;
	
	/**
	 * Boolean to keep track of which setting is selected. Single or multiple images.
	 * False is single, true is multiple.
	 * @author Marko S. Bachynsky
	 * @since 1.0
	 */
	
	public Boolean				CreateSingleOrMultiple;
	
	/**
	 * ButtonCreateSingle on action event.
	 * When selected, update selection color, and CreateSingleOrMultiple boolean.
	 * @author Marko S. Bachynsky
	 * @since 1.0
	 */
	
	public void OnActionButtonCreateSingle(ActionEvent event)
	{
		if (CreateSingleOrMultiple == true) // If ButtonCreateSingle is not currently selected 
		{
			ButtonCreateSingle.setStyle("-fx-border-color: Lime");
			ButtonCreateMultiple.setStyle(null);
			CreateSingleOrMultiple = false;
			EnableOrDisableButtonCreate();
		}

	}
	
	/**
	 * ButtonCreateMultiple on action event.
	 * When selected, update selection color, and CreateSingleOrMultiple boolean.
	 * @author Marko S. Bachynsky
	 * @since 1.0
	 */
	
	public void OnActionButtonCreateMultiple(ActionEvent event)
	{

		if (CreateSingleOrMultiple == false) // If ButtonCreateMultiple is not currently selected 
		{
            try
            {
            	TextFieldChoiceLocation.setText(TextFieldChoiceLocation.getText().substring(0, TextFieldChoiceLocation.getText().lastIndexOf("\\")) + "\\");
            } catch (Exception error)
            {
                System.out.println(error);
            }
			
			ButtonCreateMultiple.setStyle("-fx-border-color: Lime");
			ButtonCreateSingle.setStyle(null);
			CreateSingleOrMultiple = true;
			EnableOrDisableButtonCreate();
			
			
		}
	}

	
	/**
	 * Initialize event. Initializes variables, and events for GUI elements.
	 * TextFieldChoiceLocation Text Changed event runs EnableOrDisableButtonCreate()
	 * @author Marko S. Bachynsky
	 * @since 1.0
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		//StageMain = (Stage) BorderPaneMain.getScene().getWindow();
		
		CreateSingleOrMultiple = false;
		
		
		
		
		TextFieldChoiceLocation.textProperty().addListener(new ChangeListener<String>()
		{
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
		    {
		    	EnableOrDisableButtonCreate();
		    }
		});
		
	}
	
	/**
	 * Checks user input to enable or disable the create image button.
	 * @author Marko S. Bachynsky
	 * @since 1.0
	 */
	public void EnableOrDisableButtonCreate()
	{
		if (CreateSingleOrMultiple == false) // If Create Single Is Selected
		{
			if (((File) new File(TextFieldChoiceLocation.getText())) .isFile()) // if the file does exist, enable Create Image Button
				ButtonCreate.setDisable(false);
			else
				ButtonCreate.setDisable(true);
		} else if (CreateSingleOrMultiple == true) // If Create Multiple Is Selected
		{
			if (((File) new File(TextFieldChoiceLocation.getText())) .isDirectory()) // if the directory does exist, enable Create Image Button
				ButtonCreate.setDisable(false);
			else
				ButtonCreate.setDisable(true);
		}
		
		
		try
		{
	        if (Integer.parseInt(TextFieldCustomWidth.getText()) <= 0 || Integer.parseInt(TextFieldCustomHeight.getText()) <= 0) // If either custom resolution inputs are less than 1
				ButtonCreate.setDisable(false); // If inputs are good, stay enabled
			else
				ButtonCreate.setDisable(true); // If inputs are bad, disable button
		} catch (NumberFormatException Exception)
		{
			// This exception is expected, and doesn't need to be handled further.
		}

	}
	
	
	/**
	 * On Action Event that allows the user to select a file or directory.
	 * @author Marko S. Bachynsky
	 * @since 1.0
	 */
	public void OnActionButtonBrowseChoiceLocation(ActionEvent event)
	{
		 FileChooser fileChooser = new FileChooser();
		 fileChooser.setTitle("Open Resource File");
		 fileChooser.getExtensionFilters().addAll(
		         new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"),
		         new ExtensionFilter("All Files", "*.*"));
		 File selectedFile = fileChooser.showOpenDialog(StageMain);
		 if (selectedFile != null) {
			 String selectedFilePath = selectedFile.getPath();
			 TextFieldChoiceLocation.setText(selectedFilePath);
		 }

	}
	
	
}















