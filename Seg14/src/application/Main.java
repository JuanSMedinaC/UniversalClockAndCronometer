package application;
	
import java.io.IOException;

import controller.CronometerController;
import controller.MainHourController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	private Stage currentStage = new Stage();
	@Override
	public void start(Stage primaryStage) {
		BorderPane root;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/MainHour.fxml"));
			root = (BorderPane)loader.load();
			MainHourController mainHourController= loader.getController();
			mainHourController.setMain(this);
			
			Scene scene = new Scene(root);
			currentStage.setScene(scene);
			currentStage.setHeight(500);
			currentStage.setWidth(675);
			currentStage.show();			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showCronometer() {
		BorderPane cronometer;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Cronometer.fxml"));
			cronometer = (BorderPane)loader.load();
			CronometerController cronometerController = loader.getController();
			cronometerController.setMain(this);
			
			
			BorderPane root;
			Stage stage = currentStage;
			root = (BorderPane)stage.getScene().getRoot();
			root.setCenter(cronometer);
			stage.setHeight(500);
			stage.setWidth(675);
			stage.show();
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showClock() {
		BorderPane root;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/MainHour.fxml"));
			root = (BorderPane)loader.load();
			MainHourController mainHourController = loader.getController();
			mainHourController.setMain(this);
			
			Scene scene = new Scene(root);
			currentStage.setScene(scene);
			currentStage.setHeight(500);
			currentStage.setWidth(675);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
