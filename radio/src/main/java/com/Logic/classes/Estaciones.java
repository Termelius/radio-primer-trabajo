package com.Logic.classes;

public class Estaciones {
    private float[] estacionesFM;
    private float[] estacionesAM ;

    public Estaciones() {
        this.estacionesAM = new float[]{530, 540, 550, 560, 570, 580, 590, 600, 610, 620, 630, 640};
        this.estacionesFM = new float[]{87.9f, 88.9f, 89.9f, 90.9f, 91.9f, 92.9f, 93.9f, 94.9f, 95.9f, 96.9f, 97.9f, 98.9f};

    }

    public float[] getEstacionesFM() {
        return estacionesFM;
    }

    public void setEstacionesFM(float[] estacionesFM) {
        this.estacionesFM = estacionesFM;
    }
}

