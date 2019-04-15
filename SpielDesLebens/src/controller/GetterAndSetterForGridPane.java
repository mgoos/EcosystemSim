package controller;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class GetterAndSetterForGridPane {

	public Node getGridNodeContent(GridPane gridPane, int row, int column) {
		for (Node node : gridPane.getChildren()) {
			if (GridPane.getColumnIndex(node) == column && GridPane.getRowIndex(node) == row) {
				return node;
			}
		}
		return null;
	}

	public void setGridNodeContentFloor(GridPane gridPane, Image image, int row, int column) {
		gridPane.getChildren().remove(getGridNodeContent(gridPane, row, column));
		ImageView setThisImage = new ImageView(image);
		setThisImage.setId(column + "/" + row);
		gridPane.add(setThisImage, column, row);
	}

	public void setGridNodeContentBeast(GridPane gridPane, ImageView imageView, int row, int column) {
		gridPane.add(imageView, column, row);
	}

}
