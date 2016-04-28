public class Room {
	private String info = null;
	private int x = 0;
	private int y = 0;
	
	public Room(){}
	
	public Room(int x, int y, String info) {
		this.x = x;
		this.y = y;
		this.info = info;
	}
	
	public String getInfo() {
		return this.info;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getX() {
		return this.x;
	}
}