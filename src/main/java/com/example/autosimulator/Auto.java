package com.example.autosimulator;

import javafx.scene.control.ChoiceBox;

public class Auto {
    private String autoAuswählen;
    private int aktuelleGeschwindigkeit;
    private int aktuellerGang;
    private boolean istMotorGestartet;
    private String make;
    private int ps;
    private int tankFuellstand;
    private int geschwindigkeit = 0;
    private boolean istAngehalten = false; // Flag, um zu überprüfen, ob das Auto angehalten ist

    public void setAutoAuswählen(ChoiceBox<String> autoAuswählen) {
        this.autoAuswählen = String.valueOf(autoAuswählen);
    }

    public int getTankFuellstand(String carModel) {
        if ("Opel, 90 PS".equals(carModel) || "Porsche, 250 PS".equals(carModel) || "Ferrari, 370 PS".equals(carModel)) {
            return tankFuellstand;
        }
        return 0;
    }

    public int getAktuelleGeschwindigkeit() {
        double sleeptime = 100000.0 / ps;
        try {
            Thread.sleep((int) sleeptime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return aktuelleGeschwindigkeit;
    }

    public void setAktuelleGeschwindigkeit(int aktuelleGeschwindigkeit) {
        this.aktuelleGeschwindigkeit = aktuelleGeschwindigkeit;
    }

    public int getAktuellerGang() {
        return aktuellerGang;
    }

    public void setAktuellerGang(int aktuellerGang) {
        this.aktuellerGang = aktuellerGang;
    }

    public boolean isIstMotorGestartet() {
        return istMotorGestartet;
    }

    public void setIstMotorGestartet(boolean istMotorGestartet) {
        this.istMotorGestartet = istMotorGestartet;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public int getTankFuellstand() {
        return tankFuellstand;
    }

    public void setTankFuellstand(int tankFuellstand) {
        this.tankFuellstand = tankFuellstand;
    }

    public void erhöheGeschwindigkeit() {
        if (geschwindigkeit < ps) {
            geschwindigkeit++;
        }
    }

    public int getGeschwindigkeit() {
        return geschwindigkeit;
    }

    public void setGeschwindigkeit(int neueGeschwindigkeit) {
        geschwindigkeit = Math.min(neueGeschwindigkeit, ps);

        if (geschwindigkeit == 0) {
            aktuellerGang = 1;
        } else if (geschwindigkeit <= 10) {
            aktuellerGang = 1;
        } else if (geschwindigkeit <= 20) {
            aktuellerGang = 2;
        } else if (geschwindigkeit <= 40) {
            aktuellerGang = 3;
        } else if (geschwindigkeit <= 70) {
            aktuellerGang = 4;
        } else if (geschwindigkeit <= 100) {
            aktuellerGang = 5;
        } else {
            aktuellerGang = 6;
        }
    }

    public void setPsBasedOnSelection(String selectedCar) {
        if ("Opel, 90 PS".equals(selectedCar)) {
            ps = 90;
        } else if ("Porsche, 250 PS".equals(selectedCar)) {
            ps = 250;
        } else if ("Ferrari, 370 PS".equals(selectedCar)) {
            ps = 370;
        }
    }

    public void pause() {
        istAngehalten = true;
        int schrittweite = 5;

        while (geschwindigkeit > 0 && istAngehalten) {
            setGeschwindigkeit(geschwindigkeit - schrittweite);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        if (!istAngehalten) {
            setAktuellerGang(1);
        }
    }

    public void verlangsameGeschwindigkeit() {
        if (geschwindigkeit > 0) {
            geschwindigkeit--;
            aktualisiereGang();
        }
    }

    private void aktualisiereGang() {
        if (geschwindigkeit == 0) {
            aktuellerGang = 1;
        } else if (geschwindigkeit <= 10) {
            aktuellerGang = 1;
        } else if (geschwindigkeit <= 20) {
            aktuellerGang = 2;
        } else if (geschwindigkeit <= 40) {
            aktuellerGang = 3;
        } else if (geschwindigkeit <= 70) {
            aktuellerGang = 4;
        } else if (geschwindigkeit <= 100) {
            aktuellerGang = 5;
        } else {
            aktuellerGang = 6;
        }
    }

}
