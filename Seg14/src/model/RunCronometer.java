package model;

import controller.CronometerController;
import javafx.application.Platform;

public class RunCronometer extends Thread{
	private CronometerController mainThread;
	private String timeString;
	
	public RunCronometer(CronometerController mainThread) {
		this.mainThread=mainThread;
		timeString="";
	}
	
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			Platform.runLater(() -> {
				if (mainThread.minutes==60) {
					mainThread.hours+=1;
					mainThread.minutes=0;
				}
				if (mainThread.seconds==60) {
					mainThread.seconds=0;
					mainThread.minutes+=1;
				}
				mainThread.seconds+=1;	
				
				if (mainThread.hours<10) {
					timeString="0"+mainThread.hours+":";
				}else {
					timeString=mainThread.hours+":";
				}
				
				if(mainThread.minutes<10) {
					timeString+="0"+mainThread.minutes+":";
				}else {
					timeString+=mainThread.minutes+":";
				}
				
				if(mainThread.seconds<10) {
					timeString+="0"+mainThread.seconds+"";
				}else {
					timeString+=mainThread.seconds;
				}
				mainThread.cronometerLabel.setText(timeString);
			});
		}
	}
}

