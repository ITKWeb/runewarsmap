/**
 * 
 */
package com.itk.hday.runewarsmaps.grid;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.itk.hday.runewars.RWTile;
import com.itk.hday.runewars.RWTilesSet;

/**
 * @author marc
 * 
 */
public class Grid {

	Map<Coordinates, Tile> coordinates_tiles = new HashMap<Coordinates, Tile>();

	Set<RWTile> RWtiles = new HashSet<RWTile>();

	public void addTileSet(RWTilesSet rwTilesSet, Coordinates coordinates) {
		for (RWTile rwtile : rwTilesSet.getRWTiles().values()) {
			getRWtiles().add(rwtile);
			Coordinates coord = coordinates
					.add(rwtile.getRelativeCoordinates());
			Tile tile = getCoordinates_Tiles().get(coord);
			if (tile == null) {
				tile = new Tile(coord);
				getCoordinates_Tiles().put(coord, tile);
			}
			tile.setRwTile(rwtile);
		}

	}

	@Override
	public String toString() {
		String result = "";
		for (Tile tile : getCoordinates_Tiles().values()) {
			result += tile.toString() + "\n";
		}
		return result;
	}

	public Map<Coordinates, Tile> getCoordinates_Tiles() {
		return coordinates_tiles;
	}

	public void setCoordinates_Tiles(Map<Coordinates, Tile> coordinates_tiles) {
		this.coordinates_tiles = coordinates_tiles;
	}

	public Set<RWTile> getRWtiles() {
		return RWtiles;
	}

}
