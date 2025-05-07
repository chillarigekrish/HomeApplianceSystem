package com.smarthome.controller;

import com.smarthome.appliance.Appliance;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApplianceRegistry {

    private final List<Appliance> appliances = new ArrayList<>();

    public void registerAppliance(Appliance appliance) {
        appliances.add(appliance);
    }

    public List<String> getStatus() throws Exception {
        if (appliances.isEmpty()) {
            //can be a customized exception
            throw new Exception("No Appliance initialized");
        }
        return appliances.stream().map(Appliance::getStatus).toList();
    }

    public void turnOffAll() throws Exception {
        if (appliances.isEmpty()) {
            //can be a customized exception
            throw new Exception("No Appliance initialized");
        }
        appliances.forEach(Appliance::turnOff);
    }
}
