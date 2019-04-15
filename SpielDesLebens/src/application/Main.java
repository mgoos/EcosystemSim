package application;

import elements.Animal;
import elements.AnimalCollection;
import elements.FloorTiles;
import elements.GroundTilesCollection;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.CheckForDeath;
import model.CreateTheGridMap;
import model.GameStats;
import model.Ticker;
import view.RefreshTheAnimals;
import view.RefreshTheFloor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Main extends Application {

	static boolean tickerIsTicking;

	@Override
	public void start(Stage primaryStage) {
		try {

			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 1200, 700);
			Ticker tick = new Ticker();
			RefreshTheAnimals refresAnm = new RefreshTheAnimals();
			GridPane gridPane = new GridPane();
			GameStats statRefresh = new GameStats();
			CreateTheGridMap createMap = new CreateTheGridMap();
			TextArea debugField = new TextArea("DebugOutput");
			TextArea gameStats = new TextArea(
					"Willkommen!\nIn dieser Anwendung wird ein einfaches Oekosystem simuliert.\n"
							+ "Durch das Verstellen verschiedener Werte, kann der Benutzer\n"
							+ "beeinflussen, wie gut sich das Wachstum der Pflanzen und\n"
							+ "die Vermehrung der Tiere die Waage halten."
							+ "\n\nAus Performancegruenden vermehren sich Tiere nicht mehr "
							+ "\nweiter, wenn es bereits 4000 oder mehr von ihnen gibt.");
			Timeline tickTimer = new Timeline(new KeyFrame(Duration.millis(1500.0), ev -> {
				tick.tick(gridPane, gameStats);
			}));

			primaryStage.setTitle("Spiel des Lebens");
			primaryStage.setScene(scene);
			primaryStage.show();
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			root.setCenter(gridPane);
			root.setStyle("-fx-background-color: beige;");
			gridPane.setStyle("-fx-border-color: black; -fx-border-radius: 2");
			createMap.createTheGrid(gridPane);

			// RIGHT SIDE MENUE
			VBox rightSidePanes = new VBox();
			root.setRight(rightSidePanes);

			gameStats.setPrefHeight(300);
			gameStats.setEditable(false);
			rightSidePanes.getChildren().add(gameStats);

			Text growthExplanation = new Text("\nWahrscheinlichkeit fuer Graswachstum in Prozent pro Grasblock.");
			rightSidePanes.getChildren().add(growthExplanation);

			HBox setGrowthPerRound = new HBox();
			rightSidePanes.getChildren().add(setGrowthPerRound);

			TextArea growthTxAr = new TextArea("25");
			setGrowthPerRound.getChildren().add(growthTxAr);
			growthTxAr.setMaxSize(60, 30);
			growthTxAr.setMinSize(60, 30);

			Button sendGrowth = new Button("Setze Wachstum/Runde");
			setGrowthPerRound.getChildren().add(sendGrowth);
			sendGrowth.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {

					try {
						int growth = Integer.parseInt(growthTxAr.getText());
						tick.setGrowth(growth);
						debugField.setText(debugField.getText() + "\n" + "Wahrscheinlichkeit fuer Graswachstum auf "
								+ growth + "% gesetzt.");
						statRefresh.gameStats(gameStats, tick);
					} catch (NumberFormatException e) {
						growthTxAr.setText("FEHLER");
						debugField.setText(debugField.getText() + "\n" + "Es sind nur ganze Zahlen zulaessig.");
					}

				}
			});

			Text hungerExplanation = new Text(
					"\nNahrungsverlust pro Runde. Bei einer Saettigung von '0'\n stirbt das Tier. Bei einem Wert kleiner gleich '150' frisst es,\n falls moeglich und erhaelt '30' Saettigung.");
			rightSidePanes.getChildren().add(hungerExplanation);

			HBox setHungerPerRound = new HBox();
			rightSidePanes.getChildren().add(setHungerPerRound);

			TextArea hungerTxAr = new TextArea("10");
			setHungerPerRound.getChildren().add(hungerTxAr);
			hungerTxAr.setMaxSize(60, 30);
			hungerTxAr.setMinSize(60, 30);

			Button sendHunger = new Button("Setze Hunger/Runde");
			setHungerPerRound.getChildren().add(sendHunger);
			sendHunger.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {

					try {
						int hunger = Integer.parseInt(hungerTxAr.getText());
						tick.setHunger(hunger);
						debugField.setText(debugField.getText() + "\n" + "Saettigungsverlust pro Runde auf " + hunger
								+ " gesetzt.");
						statRefresh.gameStats(gameStats, tick);
					} catch (NumberFormatException e) {
						hungerTxAr.setText("FEHLER");
						debugField.setText(debugField.getText() + "\n" + "Es sind nur ganze Zahlen zulaessig.");
					}

				}
			});

			Text libidoExplanation = new Text(
					"\nAnstieg der Fruchtbarkeit pro Runde. Befinden sich zwei Tiere mit \neinem gemeinsamen Gesamtwert von 70 auf einem Feld,\npflanzen sie sich fort.");
			rightSidePanes.getChildren().add(libidoExplanation);

			HBox setLibidoPerRound = new HBox();
			rightSidePanes.getChildren().add(setLibidoPerRound);

			TextArea libidoTxAr = new TextArea("10");
			setLibidoPerRound.getChildren().add(libidoTxAr);
			libidoTxAr.setMaxSize(60, 30);
			libidoTxAr.setMinSize(60, 30);

			Button sendLibido = new Button("Setze Fruchtbarkeitszuwachs/Runde");
			setLibidoPerRound.getChildren().add(sendLibido);
			sendLibido.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {

					try {
						int libido = Integer.parseInt(libidoTxAr.getText());
						tick.setLibido(libido);
						debugField.setText(debugField.getText() + "\n" + "Fruchtbarkeitszuwachs pro Runde auf " + libido
								+ " gesetzt.");
						statRefresh.gameStats(gameStats, tick);
					} catch (NumberFormatException e) {
						libidoTxAr.setText("FEHLER");
						debugField.setText(debugField.getText() + "\n" + "Es sind nur ganze Zahlen zulaessig.");
					}

				}
			});

			rightSidePanes.getChildren().add(debugField);

			debugField.setWrapText(true);

			// BOTTOM MENUE

			HBox bottomHBox = new HBox();
			root.setBottom(bottomHBox);
			bottomHBox.setSpacing(5.0);

			Button doTickTester = new Button("Do Tick <Test>");
			bottomHBox.getChildren().add(doTickTester);

			Button runTicker = new Button("Starte Ticker");
			bottomHBox.getChildren().add(runTicker);

			Button addOneGrass = new Button("Setze Grass");
			bottomHBox.getChildren().add(addOneGrass);

			Button addBeast = new Button("Setze Tier");
			bottomHBox.getChildren().add(addBeast);

			Button clearGame = new Button("Reset");
			bottomHBox.getChildren().add(clearGame);

			addOneGrass.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {

					int rnd1 = (int) (Math.random() * 221);
					int rnd2 = (int) (Math.random() * 221);

					GroundTilesCollection.getAllTheGroundTiles().get(rnd1).setOvergrown(true);
					GroundTilesCollection.getAllTheGroundTiles().get(rnd1).setAge(1);

					GroundTilesCollection.getAllTheGroundTiles().get(rnd2).setOvergrown(true);
					GroundTilesCollection.getAllTheGroundTiles().get(rnd2).setAge(1);

					RefreshTheFloor refr = new RefreshTheFloor();
					refr.refresher(gridPane);
					refresAnm.showAnimals(gridPane);
					statRefresh.gameStats(gameStats, tick);
				}
			});

			doTickTester.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					tick.tick(gridPane, gameStats);

				}
			});

			addBeast.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {

					int x;
					int y;
					x = (int) (Math.random() * 16) + 1;
					y = (int) (Math.random() * 12) + 1;

					@SuppressWarnings("unused")
					Animal beastN = new Animal(x, y);

					refresAnm.showAnimals(gridPane);
					statRefresh.gameStats(gameStats, tick);
				}
			});

			runTicker.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {

					if (tickerIsTicking == false) {
						tickerIsTicking = true;
						tickTimer.setCycleCount(Animation.INDEFINITE);
						runTicker.setText("Stoppe Ticker");
						tickTimer.play();
						System.out.println("on");
					} else {
						tickTimer.pause();
						runTicker.setText("Starte Ticker");
						System.out.println("off");
						tickerIsTicking = false;

					}
				}
			});

			clearGame.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {

					for (FloorTiles ft : GroundTilesCollection.getAllTheGroundTiles()) {
						ft.setOvergrown(false);
						ft.setAge(0);
					}
					new AnimalCollection().getAllTheAnimals().clear();

					CheckForDeath.setDiedSoFar(0);
					tick.tick(gridPane, gameStats);
					Ticker.setZaehler(0);
					debugField.setText(debugField.getText() + "\nSimulation Reseted.");
					statRefresh.gameStats(gameStats, tick);

				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
