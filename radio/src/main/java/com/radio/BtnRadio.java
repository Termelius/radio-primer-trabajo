package com.radio;

import java.io.IOException;
import javafx.fxml.FXML;


public class BtnRadio {
    
    private float[] SaveStation = new float[12];

    @FXML
    private void VolumeUp() throws IOException {
        if(volumen<100){
            volumen = Math.min(100,volumen + 5)
        }    
    }

    @FXML
    private void VolumeDown() throws IOException {
        if(volumen<100){
            volumen = Math.min(100,volumen - 5)
        }  
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
