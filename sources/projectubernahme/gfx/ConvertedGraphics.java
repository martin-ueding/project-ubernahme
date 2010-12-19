package projectubernahme.gfx;

import java.awt.Graphics2D;

import javax.swing.Icon;

public abstract class ConvertedGraphics implements Icon {

	public abstract int getIconWidth();

	public abstract int getIconHeight();

	public abstract int getOrigHeight();

	public abstract int getOrigWidth();

	public abstract int getOrigY();

	public abstract int getOrigX();

	public abstract void paint(Graphics2D g);

}
