import appliances.Light;
import enums.Switch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LightTest {

    private Light light;

    @BeforeEach
    void setUp() {
        light = new Light();
    }

    @Test
    void testInitialStatusIsOff() {
        assertEquals("Light is OFF", light.getStatus());
    }

    @Test
    void testTurnOnSetsStatusToOn() {
        light.turnOn();
        assertEquals("Light is ON", light.getStatus());
    }

    @Test
    void testTurnOnWhenAlreadyOnDoesNotChange() {
        light.turnOn(); // first time
        light.turnOn(); // second call should not change or reprint
        assertEquals("Light is ON", light.getStatus());
    }

    @Test
    void testTurnOffAfterTurningOn() {
        light.turnOn();
        light.turnOff();
        assertEquals("Light is OFF", light.getStatus());
    }

    @Test
    void testTurnOffWhenAlreadyOffDoesNotChange() {
        light.turnOff(); // should stay off
        assertEquals("Light is OFF", light.getStatus());
    }
}
