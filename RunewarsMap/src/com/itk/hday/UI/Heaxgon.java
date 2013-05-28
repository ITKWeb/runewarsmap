package com.itk.hday.UI;


import com.itk.hday.runewarsmaps.grid.Coordinates;


public class Heaxgon {
	
	private Coordinates _coordonates;
	private int _size;
	
	
	public Heaxgon(int x, int y, int size) {
		set_coordonates(new Coordinates(x, y));
		set_size(size);
	}


	public Coordinates get_coordonates() {
		return _coordonates;
	}


	public void set_coordonates(Coordinates _coordonates) {
		this._coordonates = _coordonates;
	}


	public int get_size() {
		return _size;
	}


	public void set_size(int _size) {
		if(_size > 0 ) this._size = _size;
	}

}
