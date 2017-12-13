package app.model;

public class Pole {
	private int id;


	private static int nr_planszy;
	private int x;
	private int y;
	private int rodzaj;
	private int stwor;

	public Pole(int id, int x, int y, int rodzaj, int stwor) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.rodzaj = rodzaj;
		this.stwor = stwor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public static int getNr_planszy() {
		return nr_planszy;
	}

	public static void setNr_planszy(int nr_planszy) {
		Pole.nr_planszy = nr_planszy;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getRodzaj() {
		return rodzaj;
	}

	public void setRodzaj(int rodzaj) {
		this.rodzaj = rodzaj;
	}

	public int getStwor() {
		return stwor;
	}

	public void setStwor(int stwor) {
		this.stwor = stwor;
	}
	
	
}
