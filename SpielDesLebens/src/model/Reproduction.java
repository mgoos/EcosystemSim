package model;

import java.util.ArrayList;
import elements.Animal;
import elements.AnimalCollection;

public class Reproduction {

	public void procreate() {

		AnimalCollection anmCol = new AnimalCollection();
		ArrayList<Animal> list2 = new ArrayList<>();

		list2.addAll(anmCol.getAllTheAnimals());

		if (anmCol.getAllTheAnimals().size() <= 4000) {

			for (Animal parent1 : list2) {

				for (Animal parent2 : list2) {

					if (parent1.getLocation().compareToIgnoreCase(parent2.getLocation()) == 0
							& !parent1.equals(parent2)) {

						int fullLibido = parent1.getLibido() + parent2.getLibido();

						if (fullLibido >= 70) {

							@SuppressWarnings("unused")
							Animal beastN = new Animal(parent1.getPositionX(), parent2.getPositionY());
							parent1.setLibido(0);
							parent2.setLibido(0);
						}

					}

				}

			}
		}
	}

}
