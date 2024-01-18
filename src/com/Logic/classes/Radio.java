package com.Logic.classes;
import com.Logic.interfaces.IRadio;

public class Radio implements IRadio {
    private boolean encendido;
    protected String marca;
    private int banda;
    private float estacion;
    private int volume;
    private float[] SaveStation = new float[12];

    public Radio() {
        this.encendido = false;
        this.marca = "MLJP";
        this.banda = IRadio.AM;
        this.estacion = 530;
        this.volume = 50;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    public void setVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            this.volume = volume;
        } else {
            this.volume = 0;
        }
    }

    public void setEstacion(float emisora, int Sentbanda) {
        if (Sentbanda == banda){
            this.estacion = emisora;
        }
    }

    public void setBanda() {
        if (this.banda == IRadio.AM) {
            this.banda = IRadio.FM;
        } else {
            this.banda = IRadio.AM;
        }
    }

    public Boolean getEncendido() {
        return this.encendido;
    }

    public float getEstacion() {
        return this.estacion;
    }

    public int getBanda() {
        return this.banda;
    }

    public int getVolume() {
        return this.volume;
    }

    public void guardarEstacion(float emisora, int banda, int indx) {
        for (int i = 0; i < this.SaveStation.length; i++) {
            if (i == indx) {
                this.SaveStation[i] = emisora;
                break;
            }
        }
    }

    public float recuperarEstacion(int indx) {
        return this.SaveStation[indx];
    }

}
