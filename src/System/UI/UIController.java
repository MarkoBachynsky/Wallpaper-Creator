package System.UI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * The UI Controller class responsible for functionality to the User Interface.
 * 
 * @author Marko S. Bachynsky
 * @since 1.0
 */

public class UIController
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
	
}
