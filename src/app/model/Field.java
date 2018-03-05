package app.model;

public class Field {
	private int boardRow;
	private int boardCol;
	private int fieldRow;
	private int fieldCol;
	private String landFilename;
	private int landRotation;
	private String obstacleFilename;
	private String creatureFilename;
	
	
	public Field(int boardRow, int boardCol, int fieldRow, int fieldCol, String landFilename, int landRotation,
			String obstacleFilename, String creatureFilename) {
		this.boardRow = boardRow;
		this.boardCol = boardCol;
		this.fieldRow = fieldRow;
		this.fieldCol = fieldCol;
		this.landFilename = landFilename;
		this.landRotation = landRotation;
		this.obstacleFilename = obstacleFilename;
		this.creatureFilename = creatureFilename;
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
	public String getLandFilename() {
		return landFilename;
	}
	public void setLandFilename(String landFilename) {
		this.landFilename = landFilename;
	}
	public int getLandRotation() {
		return landRotation;
	}
	public void setLandRotation(int landRotation) {
		this.landRotation = landRotation;
	}
	public String getObstacleFilename() {
		return obstacleFilename;
	}
	public void setObstacleFilename(String obstacleFilename) {
		this.obstacleFilename = obstacleFilename;
	}
	public String getCreatureFilename() {
		return creatureFilename;
	}
	public void setCreatureFilename(String creatureFilename) {
		this.creatureFilename = creatureFilename;
	}

}
