/**
 * 
 */
package com.itk.hday.runewars;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.itk.hday.runewars.RWTile.Orientation;
import com.itk.hday.runewarsmaps.grid.Coordinates;

/**
 * @author marc
 * 
 */
public class RWTileTest {

	/**
	 * Test method for
	 * {@link com.itk.hday.runewars.RWTile#setNeighbor(com.itk.hday.runewars.RWTile, com.itk.hday.runewars.RWTile.Orientation)}
	 * .
	 */
	@Test
	public void testSetNeighbor() {
		RWTile ta = new RWTile('A');
		RWTile tb = new RWTile('B');
		ta.setNeighbor(tb, Orientation.SUD_EST);
		assertTrue(ta.getNeighbor(Orientation.SUD_EST) == tb);
		assertNull(ta.getNeighbor(Orientation.NORD));
		assertNull(ta.getNeighbor(Orientation.NORD_OUEST));
	}

	/**
	 * Test method for
	 * {@link com.itk.hday.runewars.RWTile#addLink(com.itk.hday.runewars.RWTile, com.itk.hday.runewars.RWTile.Orientation)}
	 * .
	 */
	@Test
	public void testAddLink() {
		RWTile ta = new RWTile('A');
		RWTile tb = new RWTile('B');
		ta.addLink(tb, Orientation.SUD_EST);
		assertTrue(ta.getNeighbor(Orientation.SUD_EST) == tb);
		assertNull(ta.getNeighbor(Orientation.NORD));
		assertNull(ta.getNeighbor(Orientation.NORD_OUEST));
		assertTrue(tb.getNeighbor(Orientation.NORD_OUEST) == ta);
		assertNull(tb.getNeighbor(Orientation.NORD));
		assertNull(tb.getNeighbor(Orientation.SUD_EST));
	}

	/**
	 * Test method for
	 * {@link com.itk.hday.runewars.RWTile#findRelativeCoordinates(com.itk.hday.runewars.RWTile, com.itk.hday.runewars.RWTile.Orientation)}
	 * .
	 */
	@Test
	public void testfindRelativeCoordinates() {
		RWTile ta = new RWTile('A');
		ta.setRelativeCoordinates(new Coordinates(0, 0));
		assertTrue(ta.findRelativeCoordinates(Orientation.NORD).equals(
				new Coordinates(0, -1)));
		assertTrue(ta.findRelativeCoordinates(Orientation.SUD).equals(
				new Coordinates(0, 1)));
		assertTrue(ta.findRelativeCoordinates(Orientation.NORD_EST).equals(
				new Coordinates(1, -1)));
		assertTrue(ta.findRelativeCoordinates(Orientation.NORD_OUEST).equals(
				new Coordinates(-1, 0)));
		assertTrue(ta.findRelativeCoordinates(Orientation.SUD_EST).equals(
				new Coordinates(1, 0)));
		assertTrue(ta.findRelativeCoordinates(Orientation.SUD_OUEST).equals(
				new Coordinates(-1, 1)));
	}

	@Test
	public void testgetOrientationAfterRotating() {
		assertTrue(RWTile.getOrientationAfterRotating(Orientation.NORD, 7,
				false).equals(Orientation.NORD_OUEST));
	}
}
