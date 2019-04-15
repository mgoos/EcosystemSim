package model;

import elements.Animal;
import elements.AnimalCollection;
import elements.FloorTiles;
import elements.GroundTilesCollection;

public class AnimalEats {

	AnimalCollection anmcol = new AnimalCollection();
	GroundTilesCollection gtc = new GroundTilesCollection();

	public void eatIfHungryAndPossible() {

		for (Animal e : anmcol.getAllTheAnimals()) {

			String north = ((e.getPositionX() - 1) + "-" + e.getPositionY());
			String south = ((e.getPositionX() + 1) + "-" + e.getPositionY());
			String west = (e.getPositionX()) + "-" + (e.getPositionY() - 1);
			String east = (e.getPositionX() + "-" + e.getPositionY() + 1);

			if (e.getHunger() <= 170) {

				for (FloorTiles ft : GroundTilesCollection.getAllTheGroundTiles()) {

					if (e.getLocation().compareToIgnoreCase(ft.getName()) == 0) {
						if (ft.isOvergrown() == true) {
							ft.setOvergrown(false);
							ft.setAge(-7);
							e.setHunger(e.getHunger() + 30);
//							System.out.print(
//									e.getName() + " frisst auf ihrem Feld. " + e.getLocation() + " | " + ft.getName());
							break;
						}
					} else {

						if (ft.getName().compareToIgnoreCase(south) == 0 && ft.isOvergrown() == true
								|| ft.getName().compareToIgnoreCase(north) == 0 && ft.isOvergrown() == true
								|| ft.getName().compareToIgnoreCase(west) == 0 && ft.isOvergrown() == true
								|| ft.getName().compareToIgnoreCase(east) == 0 && ft.isOvergrown() == true) {

							int tries = 10;
							if (e.isChewing() != true) {
								while (tries > 0) {

									int randDirection = (int) ((Math.random() * 4) + 1);

//									System.out.println(
//											"Random Number: " + randDirection + " Verbleibende Tries: " + tries);
									switch (randDirection) {

									case 1:

										if (north.compareToIgnoreCase(ft.getName()) == 0) {
											if (ft.isOvergrown()) {
												e.setPositionX(e.getPositionX() - 1);
												e.setLocation(e.getPositionX() + "-" + e.getPositionY());
												ft.setOvergrown(false);
												ft.setAge(8);
												e.setHunger(e.getHunger() + 30);
//												System.out
//														.print("Try: " + tries + " S‰ttigung :" + e.getHunger() + ". ");
//												System.out.println("Norden. " + e.getName() + " Kuh auf: "
//														+ e.getLocation() + " aﬂ hier: " + ft.getName());
												tries = 0;
												e.setChewing(true);
												break;
											} else {
												tries = tries - 1;
												break;
											}
										} else {
											tries = tries - 1;
											break;
										}

									case 2:

										if (south.compareToIgnoreCase(ft.getName()) == 0) {
											if (ft.isOvergrown()) {
												e.setPositionX(e.getPositionX() + 1);
												e.setLocation(e.getPositionX() + "-" + e.getPositionY());
												ft.setOvergrown(false);
												ft.setAge(8);
												e.setHunger(e.getHunger() + 30);
//												System.out
//														.print("Try: " + tries + " S‰ttigung :" + e.getHunger() + ". ");
//												System.out.println("Sueden. " + e.getName() + " Kuh auf: "
//														+ e.getLocation() + " aﬂ hier: " + ft.getName());
												tries = 0;
												e.setChewing(true);
												break;
											} else {
												tries = tries - 1;
												break;
											}
										} else {
											tries = tries - 1;
											break;
										}

									case 3:

										if (west.compareToIgnoreCase(ft.getName()) == 0) {
											if (ft.isOvergrown()) {
												e.setPositionY(e.getPositionY() - 1);
												e.setLocation(e.getPositionX() + "-" + e.getPositionY());
												ft.setOvergrown(false);
												ft.setAge(8);
												e.setHunger(e.getHunger() + 30);
//												System.out
//														.print("Try: " + tries + " S‰ttigung :" + e.getHunger() + ". ");
//												System.out.println("Westen. " + e.getName() + " Kuh auf: "
//														+ e.getLocation() + " aﬂ hier: " + ft.getName());
												tries = 0;
												e.setChewing(true);
												break;
											} else {
												tries = tries - 1;
												break;
											}
										} else {
											tries = tries - 1;
											break;
										}

									case 4:
										if (east.compareToIgnoreCase(ft.getName()) == 0) {
											if (ft.isOvergrown()) {
												e.setPositionY(e.getPositionY() + 1);
												e.setLocation(e.getPositionX() + "-" + e.getPositionY());
												ft.setOvergrown(false);
												ft.setAge(8);
												e.setHunger(e.getHunger() + 30);
//												System.out
//														.print("Try: " + tries + " S‰ttigung :" + e.getHunger() + ". ");
//												System.out.println("Osten. " + e.getName() + " auf: " + e.getLocation()
//														+ " aﬂ hier: " + ft.getName());
												tries = 0;
												e.setChewing(true);
												break;
											} else {
												tries = tries - 1;
												break;
											}
										} else {
											tries = tries - 1;
											break;
										}

									default:
										System.err.println("Never happens.");
										break;
									}

								}
							}
						}
					}
				}
			}
		}
	}

}
