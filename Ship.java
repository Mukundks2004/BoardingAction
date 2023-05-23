import java.util.List;
import java.util.ArrayList;

public class Ship {

	private final String type;
	private final List<Segment> segments;

	private Ship(final String type) {
		this.type = type.toLowerCase();
		this.segments = new ArrayList<Segment>();
		for (int i = 0; i < this.length(); i++) {
			this.segments.add(new Segment(this));
		}
	}
	
	public Segment getSegment(int segmentNumber) {
		if (1 <= segmentNumber && segmentNumber <= this.length()) {
			return this.segments.get(segmentNumber - 1);
		}
		return null;
	}
	
	public int length() {
		return switch (this.type) {
		case "battleship" -> 4;
		case "carrier" -> 5;
		case "destroyer" -> 3;
		case "submarine" -> 3;
		case "patrol boat" -> 2;
		default -> 0;
		};
	}
	
	public String name() {
		return switch (this.type) {
		case "battleship" -> "Battleship";
		case "carrier" -> "Carrier";
		case "destroyer" -> "Destroyer";
		case "submarine" -> "Submarine";
		case "patrol boat" -> "Patrol Boat";
		default -> "?";
		};
	}

	public boolean sunk() {
		for (Segment s : this.segments) {
			if (!s.hit()) return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return switch (this.type) {
		case "battleship" -> "B";
		case "carrier" -> "C";
		case "destroyer" -> "D";
		case "submarine" -> "S";
		case "patrol boat" -> "P";
		default -> "?";
		};
	}

	public static Ship createShip(String type) {
		switch (type.toLowerCase()) {
		case "battleship", "carrier", "destroyer", "submarine", "patrol boat":
			return new Ship(type);
		default:
			return null;

		}
	}

}
