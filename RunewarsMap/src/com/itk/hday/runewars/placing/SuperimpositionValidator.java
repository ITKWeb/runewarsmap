/**
 * 
 */
package com.itk.hday.runewars.placing;

import com.itk.hday.runewarsmaps.grid.Grid;

/**
 * @author marc
 * 
 */
public class SuperimpositionValidator implements Validator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.itk.hday.runewars.placing.Validator#validate(com.itk.hday.runewarsmaps
	 * .grid.Grid)
	 */
	@Override
	public boolean validate(Grid grid) {
		return grid.getCoordinates_Tiles().values().size() == grid.getRWtiles()
				.size();
	}
}
