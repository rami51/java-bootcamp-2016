
public class File {
	private boolean open = false; //is false when it's closed, and is true when it's opened.
	private String name;
	
	public boolean isOpen() {
		return open;
	}
	public void open() {
		this.open = true;
	}
	public void close(){
		this.open = false;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}
