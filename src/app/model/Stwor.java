package app.model;

import javafx.scene.image.Image;

public class Stwor {
	String nazwa;
	Image img_maly;
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

	Image img_duzy;
	int atak;
	int obrona;
	
	public Stwor(String nazwa, Image img_maly, Image img_duzy, int atak, int obrona) {
		this.nazwa = nazwa;
		this.img_maly = img_maly;
		this.img_duzy = img_duzy;
		this.atak = atak;
		this.obrona = obrona;
	}
}
