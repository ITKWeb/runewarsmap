/**
 * 
 */
package com.itk.hday.runewars;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author marc
 * 
 */
public final class RWTilesSets {
	private static Map<Integer, RWTilesSet> tilesSets;

	public static RWTilesSet getTilesSet(int reference) {
		return getTilesSets().get(reference);
	}

	protected static Map<Integer, RWTilesSet> getTilesSets() {
		if (tilesSets == null) {
			tilesSets = new HashMap<Integer, RWTilesSet>();
			addTilesSet();
		}
		return tilesSets;
	}

	protected static void addTilesSet() {
		tilesSets.put(
				1,
				RWTilesSetsFactory.getInstance().buildTilesSet(1, 3,
						"A:B:SUD_EST,A:C:SUD,B:C:SUD_OUEST"));
	}

	public static Collection<RWTilesSet> getAllTilesSets() {
		return getTilesSets().values();
	}

}
