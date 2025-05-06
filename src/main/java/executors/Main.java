package executors;

import appliances.AirConditioner;
import appliances.Fan;
import appliances.Light;
import controller.SmartHomeApplianceController;
import scheduler.HomeApplianceSystemUpdate;

public class Main {
    public static void main(String[] args) {
        SmartHomeApplianceController controller = new SmartHomeApplianceController();

        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();

        controller.registerAppliance(light);
        controller.registerAppliance(fan);
        controller.registerAppliance(ac);

        light.turnOn();
        fan.setSpeed(2);
        ac.turnOn();
        System.out.println("Below are the current status of each appliance");
        System.out.println(light.getStatus());
        System.out.println(fan.getStatus());
        System.out.println(ac.getStatus());

        HomeApplianceSystemUpdate scheduler = new HomeApplianceSystemUpdate(controller);
        scheduler.scheduleNextUpdate();
    }
}