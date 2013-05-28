import com.itk.hday.runewars.RWTile;
import com.itk.hday.runewars.RWTile.Orientation;
import com.itk.hday.runewars.RWTilesSet;
import com.itk.hday.runewars.RWTilesSets;

public class testMaps {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(RWTile.getOrientationAfterRotating(Orientation.NORD,
				7, false));
		RWTilesSet ts = RWTilesSets.getTilesSet(1);
		System.out.println(ts);
		ts.rotate(2);
		System.out.println(ts);
		ts.rotate(2);
		System.out.println(ts);
		ts.rotate(2);
		System.out.println(ts);
	}

}
