package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import model.RunCronometer;

public class CronometerController implements Initializable{
	private Main main;
	public boolean active;
	
	@FXML
	public Label cronometerLabel;
	@FXML
	Button start_Stop;
	@FXML
	ListView<String> lapssList;
	
	
	public int hours,minutes,seconds;
	
	private RunCronometer thread1;
	private boolean started;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		active=false;
		started=false;
		hours=00;
		minutes=00;
		seconds=00;
		thread1=new RunCronometer(this);	
	}
	
	public void setMain(Main main) {
		this.main=main;
	}
	@FXML
	public void showClock() {
		main.showClock();
	}
	@FXML
	public void startStop() {
		
		if (!started) {
			started=true;
			thread1.start();
			start_Stop.setText("Stop");
			active=true;
		}else if(started) {
			if(active) {
				start_Stop.setText("Start");
				active=false;
				thread1.suspend();
			}
			else if(!active) {
				start_Stop.setText("Stop");
				active=true;
				thread1.resume();
			}			
		}
	}
	
	@FXML
	public void lap() {
		lapssList.getItems().add(cronometerLabel.getText());
	}
	
	@FXML
	public void reset() {
		if(started) {
			if(active) {
				thread1.suspend();
				active=false;
				start_Stop.setText("Start");
			}
		}
		hours=0;
		minutes=0;
		seconds=0;
		cronometerLabel.setText("00:00:00");
		lapssList.getItems().clear();
	}
	
}
