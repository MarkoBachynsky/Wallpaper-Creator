package System.UI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * The UI Controller Class responsible for functionality to the User Interface.
 * 
 * @author Marko S. Bachynsky
 * @since 1.0
 */

public class UIController implements Initializable
{
	@FXML
	public ImageView			ImageViewMain;
	@FXML
	public Button				ButtonSingle;
	@FXML
	public Button				ButtonMultiple;
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
	public Boolean				SingleOrMultiple;
	
	
	public void OnActionButtonSingle(ActionEvent event)
	{
		if (SingleOrMultiple == true) // If ButtonSingle is not currently selected 
		{
			ButtonSingle.setStyle("-fx-border-color: Lime");
			ButtonMultiple.setStyle(null);
			SingleOrMultiple = false;
		}

	}
	
	public void OnActionButtonMultiple(ActionEvent event)
	{

		if (SingleOrMultiple == false) // If ButtonMultiple is not currently selected 
		{
			ButtonMultiple.setStyle("-fx-border-color: Lime");
			ButtonSingle.setStyle(null);
			SingleOrMultiple = true;
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		SingleOrMultiple = false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
