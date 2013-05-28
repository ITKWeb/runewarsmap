/**
 * 
 */
package com.itk.hday.runewarsmaps.grid;

/**
 * @author marc
 * 
 */
public class Coordinates extends Couple<Integer, Integer> {

	public Coordinates(Integer first, Integer second) {
		super(first, second);
	}

	@Override
	public String toString() {
		return "(x = " + getFirst() + " ; y = " + getSecond() + ")";
	}

	public Coordinates add(Coordinates relativeCoordinates) {
		return new Coordinates(getFirst() + relativeCoordinates.getFirst(),
				getSecond() + relativeCoordinates.getSecond());
	}

}
