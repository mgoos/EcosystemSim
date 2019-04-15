package view;

import java.util.ArrayList;

import controller.GetterAndSetterForGridPane;
import elements.Animal;
import elements.AnimalCollection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class RefreshTheAnimals {

	static ArrayList<ImageView> lastRoundAnimals = new ArrayList<>();

	AnimalCollection anmColl = new AnimalCollection();

	GetterAndSetterForGridPane getAndSet = new GetterAndSetterForGridPane();

	public void showAnimals(GridPane gridPane) {

		Image imageOfAnimal = new Image(
				"https://i.ibb.co/xCgWHDJ/cow.png");

		lastRoundAnimals.clear();

		for (Animal anm : anmColl.getAllTheAnimals()) {

			ImageView newAnimal = new ImageView(imageOfAnimal);
			getAndSet.setGridNodeContentBeast(gridPane, newAnimal, anm.getPositionY(), anm.getPositionX());

		}
	}
}
