package menjacnica.interfejs;

import java.util.GregorianCalendar;

public interface MenjacnicaInterfejs {
	public void dodajKurs(String naziv, String skraceniNaziv, GregorianCalendar datum, int prodajni, int srednji, int kupovni);
	public void obrisiKurs(String naziv, String skraceniNaziv, GregorianCalendar datum);
	public double[] pronadjiKurs(String valuta, GregorianCalendar datum);
}
