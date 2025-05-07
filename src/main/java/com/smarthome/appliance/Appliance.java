package com.smarthome.appliance;

import org.springframework.stereotype.Component;

@Component
public interface Appliance {

    void turnOn();
    void turnOff();
    String getStatus();
}
