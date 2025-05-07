import com.smarthome.appliance.AirConditioner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AirConditionerTest {

    private AirConditioner ac;

    @BeforeEach
    void setUp() {
        ac = new AirConditioner();
    }

    @Test
    void testInitialModeIsOff() {
        assertEquals("Air Conditioner mode: OFF", ac.getStatus());
    }

    @Test
    void testTurnOnSetsModeToOn() {
        ac.turnOn();
        assertEquals("Air Conditioner mode: ON", ac.getStatus());
    }

    @Test
    void testTurnOffSetsModeToOff() {
        ac.turnOn();
        ac.turnOff();
        assertEquals("Air Conditioner mode: OFF", ac.getStatus());
    }
}
