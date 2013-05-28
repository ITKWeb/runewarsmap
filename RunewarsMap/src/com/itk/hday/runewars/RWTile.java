/**
 * 
 */
package com.itk.hday.runewars;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.itk.hday.runewarsmaps.grid.Coordinates;

/**
 * @author marc
 * 
 */

public class RWTile {

	public enum Orientation {
		NORD, SUD, NORD_OUEST, NORD_EST, SUD_EST, SUD_OUEST
	}

	private char tileRef;
	private RWTilesSet rwTilesSet;
	private Map<Orientation, RWTile> neighbors = new HashMap<Orientation, RWTile>();
	private Coordinates relativeCoordinates;

	public RWTile(char letter) {
		setTileRef(letter);
	}

	public RWTile getNeighbor(Orientation orientation) {
		return neighbors.get(orientation);
	}

	public Map<Orientation, RWTile> getNeighbors() {
		return neighbors;
	}

	/**
	 * @return the tileNumber
	 */
	public char getTileRef() {
		return tileRef;
	}

	/**
	 * @param tileNumber
	 *            the tileNumber to set
	 */
	public void setTileRef(char tileRef) {
		this.tileRef = tileRef;
	}

	public void addLink(RWTile rwTile, Orientation orientation) {
		this.setNeighbor(rwTile, orientation);
		if (getRelativeCoordinates() != null
				&& rwTile.getRelativeCoordinates() == null) {
			rwTile.setRelativeCoordinates(findRelativeCoordinates(orientation));
		}
		rwTile.setNeighbor(this, getOppositeOrientation(orientation));
	}

	protected Coordinates findRelativeCoordinates(Orientation orientation) {
		Coordinates coord = getRelativeCoordinates();
		switch (orientation) {
		case NORD:
			return new Coordinates(coord.getFirst() + 1, coord.getSecond() + 1);
		case SUD:
			return new Coordinates(coord.getFirst() - 1, coord.getSecond() - 1);
		case NORD_EST:
			return new Coordinates(coord.getFirst(), coord.getSecond() + 1);
		case NORD_OUEST:
			return new Coordinates(coord.getFirst() + 1, coord.getSecond());
		case SUD_EST:
			return new Coordinates(coord.getFirst() - 1, coord.getSecond());
		case SUD_OUEST:
			return new Coordinates(coord.getFirst(), coord.getSecond() - 1);
		default:
			return null;
		}
	}

	protected void setNeighbor(RWTile rwTile, Orientation orientation) {
		getNeighbors().put(orientation, rwTile);
	}

	protected Orientation getOppositeOrientation(Orientation orientation) {
		switch (orientation) {
		case NORD:
			return Orientation.SUD;
		case SUD:
			return Orientation.NORD;
		case NORD_EST:
			return Orientation.SUD_OUEST;
		case NORD_OUEST:
			return Orientation.SUD_EST;
		case SUD_EST:
			return Orientation.NORD_OUEST;
		case SUD_OUEST:
			return Orientation.NORD_EST;
		default:
			return null;
		}

	}

	public String toString() {
		String neighbors = "";
		for (Entry<Orientation, RWTile> neighbor : getNeighbors().entrySet()) {
			if (!neighbors.equals("")) {
				neighbors += "-";
			}
			neighbors += neighbor.getKey() + ":"
					+ neighbor.getValue().getTileRef();
		}
		String coord = "Pas de Coordonnées";
		if (getRelativeCoordinates() != null) {
			coord = getRelativeCoordinates().toString();
		}
		return getTileRef() + " " + coord + " (Voisins : " + neighbors + ")";
	}

	public RWTilesSet getRWTilesSet() {
		return rwTilesSet;
	}

	public void setRWTilesSet(RWTilesSet rwTilesSet) {
		this.rwTilesSet = rwTilesSet;
	}

	public int getTilesSetRef() {
		return getRWTilesSet().getReference();
	}

	/**
	 * @return the relativeCoordinates
	 */
	public Coordinates getRelativeCoordinates() {
		return relativeCoordinates;
	}

	/**
	 * @param relativeCoordinates
	 *            the relativeCoordinates to set
	 */
	protected void setRelativeCoordinates(Coordinates relativeCoordinates) {
		this.relativeCoordinates = relativeCoordinates;
	}

}
