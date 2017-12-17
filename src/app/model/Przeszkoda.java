package app.model;

public class Przeszkoda {
	private int id;
	private String nazwa;
	private String plik;

	public Przeszkoda(int id, String nazwa, String plik) {
		this.id = id;
		this.nazwa = nazwa;
		this.plik = plik;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getPlik() {
		return plik;
	}

	public void setPlik(String plik) {
		this.plik = plik;
	}
}
