import java.util.ArrayList;

public class Player {
	ArrayList<PlayerBlob> blobs;

	/** initializes the list of blobs, add a starting one */
	public Player () {
		blobs = new ArrayList<PlayerBlob>();

		blobs.add(new PlayerBlob());
	}
}
