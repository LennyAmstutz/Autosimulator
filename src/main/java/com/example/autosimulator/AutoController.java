package com.example.autosimulator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class AutoController {

    @FXML
    public Button Hupen;
    @FXML
    public ChoiceBox<String> Autoauswählen;

    @FXML
    public ProgressBar Tankstand;

    @FXML
    protected void OnClickTanken() {
        String selectedCar = Autoauswählen.getValue();
        double tankFill = getTankFill(selectedCar);
        Tankstand.setProgress(tankFill);
    }

    @FXML
    protected void OnClickHupen() {
        String soundFile = "/Users/lennyamstutz/Documents/ük/OOP/Sounds/AutoHupen.mp3";

        Media sound = new Media(new File(soundFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    @FXML
    protected void OnClickAutoöffnen() {
        String selectedCar = Autoauswählen.getValue();
        double tankFill = getTankFill(selectedCar);

        if (tankFill > 0) {
            String soundFile = "/Users/lennyamstutz/Documents/ük/OOP/Sounds/StartaCar.mp3";

            Media sound = new Media(new File(soundFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
        } else {
            System.out.println("auto startet nicht");
        }
    }


    @FXML
    private double getTankFill(String selectedCar) {
        if ("Opel, 90 PS".equals(selectedCar)) {
            return 1;
        } else if ("Porsche, 250 PS".equals(selectedCar)) {
            return 1;
        } else if ("Ferrari, 370 PS".equals(selectedCar)) {
            return 1;
        }
        return 0.0;
    }

    @FXML
    public void initialize() {
        Autoauswählen.getItems().add("Opel, 90 PS");
        Autoauswählen.getItems().add("Porsche, 250 PS");
        Autoauswählen.getItems().add("Ferrari, 370 PS");
    }

    public void getTankFill(MouseEvent mouseEvent) {
    }
}
