package com.radio;
import com.Logic.classes.Radio;
import com.Logic.classes.Estaciones;
import java.io.IOException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.util.Duration;

import com.Logic.interfaces.IRadio;

public class BtnRadio {
    
    private Radio MLJP = new Radio();

    private static final Duration HOLD_DURATION = Duration.seconds(2);
    private Timeline holdTimer;
    private boolean isHolding = false;

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
    private void Put_AddStation(ActionEvent event) throws IOException {
        if (MLJP.getEncendido()) {
            MenuItem menuItem = (MenuItem) event.getSource();
            int indx = Integer.parseInt(menuItem.getText());

            startHoldTimer();
            isHolding = true;
    
            if (isHolding && holdTimer != null && holdTimer.getCurrentTime().greaterThanOrEqualTo(HOLD_DURATION)) {
                MLJP.guardarEstacion(MLJP.getEstacion(), MLJP.getBanda(), (indx - 1));
                System.out.println("Station Saved");
            } else {
                System.out.println("Radio station: " + indx);
                System.out.println( MLJP.recuperarEstacion((indx - 1)));

                if (MLJP.recuperarEstacion((indx - 1)) - 500 >= 0){
                MLJP.setEstacion((MLJP.recuperarEstacion((indx - 1))), IRadio.AM);
                System.out.println(MLJP.getBanda());
                }
                else if (MLJP.recuperarEstacion((indx - 1)) - 500 < 0){
                    MLJP.setEstacion((MLJP.recuperarEstacion((indx - 1))), IRadio.FM);
                    System.out.println(MLJP.getBanda());
                }
            }
        }
    }
    


    private void startHoldTimer() {
        isHolding = true;
        holdTimer = new Timeline(new KeyFrame(HOLD_DURATION, e -> {
            System.out.println("HOLD");
        }));
        holdTimer.play();

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
