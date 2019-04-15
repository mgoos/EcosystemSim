	package elements;

import java.util.ArrayList;

public class AnimalCollection {

	private static ArrayList<Animal> allTheAnimals = new ArrayList<>();

	public ArrayList<Animal> getAllTheAnimals() {
		return allTheAnimals;
	}

	public void setAllTheAnimals(ArrayList<Animal> allTheAnimals) {
		AnimalCollection.allTheAnimals = allTheAnimals;
	}

	public void addToAllTheAnimals(Animal animal) {
		AnimalCollection.allTheAnimals.add(animal);
	}

	public void doToAllTheAnimalsOnTick(int libido, int hunger) {
		for (Animal e : allTheAnimals) {
			e.setAge(e.getAge() + 1);
			e.setLibido(e.getLibido() + libido);
			e.setHunger(e.getHunger() - hunger);
			if(e.getLibido()>e.getHunger()) {
				e.setLibido(e.getHunger());
			}
			
		}
	}

	public void removeDeadAnimal(Animal carcass) {
		getAllTheAnimals().remove(carcass);
	}

}
