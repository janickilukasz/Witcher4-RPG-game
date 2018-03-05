package app.model;

public class Land {
	private int id;
	private String name;
	private String fileName;
	
	public Land(int id, String name, String fileName) {
		this.id = id;
		this.name = name;
		this.fileName = fileName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
