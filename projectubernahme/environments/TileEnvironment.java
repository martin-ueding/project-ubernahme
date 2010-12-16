package projectubernahme.environments;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class TileEnvironment implements Environment {

	private char[][] tiles;
	private BufferedImage bg;

	private BufferedImage tile_default;

	private int tileWidth = 100;
	private double tileWidthInReal = 0.25;

	private AffineTransform previousTransform;

	public TileEnvironment (String mapname) {

		ClassLoader cl = getClass().getClassLoader();

		try {

			tile_default = ImageIO.read(cl.getResourceAsStream("projectubernahme/gfx/tile_default.png"));

			InputStream fis = cl.getResourceAsStream("projectubernahme/environments/tilemap_"+mapname+".txt");

			byte[] text = new byte[fis.available()];

			fis.read(text);

			int spalten = 0, zeilen = 0;
			boolean erste = true;

			for (int i = 0; i < text.length; i++) {
				if (erste)
					if (text[i] != '\n' && text[i] != '\r')
						spalten++;

				if (text[i] == '\n' || text[i] == '\r') {
					zeilen++;
					erste = false;
				}
			}

			tiles = new char[spalten][zeilen];

			for (int i = 0; i < zeilen; i++) {
				for (int j = 0; j < spalten; j++) {
					tiles[j][i] = (char)text[i*(spalten+1)+j];
				}
			}



			fis.close();
		} catch (IOException e1) {
			System.out.println("Error while reading file");
			System.exit(1);
		}
	}

	public boolean isFreeBetween(double x1, double y1, double z1, double x2, double y2, double z2) {
		// TODO Auto-generated method stub
		return true;
	}

	public BufferedImage getBackground() {
		return bg;
	}

	public BufferedImage getBackground (int width, int height, AffineTransform transform) {

		// TODO check whether it was repainted already

		if (transform.equals(previousTransform)) {
			System.out.println("no need to paint");
		}
		else {
			System.out.println("need to paint");

			/* draw everything onto the background */

			bg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = (Graphics2D) bg.getGraphics();
			for (int i = 0; i < tiles[0].length; i++) {
				for (int j = 0; j < tiles.length; j++) {
					AffineTransform tileTransform = new AffineTransform();
					tileTransform.scale(1.0/tileWidth*tileWidthInReal, 1.0/tileWidth*tileWidthInReal);
					tileTransform.translate(j*tileWidth, i*tileWidth);
					tileTransform.preConcatenate(transform);
					g.drawImage(tile_default, tileTransform, null);

					//tiles[j][i] = (char)text[i*(spalten+1)+j];
					//System.out.println("drawing tile\t"+i+"\t"+j);
				}
			}
			previousTransform = (AffineTransform) transform.clone();

		}
		return bg;
	}

}
