package com.smarthome.appliance;

import com.smarthome.enums.Switch;
import org.springframework.stereotype.Component;

@Component
public class AirConditioner implements Appliance{

    private String mode = Switch.OFF.toString();

    @Override
    public void turnOn() {
        if(mode.equalsIgnoreCase(Switch.OFF.toString())) {
            mode = Switch.ON.toString();
            System.out.println("Air Conditioner set turned ON");
        }
    }

    @Override
    public void turnOff() {
        if(mode.equalsIgnoreCase(Switch.ON.toString())) {
            mode = Switch.OFF.toString();
            System.out.println("Air Conditioner turned OFF.");
        }
    }

    @Override
    public String getStatus() {
        return String.format("Air Conditioner mode: %s", mode);
    }
}
