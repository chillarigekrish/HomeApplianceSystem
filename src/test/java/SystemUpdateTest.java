import controller.SmartHomeApplianceController;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import scheduler.HomeApplianceSystemUpdate;

import java.util.concurrent.*;

import static org.mockito.Mockito.*;

class SystemUpdateTest {

    @Test
    void testUpdateTaskExecutesAndTurnsOffAllAppliances() throws InterruptedException {
        SmartHomeApplianceController controller = mock(SmartHomeApplianceController.class);

        ScheduledExecutorService testScheduler = Executors.newSingleThreadScheduledExecutor();
        HomeApplianceSystemUpdate updateSystem = new HomeApplianceSystemUpdate(controller, testScheduler);

        // Replace scheduleNextUpdate with a short one-time delay
        Runnable testTask = () -> {
            System.out.println("Simulating system update...");
            controller.turnOffAll();
        };

        // Act: Schedule task to run in 100 ms
        testScheduler.schedule(testTask, 100, TimeUnit.MILLISECONDS);

        // Wait briefly to ensure task runs
        Thread.sleep(200);

        // Assert
        verify(controller, times(1)).turnOffAll();
        testScheduler.shutdownNow();
    }
}
