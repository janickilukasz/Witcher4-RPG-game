package app.model;

public class Field {
	private int boardRow;
	private int boardCol;
	private int fieldRow;
	private int fieldCol;
	private Land land;
	private int landRotation;
	private Obstacle obstacle;
	private Creature creature;
	
	public Field(int boardRow, int boardCol, int fieldRow, int fieldCol, Land land, int landRotation, Obstacle obstacle,
			Creature creature) {
		this.boardRow = boardRow;
		this.boardCol = boardCol;
		this.fieldRow = fieldRow;
		this.fieldCol = fieldCol;
		this.land = land;
		this.landRotation = landRotation;
		this.obstacle = obstacle;
		this.creature = creature;
	}

	public int getBoardRow() {
		return boardRow;
	}

	public void setBoardRow(int boardRow) {
		this.boardRow = boardRow;
	}

	public int getBoardCol() {
		return boardCol;
	}

	public void setBoardCol(int boardCol) {
		this.boardCol = boardCol;
	}

	public int getFieldRow() {
		return fieldRow;
	}

	public void setFieldRow(int fieldRow) {
		this.fieldRow = fieldRow;
	}

	public int getFieldCol() {
		return fieldCol;
	}

	public void setFieldCol(int fieldCol) {
		this.fieldCol = fieldCol;
	}

	public Land getLand() {
		return land;
	}

	public void setLand(Land land) {
		this.land = land;
	}

	public int getLandRotation() {
		return landRotation;
	}

	public void setLandRotation(int landRotation) {
		this.landRotation = landRotation;
	}

	public Obstacle getObstacle() {
		return obstacle;
	}

	public void setObstacle(Obstacle obstacle) {
		this.obstacle = obstacle;
	}

	public Creature getCreature() {
		return creature;
	}

	public void setCreature(Creature creature) {
		this.creature = creature;
	}
	
	
}
