/**
 * 
 */
package com.itk.hday.runewarsmaps.grid;

import java.util.ArrayList;
import java.util.List;

import com.itk.hday.runewars.RWTile;

/**
 * @author marc
 * 
 */
public class Tile {

	private Coordinates coordinates;
	private RWTile rwTile = null;

	public Tile(int i, int j) {
		setCoordinates(i, j);
	}

	public Tile(Coordinates coord) {
		setCoordinates(coord);
	}

	public void setCoordinates(int i, int j) {
		setCoordinates(new Coordinates(i, j));
	}

	/**
	 * @return the coordinates
	 */
	public Couple<Integer, Integer> getCoordinates() {
		return coordinates;
	}

	/**
	 * @param coordinates
	 *            the coordinates to set
	 */
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public List<Coordinates> getNeigboorsCoordinates() {
		List<Coordinates> nCoordinates = new ArrayList<Coordinates>();
		nCoordinates.add(new Coordinates(getCoordinates().getFirst() - 1,
				getCoordinates().getSecond() - 1));
		nCoordinates.add(new Coordinates(getCoordinates().getFirst(),
				getCoordinates().getSecond() - 1));
		nCoordinates.add(new Coordinates(getCoordinates().getFirst() + 1,
				getCoordinates().getSecond()));
		nCoordinates.add(new Coordinates(getCoordinates().getFirst() + 1,
				getCoordinates().getSecond() + 1));
		nCoordinates.add(new Coordinates(getCoordinates().getFirst(),
				getCoordinates().getSecond() + 1));
		nCoordinates.add(new Coordinates(getCoordinates().getFirst() - 1,
				getCoordinates().getSecond()));
		return nCoordinates;
	}

	public String toString() {
		String rwTile;
		if (getRwTile() == null) {
			rwTile = "Vide";
		} else {
			rwTile = String.valueOf(getRwTile().getTilesSetRef())
					+ getRwTile().getTileRef();
		}
		return "Coordonnées : " + getCoordinates().toString() + " - Tuile : "
				+ rwTile;
	}

	/**
	 * @return the rwTile
	 */
	public RWTile getRwTile() {
		return rwTile;
	}

	/**
	 * @param rwTile
	 *            the rwTile to set
	 */
	public void setRwTile(RWTile rwTile) {
		this.rwTile = rwTile;
	}

}
