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
import com.itk.hday.runewars.RWTilesSetsFactory;
import com.itk.hday.runewars.RWTile.Orientation;

/**
 * @author marc
 * 
 */
public class RWTilesSetsFactoryTest {

	/**
	 * Test method for
	 * {@link com.itk.hday.runewars.RWTilesSetsFactory#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		assertTrue(RWTilesSetsFactory.getInstance() != null);
	}

	/**
	 * Test method for
	 * {@link com.itk.hday.runewars.RWTilesSetsFactory#buildTilesSet(int, int, java.lang.String)}
	 * .
	 */
	@Test
	public void testBuildTilesSet() {
		RWTilesSet rwTilesSet = RWTilesSetsFactory.getInstance().buildTilesSet(
				1, 3, "A:B:SUD_EST,A:C:SUD,B:C:SUD_OUEST");
		assertNotNull(rwTilesSet);
	}

	/**
	 * Test method for
	 * {@link com.itk.hday.runewars.RWTilesSetsFactory#addLink(java.util.Map, java.lang.String)}
	 * .
	 * @throws Exception 
	 */
	@Test
	public void testAddLink() throws Exception {
		Map<Character, RWTile> map = new HashMap<Character, RWTile>();
		RWTile ta = new RWTile('A');
		map.put('A', ta);
		RWTile tb = new RWTile('B');
		map.put('B', tb);
		RWTilesSetsFactory.getInstance().addLink(map, "A:B:SUD_EST");
		assertTrue(ta.getNeighbor(Orientation.SUD_EST).equals(tb));
		assertTrue(tb.getNeighbor(Orientation.NORD_OUEST).equals(ta));
	}

	/**
	 * Test method for
	 * {@link com.itk.hday.runewars.RWTilesSetsFactory#getLinkList(java.lang.String)}
	 * .
	 */
	@Test
	public void testGetLinkList() {
		String[] split = { "A:B:SUD_EST", "A:C:SUD", "B:C:SUD_OUEST" };
		assertArrayEquals(
				split,
				RWTilesSetsFactory.getInstance().getLinkList(
						"A:B:SUD_EST,A:C:SUD,B:C:SUD_OUEST"));
	}

	/**
	 * Test method for
	 * {@link com.itk.hday.runewars.RWTilesSetsFactory#getTilesFromRefs(int)}
	 * .
	 */
	@Test
	public void testGetTilesFromRefs() {
		Map<Character, RWTile> map = RWTilesSetsFactory.getInstance()
				.getTilesFromRefs(3);
		assertTrue(map.size() == 3);
		assertNotNull(map.get('A'));
		assertTrue(map.get('A').getTileRef() == 'A');
		assertNotNull(map.get('B'));
		assertTrue(map.get('B').getTileRef() == 'B');
		assertNotNull(map.get('C'));
		assertTrue(map.get('C').getTileRef() == 'C');
	}

}
