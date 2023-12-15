package com.example.autosimulator;

import javafx.scene.control.ChoiceBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class Auto {

    private int aktuellerGang = 1;
    private boolean istMotorGestartet;
    private String marke;
    private int ps;
    private double tankFuellstand = 0;
    private int aktuelleGeschwindigkeit = 0;


    public Auto(String marke, int ps)
    {
        this.marke = marke;
        this.ps = ps;
    }

    public double getTankFuellstand() {
        return tankFuellstand;
    }

     public int getAktuellerGang() {
        return aktuellerGang;
    }

     public boolean getIstMotorGestartet() {
        return istMotorGestartet;

    }

    public String getMarke() {
        return marke;
    }

     public int getPs() {
        return ps;
    }

    public void auftanken() {
        this.tankFuellstand = 1.0;
    }

    public void gibGas() {

        if (this.istMotorGestartet == false)
            return;

        double sleeptime = 100000.0 / ps;
        try {
            Thread.sleep((int) sleeptime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        if (aktuelleGeschwindigkeit < ps) {
            aktuelleGeschwindigkeit++;
        }

        aktualisiereGang();
    }

    public int getAktuelleGeschwindigkeit() {
        return aktuelleGeschwindigkeit;
    }


    public void bremse() {
        if (aktuelleGeschwindigkeit > 0) {
            aktuelleGeschwindigkeit--;
         }

        aktualisiereGang();
    }

    public void starteMotor() {
        if (tankFuellstand > 0)
            this.istMotorGestartet = true;

        String soundFile = "/Users/lennyamstutz/Documents/ük/OOP/Sounds/StartaCar.mp3";
        Media sound = new Media(new File(soundFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    public void hupe() {

        String soundFile = "/Users/lennyamstutz/Documents/ük/OOP/Sounds/AutoHupen.mp3";
        Media sound = new Media(new File(soundFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();

    }
    private void aktualisiereGang() {
        if (aktuelleGeschwindigkeit == 0) {
            aktuellerGang = 1;
        } else if (aktuelleGeschwindigkeit <= 10) {
            aktuellerGang = 1;
        } else if (aktuelleGeschwindigkeit <= 20) {
            aktuellerGang = 2;
        } else if (aktuelleGeschwindigkeit <= 40) {
            aktuellerGang = 3;
        } else if (aktuelleGeschwindigkeit <= 70) {
            aktuellerGang = 4;
        } else if (aktuelleGeschwindigkeit <= 100) {
            aktuellerGang = 5;
        } else {
            aktuellerGang = 6;
        }
    }

    @Override
    public String toString() {
        return this.marke + " (PS: " + String.valueOf(this.ps) + ")";
    }

}
