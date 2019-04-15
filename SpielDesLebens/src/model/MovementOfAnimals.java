package model;

import elements.Animal;
import elements.AnimalCollection;

public class MovementOfAnimals {

	AnimalCollection anmCol = new AnimalCollection();

	public void moveAnimals() {

		for (Animal a : anmCol.getAllTheAnimals()) {

			if (a.isChewing() == false) {

				if (a.getLibido() >= 60) {

					int whereTo = (int) (Math.random() * 2) + 1;
					
					switch (whereTo) {

					case 1:
						if (a.getPositionX() <= 8) {
							a.setPositionX(a.getPositionX() + 1);
							a.setLocation(a.getPositionX() + "-" + a.getPositionY());
						} else {
							a.setPositionX(a.getPositionX() - 1);
							a.setLocation(a.getPositionX() + "-" + a.getPositionY());
						}

					case 2:
						if (a.getPositionY() <= 6) {
							a.setPositionY(a.getPositionY() + 1);
							a.setLocation(a.getPositionX() + "-" + a.getPositionY());
						} else {
							a.setPositionY(a.getPositionY() - 1);
							a.setLocation(a.getPositionX() + "-" + a.getPositionY());
						}
						
					}
									
				} else {

					int whereTo = (int) (Math.random() * 4) + 1;

					switch (whereTo) {

					case 1:
						if (a.getPositionX() > 0) {
							a.setPositionX(a.getPositionX() - 1);
							a.setLocation(a.getPositionX() + "-" + a.getPositionY());
						}
						break;
					case 2:
						if (a.getPositionX() < 16) {
							a.setPositionX(a.getPositionX() + 1);
							a.setLocation(a.getPositionX() + "-" + a.getPositionY());
						}
						break;
					case 3:
						if (a.getPositionY() > 0) {
							a.setPositionY(a.getPositionY() - 1);
							a.setLocation(a.getPositionX() + "-" + a.getPositionY());
						}
						break;
					case 4:
						if (a.getPositionY() < 12) {
							a.setPositionY(a.getPositionY() + 1);
							a.setLocation(a.getPositionX() + "-" + a.getPositionY());
						}
						break;
					}

				}
			} else {
				a.setChewing(false);
			}
		}
	}
}
