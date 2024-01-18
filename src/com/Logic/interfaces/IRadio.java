package com.Logic.interfaces;

public interface IRadio {

    public void setEncendido(boolean encendido);
    public void setVolume(int volume);
    public void setEstacion(float emorisora, int banda);

    public static final int AM = 0;
    public static final int FM = 1;

    public Boolean getEncendido();
    public float getEstacion();
    public int getBanda();
    public int getVolume();

    public void guardarEstacion(float emisora, int banda, int indx);
    public float recuperarEstacion(int indx);
}
