package scheduler;

import controller.SmartHomeApplianceController;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class HomeApplianceSystemUpdate {
    private final ScheduledExecutorService scheduler;
    private final SmartHomeApplianceController controller;

    public HomeApplianceSystemUpdate(SmartHomeApplianceController controller) {
        this(controller, Executors.newSingleThreadScheduledExecutor());
    }

    public HomeApplianceSystemUpdate(SmartHomeApplianceController controller, ScheduledExecutorService scheduler) {
        this.controller = controller;
        this.scheduler = scheduler;
    }

    public void scheduleNextUpdate() {
        LocalDateTime now = LocalDateTime.now();
        //if required can be passed an input to make this method reusable
        LocalDateTime nextUpdate = LocalDateTime.of(now.getYear() + 1, 1, 1, 1, 0); // Jan 1, 1:00 AM

        long delayMillis = Duration.between(now, nextUpdate).toMillis();

        Runnable updateTask = () -> {
            System.out.println("System update in progress: turning off all appliances...");
            controller.turnOffAll();
            System.out.println("Update completed.");

            // Reschedule for next year
            scheduleNextUpdate();
        };

        scheduler.schedule(updateTask, delayMillis, TimeUnit.MILLISECONDS);
        System.out.println("Next yearly update scheduled for: " + nextUpdate);
    }
}
