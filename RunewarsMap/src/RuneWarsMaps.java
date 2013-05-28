
import com.itk.hday.runewars.RWTilesSets;
import com.itk.hday.runewarsmaps.grid.Tile;

/**
 * @author marc
 * 
 */
public class RuneWarsMaps {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tile tile = new Tile(10, 7);
		System.out.println(tile);
		System.out.println("Voisins : " + tile.getNeigboorsCoordinates());
		System.out.println(RWTilesSets.getAllTilesSets());
		tile.setTileSet(RWTilesSets.getTilesSet(1));
		System.out.println(tile);
	}

}
