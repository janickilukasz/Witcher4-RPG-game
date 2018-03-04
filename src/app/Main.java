package app;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage stg) throws Exception {
		//Parent rodzic = (Parent) FXMLLoader.load(getClass().getResource("/app/view/StartView.fxml"));
		Parent rodzic = (Parent) FXMLLoader.load(getClass().getResource("/app/view/Edytor.fxml"));
		Scene sc = new Scene(rodzic);
		sc.getStylesheets().add("/other/styles.css");
		stg.setScene(sc);
		stg.setTitle("WITCHER 4 : Dzika Zgon");
		stg.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
