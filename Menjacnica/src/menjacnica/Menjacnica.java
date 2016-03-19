package menjacnica;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import menjacnica.interfejs.MenjacnicaInterfejs;

public class Menjacnica implements MenjacnicaInterfejs {

	private LinkedList<Valuta> valute;

	@Override
	public void dodajKurs(String naziv, String skraceniNaziv, GregorianCalendar datum, int prodajni, int srednji,
			int kupovni) {
		if(naziv == null || skraceniNaziv == null || datum == null)
			return;
		
		Kurs k = new Kurs(datum, prodajni, kupovni, srednji);
		boolean unet = false;
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
		if(naziv == null || skraceniNaziv == null || datum == null)
			return;
		
		for (int i = 0; i < valute.size(); i++) {
			if(valute.get(i).getNaziv().equals(naziv)){
				for (int j = 0; j < valute.get(i).getKursevi().size(); j++) {
					if( ( valute.get(i).getKursevi().get(j).getDatum().get(GregorianCalendar.DATE) == datum.get(GregorianCalendar.DATE) )
							&& ( valute.get(i).getKursevi().get(j).getDatum().get(GregorianCalendar.MONTH) == datum.get(GregorianCalendar.MONTH) )  
							&& ( valute.get(i).getKursevi().get(j).getDatum().get(GregorianCalendar.YEAR) == datum.get(GregorianCalendar.YEAR) )){
						valute.get(i).getKursevi().remove(j);
						return;
					}
				}
			}
		}
	}

	@Override
	public double[] pronadjiKurs(String valuta, GregorianCalendar datum) {
		if(valuta == null || datum == null)
			return null;
		
		double[] niz = new double[3];
		boolean postoji = false;
		for (int i = 0; i < valute.size(); i++) {
			if(valute.get(i).getNaziv().equals(valuta)) {
				for (int j = 0; j < valute.get(i).getKursevi().size(); j++) {
					if( ( valute.get(i).getKursevi().get(j).getDatum().get(GregorianCalendar.DATE) == datum.get(GregorianCalendar.DATE) )
							&& ( valute.get(i).getKursevi().get(j).getDatum().get(GregorianCalendar.MONTH) == datum.get(GregorianCalendar.MONTH) )  
							&& ( valute.get(i).getKursevi().get(j).getDatum().get(GregorianCalendar.YEAR) == datum.get(GregorianCalendar.YEAR) )){
						niz[0] = valute.get(i).getKursevi().get(j).getProdajniKurs();
						niz[1] = valute.get(i).getKursevi().get(j).getSrednjiKurs();
						niz[2] = valute.get(i).getKursevi().get(j).getKupovniKurs();
						postoji = true;
						break;
					}
				}
			}
		}
		if(!postoji)
			return null;
		return niz;
	}

}
