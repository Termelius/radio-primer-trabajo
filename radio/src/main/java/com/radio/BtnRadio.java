package com.radio;
import com.Logic.classes.Radio;
import com.Logic.classes.Estaciones;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class BtnRadio {
    
    private Radio MLJP = new Radio();

    private float[] SaveStation = new float[12];
    @FXML
    private Label volumeLabel;

    @FXML
    private void updateVolumeLabel() {
        volumeLabel.setText(String.valueOf(MLJP.getVolume()));
    }

    @FXML
    private void VolumeUp(ActionEvent event) throws IOException {
        int currentVolume = MLJP.getVolume();
        MLJP.setVolume(currentVolume + 5);
        updateVolumeLabel();
    }

    @FXML
    private void VolumeDown(ActionEvent event) throws IOException {
        int currentVolume = MLJP.getVolume();
        MLJP.setVolume(currentVolume - 5);
        updateVolumeLabel();
    }

    @FXML
    private void PressPowerBtn() throws IOException {
        
    }

    @FXML
    private void Put_AddStation() throws IOException {
        
    }

    @FXML
    private void ShowStation() throws IOException {
        
    }
}
