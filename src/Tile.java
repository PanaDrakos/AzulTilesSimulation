
public abstract class Tile {
	private int id;
	private String name;
	private int placedTiles;
	private int maxAmount;
	
	public Tile(int id, String name) {
		this.id = id;
		this.name = name;
		this.placedTiles = 0;
		this.maxAmount = 20;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAmount() {
		return this.placedTiles;
	}
	
	public int checkMax() {
		return this.maxAmount;
	}
	
	public void increaseAmount() {
		this.placedTiles++;
	}
	
	public void resetAmount() {
		this.maxAmount -= placedTiles;
		if (maxAmount == 0) {
			maxAmount = 20;
		}
		this.placedTiles = 0;
	}
	
	public String toString() {
		if (placedTiles == 1) {
			return placedTiles + " " + name + " tile";
		} else {
			return placedTiles + " " + name + " tiles";
		}
	}
 
}
