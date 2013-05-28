/**
 * 
 */
package com.itk.hday.runewarsmaps.grid;

import java.util.HashMap;
import java.util.Map;

import com.itk.hday.runewars.RWTile;
import com.itk.hday.runewars.RWTilesSet;

/**
 * @author marc
 * 
 */
public class Grid {

	Map<Coordinates, Tile> tiles = new HashMap<Coordinates, Tile>();

	public void addTileSet(RWTilesSet rwTilesSet, Coordinates coordinates) {

		for (RWTile rwtile : rwTilesSet.getRWTiles().values()) {
			Coordinates coord = coordinates
					.add(rwtile.getRelativeCoordinates());
			Tile tile = getTiles().get(coord);
			if (tile == null) {
				tile = new Tile(coord);
				getTiles().put(coord, tile);
			}
			tile.setRwTile(rwtile);
		}

	}

	@Override
	public String toString() {
		String result = "";
		for (Tile tile : getTiles().values()) {
			result += tile.toString() + "\n";
		}
		return result;
	}

	public Map<Coordinates, Tile> getTiles() {
		return tiles;
	}

	public void setTiles(Map<Coordinates, Tile> tiles) {
		this.tiles = tiles;
	}

}
