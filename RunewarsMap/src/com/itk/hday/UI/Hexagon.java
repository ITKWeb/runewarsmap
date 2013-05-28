package com.itk.hday.UI;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.itk.hday.R;
import com.itk.hday.runewarsmaps.grid.Coordinates;


@SuppressLint("NewApi") public class Hexagon extends Activity{
	
	private Coordinates _coordonatesScreen;
	
	
	public Hexagon(int x, int y) {
		set_coordonates(new Coordinates(x, y));
	}


	public Coordinates get_coordonates() {
		return _coordonatesScreen;
	}


	public void set_coordonates(Coordinates _coordonates) {
		this._coordonatesScreen = _coordonates;
	}
	
	/*public void firstDraw(){
		setContentView(R.layout.runwars_gameboard);
		ImageView tuile = new ImageView(Hexagon.this);
		tuile.setX(100);
		tuile.setY(100);
		tuile.getLayoutParams().height = 20;
		tuile.getLayoutParams().width = 20;
		tuile.setImageResource(R.drawable.tuiles_1a);
		FrameLayout frameLayout = (FrameLayout)findViewById(R.id.gameboard);
		frameLayout.addView(tuile);
	}*/
	
	public void draw(){
		setContentView(R.layout.runwars_gameboard);
		ImageView tuile = new ImageView(Hexagon.this);
		tuile.setX(_coordonatesScreen.getFirst());
		tuile.setY(_coordonatesScreen.getSecond());
		tuile.getLayoutParams().height = 100;
		tuile.getLayoutParams().width = 100;
		tuile.setImageResource(R.drawable.tuiles_1b);
		FrameLayout frameLayout = (FrameLayout)findViewById(R.id.gameboard);
		frameLayout.addView(tuile);
	}
	
	/*public Coordinates tuilePosition(Hexagon tuileDepart, int x, int y){
		
		Coordinates coordonatesOnScreen;
		float xscreen = tuileDepart._coordonatesScreen.getFirst();
		float yscreen = tuileDepart._coordonatesScreen.getSecond();
		if((x == 1) && (y == 1)){
			yscreen	= tuileDepart._coordonatesScreen.getSecond() + 100;
		}
		coordonatesOnScreen.setFirst(xscreen);
		coordonatesOnScreen.setSecond(yscreen);
		return coordonatesOnScreen;
		
	}*/

}
