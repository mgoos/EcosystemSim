package model;

import elements.Animal;
import elements.AnimalCollection;
import elements.FloorTiles;
import elements.GroundTilesCollection;
import javafx.scene.control.TextArea;

public class GameStats {

	public void gameStats(TextArea textArea, Ticker ticker) {

		AnimalCollection anmColl = new AnimalCollection();

		String outPut;
		int overGrownFields = 0;
		int overallAge = 0;
		int overallLibido = 0;
		int overallHunger = 0;

		for (FloorTiles ft : GroundTilesCollection.getAllTheGroundTiles()) {

			if (ft.isOvergrown() == true) {
				overGrownFields = overGrownFields + 1;
			}
		}

		if (anmColl.getAllTheAnimals().size() > 0) {
			for (Animal anm : anmColl.getAllTheAnimals()) {
				overallAge = overallAge + anm.getAge();
				overallLibido = overallLibido + anm.getLibido();
				overallHunger = overallHunger + anm.getHunger();
			}

			overallAge = overallAge / anmColl.getAllTheAnimals().size();
			overallLibido = overallLibido / anmColl.getAllTheAnimals().size();
			overallHunger = overallHunger / anmColl.getAllTheAnimals().size();
		}
		outPut = ("Spieleinstellungen:\n" + "Graswachstum: " + ticker.getGrowth() + "%\nHunger/Runde: "
				+ ticker.getHunger() + "\nFruchtbarkeitszuwachs/Runde: " + ticker.getLibido() + "\n\n" + "Anzahl der Felder: "
				+ GroundTilesCollection.getAllTheGroundTiles().size() + "\n" + "Davon bewachsen: " + overGrownFields
				+ "\n\n" + "Anzahl der Tiere: " + anmColl.getAllTheAnimals().size() + "\n"
				+ "Durchschnittliches Alter: " + overallAge + "\n" + "Durchschnittliche Saettigung: " + overallHunger
				+ "\n" + "Durchschnittliche Libido: " + overallLibido + "\nBisher verstorbene Tiere: "
				+ CheckForDeath.getDiedSoFar()+"\n\nRunde: " +Ticker.getZaehler());

		textArea.setText(outPut);
	}

}