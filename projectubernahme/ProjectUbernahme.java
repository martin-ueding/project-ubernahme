package projectubernahme;
/*
 * Copyright 2010 Project Ubernahme Team
 * Copyright 2010 Martin Ueding <dev@martin-ueding.de>
 * 
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
import java.util.ArrayList;

import projectubernahme.lifeforms.Lifeform;
import projectubernahme.lifeforms.LifeformHuman;


/** the main game class */
public class ProjectUbernahme {
	/** main player */
	static Player player;

	/** list of all lifeforms in the whole game which are not controlled by the player */
	private static ArrayList<Lifeform> npcLifeforms;

	public static void main (String[] args) {
		setNpcLifeforms(new ArrayList<Lifeform>());

		/* add some NPCs to the game */
		for (int i = 0; i < 5; i++) {
			getNpcLifeforms().add(new LifeformHuman());
		}

		System.out.println(Localizer.get("Welcome to Project Ubernahme"));
		System.out.println(Localizer.get("You can quit the game any time by entering either “q” or “quit”"));

		player = new Player();


		player.play();
	}

	public static void setNpcLifeforms(ArrayList<Lifeform> npcLifeforms) {
		ProjectUbernahme.npcLifeforms = npcLifeforms;
	}

	public static ArrayList<Lifeform> getNpcLifeforms() {
		return npcLifeforms;
	}
}
