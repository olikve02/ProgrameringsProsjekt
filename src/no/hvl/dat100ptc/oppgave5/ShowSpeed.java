package no.hvl.dat100ptc.oppgave5;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

import java.awt.*;

public class ShowSpeed extends EasyGraphics {
			
	private static final int MARGIN = 50;
	private static final int BARHEIGHT = 50; // assume no speed above 200 km/t

	private GPSComputer gpscomputer;
	private GPSPoint[] gpspoints;
	
	public ShowSpeed() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();
		
	}
	
	// read in the files and draw into using EasyGraphics
	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		int N = gpspoints.length-1; // number of data points
		
		makeWindow("Speed profile", 2*MARGIN + 2 * N, 2 * MARGIN + BARHEIGHT);
		
		showSpeedProfile(MARGIN + BARHEIGHT,N);
	}
	
	public void showSpeedProfile(int ybase, int N) {
		int xIncrement = 0;
		// get segments speeds from the GPS computer object		
		double[] speeds = gpscomputer.speeds();
		for (int i = 0; i < speeds.length; i++) {
			if(speeds[i] >= 0){
				Point pointBotom = new Point(xIncrement, ybase);
				Point pointTop = new Point(xIncrement, (int)speeds[i]);
				setColor(0, 0, 255);
				drawLine(pointBotom.x, pointBotom.y, pointTop.x, pointTop.y);
			}else {
				System.out.println("kuk");
				Point pointBotom = new Point(xIncrement, ybase);
				Point pointTop = new Point(xIncrement, ybase);
				setColor(0, 0, 255);
				drawLine(pointBotom.x, pointBotom.y, pointTop.x, pointTop.y);
			}
			xIncrement += 2;
		}
	}
}
