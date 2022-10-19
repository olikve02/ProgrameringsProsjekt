package no.hvl.dat100ptc;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class Main {
    public static void main(String[] args) {
        GPSPoint point = new GPSPoint(1, 2, 4, 5);
        System.out.println(point.toString());
    }
}
