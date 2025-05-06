import appliances.Fan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FanTest {

    private Fan fan;

    @BeforeEach
    void setUp() {
        fan = new Fan();
    }

    @Test
    void testInitialSpeedIsZero() {
        assertEquals(0, fan.getSpeed());
        assertEquals("Fan speed: 0", fan.getStatus());
    }

    @Test
    void testTurnOnSetsSpeedToOne() {
        fan.turnOn();
        assertEquals(1, fan.getSpeed());
        assertEquals("Fan speed: 1", fan.getStatus());
    }

    @Test
    void testTurnOffSetsSpeedToZero() {
        fan.setSpeed(2);
        fan.turnOff();
        assertEquals(0, fan.getSpeed());
        assertEquals("Fan speed: 0", fan.getStatus());
    }

    @Test
    void testSetSpeedToValidValues() {
        fan.setSpeed(1);
        assertEquals(1, fan.getSpeed());

        fan.setSpeed(2);
        assertEquals(2, fan.getSpeed());

        fan.setSpeed(0); // should also be valid (off)
        assertEquals(0, fan.getSpeed());
    }

    @Test
    void testSetSpeedToInvalidValueDoesNotChangeSpeed() {
        fan.setSpeed(1);
        fan.setSpeed(5); // invalid
        assertEquals(1, fan.getSpeed());

        fan.setSpeed(-1); // invalid
        assertEquals(1, fan.getSpeed());
    }
}
