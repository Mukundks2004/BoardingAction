public class Cell {
	
	private Segment segment;
	private boolean hit;

	public Cell() {
		this.segment = null;
		this.hit = false;
	}
	
	public boolean hasBeenHit() {
		return this.hit;
	}
	
	public void attack() {
		//System.out.println("attacked!");
		if (this.segment != null) this.segment.attack();
		this.hit = true;
	}
	
	public boolean isOccupied() {
		return this.segment != null;
	}
	
	public void placeSegment(Segment segment) {
		if (!this.isOccupied()) {
			this.segment = segment;
		}
	}
	
	@Override
	public String toString() {
		if (!this.hit) {
			return ".";
		}
		else {
			if (!this.isOccupied()) {
				return "O";
			}
			else if (!this.segment.getShip().sunk()) {
				return "X";
			}
			else {
				return this.segment.toString();
			}
		}
	}
	
	public String displaySetup() {
		return this.isOccupied() ? this.segment.toString() : ".";
	}
}
