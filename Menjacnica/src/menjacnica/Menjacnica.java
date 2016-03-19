package menjacnica;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import menjacnica.interfejs.MenjacnicaInterfejs;

public class Menjacnica implements MenjacnicaInterfejs {

	private LinkedList<Valuta> valute;
	
	
	@Override
	public void dodajKurs(String naziv, String skraceniNaziv, GregorianCalendar datum, int prodajni, int srednji,
			int kupovni) {
		boolean unet = false;
		Kurs k = new Kurs(datum, prodajni, kupovni, srednji);
		for (int i = 0; i < valute.size(); i++) {
			if(valute.get(i).getNaziv().equals(naziv)){
				LinkedList<Kurs> lista = valute.get(i).getKursevi();
				lista.add(k);
				valute.get(i).setKursevi(lista);
				unet = true;
				break;
			}
		}
		if(!unet){
			LinkedList<Kurs> lista = new LinkedList<>();
			lista.add(k);
			Valuta v = new Valuta(naziv, skraceniNaziv, lista);
			valute.add(v);
		}
	}

	@Override
	public void obrisiKurs(String naziv, String skraceniNaziv, GregorianCalendar datum) {

	}

	@Override
	public double[] pronadjiKurs(String valuta, GregorianCalendar datum) {

		return null;
	}

}
