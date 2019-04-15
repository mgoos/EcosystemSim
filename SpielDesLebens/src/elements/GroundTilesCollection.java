package elements;

import java.util.ArrayList;

public class GroundTilesCollection {

	static ArrayList<FloorTiles> allTheGroundTiles = new ArrayList<>();

	public static ArrayList<FloorTiles> getAllTheGroundTiles() {
		return allTheGroundTiles;
	}

	public static void addGroundTiles(FloorTiles floorTile) {
		getAllTheGroundTiles().add(floorTile);

	}

	public static void setAllTheGroundTiles(ArrayList<FloorTiles> allTheGroundTiles) {
		GroundTilesCollection.allTheGroundTiles = allTheGroundTiles;
	}

	public static void ageAllTheFloorTiles() {
		for (FloorTiles e : GroundTilesCollection.allTheGroundTiles) {
			if (e.getAge() > 0) {
				e.setAge(e.getAge() - 1);
			}
		}
	}

}
