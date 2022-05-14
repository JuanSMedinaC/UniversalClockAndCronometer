package controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.TimeZone;

import application.Main;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import model.AddClock;
import model.LoadMainClock;

public class MainHourController implements Initializable {
	public Calendar calendar;
	public SimpleDateFormat sdf;
	public String mainTime;
	public Main main;
	@FXML
	public Label mainClockLabel;
	@FXML
	ListView<String> timeZonesList;
	@FXML
	public ListView<String> externalHoursList;
	private ArrayList<AddClock> addClockList;
	public ArrayList<SimpleDateFormat> formats;
	
	public void setMain(Main main) {
		this.main=main;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		addClockList=new ArrayList<>();
		formats=new ArrayList<>();
		sdf=new SimpleDateFormat("hh:mm:ss aa");
		updateTime();	
		loadTZList();
	}
	
	public void updateTime() {
		LoadMainClock thread1=new LoadMainClock(this);
		thread1.start();
	}
	public void loadTZList() {
		String[] timeZones=TimeZone.getAvailableIDs();
		timeZonesList.getItems().addAll(timeZones);
	}
	@FXML
	public void addHour() {
		String tz=timeZonesList.getSelectionModel().getSelectedItem();
		addClockList.add(new AddClock(this,addClockList.size(),tz));
		addClockList.get(addClockList.size()-1).start(); 
		externalHoursList.getItems();
	}
	
	@FXML
	public void showCronometer() {
		main.showCronometer();
	}

}
