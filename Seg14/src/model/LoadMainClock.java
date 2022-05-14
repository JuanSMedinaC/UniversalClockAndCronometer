package model;

import controller.MainHourController;
import javafx.application.Platform;

public class LoadMainClock extends Thread{
	
	private MainHourController mainThread;
	
	public LoadMainClock(MainHourController mainThread) {
		this.mainThread=mainThread;
	}

	@Override
	public void run() {
		while (true) {
			mainThread.mainTime=mainThread.sdf.format(mainThread.calendar.getInstance().getTime());	
			Platform.runLater(() -> {mainThread.mainClockLabel.setText(mainThread.mainTime);
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
