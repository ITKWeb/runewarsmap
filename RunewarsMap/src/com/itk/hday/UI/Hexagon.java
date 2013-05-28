package com.itk.hday.UI;


import android.app.Activity;
import android.graphics.Paint;
import android.widget.ImageView;

import com.itk.hday.R;
import com.itk.hday.runewarsmaps.grid.Coordinates;


public class Hexagon extends Activity{
	
	private Coordinates _coordonates;
	private int _size;
	
	
	public Hexagon(int x, int y, int size) {
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
	
	public void draw(){
		/*setContentView(R.layout.runwars_gameboard);
		ImageView tuile = (ImageView) findViewById(R.id.tuile1);
		tuile.setImageResource(R.drawable.tuiles_1);*/

	}

}
