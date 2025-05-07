package com.smarthome.appliance;

import com.smarthome.enums.Switch;
import org.springframework.stereotype.Component;

@Component
public class Light implements Appliance {
    private String lightStatus = Switch.OFF.toString();

    @Override
    public void turnOn() {
        if(lightStatus.equalsIgnoreCase(Switch.OFF.toString())) {
            lightStatus = Switch.ON.toString();
            System.out.println("Light turned ON.");
        }
    }

    @Override
    public void turnOff() {
        if(lightStatus.equalsIgnoreCase(Switch.ON.toString())) {
            lightStatus = Switch.OFF.toString();  // toggle switch off
            System.out.println("Light turned OFF.");
        }
    }

    @Override
    public String getStatus() {
        return String.format("Light is %s", lightStatus);
    }
}
