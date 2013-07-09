/**
 * 
 */
package com.itk.hday.grid;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.itk.hday.runewars.RWTilesSet;
import com.itk.hday.runewars.RWTilesSets;
import com.itk.hday.runewarsmaps.grid.Coordinates;
import com.itk.hday.runewarsmaps.grid.Grid;

/**
 * @author marc
 * 
 */
public class GridTest {

	@Test
	public void testAddTileSet() {
		RWTilesSet ts1 = RWTilesSets.getTilesSet(1);

		RWTilesSet ts2 = RWTilesSets.getTilesSet(2);
		ts2.rotate(5);

		Grid grid = new Grid();
		grid.addTileSet(ts1, new Coordinates(0, -1));
		grid.addTileSet(ts2, new Coordinates(-1, 1));
		assertTrue(grid.getCoordinates_Tiles().get(new Coordinates(0, -1))
				.getRwTile().equals(ts1.getFirstTile()));
		assertTrue(grid.getCoordinates_Tiles().get(new Coordinates(1, -1))
				.getRwTile().getCompletRef().equals("1B"));
		assertTrue(grid.getCoordinates_Tiles().get(new Coordinates(0, 0))
				.getRwTile().getCompletRef().equals("1C"));
		assertTrue(grid.getCoordinates_Tiles().get(new Coordinates(-1, 1))
				.getRwTile().getCompletRef().equals("2A"));
		assertTrue(grid.getCoordinates_Tiles().get(new Coordinates(0, 1))
				.getRwTile().getCompletRef().equals("2B"));
		assertTrue(grid.getCoordinates_Tiles().get(new Coordinates(1, 0))
				.getRwTile().getCompletRef().equals("2C"));
	}

}
