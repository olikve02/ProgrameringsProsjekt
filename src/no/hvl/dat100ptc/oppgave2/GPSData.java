package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int n) {

		gpspoints = new GPSPoint[n];
		antall = 0;
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	protected boolean insertGPS(GPSPoint gpspoint) {
		boolean sattInn = false;
		if(antall < gpspoints.length){
			gpspoints[antall] = gpspoint;
			sattInn = true;
			antall++;
		}
	return sattInn;
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {
		boolean sattInn = false;
		sattInn = insertGPS(GPSDataConverter.convert(time, latitude, longitude, elevation));
		return sattInn;
	}

	public void print() {
		System.out.println("====== Konvertert GPS Data - START ======");
		for(GPSPoint gpsPoint : gpspoints){
			System.out.println(gpsPoint.toString());
		}
		System.out.println("====== Konvertert GPS Data - SLUTT ======");
	}
}
