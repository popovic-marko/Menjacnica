package menjacnica;

import java.util.GregorianCalendar;

import menjacnica.interfejs.MenjacnicaInterfejs;

public class Menjacnica implements MenjacnicaInterfejs {

	@Override
	public void dodajKurs(String naziv, String skraceniNaziv, GregorianCalendar datum, int prodajni, int srednji,
			int kupovni) {

	}

	@Override
	public void obrisiKurs(String naziv, String skraceniNaziv, GregorianCalendar datum) {

	}

	@Override
	public double[] pronadjiKurs(String valuta, GregorianCalendar datum) {

		return null;
	}

}
