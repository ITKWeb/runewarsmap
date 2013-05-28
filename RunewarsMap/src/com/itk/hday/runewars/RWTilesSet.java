/**
 * 
 */
package com.itk.hday.runewars;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.itk.hday.runewars.RWTile.Orientation;
import com.itk.hday.runewarsmaps.grid.Coordinates;

/**
 * @author marc
 * 
 */
public class RWTilesSet {

	private int reference;
	private Map<Character, RWTile> rWTiles;
	private Orientation orientation;

	public RWTilesSet(int reference, Map<Character, RWTile> tilesMap) {
		setReference(reference);
		setRWTiles(tilesMap);
		for (RWTile rwtile : tilesMap.values()) {
			rwtile.setRWTilesSet(this);
		}
		updateRelativeCoordinates();
		setOrientation(Orientation.NORD);
	}

	public void rotate(int nbRotations) {
		for (RWTile tile : getRWTiles().values()) {
			tile.rotate(nbRotations);
		}
		updateRelativeCoordinates();
	}

	protected void updateRelativeCoordinates() {
		for (RWTile tile : getRWTiles().values()) {
			tile.setRelativeCoordinates(null);
		}
		RWTile firstTile = getFirstTile();
		firstTile.setRelativeCoordinates(new Coordinates(0, 0));
		ConcurrentLinkedQueue<RWTile> queue = new ConcurrentLinkedQueue<RWTile>();
		queue.add(firstTile);
		Iterator<RWTile> ite = queue.iterator();
		while (ite.hasNext()) {
			RWTile tile = ite.next();
			for (Entry<Orientation, RWTile> neighbor : tile.getNeighbors()
					.entrySet()) {
				if (neighbor.getValue().getRelativeCoordinates() == null) {
					neighbor.getValue().setRelativeCoordinates(
							tile.findRelativeCoordinates(neighbor.getKey()));
					queue.add(neighbor.getValue());
				}
			}

		}

	}

	/**
	 * @return the reference
	 */
	public int getReference() {
		return reference;
	}

	/**
	 * @param reference
	 *            the reference to set
	 */
	public void setReference(int reference) {
		this.reference = reference;
	}

	public String toString() {
		return "Tuile numéro : " + getReference() + " - "
				+ getRWTiles().values();
	}

	public Map<Character, RWTile> getRWTiles() {
		return rWTiles;
	}

	public void setRWTiles(Map<Character, RWTile> rWTiles) {
		this.rWTiles = rWTiles;
	}

	public RWTile getFirstTile() {
		return getRWTiles().get('A');
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

}
