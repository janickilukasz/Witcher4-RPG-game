package app.model;

public class Creature extends Element{

	private String fileNameBig;
	private int smart;
	private int offence;
	private int defence;
	private String weapon;
	private int weaponPower;
	private int life;
	
	public Creature(int id, String name, String fileName, String fileNameBig, int smart, int offence, int defence,
			String weapon, int weaponPower, int life) {
		super(id, name, fileName);
		this.fileNameBig = fileNameBig;
		this.smart = smart;
		this.offence = offence;
		this.defence = defence;
		this.weapon = weapon;
		this.weaponPower = weaponPower;
		this.life = life;
	}

	public String getFileNameBig() {
		return fileNameBig;
	}

	public void setFileNameBig(String fileNameBig) {
		this.fileNameBig = fileNameBig;
	}

	public int getSmart() {
		return smart;
	}

	public void setSmart(int smart) {
		this.smart = smart;
	}

	public int getOffence() {
		return offence;
	}

	public void setOffence(int offence) {
		this.offence = offence;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public String getWeapon() {
		return weapon;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	public int getWeaponPower() {
		return weaponPower;
	}

	public void setWeaponPower(int weaponPower) {
		this.weaponPower = weaponPower;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	
	
}