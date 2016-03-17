package menjacnica.interfejs;

import java.util.GregorianCalendar;

public interface MenjacnicaInterfejs {
	public void dodajKurs(GregorianCalendar datum, int prodajni, int srednji, int kupovni);
	public void obrisiKurs(GregorianCalendar datum);
	public int[] pronadjiKurs(String valuta, GregorianCalendar datum);
}
