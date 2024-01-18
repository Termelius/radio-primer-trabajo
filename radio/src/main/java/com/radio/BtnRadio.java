package com.radio;
import com.Logic.classes.Radio;
import com.Logic.classes.Estaciones;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import com.Logic.interfaces.IRadio;

public class BtnRadio {
    
    private Radio MLJP = new Radio();


    @FXML
    private Label volumeLabel;
    private Label RadioLabel;


    @FXML
    private void updateVolumeLabel() {
        volumeLabel.setText(String.valueOf(MLJP.getVolume()));
    }

    @FXML
    private void updateRadioLabel() {
        RadioLabel.setText(String.valueOf(MLJP.getEstacion()));
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
    private void Put_AddStation() throws IOException {
        
    }

    @FXML
    private void ChangeStationUP() throws IOException {
        System.out.println("ChangeStationUP");
        if (MLJP.getEncendido()){
            switch (MLJP.getBanda()) {
                case IRadio.AM:
                    if (MLJP.getEstacion() == 530) {
                        MLJP.setEstacion(1610, IRadio.AM);
                    } else {
                        MLJP.setEstacion(MLJP.getEstacion() + 10, IRadio.AM);
                        System.out.println(MLJP.getEstacion());
                    }
                    break;
                case IRadio.FM:
                    if (MLJP.getEstacion() == 87.9) {
                        MLJP.setEstacion(107.9f, IRadio.FM);
                    } else {
                        MLJP.setEstacion(MLJP.getEstacion() + 0.2f, IRadio.FM);
                        System.out.println(MLJP.getEstacion());
                    }
                    break;
            }
        }
    }

    @FXML
    // TODO: Fix this
    private void ChangeStationDown() throws IOException {
        System.out.println("ChangeStationDown");
        if (MLJP.getEncendido()){
            switch (MLJP.getBanda()) {
                case IRadio.AM:
                    if (MLJP.getEstacion() == 530) {
                        MLJP.setEstacion(1610, IRadio.AM);
                    } else {
                        MLJP.setEstacion(MLJP.getEstacion() - 10, IRadio.AM);
                        System.out.println(MLJP.getEstacion());
                    }
                    break;
                case IRadio.FM:
                    if (MLJP.getEstacion() == 87.9) {
                        MLJP.setEstacion(107.9f, IRadio.FM);
                    } else {
                        MLJP.setEstacion(MLJP.getEstacion() - 0.2f, IRadio.FM);
                        System.out.println(MLJP.getEstacion());
                    }
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
