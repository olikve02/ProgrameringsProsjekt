package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	// konverter tidsinformasjon i gps data punkt til antall sekunder fra midnatt
	// dvs. ignorer information om dato og omregn tidspunkt til sekunder
	// Eksempel - tidsinformasjon (som String): 2017-08-13T08:52:26.000Z
    // skal omregnes til sekunder (som int): 8 * 60 * 60 + 52 * 60 + 26 
	
	private static int TIME_STARTINDEX = 11; // posisjon for start av tidspunkt i timestr

	public static int toSeconds(String timestr) {
		
		int secs = 0;
		int hr, min, sec;
		
		timestr = timestr.substring(11,19);
		String[] timeStr = timestr.split(":");
		hr = Integer.parseInt(timeStr[0]);
		min = Integer.parseInt(timeStr[1]);
		sec = Integer.parseInt(timeStr[2]);

		secs += hr * 3600;
		secs += min * 60;
		secs += sec;

		return secs;
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		int secs = toSeconds(timeStr);

		double latitude = Double.parseDouble(latitudeStr);
		double longitude = Double.parseDouble(longitudeStr);
		double elevation = Double.parseDouble(elevationStr);

		GPSPoint gpspoint = new GPSPoint(secs, latitude, longitude, elevation);
		return gpspoint;
	}
	
}
