import com.smarthome.controller.ApplianceRegistry;
import org.junit.jupiter.api.Test;
import scheduler.HomeApplianceSystemUpdate;

import static org.mockito.Mockito.*;

class HomeApplianceSystemUpdateTest {

    @Test
    void testSystemUpdateTurnsOffAllAppliances() {
        ApplianceRegistry controller = mock(ApplianceRegistry.class);
        HomeApplianceSystemUpdate updateSystem = new HomeApplianceSystemUpdate(controller);

        updateSystem.runSystemUpdateLogic();

        verify(controller, times(1)).turnOffAll();
    }
}
