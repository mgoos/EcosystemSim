package model;

import elements.AnimalCollection;
import elements.GroundTilesCollection;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import view.RefreshTheAnimals;
import view.RefreshTheFloor;

public class Ticker {

	RefreshTheFloor refresher = new RefreshTheFloor();

	private static int zaehler = 0;

	private int hunger = 10;

	private int libido = 10;

	private int growth = 25;

	public void tick(GridPane gridPane, TextArea textArea) {

		++zaehler;
		System.out.println("Tick: " + zaehler);

		CheckForGrowth checkForGrowth = new CheckForGrowth();
		RefreshTheAnimals refreshAnimals = new RefreshTheAnimals();
		AnimalCollection anmColl = new AnimalCollection();
		CheckForDeath checkDeath = new CheckForDeath();
		MovementOfAnimals move = new MovementOfAnimals();
		AnimalEats eatsmth = new AnimalEats();
		Reproduction reproduce = new Reproduction();
		GameStats gameStats = new GameStats();

		checkForGrowth.checkForGrowth(getGrowth());
		GroundTilesCollection.ageAllTheFloorTiles();
		anmColl.doToAllTheAnimalsOnTick(getLibido(), getHunger());
		checkDeath.checkForDeath();
		eatsmth.eatIfHungryAndPossible();
		reproduce.procreate();
		move.moveAnimals();
		refresher.refresher(gridPane);
		refreshAnimals.showAnimals(gridPane);
		gameStats.gameStats(textArea, this);
		System.out.println();

	}

	// Getter and Setter
	public int getHunger() {
		return hunger;
	}

	public void setHunger(int hunger) {
		this.hunger = hunger;
	}

	public int getLibido() {
		return libido;
	}

	public void setLibido(int libido) {
		this.libido = libido;
	}

	public int getGrowth() {
		return growth;
	}

	public void setGrowth(int growth) {
		this.growth = growth;
	}
	
	public static int getZaehler() {
		return zaehler;
	}

	public static void setZaehler(int zaehler) {
		Ticker.zaehler = zaehler;
	}
}
