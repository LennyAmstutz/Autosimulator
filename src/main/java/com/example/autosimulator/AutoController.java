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
    private Auto selectedCar;

    @FXML
    public ChoiceBox<Auto> autoAuswählen;

    @FXML
    public ProgressBar tankstand;

    @FXML
    public TextField kmh;

    @FXML
    public TextField gangAnzeige;

    @FXML
    public void initialize() {
        autoAuswählen.getItems().add(new Auto("Opel", 90));
        autoAuswählen.getItems().add(new Auto("Porsche", 250));
        autoAuswählen.getItems().add(new Auto("Ferrari", 370));

        autoAuswählen.setOnAction(event -> {
            selectedCar = autoAuswählen.getValue();
            AktualisiereInstrumente();
        });
    }

    @FXML
    protected void onClickTanken() {
        double tankFill = 0;


        tankFill = selectedCar.getTankFuellstand();


        tankstand.setProgress(tankFill);
    }



    @FXML
    protected void onClickHupen() {
        selectedCar.hupe();
    }

    @FXML
    protected void onClickAutoÖffnen() {
        if (selectedCar != null) {

            selectedCar.starteMotor();

        }
    }


    @FXML
    protected void onClickGasgeben() {

        selectedCar.gibGas();
        AktualisiereInstrumente();
    }

    @FXML
    protected void onClickBremsen() {
        selectedCar.bremse();

        AktualisiereInstrumente();
    }

    private void AktualisiereInstrumente() {

        kmh.setText(String.valueOf(selectedCar.getAktuelleGeschwindigkeit()));
        gangAnzeige.setText(String.valueOf(selectedCar.getAktuellerGang()));
    }
}
