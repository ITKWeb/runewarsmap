/**
 * 
 */
package com.itk.hday.runewars;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.itk.hday.runewars.RWTile.Orientation;

/**
 * @author marc
 * 
 */
public final class RWTilesSetsFactory {

	protected Logger logger = Logger.getLogger(RWTilesSetsFactory.class
			.getName());

	private RWTilesSetsFactory() {
	}

	private static RWTilesSetsFactory instance = null;

	public RWTilesSet buildTilesSet(int reference, int nbTiles, String links) {
		RWTilesSet tilesSet = null;
		try {
			Map<Character, RWTile> tilesMap = getTilesFromRefs(nbTiles);
			String[] linkArray = getLinkList(links);
			for (String link : linkArray) {
				addLink(tilesMap, link);
			}
			tilesSet = new RWTilesSet(reference, tilesMap);

		} catch (Exception e) {
			logger.log(Level.SEVERE,
					"Impossible de créer un ensemble de tuiles à parir de : "
							+ links);
			e.printStackTrace();
		}
		return tilesSet;
	}

	protected void addLink(Map<Character, RWTile> tilesMap, String link) throws Exception {
		try {
			String[] linkElements = link.split(":");
			char first = linkElements[0].charAt(0);
			char second = linkElements[1].charAt(0);
			Orientation orientation = Orientation.valueOf(linkElements[2]);
			tilesMap.get(first).addLink(tilesMap.get(second), orientation);
		} catch (Exception e) {
			logger.log(Level.SEVERE,
					"Impossible de créer un lien à partir de : " + link);
			throw e;
		}

	}

	protected String[] getLinkList(String links) {
		return links.split(",");
	}

	protected Map<Character, RWTile> getTilesFromRefs(int nbTiles) {
		Map<Character, RWTile> tilesMap = new HashMap<Character, RWTile>();
		char letter = 'A';
		for (int i = 0; i < nbTiles; i++) {
			RWTile tile = new RWTile(letter);
			tilesMap.put(new Character(letter), tile);

			letter++;
		}
		return tilesMap;
	}

	public static synchronized RWTilesSetsFactory getInstance() {
		if (instance == null) {
			instance = new RWTilesSetsFactory();
		}
		return instance;
	}

}
