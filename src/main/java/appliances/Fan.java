package appliances;

public class Fan implements Appliance {
    private int speed = 0; // 0 = off, 1 = low, 2 = high

    @Override
    public void turnOn() {
        setSpeed(1);
    }

    @Override
    public void turnOff() {
        setSpeed(0);
    }

    public void setSpeed(int newSpeed) {
        if (newSpeed < 0 || newSpeed > 2) {
            System.out.println("Invalid speed. Use 0 (off), 1, or 2.");
        } else {
            speed = newSpeed;
            System.out.println("Fan speed set to " + speed + (speed == 0 ? " (off)" : ""));
        }
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String getStatus() {
        return "Fan speed: " + speed;
    }
}
