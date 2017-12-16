package app.model;

import javafx.scene.image.Image;

public class Stwor {
	String nazwa;
	Image img_maly;
	Image img_duzy;
	int spryt;
	int atak;
	int obrona;
	String bron;
	int bronSila;
	int zycie;
	
	public int getSpryt() {
		return spryt;
	}

	public void setSpryt(int spryt) {
		this.spryt = spryt;
	}

	public String getBron() {
		return bron;
	}

	public void setBron(String bron) {
		this.bron = bron;
	}

	public int getBronSila() {
		return bronSila;
	}

	public void setBronSila(int bronSila) {
		this.bronSila = bronSila;
	}

	public int getZycie() {
		return zycie;
	}

	public void setZycie(int zycie) {
		this.zycie = zycie;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public Image getImg_maly() {
		return img_maly;
	}

	public void setImg_maly(Image img_maly) {
		this.img_maly = img_maly;
	}

	public Image getImg_duzy() {
		return img_duzy;
	}

	public void setImg_duzy(Image img_duzy) {
		this.img_duzy = img_duzy;
	}

	public int getAtak() {
		return atak;
	}

	public void setAtak(int atak) {
		this.atak = atak;
	}

	public int getObrona() {
		return obrona;
	}

	public void setObrona(int obrona) {
		this.obrona = obrona;
	}

	public Stwor(String nazwa, Image img_maly, Image img_duzy, int spryt, int atak, int obrona, String bron,
			int bronSila, int zycie) {
		this.nazwa = nazwa;
		this.img_maly = img_maly;
		this.img_duzy = img_duzy;
		this.spryt = spryt;
		this.atak = atak;
		this.obrona = obrona;
		this.bron = bron;
		this.bronSila = bronSila;
		this.zycie = zycie;
	}
	
	
}
