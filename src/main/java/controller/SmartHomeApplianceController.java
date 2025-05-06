package controller;

import appliances.Appliance;
import commands.Command;
import commands.TurnOffCommand;

import java.util.ArrayList;
import java.util.List;

public class SmartHomeApplianceController {

    private final List<Appliance> appliances = new ArrayList<>();

    public void registerAppliance(Appliance appliance) {
        appliances.add(appliance);
    }

    public void turnOffAll() {
        for (Appliance appliance : appliances) {
            Command offCommand = new TurnOffCommand(appliance);
            offCommand.execute();
        }
    }

    public List<Appliance> getAppliances() {
        return appliances;
    }
}
