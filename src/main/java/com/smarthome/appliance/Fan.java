package com.smarthome.appliance;

import org.springframework.stereotype.Component;

@Component
public class Fan implements Appliance {
    private int speed = 0; // 0 = off, 1 = low, 2 = high
    private boolean isOn = false;

    @Override
    public void turnOn() {
        setSpeed(1);
        isOn = true;
    }

    @Override
    public void turnOff() {
        setSpeed(0);
        isOn = false;
    }

    public void setSpeed(int newSpeed) {
        if (newSpeed < 0 || newSpeed > 2) {
            System.out.println("Invalid speed. Use 0 (off), 1, or 2.");
        } else {
            speed = newSpeed;
            System.out.println("Fan speed set to " + speed + (speed == 0 ? " (off)" : ""));
        }
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String getStatus() {
        return "Fan speed: " + speed;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }
}
