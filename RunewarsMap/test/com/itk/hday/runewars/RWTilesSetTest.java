/**
 * 
 */
package com.itk.hday.runewars;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.itk.hday.runewars.RWTile;
import com.itk.hday.runewars.RWTilesSet;

/**
 * @author marc
 * 
 */
public class RWTilesSetTest {

	/**
	 * Test method for
	 * {@link com.itk.hday.runewars.RWTilesSet#RWTilesSet(int, java.util.Map)}
	 * .
	 */
	@Test
	public void testRWTilesSet() {
		Map<Character, RWTile> map = new HashMap<Character, RWTile>();
		map.put('A', new RWTile('A'));
		map.put('B', new RWTile('B'));
		RWTilesSet set = new RWTilesSet(1, map);
		assertNotNull(set);
	}

	/**
	 * Test method for
	 * {@link com.itk.hday.runewars.RWTilesSet#getFirstTile()}.
	 */
	@Test
	public void testGetFirstTile() {
		Map<Character, RWTile> map = new HashMap<Character, RWTile>();
		RWTile ta = new RWTile('A');
		map.put('A', ta);
		map.put('B', new RWTile('B'));
		RWTilesSet set = new RWTilesSet(1, map);
		assertTrue(set.getFirstTile().equals(ta));
	}

}
