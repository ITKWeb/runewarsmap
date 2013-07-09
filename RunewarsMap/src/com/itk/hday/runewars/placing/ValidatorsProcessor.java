/**
 * 
 */
package com.itk.hday.runewars.placing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.itk.hday.runewarsmaps.grid.Grid;

/**
 * @author marc
 * 
 */
public class ValidatorsProcessor {

	private static ValidatorsProcessor INSTANCE = null;

	private ValidatorsProcessor() {
		addValidator(new SuperimpositionValidator());
	}

	List<Validator> validators = new ArrayList<Validator>();

	public boolean validate(Grid grid) {
		boolean validate = true;
		Iterator<Validator> ite = getValidators().listIterator();
		while (validate && ite.hasNext()) {
			Validator validator = ite.next();
			if (!validator.validate(grid)) {
				validate = false;
			}
		}
		return validate;
	}

	public List<Validator> getValidators() {
		return validators;
	}

	public boolean addValidator(Validator validator) {
		return getValidators().add(validator);
	}

	public static ValidatorsProcessor getInstance() {
		if (INSTANCE == null) {
			synchronized (ValidatorsProcessor.class) {
				if (INSTANCE == null) {
					INSTANCE = new ValidatorsProcessor();
				}
			}
		}
		return INSTANCE;
	}

}
