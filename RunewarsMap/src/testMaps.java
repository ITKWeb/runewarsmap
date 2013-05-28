import com.itk.hday.runewars.RWTile;
import com.itk.hday.runewars.RWTile.Orientation;
import com.itk.hday.runewars.RWTilesSet;
import com.itk.hday.runewars.RWTilesSets;
import com.itk.hday.runewarsmaps.grid.Coordinates;
import com.itk.hday.runewarsmaps.grid.Grid;

public class testMaps {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(RWTile.getOrientationAfterRotating(Orientation.NORD,
				7, false));
		RWTilesSet ts1 = RWTilesSets.getTilesSet(1);
		
		RWTilesSet ts2 = RWTilesSets.getTilesSet(2);
		ts2.rotate(5);

		Grid grid = new Grid();
		System.out.println(grid);
		grid.addTileSet(ts1, new Coordinates(1, 1));
		System.out.println(grid);
		grid.addTileSet(ts2, new Coordinates(-1, 0));
		System.out.println(grid);

	}

}
