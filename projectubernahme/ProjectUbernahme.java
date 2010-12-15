package projectubernahme;

import projectubernahme.interface2D.Interface2D;
import projectubernahme.simulator.MainSimulator;

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


/** the main game class */
public class ProjectUbernahme {
	/** main player */
	static Player player;
	static MainSimulator sim;
	

	public static void main (String[] args) {
		sim = new MainSimulator();

		player = new Player(sim);
		
		sim.addPlayer(player);
		
		@SuppressWarnings("unused")
		Interface2D interface2d = new Interface2D(sim, player);
	}
}
