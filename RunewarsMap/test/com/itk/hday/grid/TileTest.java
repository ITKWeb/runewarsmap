/**
 * 
 */
package com.itk.hday.grid;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.itk.hday.runewarsmaps.grid.Coordinates;
import com.itk.hday.runewarsmaps.grid.Tile;

/**
 * @author marc
 * 
 */
public class TileTest {

	/**
	 * Test method for
	 * {@link com.itk.hday.grid.TileTest#getNeigboorsCoordinates()}.
	 */
	@Test
	public void testGetNeigboorsCoordinates() {
		Tile tile = new Tile(5, 6);
		List<Coordinates> ncoordinates = tile.getNeigboorsCoordinates();
		assertTrue(ncoordinates.size() == 6);
		Iterator<Coordinates> iterator = ncoordinates.iterator();
		Coordinates coordinates = iterator.next();
		assertTrue(coordinates.getFirst() == 4 && coordinates.getSecond() == 5);
		coordinates = iterator.next();
		assertTrue(coordinates.getFirst() == 5 && coordinates.getSecond() == 5);
		coordinates = iterator.next();
		assertTrue(coordinates.getFirst() == 6 && coordinates.getSecond() == 6);
		coordinates = iterator.next();
		assertTrue(coordinates.getFirst() == 6 && coordinates.getSecond() == 7);
		coordinates = iterator.next();
		assertTrue(coordinates.getFirst() == 5 && coordinates.getSecond() == 7);
		coordinates = iterator.next();
		assertTrue(coordinates.getFirst() == 4 && coordinates.getSecond() == 6);
	}

}
