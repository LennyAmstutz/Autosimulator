package com.example.autosimulator;

import java.util.Timer;
import java.util.TimerTask;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class AutoController {
    private static final double MAX_TANK_FILL = 1;
    private Auto auto = new Auto();

    @FXML
    public ChoiceBox<String> autoAuswählen;

    @FXML
    public ProgressBar tankstand;

    @FXML
    public TextField kmh;

    @FXML
    public TextField gangAnzeige;

    @FXML
    public void initialize() {
        autoAuswählen.getItems().add("Opel, 90 PS");
        autoAuswählen.getItems().add("Porsche, 250 PS");
        autoAuswählen.getItems().add("Ferrari, 370 PS");

        autoAuswählen.setOnAction(event -> {
            String selectedCar = autoAuswählen.getValue();
            auto.setPsBasedOnSelection(selectedCar);
        });
    }

    @FXML
    protected void onClickTanken() {
        String selectedCar = autoAuswählen.getValue();
        int tankFill = auto.getTankFuellstand(selectedCar);

        double normalizedTankFill = (double) tankFill / MAX_TANK_FILL;


        normalizedTankFill = Math.min(1.0, Math.max(0.0, normalizedTankFill));

        tankstand.setProgress(normalizedTankFill);
    }



    @FXML
    protected void onClickHupen() {
        String soundFile = "/Users/lennyamstutz/Documents/ük/OOP/Sounds/AutoHupen.mp3";
        Media sound = new Media(new File(soundFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    @FXML
    protected void onClickAutoÖffnen() {
        String selectedCar = autoAuswählen.getValue();
        int tankFill = auto.getTankFuellstand(selectedCar);

        if (selectedCar != null && tankFill >= 1) {
            String soundFile = "/Users/lennyamstutz/Documents/ük/OOP/Sounds/StartaCar.mp3";
            Media sound = new Media(new File(soundFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
        } else {
            System.out.println("Bitte befülle den Tank bevor du das Auto startest");
        }
    }


    @FXML
    protected void onClickGasgeben() {
        auto.erhöheGeschwindigkeit();
        kmh.setText(String.valueOf(auto.getGeschwindigkeit()));
        auto.setGeschwindigkeit(auto.getGeschwindigkeit());
        gangAnzeige.setText(String.valueOf(auto.getAktuellerGang()));
    }

    @FXML
    protected void onClickBremsen() {
        auto.verlangsameGeschwindigkeit();
        kmh.setText(String.valueOf(auto.getGeschwindigkeit()));
        gangAnzeige.setText(String.valueOf(auto.getAktuellerGang()));
    }

}
