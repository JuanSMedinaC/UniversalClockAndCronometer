package model;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import controller.MainHourController;
import javafx.application.Platform;

public class AddClock extends Thread {
	private MainHourController mainThread;
	private int pos;
	private String tz;
	public AddClock(MainHourController mainThread, int pos, String tz) {
		this.mainThread=mainThread;
		this.pos=pos;
		this.tz=tz;
	}
	
	@Override
	public void run() {
		Platform.runLater(() -> {
			mainThread.externalHoursList.getItems().add(tz);
			mainThread.formats.add(new SimpleDateFormat("hh:mm:ss aa"));
			mainThread.formats.get(pos).setTimeZone(TimeZone.getTimeZone(tz));
		});
		while (true) {	
			Platform.runLater(() -> {
				mainThread.externalHoursList.getItems().set(pos, mainThread.formats.get(pos).format(mainThread.calendar.getInstance().getTime())+" "+ tz);
			});
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
}
