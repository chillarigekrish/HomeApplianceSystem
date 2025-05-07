package com.smarthome.service;

import com.smarthome.exceptions.InvalidApplianceTypeException;
import com.smarthome.appliance.AirConditioner;
import com.smarthome.appliance.Fan;
import com.smarthome.appliance.Light;
import com.smarthome.controller.ApplianceRegistry;
import com.smarthome.enums.ApplianceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartHomeService {

    @Autowired
    private ApplianceRegistry applianceRegistry;

    @Autowired
    private Light light;

    @Autowired
    private Fan fan;

    @Autowired
    private AirConditioner ac;

    private ApplianceType convertToApplianceType(String applianceType) {
        try {
            return ApplianceType.valueOf(applianceType.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidApplianceTypeException(applianceType);
        }
    }

    public String initialize(List<String> appliancesTypes) {

        List<ApplianceType> appliances = appliancesTypes.stream()
                .map(this::convertToApplianceType)
                .toList();

        for (ApplianceType appliance : appliances) {
            switch (appliance) {
                case LIGHT:
                    applianceRegistry.registerAppliance(light);
                    break;
                case FAN:
                    applianceRegistry.registerAppliance(fan);
                    break;
                case AC:
                    applianceRegistry.registerAppliance(ac);
                    break;
            }
        }
        return "Specified appliances initialized.";
    }
    public String turnOnLight() {
        light.turnOn();
        return light.getStatus();
    }

    public String turnOffLight() {
        light.turnOff();
        return light.getStatus();
    }

    public String setFanSpeed(int speed) {
        if (speed < 0 || speed > 2) {
            throw new IllegalArgumentException("Invalid speed. Use 0 (off), 1, or 2.");
        }
        fan.setSpeed(speed);
        return fan.getStatus();
    }

    public String turnOnAC() {
        ac.turnOn();
        return ac.getStatus();
    }

    public String turnOffAC() {
        ac.turnOff();
        return ac.getStatus();
    }

    public List<String> getStatus() throws Exception {
        return applianceRegistry.getStatus();
    }

}
