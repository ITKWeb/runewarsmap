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

}
