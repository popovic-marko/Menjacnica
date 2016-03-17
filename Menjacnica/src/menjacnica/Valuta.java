package menjacnica;

import java.util.LinkedList;

public class Valuta {
	private String naziv;
	private String skraceniNaziv;
	private LinkedList<Kurs> kursevi;
	
	@Override
	public String toString() {
		return "\n" + naziv + "("+ skraceniNaziv + ")" + ",je za sledece datume imala kurseve: " + "\n" + kursevi;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kursevi == null) ? 0 : kursevi.hashCode());
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		result = prime * result + ((skraceniNaziv == null) ? 0 : skraceniNaziv.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Valuta){
			Valuta v = (Valuta) obj;
			return this.naziv.equals(v.naziv);
		}
		return false;
	}
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		if(naziv == null || naziv.isEmpty()){
			throw new RuntimeException("Greska pri unosu naziva valute!");
		}
		this.naziv = naziv;
	}
	public String getSkraceniNaziv() {
		return skraceniNaziv;
	}
	public void setSkraceniNaziv(String skraceniNaziv) {
		if(skraceniNaziv == null || skraceniNaziv.isEmpty()){
			throw new RuntimeException("Greska pri unosu skracenog naziva valute!");
		}
		this.skraceniNaziv = skraceniNaziv;
	}
	public LinkedList<Kurs> getKursevi() {
		return kursevi;
	}
	public void setKursevi(LinkedList<Kurs> kursevi) {
		if(kursevi == null){
			throw new RuntimeException("Greska pri unosu kurseva!");
		}
		this.kursevi = kursevi;
	}
	
	
}
