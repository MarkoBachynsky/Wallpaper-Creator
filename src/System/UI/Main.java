package System.UI;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

/**
 * The main class, where the application starts.
 * 
 * @author Marko S. Bachynsky
 * @since 1.0
 */
public class Main extends Application
{

	/**
	 * 
	 * Creates main program.
	 * 
	 * @since 1.0
	 * @author Marko S. Bachynsky
	 */
	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/System/UI/Resources/MainApplication.fxml"));
			Parent root = (Parent) loader.load();
			
			// Main Program
			Scene scene = new Scene(root);
			primaryStage.setTitle("Wallpaper Creator");
			scene.getStylesheets().add(getClass().getResource("/System/UI/Resources/Application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception error)
		{
			error.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
