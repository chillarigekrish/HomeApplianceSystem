package commands;

import appliances.Appliance;

public class TurnOffCommand implements Command {
    private final Appliance appliance;

    public TurnOffCommand(Appliance appliance) {
        this.appliance = appliance;
    }

    @Override
    public void execute() {
        appliance.turnOff();
    }

}
