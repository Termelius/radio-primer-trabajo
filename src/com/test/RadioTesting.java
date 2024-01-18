package com.test;

import org.junit.Assert;
import org.junit.Test;
import com.Logic.classes.Radio;
import com.Logic.interfaces.IRadio;


public class RadioTesting{ 

    @Test
    public void testEncendidoRadio() {
        Radio radio = new Radio();
        radio.setEncendido(true);
        Assert.assertTrue(radio.getEncendido());
    }

}