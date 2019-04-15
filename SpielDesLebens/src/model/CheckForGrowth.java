package model;

import elements.FloorTiles;
import elements.GroundTilesCollection;

public class CheckForGrowth {

	public void checkForGrowth(int growthRate) {

		for (FloorTiles ft : GroundTilesCollection.getAllTheGroundTiles()) {

			if (ft.isOvergrown()) {

				int sprd = (int) (Math.random() * 100) + 1;

				if (sprd <= growthRate) {
					GrowthNearby grow = new GrowthNearby();
					grow.growNearby(ft);
				}
			} else {

			}

		}

	}

}
