/**
 * 
 */
package com.itk.hday.runewarsmaps.grid;

/**
 * @author marc
 * 
 */
public class Couple<T1, T2> {
	private T1 first;
	private T2 second;

	public Couple(T1 first, T2 second) {
		this.first = first;
		this.second = second;
	}

	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o.getClass() != this.getClass()) {
			return false;
		}
		@SuppressWarnings("unchecked")
		Couple<T1, T2> couple = (Couple<T1, T2>) o;
		return couple.getFirst().equals(getFirst())
				&& couple.getSecond().equals(getSecond());
	}

	/**
	 * @return the first
	 */
	public T1 getFirst() {
		return first;
	}

	/**
	 * @param first
	 *            the first to set
	 */
	public void setFirst(T1 first) {
		this.first = first;
	}

	/**
	 * @return the second
	 */
	public T2 getSecond() {
		return second;
	}

	/**
	 * @param second
	 *            the second to set
	 */
	public void setSecond(T2 second) {
		this.second = second;
	}
}
