package com.example.autosimulator;

public class Auto {
    private int aktuelleGeschwindigkeit;
    private int AktuellerGang;
    private boolean istMotorGestartet;
    private String make;
    private int ps;
    private int tankFuellstand;

    public int getAktuelleGeschwindigkeit() {
        return aktuelleGeschwindigkeit;
    }

    public void setAktuelleGeschwindigkeit(int aktuelleGeschwindigkeit) {
        this.aktuelleGeschwindigkeit = aktuelleGeschwindigkeit;
    }

    public int getAktuellerGang() {
        return AktuellerGang;
    }

    public void setAktuellerGang(int aktuellerGang) {
        AktuellerGang = aktuellerGang;
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
}
