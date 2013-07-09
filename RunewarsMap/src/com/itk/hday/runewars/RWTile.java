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
		NORD, NORD_EST, SUD_EST, SUD, SUD_OUEST, NORD_OUEST
	}

	private char tileRef;
	private RWTilesSet rwTilesSet;
	private Map<Orientation, RWTile> neighbors = new HashMap<RWTile.Orientation, RWTile>();
	private Coordinates relativeCoordinates;
	private static Map<Orientation, Orientation> nextOrientations;

	public RWTile(char letter) {
		setTileRef(letter);
	}

	public String getCompletRef() {
		return getTilesSetRef() + String.valueOf(getTileRef());
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
			return new Coordinates(coord.getFirst(), coord.getSecond() - 1);
		case SUD:
			return new Coordinates(coord.getFirst(), coord.getSecond() + 1);
		case NORD_EST:
			return new Coordinates(coord.getFirst() + 1, coord.getSecond() - 1);
		case NORD_OUEST:
			return new Coordinates(coord.getFirst() - 1, coord.getSecond());
		case SUD_EST:
			return new Coordinates(coord.getFirst() + 1, coord.getSecond());
		case SUD_OUEST:
			return new Coordinates(coord.getFirst() - 1, coord.getSecond() + 1);
		default:
			return null;
		}
	}

	public void rotate(int nbRotations) {
		Map<Orientation, RWTile> newneighbors = new HashMap<RWTile.Orientation, RWTile>();
		for (Entry<Orientation, RWTile> neighbor : getNeighbors().entrySet()) {
			newneighbors
					.put(getOrientationAfterRotating(neighbor.getKey(),
							nbRotations), neighbor.getValue());
		}
		setNeighbors(newneighbors);
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

	public static Orientation getOrientationAfterRotating(
			Orientation originalOrientation, int nbRotation) {
		return getOrientationAfterRotating(originalOrientation, nbRotation,
				true);
	}

	public static Orientation getOrientationAfterRotating(
			Orientation originalOrientation, int nbRotation, boolean clockwise) {
		nbRotation = nbRotation % 6;
		if (!clockwise) {
			nbRotation = 6 - nbRotation;
		}
		Orientation orientation = originalOrientation;
		for (int i = 0; i < nbRotation; i++) {
			orientation = getNextOrientations().get(orientation);
		}
		return orientation;
	}

	public static Map<Orientation, Orientation> getNextOrientations() {
		if (nextOrientations == null) {
			nextOrientations = new HashMap<Orientation, Orientation>();
			nextOrientations.put(Orientation.NORD, Orientation.NORD_EST);
			nextOrientations.put(Orientation.NORD_EST, Orientation.SUD_EST);
			nextOrientations.put(Orientation.SUD_EST, Orientation.SUD);
			nextOrientations.put(Orientation.SUD, Orientation.SUD_OUEST);
			nextOrientations.put(Orientation.SUD_OUEST, Orientation.NORD_OUEST);
			nextOrientations.put(Orientation.NORD_OUEST, Orientation.NORD);
		}
		return nextOrientations;
	}

	public void setNeighbors(Map<Orientation, RWTile> neighbors) {
		this.neighbors = neighbors;
	}

}
