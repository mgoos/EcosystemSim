package model;

import elements.FloorTiles;
import elements.GroundTilesCollection;

public class GrowthNearby {

	FloorTiles dummyFloor = new FloorTiles(99, 99);

	public void growNearby(FloorTiles flrTile) {

		boolean growthDone = false;
		int x = flrTile.getX();
		int y = flrTile.getY();

		String north = ((x - 1) + "-" + y);
		String south = ((x + 1) + "-" + y);
		String west = x + "-" + (y - 1);
		String east = x + "-" + (y + 1);

		FloorTiles northFt = dummyFloor;
		FloorTiles southFt = dummyFloor;
		FloorTiles westFt = dummyFloor;
		FloorTiles eastFt = dummyFloor;

		for (FloorTiles ft : GroundTilesCollection.getAllTheGroundTiles()) {
			if (ft.getName().compareToIgnoreCase(west) == 0) {
				westFt = ft;
			}
			if (ft.getName().compareToIgnoreCase(east) == 0) {
				eastFt = ft;
			}
			if (ft.getName().compareToIgnoreCase(north) == 0) {

				northFt = ft;
			}
			if (ft.getName().compareToIgnoreCase(south) == 0) {

				southFt = ft;
			}
		}

		if (flrTile.getAge() <= 0) {
			while (growthDone == false) {

				if (northFt.isOvergrown() == true && southFt.isOvergrown() == true && westFt.isOvergrown() == true
						&& eastFt.isOvergrown() == true) {
					growthDone = true;
				} else {

					int growthSide = (int) (Math.random() * 4) + 1;

					switch (growthSide) {

					case 1:
						if (northFt.isOvergrown() == false) {
							northFt.setOvergrown(true);
							northFt.setAge(0);
							growthDone = true;
						}
						break;

					case 2:
						if (southFt.isOvergrown() == false) {
							southFt.setOvergrown(true);
							southFt.setAge(0);
							growthDone = true;

						}
						break;

					case 3:
						if (westFt.isOvergrown() == false) {
							westFt.setOvergrown(true);
							westFt.setAge(0);
							growthDone = true;
						}
						break;

					case 4:
						if (eastFt.isOvergrown() == false) {
							eastFt.setOvergrown(true);
							eastFt.setAge(0);
							growthDone = true;
						}
						break;

					}
				}
			}
		}
	}

}
