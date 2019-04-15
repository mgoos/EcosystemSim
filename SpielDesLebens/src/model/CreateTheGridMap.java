package model;

import elements.FloorTiles;
import elements.GroundTilesCollection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class CreateTheGridMap {

	Image dirtImg = new Image(
			"https://i.ibb.co/FW97Mtb/dirt.jpg");

	public void createTheGrid(GridPane gridPane) {

		int x;
		int y;

		for (x = 0; x <= 16;) {
			y = 0;
			for (y = 0; y < 12;) {

				FloorTiles floorTile = new FloorTiles(x, y);
				GroundTilesCollection.addGroundTiles(floorTile);
				ImageView imageView = new ImageView(dirtImg);
				gridPane.add(imageView, x, y);
				y = y + 1;
			}
			FloorTiles floorTile = new FloorTiles(x, y);
			GroundTilesCollection.addGroundTiles(floorTile);
			ImageView imageView = new ImageView(dirtImg);
			gridPane.add(imageView, x, y);
			x = x + 1;
		}

	}

}
