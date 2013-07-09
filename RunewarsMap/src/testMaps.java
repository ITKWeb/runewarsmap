import com.itk.hday.runewars.RWTilesSet;
import com.itk.hday.runewars.RWTilesSets;
import com.itk.hday.runewars.placing.ValidatorsProcessor;
import com.itk.hday.runewarsmaps.grid.Coordinates;
import com.itk.hday.runewarsmaps.grid.Grid;

public class testMaps {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		RWTilesSet ts1 = RWTilesSets.getTilesSet(1);

		RWTilesSet ts2 = RWTilesSets.getTilesSet(2);
		ts2.rotate(5);

		Grid grid = new Grid();
		System.out.println(grid);
		grid.addTileSet(ts1, new Coordinates(0, -1));
		System.out.println(grid);
		grid.addTileSet(ts2, new Coordinates(0, 0));
		System.out.println(grid);
		System.out.println(ValidatorsProcessor.getInstance().validate(grid));

	}

}
