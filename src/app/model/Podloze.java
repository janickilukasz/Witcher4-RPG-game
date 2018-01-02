package app.model;

public class Podloze {
	private int id;
	private String nazwa;
	private String plik;
	private int rotacja;

	public Podloze(int id, String nazwa, String plik, int rotacja) {
		this.id = id;
		this.nazwa = nazwa;
		this.plik = plik;
		this.rotacja = rotacja;
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

	public int getRotacja() {
		return rotacja;
	}

	public void setRotacja(int rotacja) {
		this.rotacja = rotacja;
	}
}
