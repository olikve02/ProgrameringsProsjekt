package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

import java.awt.event.MouseAdapter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max;

		max = da[0];

		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}

		return max;
	}

	public static double findMin(double[] da) {

		double min;

		min = da[0];

		for(double d : da){
			if (d < min){
				min = d;
			}
		}
		return min;
	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		double[] latitudes = new double[gpspoints.length];
		for (int i = 0; i < gpspoints.length; i++) {
			latitudes[i] = gpspoints[i].getLatitude();
		}
		return latitudes;
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		double[] longitudes = new double[gpspoints.length];
		for (int i = 0; i < gpspoints.length; i++) {
			longitudes[i] = gpspoints[i].getLongitude();
		}
		return longitudes;
	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;
		latitude1 = gpspoint1.getLatitude();
		longitude1 = gpspoint1.getLongitude();
		latitude2 = gpspoint2.getLatitude();
		longitude2 = gpspoint2.getLongitude();

		double rad1 = toRadians(gpspoint1.getLatitude());
		double rad2 = toRadians(gpspoint2.getLatitude());
		double deltaLatidude = toRadians(latitude2 - latitude1);
		double deltaLongitude = toRadians(longitude2 - longitude1);

		double a = pow(sin(deltaLatidude/2), 2) + cos(rad1)* cos(rad2) * pow(sin(deltaLongitude/2), 2);
		double c = 2 * atan2(sqrt(a), sqrt(1-a));
		d = R * c;
		return d;
	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double distance = distance(gpspoint1, gpspoint2);
		double time = gpspoint2.getTime() - gpspoint1.getTime();
		double speedMS = distance / time;
		double speedKMT = speedMS * 3.6;
		return speedKMT;
	}

	public static String formatTime(int secs) {
		String timeStr;
		double sek = (secs%3600)%60;
		double min = ((secs - sek)%3600) / 60;
		double time = (double)secs / 3600;

		timeStr = String.format("%2d:%2d:%2d", (int)time, (int)min, (int)sek);
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh-mm-ss");
		return timeStr;
	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;
		str = String.format("%10s", (double)round(d * 100) / 100);
		return str;
	}
}
