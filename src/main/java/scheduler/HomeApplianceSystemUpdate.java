package scheduler;

import com.smarthome.controller.ApplianceRegistry;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class HomeApplianceSystemUpdate {

    private final ApplianceRegistry registry;

    public HomeApplianceSystemUpdate(ApplianceRegistry controller) {
        this.registry = controller;
    }

    @Scheduled(cron = "0 0 1 1 1 *") // Jan 1st, 1:00 AM
    public void performSystemUpdate() {
        runSystemUpdateLogic();
    }

    public void runSystemUpdateLogic() {
        System.out.println("System update in progress: turning off all appliances...");
        registry.turnOffAll();
        System.out.println("Update completed.");
    }
}
