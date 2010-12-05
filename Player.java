import java.util.ArrayList;

public class Player {
	ArrayList<PlayerBlob> blobs;

	/** initializes the list of blobs, add a starting one */
	public Player () {
		System.out.println(Localizer.get("You are a blob of something. Somewhere, you do not really know where you are actually."));
		blobs = new ArrayList<PlayerBlob>();

		blobs.add(new PlayerBlob());
	}

	public void play () {
		/* the game continues as long as there are blobs in control of the player */
		while (blobs.size() > 0) {
			/* select which unit to use */

			/* use the selected unit */

			/* let the other blobs interact with you */
			for (PlayerBlob blob : ProjectUbernahme.globalBlobs) {
				
			}

			/* remove the first blob to get the game over */
			blobs.remove(blobs.get(0));
		}

		System.out.println(Localizer.get("Game Over"));
	}
}
