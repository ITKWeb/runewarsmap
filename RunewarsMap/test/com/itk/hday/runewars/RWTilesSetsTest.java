/**
 * 
 */
package com.itk.hday.runewars;

import static org.junit.Assert.*;

import org.junit.Test;

import com.itk.hday.runewars.RWTilesSets;

/**
 * @author marc
 * 
 */
public class RWTilesSetsTest {

	/**
	 * Test method for
	 * {@link com.itk.hday.runewars.RWTilesSets#getTilesSet(int)}.
	 */
	@Test
	public void testGetTilesSet() {
		assertNotNull(RWTilesSets.getTilesSet(1));
		assertTrue(RWTilesSets.getTilesSet(1).getReference() == 1);
	}

	/**
	 * Test method for
	 * {@link com.itk.hday.runewars.RWTilesSets#getTilesSets()}.
	 */
	@Test
	public void testGetTilesSets() {
		assertNotNull(RWTilesSets.getTilesSets());
	}

	/**
	 * Test method for
	 * {@link com.itk.hday.runewars.RWTilesSets#addTilesSet()}.
	 */
	@Test
	public void testAddTilesSet() {
		assertFalse(RWTilesSets.getAllTilesSets().isEmpty());
	}

}
