package view;

import controller.GetterAndSetterForGridPane;
import elements.FloorTiles;
import elements.GroundTilesCollection;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

public class RefreshTheFloor {

	Image grassImg = new Image("https://i.ibb.co/qWSdw7d/grass.jpg");
	Image dirtImg = new Image(
			"https://i.ibb.co/FW97Mtb/dirt.jpg");

	public void refresher(GridPane gridPane) {

		GetterAndSetterForGridPane gtUndSt = new GetterAndSetterForGridPane();

		for (FloorTiles ft : GroundTilesCollection.getAllTheGroundTiles()) {

			if (ft.isOvergrown() == true) {
				gtUndSt.setGridNodeContentFloor(gridPane, grassImg, ft.getY(), ft.getX());

			} else {
				gtUndSt.setGridNodeContentFloor(gridPane, dirtImg, ft.getY(), ft.getX());
			}

		}
	}

}
