package model;

import java.util.ArrayList;

import elements.Animal;
import elements.AnimalCollection;

public class CheckForDeath {

	AnimalCollection animalCollection = new AnimalCollection();

	ArrayList<Animal> listOfAnimals = new ArrayList<>();

	private static int diedSoFar = 0;

	public static int getDiedSoFar() {
		return diedSoFar;
	}

	public static void setDiedSoFar(int diedSoFar) {
		CheckForDeath.diedSoFar = diedSoFar;
	}

	public void checkForDeath() {

		if (animalCollection.getAllTheAnimals().size() > 0) {

			listOfAnimals.addAll(animalCollection.getAllTheAnimals());

			for (Animal anm : listOfAnimals) {

				if (anm.getHunger() <= 0) {
					anm.setLives(false);
					animalCollection.removeDeadAnimal(anm);
					diedSoFar++;
				}
				if (anm.getAge() >= 70) {
					anm.setLives(false);
					animalCollection.removeDeadAnimal(anm);
					diedSoFar++;
				}
			}
		}
	}
}
