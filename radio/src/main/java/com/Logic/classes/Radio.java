package com.Logic.classes;

public class Radio {
    private boolean encendido;

    public Radio() {
        this.encendido = false;
    }

    public void encender() {
        this.encendido = true;
    }

    public void apagar() {
        this.encendido = false;
    }

    public boolean estaEncendido() {
        return this.encendido;
    }
}
