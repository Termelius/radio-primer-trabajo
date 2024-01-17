package com.Logic.classes;

public class Estaciones {
    private double estacionFM;
    private int estacionAM;

    public Estaciones() {
        this.estacionFM = 87.9;
        this.estacionAM = 530;
    }

    public void cambiarEstacionFM(double nuevaEstacion) {
        if (nuevaEstacion >= 87.9 && nuevaEstacion <= 107.9) {
            this.estacionFM = nuevaEstacion;
        } else {
            System.out.println("La estación FM ingresada no es válida.");
        }
    }

    public void cambiarEstacionAM(int nuevaEstacion) {
        if (nuevaEstacion >= 530 && nuevaEstacion <= 1610) {
            this.estacionAM = nuevaEstacion;
        } else {
            System.out.println("La estación AM ingresada no es válida.");
        }
    }

    public double obtenerEstacionFM() {
        return this.estacionFM;
    }

    public int obtenerEstacionAM() {
        return this.estacionAM;
    }
}

