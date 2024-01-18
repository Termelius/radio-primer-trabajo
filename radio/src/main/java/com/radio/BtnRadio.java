package com.radio;
import java.io.IOException;


import com.Logic.classes.Radio;
import com.Logic.interfaces.IRadio;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

public class BtnRadio {
    
    private Radio MLJP = new Radio();

    @FXML
    private Label volumeLabel;
    @FXML
    private Label radiolabel;


    @FXML
    private void updateVolumeLabel() {
        volumeLabel.setText(String.valueOf(MLJP.getVolume()));
    }

    @FXML
    private void updateRadioLabel() {
        if (radiolabel == null) {
            System.out.println("radiolabel is null");
        }
        radiolabel.setText(String.valueOf(MLJP.getEstacion()));
    }

    @FXML
    private void VolumeUp(ActionEvent event) throws IOException {
        if (MLJP.getEncendido()){
            int currentVolume = MLJP.getVolume();
            MLJP.setVolume(currentVolume + 5);
            updateVolumeLabel();
        }
    }

    @FXML
    private void VolumeDown(ActionEvent event) throws IOException {
        if (MLJP.getEncendido()){
            int currentVolume = MLJP.getVolume();
            MLJP.setVolume(currentVolume - 5);
            updateVolumeLabel();
        }
    }

    @FXML
    private void PressPowerBtn() throws IOException {
        if (MLJP.getEncendido() == false) {
            MLJP.setEncendido(true);
        } else {
            MLJP.setEncendido(false);
        }
        
    }


    @FXML
    private void AddStation(ActionEvent event) throws IOException {
        if (MLJP.getEncendido()) {
            MenuItem menuItem = (MenuItem) event.getSource();
            int indx = Integer.parseInt(menuItem.getText());

            MLJP.guardarEstacion(MLJP.getEstacion(), MLJP.getBanda(), (indx - 1));
            System.out.println("Station Saved");

        }
    }
    @FXML
    private void PutStation(ActionEvent event) throws IOException {
        if (MLJP.getEncendido()) {
            MenuItem menuItem = (MenuItem) event.getSource();
            int indx = Integer.parseInt(menuItem.getText());

            MLJP.setEstacion(MLJP.recuperarEstacion(indx-1), MLJP.getBanda());
            System.out.println("Station Loaded");
            updateRadioLabel();
        }
    }

    @FXML
    private void ChangeStationUP() throws IOException {
        System.out.println("ChangeStationUP");
        if (MLJP.getEncendido()){
            switch (MLJP.getBanda()) {
                case IRadio.AM:
                    if (MLJP.getEstacion()  > 1610) {
                        MLJP.setEstacion(530, IRadio.AM);
                        System.out.println(MLJP.getEstacion());
                    } else {
                        MLJP.setEstacion(MLJP.getEstacion() + 10, IRadio.AM);
                        System.out.println(MLJP.getEstacion());
                    }
                    updateRadioLabel();
                    break;
                case IRadio.FM:
                    if (MLJP.getEstacion() > 107.9f) {
                        MLJP.setEstacion(87.9f, IRadio.FM);
                        System.out.println(MLJP.getEstacion());
                    } else {
                        MLJP.setEstacion(MLJP.getEstacion() + 0.2f, IRadio.FM);
                        System.out.println(MLJP.getEstacion());
                    }
                    updateRadioLabel();
                    break;
            }
        }
    }

    @FXML
    private void ChangeStationDown() throws IOException {
        System.out.println("ChangeStationDown");
        if (MLJP.getEncendido()){
            switch (MLJP.getBanda()) {
                case IRadio.AM:
                    if (MLJP.getEstacion() < 530) {
                        MLJP.setEstacion(1610, IRadio.AM);
                        System.out.println(MLJP.getEstacion());
                    } else {
                        MLJP.setEstacion(MLJP.getEstacion() - 10, IRadio.AM);
                        System.out.println(MLJP.getEstacion());
                    }
                    updateRadioLabel();
                    break;
                case IRadio.FM:
                    if (MLJP.getEstacion() < 87.9) {
                        MLJP.setEstacion(107.9f, IRadio.FM);
                        System.out.println(MLJP.getEstacion());
                    } else {
                        MLJP.setEstacion(MLJP.getEstacion() - 0.2f, IRadio.FM);
                        System.out.println(MLJP.getEstacion());
                    }
                    updateRadioLabel();
                    break;
            }
        }
    }

    @FXML
    private void ChangeBand() throws IOException {
        if (MLJP.getEncendido()){
            switch (MLJP.getBanda()) {
                case IRadio.FM:
                    MLJP.setBanda();
                    MLJP.setEstacion(530, IRadio.AM);
                    System.out.println("AM");
                    System.out.println(MLJP.getBanda());

                    break;
                case IRadio.AM:
                    MLJP.setBanda();
                    MLJP.setEstacion(87.9f, IRadio.FM);
                    System.out.println("FM");
                    System.out.println(MLJP.getBanda());
                    break;
            }
        }
    }
}
